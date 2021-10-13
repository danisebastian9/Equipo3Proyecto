<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/reportes.js"></script>
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
				<div id="botonesReportes">
					<div><button class="listadoUsuarios" >Listado de Usuarios</button></div>
					<div><button class="botones" id="listadoClientes">Listado de Clientes</button></div>
					<div><button class="botones" id="ventasClientes">Ventas por Cliente</button></div>
				</div>
			</section>
			<table id="tabla">

			</table>
		</main>
	</div>
</body>
</html>