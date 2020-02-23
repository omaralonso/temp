package pe.com.brunominelli.service;

import pe.com.brunominelli.dto.CarritoTO;
import pe.com.brunominelli.dto.ClienteTO;

public interface CarritoService {
    
    String insertarDetalleAndCarrito(ClienteTO cliente, int idProducto, int cantidad);
    
    String insertarDetalle(int idUsuario, int idProducto, int cantidad);
    
    CarritoTO findByUsuario(int idUsuario);
}
