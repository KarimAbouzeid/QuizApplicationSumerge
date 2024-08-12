import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import Exceptions.*;

public class Quiz {

    private ArrayList<Question> questionsBank;
    private ArrayList<Integer> questions;
    private int score;
    private int total;
    private int prevQ;

    public Quiz() {
        questionsBank = new ArrayList<Question>();
        questions     = new ArrayList<Integer>();
        score = 0;
        total = 0;
    }

    public ArrayList<Integer> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Integer> questions) {
        this.questions = questions;
    }

    public int getTotal() {
        return total;
    }

    public void addQuestion(String questionText, String[] possibleAnswers, int correctAnswer) throws InvalidQuestionException{
        if(questionText.isEmpty() || possibleAnswers.length != 4 || correctAnswer < 1 || correctAnswer > 4){
            System.out.println("HERE????");
            throw new InvalidQuestionException("Invalid question");
        }
        HashSet<String> hs = new HashSet<>();
        for(String answer: possibleAnswers){
            if (answer.isEmpty() || hs.contains(answer))
                throw new InvalidQuestionException("Invalid question");
            hs.add(answer);
        }
        Question q = new Question(questionText, possibleAnswers, correctAnswer);
        questionsBank.add(q);
    }

    public void createQuiz() throws InterruptedException {
        score = 0;
        questions = new ArrayList<>();
        Random rand = new Random();
        total = Math.min(questionsBank.size(), 5);
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < total; i++){
            int index = rand.nextInt(questionsBank.size());
            while (hs.contains(index))
                index = rand.nextInt(questionsBank.size());
            hs.add(index);
            questions.add(index);
        }
        System.out.println("This is the beginning of the quiz. Please type the number of your answer after each question. Goodluck :)");
        Thread.sleep(3000);
    }
    public void displayQuestion(int j){
        Question q = questionsBank.get(j);
        System.out.println(q.getQuestionText());
        for(int i = 1; i < 5; i++){
            System.out.print(i + ". ");
            System.out.println(q.getPossibleAnswers()[i - 1]);
        }
        prevQ = j;
    }

    public void calculateScore(String answerString){
        int answer = Integer.parseInt(answerString);
        Question q = questionsBank.get(prevQ) ;
        if(q.getCorrectAnswer() == answer)
            score += 1;
    }

    public void endOfQuiz(){
        StringBuilder sb = new StringBuilder();
        sb.append("You got ").append(score).append("/").append(total);
        System.out.println(sb.toString());
        if(score >= Math.floorDiv(total,2))
            System.out.println("Congratulations, you passed the test :)");
        else
            System.out.println("Unfortunately, you didn't pass the test :( Try again later");
    }

}
