
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerCliente.jsp" %>

<div class="container">
    <input type="hidden" id="idDistribuidor" value="${distribuidor.idDistribuidor}">
    <div class="row">
        <div class="col-12">
            <h1>Comisión de: <c:out value="${sessionScope.nombrePerfil}"></c:out></h1>
            <c:if test="${comision != null}">
                <h2>Monto a recibir en este periodo: <c:out value="S/.${comision.montoComision}"></c:out></h2>
            </c:if>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <h3>Actividad de mi grupo - Ventas</h3>
            <canvas id="cuadroComisiones"></canvas>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/lib/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/js/comisiones.js"></script>

<%@ include file="../includes/footer.jsp"%>
