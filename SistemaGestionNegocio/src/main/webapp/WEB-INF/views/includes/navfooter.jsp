<!-- Nav Footer -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${sessionScope.nombrePerfil != null}">
    <div class="my-2 my-lg-0">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown mr-sm-5 asd">
                <a class="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="fa fa-user-circle fa-lg drop"><c:out value="${sessionScope.nombrePerfil}"></c:out></span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/perfil">Perfil</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/cambiarContraseña">Cambiar contraseña</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/cerrarSesion">Cerrar sesión</a>
                </div>
            </li>
        </ul>
    </div>
</c:if>
</div>
</nav>
</header>
<!-- Fin Nav Footer -->
