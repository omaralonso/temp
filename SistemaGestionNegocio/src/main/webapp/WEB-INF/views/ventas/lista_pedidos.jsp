<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerVentas.jsp" %>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Pedidos</h1>
        <a href="${pageContext.request.contextPath}/ventas/pedido" class="btn btn-warning pull-right" id="add-pedido-btn">Registrar un pedido</a>
        <div class="clearfix"></div><hr>
    </div>
    <div class="row">
        <table class="table table-hover table-bordered">
            <thead class="thead-inverse">
                <tr>
                    <th>Nº de pedido</th>
                    <th>Cliente</th>
                    <th>Importe total</th>
                    <th>Fecha de registro</th>
                    <th>Fecha de modificación</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaPedidos}" var="pedido">
                <tr>
                    <td>${pedido.idPedido}</td>
                    <td><c:out value="${pedido.cliente.primerNombre}"></c:out> <c:out value="${pedido.cliente.primerApellido}"></c:out></td>
                    <td>${pedido.precioAcumuladoPedido}</td>
                    <td>${pedido.fechaCreacion}</td>
                    <td>${pedido.fechaModificacion}</td>
                    <td>
                        <button class="btn btn-sm btn-editar-pedido" data-toggle="modal" data-target="#modalEditarPedido" data-idpedido="${pedido.idPedido}">
                            <span class="fa fa-pencil fa-2x"></span>
                        </button>
                        <c:out value="${pedido.estadoPedido}"></c:out>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="modalEditarPedido">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="centrar-texto-modal">
                        <h4 class="modal-title" id="myModalLabel"></h4>
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <form>
                        <input type="hidden" name="idpedido">
                        <select  class="form-control" name="cliente" id="txtPedido">
                            
                        </select>
                        <p><small><b>Nota:</b> Un pedido solo será cancelado si el cliente lo solicita o si supera el límite de tiempo de compra.</small></p>
                    </form>
                </div>
                <div class="modal-footer">
                    <div class="centrar-texto-modal">
                        <button type="button" class="btn btn-warning" id="modalEditarPedido-btn-si">Guardar cambios</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="modalEditarPedido-btn-no">Cancelar</button>
                    </div>
                </div>
    
            </div>
        </div>
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>
