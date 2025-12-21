<%@ page import="quizportal.model.Quiz" %>
<%
    Quiz quiz = (Quiz) request.getAttribute("quiz");
%>
 
<!DOCTYPE html>
<html>
<head>
    <title>Edit Quiz</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 
</head>
<body>
    <h2>Edit Quiz</h2>
 
    <form action="editQuiz" method="post">
        <input type="hidden" name="id" value="<%=quiz.getId()%>">
 
        <label>Quiz Name:</label><br>
        <input type="text" name="quizName" value="<%=quiz.getName()%>" required><br><br>
 
        <label>Description:</label><br>
        <textarea name="description" required><%=quiz.getDescription()%></textarea><br><br>
 
        <button type="submit">Update Quiz</button>
    </form>
 
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Failed to update quiz. Try again.</p>
    <% } %>
 
    <br>
    <a href="listQuizzes">Back to Quiz List</a>
</body>
</html>