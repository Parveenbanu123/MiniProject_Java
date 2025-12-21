<%
	String quizIdStr=request.getParameter("quizId");
	if(quizIdStr==null){
		out.println("Quiz Id Missing! Go back to quiz list");
		return;
	}
    int quizId = Integer.parseInt(request.getParameter("quizId"));
%>
 
<!DOCTYPE html>
<html>
<head>
    <title>Add Question</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 
</head>
<body>
    <h2>Add Question</h2>
 
    <form action="../addQuestion" method="post">
        <input type="hidden" name="quizId" value="<%=quizId%>">
 
        <label>Question Text:</label><br>
        <textarea name="questionText" required></textarea><br><br>
 
        <label>Option A:</label><br>
        <input type="text" name="optionA" required><br><br>
 
        <label>Option B:</label><br>
        <input type="text" name="optionB" required><br><br>
 
        <label>Option C:</label><br>
        <input type="text" name="optionC" required><br><br>
 
        <label>Option D:</label><br>
        <input type="text" name="optionD" required><br><br>
 
        <label>Correct Option (A/B/C/D):</label><br>
        <input type="text" name="correctOption" maxlength="1" required><br><br>
 
        <button type="submit">Add Question</button>
    </form>
 
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Failed to add question. Try again.</p>
    <% } %>
 
    <br>
    <a href="../listQuestions?quizId=<%=quizId%>">Back to Question List</a>
</body>
</html>