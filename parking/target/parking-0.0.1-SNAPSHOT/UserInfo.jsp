<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User-Page</title>

<!-- Link of JQuery cdn -->
    <script src= "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> </script>
<!-- Checkbox disable or enable -->        
<script>
	$(document).ready(function () {
		  $('#myCheckbox').click(function () {
		    $('#myButton').prop("disabled", !$("#myCheckbox").prop("checked")); 
		  })
		});
 </script>
 
<!-- Link of Bootstrap cdn -->     
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">
</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
			<img src="https://w7.pngwing.com/pngs/974/17/png-transparent-car-park-parking-computer-icons-parking-text-rectangle-logo-thumbnail.png" alt="" width="60" height="60"> 
		    <a href="Home.jsp" class="btn btn-info" type="button" style="margin-right: 1150px;">Home</a>
		</nav>	
	</div>
</header>
<body>
		
<div class="container">
	<form action="user" method="post" style="background-color: white; margin-top: 10px;margin-bottom: 10px; margin-left: 200px; margin-right: 200px; border: 1px solid black; border-radius: 10px;">
		<h1 style="color: red; text-align: center;" >User Information</h1>
		<div class="container">
			<label for="name"><b>User Name</b></label>
			<input type="text" name="name" placeholder="Enter Name" class="form-control" required="required">
			<label for="email"><b>User Email</b></label>
			<input type="email" name="email" placeholder="Enter Email" class="form-control" required="required">
			<label for="mobile"><b>User Mobile</b></label>
			<input type="number" name="mobile" placeholder="Enter Mobile" class="form-control" required="required">
			<label for="location"><b>User Location</b></label>
					<select name="location" class="form-control">
					<option value="">Location</option>
					<option value="Rajaji-Nagar">Rajaji-Nagar</option>
					<option value="kurubarahalli">Kurubarahalli</option>
					<option value="btm">BTM</option>
					</select>
			<label for="type"><b>User Type</b></label>
					<select name="type" class="form-control">
					<option value="">type</option>
					<option value="2 wheeler">2-Wheeler</option>
					<option value="4 wheeler">4-wheeler</option>
					</select>
			<label for="classification"><b>User Classification</b></label>	
					<select name="classification" class="form-control" >
					<option value="">classification</option>
					<option value="bmw">BMW</option>
					<option value="dastun">Dastun</option>
					<option value="benz">Benz</option>
					<option value="bike">Bike</option>
					</select>
			<label for="terms"><b>User Terms</b></label>		
					<select name="terms" class="form-control">
					<option value="">terms</option>
					<option value="1-day">1-Day</option>
					<option value="7-day">7-Days</option>
					<option value="15-day">15-Days</option>
					<option value="30-day">30-Days</option>
					<option value="90-day">90-Days</option>
					<option value="180-day">180-Days</option>
					<option value="365-day">365-Days</option>
					</select>
			<label for="price"><b> User Price</b></label>		
					<input type="text" name="price" class="form-control" placeholder="price" readonly="readonly">
			<label for="discount"><b>User Discount</b></label>
					<input type="text" name="discount" class="form-control" placeholder="discount">
			<label for="totalAmount"><b>User Total Amount</b></label>
					<input type="text" name="totalAmount" class="form-control" placeholder="Total Amount" disabled="disabled">
			<div class="form-group form-check">
			    <input type="checkbox" class="form-check-input" id="myCheckbox">
			    <label class="form-check-label" for="myCheckbox">Check for agreement</label>
		 	</div>
	 			 <input type="submit" value="Submit" class="btn btn-info" id="myButton" disabled><br><br>
	 			 
	 			 <a style="color: blue; text-align: center;">${usermsg }</a>
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