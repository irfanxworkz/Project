<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact-Form</title>
</head>
<body>

<h1>Contact Form</h1>

<form action="send" method="post" enctype="multipart/form-data">
	<pre>
			Name : <input type="text" name="name">
			Email : <input type="text" name="email">
			Mobile No : <input type="text" name="mobile">
			Comments : <textarea rows="3" cols="6" name="comments"></textarea>
			File : <input type="file" name="file">
			
				<input type="submit" value="Send">
	</pre>
</form>

</body>
</html>