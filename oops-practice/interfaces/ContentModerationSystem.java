package interfaces;

interface TextModeration {
    boolean checkOffensiveContent(String text);
    
    default void displayModerationPolicy() {
        System.out.println("Text Moderation Policy: No hate speech or offensive language allowed.");
    }

    // Requirement: static method containsRestrictedWords
    static boolean containsRestrictedWords(String post) {
        String[] restricted = {"badword1", "badword2", "offensive"};
        for (String word : restricted) {
            if (post.toLowerCase().contains(word)) return true;
        }
        return false;
    }
}

interface SpamDetection {
    boolean isSpam(String text);

    default void displayModerationPolicy() {
        System.out.println("Spam Detection Policy: No repetitive or unsolicited commercial content.");
    }
}

// Requirement: Implement both interfaces in ContentModerator
class ContentModerator implements TextModeration, SpamDetection {
    
    @Override
    public boolean checkOffensiveContent(String text) {
        // Use the static method from TextModeration
        return TextModeration.containsRestrictedWords(text);
    }

    @Override
    public boolean isSpam(String text) {
        // Simple beginner level check: if text contains "buy now" or is very short
        return text.toLowerCase().contains("buy now") || text.toLowerCase().contains("click here");
    }

    // Resolving conflict
    @Override
    public void displayModerationPolicy() {
        System.out.println("--- Unified Moderation Policy ---");
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }
}

public class ContentModerationSystem {
    public static void main(String[] args) {
        // Requirement: Store multiple posts in a String[]
        String[] posts = {
            "Hello everyone, have a nice day!",
            "This is a badword1 post, very offensive.",
            "BUY NOW for cheap prices! CLICK HERE!!!",
            "I love programming in Java.",
            "This post is offensive and also a spam click here"
        };

        ContentModerator moderator = new ContentModerator();
        moderator.displayModerationPolicy();

        System.out.println("\n--- Processing Posts ---");
        for (String post : posts) {
            boolean isOffensive = moderator.checkOffensiveContent(post);
            boolean isSpam = moderator.isSpam(post);

            System.out.println("Post: \"" + post + "\"");
            if (isOffensive && isSpam) {
                System.out.println("Result: REJECTED (Offensive & Spam)");
            } else if (isOffensive) {
                System.out.println("Result: REJECTED (Offensive Content)");
            } else if (isSpam) {
                System.out.println("Result: REJECTED (Spam Detected)");
            } else {
                System.out.println("Result: APPROVED (Valid Post)");
            }
            System.out.println("-------------------------");
        }
    }
}
