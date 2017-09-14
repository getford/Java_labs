<%@page language="java" contentType="text/html; ISO-8859-1" %>
<%@ page import="jspclass.Time" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>04 - Index.jsp</title>

    <%--    <%!
            private Time time = new Time();
            private Integer n = time.getHour();

            private String Hello(Integer hour) {
                String rc;
                if (hour > 0 && hour <= 5)
                    rc = "Good night";
                else if (hour > 5 && hour <= 12)
                    rc = "Good morning";
                else if (hour > 12 && hour <= 17)
                    rc = "Good afternoon";
                else
                    rc = "Good evening";
                return rc;
            }
        %>--%>
</head>
<body>
<% Time time = new Time();%>

<%time.PrintHello(time.getHour());%>
<%time.ArrayDates(time.getDay(), time.getDayOfWeek(), time.getDayOfMonth(), time.getDate());%>
<%=time.getRc()%>
<hr/>
</body>
</html>
