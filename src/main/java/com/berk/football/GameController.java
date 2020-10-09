package com.berk.football;

/* A REST controller for the dice rolling */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping()
public class GameController {
    private final Random randomGenerator = new Random();   // check if there should be a seed here

    private static final Map<String, Integer> diceMap = new HashMap<>();

    @GetMapping("/roll")
    public Map<String, Integer> roll() {

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
