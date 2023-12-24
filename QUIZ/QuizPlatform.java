import java.util.*;

public class QuizPlatform {
    String question;
    List<String> options;
    String correctAnswer;
    static List<QuizQuestions> Questions = new ArrayList<>();
    static QuizQuestions quiz;
    static Scanner input = new Scanner(System.in);

    public QuizPlatform() {
        question = "When does method overloading is determined?";
        options = Arrays.asList("At run time", "At compile time", "At coding time", "At execution time");
        correctAnswer = "At compile time";
        quiz = new QuizQuestions(question, options, correctAnswer);
        Questions.add(quiz);

        question = "What is the main purpose of the 'static' keyword in Java?";
        options = Arrays.asList("To create multiple instances of a class", "To call a method in the superclass",
                "To define a constant variable", "To access instance variables");
        correctAnswer = "To define a constant variable";
        quiz = new QuizQuestions(question, options, correctAnswer);
        Questions.add(quiz);

        question = "When does method overloading is determined?";
        options = Arrays.asList("At run time", "At compile time", "At coding time", "At execution time");
        correctAnswer = "At compile time";
        quiz = new QuizQuestions(question, options, correctAnswer);
        Questions.add(quiz);

        question = "What is the role of the 'interface' in Java?";
        options = Arrays.asList("To create an instance of a class", "To achieve multiple inheritance",
                "To define a constant variable", "To access instance variables");
        correctAnswer = "To achieve multiple inheritance";
        quiz = new QuizQuestions(question, options, correctAnswer);
        Questions.add(quiz);
    }

    static int flag = 1;

    public static void main(String[] args) {
        QuizPlatform quizObj = new QuizPlatform();

        int userChoice;
        int correctAnswer = 0, wrongAnswer = 0, i = 0;

        for (i = 0; i < Questions.size(); i++) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            flag = 1;
            System.out.println("\n\t\t\t" + Questions.get(i).question + "\n");
            for (int j = 0; j < Questions.get(i).options.size(); j++) {
                System.out.print(j + 1 + ". " + Questions.get(i).options.get(j) + "      ");
            }
            System.out.println();

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up! You didn't answer in time.");
                    System.out.println("Press 0 to Skipping to the next question...\n");
                    flag = 0;
                }
            };
            timer.schedule(task, 10000);

            System.out.print("Enter the correct option number: ");
            userChoice = input.nextInt();
            timer.cancel();

            if (flag == 0) {
                continue;
            }

            if (userChoice == Questions.get(i).getCorrectAnswer()) {
                System.out.println("Correct!\n");
                correctAnswer++;
            } else {
                System.out.println("Wrong!\n");
                wrongAnswer++;
            }

        }

        System.out.println("Total No. of Questions: " + i);
        System.out.println("Marks Scored: " + correctAnswer);
        System.out.println("Wrong Answers: " + (i - correctAnswer));
    }
}

class QuizQuestions {
    String question;
    List<String> options = new ArrayList<>();
    String correctAnswer;

    public QuizQuestions(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    int getCorrectAnswer() {
        return options.indexOf(correctAnswer) + 1;
    }
}
