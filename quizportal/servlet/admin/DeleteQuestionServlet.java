package quizportal.servlet.admin;
 
import quizportal.dao.QuestionDAO;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
 
@WebServlet("/deleteQuestion")
public class DeleteQuestionServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String idStr = request.getParameter("id");
        String quizIdStr = request.getParameter("quizId");
 
        if (idStr == null || quizIdStr == null) {
            response.getWriter().println("Missing question id or quiz id.");
            return;
        }
 
        try {
            int id = Integer.parseInt(idStr);
            int quizId = Integer.parseInt(quizIdStr);
 
            QuestionDAO questionDAO = new QuestionDAO();
            boolean deleted = questionDAO.deleteQuestion(id);
 
            if (deleted) {
                response.sendRedirect("listQuestions?quizId=" + quizId);
            } else {
                response.getWriter().println("Failed to delete question.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
 