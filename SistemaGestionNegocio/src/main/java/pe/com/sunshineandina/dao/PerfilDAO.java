/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.PerfilTO;

/**
 *
 * @author alonsorn
 */
public interface PerfilDAO {

    PerfilTO findById(int id);

    List<PerfilTO> findAll();
    
    PerfilTO findByCodigoPerfil(String codigoPerfil);
}
