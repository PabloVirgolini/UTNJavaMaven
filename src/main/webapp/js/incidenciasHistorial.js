/**
 * 
 */
 
 function completarFormulario(fila){
	var codigo = $(fila).find(".id").text();
	var nombre = $(fila).find(".maquina").text();
	var idMaquina = $(fila).find(".idMaquina").text();
	var fechaAlta = $(fila).find(".fechaApertura").text();
	var fechaCierre = $(fila).find(".fechaCierre").text();
	var descripcion= $(this).data('descripcion');
	
	document.getElementById("txtDescripcion").value=descripcion;
	$("#txtCodigo").val(codigo);
	$("#txtMaquina").val(nombre);
	$("#idMaquinaModal").val(idMaquina);
	$("#txtFechaAlta").val(fechaAlta);
	$("#txtFechaCierre").val(fechaCierre);
	
	
}

function habilitarCierre(fila){
	if($(fila).find(".fechaCierre").text() != "-") {
        $('#btnCerrar').attr('disabled', 'disabled');
    } else {
         $('#btnCerrar').removeAttr('disabled');
    }
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
			habilitarCierre($(this).closest('tr'));
			$('.btnOcultarEditar').removeAttr('disabled');
			$('.btnOcultarEliminar').attr('disabled', 'disabled');
			
		});
		
		$(document).on('click','.btnVerFila',function(){
			completarFormulario($(this).closest('tr'));
			habilitarCierre($(this).closest('tr'));
			$('.btnOcultarEditar').attr('disabled', 'disabled');
			$('.btnOcultarEliminar').attr('disabled', 'disabled');
			
		});
		
		$(document).on('click','.btnEliminarFila',function(){
			completarFormulario($(this).closest('tr'));
			habilitarCierre($(this).closest('tr'));
			$('.btnOcultarEliminar').removeAttr('disabled');
			$('.btnOcultarEditar').attr('disabled','disabled');
			
		});
		
		$(document).on('click','.btnCerrarIncidencia',function(){
			window.alert("HIZO CLICK EN CERRAR");
		});

	});