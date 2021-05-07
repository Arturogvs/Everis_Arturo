
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

<c:if test="${registrado == 1  }">
<div class="container">

	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-6">
		   <h1> Ingreso de  Usuario </h1>
			<br>
			
			
			
			<form action="/user/ingreso" method="POST">
			 
			
			  <div class="mb-3">
			    <label for="usuario" class="form-label">Usuario : </label>
			    <input type="text" class="form-control" id="usuario" name="usuario" aria-describedby="usuarioHelp" required="required">
			     
			    <div style="color:red"> <c:out value="${usuarioError}"></c:out> </div>
			    <div style="color:red"> <c:out value="${usuarioErrorLargo}"></c:out> </div>
			  </div>
		
			 
			  <div class="mb-3">
			    <label for="pass" class="form-label">Password : </label>
			    <input type="text" class="form-control" id="pass" name="pass" required="required">
			     
			     <div style="color:red"> <c:out value="${passError}"></c:out> </div>
			     <div style="color:red"> <c:out value="${passErrorLargo}"></c:out> </div>
			  </div>
			  
			  	<div class="mb-3">
			    <label for="email" class="form-label">email : </label>
			    <input type="text" class="form-control" id="email" name="email" required="required">
			    
			    <div style="color:red" > <c:out value="${emailError}"></c:out> </div>
			    <div  style="color:red"> <c:out value="${emailErrorLargo}"></c:out> </div>
			  </div>
			  	  
			   <div class="mb-3">
			    <label for="rol" class="form-label">Rol : </label>
			    <input type="text" class="form-control" id="rol" name="rol" required="required">
			    
			    <div style="color:red" > <c:out value="${rolError}"></c:out> </div>
			    <div  style="color:red"> <c:out value="${rolErrorLargo}"></c:out> </div>
			  </div>
			  
			  <button type="reset" class="btn btn-danger">Limpiar</button>
			  <button type="submit" class="btn btn-primary">Agregar</button>
			</form>
		</div>
	</div>
</div>
</c:if>
	<c:if test="${registrado != 1}">
		<c:redirect url="/login"/>
	</c:if>
</body>
</html>