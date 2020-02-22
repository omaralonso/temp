/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.OfertaTO;

/**
 *
 * @author alonsorn
 */
public interface OfertaDAO {
    
    OfertaTO findById(int id);
    
    void save(OfertaTO oferta);
    
    List<OfertaTO> findAllOfertas();
    
    List<OfertaTO> findByCategoria(int idCategoria);
}
