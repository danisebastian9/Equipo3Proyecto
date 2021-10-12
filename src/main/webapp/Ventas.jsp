<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
<link rel="stylesheet" href="AdminMenu.css">
</head>
<body>
<%!
long cedula_cliente=0, cedula_empleado=0, consecutivo=0, codigo_venta=0;
double t_venta=0, t_iva=0, t_venta_iva=0;
String nom_cliente="", nom_empleado="", estado="", mensaje="";
int codigo_producto, codProd1 = 0, codProd2 = 0, codProd3 = 0, cantProd1 = 0, cantProd2 = 0, cantProd3 = 0;
double ivacompra1 = 0, ivacompra2 = 0, ivacompra3 = 0, precio_venta, precio_venta2, precio_venta3;
String nombre_producto = "", nombre_producto2 = "", nombre_producto3 = "";
String estado1 = "", estado2 = "", estado3 = "";
%>

    <div>
        <nav id="navbar">
            <header>CRAFTY</header>
            <div>
                <a class="nav-link" href="AdminMenu.jsp">Admin Menu</a>
                <a class="nav-link" href="Empleados.jsp">Empleados</a>
                <a class="nav-link" href="Clientes.jsp">Clientes</a> 
                <a class="nav-link" href="Productos.jsp">Productos</a>
                <a class="nav-link" href="Proveedores.jsp">Proveedores</a>
				<a class="nav-link" href="Reportes.jsp">Reportes</a>
                <a class="nav-link" href="Index.jsp">Home</a>
            </div>
        </nav>
        <main id="main-doc">
            <section class="main-section" id="welcome">
                <header>Manejo Ventas</header>
                
                <% 
				if (request.getParameter("codigo_venta") != null) {
				consecutivo = Long.parseLong(request.getParameter("codigo_venta"));
				codigo_venta = Long.parseLong(request.getParameter("codigo_venta"));
				nom_empleado = request.getParameter("nombre_empleado");
				nom_cliente = request.getParameter("nombre_cliente");
				cedula_empleado = Long.parseLong(request.getParameter("cedula_empleado"));
				cedula_cliente = Long.parseLong(request.getParameter("cedula_cliente"));
				estado = "disabled";
				}
				%>
				
				<%
                if (request.getParameter("men") != null) {
	            mensaje = request.getParameter("men");
	            out.print("<script>alert('" + mensaje + "');</script>");//Mensaje con alert js
                }
                %>
                
                <%
				//Validacion consultar
				if (request.getParameter("codProd1") != null) {
					codProd1 = Integer.parseInt(request.getParameter("codProd1"));
					ivacompra1 = Double.parseDouble(request.getParameter("ivacompra"));
					nombre_producto = request.getParameter("nombre_producto");
					precio_venta = Double.parseDouble(request.getParameter("precio_venta"));
					estado = "disabled";
				}
				%>
				
				<%
				//Validacion consultar
				if (request.getParameter("codProd2") != null) {
					codProd2 = Integer.parseInt(request.getParameter("codProd2"));
					ivacompra2 = Double.parseDouble(request.getParameter("ivacompra2"));
					nombre_producto2 = request.getParameter("nombre_producto2");
					precio_venta2 = Double.parseDouble(request.getParameter("precio_venta2"));
					estado2 = "disabled";
				}
				%>
				
				<%
				//Validacion consultar
				if (request.getParameter("codProd3") != null) {
					codProd3 = Integer.parseInt(request.getParameter("codProd3"));
					ivacompra3 = Double.parseDouble(request.getParameter("ivacompra3"));
					nombre_producto3 = request.getParameter("nombre_producto3");
					precio_venta3 = Double.parseDouble(request.getParameter("precio_venta3"));
					estado3 = "disabled";
				}
				%>

                <form action="Ventas" method="post">
                    <fieldset>
                        <legend>Empleado</legend>
                        <div>
                        	<label for="">Cedula</label>
                        	<input class="inputs" type="number" name="ced_empleado" value="<%=cedula_empleado%>" required>
                        	<label for=""> Empleado</label>
                        	<input class="inputs" type="text" name="nom_empleado" value="<%=nom_empleado%>" <%=estado%>>
                        </div>
                    </fieldset>
                    <fieldset>
                        <legend>Cliente</legend>
                        <div>
                        	<label for="">Cedula</label>
                        	<input class="inputs" type="number" name="ced_cliente" value="<%=cedula_cliente%>" required>
                        	<label for=""> Cliente</label>
                        	<input class="inputs" type="text" name="nom_cliente" value="<%=nom_cliente%>" <%=estado%>>
                        </div>
                    </fieldset>
                    <div>
                    	<input class="botones" type="submit" name="consultar1" value="Consultar">
                    </div>
                    <fieldset>
                        <legend>Venta</legend>
                        <label for="">Consecutivo</label>
                        <input class="inputs" type="number" name="consecutivo" value="<%=consecutivo%>" <%=estado%>>
                        <input type="hidden" name="consec" value="<%=consecutivo%>">
                        <input type="hidden" name="codigoVenta" value="<%=codigo_venta%>">
                        <div class="lineaProd">
                            <div class="labVenta">
                            	<label for="codProd">Codigo Producto</label>
                            	<label for="nomProd">Nombre Producto</label>
                            	<label for="preProd">Precio Producto</label>
                            	<label for="cantProd">Cantidad</label>
                            	<label for="totalProd">Valor Total</label>
                            </div>
                            <div>
                            	<input class="inputs" type="text" name="codProd1" id="codProd1" value="<%=codProd1%>"  required >
                            	<input class="botones" type="submit" name="consulta2" value="Consultar">
                            	<input class="inputs" type="text" name="nomProd1" id="nomProd1" value="<%=nombre_producto%>">
                            	<input class="inputs" type="number" name="preProd1" id="preProd1" value="<%=precio_venta%>">
                            	<input class="inputs" type="number" name="cantProd1" id="cantProd1" value="<%=cantProd1%>" onchange="calcular1()">
                            	<input class="inputs" type="number" name="totalProd1" id="totalProd1">
                            	<input type="hidden" name="ivacompra1" id="ivacompra1" value="<%=ivacompra1%>">
								<input type="hidden" name="valoriva1" id="valoriva1">
								<input type="hidden" name="valorventa1" id="valorventa1">
                            </div>
                            <div>
                            	<input class="inputs" type="text" name="codProd2" id="codProd2" value="<%=codProd2%>">
                            	<input class="botones" type="submit" name="consulta3" value="Consultar">
                            	<input class="inputs" type="text" name="nomProd2" id="nomProd2" value="<%=nombre_producto2%>">
                            	<input class="inputs" type="number" name="preProd2" id="preProd2" value="<%=precio_venta2%>">
                            	<input class="inputs" type="number" name="cantProd2" id="cantProd2" value="<%=cantProd2%>" onchange="calcular2()">
                            	<input class="inputs" type="number" name="totalProd2" id="totalProd2" >
                            	<input type="hidden" name="ivacompra2" id="ivacompra2" value="<%=ivacompra2%>">
								<input type="hidden" name="valoriva2" id="valoriva2">
								<input type="hidden" name="valorventa2" id="valorventa2">                            </div>
                            <div>
                            	<input class="inputs" type="text" name="codProd3" id="codProd3" value="<%=codProd3%>">
                            	<input class="botones" type="submit" name="consulta4" value="Consultar">
                            	<input class="inputs" type="text" name="nomProd3" id="nomProd3" value="<%=nombre_producto3%>">
                            	<input class="inputs" type="number" name="preProd3" id="preProd3" value="<%=precio_venta3%>">
                            	<input class="inputs" type="number" name="cantProd3" id="cantProd3" value="<%=cantProd3%>" onchange="calcular3()">
                            	<input class="inputs" type="number" name="totalProd3" id="totalProd3">
                            	<input type="hidden" name="ivacompra3" id="ivacompra3" value="<%=ivacompra3%>">
								<input type="hidden" name="valoriva3" id="valoriva3">
								<input type="hidden" name="valorventa3" id="valorventa3">
                            </div>
                            <div>
                            	<input class="botones" type="button" onclick="calcularTotal()" name="Calcular" value="Calcular">
                            </div>
                            <div>
                                <div>
                                	<label for="totalVenta">Total Venta</label>
                                	<input class="inputs" type="number" name="totalVenta" id="totalVenta">
                                </div>
                                <div>
                                	<label for="totalIva">Total Iva</label>
                                	<input class="inputs" type="number" name="totalIva" id="totalIva">
                                </div>
                                <div>
                                	<label for="totalConIva">Total con Iva</label>
                                	<input class="inputs" type="number" name="totalConIva" id="totalConIva">
                                </div>
                            </div>
                            <input class="botones" type="submit" name="registrarVenta" value="Registrar Venta">
                        </div>
                    </fieldset>
                </form>
            </section>
        </main>
    </div>
    
      <script>
    
    	function calcular1(){
    		var precio = document.getElementById("preProd1").value;
    		var cantidad = document.getElementById("cantProd1").value;
    		document.getElementById("totalProd1").value = precio * cantidad;
    	}
    	function calcular2(){
    		var precio = document.getElementById("preProd2").value;
    		var cantidad = document.getElementById("cantProd2").value;
    		document.getElementById("totalProd2").value = precio*cantidad;
    	}
    	function calcular3(){
    		var precio = document.getElementById("preProd3").value;
    		var cantidad = document.getElementById("cantProd3").value;
    		document.getElementById("totalProd3").value = precio*cantidad;
    	}
    	
    	function calcularTotal(){
    		var precioTotal = 0;
    		var valorIVA1 = 0, valorIVA2 = 0, valorIVA3 = 0;
    		var subtotal1 = 0, subtotal2 = 0, subtotal3 = 0;
    		if(document.getElementById("codProd1").value != 0){
    			subtotal1 += document.getElementById("totalProd1").value / ((document.getElementById("ivacompra1").value / 100) + 1);
    			document.getElementById("valorventa1").value = subtotal1;
    			valorIVA1 += (document.getElementById("totalProd1").value / ((document.getElementById("ivacompra1").value / 100) + 1) * document.getElementById("ivacompra1").value) / 100;
    			document.getElementById("valoriva1").value = valorIVA1;
    			precioTotal += (subtotal1 + valorIVA1);
    		}
    		
    		if(document.getElementById("codProd2").value != 0){
    			subtotal2 += document.getElementById("totalProd2").value / ((document.getElementById("ivacompra2").value / 100) + 1);
    			document.getElementById("valorventa2").value = subtotal2;
    			valorIVA2 += (document.getElementById("totalProd2").value / ((document.getElementById("ivacompra2").value / 100) + 1) * document.getElementById("ivacompra2").value) / 100;
    			document.getElementById("valoriva2").value = valorIVA2;
    			precioTotal += (subtotal2 + valorIVA2);
    		}
    		
    		if(document.getElementById("codProd3").value != 0){
    			subtotal3 += document.getElementById("totalProd3").value / ((document.getElementById("ivacompra3").value / 100) + 1);
    			document.getElementById("valorventa3").value = subtotal3;
    			valorIVA3 += (document.getElementById("totalProd3").value / ((document.getElementById("ivacompra3").value / 100) + 1) * document.getElementById("ivacompra3").value) / 100;
    			document.getElementById("valoriva3").value = valorIVA3;
    			precioTotal += (subtotal3 + valorIVA3);
    		}
    		
    		document.getElementById("totalVenta").value = Math.round(subtotal1 + subtotal2 + subtotal3);
    		document.getElementById("totalIva").value = Math.round(valorIVA1 + valorIVA2 +valorIVA3); 
    		document.getElementById("totalConIva").value = precioTotal;
    		
    	}
    	
	</script>
</body>
</html>