/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.PoliticaTO;

/**
 *
 * @author alonsorn
 */
public interface PoliticaDAO {
    
    PoliticaTO findById(int id);
    
    List<PoliticaTO> findAll(); 
    
    PoliticaTO findByDescPolitica(String descPolitica);
    
    void save(PoliticaTO politica);
    
    PoliticaTO findByParameters(int puntosInd, int puntosGru);
}
