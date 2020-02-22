<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../includes/headerLogin.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-6 offset-md-3 login">
            <h3>Ingresar a la plataforma</h3>
            <br>
            <form action="login" method="POST">
                <div class="form-group">
                    <label for="usuario">Ingrese usuario: </label>
                    <input id="usuario" name="usuario" type="text" class="form-control">    
                </div>
                <br>
                <div class="form-group">
                    <label for="password">Ingrese contraseña:</label>
                    <input id="password" name="password" type="password" class="form-control">
                </div>
                <br>
                <button class="btn btn-warning" type="submit">Ingresar</button> 
            </form>     
        </div>
    </div>

    <br><br> 
</div>


<%@include file="../includes/footer.jsp" %>