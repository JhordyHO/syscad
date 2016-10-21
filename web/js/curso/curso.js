$(document).ready(function () {
    $(".dropdown-button").dropdown();
    $('.modal-trigger').leanModal();
    $('select').material_select();

    //--------------modificar event -----------
    $('#modificar').click(function () {
        $('#form-edit').submit();
    });

    //--------------crear event -----------------
    $('#crear').click(function () {
        $('#form-registrar').submit();
    });

    // -------------initialize----------
    $('select').on('contentChanged', function () {
        $(this).material_select();
    });

    //------- combobox dinamico docente ------------
    $('#btn_crear').click(function () {
        $.ajax({
            url: "cd",
            data: {op: 'list_json'},
            success: function (data) {
                // ----------- poner los datos en el combobox----------
                var selectD = $("#docent_select").empty().html(' ');
                $.each(data, function (i, json) {
                    $.each(json, function (i, dat) {
                        var value = dat.nombres + ' / ' + dat.grado;
                        $('#docent_select').append('<option value="' + dat.iddocente + '">' + value + "</option>");
                        selectD.trigger('contentChanged');// trigger select change
                    });
                });
            },
            error: function (e) {
                alert(e);
            }
        });
    });
});

//---- creamos la funcion para editar alumno
function edit(id) {
 
    $.ajax({url: "cc",
        data: {op: 'edit', id_c: id},
        success: function (json1) {
            $('label').addClass('active');
            $('#id_c').val(json1.id_curso);
            $('#nombre_c').val(json1.nombre_curso);
            //---------hacemos un ajax para traer los docentes ------- 
            $.ajax({
                url: "cd",
                data: {op: 'list_json'},
                success: function (data) {
                   
                    // limpiamosel contenido
                    var selectD = $("#select_docente").empty().html(' ');
                    
                    $.each(data, function (i, json) {
                        $.each(json, function (i, dat) {
                                 console.log(dat);
                            // añadir el nuevo valor
                            var value = dat.nombres + ' /---- ' + dat.grado;
                            if (dat.iddocente == json1.id_docente) {
                                $('#select_docente').append('<option value="' + dat.iddocente + '">' + value + "</option>");
                                $('#select_docente').val(dat.iddocente);
                            } else {
                                $('#select_docente').append('<option value="' + dat.iddocente + '">' + value + "</option>");
                            }

                            // disparamos el event
                            selectD.trigger('contentChanged');
                        });
                    });

                },
                error: function (e) {
                    alert("erro");
                }

            });
        }, error: function (e) {}
    });
    $('#modaledit').openModal();// se able el modal 
}


//---- creamos la funcion para eliminar alumno
function eliminar(id) { // el parametro "id" es lo que nos trae el id del usuario
    var del = confirm("Deseas eliminar este Registro ?");
    if (del) {
        $.ajax({
            url: "cc",
            data: {op: 'eliminar', id_c: id},
            success: function (data) {
                location.reload();
            }

        });
    }

}