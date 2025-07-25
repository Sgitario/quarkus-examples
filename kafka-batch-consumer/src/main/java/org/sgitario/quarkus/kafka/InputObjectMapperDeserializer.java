package org.sgitario.quarkus.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class InputObjectMapperDeserializer extends ObjectMapperDeserializer<Input> {

  public InputObjectMapperDeserializer() {
    super(Input.class);
  }
}
