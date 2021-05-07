
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">

	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-6">
		   <h1> Lista de Categorias </h1>
			<br>
			
			<form:form action="/categoria/actualizar" method="POST" modelAttribute="categoria">
			
			 <div class="mb-3">
			    <form:input type="hidden" path="id" class="form-control"/>
			  </div>
			
			
			  <div class="mb-3">
			    <form:label path="nombre" class="form-label">Nombre : </form:label>
			    <form:input type="text" path="nombre" class="form-control" aria-describedby="nombreHelp" required="required"/>
			  </div>
			  
			
			  <button type="submit" class="btn btn-primary">Actualizar</button>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>