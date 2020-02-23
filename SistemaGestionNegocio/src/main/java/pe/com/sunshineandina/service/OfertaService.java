package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.OfertaTO;

public interface OfertaService {
    
    List<OfertaTO> findAllOfertas();
    
    OfertaTO findById(int oferta);
    
    void addOferta(OfertaTO oferta);
     
    void editOferta(OfertaTO oferta);
}
