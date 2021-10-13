$(document).ready(function(){
	
	function listarVentas(){
		
		$.ajax({
			type:"post",
			url:"ReporteVentas",
			dataType:"json",
			data:{opcion:"ventas"},
			success: function(result){
				console.log(result);
				var totalGeneral = 0;
				var tabla = document.querySelector("#tabla")
				tabla.innerHTML =''
				tabla.innerHTML+=`<tr>
				<th>Nombre</th>
				<th>Cedula</th>
				<th>Total</th>
				</tr>`
				for(var vent of result){
					totalGeneral += vent.total_venta;
					tabla.innerHTML+=`<tr>
					<td>${vent.nombre_cliente}</td>
					<td>${vent.cedula_cliente_key}</td>
					<td>${vent.total_venta}</td>
					</tr>`
				}
				
				tabla.innerHTML+=`<tr>
				<td>Total</td>
				<td colspan=2>${totalGeneral}</td>
				</tr>`
			}
		});
		
	}
	
	$('.listaVentas').on('click', function(){
		listarVentas();
	})
	
});