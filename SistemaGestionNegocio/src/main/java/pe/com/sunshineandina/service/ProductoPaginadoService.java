package pe.com.sunshineandina.service;

public interface ProductoPaginadoService {
    
    int productoPaginaInicio();
    
    int cantidadProductos();
    
    int productoPaginaInicioByCategoria(int idCategoria);
    
    int cantidadProductosByCategoria(int idCategoria);
}
