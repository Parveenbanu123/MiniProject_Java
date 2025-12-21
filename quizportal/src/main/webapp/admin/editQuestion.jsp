<%@ page import="quizportal.model.Question" %>
 
<%
    Question q = (Question) request.getAttribute("question");
    int quizId = (int) request.getAttribute("quizId");
%>
 
<!DOCTYPE html>
<html>
<head>
    <title>Edit Question</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 
</head>
<body>
 
<h2>Edit Question</h2>
 
<form action="editQuestion" method="post">
 
    <input type="hidden" name="id" value="<%= q.getId() %>">
    <input type="hidden" name="quizId" value="<%= quizId %>">
 
    Question:<br>
    <input type="text" name="questionText" value="<%= q.getQuestionText() %>" required><br><br>
 
    Option A:<br>
    <input type="text" name="optionA" value="<%= q.getOptionA() %>" required><br><br>
 
    Option B:<br>
    <input type="text" name="optionB" value="<%= q.getOptionB() %>" required><br><br>
 
    Option C:<br>
    <input type="text" name="optionC" value="<%= q.getOptionC() %>" required><br><br>
 
    Option D:<br>
    <input type="text" name="optionD" value="<%= q.getOptionD() %>" required><br><br>
 
    Correct Option:<br>
    <select name="correctOption" required>
        <option value="A" <%= q.getCorrectOption().equals("A") ? "selected" : "" %>>A</option>
        <option value="B" <%= q.getCorrectOption().equals("B") ? "selected" : "" %>>B</option>
        <option value="C" <%= q.getCorrectOption().equals("C") ? "selected" : "" %>>C</option>
        <option value="D" <%= q.getCorrectOption().equals("D") ? "selected" : "" %>>D</option>
    </select>
    <br><br>
 
    <button type="submit">Update Question</button>
</form>
 
<br>
<a href="listQuestions?quizId=<%=quizId%>">Back to Question List</a>
 
</body>
</html>