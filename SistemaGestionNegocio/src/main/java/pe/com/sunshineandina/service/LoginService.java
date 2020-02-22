/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import java.util.Map;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.UsuarioTO;

/**
 *
 * @author alonsorn
 */
public interface LoginService {
    
    Map<String, Object> autenticacion(UsuarioTO usuarioPosible);
    
    List<PerfilTO> perfilesUsuario(UsuarioTO usuario); 
    
    int esCliente(int idUsuario);
}
