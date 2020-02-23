<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerAdmin.jsp" %>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Lista de Políticas de Negocio</h1>
        <hr>
    </div>
    <div class="row">
        <table class="table table-sm table-hover table-bordered">
            <thead class="thead-inverse">
            <th></th>
            <th>Política</th>
            <th>Puntos mínimos individuales</th>
            <th>Puntos mínimos grupales</th>
            <th>Puntos máximos grupales</th>
            <th>Porcentaje de descuento</th>
            </thead>
            <tbody>
                <c:forEach items="${lstPoliticas}" var="politica">
                <tr>
                    <td class="text-center icon">
                        <button class="btn btn-sm btn-editar-politica" data-toggle="modal" data-target="#modalEditarPolitica" data-idpolitica="${politica.idPolitica}">
                            <span class="fa fa-pencil fa-2x"></span>
                        </button>
                    </td>
                    <td>${politica.descPolitica}</td>
                    <td>${politica.minPuntosIndividual}</td>
                    <td>${politica.minPuntosGrupal}</td>
                    <td>${politica.maxPuntosGrupal}</td>
                    <td>${politica.porcentajeDescuento}</td>  
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="modalEditarPolitica">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="centrar-texto-modal">
                        <h4 class="modal-title" id="myModalLabel">Editar Política</h4>
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-6 offset-3">
                            <form action="">
                                <input type="hidden" name="idpolitica">
                                <div class="form-group">
                                    <label for="txtPolitica">Politica</label>
                                    <input type="text" class="form-control" name="politica" id="txtPolitica" disabled >
                                </div>
                                <div class="form-group">
                                    <label for="txtPuntosMinInd">Mínimo de puntos individuales</label>
                                    <input type="text" class="form-control" name="minPuntos" id="txtPuntosMinInd">
                                </div>
                                <div class="form-group">
                                    <label for="txtPuntosMaxInd">Máximo de puntos individuales</label>
                                    <input type="text" class="form-control" name="maxPuntos" id="txtPuntosMaxInd">
                                </div>
                                <div class="form-group">
                                    <label for="txtPuntosMinGru">Mínimo de puntos grupales</label>
                                    <input type="text" class="form-control" name="minPuntos" id="txtPuntosMinGru">
                                </div>
                                <div class="form-group">
                                    <label for="txtPuntosMaxGru">Mínimo de puntos grupales</label>
                                    <input type="text" class="form-control" name="minPuntos" id="txtPuntosMaxGru">
                                </div>
                                <div class="form-group">
                                    <label for="txtPorcentaje">Porcentaje de descuento</label>
                                    <input type="text" class="form-control" name="porcentaje" id="txtPorcentaje">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="centrar-texto-modal">
                        <button type="button" class="btn btn-warning" id="modalEditarPolitica-btn-si">Guardar cambios</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="modalEditarPolitica-btn-no">Cancelar</button>
                    </div>
                </div>
    
            </div>
        </div>
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>
