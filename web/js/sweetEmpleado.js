/* global swal, result, id */

$(document).on('click', '#eliminar_registro', function (e) {
    e.preventDefault();
    var registroId = $(this).data('id');
    swal({
        title: "Esta Seguro de Eliminar?",
        text: "Una vez eliminado deberá agregar de nuevo!",
        type: "warning",
        showCancelButton: true,
        confirmButtonClass: "btn-danger",
        confirmButtonText: "Sí, Eliminar!",
        cancelButtonText: "No, Cancelar!",
        closeOnConfirm: false,
        closeOnCancel: false
    },
            function (isConfirm) {
                if (isConfirm) {
                    eliminarUsuario(registroId);
                    swal("Eliminado!", "El usuario se ha eliminado", "success");
                    setTimeout(function () {

                        parent.location.href = "Controlador?menu=Empleado&accion=Listar";
                    }, 1800);
                } else {
                    swal("Cancelado", "Cancelaste la eliminación", "error");
                }
            });
});

function eliminarUsuario(cod) {
    var url = "Controlador?menu=Empleado&accion=Delete&id=" + cod;
    console.log("eliminado");
    $.ajax({
        type: 'POST',
        url: url,
        async: true,
        success: function (r) {

        }
    });

}

