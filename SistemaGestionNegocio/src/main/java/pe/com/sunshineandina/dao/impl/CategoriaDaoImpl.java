/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.CategoriaDAO;
import pe.com.sunshineandina.dto.CategoriaTO;

/**
 *
 * @author alonsorn
 */
@Repository("categoriaDao")
public class CategoriaDaoImpl extends AbstractDAO<Integer, CategoriaTO> implements CategoriaDAO{

    @Override
    public void save(CategoriaTO categoria) {
        persist(categoria);
    }
    
    @Override
    public CategoriaTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public CategoriaTO findByNombre(String nombreCategoria) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nombreCategoria", nombreCategoria));
        return (CategoriaTO) criteria.uniqueResult();
    }
    
    @Override
    public CategoriaTO findByIdAndNombre(int idCategoria,String nombreCategoria) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("idCategoria", idCategoria));
        criteria.add(Restrictions.eq("nombreCategoria", nombreCategoria));
        return (CategoriaTO) criteria.uniqueResult();
    }
    
    @Override
    public List<CategoriaTO> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<CategoriaTO>)criteria.list();
    }

    @Override
    public CategoriaTO findByNombreCategoria(String nombreCategoria) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nombreCategoria", nombreCategoria));
        return (CategoriaTO) criteria.uniqueResult();
    }
    
    
}
