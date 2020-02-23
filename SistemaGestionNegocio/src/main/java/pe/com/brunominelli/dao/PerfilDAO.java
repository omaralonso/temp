package pe.com.brunominelli.dao;

import java.util.List;
import pe.com.brunominelli.dto.PerfilTO;

public interface PerfilDAO {

    PerfilTO findById(int id);

    List<PerfilTO> findAll();
    
    PerfilTO findByCodigoPerfil(String codigoPerfil);
}
