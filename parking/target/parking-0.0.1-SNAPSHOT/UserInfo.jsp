<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
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
	
 	function validateFields() {
		var location=document.getElementById("location").value;
		var type=document.getElementById("type").value;
		var classification=document.getElementById("classification").value;
		var terms=document.getElementById("terms").value;
		
		if(location=="" || location==null && type=="" || type==null && classification=="" || classification==null && terms=="" || terms==null){
			document.getElementById('validate').innerHTML="please fill the form";
			return false;
		}else if (location=="" || type =="" || classification =="" || terms =="") {
			document.getElementBy('validate').innerHTML="please fill the missing fields";
			return false;
		}else{
			document.getElementBy('validate').innerHTML="";
			return true;
		}
	}
 
 	function EmailAjax(){
 		console.log("EmailAjax logged-in");
 		var email=document.getElementById("email").value;
 		var url="http://localhost:8080/parking/validateEmail/"+email;
 		console.log(url);
 		const xmlHttp=new XMLHttpRequest();
 		xmlHttp.open("GET", url);
 		xmlHttp.send();
 		xmlHttp.onload=function(){
 			console.log(this.responseText);
 			document.getElementById('display').innerHTML=this.responseText;
 			document.getElementById('here').innerHTML="";
 		}
 	}
 	
 	function ajaxWithObj() {
 		console.log("ajaxWithObj logged-in")
 		var location=document.getElementById("location").value;
 		var type=document.getElementById("type").value;
 		var classification=document.getElementById("classification").value;
 		var terms=document.getElementById("terms").value;
 		var url="http://localhost:8080/parking/getPriceAndDiscount/"+location+"/"+type+"/"+classification+"/"+terms
 		console.log(url);
 		const xmlHttp=new XMLHttpRequest();
 		xmlHttp.open("GET", url);
 		xmlHttp.send();
 		xmlHttp.onload=function(){
 			console.log(this.responseText);
 			var obj=JSON.parse(this.responseText);
 			console.log(obj.price);
 			console.log(obj.discount);
 			document.getElementById("price").value=obj.price;
 			document.getElementById("discount").value=obj.discount;
 			var totalAmount=obj.price-((obj.price*obj.discount)/100);
 			console.log(totalAmount);
 			document.getElementById("totalAmount").value = totalAmount;
 		}
	}
 </script>
<!-- Link of Bootstrap cdn -->     
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">
</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
		    <a  href="UserDetails.jsp" class="btn btn-info" type="button">Home</a>
		    <a style="margin-left: 1000px; color: pink;" class="navbar-brand" >Welcome,${userInfoDTO.name}</a>
		</nav>
	</div>		
</header>
<body>
		
<div class="container">
	<form action="addUser" method="post" onsubmit="return validateFields()" style="background-color: white; margin-top: 10px;margin-bottom: 10px; margin-left: 200px; margin-right: 200px; border: 1px solid black; border-radius: 10px;">
		
		<span style="margin-left: 70px; color: blue;">${usermsg }</span> 	 
	 	<span style="color: red;" id="display"></span><a id="here" href="UserLogin.jsp"></a>
		<h1 style="color: red; text-align: center;" >User Parking Information</h1>
		<div class="container">
			<label for="name"><b>User Name</b></label>
			<input type="text" name="name" value="${userInfoDTO.name}" class="form-control" readonly="readonly">
			<label for="email"><b>User Email</b></label>
			<input type="email" name="email" value="${userInfoDTO.email}" class="form-control" onchange="EmailAjax()" id="email" readonly="readonly">
			<label for="mobile"><b>User Mobile</b></label>
			<input type="number" name="mobile" value="${userInfoDTO.mobile}" class="form-control" readonly="readonly" >
			<label for="location"><b>Vehicle Location</b></label>
					<select name="location" class="form-control" id="location">
					<option value="">Location</option>
					<option value="Rajaji-Nagar">Rajaji-Nagar</option>
					<option value="kurubarahalli">Kurubarahalli</option>
					<option value="btm">BTM</option>
					</select>
			<label for="type"><b>Vehicle Type</b></label>
					<select name="type" class="form-control" id="type">
					<option value="">type</option>
					<option value="2 wheeler">2-Wheeler</option>
					<option value="4 wheeler">4-wheeler</option>
					</select>
			<label for="classification"><b>Vehicle Classification</b></label>	
					<select name="classification" class="form-control" id="classification">
					<option value="">classification</option>
					<option value="bmw">BMW</option>
					<option value="dastun">Dastun</option>
					<option value="benz">Benz</option>
					<option value="bike">Bike</option>
					</select>
			<label for="terms"><b>Vehicle Terms</b></label>		
					<select name="terms" class="form-control" onchange="ajaxWithObj()" id="terms">
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
					<input type="text" name="price" class="form-control" placeholder="price" id="price" readonly="readonly">
			<label for="discount"><b>User Discount</b></label>
					<input type="text" name="discount" class="form-control" placeholder="discount" id="discount" readonly="readonly">
			<label for="totalAmount"><b>User Total Amount</b></label>
					<input type="text" name="totalAmount" class="form-control" placeholder="Total Amount" id="totalAmount" readonly="readonly">
			<div class="form-group form-check">
			    <input type="checkbox" class="form-check-input" id="myCheckbox">
			    <label class="form-check-label" for="myCheckbox">Check for agreement</label>
		 	</div>
	 			 <input type="submit" value="Submit" class="btn btn-info" id="myButton" disabled><br><br>
		</div>
	</form>
</div>
</body>
	<div class="fixed-footer">
		<footer class="bg-secondary text-white">
		    <div class="text-center p-3" style="background-color: secondary;">
		      © 2023 Copyright:
		      <a class="text-white" href="https://irfan.xworkz@gmail.com/">irfan.xworkz@gmail.com <span style="color: orange;">[LoginTime:${userInfoDTO.loginTime }]</span></a>
		    </div>
		 </footer>
	</div>		 
</html>