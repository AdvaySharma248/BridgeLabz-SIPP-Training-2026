package interfaces;

interface StreamingService {
    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("Streaming Service: Monthly subscription is $12.99");
    }
}

interface GamingService {
    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("Gaming Service: Monthly subscription is $14.99");
    }
}

// Requirement: Class SmartTV implementing both interfaces
class SmartTV implements StreamingService, GamingService {
    
    // Requirement: Resolve the default method conflict
    @Override
    public void showSubscriptionDetails() {
        System.out.println("--- Smart TV Subscription Info ---");
        // We can call specific interface default methods using InterfaceName.super
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
        System.out.println("Combo Pack: Both for $20.00");
    }

    @Override
    public void streamMovie(String movieName) {
        System.out.println("Streaming Movie: " + movieName);
    }

    @Override
    public void playGame(String gameName) {
        System.out.println("Launching Game: " + gameName);
    }

    public void displayContent(String[] movies, String[] games) {
        System.out.println("\n--- Available Content ---");
        System.out.println("Movies:");
        for (String m : movies) System.out.println("- " + m);
        
        System.out.println("\nGames:");
        for (String g : games) System.out.println("- " + g);
    }
}

public class SmartTVSystem {
    public static void main(String[] args) {
        SmartTV myTV = new SmartTV();

        // Requirement: Store movie names and game names in separate arrays
        String[] movies = {"Inception", "Interstellar", "The Dark Knight"};
        String[] games = {"FIFA 24", "Spider-Man", "God of War"};

        // Resolving conflict and showing details
        myTV.showSubscriptionDetails();

        // Displaying content
        myTV.displayContent(movies, games);

        // Performing actions
        System.out.println("\n--- TV Actions ---");
        myTV.streamMovie(movies[0]);
        myTV.playGame(games[1]);
    }
}
