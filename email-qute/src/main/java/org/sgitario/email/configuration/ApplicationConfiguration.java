package org.sgitario.email.configuration;

import io.smallrye.config.ConfigMapping;

import java.util.Map;

@ConfigMapping(prefix = "app")
public interface ApplicationConfiguration {
    String to();
    Map<String, ReportConfiguration> reports();
}
