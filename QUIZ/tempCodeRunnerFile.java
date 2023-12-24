import java.util.*;

public class QuizPlatform {
    String question;
    List<String> options;
    String correctAnswer;
    static List<QuizQuestions> questionsList = new ArrayList<>();
    static QuizQuestions currentQuestion;
    static Scanner scanner = new Scanner(System.in);

    // Let's set up some quiz questions
    public QuizPlatform() {
        // Question 1
        question = "When do you think Java figures out method overloading?";
        options = Arrays.asList("During the actual running of the program (runtime)", "While you're writing the code (compile time)", "Right when you start coding", "When the code is executed");
        correctAnswer = "While you're writing the code (compile time)";
        currentQuestion = new QuizQuestions(question, options, correctAnswer);
        questionsList.add(currentQuestion);

        // Question 2
        question = "Why do you think Java has the 'static' keyword?";
        options = Arrays.asList("To make lots of copies of a class", "To call a method in the parent class", "To define a constant value", "To get to instance variables");
        correctAnswer = "To define a constant value";
        currentQuestion = new QuizQuestions(question, options, correctAnswer);
        questionsList.add(currentQuestion);

        // Question 3
        question = "When is method overloading determined in Java?";
        options = Arrays.asList("During the actual running of the program (runtime)", "While you're writing the code (compile time)", "Right when you start coding", "When the code is executed");
        correctAnswer = "While you're writing the code (compile time)";
        currentQuestion = aQuizQuestions(question, options, correctAnswer);
        questionsList.add(currentQuestion);

        // Question 4
        question = "What do you think the 'interface' does in Java?";
        options = Arrays.asList("Helps you create an instance of a class", "Lets you do multiple things at once", "Defines a constant value", "Gives you access to instance variables");
        correctAnswer = "Lets you do multiple things at once";
        currentQuestion = new QuizQuestions(question, options, correctAnswer);
        questionsList.add(currentQuestion);
    }

    public static void main(String[] args) {
        QuizPlatform quiz = new QuizPlatform();

        int userChoice;
        int correctAnswers = 0, wrongAnswers = 0;

        for (int i = 0; i < questionsList.size(); i++) {
            System.out.println("Here's a question for you: " + questionsList.get(i).question + "\n");
            displayOptions(questionsList.get(i).options);

            // Let's give you 10 seconds to think...
            boolean isAnswered = false;
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.\n");
                    isAnswered = true;
                }
            };
            timer.schedule(task, 10000); // 10 seconds timer

            while (!isAnswered) {
                System.out.print("Enter the number of your choice: ");
                if (scanner.hasNextInt()) {
                    userChoice = scanner.nextInt();
                    isAnswered = true; // Break the loop if the user provides an answer
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            timer.cancel(); // Cancel the timer as the user has answered

            if (userChoice == questionsList.get(i).getCorrectAnswer()) {
                System.out.println("Correct! Great job!\n");
                correctAnswers++;
            } else {
                System.out.println("Oops, that's not quite right. The correct answer is: " + questionsList.get(i).correctAnswer + "\n");
                wrongAnswers++;
            }
        }

        // Alright, let's see how you did in the quiz!
        System.out.println("You've completed the quiz!");
        System.out.println("Total questions: " + questionsList.size());
        System.out.println("Correct answers: " + correctAnswers);
        System.out.println("Incorrect answers: " + wrongAnswers);
    }

    private static void displayOptions(List<String> options) {
        for (int j = 0; j < options.size(); j++) {
            System.out.println((j + 1) + ". " + options.get(j));
        }
        System.out.println();
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
