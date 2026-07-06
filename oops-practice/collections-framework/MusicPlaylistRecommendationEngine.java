import java.util.LinkedList;
import java.util.List;

public class MusicPlaylistRecommendationEngine {
    private LinkedList<String> recentlyPlayed;
    private static final int MAX_SIZE = 10;

    public MusicPlaylistRecommendationEngine() {
        recentlyPlayed = new LinkedList<>();
    }

    public void playSong(String song) {
        recentlyPlayed.remove(song);
        recentlyPlayed.addFirst(song);
        if (recentlyPlayed.size() > MAX_SIZE) {
            recentlyPlayed.removeLast();
        }
        System.out.println("Played: " + song);
    }

    public boolean searchSong(String song) {
        return recentlyPlayed.contains(song);
    }

    public void displayPlaylist() {
        System.out.println("Recently played songs:");
        for (String song : recentlyPlayed) {
            System.out.println("- " + song);
        }
    }

    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine playlist = new MusicPlaylistRecommendationEngine();
        playlist.playSong("Song 1");
        playlist.playSong("Song 2");
        playlist.playSong("Song 3");
        playlist.playSong("Song 4");
        playlist.playSong("Song 5");
        playlist.playSong("Song 6");
        playlist.playSong("Song 7");
        playlist.playSong("Song 8");
        playlist.playSong("Song 9");
        playlist.playSong("Song 10");
        playlist.displayPlaylist();
        playlist.playSong("Song 11");
        playlist.displayPlaylist();
        boolean found = playlist.searchSong("Song 2");
        System.out.println("Is Song 2 in recently played? " + found);
    }
}
