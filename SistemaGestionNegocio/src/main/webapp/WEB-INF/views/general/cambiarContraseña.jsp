<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/head.jsp" %>

<%@include file="../includes/headerGenerico.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-6 offset-3">
            <div id="alert-wrapper">
                
            </div>
            <form action="">
                <div class="form-group">
                    <label for="passwordActual">Ingrese su contraseña:</label>
                    <input type="password" class="form-control" name="passwordActual" id="passwordActual">
                </div>
                <div class="form-group">
                    <label for="passwordNueva">Ingrese su nueva contraseña:</label>
                    <input type="password" class="form-control" name="passwordNueva" id="passwordNueva">
                </div>
                <div class="form-group">
                    <label for="passwordConfirmacion">Ingrese su nueva contraseña otra vez: </label>
                    <input type="password" class="form-control" name="passwordConfirmacion" id="passwordConfirmacion">
                </div>
                <button class="btn btn-warning" id="submitPassword" type="submit">Guardar contraseña</button>
                <button class="btn btn-secondary" id="btnCancelarPassword">Cancelar</button>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalPassword">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <div class="centrar-texto-modal">
                    <h4 class="modal-title" id="myModalLabel">Confirmar</h4>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p class="text-center">¿Está seguro que desea cambiar su contraseña?</p>
            </div>
            <div class="modal-footer">
                <div class="centrar-texto-modal">
                    <button type="button" class="btn btn-danger" id="modalPassword-btn-si">Si</button>
                    <button type="button" class="btn btn-secondary" id="modalPassword-btn-no">No</button>
                </div>
            </div>

        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp" %>