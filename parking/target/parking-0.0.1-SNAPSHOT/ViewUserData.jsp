<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		    <a  href="UserDetails.jsp" class="btn btn-info" type="button">Home</a>
		    <a style="margin-left: 1000px; color: pink;" class="navbar-brand" >Welcome,${userInfoDTO.name}</a>
		</nav>
	</div>		
</header>
<body>
				<h1 style="color: green; text-align: center;">User information</h1>
	  <table class="table" id="customers">
		<tr >
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Mobile</th>	
			<th>UserId</th>
			<th>Location</th>
			<th>Type</th>
			<th>Classification</th>
			<th>Terms</th>
			<th>totalAmount</th>
			<th>Edit</th>
		</tr>
			<tr>
				<td>${userInfoDTO.id }</td>
				<td>${userInfoDTO.name }</td>
				<td>${userInfoDTO.email }</td>
				<td>${userInfoDTO.mobile }</td>
			<c:forEach items="${userParkingInfoDTO}" var="pud">
				<td>${pud.userId }</td>
				<td>${pud.location}</td>
				<td>${pud.type}</td>
				<td>${pud.classification}</td>
				<td>${pud.terms}</td>
				<td>${pud.totalAmount}</td>	
				<td><a  href="UpdateUserInfo.jsp" class="btn btn-info" type="button">Edit</a></td>
			</c:forEach>	
 			</tr>
	</table>
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