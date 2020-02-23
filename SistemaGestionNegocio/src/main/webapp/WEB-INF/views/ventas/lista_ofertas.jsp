<%@page import="pe.com.brunominelli.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerVentas.jsp" %>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Ofertas</h1>
        <a href="${pageContext.request.contextPath}/ventas/nuevaOferta" class="btn btn-warning pull-right" id="add-oferta-btn">Registrar una oferta</a>
        <div class="clearfix"></div><hr>
    </div>
    <div class="row">
        <table class="table table-hover table-bordered">
            <thead class="thead-inverse">     
            <th></th>
            <th>ID</th>
            <th>Oferta en</th>
            <th>Porcentaje</th>
            <th>Fecha de Inicio</th>
            <th>Fecha de Fin</th>
            </thead>
            <tbody>
                <c:forEach items="${listaOfertas}" var="oferta">
                    <tr>
                        <td class="text-center icon">
                            <button type="submit" class="btn btn-sm btn-editar-oferta" data-toggle="tooltip" data-placement="top" title="Editar la oferta" data-idoferta="${oferta.idOferta}">
                                <span class="fa fa-pencil fa-2x"></span>
                            </button>
                        </td>
                        <td>${oferta.idOferta}</td>
                        <td>${oferta.categoria.nombreCategoria}</td>
                        <td><c:out value="${oferta.porcentajeOferta}"></c:out>%</td>
                        <td>${oferta.fechaInicio}</td>
                        <td>${oferta.fechaFin}</td>
                        </tr>
                </c:forEach>
            </tbody>
        </table>
        <form id="EditFormOferta" action="editarOferta" method="POST">
            <input type="hidden" id="hiddenEditarOferta" name="idOferta" value="">
        </form>
    </div>
</div>


<%@ include file="../includes/footer.jsp"%>

