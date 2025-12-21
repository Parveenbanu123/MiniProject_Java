package quizportal.servlet.user;
 
import quizportal.dao.UserAttemptDAO;
import quizportal.model.UserAttempt;
 
import quizportal.model.LeaderboardEntry;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
 
@WebServlet("/result")
public class ResultViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int quizId = Integer.parseInt(req.getParameter("quizId"));
        int score = Integer.parseInt(req.getParameter("score"));
        int total = Integer.parseInt(req.getParameter("total"));
 
        UserAttemptDAO uad = new UserAttemptDAO();
        List<LeaderboardEntry> leaderboard = uad.getLeaderboardByQuiz(quizId);
 
        req.setAttribute("score", score);
        req.setAttribute("total", total);
        req.setAttribute("leaderboard", leaderboard);
        req.setAttribute("quizId", quizId);
        req.getRequestDispatcher("/user/result.jsp").forward(req, resp);
    }
}