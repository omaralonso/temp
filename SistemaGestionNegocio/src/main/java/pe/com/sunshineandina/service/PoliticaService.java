package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.PoliticaTO;

public interface PoliticaService {
    
    List<PoliticaTO> findAllPoliticas();
    
    void actualizarPolitica(PoliticaTO politica);
    
    PoliticaTO findById(int idPolitica);
}
