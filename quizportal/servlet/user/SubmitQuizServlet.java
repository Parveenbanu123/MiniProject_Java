package quizportal.servlet.user;
 
import quizportal.dao.QuestionDAO;
import quizportal.dao.UserAttemptDAO;
import quizportal.model.Question;
import quizportal.model.User;
import quizportal.model.UserAttempt;
 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
 
@WebServlet("/submitQuiz")
public class SubmitQuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        User user = (User) session.getAttribute("user");
 
        int quizId = Integer.parseInt(req.getParameter("quizId"));
        QuestionDAO qdao = new QuestionDAO();
        List<Question> questions = qdao.getQuestionsByQuizId(quizId);
 
        int correct = 0;
        for (Question q : questions) {
            String ans = req.getParameter("q_" + q.getId());
            if (ans != null && ans.equalsIgnoreCase(q.getCorrectOption())) correct++;
        }
        int total = questions.size();
 
        // Save attempt
        UserAttempt ua = new UserAttempt();
        ua.setUserId(user.getId());
        ua.setQuizId(quizId);
        ua.setScore(correct);
        ua.setTotalQuestions(total);
 
        UserAttemptDAO uad = new UserAttemptDAO();
        uad.saveAttempt(ua);
 
        resp.sendRedirect(req.getContextPath() + "/result?quizId=" + quizId + "&score=" + correct + "&total=" + total);
    }
}