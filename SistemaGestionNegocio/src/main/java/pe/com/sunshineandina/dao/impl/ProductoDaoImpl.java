/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.ProductoDAO;
import pe.com.sunshineandina.dto.CategoriaTO;
import pe.com.sunshineandina.dto.ProductoTO;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author alonsorn
 */
@Repository("productoDao")
public class ProductoDaoImpl extends AbstractDAO<Integer, ProductoTO> implements ProductoDAO {

    @Override
    public ProductoTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(ProductoTO producto) {
        persist(producto);
    }

    @Override
    public ProductoTO findByNombre(String nombreProducto) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nombreProducto", nombreProducto));
        return (ProductoTO) criteria.uniqueResult();
    }
    
    @Override
    public ProductoTO findByIdAndNombre(int idProducto,String nombreProducto) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("idProducto", idProducto));
        criteria.add(Restrictions.eq("nombreProducto", nombreProducto));
        return (ProductoTO) criteria.uniqueResult();
    }
    
    @Override
    public List<ProductoTO> findByCategoria(int idCategoria) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("estadoProducto", Constantes.ESTADO_ACTIVO));
        criteria.add(Restrictions.eq("categoria.idCategoria", idCategoria));
        return (List<ProductoTO>) criteria.list();
    }

    @Override
    public List<ProductoTO> findAllByCategoria(int idCategoria) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("categoria.idCategoria", idCategoria));
        return (List<ProductoTO>) criteria.list();
    }

    //Mostrar productos en inventario, estén o no disponibles
    @Override
    public List<ProductoTO> findInventario() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("nombreProducto"));
        /*criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);*/
        return (List<ProductoTO>) criteria.list();
    }

    //Mostrar productos en tienda, SOLO disponibles, con paginación
    @Override
    public List<ProductoTO> findPaginado(int inicio, int cantidadPagina) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("estadoProducto", Constantes.ESTADO_ACTIVO));
        criteria.addOrder(Order.asc("nombreProducto"));
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);
        return (List<ProductoTO>) criteria.list();
    }

    @Override
    public List<ProductoTO> findByCategoriaPaginado(int idCategoria, int inicio, int cantidadPagina) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("estadoProducto", Constantes.ESTADO_ACTIVO));
        criteria.add(Restrictions.eq("categoria.idCategoria", idCategoria));
        criteria.addOrder(Order.asc("nombreProducto"));
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);
        return (List<ProductoTO>) criteria.list();
    }

    @Override
    public int cantidadProductos() {
        int count = ((Long) getSession().createQuery("select count(*) from Producto").uniqueResult()).intValue();
        return count;
    }

    @Override
    public int cantidadProductosByCategoria(int idCategoria) {
        int count = ((Long) getSession().createQuery("select count(*) from Producto p "
                + "where p.categoria.idCategora = :idCategoria")
                .setParameter("idCategoria", idCategoria)
                .uniqueResult())
                .intValue();
        return count;
    }

}
