<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User-Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="Parking.css">

</head>
<header>
	<div class="fixed-header">
		<nav class="navbar navbar-dark bg-secondary justify-content-between">
			<a  href="Home.jsp" class="btn btn-info" type="button">Home</a>
		    <%-- <img src="data:image/png;base64,${Base64.getEncoder().encodeToString(UserInfoEntity.profilePicture)}" alt="User Picture" width="60" height="60"> --%>
		    <a style="margin-left: 950px; color: pink;" class="navbar-brand">Welcome,${userInfoDTO.name}</a>
	 		<a href="UserOTP.jsp" class="btn btn-info" type="button">Logout</a>
 		</nav>
	</div>	
</header>
<body>
			<pre>	
			<a href="UserInfo.jsp" class="btn btn-info" type="button">Add Parking Info</a>
			 </pre>
			<form action="userParkingView" method="post">
		  	<pre>
		  	<button value="${userInfoDTO.email}" name="viewParkingInfo" class="btn btn-info" type="submit">View Parking Info</button>
		  	</pre>
			</form>
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