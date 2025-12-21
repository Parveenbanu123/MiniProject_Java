package quizportal.servlet.user;
 
import quizportal.dao.QuizDAO;
import quizportal.model.Quiz;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
 
@WebServlet("/user/dashboard")
public class UserDashboardServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        try {
            QuizDAO quizDAO = new QuizDAO();
            List<Quiz> quizzes = quizDAO.getAllQuizzes();
 
            request.setAttribute("quizzes", quizzes);
            request.getRequestDispatcher("/user/dashboard.jsp").forward(request, response);
 
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error loading dashboard");
        }
    }
}