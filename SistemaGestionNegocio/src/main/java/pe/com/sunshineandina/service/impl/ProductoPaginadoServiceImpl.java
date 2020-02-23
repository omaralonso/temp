/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.ProductoDAO;
import pe.com.sunshineandina.service.ProductoPaginadoService;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author alonsorn
 */
@Service("productoPaginadoService")
@Transactional
public class ProductoPaginadoServiceImpl implements ProductoPaginadoService{

    @Autowired
    private ProductoDAO productoDao;
    
    @Override
    public int productoPaginaInicio() {
        int cantidadProductosPorPagina = Integer.parseInt(Constantes.PARAMETRIA_PRODUCTOS_POR_PAGINA);
        int cantidadProductos = productoDao.cantidadProductos();
        int cantidadPaginas = cantidadProductos / cantidadProductosPorPagina;
        return cantidadPaginas;
    }

    @Override
    public int cantidadProductos() {
        return productoDao.cantidadProductos();
    }

    @Override
    public int productoPaginaInicioByCategoria(int idCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cantidadProductosByCategoria(int idCategoria) {
        return productoDao.cantidadProductosByCategoria(idCategoria);
    }
    
}
