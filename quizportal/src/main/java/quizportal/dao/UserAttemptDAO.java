package quizportal.dao;

import java.sql.*;
import java.util.*;
import quizportal.model.LeaderboardEntry;
import quizportal.model.UserAttempt;
import quizportal.util.DBConnection;

public class UserAttemptDAO {

	public List<LeaderboardEntry> getLeaderboardByQuiz(int quizId) {
		List<LeaderboardEntry> list = new ArrayList<>();

		String sql = "SELECT u.id, u.name, u.email, MAX(ua.score) AS score " + "FROM user_attempts ua "
				+ "JOIN users u ON ua.user_id = u.id " + "WHERE ua.quiz_id = ? " + "GROUP BY u.id, u.name, u.email "
				+ "ORDER BY score DESC, u.name ASC";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, quizId);
			ResultSet rs = ps.executeQuery();

			int rank = 1;
			while (rs.next()) {
				LeaderboardEntry e = new LeaderboardEntry();
				e.setUserId(rs.getInt("id"));
				e.setUserName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setScore(rs.getInt("score"));
				e.setRank(rank++);
				list.add(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<UserAttempt> getAttemptsByUser(int userId) {

		List<UserAttempt> list = new ArrayList<>();

		String sql = "SELECT id, quiz_id, score, total_questions, attempt_time " + "FROM user_attempts "
				+ "WHERE user_id = ? " + "ORDER BY attempt_time DESC";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserAttempt ua = new UserAttempt();
				ua.setId(rs.getInt("id"));
				ua.setQuizId(rs.getInt("quiz_id"));
				ua.setScore(rs.getInt("score"));
				ua.setTotalQuestions(rs.getInt("total_questions"));
				ua.setAttemptTime(rs.getTimestamp("attempt_time"));

				list.add(ua);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean saveAttempt(UserAttempt ua) {

		String sql = "INSERT INTO user_attempts (user_id, quiz_id, score, total_questions) " + "VALUES (?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, ua.getUserId());
			ps.setInt(2, ua.getQuizId());
			ps.setInt(3, ua.getScore());
			ps.setInt(4, ua.getTotalQuestions());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}