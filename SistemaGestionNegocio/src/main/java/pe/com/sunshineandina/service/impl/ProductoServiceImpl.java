/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.ParametroDAO;
import pe.com.sunshineandina.dao.ProductoDAO;
import pe.com.sunshineandina.dto.ParametroTO;
import pe.com.sunshineandina.dto.ProductoTO;
import pe.com.sunshineandina.service.ProductoService;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author FERNANDO
 */
@Service("productoService")  
@Transactional
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDAO productoDao;
    
    @Autowired
    private ParametroDAO parametroDAO;
    
    //Lista productos en inventario
    @Override
    public List<ProductoTO> findAllProductosInventario() {
        List<ProductoTO> listaProductos= productoDao.findInventario();
        for(ProductoTO producto : listaProductos){
            Hibernate.initialize(producto.getCategoria());
        }
        return listaProductos;
    }

    @Override
    public ProductoTO findProductoById(int id) {
        ProductoTO producto=productoDao.findById(id);
        Hibernate.initialize(producto.getCategoria());
        return producto;
    }
    
    @Override
    public boolean nombreRepetido(String nombre) {
        ProductoTO producto=productoDao.findByNombre(nombre);
        if(producto==null)
        {
            return false;
        }          
        return true;
    }
    
    @Override
    public boolean idRepetido(int id,String nombre) {
        ProductoTO producto=productoDao.findByIdAndNombre(id,nombre);
        if(producto==null)
        {
            return false;
        }          
        return true;
    }

    @Override
    public void addProducto(ProductoTO producto) {
        productoDao.save(producto);
    }

    @Override
    public void editProducto(ProductoTO producto) {
        if(producto != null){
            ProductoTO productoUpd = productoDao.findById(producto.getIdProducto());
            productoUpd.setNombreProducto(producto.getNombreProducto());
            productoUpd.setCategoria(producto.getCategoria());
            productoUpd.setDescripcionProducto(producto.getDescripcionProducto());
            productoUpd.setPrecioProducto(producto.getPrecioProducto());
            productoUpd.setPuntosProducto(producto.getPuntosProducto());
            productoUpd.setStockProducto(producto.getStockProducto());
            productoDao.save(productoUpd);
        }
    }
    
    @Override
    public void changeProductState(ProductoTO producto){
        if(producto!=null){
            ProductoTO productoUpd=productoDao.findById(producto.getIdProducto());
            if(productoUpd.getEstadoProducto()==Constantes.ESTADO_ACTIVO){
                productoUpd.setEstadoProducto(Constantes.ESTADO_INACTIVO);
            }
            else if(productoUpd.getEstadoProducto()==Constantes.ESTADO_INACTIVO){
                productoUpd.setEstadoProducto(Constantes.ESTADO_ACTIVO);
            }
            productoDao.save(productoUpd);
        }
    }

    @Override
    public List<ProductoTO> findPaginado(int inicio) {
        /* Obtenemos el nro de productos por pagina */
        ParametroTO parametro = parametroDAO.findByDescParametro(Constantes.PARAMETRIA_PRODUCTOS_POR_PAGINA);
        if(parametro != null){
            int cantidadPagina = Integer.parseInt(parametro.getValorParametro());
            List<ProductoTO> lstProductos = productoDao.findPaginado(inicio, cantidadPagina);
            return lstProductos;
        }
        return null;
    }

    @Override
    public List<ProductoTO> findByCategoriaPaginado(int idCategoria, int inicio) {
        ParametroTO parametro = parametroDAO.findByDescParametro(Constantes.PARAMETRIA_PRODUCTOS_POR_PAGINA);
        if(parametro != null){
            int cantidadPagina = Integer.parseInt(parametro.getValorParametro());
            List<ProductoTO> lstProductos = productoDao.findByCategoriaPaginado(idCategoria, inicio, cantidadPagina);
            return lstProductos;
        }
        return null;
    }

    @Override
    public List<ProductoTO> findByCategoria(int idCategoria) {
        return productoDao.findAllByCategoria(idCategoria);
    }

}
