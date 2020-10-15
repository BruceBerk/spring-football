package com.berk.football;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class DiceRollerTests {
    @Test
    public void rollReturnsMapValues() {
        // Make sure we get the 4 expected dice roll values back and the values make sense

        DiceRoller diceRoller = new DiceRoller();
        Map<String, Integer> rollResult = diceRoller.roll();

        assertAll(
                () -> assertNotNull(rollResult),
                () -> assertEquals(4, rollResult.size()),
                () -> assertTrue(rollResult.containsKey("white")),
                () -> assertTrue(rollResult.containsKey("red1")),
                () -> assertTrue(rollResult.containsKey("red2")),
                () -> assertTrue(rollResult.containsKey("black")),
                () -> assertTrue(rollResult.get("white") >= 1),
                () -> assertTrue(rollResult.get("white") <= 6),
                () -> assertTrue(rollResult.get("red1") >= 1),
                () -> assertTrue(rollResult.get("red1") <= 6),
                () -> assertTrue(rollResult.get("red2") >= 1),
                () -> assertTrue(rollResult.get("red2") <= 6),
                () -> assertTrue(rollResult.get("black") >= 1),
                () -> assertTrue(rollResult.get("black") <= 3)
        );
    }
}
