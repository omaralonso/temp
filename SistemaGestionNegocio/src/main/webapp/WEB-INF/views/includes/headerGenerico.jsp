<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${sessionScope.perfil.codigoPerfil eq 'ADM'}">
        <%@include file="../includes/headerAdmin.jsp" %>
    </c:when>
    <c:when test="${sessionScope.perfil.codigoPerfil eq 'INV'}">
        <%@include file="../includes/headerInventario.jsp" %>
    </c:when>
    <c:when test="${sessionScope.perfil.codigoPerfil eq 'VEN'}">
        <%@include file="../includes/headerVentas.jsp" %>
    </c:when>
    <c:when test="${sessionScope.perfil.codigoPerfil eq 'DIS'}">
        <%@include file="../includes/headerCliente.jsp" %>
    </c:when>
    <c:when test="${sessionScope.perfil.codigoPerfil eq 'CLI'}">
        <%@include file="../includes/headerCliente.jsp" %>
    </c:when>
</c:choose>

