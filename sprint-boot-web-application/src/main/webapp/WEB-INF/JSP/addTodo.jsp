<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Web application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
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

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
</div>
</body>
</html>