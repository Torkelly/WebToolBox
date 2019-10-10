<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Toolboxes</title>
</head>
<body>
<form method = "post" action = "NavigationToolsServlet">
    <table>
        <c:forEach items="${requestScope.allTools}" var="currentTool">
            <tr>
                <td><input type="radio" name="id" value="${currentTool.toolId}"></td>
                <td>${currentTool.toolName}</td>
            </tr>
        </c:forEach>
    </table>
    <input type = "submit" value = "edit" name="doThisToTool">
    <input type = "submit" value = "delete" name="doThisToTool">
    <input type="submit" value = "add" name = "doThisToTool">
</form>
</body>
</html>