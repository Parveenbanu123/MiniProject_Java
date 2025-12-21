<!DOCTYPE html>
<html>
<head>
    <title>Add Quiz</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 
</head>
<body>
    <h2>Add New Quiz</h2>
 
    <form action="../addQuiz" method="post">
        <label>Quiz Name:</label><br>
        <input type="text" name="quizName" required><br><br>
 
        <label>Description:</label><br>
        <textarea name="description" required></textarea><br><br>
 
        <button type="submit">Add Quiz</button>
    </form>
 
    <% if (request.getParameter("success") != null) { %>
        <p style="color:green;">Quiz added successfully!</p>
    <% } %>
 
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Failed to add quiz. Try again.</p>
    <% } %>
 
</body>
</html>