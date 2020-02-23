package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.CategoriaTO;

public interface CategoriaDAO {
    
    void save(CategoriaTO categoria);
    
    CategoriaTO findById(int id);
    
    CategoriaTO findByNombre(String nombreCategoria);
    
    CategoriaTO findByIdAndNombre(int idCategoria,String nombreCategoria);
    
    List<CategoriaTO> findAll();
    
    CategoriaTO findByNombreCategoria(String nombreCategoria);
    
}
