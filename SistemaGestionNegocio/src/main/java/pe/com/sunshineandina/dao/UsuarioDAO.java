/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import pe.com.sunshineandina.dto.UsuarioTO;

/**
 *
 * @author alonsorn
 */
public interface UsuarioDAO {
   
    UsuarioTO findById(int id);
    
    void saveUsuario(UsuarioTO usuario);
    
    UsuarioTO findByRegistro(String registro);
    
    UsuarioTO findByNombre(String nombreUsuario);

}
