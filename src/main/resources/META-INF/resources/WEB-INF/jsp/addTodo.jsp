 <%@ include file = "common/header.jspf" %>
 <%@ include file = "common/navigation.jspf" %>
	<div class="container">
		<h1>Add Todo</h1>
		<form:form method="POST" modelAttribute="todo">

			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>



			<form:input path="id" type="hidden" />
			<form:input path="isCompleted" type="hidden" />
			<p>
				<input type="submit" name="submit" class="btn btn-success" />
			</p>
		</form:form>

	</div>

	 <%@ include file = "common/footer.jspf" %>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>






