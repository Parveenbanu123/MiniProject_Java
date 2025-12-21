<%@ page import="java.util.List" %>
<%@ page import="quizportal.model.Question" %>
<%@ page import="quizportal.model.Quiz" %>
<%
    Quiz quiz = (Quiz) request.getAttribute("quiz");
    List<Question> questions = (List<Question>) request.getAttribute("questions");
%>
<!DOCTYPE html>
<html>
<head><title>Take Quiz</title><link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 </head>
<body>
<h2>Quiz: <%= quiz.getName() %></h2>
 
<form action="<%=request.getContextPath()%>/submitQuiz" method="post">
    <input type="hidden" name="quizId" value="<%=quiz.getId()%>" />
    <%
      for(Question q: questions){
    %>
      <div style="margin:12px;">
        <p><strong>Q.<%=q.getId()%></strong> <%=q.getQuestionText()%></p>
        <label><input type="radio" name="q_<%=q.getId()%>" value="A"> <%=q.getOptionA()%></label><br>
        <label><input type="radio" name="q_<%=q.getId()%>" value="B"> <%=q.getOptionB()%></label><br>
        <label><input type="radio" name="q_<%=q.getId()%>" value="C"> <%=q.getOptionC()%></label><br>
        <label><input type="radio" name="q_<%=q.getId()%>" value="D"> <%=q.getOptionD()%></label><br>
      </div>
    <%
      }
    %>
 
    <button type="submit">Submit Quiz</button>
</form>
 
</body>
</html>