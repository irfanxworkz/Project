<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Details</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">

</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
		    <a  href="Admin.jsp" class="btn btn-info" type="button">Home</a>
		    <a style="margin-left: 1000px; color: pink;" class="navbar-brand" >Welcome,${adminDTOS.name}</a>
			<!-- <a href="Admin.jsp" class="btn btn-info" type="button">Logout</a> -->
		</nav>
	</div>	
</header>
<body>
		<pre>
			<a href="ParkingInfo.jsp" class="btn btn-info" type="button">Add Parking Info</a><br>
			<a  href="ViewData.jsp" class="btn btn-info" type="button">View Parking Data</a>
		</pre>  		
</body>
	<div class="fixed-footer">
		 <footer class="bg-secondary text-white">
		    <div class="text-center p-3" style="background-color: secondary;">
		      © 2023 Copyright:
		      <a class="text-white" href="https://irfan.xworkz@gmail.com/">irfan.xworkz@gmail.com <span style="color: orange;">[LoginTime:${adminDTOS.loginTime }]</span></a>
		    </div>
		  </footer>
	</div>	  
</html>