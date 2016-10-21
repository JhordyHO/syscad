$(document).ready(function () {
    $(".dropdown-button").dropdown();//inicializamos el dropdown
    $('.modal-trigger').leanModal();
    //--------------modificar event -----------
    $('#modificar').click(function () {
        $('#form-edit').submit();
    });//-- end modificar event

    //--------------crear event -----------------
    $('#crear').click(function () {
        $('#form-registrar').submit();
    });//-end event crear

});// --- end inicializacion jQuery

//---- creamos la funcion para editar alumno
function edit_alum(id) { // el parametro "id" es lo que nos trae el id del usuario
    // --- madamos un ajax para traer el usuario
    $.ajax({url: "ac",
        data: {op: 'edit', id_alum: id},
        success: function (json) {

            $('label').addClass('active');
            $('#txtid').val(json.id);
            $('#txtnombre').val(json.nombre);
            $('#txtapellido').val(json.apellido);
            $('#txtciclo').val(json.ciclo);
            $('#txttelefono').val(json.telefono);
            $('#txtcorreo').val(json.correo);

        }, error: function (error) {

        }
    });
    $('#modaledit').openModal();// se able el modal 
}


//---- creamos la funcion para eliminar alumno
function eliminar_alum(id) { // el parametro "id" es lo que nos trae el id del usuario
    var del = confirm("Deseas eliminar este Registro ?");
    if (del) {
        $.ajax({
            url: "ac",
            data: {op: 'eliminar', id_alum: id},
            success: function (data, textStatus, jqXHR) {
                location.reload();
            }

        });
    }

}