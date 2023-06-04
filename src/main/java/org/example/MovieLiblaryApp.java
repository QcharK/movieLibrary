package org.example;


import org.example.handlers.MenuHandlers;
import org.example.handlers.MovieLiblary;
import org.example.handlers.UserInputHandler;

public class MovieLiblaryApp {
    public static void main(String[] args) {

        //ładowanie biblioteki fimów
        MovieLiblary movieLiblary = new MovieLiblary();
        movieLiblary.fillMovieLisy();

        while(true){
            MenuHandlers.print();

            switch (UserInputHandler.getMenuOptionFromUser()){
                case DISPLAY_INFORMATION_ABOUT_RANDOM_MOVIE:
                    movieLiblary.getRandomMovieInformation();
                    break;
                case DISPALY_ALL_MOVIES_FOR_SELECTED_ACTOR:
                    movieLiblary.printActorFilmography();
                    break;
                case QUIT:
                    System.out.println("\nThank you. Bye");
                    System.exit(1);

            }
        }

    }
    }