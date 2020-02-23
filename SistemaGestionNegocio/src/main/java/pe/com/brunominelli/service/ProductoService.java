package pe.com.brunominelli.service;

import java.util.List;
import pe.com.brunominelli.dto.ProductoTO;

public interface ProductoService {
     List<ProductoTO> findAllProductosInventario();
     
     ProductoTO findProductoById(int id);
     
     boolean nombreRepetido(String nombre);
     
     boolean idRepetido(int id,String nombre);
          
     void addProducto(ProductoTO producto);
     
     void editProducto(ProductoTO producto);
     
     void changeProductState(ProductoTO producto);
     
     List<ProductoTO> findPaginado(int inicio);
     
     List<ProductoTO> findByCategoriaPaginado(int idCategoria, int inicio);
     
     List<ProductoTO> findByCategoria(int idCategoria);
     
}
