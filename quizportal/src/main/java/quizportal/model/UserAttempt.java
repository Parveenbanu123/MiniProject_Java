package quizportal.model;
 
import java.sql.Timestamp;
 
public class UserAttempt {
    private int id;
    private int userId;
    private int quizId;
    private int score;
    private int totalQuestions;
    private Timestamp attemptTime;
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
 
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
 
    public int getQuizId() {
        return quizId;
    }
    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
 
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
 
    public int getTotalQuestions() {
        return totalQuestions;
    }
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
 
    public Timestamp getAttemptTime() {
        return attemptTime;
    }
    public void setAttemptTime(Timestamp attemptTime) {
        this.attemptTime = attemptTime;
    }
}
 