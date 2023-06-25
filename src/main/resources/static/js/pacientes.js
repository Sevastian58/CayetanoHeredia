/* ABRIR NUEVO PACIENTE VISTA */
$(document).on("click", "#pacientes-main-nuevo-paciente-vista-abrir", function(e)
{
	$("#NombresPaciente").val("");
	$("#ApellidosPaciente").val("");
	$("#DNIPaciente").val("");
	$("#EdadPaciente").val("");
	$("#CorreoPaciente").val("");
	$("#TelefonoPaciente").val("");
	$("#SexoPaciente").val("");
    $("#pacientes-main-nuevo-paciente-vista").show();
});

//ver datos de pacientes
$(document).on("click", ".verDatos", function(e)
{
    $("#pacientes-main-nuevo-paciente-vista").show();
});
//modificar algunos datos de pacientes
$(document).on("click", ".modificar", function(e)
{
    $("#pacientes-main-modificar-paciente-vista").show();
});

/* CERRAR NUEVO PACIENTE VISTA */
$(document).on("click", "#pacientes-main-nuevo-paciente-vista-cerrar", function(e)
{
    e.preventDefault();

    $("#pacientes-main-nuevo-paciente-vista").hide();
});
//cerrar modificar paciente
$(document).on("click", "#pacientes-main-modificar-paciente-vista-cerrar", function(e)
{
    e.preventDefault();

    $("#pacientes-main-modificar-paciente-vista").hide();
});

/*CODIGO QUE LE DA FUNCIONALIDAD A LA PAGINA
++++++++++++++++++++++++++++++++++++++++++++ */
cargarPacientes();
	$(document).on("click",".modificar",function(){
		//variables
		let cod;
		//leer columnas de la fila actual según el botòn buscar que hizo click
		cod=$(this).parent().parent().find(".codigo").text();
		console.log(cod);
		
		$.get("ServletPaciente?accion=BUSCAR&codigo="+cod,function(response){
			console.log(response);
			console.log(response.codigoPaciente);
			//mostrar en las controles del modalDocente
			$("#codigoPacienteModificar").val(response.codigoPaciente);
			$("#CorreoPacienteModificar").val(response.correoPaciente);
			$("#TelefonoPacienteModificar").val(response.telefono);
		})
		
		
	})
	$(document).on("click",".verDatos",function(){
		//variables
		let cod;
		//leer columnas de la fila actual según el botòn buscar que hizo click
		cod=$(this).parent().parent().find(".codigo").text();
		console.log(cod);
		
		$.get("ServletPaciente?accion=BUSCAR&codigo="+cod,function(response){
			console.log(response);
			//mostrar en las controles del modalDocente
			$("#NombresPaciente").val(response.nombrePaciente);
			$("#ApellidosPaciente").val(response.apellidos);
			$("#DNIPaciente").val(response.DNI);
			$("#EdadPaciente").val(response.edad);
			$("#CorreoPaciente").val(response.correoPaciente);
			$("#TelefonoPaciente").val(response.telefono);
			$("#SexoPaciente").val(response.sexo);
		})
		
		
	})
		function cargarPacientes(){
			$.get("ServletPacienteJSON", function(e){
				//console.log(e);
				$.each(e,function(i,item){
					$('#pacientes-main-view-content-bottom-table-list').append("<div class='pacientes-main-view-content-bottom-table-list-item app-1-border-bottom'>"+
							"<div class='pacientes-main-view-content-bottom-table-list-item-child codigo'>"+"<span>"+item.codigoPaciente+"</span>"+"</div>"+
							"<div class='pacientes-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.DNI+"</span>"+"</div>"+
							"<div class='pacientes-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.nombrePaciente+" " +item.apellidos+ "</span>"+"</div>"+
							"<div class='pacientes-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.edad+"</span>"+"</div>"+
							"<div class='pacientes-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.correoPaciente+"</span>"+"</div>"+
							"<div class='pacientes-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.telefono+"</span>"+"</div>"+
							"<div class='pacientes-main-view-content-bottom-table-list-item-child'>"+
							"<button class='verDatos'>"+"<img src='app/logo/ojo_30px.png'>"+"</button>"+
							"<button class='modificar'>"+"<span class='material-icons-outlined editar'>edit</span>"+"</button>"+
							"</div>"+
							"</div>");
				})
			})
		}