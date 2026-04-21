package pl.takehome.alerts;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlertRuleEngineTest {
    @Test
    void supportsAnyNumberOfRules() {
        AlertRuleEngine engine = new AlertRuleEngine(List.of(
                new AlertRule(2, "EVEN"),
                new AlertRule(3, "LOW"),
                new AlertRule(5, "ADVISORY")
        ));

        assertEquals("EVENLOW", engine.alertFor(6));
        assertEquals("EVENADVISORY", engine.alertFor(10));
        assertEquals("EVENLOWADVISORY", engine.alertFor(30));
    }

    @Test
    void combinesLabelsInRuleOrder() {
        AlertRuleEngine engine = new AlertRuleEngine(List.of(
                new AlertRule(5, "ADVISORY"),
                new AlertRule(3, "LOW")
        ));

        assertEquals("ADVISORYLOW", engine.alertFor(15));
    }

    @Test
    void supportsWarnRuleFromStageFour() {
        AlertRuleEngine engine = new AlertRuleEngine(List.of(
                new AlertRule(3, "LOW"),
                new AlertRule(5, "ADVISORY"),
                new AlertRule(7, "WARN")
        ));

        assertEquals("LOWWARN", engine.alertFor(21));
        assertEquals("ADVISORYWARN", engine.alertFor(35));
        assertEquals("LOWADVISORYWARN", engine.alertFor(105));
    }

    @Test
    void returnsExpectedOutputForValuesFromOneToTwenty() {
        AlertRuleEngine engine = new AlertRuleEngine(List.of(
                new AlertRule(3, "LOW"),
                new AlertRule(5, "ADVISORY")
        ));

        List<String> expectedOutput = List.of(
                "1",
                "2",
                "LOW",
                "4",
                "ADVISORY",
                "LOW",
                "7",
                "8",
                "LOW",
                "ADVISORY",
                "11",
                "LOW",
                "13",
                "14",
                "LOWADVISORY",
                "16",
                "17",
                "LOW",
                "19",
                "ADVISORY"
        );

        assertEquals(expectedOutput, engine.alertsFor(1, 20));
    }
}
