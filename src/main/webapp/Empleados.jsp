
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleados</title>
<link rel="stylesheet" href="AdminMenu.css">
</head>
<body>
	<%!String mensaje = "";
	long cedula_empleado = 0;
	String nombre_empleado = "", email_empleado = "", empleado = "", contrasena = "", estado = "";%>
	<div>
		<nav id="navbar">
			<header>CRAFTY</header>
			<div>
				<a class="nav-link" href="AdminMenu.jsp">Admin Menu</a> 
				<a class="nav-link" href="Clientes.jsp">Clientes</a> 
				<a class="nav-link" href="Productos.jsp">Productos</a> 
				<a class="nav-link" href="Proveedores.jsp">Proveedores</a>
				<a class="nav-link" href="Ventas.jsp">Ventas</a>
				<a class="nav-link" href="Index.jsp">Home</a>
			</div>
		</nav>
		<main id="main-doc">
			<section class="main-section" id="welcome">
				<header>Manejo Empleados</header>

				<%
				//Trae los datos de la consulta y hace una validaci�n
				if (request.getParameter("cedula_empleado") != null) {
					cedula_empleado = Long.parseLong(request.getParameter("cedula_empleado"));
					nombre_empleado = request.getParameter("nombre_empleado");
					email_empleado = request.getParameter("email_empleado");
					empleado = request.getParameter("empleado");
					contrasena = request.getParameter("contrasena");
					estado = "disabled";
				}
				%>

				<%
				//Sirve como una validaci�n de la actualizaci�n y del bot�n crear
				if (request.getParameter("men") != null) {
					cedula_empleado = 0;
					nombre_empleado = "";
					email_empleado = "";
					empleado = "";
					contrasena = "";
					estado = "";
					mensaje = request.getParameter("men");
					out.print("<script>alert('" + mensaje + "');</script>");//Mensaje con alert js
				}
				%>

				<form action="Empleado" method="post">
					<fieldset>
						<legend>Datos del Empleado</legend>
						<div>
							<label>Cedula: </label><input type="number" class="inputs"
								name="cedula_empleado" value="<%=cedula_empleado%>" required
								<%=estado%>>
						</div>
						<input type="hidden" name="ced_empleado"
							value="<%=cedula_empleado%>">
						<div>
							<label>Nombre Completo: </label><input type="text" class="inputs"
								name="nombre_empleado" value="<%=nombre_empleado%>" required>
						</div>
						<div>
							<label>Correo Electronico: </label><input type="text" class="inputs"
								name="email_empleado" value="<%=email_empleado%>" required>
						</div>
						<div>
							<label>Usuario: </label><input type="text" name="empleado" class="inputs"
								value="<%=empleado%>" required>
						</div>
						<div>
							<label>Contrasena: </label><input type="password" class="inputs"
								name="contrasena" value="<%=contrasena%>" required>
						</div>
						<div>
							<input class="botones" type="submit" name="crear" value="Crear"> <input
							class="botones" type="submit" name="actualizar" value="Actualizar"> <input
							class="botones" type="submit" name="borrar" value="Borrar">
						</div>
					</fieldset>
				</form>

				<form action="Empleado" method="post">
					<fieldset>
						<legend>Consultar</legend>
						<div>
							<label>Cedula: </label><input type="number" name="cedula" class="inputs"
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