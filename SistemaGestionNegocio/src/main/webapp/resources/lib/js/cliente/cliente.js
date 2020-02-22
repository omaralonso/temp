let btnRegistrarPedido = $('#btnRegistrarPedido');
let btnModalConfirmarPedidoSi = $('#modalPedidoConfirmar-btn-si');
let btnModalConfirmarPedidoNo = $('#modalPedidoConfirmar-btn-no');

let modalConfirmarPedido = $('#modalPedidoConfirmar');
let modalPedidoEstadoConfirmacion = $('#modalPedidoEstadoConfirmacion');

btnModalConfirmarPedidoSi.on('click', function(e){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: '../pedido'
    }).done(function(response){
        modalConfirmarPedido.modal('hide');
        let nuevoPedidoResponse = response.nuevoPedidoResponse;
        if(nuevoPedidoResponse != ""){
            modalPedidoEstadoConfirmacion.find('.modal-body p').text(nuevoPedidoResponse);
            modalPedidoEstadoConfirmacion.modal('show');
        }
    });
});

btnModalConfirmarPedidoNo.on('click', function(e){
    modalConfirmarPedido.modal('hide');
});

modalPedidoEstadoConfirmacion.on('hide.bs.modal', function(e){
    window.location.href = '../tienda/productos';
});