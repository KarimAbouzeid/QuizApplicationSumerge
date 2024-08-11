import Exceptions.InvalidQuestionException;

import java.util.Scanner;

public class QuizApplication {

    private Users users;
    private Quiz quiz;
    private static Scanner sc = new Scanner(System.in);


    public QuizApplication() {
        users = new Users();
        quiz = new Quiz();
    }


    public void register(String s, String p){
        if(!users.isRegistered(s)){
            users.createUser(s, p);
        } else {
            while (!users.isAuth(s, p)){
                System.out.println("Wrong password! Try the password again");
                p = sc.nextLine();
            }
        }
    }

    public void adminMode() {
        System.out.println("Please enter the question");
        String questionText = sc.nextLine();
        System.out.println("Please enter 4 choices each in a line");
        String a = sc.nextLine();
        String b = sc.nextLine();
        String c = sc.nextLine();
        String d = sc.nextLine();
        System.out.println("Please enter the number of the correct answer");
        String answerNo = sc.nextLine();
        int ans = Integer.parseInt(answerNo);
        String[] possibleAnswers = new String[]{a, b, c, d};
        try{
            quiz.addQuestion(questionText, possibleAnswers, ans);
            System.out.println("Question added successfully!");
        }catch (InvalidQuestionException e){
            System.out.println(e.getMessage());
        }
    }

    public void userMode() throws InterruptedException {
        System.out.println("Please enter your name and password");
        String user = sc.nextLine();
        String password = sc.nextLine();
        this.register(user, password);
        this.quiz.createQuiz();
        for(int i = 0; i < quiz.getQuestions().size(); i++){
            StringBuilder sb = new StringBuilder();
            int question = quiz.getQuestions().get(i);
            sb.append("Question ").append(i).append(" out of ").append(quiz.getTotal());
            System.out.println(sb.toString());
            quiz.displayQuestion(question);
            String answer = sc.nextLine();
            quiz.calculateScore(answer);
        }
        quiz.endOfQuiz();


    }

    public static void main(String[] args) throws InterruptedException {
        QuizApplication application = new QuizApplication();
        System.out.println("Welcome to my humble creation :)");
        while (true) {
            System.out.println("Please select 1/userMode 2/adminMode");
            String mode = sc.nextLine();
            if(mode.equals("2")){
                application.adminMode();
            } else if(mode.equals("1")){
                application.userMode();
                Thread.sleep(5000);
            }
        }
    }
}
