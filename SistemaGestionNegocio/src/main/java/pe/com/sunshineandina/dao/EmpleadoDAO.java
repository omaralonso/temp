/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.EmpleadoTO;

/**
 *
 * @author alonsorn
 */
public interface EmpleadoDAO {
    
    EmpleadoTO findById(int id);
    
    EmpleadoTO findByUsuario(int idUsuario);
    
    void save(EmpleadoTO empleado);
    
    EmpleadoTO findByRuc(String ruc);
    
    List<EmpleadoTO> findAll();
    
    List<EmpleadoTO> findPaginado(int inicio, int cantidadPagina);
    
    EmpleadoTO findByIdAndRuc(int id,String ruc);
}
