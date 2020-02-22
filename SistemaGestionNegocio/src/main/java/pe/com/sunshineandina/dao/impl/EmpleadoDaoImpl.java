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
import pe.com.sunshineandina.dao.EmpleadoDAO;
import pe.com.sunshineandina.dto.EmpleadoTO;

/**
 *
 * @author alonsorn
 */
@Repository("empleadoDao")
public class EmpleadoDaoImpl extends AbstractDAO<Integer, EmpleadoTO> implements EmpleadoDAO{

    @Override
    public EmpleadoTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(EmpleadoTO empleado) {
        persist(empleado);
    }

    @Override
    public EmpleadoTO findByRuc(String ruc) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ruc", ruc));
        return (EmpleadoTO) criteria.uniqueResult();
    }
    
    @Override
    public EmpleadoTO findByIdAndRuc(int id,String ruc) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("idEmpleado", id));
        criteria.add(Restrictions.eq("ruc", ruc));
        return (EmpleadoTO) criteria.uniqueResult();
    }

    @Override
    public List<EmpleadoTO> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<EmpleadoTO>) criteria.list();
    }

    @Override
    public List<EmpleadoTO> findPaginado(int inicio, int cantidadPagina) {
        Criteria criteria = createEntityCriteria();
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);
        return (List<EmpleadoTO>) criteria.list();
    }

    @Override
    public EmpleadoTO findByUsuario(int idUsuario) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("usuario.idUsuario", idUsuario));
        return (EmpleadoTO) criteria.uniqueResult();
    }
    
}
