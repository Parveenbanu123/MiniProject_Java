package quizportal.servlet.admin;

import quizportal.dao.QuizDAO;
import quizportal.model.Quiz;
 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/addQuiz")
public class AddQuizServlet extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String quizName = request.getParameter("quizName");
        String description = request.getParameter("description");
 
        try {
            QuizDAO quizDAO = new QuizDAO();
 
            Quiz quiz = new Quiz();
            quiz.setName(quizName);
            quiz.setDescription(description);
 
            boolean inserted = quizDAO.addQuiz(quiz);
 
            if (inserted) {
               response.sendRedirect(request.getContextPath()+"/listQuizzes");
            } else {
               response.sendRedirect(request.getContextPath()+"/admin/addQuiz.jsp?error=1");
            }
 
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("admin/addQuiz.jsp?error=1");
        }
    }
}

 