package com.berk.football;

/* A REST controller for the dice rolling */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/dice")
public class DiceController {
    private Random randomGenerator = new Random();
    private List<String> dice;

    public List<String> roll() {
        dice = new ArrayList<>();

    }
}
