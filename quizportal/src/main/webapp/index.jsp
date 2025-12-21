<!DOCTYPE html>
<html>
<head>
    <title>Online Quiz Portal - Login</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
 
<h1>Online Quiz Portal</h1>
 
<h2>Admin Login</h2>
<form action="adminLogin" method="post">
    <label>Admin Username:</label>
    <input type="text" name="username" required><br>
 
    <label>Password:</label>
    <input type="password" name="password" required><br>
 
    <button type="submit">Login as Admin</button>
</form>
 
<hr>
 
<h2>User Login</h2>
<form action="userLogin" method="post">
    <label>Email:</label>
    <input type="email" name="email" required><br>
 
    <label>Password:</label>
    <input type="password" name="password" required><br>
 
    <button type="submit">Login as User</button>
</form>
 
<br>
 
<a href="user/register.jsp">New User? Register Here</a>
 
</body>
</html>