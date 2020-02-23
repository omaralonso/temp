<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerInventario.jsp"%>

<div class="container">
    <h3 class="text-center">
        <c:choose><c:when test="${swEditar eq 1}">Editar </c:when><c:otherwise>Agregar </c:otherwise></c:choose>un producto
            </h3>
            <hr>
            <form action="saveProducto" id="form-producto" method="POST">
                <div id="errores-producto"></div>
                <div class="row">
                    <div class="form-group col-md-3">
                        <label for="nombre">Nombre*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="hidden" name="idProducto" id="idProducto" value="${producto.idProducto}">
                        <input value="${producto.nombreProducto}" class="form-control" type="text" id="nombre" name="nombre">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="idProducto" id="idProducto" value="0">
                        <input class="form-control" type="text" id="nombre" name="nombre">
                    </c:otherwise>
                </c:choose>

            </div>
            <div class="form-group col-md-3">
                <label for="categoria">Categoría*:</label>
                <select class="form-control" id="categoria" name="categoria">
                    <option value=" " selected="">Seleccione una opción</option>
                    <c:choose>
                        <c:when test="${swEditar eq 1}">
                            <c:forEach items="${listaCategorias}" var="cat">
                                <option value="${cat.idCategoria}" <c:if test="${producto.categoria.nombreCategoria == cat.nombreCategoria}"> selected</c:if>>${cat.nombreCategoria}</option>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${listaCategorias}" var="cat">
                                <option value="${cat.idCategoria}">${cat.nombreCategoria}</option>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="precio">Precio*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="text" name="precio" id="precio" class="form-control" value="${producto.precioProducto}">
                    </c:when>
                    <c:otherwise>
                        <input type="text" name="precio" id="precio" class="form-control" value="">
                    </c:otherwise>
                </c:choose>            
            </div>
            <div class="form-group col-md-2">
                <label for="puntos">Puntos*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="text" name="puntos" id="puntos" class="form-control" value="${producto.puntosProducto}">
                    </c:when>
                    <c:otherwise>
                        <input type="text" name="puntos" id="puntos" class="form-control" value="">
                    </c:otherwise>
                </c:choose>

            </div>
            <div class="form-group col-md-2">
                <label for="cantidad">Cantidad*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="text" name="cantidad" id="cantidad" class="form-control" value="${producto.stockProducto}">
                    </c:when>
                    <c:otherwise>
                        <input type="text" name="cantidad" id="cantidad" class="form-control" value="">
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="imagen">Imagen del producto:</label>
                <!-- fallé :v -->
                <input type="file" name="imagen" class="form-control" id="imagen">
            </div>
            <div class="form-group col-md-6">
                <label for="descripcion">Descripción:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <textarea name="descripcion" id="descripcion" class="form-control" rows="6">${producto.descripcionProducto}</textarea>
                    </c:when>
                    <c:otherwise>
                        <textarea name="descripcion" id="descripcion" class="form-control" rows="6"></textarea>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </form>
    <div class="form-group pull-right">
        <input type="submit" class="form-control btn btn-warning pull-right" id="btn-registrar-producto" value="Registrar">
    </div><div class="clearfix"></div>
    <div class="form-group pull-right">
        <a href="${pageContext.request.contextPath}/inventario/listaProductos" class="form-control btn btn-secondary">Cancelar</a>
    </div><div class="clearfix"></div>

</div>

<%@ include file="../includes/footer.jsp"%>