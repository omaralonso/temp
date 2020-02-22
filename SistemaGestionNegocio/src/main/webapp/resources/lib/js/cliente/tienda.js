let modalDetalleProducto = $('#modalDetalleProducto');
let modalAgregarACarrito = $('#modalAgregarACarrito');

let btnModalAgregarACarritoSi = $('#modalAgregarACarrito-btn-si');
let btnModalAgregarACarritoNo = $('#modalAgregarACarrito-btn-no');

modalDetalleProducto.on('show.bs.modal', function (event) {
    let button = $(event.relatedTarget);
    let idProducto = button.data('idproducto');
    let modal = $(this);

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: `productos/${idProducto}`,
        method: 'GET'
    }).done(function (response) {
        modal.find('.modal-header h4').text(response.nombreProducto);
        modal.find('.modal-body input#txtCategoria').val(response.categoria.nombreCategoria);
        modal.find('.modal-body textarea').val(response.descripcionProducto);
    });
});

modalAgregarACarrito.on('show.bs.modal', function(event) {
    let button = $(event.relatedTarget);
    let idProducto = button.data('idproducto');
    let modal = $(this);

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: `productos/${idProducto}`,
        method: 'GET' 
    }).done(function (response){
        modal.find('.modal-header h4').text(response.nombreProducto);
        modal.find('.modal-body input[type="hidden"]').val(response.idProducto);
    });
});

modalAgregarACarrito.on('hide.bs.modal', function(event){
    modalAgregarACarrito.find('.modal-body input#txtCantidad').val("");
});

btnModalAgregarACarritoNo.on('click', function(e){
    modalAgregarACarrito.modal('hide');
});

btnModalAgregarACarritoSi.on('click', function(e){
    let modal = modalAgregarACarrito;
    let idProducto = modal.find('.modal-body input[type="hidden"]').val();
    let cantidad = modal.find('.modal-body input#txtCantidad').val();

    let data = {
        idProducto: idProducto,
        cantidad: cantidad
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: 'carrito',
        method: 'POST',
        data: JSON.stringify(data) 
    }).done(function (response){
        modalAgregarACarrito.modal('hide');
    });
});
