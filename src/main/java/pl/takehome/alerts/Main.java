package pl.takehome.alerts;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlertRuleEngine engine = new AlertRuleEngine(List.of(
                new AlertRule(3, "LOW"),
                new AlertRule(5, "ADVISORY"),
                new AlertRule(7, "WARN")
        ));

        engine.alertsFor(1, 105).forEach(System.out::println);

        System.out.println("Value for 21: " + engine.alertFor(21));
        System.out.println("Value for 35: " + engine.alertFor(35));
        System.out.println("Value for 105: " + engine.alertFor(105));
    }
}
