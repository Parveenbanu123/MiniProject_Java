
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login | Online Quiz Portal</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<div class="container">

    <h1>Online Quiz Portal</h1>
    <h2>Admin Login</h2>

    <form action="adminLogin" method="post">

        <label>Admin Username</label>
        <input type="text" name="username" placeholder="Enter admin username" required>

        <label>Password</label>
        <input type="password" name="password" placeholder="Enter password" required>

        <button type="submit">Login as Admin</button>

    </form>

    <hr>

    <a href="<%=request.getContextPath()%>/login.jsp">
        Login as User 
    </a>

</div>

</body>
</html>
