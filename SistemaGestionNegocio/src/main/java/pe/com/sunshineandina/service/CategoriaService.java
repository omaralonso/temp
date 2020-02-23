package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.CategoriaTO;

public interface CategoriaService {
    List<CategoriaTO> findAllCategorias();
    
    CategoriaTO findCategoriaById(int id);
    
    boolean nombreRepetido(String nombre);
     
    boolean idRepetido(int id,String nombre);
    
    CategoriaTO findCategoriaByNombre(String nombre);
    
    void addCategoria(CategoriaTO categoria);
    
    void updateCategoria(CategoriaTO categoria);
    
    void changeCategoriasState(CategoriaTO categoria);
}
