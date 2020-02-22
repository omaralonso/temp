/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.DetalleCarritoTO;

/**
 *
 * @author alonsorn
 */
public interface DetalleCarritoDAO {
    
    DetalleCarritoTO findById(int id);
    
    void save(DetalleCarritoTO detalleCarrito);
    
    List<DetalleCarritoTO> findByCarrito(int idCarrito);
    
    DetalleCarritoTO findByProducto(int idProducto);
}
