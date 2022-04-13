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
<form method="post" action="/account/register">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="userName"><b>userName</b></label>
        <input type="text" placeholder="Enter Email" name="userName" id="userName" required>

        <label for="fullName"><b>fullName</b></label>
        <input type="text" placeholder="Enter Email" name="fullName" id="fullName" required>

        <label for="passwordHash"><b>passwordHash</b></label>
        <input type="password" placeholder="Enter Password" name="passwordHash" id="passwordHash" required>

        <label for="comfirmPassword"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="comfirmPassword" id="comfirmPassword" required>
        <hr>

        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="/account/login">Log in</a>.</p>
    </div>
</form>
</body>
</html>
