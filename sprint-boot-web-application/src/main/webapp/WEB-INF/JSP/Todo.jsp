<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Web application</title>
</head>
<body>
<br/>
<br/>
<table>
<caption>Your Todo's</caption>
<thead>
<tr>
<th>Description</th>
<th>Target Date</th>
<th>Is Done</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todoList}" var="todo">
<tr>
<td>${todo.desc}</td>
<td>${todo.targetDate}</td>
<td>${todo.isDone}</td>
</tr>
</c:forEach>


</tbody>
</table>


<a href="/addTodo">Add a Todo</a>
</body>
</html>