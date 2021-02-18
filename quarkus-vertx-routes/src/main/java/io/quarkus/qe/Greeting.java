package io.quarkus.qe;

import org.hibernate.validator.constraints.Length;

public class Greeting {

    private String name;
    private String welcome;

    public Greeting(String name, String welcome) {
        this.name = name;
        this.welcome = welcome;
    }

    @Length(min = 4)
    public String getName() {
        return name;
    }

    @Length(min = 4)
    public String getWelcome() {
        return welcome;
    }
}