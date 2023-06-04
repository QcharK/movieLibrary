package org.example.handlers;
import org.example.models.Actor;
import org.example.models.Director;
import org.example.models.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieLiblary {

    private static List<Movie> movieLibrary;
    public void fillMovieLisy() {
        movieLibrary = new ArrayList<>();
        Director ridleySct = new Director("Ridley", "Scot");
        Director g_Verbinski = new Director("Gore", "Verbinski");
        Director q_Tarantino = new Director("Quentin", "Tarantino");
        Director p_Jackson = new Director("Peter", "Jackson");

        Actor raselCrow = new Actor("Rasel", "Crow");
        Actor oliwerRead = new Actor("Oliwer", "Read");
        Actor djacob = new Actor("Darek", "Jacob");
        Actor j_Deep = new Actor("Johnny", "Deep");
        Actor o_Bloom = new Actor("Orlando", "Bloom");
        Actor k_Knightley = new Actor("Keira", "Knightley");
        Actor j_Travolta = new Actor("John", "Travolta");
        Actor u_Thurman = new Actor("Uma", "Thurman");
        Actor h_Keitel = new Actor("Harvey", "Keitel");
        Actor t_Cruze = new Actor("Tom", "Cruise");

        movieLibrary.add(new Movie("Gladiator", ridleySct, List.of(raselCrow, oliwerRead, j_Deep)));
        movieLibrary.add(new Movie("Pirates of the Caribbean", g_Verbinski, List.of(oliwerRead, j_Deep)));
        movieLibrary.add(new Movie("Pulp Fiction", q_Tarantino, List.of(j_Travolta, u_Thurman)));
        movieLibrary.add(new Movie("Hobbit - An Unexpected Jorney", ridleySct, List.of(k_Knightley, djacob)));
        movieLibrary.add(new Movie("Poranek Kojota", p_Jackson, List.of(raselCrow, o_Bloom)));
        movieLibrary.add(new Movie("Transformers", q_Tarantino, List.of(raselCrow, djacob)));
        movieLibrary.add(new Movie("Top Gun", ridleySct, List.of(raselCrow, t_Cruze)));
        movieLibrary.add(new Movie("Desperado", ridleySct, List.of(raselCrow, o_Bloom)));
        movieLibrary.add(new Movie("Mission Impossible", p_Jackson, List.of(raselCrow, t_Cruze)));
        movieLibrary.add(new Movie("Forest Gump", g_Verbinski, List.of(oliwerRead, h_Keitel)));
    }

    public static List<Movie> getMovieLibrary() {
        return movieLibrary;
    }

    public void getRandomMovieInformation() {
        System.out.println(movieLibrary.get(RandomDataHandler.getRandomMovieIndex()));
    }

    public void printActorFilmography() {
        Actor actor = UserInputHandler.getActorFromUser();
        var actorMovieList = getActorMovieList(actor);
        if (actorMovieList.isEmpty()) {
            System.out.println("Actor dodn'y play in any movies fromlibrary");
        } else {
            System.out.println("Actor " + actor + " have palyed ijn folowing movies");
            for (String movie : actorMovieList) {
                System.out.println(movie);
            }
        }
    }

    private List<String> getActorMovieList(Actor actorToFind) {
        Predicate<Movie> moviePredicate = movie ->  movie.getListOfActors().stream()
                .anyMatch(actor -> actor.getFirstName().equals(actorToFind.getFirstName()) &&
                        actor.getLastName().equals(actorToFind.getLastName()));
        return movieLibrary.stream()
                .filter(moviePredicate)
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }
}

