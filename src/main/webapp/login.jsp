<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/6/2022
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form method="POST" action="/account/login">
    <div class="container">
        <h1>Login</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label for="userName"><b>userName</b></label>
        <input type="text" placeholder="Enter Email" name="userName" id="userName" required>

        <label for="passwordHash"><b>passwordHash</b></label>
        <input type="password" placeholder="Enter Password" name="passwordHash" id="passwordHash" required>

        <button type="submit" class="registerbtn">Login</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="/account/register">Register </a>.</p>
    </div>
</form>
</body>
</html>
