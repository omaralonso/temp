/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import pe.com.sunshineandina.dto.CarritoTO;

/**
 *
 * @author alonsorn
 */
public interface CarritoDAO {
    
    CarritoTO findById(int id);
    
    void save(CarritoTO carrito);
    
    void destroy(CarritoTO carrito);
    
    CarritoTO findByCliente(int idCliente);
}
