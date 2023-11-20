<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">
</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
			<img src="https://w7.pngwing.com/pngs/974/17/png-transparent-car-park-parking-computer-icons-parking-text-rectangle-logo-thumbnail.png" alt="" width="60" height="60">
		    <a  href="User.jsp" class="btn btn-info" type="button" style="margin-right: 1150px;">Home</a>
		</nav>
	</div>		
</header>
<body >
 	<div class="container">	
 		
 		<form method="post" action="userotp"  style="background-color: white; margin-top: 50px; margin-left: 200px; margin-right: 200px; border: 1px solid black; border-radius: 10px;">
				<span></span><br>
				<h1 style="text-align: center; color: red;">Send OTP</h1>
			<div class="container">
			<span style="color: red;">${otpmsg1 }</span><br>
			<label for="email"><b>Email Address</b></label>	
			    <input type="email" name="email" class="form-control" placeholder="Enter Email" required="required">
			    <input type="submit" value="Send OTP" onclick="countdown();" class="btn btn-info" style="margin-top: 5px;" >
			 	<span></span><br>
			 	<span></span><br>
			</div>		
		</form>
	</div>	
</body>
	<div class="fixed-footer">
		<footer class="bg-secondary text-white">
		    <div class="text-center p-3" style="background-color: secondary;">
		      © 2023 Copyright:
		      <a class="text-white" href="https://irfan.xworkz@gmail.com/">irfan.xworkz@gmail.com</a>
		    </div>
		 </footer>
	</div>	 
</html>