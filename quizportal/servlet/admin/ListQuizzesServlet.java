package quizportal.servlet.admin;
 
import quizportal.dao.QuizDAO;
import quizportal.model.Quiz;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
 
@WebServlet("/listQuizzes")
public class ListQuizzesServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        try {
            QuizDAO quizDAO = new QuizDAO();
            List<Quiz> quizzes = quizDAO.getAllQuizzes();
 
            request.setAttribute("quizzes", quizzes);
            request.getRequestDispatcher("/admin/quizzes.jsp").forward(request, response);
 
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error fetching quizzes: " + e.getMessage());
        }
    }
}

 