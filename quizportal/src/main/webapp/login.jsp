<!DOCTYPE html>
<html>
<head>
    <title>User Login | Online Quiz Portal</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<div class="container">

    <h1>Online Quiz Portal</h1>
    <h2>User Login</h2>

    <form action="userLogin" method="post">

        <label>Email</label>
        <input type="email" name="email" placeholder="Enter your email" required>

        <label>Password</label>
        <input type="password" name="password" placeholder="Enter password" required>

        <button type="submit">Login as User</button>

    </form>

    <hr>

    <a href="user/register.jsp">New User? Register Here</a>

    <br><br>

    <a href="index.jsp"> Back to Admin Login</a>

</div>

</body>
</html>
