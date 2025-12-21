<%@ page import="java.util.List" %>
<%@ page import="quizportal.model.Quiz" %>
<%
    List<Quiz> quizzes = (List<Quiz>) request.getAttribute("quizzes");
%>
 
<!DOCTYPE html>
<html>
<head>
    <title>All Quizzes</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 
</head>
<body>
    <h2>All Quizzes</h2>
    <a href="/OnlineQuizPortal/admin/addQuiz.jsp">Add New Quiz</a>
    <a href="<%=request.getContextPath()%>/admin/logout">Logout</a>
 
    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <%
            if (quizzes != null) {
                for (Quiz q : quizzes) {
        %>
        <tr>
            <td><%= q.getId() %></td>
            <td><%= q.getName() %></td>
            <td><%= q.getDescription() %></td>
            <td>
                <a href="editQuiz?id=<%=q.getId()%>">Edit</a> |
                <a href="admin/addQuestion.jsp?quizId=<%=q.getId()%>">Add Question</a> |
                <a href="deleteQuiz?id=<%=q.getId()%>" onclick="return confirm('Delete this quiz?');">Delete</a>
                
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>