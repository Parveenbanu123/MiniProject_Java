package quizportal.servlet.user;
 
import quizportal.dao.UserDAO;
import quizportal.model.User;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
 
@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
 
        UserDAO dao = new UserDAO();
        User user = dao.validateUser(email, password);
 
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/user/dashboard.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp?userLoginError=1");
        }
    }
}