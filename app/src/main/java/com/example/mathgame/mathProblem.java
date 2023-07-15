package com.example.mathgame;

import java.util.Random;

public class mathProblem {
    String answer;
    String operator;
    int numOne;
    int numTwo;

    public mathProblem(int bound) {
        //I imported the random class, so I can make a new random object called rand
        Random rand = new Random();

        //These will be the same regardless of problem type
        numOne = rand.nextInt(bound);
        numTwo = rand.nextInt(bound);

        //These next variables vary based on the type of problem
        int determinant = rand.nextInt(3);
        if (determinant == 0) {
            answer = String.valueOf(numOne * numTwo);
            operator = "*";
        } else if (determinant == 1) {
            answer = String.valueOf(numOne + numTwo);
            operator = "+";
        } else if (determinant == 2) {
            answer = String.valueOf(numOne - numTwo);
            operator = "-";
        }

    }
}

