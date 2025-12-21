package quizportal.servlet.admin;
 
import quizportal.dao.QuizDAO;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
 
@WebServlet("/deleteQuiz")
public class DeleteQuizServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int quizId = Integer.parseInt(request.getParameter("id"));
 
        try {
            QuizDAO quizDAO = new QuizDAO();
            boolean deleted = quizDAO.deleteQuiz(quizId);
 
            if (deleted) {
                response.sendRedirect("listQuizzes");
            } else {
                response.getWriter().println("Failed to delete quiz.");
            }
 
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error deleting quiz: " + e.getMessage());
        }
    }
}