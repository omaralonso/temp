/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.ClienteTO;

/**
 *
 * @author FERNANDO
 */
public interface ClienteService {
    
    List<ClienteTO> findAllClientes();
      
    ClienteTO findById(int idCliente);
    
    void cambiarTipoCliente(ClienteTO cliente,String tipoCliente);
    
    ClienteTO findByDni(String dni);
}
