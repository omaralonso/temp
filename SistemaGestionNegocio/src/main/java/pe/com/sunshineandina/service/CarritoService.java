/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import pe.com.sunshineandina.dto.CarritoTO;
import pe.com.sunshineandina.dto.ClienteTO;

/**
 *
 * @author alonsorn
 */
public interface CarritoService {
    
    String insertarDetalleAndCarrito(ClienteTO cliente, int idProducto, int cantidad);
    
    String insertarDetalle(int idUsuario, int idProducto, int cantidad);
    
    CarritoTO findByUsuario(int idUsuario);
}
