
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Menu</title>
<link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
<link rel="stylesheet" href="AdminMenu.css">
</head>
<body>
    <div>
        <nav id="navbar">
            <header>CRAFTY</header>
            <div>
                <a class="nav-link" href="Empleados.jsp">Empleados</a>
                <a class="nav-link" href="Clientes.jsp">Clientes</a>
                <a class="nav-link" href="Productos.jsp">Productos</a>
                <a class="nav-link" href="Proveedores.jsp">Proveedores</a>
                <a class="nav-link" href="Ventas.jsp">Ventas</a>
                <a class="nav-link" href="Index.jsp">Home</a>
            </div>
        </nav>
        <main id="main-doc">
            <section class="main-section" id="welcome">
                <header>Menu Administracion</header>
                <%
                String nombre= request.getParameter("nom");
                %>
                <h2>Bienvenido: <%=nombre %></h2>

                <p>Por favor seleccione la dependencia a la que desea ingresar o si desea regresar al inicio</p>
            </section>
        </main>
    </div>
</body>
</html>