package pe.com.brunominelli.dao;

import java.util.List;
import pe.com.brunominelli.dto.CategoriaTO;

public interface CategoriaDAO {
    
    void save(CategoriaTO categoria);
    
    CategoriaTO findById(int id);
    
    CategoriaTO findByNombre(String nombreCategoria);
    
    CategoriaTO findByIdAndNombre(int idCategoria,String nombreCategoria);
    
    List<CategoriaTO> findAll();
    
    CategoriaTO findByNombreCategoria(String nombreCategoria);
    
}
