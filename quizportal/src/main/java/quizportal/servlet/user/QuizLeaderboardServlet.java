package quizportal.servlet.user;
 
import quizportal.dao.UserAttemptDAO;
import quizportal.model.LeaderboardEntry;
import quizportal.model.User;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
 
@WebServlet("/user/leaderboard")
public class QuizLeaderboardServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int quizId = Integer.parseInt(request.getParameter("quizId"));
 
        UserAttemptDAO dao = new UserAttemptDAO();
        List<LeaderboardEntry> leaderboard = dao.getLeaderboardByQuiz(quizId);
 
        request.setAttribute("leaderboard", leaderboard);
        request.setAttribute("quizId", quizId);
 
        request.getRequestDispatcher("/user/leaderboard.jsp")
               .forward(request, response);
    }
}