<%@ page import="java.util.List" %>
<%@ page import="quizportal.model.UserAttempt" %>
<%@ page import="quizportal.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
 
    quizportal.dao.UserAttemptDAO dao = new quizportal.dao.UserAttemptDAO();
    List<UserAttempt> attempts = dao.getAttemptsByUser(user.getId());
%>
<!DOCTYPE html>
<html>
<head><title>Attempt History</title><link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 </head>
<body>
<h2>Your Attempts</h2>
<table border="1">
<tr><th>Quiz ID</th><th>Score</th><th>Total</th><th>Time</th></tr>
<% for (UserAttempt a : attempts) { %>
  <tr>
    <td><%= a.getQuizId() %></td>
    <td><%= a.getScore() %></td>
    <td><%= a.getTotalQuestions() %></td>
    <td><%= a.getAttemptTime() %></td>
  </tr>
<% } %>
</table>
 
<br><a href="<%=request.getContextPath()%>/user/dashboard.jsp">Back</a>
</body>
</html>