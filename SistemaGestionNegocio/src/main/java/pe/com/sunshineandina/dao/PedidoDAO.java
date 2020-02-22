/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.Date;
import java.util.List;
import pe.com.sunshineandina.dto.PedidoTO;

/**
 *
 * @author alonsorn
 */
public interface PedidoDAO {
    
    PedidoTO findById(int id);
    
    void save(PedidoTO pedido);
    
    List<PedidoTO> findAllPedidos();
    
    List<PedidoTO> findByCliente(int idCliente);
    
    List<PedidoTO> findByClienteFecha(int idCliente, Date fechaInicio, Date fechaFin);
    
    List<PedidoTO> findByClienteFechaPaginado(int idCliente, Date fechaInicio, Date fechaFin, int inicio, int cantidadPagina);
}
