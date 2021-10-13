$(document).ready(function(){
	
	function listarClientes(){
		
		$.ajax({
			type:"post",
			url:"Rep_clientes",
			dataType:"json",
			data:{opcion:"clientes"},
			success: function(result){
				console.log(result);
				var tabla = document.querySelector("#tabla")
				tabla.innerHTML =''
				tabla.innerHTML+=`<tr>
				<th>Cedula</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Direccion</th>
				<th>Telefono</th>
				</tr>`
				for(let cli of result){
					tabla.innerHTML+=`<tr>
					<td>${cli.Cedula}</td>
					<td>${cli.Nombre}</td>
					<td>${cli.Email}</td>
					<td>${cli.Direccion}</td>
					<td>${cli.Telefono}</td>
					</tr>`
				}
			}
		});
		
	}
	
	$('.listaClientes').on('click', function(){
		listarClientes();
	})
	
});