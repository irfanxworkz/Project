<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact-Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Simple.css">
</head>
<body>
	
	<nav class="navbar navbar-dark bg-dark justify-content-between">
		<a href="Details.jsp" class="navbar-brand">Details</a>
		<a href="ImageDisplay.jsp" class="navbar-brand">Download Image</a>
		<a href="list" class="navbar-brand">AllListView</a>
		<form class="form-inline">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</nav>
	
<h3 style="text-align: center; color: red;">Contact Form</h3>

<form style="border: solid thin; margin-left: 150px; margin-right: 150px" action="send" method="post" enctype="multipart/form-data">
	<pre>
			Name : <input type="text" name="name" value="${dto.name }" />
			Email : <input type="text" name="email" value="${dto.email }" />>
			Mobile No : <input type="text" name="mobile" value="${dto.mobile }" />>
			Comments : <textarea rows="3" cols="6" name="comments" >></textarea >
			File : <input type="file" name="file">
			
				<input type="submit" value="Send">
	</pre>
</form>

</body>
</html>