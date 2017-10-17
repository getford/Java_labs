<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index lb10</title>
</head>
<body>
<h4>Static select query</h4>
<form action="/QuerySelect" method="get">
       <button type="submit">click</button>
</form>
<hr/>
<h4>Dynamic select where</h4>
<form action="/QueryWhereSelect" method="post">
    <input type="text" name="whereValue" placeholder="value">
    <button type="submit">click</button>
</form>
</body>
</html>
