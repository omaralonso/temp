/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.OfertaTO;

/**
 *
 * @author FERNANDO
 */
public interface OfertaService {
    
    List<OfertaTO> findAllOfertas();
    
    OfertaTO findById(int oferta);
    
    void addOferta(OfertaTO oferta);
     
    void editOferta(OfertaTO oferta);
}
