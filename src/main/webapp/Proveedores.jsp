
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<link rel="stylesheet" href="AdminMenu.css">
</head>
<body>
	<%!String mensaje = "";
	long nitproveedor = 0;
	String ciudad_proveedor = "", direccion_proveedor = "", nombre_proveedor = "", telefono_proveedor = "", estado = "";%>
	<div>
		<nav id="navbar">
			<header>CRAFTY</header>
			<div>
				<a class="nav-link" href="AdminMenu.jsp">Admin Menu</a> 
				<a class="nav-link" href="Empleados.jsp">Empleados</a> 
				<a class="nav-link" href="Clientes.jsp">Clientes</a> 
				<a class="nav-link" href="Productos.jsp">Productos</a> 
				<a class="nav-link" href="Ventas.jsp">Ventas</a>
				<a class="nav-link" href="Reportes.jsp">Reportes</a>
				<a class="nav-link" href="Index.jsp">Home</a>
			</div>
		</nav>
		<main id="main-doc">
			<section class="main-section" id="welcome">
				<header>Manejo Proveedores</header>

				<%
				//Sirve como una validaci�n del bot�n Consultar
				if (request.getParameter("nitproveedor") != null) {
					nitproveedor = Long.parseLong(request.getParameter("nitproveedor"));
					nombre_proveedor = request.getParameter("nombre_proveedor");
					direccion_proveedor = request.getParameter("direccion_proveedor");
					telefono_proveedor = request.getParameter("telefono_proveedor");
					ciudad_proveedor = request.getParameter("ciudad_proveedor");
					estado = "disabled";
				}
				%>

				<%
				//Sirve como una validaci�n del bot�n crear, actualizar y eliminar
				if (request.getParameter("men") != null) {
					nitproveedor = 0;
					nombre_proveedor = "";
					direccion_proveedor = "";
					telefono_proveedor = "";
					ciudad_proveedor = "";
					estado = "";
					mensaje = request.getParameter("men");
					out.print("<script>alert('" + mensaje + "');</script>");//Mensaje con alert js
				}
				%>

				<form action="Proveedor" method="post">
					<fieldset>
						<legend>Datos del Empleado</legend>
						<div>
							<label>NIT: </label><input class="inputs" type="number" name="nitproveedor"
								value="<%=nitproveedor%>" required <%=estado%>>
						</div>
						<input type="hidden" name="nit_prov"
							value="<%=nitproveedor%>">
						<div>
							<label>Nombre Proveedor: </label><input class="inputs" type="text"
								name="nombre_proveedor" value="<%=nombre_proveedor%>" required>
						</div>
						<div>
							<label>Direccion: </label><input class="inputs" type="text"
								name="direccion_proveedor" value="<%=direccion_proveedor%>" required>
						</div>
						<div>
							<label>Telefono: </label><input class="inputs" type="text"
								name="telefono_proveedor" value="<%=telefono_proveedor%>" required>
						</div>
						<div>
							<label>Ciudad: </label><input class="inputs" type="text" name="ciudad_proveedor"
								value="<%=ciudad_proveedor%>" required>
						</div>
						<div>
							<input class="botones" type="submit" name="crear" value="Crear"> <input class="botones"
								type="submit" name="actualizar" value="Actualizar"> <input class="botones"
								type="submit" name="borrar" value="Borrar">
						</div>
					</fieldset>
				</form>

				<form action="Proveedor" method="post">
					<fieldset>
						<legend>Consultar</legend>
						<div>
							<label>Cedula: </label><input class="inputs" type="number" name="nit"
								required>
						</div>
						<input class="botones" type="submit" name="consultar" value="Consultar">
					</fieldset>
				</form>

			</section>
		</main>
	</div>
</body>
</html>
