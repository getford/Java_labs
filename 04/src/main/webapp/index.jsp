<%@page language="java" contentType="text/html; ISO-8859-1" %>
<%@ page import="jspclass.*" %>
<html>
<head>
    <title>04 - Index.jsp</title>

    <%!
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
    %>
</head>
<body>
<h4><%=Hello(n)%>
</h4>
<hr/>
</body>
</html>
