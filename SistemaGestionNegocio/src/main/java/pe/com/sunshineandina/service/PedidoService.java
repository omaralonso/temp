package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.DetallePedidoTO;
import pe.com.sunshineandina.dto.PedidoTO;
import pe.com.sunshineandina.dto.ProductoTO;

public interface PedidoService {
    List<PedidoTO> findAllPedidos();
    
    PedidoTO findPedidoById(int id);
    
    List<PedidoTO> findPedidoByIdUsuario(int idUsuario);
    
    void actualizarPedido(PedidoTO pedido);
    
    String nuevoPedido(int idUsuario);
    
    String validarStock(ProductoTO producto, int cantidad) throws Exception;
    
    String registroPedido(String dniCliente, List<DetallePedidoTO> detalles, PedidoTO pedido);
}
