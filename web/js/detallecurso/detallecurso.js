$(document).ready(function (){
     $('.modal-trigger').leanModal();
     $('select').material_select();
     $('select').on('contentChanged', function () {
        $(this).material_select();
    });
    
    $('#crear_n').click(function(){
        // -- listar docentes --
        $.ajax({
                url: "ac",
                data: {op: 'list_json'},
                success: function (data) {
                    console.log(data);
                    // limpiamosel contenido
                    var selectD = $("#select_alumno").empty().html(' ');
                    
                    $.each(data, function (i, json) {
                        $.each(json, function (i, dat) {
                            // añadir el nuevo valor
                            var value = dat.nombre + '  ' + dat.apellido;
                                $('#select_alumno').append('<option value="' + dat.id_alumno + '">' + value + "</option>");
                            
                            // disparamos el event
                            selectD.trigger('contentChanged');
                        });
                    });

                },
                error: function (e) {
                    alert("erro");
                }

            });
        // -- listar curso --
        $.ajax({
                url: "cc",
                data: {op: 'list_json'},
                success: function (data) {
                    console.log(data);
                    // limpiamosel contenido
                    var selectD = $("#select_curso").empty().html(' ');
                    
                    $.each(data, function (i, json) {
                        $.each(json, function (i, dat) {
                            // añadir el nuevo valor
                                $('#select_curso').append('<option value="' + dat.id_curso + '">' + dat.nombre_curso + "</option>");
                            
                            // disparamos el event
                            selectD.trigger('contentChanged');
                        });
                    });

                },
                error: function (e) {
                    alert("erro");
                }

            });
    });
    
    $('#crear').click(function (){
        $('#form-registrar').submit();
        
    });
});


