package quizportal.servlet.admin;
 
import quizportal.dao.QuestionDAO;
import quizportal.model.Question;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/addQuestion")
public class AddQuestionServlet extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        String questionText = request.getParameter("questionText");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String correctOption = request.getParameter("correctOption");
 
        try {
            QuestionDAO questionDAO = new QuestionDAO();
 
            Question q = new Question();
            q.setQuizId(quizId);
            q.setQuestionText(questionText);
            q.setOptionA(optionA);
            q.setOptionB(optionB);
            q.setOptionC(optionC);
            q.setOptionD(optionD);
            q.setCorrectOption(correctOption);
 
            boolean inserted = questionDAO.addQuestion(q);
 
            if (inserted) {
                response.sendRedirect("listQuestions?quizId=" + quizId + "&success=1");
            } else {
                response.sendRedirect("addQuestion.jsp?quizId=" + quizId + "&error=1");
            }
 
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("admin/addQuestion.jsp?quizId=" + quizId + "&error=1");
        }
    }
}