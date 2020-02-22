<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <%@include file="../includes/headerVentas.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="offset-md-3 col-md-6 col-sm-12">
                    <div id="registrarPedidoAlert"></div>
                    <div class="row">
                        <div class="form-group col-md-3 col-sm-12">
                            <label for="txtDniCliente">DNI del Cliente:</label>
                            <input id="txtDniCliente" type="text" maxlength="8" minlength="8" class="form-control">
                        </div>
                    </div>
                    <br>
                    <table class="table table-responsive table-hover table-bordered" id="tablePedido">
                        <thead class="thead-inverse">
                            <tr>
                                <th>Producto</th>
                                <th>Precio S/.</th>
                                <th>Puntos</th>
                                <th>Cantidad</th>
                                <th>Subtotal S/.</th>
                                <th>Subtotal Puntos</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                    <div class="pull-right">
                        <button class="btn btn-success" id="btnAddProductoPedido" data-toggle="modal" data-target="#modalAddProductoPedido">Añadir Producto</button>
                        <button class="btn btn-warning" id="btnVentasRegistrarPedido" data-toggle="modal" data-target="#modalRegistrarPedido">Registrar Pedido</button>
                        <button class="btn btn-secondary" id="btnVentasCancelarPedido">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="modalAddProductoPedido">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="centrar-texto-modal">
                            <h4 class="modal-title" id="myModalLabel">Añadir Producto</h4>
                        </div>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div id="modalAddProductoAlert"></div>
                        <form>
                            <div class="form-group">
                                <label for="categoria">Seleccione la categoria:</label>
                                <select name="categoria" id="categoria" class="form-control"></select>
                            </div>
                            <br>
                            <div class="form-group">
                                <label for="producto">Seleccione el producto:</label>
                                <select name="producto" id="producto" class="form-control"></select>
                            </div>
                            <div class="form-group">
                                <label for="cantidad">Ingrese la cantidad:</label>
                                <input id="cantidad" type="text" class="form-control">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <div class="centrar-texto-modal">
                            <button type="button" class="btn btn-warning" id="modalAddProductoPedido-btn-si">Añadir al Pedido</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="modalRegistrarPedido">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="centrar-texto-modal">
                            <h4 class="modal-title" id="myModalLabel">Registrar Pedido</h4>
                        </div>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>¿Seguro que desea registrar el pedido?</p>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-warning" id="modalRegistrarPedido-btn-si">Si</button>
                        <button class="btn btn-secondary" data-dismiss="modal">No</button>
                    </div>
                </div>
            </div>
        </div>


        <%@ include file="../includes/footer.jsp"%>