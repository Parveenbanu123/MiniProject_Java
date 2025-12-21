<!DOCTYPE html>
<html>
<head>
	<title>User Registration</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<h2>User Registration</h2>
<form action="${pageContext.request.contextPath}/registerUser" method="post">
    Name: <input type="text" name="name" required><br>
    Email: <input type="email" name="email" required><br>
    Password: <input type="password" name="password" required><br>
    <button type="submit">Register</button>
</form>
<% if(request.getParameter("error")!=null){ %>
<p style="color:red">Registration error or email exists</p>
<% } %>
</body>
</html>