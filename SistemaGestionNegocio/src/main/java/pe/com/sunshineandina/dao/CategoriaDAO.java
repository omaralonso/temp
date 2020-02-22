/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.CategoriaTO;

/**
 *
 * @author alonsorn
 */
public interface CategoriaDAO {
    
    void save(CategoriaTO categoria);
    
    CategoriaTO findById(int id);
    
    CategoriaTO findByNombre(String nombreCategoria);
    
    CategoriaTO findByIdAndNombre(int idCategoria,String nombreCategoria);
    
    List<CategoriaTO> findAll();
    
    CategoriaTO findByNombreCategoria(String nombreCategoria);
    
}
