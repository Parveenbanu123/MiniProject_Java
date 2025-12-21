package quizportal.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import quizportal.model.Admin;
import quizportal.util.DBConnection;
 
public class AdminDAO {
 
    public Admin login(String username, String password) {
        Admin admin = null;
 
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
 
            ResultSet rs = pst.executeQuery();
 
            if (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
 
        } catch (Exception e) {
            System.out.println("Admin Login Error: " + e.getMessage());
        }
 
        return admin;
    }
}