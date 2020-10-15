package com.berk.football;

import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DiceRoller {
    private static final Random randomGenerator = new Random();

    private static final Map<String, Integer> diceMap = new HashMap<>();

    public static Map<String, Integer> roll() {

        int whiteDie = randomGenerator.nextInt(6) + 1;
        diceMap.put("white", whiteDie);

        int redDie1 = randomGenerator.nextInt(6) + 1;
        diceMap.put("red1", redDie1);

        int redDie2 = randomGenerator.nextInt(6) + 1;
        diceMap.put("red2", redDie2);

        // black die: 3 sides are blank, 2 sides have "D" and 1 side has "X"
        int blackDie = randomGenerator.nextInt(6) + 1;
        if (blackDie == 4) {
            diceMap.put("black", 2);
        } else if (blackDie >= 5) {
            diceMap.put("black", 3);
        } else {
            diceMap.put("black", blackDie);
        }
        return diceMap;
    }
}
