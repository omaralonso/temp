package pe.com.brunominelli.dao;

import java.util.List;
import pe.com.brunominelli.dto.ClienteTO;

public interface ClienteDAO {
    
    ClienteTO findById(int id);
  
    ClienteTO findByUsuario(int idUsuario);
    
    void save(ClienteTO cliente);
    
    ClienteTO findByDni(String dni);
    
    List<ClienteTO> findAllClientes();
}
