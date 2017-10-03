<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Product Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Product Details</h1>
		</div>
	</div>
	</section>
	<section class="container">
	<div class="row">
		<div class="col-md-5">
			<img src="<c:url value="/img/${product.productId}.png"></c:url>"
				alt="preview" style="width: 100%" />
		</div>
		<div class="col-sm-6 col-md-5" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
					<h3>${product.name}</h3>
					<p>${product.description}</p>
					<p>
						<strong>Item code: </strong> <span class="label label-warning">${product.productId}</span>
					</p>
					<p>
						<strong>Manufacturer: </strong> ${product.manufacturer}
					</p>
					<p>
						<strong>Category: </strong> ${product.category}
					</p>
					<p>
						<strong>Available units in stock: </strong>
						${product.unitsInStock}
					</p>
					<p>
					<h4>${product.unitPrice}USD</h4>
					</p>
					<p>
						<a href="<spring:url value="/market/products"/>"
							class="btn btn-default"> <span
							class="glyphicon-hand-left glyphicon"></span> Back
						</a>
					</p>
					<a href="#" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Order Now
					</a>
				</div>
			</div>
		</div>
	</div>
	</section>
</body>
</html>