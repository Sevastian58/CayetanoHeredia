$(".especialidad-elemento").hover(function(){
    $(this).css("color", "blue");
    $(this).css("background-color", "white");
    $(this).find(".subtitulo").css("color", "blue");
    $(this).find(".especialidad-cuerpo").css("color", "blue");
    }, function(){
    $(this).css("background-color", "rgb(2, 2, 188)");
    $(this).find(".subtitulo").css("color", "white");
    $(this).find(".especialidad-cuerpo").css("color", "white");
});