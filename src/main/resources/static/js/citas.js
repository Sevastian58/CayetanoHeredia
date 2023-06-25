ocultarBotones();
//variables globales
 var fechaCita=null;
 var codEspe=null;

function ocultarBotones(){
	//$("#botones-cita").css("display", "none");
	$("#botones-cita").hide();
	console.log("hola");
	
	
}


$("#citas_calendar").fullCalendar
({
    locale: "es",
    header:
    {
        left: "title",
        right: "today prev,next"
    },
    height: "parent",
    editable: false,
    selectable: true,
    monthNames: ["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"],
    monthNamesShort: ["Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"],
    dayNames: ["Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"],
    dayNamesShort: ["Dom","Lun","Mar","Mie","Jue","Vie","Sab"],
    dayClick: function (date, jsEvent, view) {
			fechaCita=date.format()
            console.log('Has hecho click en: '+ fechaCita);
            
            $("#botones-cita").show();
        }
});

$(".fc-today-button").text("Hoy");
//añadir elementos select 
$(document).on("click", "#abrir-añadir-cita", function(e)
{
    e.preventDefault();

    $("#añadir-cita-view").show();
    $("#añadir-cita-step-1").show();
    
    //codigo de listar especialidades
    $.get("ServletEspecialidad", function(e){
	$.each(e,function(i, item){
		$('#CODEspecialidad').append("<option value='"+item.CODEspecialidad+"'>" + item.nombreEspecialidad+"</option>")
		})
	})
	$("#FechaCita").val(fechaCita);
	$("#CODEspecialidad").change(function(){
		 console.log($("#CODEspecialidad").val());
		 codEspe=$("#CODEspecialidad").val();
		 $.get("ServletMedico?codEspe="+codEspe, function(e){
			$('#CODMedico').empty();
			$.each(e,function(i, item){
			$('#CODMedico').append("<option value='"+item.codMedico+"'>" + item.nombre+" "+item.apellido +"</option>")
			})
		})
});
});

/* BOTON PARA SEGUNDO PASO */
$(document).on("click", "#abrir-cita-paso-2", function(e)
{
    e.preventDefault();
	
	let codPaciente = $("#paciente").val();
    let numSala = $("#NumSala").val();
    
    if(codPaciente!="" && numSala!=""){
      $("#añadir-cita-step-1").hide();
    	$("#añadir-cita-step-2").show();
         //habilitar el boton guardar
    
   
   //ver si una cita esta disponible
   $.get("ServletCita?fechaCita="+fechaCita+"&accion=LISTAR",function(e){
			$('#horarios-disponibles').empty();
			for(let n=8;n<=15;n++){
				let hora;
				if(n<=9){
					hora="0"+n+":00:00";
				}
				else{
					hora = n+":00:00";
				}
				let contador=0;
				console.log(e.length);
				$.each(e, function(i, item){
					if(hora==item.horaCita){
						contador++;
						$('#horarios-disponibles').append('<div class="w-100 h-60px min-h-60px f-row alg-center cursor app-1-border-bottom hora-item lista-items">'+
    								'<div class="w-100 h-100 f-row-center alg-center">'+
    								'<span class="hora">'+hora+'</span>'+'</div>'+
    								'<div class="w-100 h-100 f-row-center alg-center">'+
    								'<span>'+item.numSala+'<span>'+'</div>'+
    								'<div class="w-100 h-100 f-row-center alg-center">'+
    								'<span class="estado">'+'Ocupado'+'<span>'+'</div>'+
    								'</div>');
					}
				})
				if(contador<1){
					contador++;
					$('#horarios-disponibles').append('<div class="w-100 h-60px min-h-60px f-row alg-center cursor app-1-border-bottom hora-item lista-items">'+
    								'<div class="w-100 h-100 f-row-center alg-center">'+
    								'<span class="hora">'+hora+'</span>'+'</div>'+
    								'<div class="w-100 h-100 f-row-center alg-center">'+
    								'<span>'+'---'+'<span>'+'</div>'+
    								'<div class="w-100 h-100 f-row-center alg-center">'+
    								'<span class="estado">'+'Disponible'+'<span>'+'</div>'+
    								'</div>');
				}
			}
		} )
        }
        else{
	
			if(codPaciente==""){
				alert("Ingresar un codigo de Paciente");
			}
			if(numSala==""){
				alert("Ingresa un número de sala" );
			}
		}
	
    
    
   
});

/* BOTON PARA GRABAR CITA NUEVA */
$(document).on("click", ".hora-item", function(){
		let horaElegida;
		let estadoCita;
		estadoCita = $(this).find(".estado").text();
		
		if(estadoCita=="Disponible"){
			horaElegida=$(this).find(".hora").text();
			
			$("#horaCita").val(horaElegida);
		}
	})

/* BOTON PARA PRIMER PASO */
$(document).on("click", "#abrir-cita-paso-1", function(e)
{
    e.preventDefault();

    $("#añadir-cita-step-1").show();
    $("#añadir-cita-step-2").hide();
});

$(document).on("click", ".cerrar-añadir-cita", function(e)
{
    e.preventDefault();
	$('#CODMedico').empty();
    $("#añadir-cita-view").hide();
    $("#añadir-cita-step-1").hide();
    $("#añadir-cita-step-2").hide();
});

$(document).on("click", "#abrir-ver-citas", function(e)
{
    e.preventDefault();

    $("#ver-citas-view").show();
     $.get("ServletCita?fechaCita="+fechaCita+"&accion=LISTAR",function(e){
		$('#tabla-citas-dia').empty();
		$.each(e, function(i, item){
			 $("#tabla-citas-dia").append('<div class="w-100 h-60px min-h-60px f-row alg-center app-1-border-bottom">'+
								'<div class="w-100 h-100 f-row-center alg-center">'+
									'<span>'+ item.horaCita+'</span>'+
									'</div>'+
									'<div class="w-100 h-100 f-row-center alg-center">'+
									'<span>'+ item.codiCita+'</span>'+
									'</div>'+
									'<div class="w-100 h-100 f-row-center alg-center">'+
									'<span>'+ item.nombrePaciente+'</span>'+
									'</div>'+
									'<div class="w-100 h-100 f-row-center alg-center">'+
									'<span>'+ item.nombreEspecialidad+'</span>'+
									'</div>'+
									'<div class="w-100 h-100 f-row-center alg-center">'+
									'<span>'+ item.nombreMedico + " "+ item.apellidoMedico +'</span>'+
									'</div>'+
									'<div class="w-100 h-100 f-row-center alg-center">'+
									'<span>'+ item.numSala+'</span>'+
									'</div>'+
									'<div class="w-100 h-100 f-row-center alg-center">'+
									'<span>'+ item.fechaCita+'</span>'+
									'</div>'+'</div>');	
		})
	});
});

$(document).on("click", "#cerrar-ver-citas", function(e)
{
    e.preventDefault();

    $("#ver-citas-view").hide();
});