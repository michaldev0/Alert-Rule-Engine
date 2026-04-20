package pl.takehome.alerts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static String alertFor(int value) {
        if (value % 15 == 0) {
            return "LOWADVISORY";
        }

        if (value % 3 == 0) {
            return "LOW";
        }

        if (value % 5 == 0) {
            return "ADVISORY";
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