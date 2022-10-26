package acme;

public final class ComputedHeader {

    public static String get() {
        return "From " + ComputedHeader.class.getName();
    }

}
