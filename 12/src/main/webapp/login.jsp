<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="<%=response.encodeURL(request.getContextPath())+"/j_security_check" %>" method="post">
    <p>
     <span>Login: </span>
        <input type="text" name="j_username" placeholder="login">
    </p>
    <p>
        <span>Password: </span>
        <input type="password" name="j_password" placeholder="password">
    </p>
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>
