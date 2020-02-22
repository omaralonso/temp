<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/head.jsp" %>

<%@include file="../includes/headerGenerico.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 offset-md-3 col-sm-12">
            <form action="actualizarDatos" method="POST">
                <c:if test="${sessionScope.swCliente eq 1}">
                <div class="form-group">
                    <label for="dni">DNI:</label>
                    <input type="text" class="form-control" id="dni" disabled value="${dni}">
                </div>
                </c:if>
                <c:if test="${sessionScope.swCliente eq 0}">
                <div class="form-group">
                    <label for="ruc">RUC:</label>
                    <input type="text" class="form-control" id="ruc" disabled value="${ruc}">
                </div>
                </c:if>
                <div class="row">
                    <div class="col-md-6 col-sm-12">
                        <div class="form-group">
                            <label for="primerNombre">Primer nombre: </label>
                            <input type="text" class="form-control" id="primerNombre" disabled value="${primerNombre}">
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12">
                        <div class="form-group">
                            <label for="segundoNombre">Segundo nombre: </label>
                            <input type="text" class="form-control" id="segundoNombre" disabled value="${segundoNombre}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-sm-12">
                        <div class="form-group">
                             <label for="primerApellido">Primer apellido: </label>
                             <input type="text" class="form-control" id="primerApellido" disabled value="${primerApellido}">
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12">
                        <div class="form-group">
                            <label for="segundoApellido">Segundo Apellido:</label>
                            <input type="text" class="form-control" id="segundoApellido" disabled value="${segundoApellido}">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-sm-12">
                        <div class="form-group">
                            <label for="telCelular">Teléfono Celular</label>
                            <input type="text" class="form-control" id="telCelular" name="telCelular" value="${telCelular}">
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12">
                        <div class="form-group">
                            <label for="telFijo">Teléfono Fijo:</label>
                            <input type="text" class="form-control" id="telFijo" name="telFijo" value="${telFijo}">
                        </div>
                    </div>
                </div>
                <c:if test="${sessionScope.swCliente eq 1}">
                <div class="form-group">
                    <label for="direccion">Direccion:</label>
                    <input type="text" class="form-control" id="direccion" name="direccion" value="${direccion}">
                </div>
                </c:if>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" value="${email}">
                </div>
                <button class="btn btn-warning">Guardar cambios</button>
                <a href="${pageContext.request.contextPath}/perfil" class="btn btn-secondary">Cancelar</a>
            </form>
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp" %>