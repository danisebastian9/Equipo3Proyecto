<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Admin</title>
<link rel="stylesheet" href="Login.css">
<link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
</head>
<body>
    <form action="Validacion" method="post">
        <div id="fields">
            <div ><label class="labels" for="">User</label><input class="inputs" type="text" name="usuario"></div>
            <div ><label class="labels" for="">Password</label><input class="inputs" type="password" name="password"></div>
            <div><input class="buttons" type="submit" name="enviar" value="Ingresar"></div>
            <div><a href="Index.jsp"><input id="cancel" class="buttons" type="button" value="Cancelar"></a></div>
        </div>
    </form>	
</body>
</html>