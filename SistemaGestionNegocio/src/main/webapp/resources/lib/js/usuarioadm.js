let btnCancelarPassword = $('#btnCancelarPassword');
let botonEstadoUsuario = $(".btn-cambiar-estado-usuario");
let btnSubmitPassword = $('#submitPassword');
let btnModalPasswordSi = $('#modalPassword-btn-si');
let btnModalPasswordNo = $('#modalPassword-btn-no');
let btnEditarPolitica = $('.btn-editar-politica');
let btnEditarPoliticanSi = $('#modalEditarPolitica-btn-si');
let btnEditarPoliticaNo = $('#modalEditarPolitica-btn-no');
let modalPassword = $('#modalPassword');
let modalEditarPolitica = $('#modalEditarPolitica');

botonEstadoUsuario.on('click', function (e) {
    let idUsuario = $(this).data("idusuario");
    let data = {idUsuario: idUsuario};
    $.ajax({
        method: 'POST',
        url: 'cambiarEstadoUsuario',
        data: data
    }).done(function (e) {
            window.location.href = 'listaEmpleados';
    });

});

/* 
 Para regresar a la pantalla anterior cuando se cambia
 contraseña
 */
btnCancelarPassword.on('click', function (e) {
    e.preventDefault();

    window.location.href = 'perfil';
});

/* 
 Para guardar la contraseña nueva
 */
btnSubmitPassword.on('click', function (e) {
    e.preventDefault();

    modalPassword.modal('show');
});

btnModalPasswordSi.on('click', function () {
    let passwordActual = $('#passwordActual').val();
    let passwordNueva = $('#passwordNueva').val();
    let passwordConfirmacion = $('#passwordConfirmacion').val();

    let data = {
        passwordActual: passwordActual,
        passwordNueva: passwordNueva,
        passwordConfirmacion: passwordConfirmacion
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'passwordCorrecta',
        data: JSON.stringify(data)
    }).done(function (response) {
        let rpta = response.rpta;

        if (rpta != null) {
            actualizarAlertCambioPassword(rpta);
        } else {
            window.location.href = 'perfil';
        }
        modalPassword.modal('hide');
    });
});

btnModalPasswordNo.on('click', function () {
    modalPassword.modal('hide');
})

function actualizarAlertCambioPassword(rpta) {
    let alertWrapper = $('#alert-wrapper');

    let alerthtml = `
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        ${rpta}
    </div>
    `;

    alertWrapper.html(alerthtml);
}
;

/* Modal editar politica */
modalEditarPolitica.on('show.bs.modal', function (e) {
    let button = $(e.relatedTarget);
    let idPolitica = button.data('idpolitica');
    let modal = $(this);
    let data = {
        idPolitica: idPolitica
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'editarPolitica',
        data: JSON.stringify(data)
    }).done(function (response) {
        modal.find('.modal-body input[type="hidden"]').val(idPolitica);
        modal.find('.modal-body input#txtPolitica').val(response.descPolitica);
        modal.find('.modal-body input#txtPuntosMinInd').val(response.minPuntosIndividual);
        modal.find('.modal-body input#txtPuntosMaxInd').val(response.maxPuntosIndividual);
        modal.find('.modal-body input#txtPuntosMinGru').val(response.minPuntosGrupal);
        modal.find('.modal-body input#txtPuntosMaxGru').val(response.maxPuntosGrupal);
        modal.find('.modal-body input#txtPorcentaje').val(response.porcentajeDescuento);
    });
});

btnEditarPoliticanSi.on('click', function (e) {
    e.preventDefault();

    let idPolitica = modalEditarPolitica.find('.modal-body input[type="hidden"]').val();
    let descPolitica = modalEditarPolitica.find('.modal-body input#txtPolitica').val();
    let minPuntosInd = modalEditarPolitica.find('.modal-body input#txtPuntosMinInd').val();
    let maxPuntosInd = modalEditarPolitica.find('.modal-body input#txtPuntosMaxInd').val();
    let minPuntosGru = modalEditarPolitica.find('.modal-body input#txtPuntosMinGru').val();
    let maxPuntosGru = modalEditarPolitica.find('.modal-body input#txtPuntosMaxGru').val();
    let porcentajeDescuento = modalEditarPolitica.find('.modal-body input#txtPorcentaje').val();

    let data = {
        idPolitica: idPolitica,
        descPolitica: descPolitica,
        minPuntosIndividual: minPuntosInd,
        maxPuntosIndividual: maxPuntosInd,
        minPuntosGrupal: minPuntosGru,
        maxPuntosGrupal: maxPuntosGru,
        porcentajeDescuento: porcentajeDescuento
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'actualizarPolitica',
        data: JSON.stringify(data)
    }).done(function (response) {
        modalEditarPolitica.modal('hide');
        window.location.href = 'listaPoliticas';
    });
});

function vacio(cadena){
    if(cadena==='')
    {
        return true;
    }
    return false;
}
