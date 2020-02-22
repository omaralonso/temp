/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.CategoriaTO;

/**
 *
 * @author FERNANDO
 */
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
