package pl.takehome.alerts;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void returnsExpectedOutputForValuesFromOneToTwenty() {
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

        assertEquals(expectedOutput, Main.alertsFor(1, 20));
    }
}
