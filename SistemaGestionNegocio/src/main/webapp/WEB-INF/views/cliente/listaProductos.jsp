<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerCliente.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <form action="productos" method="GET" class="form-inline">
                <label class="mr-sm-2" for="selectCategoria">Categoría</label>
                <select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="selectCategoria" id="selectCategoria">
                    <c:forEach items="${lstCategorias}" var="categoria">
                        <option value="${categoria.idCategoria}"><c:out value="${categoria.nombreCategoria}"></c:out></option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-warning">Buscar</button>
            </form>
            <div class="row text-center">
                <c:forEach items="${lstProductos}" var="producto">
                <div class="col-sm-6 col-md-3">
                    <img src="${producto.imagenProducto}"
                         class="img-fluid">
                    <h4><c:out value="${producto.nombreProducto}"></c:out></h4>
                    <div class="text-muted">Precio: S/.<c:out value="${producto.precioProducto}"></c:out></div>
                    <c:if test="${sessionScope.perfil.codigoPerfil eq 'DIS'}"> 
                        <div class="text-muted">Puntos: <c:out value="${producto.puntosProducto}"></c:out></div>
                    </c:if>
                    <button class="btn btn-warning" data-idproducto="${producto.idProducto}" data-toggle="modal" data-target="#modalAgregarACarrito">Agregar al carrito</button>
                    <button class="btn btn-secondary" data-idproducto="${producto.idProducto}" data-toggle="modal" data-target="#modalDetalleProducto">Más Info...</button>
                </div>
                </c:forEach>
            </div>
            <br>
        </div>
    </div>

    <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="modalDetalleProducto">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="centrar-texto-modal">
                        <h4 class="modal-title" id="myModalLabel">Producto</h4>
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-6 offset-3">
                            <form action="">
                                <div class="form-group">
                                    <label for="txtCategoria">Categoria</label>
                                    <input type="text" class="form-control" id="txtCategoria" disabled >
                                </div>
                                <div class="form-group">
                                    <label for="txtDescripcion">Descripcion del producto</label>
                                    <textarea class="form-control" id="txtDescripcion" disabled></textarea>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="modalAgregarACarrito">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="centrar-texto-modal">
                        <h4 class="modal-title" id="myModalLabel">Producto</h4>
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-6 offset-3">
                            <form action="">
                                <input type="hidden" id="txtIdProducto">
                                <div class="form-group">
                                    <label for="txtCantidad">Cantidad</label>
                                    <input type="text" class="form-control" id="txtCantidad" >
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="centrar-texto-modal">
                        <button type="button" class="btn btn-warning" id="modalAgregarACarrito-btn-si">Agregar al carrito</button>
                        <button type="button" class="btn btn-secondary" id="modalAgregarACarrito-btn-no">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>