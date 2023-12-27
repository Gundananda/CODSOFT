import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    String[] options;
    int correctAnswer;

    public QuizQuestion(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class Task4{
    private static int score = 0;
    private static Timer questionTimer;

    public static void main(String[] args) {
        QuizQuestion[] quiz = {
            new QuizQuestion("What is the capital of India?", new String[]{"1) London", "2) Paris", "3) Mumbai", "4) New Delhi"}, 4),
            new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"1) Venus", "2) Mars", "3) Jupiter", "4) Saturn"}, 2)
        };

        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : quiz) {
            startQuestionTimer(10); 
            System.out.println(question.getQuestion());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Enter your choice: ");
            int userAnswer = getUserInputWithTimer(scanner);

            if (userAnswer == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            questionTimer.cancel(); 
        }

        System.out.println("Quiz completed. Your score is: " + score + "/" + quiz.length);
        scanner.close();
    }

    private static void startQuestionTimer(int seconds) {
        questionTimer = new Timer();
        questionTimer.schedule(new TimerTask() {
            public void run() {
                System.out.println("Time's up!");
                System.exit(0); 
            }
        }, seconds * 1000);
    }

    private static int getUserInputWithTimer(Scanner scanner) {
        while (true) {
            int userAnswer;
            try {
                userAnswer = scanner.nextInt();
                scanner.nextLine(); 
                return userAnswer;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
    }
}