<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminPanel</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">
	<script>
		var mins=5;
		var secs=mins*60;
		function countdown(){
			setTimeout('Decrement()', 60);	
		} 
			function Decrement(){
				if(document.getElementById){
					minutes=document.getElementById("minutes");
					seconds=document.getElementById("seconds");
					if(seconds<59){
						seconds.value=secs;
					}
					else{
						minutes.value=getminutes();
						seconds.value=getseconds();
					}
					if(min<1) {
						minutes.style.color="red";
						seconds.style.coor="red";
					}
					if(mins<0){
						alert('time up');
						minutes.value=0;
						seconds.value=0;
					}
					else{
						secs--;
						setTimeout('Decrement()', 1000);
					}
				}
			}
			
			function getminutes(){
				mins=Math.floor(secs/60);
				return mins;
			}
			
			function getseconds(){
				retun secs-Math.round(mins*60);
			}
			
	</script>
</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
			<img src="https://w7.pngwing.com/pngs/974/17/png-transparent-car-park-parking-computer-icons-parking-text-rectangle-logo-thumbnail.png" alt="" width="60" height="60">
		    <a  href="Home.jsp" class="btn btn-info" type="button" style="margin-right: 1150px;">Home</a>
		</nav>
	</div>		
</header>
<body >
 	<div class="container">	
 		
 		<form method="post" action="${pageContext.request.contextPath}/user-login"  style="background-color: white; margin-top: 50px; margin-left: 200px; margin-right: 200px; border: 1px solid black; border-radius: 10px;">		
		
				<span></span><br>
				<span style="color: green;">${otpmsg }</span>
				<span style="color: red;">${otpmsg1 }</span>
				<h1 style="text-align: center; color: red;">User Login Panel</h1>
			<div class="container">
			<label for="email"><b>Email Address</b></label>	
			    <input type="email" name="email" class="form-control" placeholder="Enter Email">
			    <input type="submit" value="Send OTP" name="otp"  onclick="countdown();" class="btn btn-info" >
			    <span style="color: red;"> 
			    <input id="minutes" type="text" style="width: 5%; border: none; font-size: 16px; font-weight: bold;"> 
			    <font size="5"> : </font> 
			    <input id="seconds" type="text" style="width: 5%; border: none; font-size: 16px; font-weight: bold;"> </span><br><br>	

			<label for="otp"><b>OTP</b></label>    
			    <input type="text" name="otp" class="form-control" placeholder="Enter OTP"><br>
			 	 <input type="submit" name="login" value="Login" class="btn btn-info"><br>
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