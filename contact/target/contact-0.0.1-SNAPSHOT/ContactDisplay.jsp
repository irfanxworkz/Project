<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ContactDisplay]</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Simple.css">
</head>
<body>
		<nav class="navbar navbar-dark bg-dark justify-content-between">
		<a href="ContactForm" class="navbar-brand">Home</a>
		<a href="list" class="navbar-brand">AllListView</a>
		</nav>

		<h1 style="color: red; text-align: center;">Submission Form</h1>
			<span style="color: green; text-align: 40px;">${msg }</span>
		<pre style="border: solid 2px; margin-left: 120px; margin-right: 120px; background-color: rgb(235, 208, 148)">
			
			id: ${dtos.id }
	
		 	name: ${dtos.name }
	
			email: ${dtos.email }
			
			mobile: ${dtos.mobile }
			
			comments: ${dtos.comments }
			
			fileName: ${dtos.fileName}
			
			contentType: ${dtos.contentType }
			
			fileSize: ${dtos.fileSize }
			
		</pre>
</body>
</html>