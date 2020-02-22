/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.request;

import pe.com.sunshineandina.dto.PedidoTO;

/**
 *
 * @author alonsorn
 */
public class RegistroPedidoRequest {
    
    private String dniCliente;
    private PedidoTO pedido;

    public RegistroPedidoRequest() {
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public PedidoTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoTO pedido) {
        this.pedido = pedido;
    }
}
