<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h4>Запрос URLn</h4>
<form action="/URLn" method="get">
    <input type="text" name="urln" placeholder="URLn">
    <button type="submit">click</button>
</form>
<hr/>
<h4>GET</h4>
<form action="/Ccc" method="get">
    <input type="text" name="value1" placeholder="Value1"/><br/>
    <input type="text" name="value2" placeholder="Value2"/><br/>
    <input type="text" name="value3" placeholder="Value3"/><br/>
    New <input type="radio" name="radio" value="new" label="New" title=""/><br/>
    Old <input type="radio" name="radio" value="old" label="Old" title=""/><br/>
    <button type="submit">click</button>
</form>
<hr/>
<h4>POST</h4>
<form action="/Ccc">
    <input type="text" name="value1" placeholder="Value1"/><br/>
    <input type="text" name="value2" placeholder="Value2"/><br/>
    <input type="text" name="value3" placeholder="Value3"/><br/>
    New <input type="radio" name="radio" value="new" label="New" title=""/><br/>
    Old <input type="radio" name="radio" value="old" label="Old" title=""/><br/>
    <button type="submit">click</button>
</form>
</body>
</html>
