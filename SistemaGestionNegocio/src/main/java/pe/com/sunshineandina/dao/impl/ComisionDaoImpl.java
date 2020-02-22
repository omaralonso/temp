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
import pe.com.sunshineandina.dao.ComisionDAO;
import pe.com.sunshineandina.dto.ComisionTO;

/**
 *
 * @author alonsorn
 */
@Repository("comisionDao")
public class ComisionDaoImpl extends AbstractDAO<Integer, ComisionTO> implements ComisionDAO {

    @Override
    public ComisionTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public List<ComisionTO> findByParameters(int idDistribuidor, int mes, int anio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("distribuidor.idDistribuidor", idDistribuidor));
        if (mes != 0) {
            criteria.add(Restrictions.eq("mesComision", mes));
        }
        if (anio != 0) {
            criteria.add(Restrictions.eq("anioComision", anio));
        }
        return (List<ComisionTO>) criteria.list();
    }

    @Override
    public void save(ComisionTO comision) {
        persist(comision);
    }

    @Override
    public ComisionTO findUnique(int idDistribuidor, int mes, int anio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("distribuidor.idDistribuidor", idDistribuidor));
        criteria.add(Restrictions.eq("mesComision", mes));
        criteria.add(Restrictions.eq("anioComision", anio));
        return (ComisionTO) criteria.uniqueResult();
    }

}
