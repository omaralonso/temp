<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerVentas.jsp" %>

<div class="container">
    <h3 class="text-center">
        <c:choose><c:when test="${swEditar eq 1}">Editar </c:when><c:otherwise>Agregar </c:otherwise></c:choose>una oferta
            </h3>
            <hr>
            <form action="saveOferta" id="form-oferta" method="POST">
                <div id="errores-oferta"></div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="inicio">Fecha de inicio*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="text" name="inicio" id="inicio" class="form-control" value="${oferta.fechaInicio}" readonly='true'>
                    </c:when>
                    <c:otherwise>
                        <input type="text" name="inicio" id="inicio" class="form-control" value="" readonly='true'>
                    </c:otherwise>
                </c:choose>            
            </div>     
            <div class="form-group col-md-6 ">
                <label for="categoria">Categoría*:</label>
                <select  class="form-control" id="categoria" name="categoria">
                    <option value=" " selected="">Seleccione una opción</option>
                    <c:choose>
                        <c:when test="${swEditar eq 1}">
                            <c:forEach items="${listaCategorias}" var="cat">
                                <option value="${cat.idCategoria}" <c:if test="${oferta.categoria.nombreCategoria == cat.nombreCategoria}"> selected</c:if>>${cat.nombreCategoria}</option>
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

        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="fin">Fecha de fin*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="text" name="fin" id="fin" class="form-control" value="${oferta.fechaFin}" readonly='true'>
                    </c:when>
                    <c:otherwise>
                        <input type="text" name="fin" id="fin" class="form-control" value="" readonly='true'>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group col-md-6">
                <label for="porcentaje">Porcentaje*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="hidden" id="idOferta" name="idOferta" value="${oferta.idOferta}">
                        <input value="${oferta.porcentajeOferta}" class="form-control" type="text" id="porcentaje" name="porcentaje">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" id="idOferta" name="idOferta" value="0">
                        <input class="form-control" type="text" id="porcentaje" name="porcentaje">
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </form>
    <div class="form-group pull-right">
        <input type="submit" class="form-control btn btn-warning pull-right" id="btn-registrar-oferta" value="Registrar">
    </div><div class="clearfix"></div>
    <div class="form-group pull-right">
        <a href="${pageContext.request.contextPath}/ventas/listaOfertas" class="form-control btn btn-secondary">Cancelar</a>
    </div><div class="clearfix"></div>

</div>

<%@ include file="../includes/footer.jsp"%>