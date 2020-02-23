package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.PoliticaTO;

public interface PoliticaDAO {
    
    PoliticaTO findById(int id);
    
    List<PoliticaTO> findAll(); 
    
    PoliticaTO findByDescPolitica(String descPolitica);
    
    void save(PoliticaTO politica);
    
    PoliticaTO findByParameters(int puntosInd, int puntosGru);
}
