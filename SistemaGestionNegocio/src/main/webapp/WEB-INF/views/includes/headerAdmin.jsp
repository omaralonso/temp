<%-- 
    Document   : headerAdmin
    Created on : 03/11/2017, 01:10:02 PM
    Author     : FERNANDO
--%>

<%@ include file="../includes/head.jsp"%>

<%@ include file="../includes/navhead.jsp"%>

<!-- Cuerpo nav -->
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/listaEmpleados">Empleados</a>
    </li>
</ul>

<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/listaPoliticas">Políticas de negocio</a>
    </li>
</ul>

<!-- Fin cuerpo nav -->

<%@ include file="../includes/navfooter.jsp"%>
