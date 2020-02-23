<%@ include file="../includes/head.jsp"%>

<%@ include file="../includes/navhead.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!-- Cuerpo nav -->
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/tienda/productos">
            <i class="fa fa-shopping-basket" aria-hidden="true"></i>
            Tienda
        </a>
    </li>
</ul>

<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/carrito/detalle">
            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
            Carrito de compras
        </a>
    </li>
</ul>

<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/cliente/listapedidos">
            <i class="fa fa-shopping-bag" aria-hidden="true"></i>
            Mis Pedidos
        </a>
    </li>
</ul>
         
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/informacion/acercade">
            <i class="fa fa-money" aria-hidden="true"></i>
            Acerca de
        </a>
    </li>
</ul>
<!-- Fin cuerpo nav -->

<%@ include file="../includes/navfooter.jsp"%>
