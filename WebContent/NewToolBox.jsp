<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new Toolbox!</title>
</head>
<body>
<form action = "CreateNewToolBoxServlet" method="post">
ToolBox Name: <input type ="text" name = "toolBoxName"><br />
Date Added: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">
Owner Name: <input type = "text" name = "ownerName"><br />

Available Tools:<br />

<select name="allToolsToAdd" multiple size="6">
<c:forEach items="${requestScope.allTools}" var="currentTool">
   <option value = "${currentTool.toolId}">${currentTool.toolName}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create ToolBox and Add Tools">
</form>
<a href = "Index.html">Add new tools instead</a>
</body>

</html>