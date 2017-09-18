<%@page language="java" contentType="text/html; ISO-8859-1" %>
<%@ page import="jspclass.Time" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>04 - Index.jsp</title>
</head>
<body>
<% Time time = new Time();%>

<%time.PrintHello(time.getHour());%>
<%time.ArrayDates(time.getDay(), time.getDayOfWeek(), time.getDayOfMonth(), time.getDate());%>
<%=time.getRc()%>
<hr/>
<%
    for (int i = 0; i < time.getListDays().length; i++) {
        out.println(Arrays.deepToString(time.getListDays()[i]));
        out.println("<br/>");
    }
%>
<hr/>
<form action="<c:url value="/Jjj"/>" method="post">
    <input type="submit" name="press">
</form>
<%--<hr/>
<jsp:include page="morning.jsp"/>
<hr/>
<jsp:forward page="night.jsp"/>--%>
</body>
</html>
