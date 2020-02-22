<%-- 
    Document   : usuario
    Created on : 01/11/2017, 07:31:50 PM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerAdmin.jsp" %>

<div class="container">
    <h3 class="text-center">
        <c:choose><c:when test="${swEditar eq 1}">Editar </c:when><c:otherwise>Agregar </c:otherwise></c:choose>un empleado
            </h3>
    <hr>
    <form action="saveEmpleado" method="POST">
        <div id="errores-empleado"></div>
        <div class="row">
            <div class="form-group col-4">
                <label for="usuario">Usuario*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="hidden" name="idEmpleado" id="idEmpleado" value="${empleado.idEmpleado}">
                        <input type="text" class="form-control" name="usuario" id="usuario" value="${empleado.usuario.registroUsuario}">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" name="idEmpleado" id="idEmpleado" value="0">
                        <input type="text" class="form-control" name="usuario" id="usuario" value="">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group col-4">
                <label for="password">Contraseña*: </label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="password" class="form-control text-center" name="password" id="password" placeholder="Actualizar contraseña">
                    </c:when>
                    <c:otherwise>
                        <input type="password" class="form-control" name="password" id="password">
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="form-group col-4">
                <label for="ruc">RUC*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="text" class="form-control" name="ruc" id="ruc" value="${empleado.ruc}">
                    </c:when>
                    <c:otherwise>
                        <input type="text" class="form-control" name="ruc" id="ruc">
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <div class="row">
            <div class="col-8">
                <div class="row">
                    <div class="form-group col-6">
                        <label for="primerNombre">Primer Nombre*:</label>
                        <c:choose>
                            <c:when test="${swEditar eq 1}">
                                <input type="text" class="form-control" name="primerNombre" id="primerNombre" value="${empleado.primerNombre}">
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="form-control" name="primerNombre" id="primerNombre">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="form-group col-6">
                        <label for="segundoNombre">Segundo Nombre:</label>
                        <c:choose>
                            <c:when test="${swEditar eq 1}">
                                <input type="text" class="form-control" name="segundoNombre" id="segundoNombre" value="${empleado.segundoNombre}">
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="form-control" name="segundoNombre" id="segundoNombre">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="primerApellido">Primer Apellido*:</label>
                        <c:choose>
                            <c:when test="${swEditar eq 1}">
                                <input type="text" class="form-control" name="primerApellido" id="primerApellido" value="${empleado.primerApellido}">
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="form-control" name="primerApellido" id="primerApellido">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="form-group col-6">
                        <label for="segundoApellido">Segundo Apellido*:</label>
                        <c:choose>
                            <c:when test="${swEditar eq 1}">
                                <input type="text" class="form-control" name="segundoApellido" id="segundoApellido" value="${empleado.segundoApellido}">
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="form-control" name="segundoApellido" id="segundoApellido">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <fieldset class="form-group col-4">
                <legend>Perfiles*:</legend>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <c:forEach items="${lstPerfiles}" var="perfil">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="perfiles" name="perfiles" value="${perfil.codigoPerfil}" <c:forEach items="${empleado.usuario.perfiles}" var="userperfil">
                                               <c:if test="${userperfil.codigoPerfil==perfil.codigoPerfil}"> checked</c:if>
                                           </c:forEach>>
                                    <c:out value="${perfil.descPerfil}"></c:out>
                                    </label>
                                </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${lstPerfiles}" var="perfil">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" name="perfiles" value="${perfil.codigoPerfil}">
                                    <c:out value="${perfil.descPerfil}"></c:out>
                                    </label>
                                </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </fieldset>
        </div>

        <div class="row">
            <div class="form-group col-3">
                <label for="telFijo">Teléfono Fijo:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="text" class="form-control" name="telFijo" id="telFijo" value="${empleado.telefonoFijo}">
                    </c:when>
                    <c:otherwise>
                        <input type="text" class="form-control" name="telFijo" id="telFijo">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group col-3">
                <label for="telCelular">Teléfono Celular*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="text" class="form-control" name="telCelular" id="telCelular" value="${empleado.telefonoCelular}">
                    </c:when>
                    <c:otherwise>
                        <input type="text" class="form-control" name="telCelular" id="telCelular">
                    </c:otherwise>
                </c:choose> 
            </div>
            <div class="form-group col-6">
                <label for="email">Email*:</label>
                <c:choose>
                    <c:when test="${swEditar eq 1}">
                        <input type="text" class="form-control" name="email" id="email" value="${empleado.email}">
                    </c:when>
                    <c:otherwise>
                        <input type="text" class="form-control" name="email" id="email">
                    </c:otherwise>
                </c:choose>
            </div>
        </div>     
    </form>
    <div class="form-group pull-right">
        <input type="submit" class="form-control btn btn-warning pull-right" id="btn-registrar-empleado" value="Registrar">
    </div><div class="clearfix"></div>
        <div class="form-group pull-right">
            <a href="${pageContext.request.contextPath}/admin/listaEmpleados" class="form-control btn btn-secondary">Cancelar</a>
        </div><div class="clearfix"></div>
</div>

<%@ include file="../includes/footer.jsp"%>