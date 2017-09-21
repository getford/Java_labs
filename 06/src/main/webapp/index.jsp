<%@page language="java" contentType="text/html; ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form action="/Ccc" method="post">
    <input type="text" name="value1" placeholder="Value1"/><br/>
    <input type="text" name="value2" placeholder="Value2"/><br/>
    <input type="text" name="value3" placeholder="Value3"/><br/>
    New <input type="radio" name="radio" value="new" label="New" title=""/><br/>
    Old <input type="radio" name="radio" value="old" label="Old" title=""/><br/>
    <button type="submit">click</button>
</form>
</body>
</html>
