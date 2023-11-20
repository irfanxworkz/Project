<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">
	

	<!-- <script type="text/javascript">
		var mint =5;
		var seconds = mint * 60;
		
		function countdown(){
			setTimeout('Decrement()', 50);
		}
		function Decremnet (){
			if(document.getElementById){
				minutes = document.getElementById("minutes");
				second = document.getElementById("seconds");
				if(second < 59){
					 second.value = second;
				} else{
					minutes.value = getminutes();
					secound.value = getseconds();
				}
				if (mint <1){
					minutes.value = getminutes();
					seconds.value = getsecound();
				}
				if (mint < 0){
					alert('time up');
					minutes.value = 0;
					seconds.value = 0;
					
				}else{
					second--;
					setTimeout
					
				}
				
			}
		} 
	</script> -->
	
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
 		
 		<form method="post" action="userlogin"  style="background-color: white; margin-top: 50px; margin-left: 200px; margin-right: 200px; border: 1px solid black; border-radius: 10px;">		
		
				<span></span><br>
				<span style="margin-left: 70px; color: green;">${otpmsg }</span>
				 <span style="color: red;">${msg }</span>
				<h1 style="text-align: center; color: red;">User Login Panel</h1>
			<div class="container">
			<label for="email"><b>Email Address</b></label>	
			    <input type="email" name="email" class="form-control" value="${utp.email}"  readonly="readonly">
			<label for="otp"><b>OTP</b></label> <input id="seconds" type="text" style="width: 5%; border: none; font-size: 16px; font-weight: bold;"><span style="color: red;"><font size="5"> : </font></span><input id="minutes" type="text" style="width: 5%; border: none; font-size: 16px; font-weight: bold;">
			    <input type="text" name="oneTimePassword" class="form-control" placeholder="Enter OTP"><br>
			 	 <input type="submit" value="Login" class="btn btn-info"><br>
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