package pl.takehome.alerts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static String alertFor(int value) {
        StringBuilder alert = new StringBuilder();

        if (value % 3 == 0) {
            alert.append("LOW");
        }

        if (value % 5 == 0) {
            alert.append("ADVISORY");
        }

        if (!alert.isEmpty()) {
            return alert.toString();
        }

        return String.valueOf(value);
    }

    public static List<String> alertsFor(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(Main::alertFor)
                .toList();
    }

    public static void main(String[] args) {
        alertsFor(1, 20).forEach(System.out::println);
    }
}