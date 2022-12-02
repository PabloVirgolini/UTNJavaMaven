/**
 * 
 */
 
 function completarFormulario(fila){
	var codigo = $(fila).find(".id").text();
	var nombre = $(fila).find(".nombre").text();
	var apellido = $(fila).find(".apellido").text();
	var email = $(fila).find(".email").text();
	var telefono = $(fila).find(".telefono").text();
	var tipoDNI = $(fila).find(".tipoDoc").text();
	var dni = $(fila).find(".dni").text();
	
	$("#txtCodigo").val(codigo);
	$("#txtNombre").val(nombre);
	$("#txtApellido").val(apellido);
	$("#txtEmail").val(email);
	$("#txtTelefono").val(telefono);
	$("#txtDNI").val(dni);
	$("#txtTipoDoc").val(tipoDNI);

	
}

$(document).ready(function (){
		
		$("#exampleModal").on("hidden.bs.modal",function(){
			$('form')[0].reset();
		})
		
		$(document).on('click','.btnEditarFila',function(){
			completarFormulario($(this).closest('tr'));
			$('.btnOcultarEditar').removeAttr('disabled');
			$('.btnOcultarGuardar').attr('disabled', 'disabled');
			$('.btnOcultarEliminar').attr('disabled', 'disabled');
		});
		
		$(document).on('click','.btnEliminarFila',function(){
			completarFormulario($(this).closest('tr'));
			$('.btnOcultarEliminar').removeAttr('disabled');
			$('.btnOcultarGuardar').attr('disabled','disabled');
			$('.btnOcultarEditar').attr('disabled','disabled');
		});
		
		$(document).on('click','.btnAdd',function(){
			$('.btnOcultarGuardar').removeAttr('disabled');
			$('.btnOcultarEliminar').attr('disabled','disabled');
			$('.btnOcultarEditar').attr('disabled','disabled');
		});
		
	});