<%@ page import="pack.CBean" %>
<%@ page contentType="text/html; ISO-8859-1" language="java" %>
<html>
<head>
    <title>06 - Ccc page</title>
</head>
<body>
<%!
    private CBean cBean = new CBean();
%>
<br>
Value1: <%=cBean.getValue1()%>
Value2: <%=cBean.getValue2()%>
Value3: <%=cBean.getValue3()%>
Attribute: <%=cBean.getAtrCBean()%>
</body>
</html>
