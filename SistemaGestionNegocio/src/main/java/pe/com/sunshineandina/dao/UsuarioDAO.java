package pe.com.sunshineandina.dao;

import pe.com.sunshineandina.dto.UsuarioTO;

public interface UsuarioDAO {
   
    UsuarioTO findById(int id);
    
    void saveUsuario(UsuarioTO usuario);
    
    UsuarioTO findByRegistro(String registro);
    
    UsuarioTO findByNombre(String nombreUsuario);

}
