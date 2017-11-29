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
<title><spring:message code="addProduct.form.pageTitle.label"></spring:message></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<section>
		<div class="pull-right" style="padding-right: 50px">
			<a href="?lang=en">English</a>|<a href="?lang=vi">Vietnamese</a>
		</div>
	</section>
	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Webstore login</h1>
		</div>
	</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							Sign In
						</h3>
					</div>
					<div class="panel-body">
						<c:url var="loginUrl" value="/login"></c:url>
						<form action="${loginUrl}" method="post" class="form-horizontal">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid username or password</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null }">
								<div class="alert alert-success">
									<p>You have been logout</p>
								</div>
							</c:if>
							<c:if test="${param.accessDenied != null }">
								<div class="alert alert-success">
									<p>403: access denied</p>
								</div>
							</c:if>
							<div class="input-group">
								<label for="userName">Username</label>
								<input type="text" class="form-control" id="userName" name="userName"/>
								<br/>
								<label for="userName">Password</label>
								<input type="password" class="form-control" id="password" name="password"/>
								
							</div>
							<div class="form-actions">
								<br/>
								<input type="submit" class="btn btn-block btn-primary" value="Log in"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>