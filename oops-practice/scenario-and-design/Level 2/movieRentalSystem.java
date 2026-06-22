import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class Movie {
    int movieId;
    String name;
    double price;
    boolean rented;

    Movie(int movieId, String name, double price) {
        this.movieId = movieId;
        this.name = name;
        this.price = price;
        this.rented = false;
    }
}

class MovieRentalSystem {
    ArrayList<Movie> allMovies;
    HashMap<Integer, Movie> movieMap;
    ArrayList<Movie> rentedMovies;

    MovieRentalSystem() {
        allMovies = new ArrayList<>();
        movieMap = new HashMap<>();
        rentedMovies = new ArrayList<>();
    }

    void addMovie(int id, String name, double price) {
        Movie m = new Movie(id, name, price);
        allMovies.add(m);
        movieMap.put(id, m);
    }

    void rent(int movieId) {
        Movie m = movieMap.get(movieId);
        if (m != null && !m.rented) {
            m.rented = true;
            rentedMovies.add(m);
            System.out.println("Rented: " + m.name);
        } else {
            System.out.println("Movie not available or not found");
        }
    }

    void drop(int movieId) {
        Movie m = movieMap.get(movieId);
        if (m != null && m.rented) {
            m.rented = false;
            rentedMovies.remove(m);
            System.out.println("Returned: " + m.name);
        }
    }

    void searchAvailable(String name) {
        System.out.println("Available movies matching '" + name + "':");
        for (Movie m : allMovies) {
            if (!m.rented && m.name.toLowerCase().contains(name.toLowerCase())) {
                System.out.println("  ID: " + m.movieId + " | " + m.name + " | $" + m.price);
            }
        }
    }

    void reportRented() {
        System.out.println("Currently rented:");
        for (Movie m : rentedMovies) {
            System.out.println("  " + m.name + " ($" + m.price + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MovieRentalSystem system = new MovieRentalSystem();

        system.addMovie(1, "Inception", 10.0);
        system.addMovie(2, "Avengers", 12.0);
        system.addMovie(3, "Interstellar", 11.0);
        system.addMovie(4, "Inception 2", 15.0);

        system.searchAvailable("Inception");

        system.rent(1);
        system.rent(2);

        System.out.println();
        system.searchAvailable("Inception");

        System.out.println();
        system.reportRented();

        system.drop(1);
        System.out.println();
        system.searchAvailable("Inception");
        System.out.println();
        system.reportRented();

        sc.close();
    }
}
