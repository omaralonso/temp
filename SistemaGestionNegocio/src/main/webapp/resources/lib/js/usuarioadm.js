let btnCancelarPassword = $('#btnCancelarPassword');
let botonEstadoUsuario = $(".btn-cambiar-estado-usuario");
let btnSubmitPassword = $('#submitPassword');
let btnModalPasswordSi = $('#modalPassword-btn-si');
let btnModalPasswordNo = $('#modalPassword-btn-no');
let btnEditarPolitica = $('.btn-editar-politica');
let btnEditarPoliticanSi = $('#modalEditarPolitica-btn-si');
let btnEditarPoliticaNo = $('#modalEditarPolitica-btn-no');
let btnModalEmpleadoInactivarSi = $('#modalEmpleadoInactivar-btn-si');
let btnModalEmpleadoInactivarNo = $('#modalEmpleadoInactivar-btn-no');
let botonEditarEmpleado = $(".btn-editar-empleado");
var botonRegistrarEmpleado = $("#btn-registrar-empleado");
let modalPassword = $('#modalPassword');
let modalEditarPolitica = $('#modalEditarPolitica');
let modalEmpleadoInactivar = $('#modalEmpleadoInactivar');


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

botonEditarEmpleado.on('click', function (e) {
    let idEmpleado = $(this).data("idempleado");
    $("#hiddenEditarEmpleado").val(idEmpleado);
    $("#EditFormEmpleado").submit();
});
/* 
 Para regresar a la pantalla anterior cuando se cambia
 contraseÃ±a
 */
btnCancelarPassword.on('click', function (e) {
    e.preventDefault();

    window.location.href = 'perfil';
});

/* 
 Para guardar la contraseÃ±a nueva
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

/* Modal para inactivar al empleado */
modalEmpleadoInactivar.on('show.bs.modal', function (e) {
    let button = $(e.relatedTarget);
    let idUsuario = button.data('value');
    let modal = $(this);

    modal.find('.modal-body input').val(idUsuario);
});

btnModalEmpleadoInactivarNo.on('click', function (e) {
    modalEmpleadoInactivar.modal('hide');
});

btnModalEmpleadoInactivarSi.on('click', function (e) {
    e.preventDefault();

    let idUsuario = modalEmpleadoInactivar.find('.modal-body input').val();

    let data = {
        idUsuario: idUsuario
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'DELETE',
        url: 'listaEmpleados',
        data: JSON.stringify(data)
    }).done(function (response) {
        window.location.href = 'listaEmpleados';
    });
});

function vacio(cadena){
    if(cadena==='')
    {
        return true;
    }
    return false;
}

botonRegistrarEmpleado.on('click', function (e) {
    let idEmpleado = $("#idEmpleado").val();
    let usuario = $("#usuario").val().trim();
    let password = $("#password").val().trim();
    let primerNombre = $("#primerNombre").val().trim();
    let segundoNombre = $("#segundoNombre").val().trim();
    let primerApellido = $("#primerApellido").val().trim();
    let segundoApellido = $("#segundoApellido").val().trim();
    let perfiles = [];
    $("input:checkbox:checked").each(function () {
        perfiles.push($(this).val());
    });
    let telefonoCelular = $("#telCelular").val().trim();
    let telefonoFijo = $("#telFijo").val().trim();
    let ruc = $("#ruc").val().trim();
    let email = $("#email").val().trim();
    let patron = /^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-Z0-9À-ÿ\u00f1\u00d1]*)*[a-zA-Z0-9À-ÿ\u00f1\u00d1]+$/;
    let patronCadena = /^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$/;
    let patronEmail =/^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
    let patronPass=/(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/;
    let patronCelular=/9{1}[0-9]{8}/;
    let patronFijo=/4{1}[0-9]{6}/;
    let patronRuc=/1{1}[0-9]{10}/;
    let patronUsuario=/^[a-z\d_]{4,15}$/i; 
    let error = '';
    //Serializa los campos del formulario en notación URL para Ajax
    if (vacio(usuario) || (vacio(password)&&idEmpleado==='0') || vacio(primerNombre)
            || vacio(primerApellido) || vacio(segundoApellido) || perfiles.length===0
            || vacio(telefonoCelular) || vacio(ruc) || vacio(email))
    {
            error += '<p class="mb-0">Debe rellenar campos obligatorios</p>';

    } else {

        // En caso de querer validar cadenas con espacios usar: /^[a-zA-Z\s]*$/
        if (usuario.search(patronUsuario))
            error += '<p class="mb-0">El nombre de usuario debe ser una cadena de texto</p>';
        if (!vacio(password)&&password.search(patronPass))
            error += '<p class="mb-0">La contrasena debe contener una letra mayuscula y un numero/caracter especial</p>';
        if (primerNombre.search(patronCadena))
            error += '<p class="mb-0">El primer nombre debe ser una cadena de texto</p>';
        if (!vacio(segundoNombre)&&segundoNombre.search(patronCadena))
            error += '<p class="mb-0">El segundo nombre debe ser una cadena de texto</p>';
        if (primerApellido.search(patronCadena))
            error += '<p class="mb-0">El primer apellido debe ser una cadena de texto</p>';
        if (segundoApellido.search(patronCadena))
            error += '<p class="mb-0">El segundo apellido debe ser una cadena de texto</p>';
        if (email.search(patronEmail))
            error += '<p class="mb-0">El correo electronico debe ser valido</p>';
        if (isNaN(ruc))
        {
            error += '<p class="mb-0">El ruc debe ser un numero Ej: 10234151512</p>';
        } else if (ruc.search(patronRuc)) {
            error += '<p class="mb-0">El ruc debe ser un numero valido</p>';
        }
        if (isNaN(telefonoCelular))
        {
            error += '<p class="mb-0">El telefono celular debe ser un numero Ej: 930636445</p>';
        } else if (telefonoCelular.search(patronCelular)) {
            error += '<p class="mb-0">El telefono celular debe ser un numero valido</p>';
        }
        if (isNaN(telefonoFijo))
        {
            error += '<p class="mb-0">El telefono fijo debe ser un numero Ej: 4505111</p>';
        } else if (!vacio(telefonoFijo)&&telefonoFijo.search(patronFijo)) {
            error += '<p class="mb-0">El telefono fijo debe ser un numero valido</p>';
        }
    }
    if (error === '')
    {
        /*nombre=nombre.toUpperCase();
         descripcion=descripcion.toUpperCase();*/
        let data = {
            idEmpleado: idEmpleado,
            usuario: usuario,
            password: password,
            primerNombre: primerNombre,
            segundoNombre: segundoNombre,
            primerApellido: primerApellido,
            segundoApellido: segundoApellido,
            perfiles: perfiles,
            telefonoCelular: telefonoCelular,
            telefonoFijo: telefonoFijo,
            ruc: ruc,
            email: email
        };
        $.ajax({
            method: 'POST',
            url: 'saveEmpleado',
            data: data
        }).done(function (e) {
            if(e.respuesta==="repetido")
            {
                error += '<p class="mb-0">Nombre de usuario repetido</p>';               
            }
            if(e.rucrespuesta==="rucrepetido")
            {
                error += '<p class="mb-0">Ruc repetido</p>';
            }
            if(error==='')
            {
                window.location.href = 'listaEmpleados';
            }else
                $("#errores-empleado").html("<div class='alert alert-danger' role='alert'>"+error+"</div>");
                
        });
    } else
        $("#errores-empleado").html("<div class='alert alert-danger' role='alert'>"+error+"</div>");
});