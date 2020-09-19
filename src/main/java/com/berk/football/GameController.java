package com.berk.football;

/* A REST controller for the dice rolling */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/game")
public class GameController {
    private final Random randomGenerator = new Random();   // check if there should be a seed here

    @GetMapping("/roll")
    public List<String> roll() {
        List<String> dice = new ArrayList<>();
        int whiteDie = randomGenerator.nextInt(6) + 1;
        dice.add(Integer.toString(whiteDie));

        int redDie1 = randomGenerator.nextInt(6) + 1;
        dice.add(Integer.toString(redDie1));

        int redDie2 = randomGenerator.nextInt(6) + 1;
        dice.add(Integer.toString(redDie2));

        // black die: 3 sides are blank, 2 sides have "D" and 1 side has "X"
        int blackDie = randomGenerator.nextInt(6) + 1;
        if (blackDie < 4) {
            dice.add("_");
        } else if (blackDie < 6) {
            dice.add("D");
        } else {
            dice.add("X");
        }

        return(dice);
    }
}
