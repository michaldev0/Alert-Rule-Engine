package pl.takehome.alerts;

import java.util.List;
import java.util.stream.IntStream;

public class AlertRuleEngine {
    private final List<AlertRule> rules;

    public AlertRuleEngine(List<AlertRule> rules) {
        this.rules = List.copyOf(rules);
    }

    public String alertFor(int value) {
        StringBuilder alert = new StringBuilder();

        for (AlertRule rule : rules) {
            if (rule.isDivisibleBy(value)) {
                alert.append(rule.label());
            }
        }

        if (!alert.isEmpty()) {
            return alert.toString();
        }

        return String.valueOf(value);
    }

    public List<String> alertsFor(int startInclusive, int endInclusive) {
        return IntStream.rangeClosed(startInclusive, endInclusive)
                .mapToObj(this::alertFor)
                .toList();
    }
}
