<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="usr" uri="usertaglib.tld" %>
<html>
<head>
    <title>05 - taglib</title>
</head>
<body>
<usr:dossier action="/Ttt">
    <usr:firstname value="Vladimir"/>
    <br/>
    <usr:lastname value="Zhigalo"/>
    <br/>
    <usr:sex/>
    <br/>
    <usr:submit/>
</usr:dossier>
</body>
</html>