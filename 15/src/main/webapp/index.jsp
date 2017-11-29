<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>15 Mail</title>
</head>
<body>
<p>Send</p>
<form action="/send" method="post">
    <p>To: <input type="email" name="sendto" placeholder="example@gmail.com"/></p>
    <p>Subject: <input type="text" name="subject" placeholder="Subject"></p>
    <p>Body: <input type="text" name="body" placeholder="Body"></p>

    <input type="submit" name="Click"/>
</form>
<hr/>
<p>Receive</p>
<form action="/receive" method="post">
    <input type="submit" name="Click">
</form>
</body>
</html>
