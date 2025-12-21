<%@ page import="java.util.List" %>
<%@ page import="quizportal.model.Quiz" %>
<%
    List<Quiz> quizzes = (List<Quiz>) request.getAttribute("quizzes");
%>
<!DOCTYPE html>
<html>
<head><title>Available Quizzes</title><link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 </head>
<body>
<h2>Available Quizzes</h2>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Description</th><th>Action</th></tr>
<%
if(quizzes!=null){
   for(Quiz q:quizzes){
%>
<tr>
    <td><%= q.getId() %></td>
    <td><%= q.getName() %></td>
    <td><%= q.getDescription() %></td>
    <td>
        <a href="<%=request.getContextPath()%>/startQuiz?quizId=<%=q.getId()%>">
            Start
        </a>
        |
        <a href="<%=request.getContextPath()%>/user/leaderboard?quizId=<%=q.getId()%>">
            Leaderboard
        </a>
    </td>
</tr>
<%
   }
}
%>
</table>
<br>
<a href="<%=request.getContextPath()%>/user/dashboard.jsp">Back to Dashboard</a>
</body>
</html>