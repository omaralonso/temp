package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.DetallePedidoTO;

public interface DetallePedidoDAO {
    
    void save(DetallePedidoTO detallePedido);
    
    DetallePedidoTO findById(int id);
    
    List<DetallePedidoDAO> findByPedido(int idPedido);
}
