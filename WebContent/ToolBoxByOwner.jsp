<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ToolBoxes by Owner</title>
</head>
<body>
<body>
<form method = "post" action = "NavigateToolBoxesServlet">
<table>
<c:forEach items="${requestScope.allToolBoxes}" var="currentToolBox">
<tr>
   <td><input type="radio" name="toolBoxId" value="${currentToolBox.toolBoxId}"></td>
   <td><h2>${currentToolBox.toolBoxName}</h2></td></tr>
   <tr><td colspan="3">Date Added: ${currentToolBox.dateAdded}</td></tr>
   <tr><td colspan="3">Owner: ${currentToolBox.owner.ownerName}</td></tr>
   <c:forEach var = "toolBoxVal" items = "${currentToolBox.toolsInToolBox}">
            <tr><td></td><td colspan="3">
                ${toolBoxVal.toolName}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToTool">
<input type = "submit" value = "delete" name="doThisToTool">
<input type="submit" value = "add" name = "doThisToTool">
</form>
<a href="AddToolsInToolBoxServlet">Create a new ToolBox</a><br>
<a href="Index.html">Insert a new Tool</a>
</body>

</body>
</html>
