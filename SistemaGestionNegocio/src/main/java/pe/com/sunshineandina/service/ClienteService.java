package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.ClienteTO;

public interface ClienteService {
    
    List<ClienteTO> findAllClientes();
      
    ClienteTO findById(int idCliente);
        
    ClienteTO findByDni(String dni);
}
