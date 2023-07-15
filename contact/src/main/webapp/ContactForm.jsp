<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact-Form</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="Simple.css">
<script type="text/javascript">
	function nameValidation() {
		var enterdNamed = document.getElementById("validName")
		console.log(enterdNamed.value)
		var errMessage = document.getElementById("errNameMessage")
		if (enterdNamed.value != '' && enterdNamed.value.length > 3
				&& enterdNamed.value.length < 45) {
			errMessage.innerHTML = '';
		} else {
			errMessage.innerHTML = "Name shoud be between 3 to 20 character!!!"
			errMessage.style.color = 'red'
		}
	}
	
	function emailValidation() {
		var enterdEmail = document.getElementById("validEmail")
		console.log(enterdEmail.value)
		var errEmail = document.getElementById("errEmailMessage")
		if (enterdEmail.value !=null && enterdEmail.value != '' && enterdEmail.value.length > 3
				&& enterdEmail.value.length < 45) {
			errEmail.innerHTML = '';
		} else {
			errEmail.innerHTML = "Please Enter Right Email!!!"
				errEmail.style.color = 'red'
		}
	}
	
	function mobileValidation() {
		var enterdMobile = document.getElementById("validMobile")
		console.log(enterdMobile.value)
		var errMobile = document.getElementById("errMobileMessage")
		if (enterdMobile.value != '' && enterdMobile.value.length > 9
				&& enterdMobile.value.length < 14) {
			errMobile.innerHTML = '';
		} else {
			errMobile.innerHTML = "Please Enter Correct Mobile Number!!!"
				errMobile.style.color = 'red'
		}
	}
	
	function commentsValidation() {
		var enterdComments = document.getElementById("validComments")
		console.log(enterdComments.value)
		var errComments = document.getElementById("errCommentsMessage")
		if (enterdComments.value != '' && enterdComments.value.length > 2
				&& enterdComments.value.length < 450) {
			errComments.innerHTML = '';
		} else {
			errComments.innerHTML = "Please Enter Correct Comments!!!"
				errComments.style.color = 'red'
		}
	}
	
	function fileValidation() {
		var enterdFile = document.getElementById("validFile")
		console.log(enterdFile.value)
		var errFile = document.getElementById("errFileMessage")
		if (enterdFile.value != '' && enterdFile.value.length > 9
				&& enterdFile.value.length < 14) {
			errFile.innerHTML = '';
		} else {
			errFile.innerHTML = "Please upload correct file!!!"
				errFile.style.color = 'red'
		}
	}
</script>

</head>
<body>

	<nav class="navbar navbar-dark bg-dark justify-content-between">
		<a href="ContactDisplay.jsp" class="navbar-brand">Display Details</a>
		<a href="Contactlist" class="navbar-brand">AllListView</a>

		<form action="search" method="get" class="form-inline">
			<input type="search" name="name" class="form-control mr-sm-2"
				placeholder="name" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>

	</nav>

	<h3 style="text-align: center; color: red;">Contact Form</h3>

	<form
		style="border: solid thin; margin-left: 150px; margin-right: 150px"
		action="send" method="post" enctype="multipart/form-data">
		<pre>
	
			Name : <input type="text"  name="name" value="${dto.name }"  id="validName" onchange="nameValidation()">
			<span id="errNameMessage"></span>
			
			Email : <input type="text" name="email" value="${dto.email }" id="validEmail" onchange="emailValidation()"><span id="errEmailMessage"></span>
			Mobile No : <input type="text" name="mobile" value="${dto.mobile }" id="validMobile" onchange="mobileValidation()"><span id="errMobileMessage"></span>>
			Comments : 
				<textarea rows="3" cols="60" name="comments" id="validMobile" onchange="mobileValidation()">>please write some comment...</textarea><span id="errCommentsMessage"></span>
			File : <input type="file" name="file">
			
				<input type="submit" value="Send">
	</pre>
	</form>

</body>
</html>