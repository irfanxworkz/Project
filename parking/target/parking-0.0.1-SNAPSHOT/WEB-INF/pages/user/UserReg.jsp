<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>User-Registration</title>
<script type="text/javascript">
	
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">
</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
			<img src="https://w7.pngwing.com/pngs/974/17/png-transparent-car-park-parking-computer-icons-parking-text-rectangle-logo-thumbnail.png" alt="" width="60" height="60"> 
		    <a href="User.jsp" class="btn btn-info" type="button">Home</a>
		    <a href="UserOTP.jsp" class="btn btn-info" type="button" style="margin-right: 1100px;">Login</a>
		</nav>	
	</div>
</header>
<body>
		
<div class="container">
	<form action="userReg" method="post" style="background-color: white; margin-top: 50px; margin-left: 200px; margin-right: 200px; border: 1px solid black; border-radius: 10px;">
		<span></span><br>
		<span style="margin-left: 70px; color: green;">${UserRegMsg }</span>
		<h1 style="text-align: center; color: red;">User Registration</h1>
		<span style="color: red;" id="display"></span><a id="here" href="UserLogin.jsp"></a> 	 
		<div class="container">
			<label for="name"><b>User Name</b></label>
				<input type="text" name="name" placeholder="Enter Name" class="form-control" required="required">
			<label for="email"><b>User Email</b></label>
				<input type="email" name="email" placeholder="Enter Email" class="form-control" onchange="EmailAjax()" id="email" required="required">
			<label for="mobile"><b>User Mobile</b></label>
				<input type="number" name="mobile" placeholder="Enter Mobile" class="form-control" required="required" >
	 			<input type="submit" value="Register" class="btn btn-info" style="margin-top: 10px;"><br>
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