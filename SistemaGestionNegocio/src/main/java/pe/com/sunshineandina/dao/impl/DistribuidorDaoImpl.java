/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.DistribuidorDAO;
import pe.com.sunshineandina.dto.DistribuidorTO;

/**
 *
 * @author alonsorn
 */
@Repository("distribuidorDao")
public class DistribuidorDaoImpl extends AbstractDAO<Integer, DistribuidorTO> implements DistribuidorDAO {

    @Override
    public DistribuidorTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(DistribuidorTO distribuidor) {
        persist(distribuidor);
    }

    @Override
    public DistribuidorTO findByCodigoDistribuidor(String codigoDistribuidor) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("codigoDistribuidor", codigoDistribuidor));
        return (DistribuidorTO) criteria.uniqueResult();
    }
   
    @Override
    public DistribuidorTO findByCliente(int idCliente) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cliente.idCliente", idCliente));
        return (DistribuidorTO) criteria.uniqueResult();
    }
    
    @Override
    public void destroy(DistribuidorTO distribuidor) {
        delete(distribuidor);
    }

    @Override
    public DistribuidorTO findByUsuario(int idUsuario) {
        Query query = getSession().createQuery("from Distribuidor d join d.cliente c join c.usuario u "
                + "where u.idUsuario = :idUsuario")
                .setParameter("idUsuario", idUsuario);

        List<Object[]> list = query.list();
        /* obtenemos el distribuidor */
        return (DistribuidorTO) list.get(0)[0];

    }

}
