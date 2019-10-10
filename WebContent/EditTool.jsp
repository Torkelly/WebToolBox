<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tool Editor</title>
</head>
<body>
    <form action = "EditToolsServlet" method="post">
        Name: <input type = "text" name = "toolName" value= "${toolToEdit.toolName}">
        <input type = "hidden" name = "toolId" value="${toolToEdit.toolId}">
        <input type = "submit" value="Save Tool">
    </form>
</body>
</html>