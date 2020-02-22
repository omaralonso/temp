let modalAddProductoPedido = $('#modalAddProductoPedido');
let modalRegistrarPedido = $('#modalRegistrarPedido');

let modalAddProductoAlert = $('#modalAddProductoAlert');
let registrarPedidoAlert = $('#registrarPedidoAlert');

let btnCancelarPedido = $('#btnVentasCancelarPedido');
let btnModalAddProductoPedidoSi = $('#modalAddProductoPedido-btn-si');
let btnModalRegistrarPedidoSi = $('#modalRegistrarPedido-btn-si');

let selectCategoria = $('.modal-body select#categoria');
let selectProducto = $('.modal-body select#producto');
let txtCantidad = $('.modal-body input#cantidad');
let txtDniCliente = $('#txtDniCliente');

let tablePedido = $('#tablePedido');

btnCancelarPedido.on('click', function (e) {
    window.location.href = 'listaPedidos';
});

modalAddProductoPedido.on('hide.bs.modal', function (e) {
    selectCategoria.find('option').remove();
    selectProducto.find('option').remove();
    txtCantidad.val('');
    modalAddProductoAlert.removeClass('alert alert-danger');
});

modalAddProductoPedido.on('show.bs.modal', function (e) {
    let modal = $(this);

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'GET',
        url: 'categoria'
    }).done(function (response) {
        selectCategoria.find('option').remove();
        response.forEach(function (categoriaItem) {
            selectCategoria.append($('<option>', {
                value: categoriaItem.idCategoria,
                text: categoriaItem.nombreCategoria
            }));
        });
    });
});

selectCategoria.on('change', function (e) {
    let idCategoria = selectCategoria.val();

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'GET',
        url: `categoria/${idCategoria}/producto`
    }).done(function (response) {
        selectProducto.find('option').remove();
        response.forEach(function (productoItem) {
            selectProducto.append($('<option>', {
                value: productoItem.idProducto,
                text: productoItem.nombreProducto
            }));
        });
    });
});

btnModalAddProductoPedidoSi.on('click', function (e) {

    let idProducto = selectProducto.val();
    let cantidad = txtCantidad.val();
    let swEncontrado = false;

    if (!idProducto) {
        modalAddProductoAlert.addClass('alert alert-danger');
        modalAddProductoAlert.text('Elija un producto');
    } else if (!cantidad) {
        modalAddProductoAlert.addClass('alert alert-danger');
        modalAddProductoAlert.text('Ingrese la cantidad');
    } else if (isNaN(cantidad)) {
        modalAddProductoAlert.addClass('alert alert-danger');
        modalAddProductoAlert.text('Solo debe ingresar números en el campo cantidad');
    } else if (cantidad < 0) {
        modalAddProductoAlert.addClass('alert alert-danger');
        modalAddProductoAlert.text('La cantidad debe ser un número positivo');
    } else {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'GET',
            url: `producto/${idProducto}`
        }).done(function (response) {
            let trArr = tablePedido.find('tr');
            for (let i = 0; i < trArr.length && !swEncontrado; i++) {
                if ($(trArr[i]).attr('data-idProducto') == idProducto) {
                    swEncontrado = true;
                }
            }
            if (swEncontrado) {
                modificarFilaTabla(response, cantidad);
            } else {
                agregarFilaTabla(response, cantidad);
            }


            modalAddProductoPedido.modal('hide');
        });
    }
});

function agregarFilaTabla(response, cantidad) {
    tablePedido.find('tbody')
        .append($('<tr>', {
            "data-idProducto": response.idProducto
        })
            .append($('<td>')
                .text(response.nombreProducto)
            )
            .append($('<td>')
                .text(response.precioProducto)
            )
            .append($('<td>')
                .text(response.puntosProducto)
            )
            .append($('<td>')
                .text(cantidad)
            )
            .append($('<td>')
                .text(response.precioProducto * cantidad)
            )
            .append($('<td>')
                .text(response.puntosProducto * cantidad)
            )
        );
}

function modificarFilaTabla(response, cantidad) {
    let tr = tablePedido.find(`tr[data-idProducto=${response.idProducto}]`);
    let tdArr = tr.find('td');
    $(tdArr[3]).text(Number($(tdArr[3]).text()) + Number(cantidad));
    $(tdArr[4]).text(Number($(tdArr[4]).text()) + cantidad * response.precioProducto);
    $(tdArr[5]).text(Number($(tdArr[5]).text()) + cantidad * response.puntosProducto);
}

btnModalRegistrarPedidoSi.on('click', function (e) {
    let dniCliente = txtDniCliente.val();

    if (!dniCliente) {
        registrarPedidoAlert.addClass('alert alert-danger');
        registrarPedidoAlert.text('Ingrese el DNI de un cliente');
        modalRegistrarPedido.modal('hide');
    } else if (isNaN(dniCliente)) {
        registrarPedidoAlert.addClass('alert alert-danger');
        registrarPedidoAlert.text('Ingrese correctamente el DNI');
        modalRegistrarPedido.modal('hide');
    } else if (tablePedido.find('tr').length < 2) {
        registrarPedidoAlert.addClass('alert alert-danger');
        registrarPedidoAlert.text('Añada al menos un producto');
        modalRegistrarPedido.modal('hide');
    } else {
        let data = {
            dniCliente: dniCliente,
            pedido: []
        };

        let totalPuntos = 0;
        let totalSoles = 0;
        let trArr = tablePedido.find('tr');
        for (let i = 1; i < trArr.length; i++) {
            let idProducto = $(trArr[i]).attr('data-idProducto'); 
            let tdArr = $(trArr[i]).find('td');
            let cantidad = $(tdArr[3]).text();
            let subtotal = $(tdArr[4]).text();
            let subtotalPuntos = $(tdArr[5]).text()
            totalSoles += Number($(tdArr[4]).text());
            totalPuntos += Number($(tdArr[5]).text());
            data.pedido.push({
                idProducto: idProducto,
                cantidad: cantidad,
                subtotal: subtotal,
                subtotalPuntos: subtotalPuntos
            });
        }
        data.totalSoles = totalSoles;
        data.totalPuntos = totalPuntos;

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'POST',
            url: 'pedido',
            data: JSON.stringify(data)  
        }).done(function(response){
            console.log(response.rpta);
            modalRegistrarPedido.modal('hide');
        });
    }
});