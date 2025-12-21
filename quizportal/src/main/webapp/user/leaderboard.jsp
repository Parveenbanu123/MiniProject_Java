<%@ page import="java.util.List" %>
<%@ page import="quizportal.model.LeaderboardEntry" %>
 
<%
    List<LeaderboardEntry> leaderboard =
        (List<LeaderboardEntry>) request.getAttribute("leaderboard");
%>
 
<!DOCTYPE html>
<html>
<head>
<title>Quiz Leaderboard</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
 
</head>
<body>
 
<h2>Leaderboard</h2>
 
<table border="1" cellpadding="10">
<tr>
    <th>Rank</th>
    <th>User Name</th>
    <th>Email</th>
    <th>Score</th>
</tr>
 
<%
if (leaderboard != null && !leaderboard.isEmpty()) {
    for (LeaderboardEntry e : leaderboard) {
%>
<tr>
    <td><%= e.getRank() %></td>
    <td><%= e.getUserName() %></td>
    <td><%= e.getEmail() %></td>
    <td><%= e.getScore() %></td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="4">No attempts yet</td>
</tr>
<%
}
%>
</table>
 
<br>
<a href="<%=request.getContextPath()%>/user/quizzes">Back to Quizzes</a>
 
</body>
</html>