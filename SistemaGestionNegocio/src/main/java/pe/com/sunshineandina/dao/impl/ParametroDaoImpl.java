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
import pe.com.sunshineandina.dao.ParametroDAO;
import pe.com.sunshineandina.dto.ParametroTO;

/**
 *
 * @author alonsorn
 */
@Repository("parametroDao")
public class ParametroDaoImpl extends AbstractDAO<Integer, ParametroTO> implements ParametroDAO {

    @Override
    public ParametroTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public ParametroTO findByDescParametro(String descParametro) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("descParametro", descParametro));
        return (ParametroTO) criteria.uniqueResult();
    }

    @Override
    public void save(ParametroTO parametro) {
        persist(parametro);
    }

    @Override
    public List<ParametroTO> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<ParametroTO>)criteria.list();
    }

}
