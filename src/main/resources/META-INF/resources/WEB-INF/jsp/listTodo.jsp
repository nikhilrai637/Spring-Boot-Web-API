  <%@ include file = "common/header.jspf" %>
  <%@ include file = "common/navigation.jspf" %>
	<div class = "Container">
	<h1>Your Todos</h1>
	<hr>	
	<table class = "table">
	<thead>
	<tr>		 
		<th>Name</th>
		<th>Description</th>
		<th>Scheduled Date</th>
		<th>isCompleted</th>
		<th></th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items = "${todos}" var = "todo"> 
	<tr>	  
 	 <td>${todo.username} </td>
 	 <td>${todo.description} </td>
 	 <td>${todo.targetDate} </td>
 	 <td>${todo.isCompleted}</td>
 	  <td class = "btn btn-warning"><a href = "delete-todo?id=${todo.id}"  style="text-decoration:none">
 	  		Delete </a></td>	  		
 	   <td class = "btn btn-success"><a href = "update-todo?id=${todo.id}"  style="text-decoration:none">
 	  		Update  </a></td>
	</tr>	
	</c:forEach>
	</tbody>
	</table>
	<a href = "add-todos" class = "btn btn-success">Add Todos</a>
	</div>
 <%@ include file = "common/footer.jspf" %>
	    
 