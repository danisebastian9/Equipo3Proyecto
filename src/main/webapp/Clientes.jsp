<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
<link rel="stylesheet" href="AdminMenu.css">
</head>
<body>
<%!String mensaje="";
String direccion="",email="",nombre="",telefono="",estado="";
int codigo=0;
%>
<%
if(request.getParameter("codigo")!=null){
codigo = Integer.parseInt(request.getParameter("codigo"));
direccion = request.getParameter("direccion");
email = request.getParameter("email");
nombre = request.getParameter("nombre");
telefono = request.getParameter("telefono");
estado = "disabled";
}
%>
<%
if(request.getParameter("men")!=null){
codigo=0;
direccion="";
email="";
nombre="";
telefono="";
estado="";
mensaje=request.getParameter("men");
out.print("<script>alert('"+mensaje+"');</script>");//Mensaje con alert js
}
%>
    <div>
        <nav id="navbar">
            <header>CRAFTY</header>
            <div>
                <a class="nav-link" href="AdminMenu.jsp">Admin Menu</a>
                <a class="nav-link" href="Empleados.jsp">Empleados</a>
                <a class="nav-link" href="Productos.jsp">Productos</a>
                <a class="nav-link" href="Proveedores.jsp">Proveedores</a>
                <a class="nav-link" href="Ventas.jsp">Ventas</a>
                <a class="nav-link" href="Index.jsp">Home</a>
            </div>
        </nav>
        <main id="main-doc">
            <section class="main-section" id="welcome">
                <header>Manejo Clientes</header>

                <form action="Clientes" method="post">
                    <div><label for="">Cedula Cliente: </label><input class="inputs" type="number" name="cedula" value="<%=codigo%>" <%=estado%> required></div>
                    <div><input type="hidden" name="cod" value="<%=codigo%>" required></div>
                    <div><label for="">Direccion Cliente: </label><input class="inputs" type="text" name="direccion" value="<%=direccion%>"></div>
                    <div><label for="">Email Cliente: </label><input class="inputs" type="email" name="email" value="<%=email%>"></div>
                    <div><label for="">Nombre Cliente: </label><input class="inputs" type="text" name="nombre" value="<%=nombre%>"></div>
                    <div><label for="">Telefono Cliente: </label><input class="inputs" type="text" name="telefono" value="<%=telefono%>"></div>
                    <div id="botonesClientes">
                        <div><input class="botones" type="submit" name="registrar" value="Registrar"></div>
                        <div><input class="botones" type="submit" name="actualizar" value="Actualizar"></div>
                        <div><input class="botones" type="submit" name="eliminar" value="Eliminar"></div>
                    </div>

                </form>
                <form action="Clientes" method="post">
                    <fieldset>
                        <legend>Consultar</legend>
                        <div><label>Cedula Cliente:</label><input class="inputs" type="number" name="codigo" required></div>
                        <div><input class="botones" type="submit" name="consultar" value="Consultar"></div>
                    </fieldset>
                </form>
            </section>
        </main>
    </div>
</body>
</html>