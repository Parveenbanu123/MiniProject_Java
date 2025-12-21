package quizportal.servlet.admin;
 
import quizportal.dao.QuestionDAO;
import quizportal.model.Question;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
 
@WebServlet("/editQuestion")
public class EditQuestionServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String idStr = request.getParameter("id");
        String quizIdStr = request.getParameter("quizId");
 
        if (idStr == null || quizIdStr == null) {
            response.getWriter().println("Missing question ID or quiz ID.");
            return;
        }
 
        int id = Integer.parseInt(idStr);
        int quizId = Integer.parseInt(quizIdStr);
 
        try {
            QuestionDAO questionDAO = new QuestionDAO();
            Question question = questionDAO.getQuestionById(id);
 
            request.setAttribute("question", question);
            request.setAttribute("quizId", quizId);
 
            request.getRequestDispatcher("admin/editQuestion.jsp").forward(request, response);
 
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error loading question: " + e.getMessage());
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int id = Integer.parseInt(request.getParameter("id"));
        int quizId = Integer.parseInt(request.getParameter("quizId"));
 
        String questionText = request.getParameter("questionText");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String correctOption = request.getParameter("correctOption");
 
        try {
            Question question = new Question();
            question.setId(id);
            question.setQuizId(quizId);
            question.setQuestionText(questionText);
            question.setOptionA(optionA);
            question.setOptionB(optionB);
            question.setOptionC(optionC);
            question.setOptionD(optionD);
            question.setCorrectOption(correctOption);
 
            QuestionDAO questionDAO = new QuestionDAO();
            boolean updated = questionDAO.updateQuestion(question);
 
            if (updated) {
                response.sendRedirect("listQuestions?quizId=" + quizId);
            } else {
                response.getWriter().println("Failed to update question.");
            }
 
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error updating question: " + e.getMessage());
        }
    }
}