public class Question {

    private String questionText;
    private String[] possibleAnswers;
    private int correctAnswer;

    public Question(String questionText, String[] possibleAnswers, int correctAnswer) {
        this.questionText = questionText;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(String[] possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
