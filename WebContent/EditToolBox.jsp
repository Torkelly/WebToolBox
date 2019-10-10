<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a ToolBox</title>
</head>
<body>
<form action = "editToolBoxesServlet" method="post">
ToolBox Name: <input type ="text" name = "toolBoxName" value="${toolBoxToEdit.toolBoxName}"><br />
Date Added: <input type ="text" name = "month" placeholder="mm" size="4" value="${toolBoxToEdit.dateAdded.getMonthValue()}"> <input type ="text" name = "day" placeholder="dd" size="4" value="${toolBoxToEdit.dateAdded.getDayOfMonth()}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value="${toolBoxToEdit.dateAdded.getYear()}">
Owner Name: <input type = "text" name = "consumerName" value="${toolBoxToEdit.owner.ownerName}"><br />
<input type = "hidden" name = "toolBoxId" value="${toolBoxToEdit.toolBoxId}">
Current ToolBoxes:<br />
<select name="currentTool" multiple size="6">
<c:forEach var = "toolBoxVal" items = "${toolBoxToEdit.toolsInToolBox}">
          <option value = "${toolBoxVal.toolBoxId}">${toolBoxVal.toolBoxName}</option>          
  </c:forEach>
</select>
<br />
Remaining Boxes:<br />
<select name="toolBoxesToAdd" multiple size="6">
<c:forEach items="${requestScope.allToolBoxesToAdd}" var="currentTool">
   <option value = "${currentBox.toolId}">${currentBox.toolName}</option>
</c:forEach>
</select>

<br />
<input type = "submit" value="Edit ToolBox and Edit Tools">
</form>
<a href = "index.html">Go add new ToolBoxes instead.</a>
</body>

</html>