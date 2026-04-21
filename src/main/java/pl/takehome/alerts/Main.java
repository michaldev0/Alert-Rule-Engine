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
    }
}