<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reportes</title>
<link rel="stylesheet" href="AdminMenu.css">
</head>
<body>
	<div>
		<nav id="navbar">
			<header>CRAFTY</header>
			<div>
				<a class="nav-link" href="AdminMenu.jsp">Admin Menu</a> 
				<a class="nav-link" href="Empleados.jsp">Empleados</a> 
				<a class="nav-link" href="Clientes.jsp">Clientes</a> 
				<a class="nav-link" href="Productos.jsp">Productos</a> 
				<a class="nav-link" href="Ventas.jsp">Ventas</a>
				<a class="nav-link" href="Proveedores.jsp">Proveedores</a>
				<a class="nav-link" href="Index.jsp">Home</a>
			</div>
		</nav>
		<main id="main-doc">
			<section class="main-section" id="welcome">
				<header>Manejo Reportes</header>
				<form action="Reportes" method="post">
				<div>
					<input class="botones" type="submit" name="listadoUsuarios" value="Listado de Usuarios">
					<input class="botones" type="submit" name="listadoClientes" value="Listado de Clientes">
					<input class="botones" type="submit" name="ventasCliente" value="Ventas por Cliente">
				</div>
				</form>
			</section>
		</main>
	</div>
</body>
</html>