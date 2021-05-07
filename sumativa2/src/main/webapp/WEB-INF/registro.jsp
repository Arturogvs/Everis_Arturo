<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container col-lg-4">
		<br>
		<h2> Registro de Usuario</h2>
		<br><hr><br>
		<form:form action="/user/guardar" method="post" modelAttribute="user">
			<form:label path="usuario">Usuario: </form:label>
			<form:input path="usuario" class="form-control mb-4"></form:input>
			<br>
			<form:label path="rol">Rol: </form:label>
			<form:input class="form-control mb-4" path="rol"></form:input>
			<br>
			<form:label path="email">Email: </form:label>
			<form:input  class="form-control mb-4" path="email"></form:input>
<br>
			<form:label path="pass">Password: </form:label>
			<form:password  class="form-control mb-4" path="pass"></form:password>
<br>
	
			<input type="submit" value="Registrar!">
		</form:form>
	</div>
</body>
</html>