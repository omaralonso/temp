package pe.com.brunominelli.dao;

import java.util.List;
import pe.com.brunominelli.dto.DetallePedidoTO;

public interface DetallePedidoDAO {
    
    void save(DetallePedidoTO detallePedido);
    
    DetallePedidoTO findById(int id);
    
    List<DetallePedidoDAO> findByPedido(int idPedido);
}
