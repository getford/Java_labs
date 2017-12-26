<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Лабораторная работа №6</title>
</head>

<body>
<%
  String _url1 = getServletConfig().getServletContext().getInitParameter("URL1");
  String _url2 = getServletConfig().getServletContext().getInitParameter("URL2");

%>
<%="URL1 = "+_url1+"\n"%><br>
<%="URL2 = "+_url2+"\n"%><br>
</body>
</html>