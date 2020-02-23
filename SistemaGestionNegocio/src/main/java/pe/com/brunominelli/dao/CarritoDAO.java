package pe.com.brunominelli.dao;

import pe.com.brunominelli.dto.CarritoTO;

public interface CarritoDAO {
    
    CarritoTO findById(int id);
    
    void save(CarritoTO carrito);
    
    void destroy(CarritoTO carrito);
    
    CarritoTO findByCliente(int idCliente);
}
