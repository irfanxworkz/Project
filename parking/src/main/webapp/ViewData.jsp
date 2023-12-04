<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		    <a  href="AdminDetails.jsp" class="btn btn-info" type="button">Home</a>
		    <a style="margin-left: 1000px; color: pink;" class="navbar-brand" >Welcome,${adminDTOS.name}</a>
		</nav>
	</div>		
</header>
<body>
	<div class="container">
		<form action="view" method="get" class="form-inline" style="margin-left: 420px; margin-bottom: 20px;">
				<select name="location" class="form-control mr-sm-2" aria-label="Search">
					<option value="">location</option>
					<option value="rajaji-nagar">Rajaji-Nagar</option>
					<option value="kurubarahalli">Kurubarahalli</option>
					<option value="btm">BTM</option>
				</select>			
					<button class="btn btn-info my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
	<h1 style="color: red; text-align: center;">Parking info</h1>
	<table class="table" id="customers">
		<tr >
			<th>Id</th>
			<th>Location</th>
			<th>Type</th>
			<th>Classification</th>
			<th>Terms</th>
			<th>Price</th>
			<th>Discount</th>
		</tr>
		<c:forEach items="${list}" var="detail">
			<tr>
				<td>${detail.id }</td>
				<td>${detail.location }</td>
				<td>${detail.type }</td>
				<td>${detail.classification }</td>
				<td>${detail.terms }</td>
				<td>${detail.price }</td>
				 <td>${detail.discount }</td>
			</tr>
		</c:forEach>
	</table>
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