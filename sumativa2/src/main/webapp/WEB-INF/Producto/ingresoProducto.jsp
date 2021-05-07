
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
		   <h1> Ingreso de  Productos </h1>
			<br>
			
			
			
			<form action="/producto/ingresar" method="POST">
			 
			
			  <div class="mb-3">
			    <label for="nombre" class="form-label">Nombre : </label>
			    <input type="text" class="form-control" id="nombre" name="nombre" aria-describedby="nombreHelp" required="required">
			     
			    <div style="color:red"> <c:out value="${nombreError}"></c:out> </div>
			    <div style="color:red"> <c:out value="${nombreErrorLargo}"></c:out> </div>
			  </div>
		
			 
			  <div class="mb-3">
			    <label for="precio" class="form-label">Precio : </label>
			    <input type="text" class="form-control" id="precio" name="precio" required="required">
			     
			     <div style="color:red"> <c:out value="${precioError}"></c:out> </div>
			     <div style="color:red"> <c:out value="${precioErrorLargo}"></c:out> </div>
			  </div>
			  
			  	  
			   <div class="mb-3">
			    <label for="caracteristica" class="form-label">Caracteristica : </label>
			    <input type="text" class="form-control" id="caracteristica" name="caracteristica" required="required">
			    
			    <div style="color:red" > <c:out value="${caracteristicaError}"></c:out> </div>
			    <div  style="color:red"> <c:out value="${caracteristicaErrorLargo}"></c:out> </div>
			  </div>
			  
			   <div class="mb-3">
			       <c:forEach var="categoria" items="${lista_categoria}">
				      <div class="form-check">
				        <input class="form-check-input" value="${categoria.id}" name="categoria" type="checkbox" id="disabledFieldsetCheck">
				        <label class="form-check-label" for="disabledFieldsetCheck">
				          	${categoria.nombre}
				        </label>
					 </div>
					</c:forEach>
				</div>
			  
			  <button type="reset" class="btn btn-danger">Limpiar</button>
			  <button type="submit" class="btn btn-primary">Agregar</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>