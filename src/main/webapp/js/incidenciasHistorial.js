/**
 * 
 */
 
 //function completarFormulario(fila){
//	var codigo = $(fila).find(".id").text();
//	var nombre = $(fila).find(".nombre").text();
//	var seccion = $(fila).find(".seccion").text();
//	var fechaAlta = $(fila).find(".fechaAlta").text();
//	
//
//	$("#txtCodigo").val(codigo);
//	$("#txtNombre").val(nombre);
//	$("#txtFechaAlta").val(fechaAlta);
//	
//	$("#txtSector option[selected]").removeAttr('selected');
//	$("#txtSector option:contains("+seccion+")").attr('selected',true);
	
//}

$(document).ready(function (){
		
		$('#tablaMaquinas').DataTable();
		
//		$("#exampleModal").on("hidden.bs.modal",function(){
//			$('form')[0].reset();
//			$("#txtSector option[selected]").removeAttr('selected');
//		})
//		
//		$(document).on('click','.btnEditarFila',function(){
//			completarFormulario($(this).closest('tr'));
//			$('.btnOcultarEditar').removeAttr('disabled');
//			$('.btnOcultarGuardar').attr('disabled', 'disabled');
//			$('.btnOcultarEliminar').attr('disabled', 'disabled');
//			
//		});
//		
//		$(document).on('click','.btnEliminarFila',function(){
//			completarFormulario($(this).closest('tr'));
//			$('.btnOcultarEliminar').removeAttr('disabled');
//			$('.btnOcultarGuardar').attr('disabled','disabled');
//			$('.btnOcultarEditar').attr('disabled','disabled');
//			
//		});
//		
//		$(document).on('click','.btnAdd',function(){
//			$('.btnOcultarGuardar').removeAttr('disabled');
//			$('.btnOcultarEliminar').attr('disabled','disabled');
//			$('.btnOcultarEditar').attr('disabled','disabled');
//			
//		});
				
	});