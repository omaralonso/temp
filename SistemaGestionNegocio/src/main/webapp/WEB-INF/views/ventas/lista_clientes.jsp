<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerVentas.jsp" %>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Clientes</h1>
        <div class="clearfix"></div><hr>
    </div>
    <div class="row">
        <table class="table table-hover table-bordered">
            <thead class="thead-inverse">      
                <tr>
                    <th>DNI</th>
                    <th>Cliente</th>
                    <th>Teléfono</th>
                    <th>Correo electrónico</th>
                    <th>Tipo de cliente</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaClientes}" var="cliente">
                    <tr>
                        <td>${cliente.dni}</td>
                        <td id="nombreCliente"><c:out value="${cliente.primerNombre}"></c:out> <c:out value="${cliente.primerApellido}"></c:out></td>
                        <td>${cliente.telefonoCelular}</td>
                        <td>${cliente.email}</td>
                        <td>
                            <button class="btn btn-sm btn-editar-cliente" data-toggle="modal" data-target="#modalEditarCliente" data-idcliente="${cliente.idCliente}">
                                <span class="fa fa-pencil fa-2x"></span>
                            </button>
                            NORMAL
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    
    <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="modalEditarCliente">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="centrar-texto-modal">
                        <h4 class="modal-title" id="myModalLabel"></h4>
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <form>
                        <input type="hidden" name="idcliente">
                        <select  class="form-control" name="cliente" id="txtCliente">
                            <option value="">Normal</option>
                        </select>
                        <p><small><b>Nota:</b> Actualmente solo se soporta 1 tipo de cliente</small></p>
                    </form>
                </div>
                <div class="modal-footer">
                    <div class="centrar-texto-modal">
                        <button type="button" class="btn btn-warning" id="modalEditarCliente-btn-si">Guardar cambios</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="modalEditarCliente-btn-no">Cancelar</button>
                    </div>
                </div>
    
            </div>
        </div>
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>
