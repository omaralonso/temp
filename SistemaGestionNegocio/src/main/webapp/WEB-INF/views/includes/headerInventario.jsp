<%-- 
    Document   : headerInventario
    Created on : 03/11/2017, 01:09:54 PM
    Author     : FERNANDO
--%>


<%@ include file="../includes/head.jsp"%>

<%@ include file="../includes/navhead.jsp"%>

<!-- Cuerpo nav -->
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/inventario/listaProductos">Productos</a>
    </li>
</ul>

<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/inventario/listaCategorias">Categor�as</a>
    </li>
</ul>

<!-- Fin cuerpo nav -->

<%@ include file="../includes/navfooter.jsp"%>