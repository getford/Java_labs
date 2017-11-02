<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = request.getRemoteUser();
%>

<span>Hello, <%=username%></span>
</body>
</html>
