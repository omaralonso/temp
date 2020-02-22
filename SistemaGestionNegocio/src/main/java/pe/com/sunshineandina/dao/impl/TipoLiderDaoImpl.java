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
import pe.com.sunshineandina.dao.TipoLiderDAO;
import pe.com.sunshineandina.dto.TipoLiderTO;

/**
 *
 * @author alonsorn
 */
@Repository("tipoLiderDao")
public class TipoLiderDaoImpl extends AbstractDAO<Integer, TipoLiderTO> implements TipoLiderDAO {

    @Override
    public TipoLiderTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public TipoLiderTO findByDescTipoLider(String descTipoLider) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("descTipoLider", descTipoLider));
        return (TipoLiderTO) criteria.uniqueResult();
    }

    @Override
    public List<TipoLiderTO> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<TipoLiderTO>) criteria.list();
    }

}
