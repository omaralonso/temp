package pe.com.brunominelli.dao;

import java.util.Date;
import java.util.List;
import pe.com.brunominelli.dto.PedidoTO;

public interface PedidoDAO {
    
    PedidoTO findById(int id);
    
    void save(PedidoTO pedido);
    
    List<PedidoTO> findAllPedidos();
    
    List<PedidoTO> findByCliente(int idCliente);
    
    List<PedidoTO> findByClienteFecha(int idCliente, Date fechaInicio, Date fechaFin);
    
    List<PedidoTO> findByClienteFechaPaginado(int idCliente, Date fechaInicio, Date fechaFin, int inicio, int cantidadPagina);
}
