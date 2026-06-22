import java.util.Scanner;

class InterviewBot {
    String botName;
    String technology;

    InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    void conductInterview() {
        System.out.println(botName + " is conducting interview on " + technology);
        System.out.println("Question 1: Explain basics of " + technology);
        System.out.println("Question 2: What are advanced concepts in " + technology + "?");
        System.out.println("Question 3: Give a real world use case of " + technology);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        InterviewBot bot1 = new InterviewBot("JavaBot", "Java");
        InterviewBot bot2 = new InterviewBot("PyBot", "Python");
        InterviewBot bot3 = new InterviewBot("WebBot", "React");

        bot1.conductInterview();
        System.out.println();
        bot2.conductInterview();
        System.out.println();
        bot3.conductInterview();

        sc.close();
    }
}
