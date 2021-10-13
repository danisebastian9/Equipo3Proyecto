$(document).ready(function(){
    function listarUsuarios(){
        $.ajax({
            type:"post",
            url:"Reportes",
            dataType:"json",
            data:{opcion:"usuarios"},
            success: function(result){
                console.log(result)
                var tabla = document.querySelector("#tabla")
                tabla.innerHTML = ''
                ReadableStream.innerHTML += `<tr>
                <th>Cedula</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Usuario</th>
                <th>Contraseña</th>
                </tr>`
                for(let emp of result){
                    tabla.innerHTML += `<tr>
                    <td>${emp.cedula_empleado}</td>
                    <td>${emp.email_empleado}</td>
                    <td>${emp.nombre_empleado}</td>
                    <td>${emp.contrasena}</td>
                    <td>${emp.empleado}</td>
                    </tr>`
                }
            }
        })
    }
    $('.listadoUsuarios').on('click',function(){
        listarUsuarios();
    })
})