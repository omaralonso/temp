<%-- 
    Document   : headerVentas
    Created on : 03/11/2017, 01:10:28 PM
    Author     : FERNANDO
--%>


<%@include file="../includes/head.jsp" %>

<%@include file="../includes/navhead.jsp" %>

<!-- Cuerpo nav -->
<!--
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/ventas/dashboard">Dashboard</a>
    </li>
</ul>
-->

<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/ventas/listaPedidos">Pedidos</a>
    </li>
</ul>   

<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/ventas/listaClientes">Clientes</a>
    </li>
</ul>

<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/ventas/listaOfertas">Ofertas</a>
    </li>
</ul>

<!-- Fin cuerpo nav -->

<%@include file="../includes/navfooter.jsp" %>
