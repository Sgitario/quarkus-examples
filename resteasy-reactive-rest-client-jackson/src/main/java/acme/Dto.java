package acme;

import java.util.Objects;

public class Dto {
    public String name;
    public String value;

    public Dto(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Dto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Dto dto = (Dto) o;
        return Objects.equals(name, dto.name) && Objects.equals(value, dto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
