package quizportal.servlet.user;
 
import quizportal.dao.QuizDAO;
import quizportal.model.Quiz;
 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
 
@WebServlet("/user/quizzes")
public class UserQuizzesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuizDAO dao = new QuizDAO();
        List<Quiz> quizzes = dao.getAllQuizzes();
        req.setAttribute("quizzes", quizzes);
        req.getRequestDispatcher("/user/quizzes.jsp").forward(req, resp);
    }
}