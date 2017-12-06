<%@ page import="java.io.File" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html; ISO-8859-1" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<%
    File[] fileInDir;
    File file = new File(request.getServletContext().getInitParameter("file-dir"));

    fileInDir = file.listFiles();

    ArrayList<String> nameFile = new ArrayList<String>();

    for (int i = 0; i < fileInDir.length; i++) {
        if (fileInDir[i].isFile())
            nameFile.add(fileInDir[i].getName());
    }
%>
<form action="#" method="get">
    <%
        PrintWriter printWriter = response.getWriter();

        response.setContentType("text/html");
        for (String fn : nameFile)
            printWriter.println("<a href = " + file + "/" + fn + " name = fn>" + fn + "</a><br>");
    %>
</form>


<h4><a href="/sss">SSS</a></h4>
</body>
</html>
