package pe.com.brunominelli.service;

public interface ProductoPaginadoService {
    
    int productoPaginaInicio();
    
    int cantidadProductos();
    
    int productoPaginaInicioByCategoria(int idCategoria);
    
    int cantidadProductosByCategoria(int idCategoria);
}
