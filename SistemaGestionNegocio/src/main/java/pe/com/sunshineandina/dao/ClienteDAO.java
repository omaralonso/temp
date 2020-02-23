package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.ClienteTO;

public interface ClienteDAO {
    
    ClienteTO findById(int id);
  
    ClienteTO findByUsuario(int idUsuario);
    
    void save(ClienteTO cliente);
    
    ClienteTO findByDni(String dni);
    
    List<ClienteTO> findAllClientes();
}
