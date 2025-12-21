package quizportal.dao;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
import quizportal.model.Question;
import quizportal.util.DBConnection;
 
public class QuestionDAO {
 
    public boolean addQuestion(Question q) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO questions(quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";
 
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, q.getQuizId());
            pst.setString(2, q.getQuestionText());
            pst.setString(3, q.getOptionA());
            pst.setString(4, q.getOptionB());
            pst.setString(5, q.getOptionC());
            pst.setString(6, q.getOptionD());
            pst.setString(7, q.getCorrectOption());
 
            return pst.executeUpdate() > 0;
 
        } catch (Exception e) {
            System.out.println("Add Question Error: " + e.getMessage());
        }
        return false;
    }
 
    public List<Question> getQuestionsByQuizId(int quizId) {
        List<Question> list = new ArrayList<>();
 
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM questions WHERE quiz_id=?";
 
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, quizId);
 
            ResultSet rs = pst.executeQuery();
 
            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setQuizId(rs.getInt("quiz_id"));
                q.setQuestionText(rs.getString("question_text"));
                q.setOptionA(rs.getString("option_a"));
                q.setOptionB(rs.getString("option_b"));
                q.setOptionC(rs.getString("option_c"));
                q.setOptionD(rs.getString("option_d"));
                q.setCorrectOption(rs.getString("correct_option"));
                list.add(q);
            }
 
        } catch (Exception e) {
            System.out.println("Get Questions Error: " + e.getMessage());
        }
 
        return list;
    }
 
    public Question getQuestionById(int id) {
        Question q = null;
 
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM questions WHERE id=?";
 
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
 
            ResultSet rs = pst.executeQuery();
 
            if (rs.next()) {
                q = new Question();
                q.setId(rs.getInt("id"));
                q.setQuizId(rs.getInt("quiz_id"));
                q.setQuestionText(rs.getString("question_text"));
                q.setOptionA(rs.getString("option_a"));
                q.setOptionB(rs.getString("option_b"));
                q.setOptionC(rs.getString("option_c"));
                q.setOptionD(rs.getString("option_d"));
                q.setCorrectOption(rs.getString("correct_option"));
            }
 
        } catch (Exception e) {
            System.out.println("Get Question Error: " + e.getMessage());
        }
 
        return q;
    }
 
    public boolean updateQuestion(Question q) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE questions SET question_text=?, option_a=?, option_b=?, option_c=?, option_d=?, correct_option=? WHERE id=?";
 
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, q.getQuestionText());
            pst.setString(2, q.getOptionA());
            pst.setString(3, q.getOptionB());
            pst.setString(4, q.getOptionC());
            pst.setString(5, q.getOptionD());
            pst.setString(6, q.getCorrectOption());
            pst.setInt(7, q.getId());
 
            return pst.executeUpdate() > 0;
 
        } catch (Exception e) {
            System.out.println("Update Question Error: " + e.getMessage());
        }
        return false;
    }
 
    public boolean deleteQuestion(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM questions WHERE id=?";
 
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
 
            return pst.executeUpdate() > 0;
 
        } catch (Exception e) {
            System.out.println("Delete Question Error: " + e.getMessage());
        }
        return false;
    }
}