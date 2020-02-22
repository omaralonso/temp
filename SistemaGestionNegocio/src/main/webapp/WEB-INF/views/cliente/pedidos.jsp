<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerCliente.jsp" %>

<div class="container-fluid">
        
    <div class="row">
        <c:if test="${pedidos != null}">
        <div class="col-md-11 col-sm-11">
            <h1>Lista de pedidos</h1>
            <table class="table table-bordered table-hover">
                <thead class="thead-inverse">
                    <tr>
                        <th>ID</th>
                        <th>Estado</th>
                        <th>Precio total</th>
                        <th>Puntos acumulados</th>
                        <th>Fecha</th>
                        <th>Detalle</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${pedidos}" var="pedido">
                    <tr>
                        <td><c:out value="${pedido.idPedido}"></c:out></td>
                        <td><c:out value="${pedido.estadoPedido}"></c:out></td>
                        <td>S/. <c:out value="${pedido.precioAcumuladoPedido}"></c:out></td>
                        <td><c:out value="${pedido.puntosAcumuladoPedido}"></c:out></td>
                        <td><c:out value="${pedido.fechaCreacion}"></c:out></td>
                        <td>
                            <c:forEach items="${pedido.detallePedidos}" var="detallePedidos">
                                <p>Producto: ${detallePedidos.producto.nombreProducto}</p>
                                <ul>
                                    <li>Cantidad: ${detallePedidos.cantidad}</li>
                                    <li>Precio: ${detallePedidos.producto.precioProducto}</li>
                                    <li>Puntos: ${detallePedidos.producto.puntosProducto}</li>
                                    <li>Precio total: ${detallePedidos.precioDetallePedido}</li>
                                    <li>Puntos total: ${detallePedidos.puntosDetallePedido}</li> 
                                </ul>
                            </c:forEach>
                        </td>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </c:if>
        
        <c:if test="${pedidos == null}">
        
        <div class="offset-md-4 col-md-4 col-sm-4">
            <div class="card text-center">
                <div class="card-block">
                  <h4 class="card-title">Lista de pedidos</h4>
                  <p class="card-text">No tienes ningún pedido</p>
                </div>
            </div>
        </div>
        </c:if>
        
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>