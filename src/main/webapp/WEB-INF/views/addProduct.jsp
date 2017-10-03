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
			<h1>Add Product</h1>
		</div>
	</div>
	</section>
	<section class="container"> <form:form method="POST"
		modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
		<fieldset>
			<legend>Add new product</legend>
			<div class="form-group">
				<label class="control-label col-lg-2" for="productId">
					<spring:message code="addProduct.form.productId.label"></spring:message>
				</label>
				<div class="col-lg-10">
					<form:input path="productId" id="productId" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="name"><spring:message code="addProduct.form.name.label"></spring:message>
					</label>
				<div class="col-lg-10">
					<form:input path="name" id="name" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="unitPrice">
					<spring:message code="addProduct.form.unitPrice.label"></spring:message></label>
				<div class="col-lg-10">
					<form:input path="unitPrice" id="unitPrice" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="manufacturer"><spring:message code="addProduct.form.manufacturer.label"></spring:message>
					</label>
				<div class="col-lg-10">
					<form:input path="manufacturer" id="manufacturer" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="category"><spring:message code="addProduct.form.category.label"></spring:message>
					</label>
				<div class="col-lg-10">
					<form:input path="category" id="category" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="unitsInStock"><spring:message code="addProduct.form.inStock.label"></spring:message>
					</label>
				<div class="col-lg-10">
					<form:input path="unitsInStock" id="unitsInStock" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="unitsInOrder"><spring:message code="addProduct.form.inOrder.label"></spring:message>
					</label>
				<div class="col-lg-10">
					<%-- <form:input path="unitsInOrder" id="unitsInOrder" type="text"
						class="form:input-large" /> --%>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="description">
					<spring:message code="addProduct.form.description.label"></spring:message></label>
				<div class="col-lg-10">
					<form:textarea path="description" id="description" rows="3" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="discounted">
					<spring:message code="addProduct.form.discounted.label"></spring:message></label>
				<div class="col-lg-10">
					<%-- <form:checkbox path="discounted" id="discounted" /> --%>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="condition">
					<spring:message code="addProduct.form.condition.label"></spring:message></label>
				<div class="col-lg-10">
					<form:radiobutton path="condition" value="New" />New
					<form:radiobutton path="condition" value="Old" />Old
					<form:radiobutton path="condition" value="Refurbished" />Refurbished
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="condition">
					<spring:message code="addProduct.form.productImage.label"></spring:message></label>
				<div class="col-lg-10">
					<form:input id="productImage" path="productImage" type="file" class="form:input-large"></form:input>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2" for="condition">
					<spring:message code="addProduct.form.productGuide.label"></spring:message></label>
				<div class="col-lg-10">
					<form:input id="productGuide" path="productGuide" type="file" class="form:input-large"></form:input>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btn-add" class="btn btn-primary" value="Add"/>
				</div>
			</div>
		</fieldset>
	</form:form> </section>
</body>
</html>