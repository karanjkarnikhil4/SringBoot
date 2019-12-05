<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class = "container">
<form:form method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label> 
				<form:hidden path="id"/>
				<form:hidden path="user"/>
				<form:hidden path="isDone"/>
				<form:input path="desc" type="text"
					class="form-control" required="required"/>
					<form:errors path="desc" cssClass="text-warning"/>
				<form:errors path="desc" cssClass="text-warning"/>
				<form:label path="desc">Date</form:label> 
				<form:input path="targetDate" type="text"
					class="form-control" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning"/>
				
			</fieldset>

			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script>
$(document).ready(function(){
	   $(".active").removeClass("active");
	   $("#addTodoNav").addClass("active");
	});
</script>

