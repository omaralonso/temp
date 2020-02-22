<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerCliente.jsp" %>

<div class="container-fluid">
    <div class="row">
        <c:if test="${carrito != null}">
        <div class="offset-md-2 col-md-5 col-sm-6">
            <table class="table table-bordered table-hover">
                <thead class="thead-inverse">
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${carrito.detalleCarritos}" var="detalle">
                    <tr>
                        <td><c:out value="${detalle.producto.nombreProducto}"></c:out></td>
                        <td><c:out value="${detalle.cantidad}"></c:out></td>
                        <td>S/. <c:out value="${detalle.precioDetalleCarrito}"></c:out></td>
                        <td>
                            <button class="btn btn-sm">
                                <span class="fa fa-pencil"></span>
                            </button>
                            <button class="btn btn-sm">
                                <span class="fa fa-trash-o"></span>
                            </button>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-5 col-sm-6">
            <div class="card text-center pull-left">
                <div class="card-block">
                  <h4 class="card-title">Carrito de Compras</h4>
                  <p class="card-text">El total a pagar es: S/.<c:out value="${carrito.precioAcumuladoCarrito}"></c:out></p>
                  <button class="btn btn-warning" id="btnRegistrarPedido" data-toggle="modal" data-target="#modalPedidoConfirmar">Registrar el pedido</button>
                </div>
            </div>
        </div>
        </c:if>
        
        <c:if test="${carrito == null}">
        
        <div class="offset-md-4 col-md-4 col-sm-4">
            <div class="card text-center">
                <div class="card-block">
                  <h4 class="card-title">Carrito de Compras</h4>
                  <p class="card-text">Tu carrito está vacío</p>
                  <button class="btn btn-warning" id="btnRegistrarPedido" data-toggle="modal" data-target="#modalPedidoConfirmar" disabled>Registrar el pedido</button>
                </div>
            </div>
        </div>
        </c:if>
        
    </div>
</div>

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalPedidoConfirmar">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <div class="centrar-texto-modal">
                    <h4 class="modal-title" id="mySmallModalLabel">Confirmar pedido</h4>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p class="text-center">¿Está seguro de realizar este pedido?</p>
                <input type="hidden" name="idUsuario">
            </div>
            <div class="modal-footer">
                <div class="centrar-texto-modal">
                    <button type="button" class="btn btn-warning" id="modalPedidoConfirmar-btn-si">Si</button>
                    <button type="button" class="btn btn-secondary" id="modalPedidoConfirmar-btn-no">No</button>
                </div>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true" id="modalPedidoEstadoConfirmacion">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <div class="centrar-texto-modal">
                    <h4 class="modal-title" id="modalLabel">Estado del Pedido</h4>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p class="text-center"></p>
                <input type="hidden" name="idUsuario">
            </div>
        </div>
    </div>
</div>


<%@ include file="../includes/footer.jsp"%>