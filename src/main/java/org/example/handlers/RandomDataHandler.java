package org.example.handlers;

import java.util.Random;

public class RandomDataHandler {

    private static Random random = new Random();
    public static int getRandomMovieIndex(){
        return random.nextInt(MovieLiblary.getMovieLibrary().size());
    }

}
