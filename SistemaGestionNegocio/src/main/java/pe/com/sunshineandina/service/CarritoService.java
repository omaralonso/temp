package pe.com.sunshineandina.service;

import pe.com.sunshineandina.dto.CarritoTO;
import pe.com.sunshineandina.dto.ClienteTO;

public interface CarritoService {
    
    String insertarDetalleAndCarrito(ClienteTO cliente, int idProducto, int cantidad);
    
    String insertarDetalle(int idUsuario, int idProducto, int cantidad);
    
    CarritoTO findByUsuario(int idUsuario);
}
