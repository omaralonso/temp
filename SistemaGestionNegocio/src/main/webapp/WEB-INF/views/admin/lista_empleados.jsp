<%-- 
    Document   : lista_usuarios
    Created on : 01/11/2017, 07:31:50 PM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerAdmin.jsp" %>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Lista de Empleados</h1>
        <a href="${pageContext.request.contextPath}/admin/nuevoEmpleado" class="btn btn-warning pull-right" id="add-usuario-btn">Registrar un empleado</a>
        <div class="clearfix"></div><hr>
    </div>
    <div class="row">
        <table class="table table-sm table-hover table-bordered">
            <thead class="thead-inverse">
            <th></th>
            <th>Nombre</th>
            <th>Correo electrónico</th>
            <th>Fecha de registro</th>
            <th>Perfiles</th>
            <th>Estado</th>
            </thead>
            <tbody>
                <c:forEach items="${lstEmpleados}" var="empleado">
                    <tr>
                        <td class="text-center icon">
                            <c:choose>
                                <c:when test="${empleado.usuario.idUsuario!=usuario.idUsuario}">
                                    <button type="submit" class="btn btn-sm btn-editar-empleado" data-toggle="tooltip" data-placement="top" title="Editar el empleado" data-idempleado="${empleado.idEmpleado}">
                                        <span class="fa fa-pencil fa-2x"></span>
                                        <c:if test="${empleado.usuario.estadoUsuario == 1}">
                                            <button class="btn btn-sm btn-cambiar-estado-usuario" data-toggle="tooltip" data-placement="top" title="Archivar el usuario" data-idusuario="${empleado.usuario.idUsuario}">
                                                <span class="fa fa-times-circle fa-2x"></span>
                                            </button>
                                        </c:if>
                                        <c:if test="${empleado.usuario.estadoUsuario == 0}">
                                            <button class="btn btn-sm btn-cambiar-estado-usuario" data-toggle="tooltip" data-placement="top" title="Desarchivar el usuario" data-idusuario="${empleado.usuario.idUsuario}">
                                                <span class="fa fa-refresh fa-2x"></span>
                                            </button>
                                        </c:if> 
                                    </c:when>
                                    <c:otherwise>
                                        <span class="fa fa fa-user-o fa-2x"></span>
                                    </c:otherwise>
                                </c:choose>


                        </td>
                        <td><c:out value="${empleado.primerNombre}"></c:out>  <c:out value="${empleado.primerApellido}"></c:out></td>
                        <td>${empleado.email}</td>
                        <td>${empleado.usuario.fechaRegistro}</td>
                        <td>
                            <c:forEach items="${empleado.usuario.perfiles}" var="perfil">
                                <c:out value="${perfil.codigoPerfil}"></c:out>
                                    <br>
                            </c:forEach>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${empleado.usuario.estadoUsuario eq 1}">
                                    <c:out value="ACTIVO"></c:out>
                                </c:when>
                                <c:when test="${empleado.usuario.estadoUsuario eq 0}">
                                    <c:out value="INACTIVO"></c:out>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form id="EditFormEmpleado" action="editarEmpleado" method="POST">
            <input type="hidden" id="hiddenEditarEmpleado" name="idEmpleado" value="">
        </form>
    </div>

</div>

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalEmpleadoInactivar">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <div class="centrar-texto-modal">
                    <h4 class="modal-title" id="mySmallModalLabel">Confirmar</h4>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p class="text-center">¿Está seguro de desactivar al empleado?</p>
                <input type="hidden" name="idUsuario">
            </div>
            <div class="modal-footer">
                <div class="centrar-texto-modal">
                    <button type="button" class="btn btn-danger" id="modalEmpleadoInactivar-btn-si">Si</button>
                    <button type="button" class="btn btn-secondary" id="modalEmpleadoInactivar-btn-no">No</button>
                </div>
            </div>

        </div>
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>
