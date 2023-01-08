/**
 * 
 */
 
 function completarFormulario(fila){
	var codigo = $(fila).find(".id").text().trim();
	var nombre = $(fila).find(".nombre").text().trim();
	var apellido = $(fila).find(".apellido").text().trim();
	var email = $(fila).find(".email").text().trim();
	var telefono = $(fila).find(".telefono").text().trim();
	var tipoDNI = $(fila).find(".tipoDoc").text().trim();
	var dni = $(fila).find(".dni").text().trim();
	var cargo = $(fila).find(".cargo").text().trim();
	
	$("#txtCodigo").val(codigo);
	$("#txtNombre").val(nombre);
	$("#txtApellido").val(apellido);
	$("#txtEmail").val(email);
	$("#txtTelefono").val(telefono);
	$("#txtDNI").val(dni);
	$("#txtTipoDoc").val(tipoDNI);
	
	$("#txtCargo option[selected]").removeAttr('selected');
	$("#txtCargo option:contains("+cargo+")").attr('selected',true);

	
}

$(document).ready(function (){
		
		$("#exampleModal").on("hidden.bs.modal",function(){
			$('form')[0].reset();
			$("#txtCargo option[selected]").removeAttr('selected');
		})
		
		$(document).on('click','.btnEditarFila',function(){
			completarFormulario($(this).closest('tr'));
			$('.btnOcultarEditar').removeAttr('disabled');
			$('.btnAsignarCargo').removeAttr('disabled');
			$('.btnOcultarGuardar').attr('disabled', 'disabled');
			$('.btnOcultarEliminar').attr('disabled', 'disabled');
			$('.btnAgregar').attr('disabled', 'disabled');
			$('.btnEliminar').attr('disabled', 'disabled');
			$('.cbbCargo').removeAttr('disabled');
			$('.listboxRolesRestantes').removeAttr('disabled');
			$('.listboxRolesActuales').removeAttr('disabled');
		});
		
		$(document).on('click','.btnEliminarFila',function(){
			completarFormulario($(this).closest('tr'));
			$('.btnOcultarEliminar').removeAttr('disabled');
			$('.btnOcultarGuardar').attr('disabled','disabled');
			$('.btnOcultarEditar').attr('disabled','disabled');
			$('.btnAsignarCargo').attr('disabled','disabled');
			$('.cbbCargo').attr('disabled','disabled');
			$('.btnAgregar').attr('disabled','disabled');
			$('.btnEliminar').attr('disabled','disabled');
			$('.listboxRolesRestantes').attr('disabled','disabled');
			$('.listboxRolesActuales').attr('disabled','disabled');
		});
		
		$(document).on('click','.btnAdd',function(){
			$('.btnOcultarGuardar').removeAttr('disabled');
			$('.btnOcultarEliminar').attr('disabled','disabled');
			$('.btnOcultarEditar').attr('disabled','disabled');
			$('.btnAsignarCargo').attr('disabled','disabled');
			$('.cbbCargo').attr('disabled','disabled');
			$('.btnAgregar').attr('disabled','disabled');
			$('.btnEliminar').attr('disabled','disabled');
			$('.listboxRolesRestantes').attr('disabled','disabled');
			$('.listboxRolesActuales').attr('disabled','disabled');
		});
		
		$(document).on('click','.listboxRolesRestantes',function(){
			if (document.getElementById('listboxRolesRestantes').value != '') 
			    {
			        $('.btnAgregar').removeAttr('disabled');
			        $('.btnEliminar').attr('disabled','disabled');
			        document.getElementById('listboxRolesActuales').value="";
			        $("#txtRolAgregar").val(document.getElementById('listboxRolesRestantes').value);
			    }
		});
		
		$(document).on('click','.listboxRolesActuales',function(){
			if (document.getElementById('listboxRolesActuales').value != '') 
			    {
					$('.btnAgregar').attr('disabled','disabled');
			        $('.btnEliminar').removeAttr('disabled');
			        document.getElementById('listboxRolesRestantes').value="";
			        $("#txtRolRetirar").val(document.getElementById('listboxRolesActuales').value);
			    }
		});
		
	});