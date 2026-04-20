package pl.takehome.alerts;

public record AlertRule(int divisor, String label) {
    public boolean isDivisibleBy(int value) {
        return value % divisor == 0;
    }
}

