package pe.com.brunominelli.dao;

import pe.com.brunominelli.dto.UsuarioTO;

public interface UsuarioDAO {
   
    UsuarioTO findById(int id);
    
    void saveUsuario(UsuarioTO usuario);
    
    UsuarioTO findByRegistro(String registro);
    
    UsuarioTO findByNombre(String nombreUsuario);

}
