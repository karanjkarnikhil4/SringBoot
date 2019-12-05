<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
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
<th>Update</th>
<th>Delete</th>
</tr>
</thead>
<tbody>

<c:forEach items="${todoList}" var="todo">
<tr>
<td>${todo.desc}</td>
<td><fmt:formatDate pattern="dd/MM/yyyy"
									value="${todo.targetDate}" /> </td>
<td>${todo.isDone}</td>
<td><a type="button" class="btn btn-success" href="/updateTodo?id=${todo.id}">Update</a></td>
<td><a type ="button" class="btn btn-warning" href="/deleteTodo?id=${todo.id}">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
 <a class="button" href="/addTodo">Add a Todo</a></div>

<div>
<%@ include file="common/footer.jspf" %>
 <script>
$(document).ready(function(){
	   $(".active").removeClass("active");
	   $("#todoNav").addClass("active");
	});
</script>