package quizportal.servlet.user;
 
import quizportal.dao.QuestionDAO;
import quizportal.dao.QuizDAO;
import quizportal.model.Question;
import quizportal.model.Quiz;
 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
 
@WebServlet("/startQuiz")
public class StartQuizServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String qid = req.getParameter("quizId");
        if (qid == null) {
            resp.getWriter().println("Quiz id missing");
            return;
        }
        int quizId = Integer.parseInt(qid);
        QuizDAO qdao = new QuizDAO();
        Quiz quiz = qdao.getQuizById(quizId);
        QuestionDAO questionDAO = new QuestionDAO();
        List<Question> questions = questionDAO.getQuestionsByQuizId(quizId);
 
        req.setAttribute("quiz", quiz);
        req.setAttribute("questions", questions);
        req.getRequestDispatcher("/user/takeQuiz.jsp").forward(req, resp);
    }
}