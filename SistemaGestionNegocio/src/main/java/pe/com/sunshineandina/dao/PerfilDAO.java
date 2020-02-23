package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.PerfilTO;

public interface PerfilDAO {

    PerfilTO findById(int id);

    List<PerfilTO> findAll();
    
    PerfilTO findByCodigoPerfil(String codigoPerfil);
}
