package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.DetalleCarritoTO;

public interface DetalleCarritoDAO {
    
    DetalleCarritoTO findById(int id);
    
    void save(DetalleCarritoTO detalleCarrito);
    
    List<DetalleCarritoTO> findByCarrito(int idCarrito);
    
    DetalleCarritoTO findByProducto(int idProducto);
}
