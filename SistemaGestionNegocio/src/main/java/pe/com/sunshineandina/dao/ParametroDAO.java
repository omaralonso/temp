/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.ParametroTO;

/**
 *
 * @author alonsorn
 */
public interface ParametroDAO  {
    
    ParametroTO findById(int id);
    
    ParametroTO findByDescParametro(String descParametro);
    
    void save(ParametroTO parametro);
    
    List<ParametroTO> findAll();
}
