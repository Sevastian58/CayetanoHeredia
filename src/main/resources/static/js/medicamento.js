/* ABRIR NUEVO MEDICAMENTO VISTA */
$(document).on("click", "#medicamento-main-nuevo-medicamento-vista-abrir", function(e)
{
	$("#descripcion").val("");
	$("#stock").val("");
	$("#precio").val("");
	$("#cantidad").val("");
	$("#categoria").val("");
	$("#estado").val("");
    $("#medicamento-main-nuevo-medicamento-vista").show();
});

//ver datos de Medicamento
$(document).on("click", ".verDatos", function(e)
{
    $("#medicamento-main-nuevo-medicamento-vista").show();
});
//modificar algunos datos de Medicamento
$(document).on("click", ".modificar", function(e)
{
    $("#medicamento-main-modificar-medicamento-vista").show();
});

/* CERRAR NUEVO MEDICAMENTO VISTA */
$(document).on("click", "#medicamento-main-nuevo-medicamento-vista-cerrar", function(e)
{
    e.preventDefault();

    $("#medicamento-main-nuevo-medicamento-vista").hide();
});
//cerrar modificar medicamento
$(document).on("click", "#medicamento-main-modificar-medicamento-vista-cerrar", function(e)
{
    e.preventDefault();

    $("#medicamento-main-modificar-medicamento-vista").hide();
});

/*CODIGO QUE LE DA FUNCIONALIDAD A LA PAGINA
++++++++++++++++++++++++++++++++++++++++++++ */
cargarMedicamento();
	$(document).on("click",".verDatos",function(){
		//variables
		let cod;
		//leer columnas de la fila actual según el botòn buscar que hizo click
		cod=$(this).parent().parent().find(".codigo").text();
		console.log(cod);
		
		$.get("ServletMedicamento?accion=BUSCAR&codigo="+cod,function(response){
			console.log(response);
			//mostrar en las controles del modalDocente
			$("#descripcion").val(response.descripcionx);
			$("#stock").val(response.stockx);
			$("#precio").val(response.preciox);
			$("#cantidad").val(response.cantidadx);
			$("#categoria").val(response.categoriax);
			$("#estado").val(response.estadox);
		})
		
		
	})
		function cargarMedicamento(){
			$.get("ServletMedicamentoJSON", function(e){
				//console.log(e);
				$.each(e,function(i,item){
					$('#Medicamento-main-view-content-bottom-table-list').append("<div class='medicamento-main-view-content-bottom-table-list-item app-1-border-bottom'>"+
    "<div class='medicamento-main-view-content-bottom-table-list-item-child codigo'>"+"<span>"+item.codigoMedicamento+"</span>"+"</div>"+
    "<div class='medicamento-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.descripcion+"</span>"+"</div>"+
    "<div class='medicamento-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.categoria+ "</span>"+"</div>"+
    "<div class='medicamento-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.stock+"</span>"+"</div>"+
    "<div class='medicamento-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.precio+"</span>"+"</div>"+
    "<div class='medicamento-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.cantidad+"</span>"+"</div>"+
    "<div class='medicamento-main-view-content-bottom-table-list-item-child'>"+"<span>"+item.estadoMedicamento+"</span>"+"</div>"+
    "<div class='medicamento-main-view-content-bottom-table-list-item-child'>"+
    "<button class='verDatos'>"+"<img src='app/logo/ojo_30px.png'>"+"</button>"+
    "<button class='modificar'>"+"<span class='material-icons-outlined editar'>edit</span>"+"</button>"+
    "</div>"+
    "</div>");
				})
			})
		}
		
		
		
		
		