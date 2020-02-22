/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.ProductoTO;

/**
 *
 * @author alonsorn
 */
public interface ProductoDAO {
    
    ProductoTO findById(int id);
    
    void save(ProductoTO producto);
    
    ProductoTO findByNombre(String nombreProducto);
    
    ProductoTO findByIdAndNombre(int idProducto,String nombreProducto);
    
    List<ProductoTO> findByCategoria(int idCategoria);
    
    List<ProductoTO> findAllByCategoria(int idCategoria);
    
    List<ProductoTO> findPaginado(int inicio, int cantidadPagina);
    
    List<ProductoTO> findInventario();
    
    List<ProductoTO> findByCategoriaPaginado(int idCategoria, int inicio, int cantidadPagina);
    
    int cantidadProductos();
    
    int cantidadProductosByCategoria(int idCategoria);
}
