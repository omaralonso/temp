package pe.com.brunominelli.dao;

import java.util.List;
import pe.com.brunominelli.dto.DetalleCarritoTO;

public interface DetalleCarritoDAO {
    
    DetalleCarritoTO findById(int id);
    
    void save(DetalleCarritoTO detalleCarrito);
    
    List<DetalleCarritoTO> findByCarrito(int idCarrito);
    
    DetalleCarritoTO findByProducto(int idProducto);
}
