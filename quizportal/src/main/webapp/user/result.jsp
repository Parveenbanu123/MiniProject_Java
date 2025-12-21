<%@ page import="java.util.List" %>
<%@ page import="quizportal.model.LeaderboardEntry" %>
 
<%
    List<LeaderboardEntry> leaderboard =
        (List<LeaderboardEntry>) request.getAttribute("leaderboard");
%>
 
<h2>Your Result</h2>
<p>Score: <b>${score}</b> / ${total}</p>
 
<h3>Leaderboard</h3>
 
<table border="1" cellpadding="8">
<tr>
    <th>Rank</th>
    <th>Name</th>
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
 