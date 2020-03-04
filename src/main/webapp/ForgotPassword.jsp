<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NewPassword</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-primary bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarTogglerDemo01"
		aria-controls="navbarTogglerDemo01" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	</nav>
	<form action="Forgot.do" method="post">
	<div class="container w-80%">
	<div class="card-body" align="front">

	<h2 class="card-title" font="bold">
	<b>NewPassword</b>
	</h2>

	<div class="form-group">
		<div class="form-group col-md-6">
		<label for="email"></label>Email<input name="email" type="text"
		class="form-control" placeholder="email"
		id="email">
	</div>
	
	<div class="form-group">
		<div class="form-group col-md-6">
		<label for="password"></label>Password<input name="password" type="password"
		class="form-control" placeholder="password"
		id="password">
	</div>
	
	<div class="form-group">
		<div class="form-group col-md-6">
		<label for="conformpassword"></label>ConformPassword<input name="conformpassword" type="text"
		class="form-control" placeholder="conformpassword"
		id="conformpassword">
	</div>
	
	<button type="Reset" class="btn btn-success">Reset</button>

	</div>
	
	<div class="text-center" align="center">
	<span style="color: green; font-family: cursive;">${successMessage}</span>
	<span style="color: red; font-family: cursive;">${failureMessage}</span>
	</div>
	
	
	
</form>
</body>
</html>