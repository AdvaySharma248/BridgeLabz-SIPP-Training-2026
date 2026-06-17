public class OnlineQuizApplication {

    static String answers[] = {"A", "B", "C", "D"};

    static void checkAnswer(int index, String correctAnswer) {
        try {
            if (answers[index].equals(correctAnswer)) {
                System.out.println("Question " + (index + 1) + ": Correct");
            } else {
                System.out.println("Question " + (index + 1) + ": Wrong (answered: " + answers[index] + ")");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Question " + (index + 1) + ": No answer recorded (invalid index " + index + ")");
        } catch (NullPointerException e) {
            System.out.println("Question " + (index + 1) + ": Answer is null, cannot evaluate");
        }
    }

    public static void main(String[] args) {
        int indicesToCheck[] = {0, 1, 2, 3, 5};
        String correctAnswers[] = {"A", "C", "C", "D", "A"};

        for (int i = 0; i < indicesToCheck.length; i++) {
            checkAnswer(indicesToCheck[i], correctAnswers[i]);
        }

        System.out.println("Quiz evaluation completed.");
    }
}
