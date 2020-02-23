package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.OfertaTO;

public interface OfertaDAO {
    
    OfertaTO findById(int id);
    
    void save(OfertaTO oferta);
    
    List<OfertaTO> findAllOfertas();
    
    List<OfertaTO> findByCategoria(int idCategoria);
}
