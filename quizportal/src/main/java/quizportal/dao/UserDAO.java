package quizportal.dao;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
import quizportal.model.User;
import quizportal.util.DBConnection;
 
public class UserDAO {
 
    // ------------------- USER LOGIN -------------------
    public User validateUser(String email, String password) {
        User user = null;
 
        try (Connection conn = DBConnection.getConnection()) {
 
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return user;
    }
 
    // ------------------- USER REGISTRATION -------------------
    public boolean registerUser(User user) {
        boolean result = false;
 
        try (Connection conn = DBConnection.getConnection()) {
 
            String sql = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
 
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
 
            int rows = ps.executeUpdate();
            if (rows > 0)
                result = true;
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return result;
    }
 
    // ------------------- CHECK EMAIL EXISTS -------------------
    public boolean emailExists(String email) {
        try (Connection conn = DBConnection.getConnection()) {
 
            String sql = "SELECT id FROM users WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
 
            ResultSet rs = ps.executeQuery();
            return rs.next();
 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
 
    // ------------------- GET ALL USERS -------------------
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
 
        try (Connection conn = DBConnection.getConnection()) {
 
            String sql = "SELECT * FROM users";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
 
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                list.add(u);
            }
 
        } catch (Exception e) {
            System.out.println("Error fetching user list: " + e.getMessage());
        }
 
        return list;
    }
}