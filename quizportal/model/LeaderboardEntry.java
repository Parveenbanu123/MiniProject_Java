package quizportal.model;
 
public class LeaderboardEntry {
    private int userId;
    private String userName;
    private String email;
    private int score;
    private int rank;
 
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
 
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
 
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
 
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
 
    public int getRank() { return rank; }
    public void setRank(int rank) { this.rank = rank; }
}