<%@ page import="quizportal.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head><title>User Dashboard</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 </head>
<body>
<h2>Welcome, <%= user.getName() %></h2>
 
<table>
<tr>
    <td><a href="<%=request.getContextPath()%>/user/quizzes">Take Quiz</a></td>
    <td><a href="<%=request.getContextPath()%>/user/history.jsp">Attempt History</a></td>
    <td><a href="<%=request.getContextPath()%>/user/logout">Logout</a></td>
</tr>
</table>
 
</body>
</html>