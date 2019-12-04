<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Web application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<div class = "container">
<h1>Your Todos</h1>
<br/>
<br/>
<table class="table table-striped">
<caption>Your Todo's</caption>
<thead>
<tr>
<th>Description</th>
<th>Target Date</th>
<th>Is Done</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todoList}" var="todo">
<tr>
<td>${todo.desc}</td>
<td>${todo.targetDate}</td>
<td>${todo.isDone}</td>
<td><a type ="button" class="btn btn-warning" href="/deleteTodo?id=${todo.id}">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<div> <a class="button" href="/addTodo">Add a Todo</a></div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</div>
</body>
</html>