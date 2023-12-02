<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excel File Upload</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">

</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
		    <a  href="AdminDetails.jsp" class="btn btn-info" type="button">Home</a>
		    <a style="margin-left: 1000px; color: pink;" class="navbar-brand" >Welcome,${adminDTOS.name}</a>
			<!-- <a href="Admin.jsp" class="btn btn-info" type="button">Logout</a> -->
		</nav>
	</div>	
</header>
<body>
		<h1 style="text-align: center; color: green;">${message}</h1>
	        	<h1 style="text-align: center; color: red;">${message1}</h1>
	    <form action="uploadExcelFile" method="post" enctype="multipart/form-data" style="background-color: white; margin-top: 50px; margin-left: 480px; margin-right: 480px; border: 1px solid black; border-radius: 10px;">
	        <span></span><br>
				<h1 style="text-align: center; color: red;">Excel Sheet</h1>
				<div class="container" style="margin-left: 50px;">
					<label for="file"><b>Select File:</b></label><br>
			        <input type="file" name="file" id="file" accept=".xlsx, .xls" style="color: blue;">
			        <br>
			        <input type="submit" value="Upload" class="btn btn-info" style="margin-top: 20px;">
			        <span></span><br><br>
				</div>
	    </form>

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