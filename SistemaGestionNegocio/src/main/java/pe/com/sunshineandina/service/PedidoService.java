/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.DetallePedidoTO;
import pe.com.sunshineandina.dto.PedidoTO;
import pe.com.sunshineandina.dto.ProductoTO;

/**
 *
 * @author FERNANDO
 */
public interface PedidoService {
    List<PedidoTO> findAllPedidos();
    
    PedidoTO findPedidoById(int id);
    
    void actualizarPedido(PedidoTO pedido);
    
    String nuevoPedido(int idUsuario);
    
    String validarStock(ProductoTO producto, int cantidad) throws Exception;
    
    String registroPedido(String dniCliente, List<DetallePedidoTO> detalles, PedidoTO pedido);
}
