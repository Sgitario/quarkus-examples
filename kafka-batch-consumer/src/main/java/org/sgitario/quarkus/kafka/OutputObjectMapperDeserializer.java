package org.sgitario.quarkus.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class OutputObjectMapperDeserializer extends ObjectMapperDeserializer<Output> {

  public OutputObjectMapperDeserializer() {
    super(Output.class);
  }
}
