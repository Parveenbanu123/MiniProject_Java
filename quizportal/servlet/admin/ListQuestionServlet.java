  package quizportal.servlet.admin;
 
import quizportal.dao.QuestionDAO;
import quizportal.model.Question;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
 
@WebServlet("/listQuestions")
public class ListQuestionServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String quizIdStr = request.getParameter("quizId");
        if (quizIdStr == null) {
            response.getWriter().println("Quiz ID missing! Go back to quiz list.");
            return;
        }
 
        int quizId = Integer.parseInt(quizIdStr);
 
        try {
            QuestionDAO questionDAO = new QuestionDAO();
            List<Question> questions = questionDAO.getQuestionsByQuizId(quizId);
 
            request.setAttribute("questions", questions);
            request.setAttribute("quizId", quizId);
            request.getRequestDispatcher("/admin/listQuestions.jsp").forward(request, response);
 
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error fetching questions: " + e.getMessage());
        }
    }
}