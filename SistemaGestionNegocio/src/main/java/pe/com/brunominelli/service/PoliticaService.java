package pe.com.brunominelli.service;

import java.util.List;
import pe.com.brunominelli.dto.PoliticaTO;

public interface PoliticaService {
    
    List<PoliticaTO> findAllPoliticas();
    
    void actualizarPolitica(PoliticaTO politica);
    
    PoliticaTO findById(int idPolitica);
}
