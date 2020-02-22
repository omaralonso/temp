/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var estados = ["ORDENADO", "PAGADO", "CANCELADO"];
var tipos = ["DISTRIBUIDOR", "NORMAL"];
var btnEditarClienteSi = $('#modalEditarCliente-btn-si');
var btnEditarClienteNo = $('#modalEditarCliente-btn-no');
var modalEditarCliente = $('#modalEditarCliente');
var btnEditarPedidoSi = $('#modalEditarPedido-btn-si');
var btnEditarPedidoNo = $('#modalEditarPedido-btn-no');
var modalEditarPedido = $('#modalEditarPedido');
var botonRegistrarOferta = $("#btn-registrar-oferta");
var botonEditarOferta=$(".btn-editar-oferta");

botonEditarOferta.on('click', function (e) {
    let idOferta= $(this).data("idoferta");
    $("#hiddenEditarOferta").val(idOferta);
    $("#EditFormOferta").submit();
});
modalEditarCliente.on('show.bs.modal', function (e) {
    let button = $(e.relatedTarget);
    let idCliente = button.data('idcliente');
    let modal = $(this);
    let data = {
        idCliente: idCliente
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'editarCliente',
        data: JSON.stringify(data)
    }).done(function (response) {
        let tipoCliente = existe(response.distribuidor.estadoDistribuidor);
        modal.find('.modal-title').text(response.primerNombre + " " + response.primerApellido);
        modal.find('.modal-body input[type="hidden"]').val(idCliente);
        modal.find('.modal-body select#txtCliente').html(mostrarTipos(tipoCliente, tipos));
    });
});

function existe(estado)
{
    if (estado && estado === 1)
        cadena = "DISTRIBUIDOR";
    else
        cadena = "NORMAL";
    return cadena;
}
;

btnEditarClienteSi.on('click', function (e) {
    e.preventDefault();

    let idCliente = modalEditarCliente.find('.modal-body input[type="hidden"]').val();
    let tipoCliente = modalEditarCliente.find('.modal-body select#txtCliente').val();

    let data = {
        idCliente: idCliente,
        tipoCliente: tipoCliente
    };

    $.ajax({
        method: 'POST',
        url: 'actualizarCliente',
        data: data
    }).done(function (response) {
        modalEditarCliente.modal('hide');
        window.location.href = 'listaClientes';
    });
});

modalEditarPedido.on('show.bs.modal', function (e) {
    let button = $(e.relatedTarget);
    let idPedido = button.data('idpedido');
    let modal = $(this);
    let data = {
        idPedido: idPedido
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'editarPedido',
        data: JSON.stringify(data)
    }).done(function (response) {
        modal.find('.modal-title').text("Pedido: " + idPedido);
        modal.find('.modal-body input[type="hidden"]').val(idPedido);
        modal.find('.modal-body select#txtPedido').html(mostrarTipos(response.estadoPedido, estados));
    });
});

function mostrarTipos(estadoPedido, arreglo) {
    let etdoPedido=estadoPedido.toUpperCase();
    let cadena = "";
    for (var estado of arreglo) {
        if (estado === etdoPedido)
            cadena += "<option selected value='" + estado + "'>" + estado + "</option>";
        else
            cadena += "<option value='" + estado + "'>" + estado + "</option>";
    }
    return cadena;
}

btnEditarPedidoSi.on('click', function (e) {
    e.preventDefault();

    let idPedido = modalEditarPedido.find('.modal-body input[type="hidden"]').val();
    let estadoPedido = modalEditarPedido.find('.modal-body select#txtPedido').val();

    let data = {
        idPedido: idPedido,
        estadoPedido: estadoPedido
    };

    $.ajax({
        method: 'POST',
        url: 'actualizarPedido',
        data: data
    }).done(function (response) {
        modalEditarPedido.modal('hide');
        window.location.href = 'listaPedidos';
    });
});

botonRegistrarOferta.on('click', function (e) {
    let hoy = new Date();
    let actual = new Date(hoy.getFullYear(),hoy.getMonth(),hoy.getDate());
    let idOferta = $("#idOferta").val();
    let porcentaje = $("#porcentaje").val().trim();
    let categoria = $("#categoria").val().trim();
    let inicio = $("#inicio").val().trim();
    let cadinicio=inicio.split("-");
    let fechaInicio=new Date(cadinicio[0],cadinicio[1]-1,cadinicio[2]);
    let fin = $("#fin").val().trim();
    let cadfin=fin.split("-");
    let fechaFin=new Date(cadfin[0],cadfin[1]-1,cadfin[2]); 
    let error = '';
    if (porcentaje === '' || inicio === '' || fin === '' || categoria === '')
    {
        error += '<p class="mb-0">Debe rellenar todos los campos</p>';

    } else {
        if(fechaInicio<actual)
        {
            error += '<p class="mb-0">La fecha de inicio debe ser mayor o igual que la fecha actual</p>';
        } else if (fechaFin < fechaInicio) {
            error += '<p class="mb-0">La fecha de fin debe ser mayor o igual que la fecha de inicio</p>';
        }
        if (isNaN(porcentaje))
        {
            error += '<p class="mb-0">El porcentaje de descuento debe ser un numero Ej: 20.5</p>';
        }
    }
    if (error === '')
    {
        let data = {
            idOferta: idOferta,
            porcentaje: porcentaje,
            inicio: inicio,
            fin: fin,
            categoria: categoria
        };
        $.ajax({
            method: 'POST',
            url: 'saveOferta',
            data: data
        }).done(function (e) {
            window.location.href = 'listaOfertas';
        });
    } else
        $("#errores-oferta").html("<div class='alert alert-danger' role='alert'>" + error + "</div>");
});



$(function () {
    $("#inicio").datepicker({
        showAnim: "clip",
        dateFormat: 'yy-mm-dd'
    });
    $("#fin").datepicker({
        showAnim: "clip",
        dateFormat: 'yy-mm-dd'
    });
});