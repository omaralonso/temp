/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.DetallePedidoTO;

/**
 *
 * @author alonsorn
 */
public interface DetallePedidoDAO {
    
    void save(DetallePedidoTO detallePedido);
    
    DetallePedidoTO findById(int id);
    
    List<DetallePedidoDAO> findByPedido(int idPedido);
}
