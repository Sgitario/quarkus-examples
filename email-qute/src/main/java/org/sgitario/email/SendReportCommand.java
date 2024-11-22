package org.sgitario.email;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.qute.Engine;
import io.quarkus.qute.Template;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;
import jakarta.transaction.Transactional;
import org.hibernate.jpa.HibernateHints;
import org.hibernate.query.Query;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvFormat;
import org.sgitario.email.configuration.ReportConfiguration;
import org.sgitario.email.configuration.ApplicationConfiguration;
import org.sgitario.email.model.Report;
import picocli.CommandLine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CommandLine.Command
public class SendReportCommand implements Runnable {

    @CommandLine.Option(names = {"-r", "--report"}, description = "The report to send", required = true)
    String reportName;

    @Inject
    Engine engine;
    @Inject
    ApplicationConfiguration applicationConfig;
    @Inject
    EntityManager em;
    @Inject
    Mailer mailer;

    @Override
    public void run() {
        Template template = loadTemplate();
        ReportConfiguration reportConfiguration = loadConfiguration();
        Report report = generateReport(reportConfiguration);
        if (report.hasData()) {
            mailer.send(Mail.withText(applicationConfig.to(), reportConfiguration.subject(),
                            template.render(report))
                    .addAttachment(reportName + "_" + LocalDate.now() + ".csv",
                            report.attachedFile(), "text/csv"));
        } else {
            System.out.println("No data was found for report '" + reportName + "'. Skipping email.");
        }

    }

    @SuppressWarnings("unchecked")
    @Transactional
    Report generateReport(ReportConfiguration reportConfiguration) {
        Query<Tuple> query = (Query<Tuple>) em.createNativeQuery(reportConfiguration.query(), Tuple.class)
                .setHint(HibernateHints.HINT_FETCH_SIZE, "1000");
        AtomicLong items = new AtomicLong(0);
        List<String> headers = new ArrayList<>();
        File file = createFile();
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath());
             Stream<Tuple> stream = query.getResultStream()) {
            stream.forEach(row -> {
                List<TupleElement<?>> elements = row.getElements();

                // populate headers
                if (headers.isEmpty()) {
                    for (TupleElement<?> element : elements) {
                        headers.add(element.getAlias());
                    }

                    writeLine(writer, headers);
                }

                List<String> line = new ArrayList<>();
                // process row
                for (String header : headers) {
                    line.add(Optional.ofNullable(row.get(header)).map(Object::toString).orElse(""));
                }
                writeLine(writer, line);
                items.incrementAndGet();
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return new Report(items.get() > 0, file);
    }

    private File createFile() {
        try {
            return File.createTempFile("report", ".csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLine(BufferedWriter writer, List<String> data) {
        try {
            writer.write(String.join(",", data) + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ReportConfiguration loadConfiguration() {
        ReportConfiguration reportConfiguration = applicationConfig.reports().get(reportName);
        if (reportConfiguration == null) {
            throw new RuntimeException("Configuration for report '" + reportName + "' not found in configuration. " +
                    "Missing properties: 'app.reports." + reportName + "'.*");
        }

        return reportConfiguration;
    }

    private Template loadTemplate() {
        Template template = engine.getTemplate(reportName);
        if (template == null) {
            throw new RuntimeException("Template '" + reportName + "' " +
                    "not found at 'src/main/resources/templates/" + reportName + ".html'");
        }

        return template;
    }
}
