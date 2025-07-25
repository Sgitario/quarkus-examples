package org.sgitario.quarkus.kafka;

public class Output {
    public Input input;
    public String capacity;

    public Output() {
    }

    public Output(Input input, String capacity) {
        this.input = input;
        this.capacity = capacity;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
} 