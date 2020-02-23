package pe.com.brunominelli.service;

import java.util.List;
import pe.com.brunominelli.dto.ClienteTO;

public interface ClienteService {
    
    List<ClienteTO> findAllClientes();
      
    ClienteTO findById(int idCliente);
        
    ClienteTO findByDni(String dni);
}
