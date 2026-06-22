import java.util.Scanner;
import java.util.ArrayList;

class BrowserHistory {
    ArrayList<String> history;
    int current;

    BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        current = 0;
    }

    void visit(String url) {
        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        current++;
    }

    String back(int steps) {
        current = current - steps;
        if (current < 0) {
            current = 0;
        }
        return history.get(current);
    }

    String forward(int steps) {
        current = current + steps;
        if (current >= history.size()) {
            current = history.size() - 1;
        }
        return history.get(current);
    }

    void display() {
        System.out.print("History: [");
        for (int i = 0; i < history.size(); i++) {
            System.out.print(history.get(i));
            if (i < history.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Current: " + history.get(current));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BrowserHistory bh = new BrowserHistory("google.com");

        bh.visit("facebook.com");
        bh.visit("youtube.com");
        bh.visit("github.com");
        bh.display();

        System.out.println("Back 2: " + bh.back(2));
        bh.display();

        System.out.println("Forward 1: " + bh.forward(1));
        bh.display();

        bh.visit("stackoverflow.com");
        bh.display();

        System.out.println("Back 5: " + bh.back(5));

        sc.close();
    }
}
