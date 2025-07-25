package org.sgitario.quarkus.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import io.quarkus.test.junit.QuarkusTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestInstance(Lifecycle.PER_CLASS)
class BatchKafkaProcessorTest {

  private KafkaProducer<String, Input> producer;
  private KafkaConsumer<String, Output> consumer;

  private static final String INPUT_TOPIC = "batch-topic";
  private static final String OUTPUT_TOPIC = "processed-topic";

  @ConfigProperty(name = "kafka.bootstrap.servers")
  String bootstrapServers;

  @BeforeEach
  void setup() {
    Properties producerProps = new Properties();
    producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, InputObjectMapperSerializer.class.getName());

    producer = new KafkaProducer<>(producerProps);

    Properties consumerProps = new Properties();
    consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, OutputObjectMapperDeserializer.class.getName());
    consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
    consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    consumer = new KafkaConsumer<>(consumerProps);
    consumer.subscribe(Collections.singletonList(OUTPUT_TOPIC));
  }

  @AfterEach
  void teardown() {
    producer.close();
    consumer.close();
  }

  @Test
  @Timeout(value = 30, unit = TimeUnit.SECONDS)
  void testBatchProcessing() {
    // Send 100 Input messages as JSON
    IntStream.range(0, 100).forEach(i -> {
      Input input = new Input("id-" + i);
      producer.send(new ProducerRecord<>(INPUT_TOPIC, "key-" + i, input));
    });
    producer.flush();

    // Wait for processed messages
    List<Output> processedOutputs = new ArrayList<>();
    long deadline = System.currentTimeMillis() + 10_000;

    while (System.currentTimeMillis() < deadline && processedOutputs.size() < 100) {
      ConsumerRecords<String, Output> records = consumer.poll(Duration.ofMillis(500));
      for (ConsumerRecord<String, Output> record : records) {
        processedOutputs.add(record.value());
      }
    }

    assertEquals(100, processedOutputs.size());
    processedOutputs.forEach(output -> {
      assertTrue(output.getInput().getId().startsWith("id-"));
      assertTrue(output.getCapacity().startsWith("HIGH_CAPACITY_"));
      assertTrue(output.getCapacity().contains(output.getInput().getId()));
    });
  }
}
