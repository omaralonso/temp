package pe.com.brunominelli.request;

import pe.com.brunominelli.dto.PedidoTO;

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
