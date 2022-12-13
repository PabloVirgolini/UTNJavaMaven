/**
 * 
 */
 
 function completarFormulario(fila){
	var codigo = $(fila).find(".id").text();
	var nombre = $(fila).find(".maquina").text();
	var fechaAlta = $(fila).find(".fechaApertura").text();
	var fechaCierre = $(fila).find(".fechaCierre").text();
	var descripcion= $(this).data('descripcion');
	
	
	document.getElementById("txtDescripcion").value=descripcion;
	$("#txtCodigo").val(codigo);
	$("#txtMaquina").val(nombre);
	$("#txtFechaAlta").val(fechaAlta);
	$("#txtFechaCierre").val(fechaCierre);
	
}

$(document).ready(function (){
		
		$('#tablaMaquinas').DataTable();
		
//		$("#exampleModal").on("hidden.bs.modal",function(){
//			$('form')[0].reset();
//			$("#txtSector option[selected]").removeAttr('selected');
//		})
//		
		$(document).on('click','.btnEditarFila',function(){
			completarFormulario($(this).closest('tr'));
			$('.btnOcultarEditar').removeAttr('disabled');
			$('.btnOcultarEliminar').attr('disabled', 'disabled');
			
		});
		
		$(document).on('click','.btnVerFila',function(){
			completarFormulario($(this).closest('tr'));
			$('.btnOcultarEditar').removeAttr('disabled');
			$('.btnOcultarEliminar').attr('disabled', 'disabled');
			
		});
		
		$(document).on('click','.btnEliminarFila',function(){
			completarFormulario($(this).closest('tr'));
			$('.btnOcultarEliminar').removeAttr('disabled');
			$('.btnOcultarEditar').attr('disabled','disabled');
			
		});

				
	});