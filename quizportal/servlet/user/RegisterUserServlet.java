package quizportal.servlet.user;
 
import quizportal.dao.UserDAO;
import quizportal.model.User;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
 
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
 
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
 
        UserDAO dao = new UserDAO();
 
        if (dao.emailExists(email)) {
            response.sendRedirect(request.getContextPath() + "/user/register.jsp?error=exists");
            return;
        }
 
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
 
        boolean saved = dao.registerUser(u);
        if (saved) response.sendRedirect(request.getContextPath() + "/index.jsp?registered=1");
        else response.sendRedirect(request.getContextPath() + "/user/register.jsp?error=1");
    }
}