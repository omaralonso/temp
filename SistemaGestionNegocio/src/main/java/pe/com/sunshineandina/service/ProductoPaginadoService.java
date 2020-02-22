/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

/**
 *
 * @author alonsorn
 */
public interface ProductoPaginadoService {
    
    int productoPaginaInicio();
    
    int cantidadProductos();
    
    int productoPaginaInicioByCategoria(int idCategoria);
    
    int cantidadProductosByCategoria(int idCategoria);
}
