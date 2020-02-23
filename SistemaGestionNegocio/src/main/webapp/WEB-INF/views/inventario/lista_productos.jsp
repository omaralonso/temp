<%@page import="pe.com.brunominelli.dto.CategoriaTO"%>
<%@page import="pe.com.brunominelli.dto.ProductoTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerInventario.jsp"%>


<c:set var="listaProductos" scope="session" value="${listaProductos}"/>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Productos</h1>
        <a href="${pageContext.request.contextPath}/inventario/nuevoProducto" class="btn btn-warning pull-right" id="add-producto-btn">Registrar un producto</a>
        <div class="clearfix"></div><hr>
    </div>
    <div class="row">
        <table class="table table-sm table-hover table-bordered">
            <thead class="thead-inverse thead-lg">
            <th></th>
            <th>Nombre</th>
            <th>Categoría</th>
            <th>Cantidad</th>
            <th>Precio</th>
            <th>Puntos</th>
            <th>Disponible</th>
            </thead>
            <tbody>

                <c:forEach items="${listaProductos}" var="producto">
                    <tr>
                        <td class="text-center icon">
                            <button type="submit" class="btn btn-sm btn-editar-producto" data-toggle="tooltip" data-placement="top" title="Editar el producto" data-idproducto="${producto.idProducto}">
                                <span class="fa fa-pencil fa-2x"></span>
                            </button>
                            <c:if test="${producto.estadoProducto == 1}">
                                <button class="btn btn-sm btn-cambiar-estado-producto" data-toggle="tooltip" data-placement="top" title="Archivar el producto" data-idproducto="${producto.idProducto}">
                                    <span class="fa fa-times-circle fa-2x"></span>
                                </button>
                            </c:if>
                            <c:if test="${producto.estadoProducto == 0}">
                                <button class="btn btn-sm btn-cambiar-estado-producto" data-toggle="tooltip" data-placement="top" title="Desarchivar el producto" data-idproducto="${producto.idProducto}">
                                    <span class="fa fa-refresh fa-2x"></span>
                                </button>
                            </c:if>  

                        </td>
                        <td>${producto.nombreProducto}</td>
                        <td>${producto.categoria.nombreCategoria}</td>
                        <td>${producto.stockProducto}</td>
                        <td>${producto.precioProducto}</td>
                        <td>${producto.puntosProducto}</td>
                        <td>
                            <c:if test="${producto.estadoProducto == 1}">Sí</c:if>
                            <c:if test="${producto.estadoProducto == 0}">No</c:if>  
                            </td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
        <form id="EditFormProducto" action="editarProducto" method="POST">
            <input type="hidden" id="hiddenEditarProducto" name="idProducto" value="">
        </form>
    </div>

</div>

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="modalCategoriaApagada">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <form>
                        <input type="hidden" name="hiddenIdCategoria" id="hiddenIdCategoria">
                        <input type="hidden" name="hiddenIdProducto" id="hiddenIdProducto">
                        <h5 class="text-center">Para activar el producto, su categoria tambien debe estar activa</h5>
                        <h5 class="text-center">¿Desea activarla?</h5>
                    </form>
                </div>
                <div class="modal-footer">
                    <div class="centrar-texto-modal">
                        <button type="button" class="btn btn-warning" id="modalCategoriaApagada-btn-si">Sí</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="modalCategoriaApagada-btn-no">Cancelar</button>
                    </div>
                </div>
    
            </div>
        </div>
    </div>

<%@ include file="../includes/footer.jsp"%>
