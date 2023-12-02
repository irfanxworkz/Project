<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">

</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
		    <a href="AdminDetails.jsp" class="btn btn-info">Home</a>
			<a style="margin-left: 1000px; color: pink;"" class="navbar-brand">Welcome,${adminDTOS.name}</a>
		</nav>
	</div>		
</header>
<body>
	<div class="container">	
		<form action="info" method="post" style="background-color: white;  margin-bottom: 10px; margin-left: 200px; margin-right: 200px; border: 1px solid black; border-radius: 10px;">
			<span style="margin-left: 70px; color: blue;"> ${msg1 }</span>
			<br><h1  style="text-align: center; color: red;">Add Parking Data</h1>
			<div class="container">
				<label for="location"><b>Location</b></label>
				<select name="location" class="form-control" required="required">
				<option value="">location</option>
				<option value="Rajaji-Nagar">Rajaji-Nagar</option>
				<option value="kurubarahalli">Kurubarahalli</option>
				<option value="btm">BTM</option>
				</select>
				<label for="type"><b>Type</b></label>
				<select name="type" class="form-control" required="required">
				<option value="">type</option>
				<option value="2 wheeler">2-Wheeler</option>
				<option value="4 wheeler">4-wheeler</option>
				</select>
				<label for="classification"><b>Classification</b></label>
				<select name="classification" class="form-control" required="required">
				<option value="">classification</option>
				<option value="bmw">BMW</option>
				<option value="dastun">Dastun</option>
				<option value="benz">Benz</option>
				<option value="bike">Bike</option>
				</select>
				<label for="terms"><b>Terms</b></label>
				<select name="terms" class="form-control" required="required">
				<option value="">terms</option>
				<option value="1-day">1-Day</option>
				<option value="7-day">7-Days</option>
				<option value="15-day">15-Days</option>
				<option value="30-day">30-Days</option>
				<option value="90-day">90-Days</option>
				<option value="180-day">180-Days</option>
				<option value="365-day">365-Days</option>
				</select>
				<label for="price"><b>Price</b></label>
				<input type="text" name="price" class="form-control" placeholder="Enter Price" required="required">
				<label for="discount"><b>Discount</b></label>
				<input type="text" name="discount" class="form-control" placeholder="Enter Discount" required="required"><br>
				<input class="btn btn-info" type="submit" value="Save"> <a href="ExcelFileForBulk.jsp" class="btn btn-danger" type="button" style="margin-left: 273px;">Add Data In Bulk</a><br><br>
				<span></span><br>
			</div>		
		</form>
	</div>	
</body>
	<div class="fixed-footer">
		<footer class="bg-secondary text-white" >
		    <div class="text-center p-3" style="background-color: secondary;">
		      © 2023 Copyright:
		      <a style="color: blue;" href="https://irfan.xworkz@gmail.com/">irfan.xworkz@gmail.com</a>  <span style="color: orange;">[LoginTime: ${adminDTOS.loginTime }]</span>
		    </div>
		 </footer>
	</div>	 
</html>