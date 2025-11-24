import java.util.Scanner;

public class QuestionService {

    Question[] questions = new Question[5];
    String[] selection = new String[5];

    public QuestionService() {
        questions[0] = new Question(1, "What is the size of int?", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "What is the size of double?", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "What is the size of char?", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "What is the size of long?", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "What is the size of boolean?", "1", "2", "4", "8", "1");
    }

    public void playQuiz() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n JAVA QUIZ \n");
        
        // Ask if the user is ready to start the quiz
        System.out.print("Are you ready for the quiz? (y/n): ");
        String ready = sc.nextLine().toLowerCase();
        
        if (ready.equals("y")) {
            int i = 0;
            System.out.println("Enter the correct answer!");
            // Loop through questions and ask them one by one
            for (Question q : questions) {
                System.out.print("\nQuestion " + q.getId() + ":");
                System.out.println(q.getQuestion());
                System.out.println("1. " + q.getOpt1());
                System.out.println("2. " + q.getOpt2());
                System.out.println("3. " + q.getOpt3());
                System.out.println("4. " + q.getOpt4());
                
                // Get user's answer
                String userAnswer = sc.nextLine();
                selection[i] = userAnswer;
                
                // Provide feedback
                if (userAnswer.equals(q.getAnswer())) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong! The correct answer is: " + q.getAnswer());
                }
                i++;
            }
            
            // After all questions are done, print the score
            printScore();
        } else {
            System.out.println("Okay, maybe next time!");
        }
    }

    public void printScore() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            Question que = questions[i];
            String answer = que.getAnswer();
            String userAnswer = selection[i];
            if (answer.equals(userAnswer)) {
                score++;
            }
        }
        System.out.println("\nYour final score is: " + score + " out of " + questions.length);
    }
}
