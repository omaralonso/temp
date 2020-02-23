package pe.com.sunshineandina.dao;

import pe.com.sunshineandina.dto.CarritoTO;

public interface CarritoDAO {
    
    CarritoTO findById(int id);
    
    void save(CarritoTO carrito);
    
    void destroy(CarritoTO carrito);
    
    CarritoTO findByCliente(int idCliente);
}
