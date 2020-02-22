/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.HistoricoDistribuidorDAO;
import pe.com.sunshineandina.dto.HistoricoDistribuidorTO;

/**
 *
 * @author alonsorn
 */
@Repository("historicoDistribuidorDao")
public class HistoricoDistribuidorDaoImpl extends AbstractDAO<Integer, HistoricoDistribuidorTO> implements HistoricoDistribuidorDAO {

    @Override
    public HistoricoDistribuidorTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public List<HistoricoDistribuidorTO> findByParameters(int idDistribuidor, int mes, int anio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("distribuidor.idDistribuidor", idDistribuidor));
        if (mes != 0) {
            criteria.add(Restrictions.eq("mesHistorico", mes));
        }
        if (anio != 0) {
            criteria.add(Restrictions.eq("anioHistorico", anio));
        }
        return (List<HistoricoDistribuidorTO>) criteria.list();
    }

    @Override
    public void save(HistoricoDistribuidorTO historicoDistribuidor) {
        persist(historicoDistribuidor);
    }

    @Override
    public HistoricoDistribuidorTO findUnique(int idDistribuidor, int mes, int anio) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("distribuidor.idDistribuidor", idDistribuidor));
        criteria.add(Restrictions.eq("mesHistorico", mes));
        criteria.add(Restrictions.eq("anioHistorico", anio));
        
        return (HistoricoDistribuidorTO) criteria.uniqueResult();
    }

    @Override
    public int sumPuntosIndividualesDescendientes(int idDistribuidor, int mes, int anio) {
        SQLQuery query = getSession().createSQLQuery("SELECT SUM(PUNTOS_INDIVIDUAL) AS PUNTOS_IND FROM TSA_HISTORICO_DISTRIBUIDOR H "
                + "INNER JOIN TSA_DISTRIBUIDOR D "
                + "ON H.ID_DISTRIBUIDOR = D.ID_DISTRIBUIDOR "
                + "WHERE D.ID_DISTRIBUIDOR_PADRE = :ID_PADRE "
                + "AND MES_HISTORICO = :MES "
                + "AND ANIO_HISTORICO = :ANIO");
        query.setParameter("ID_PADRE", idDistribuidor);
        query.setParameter("MES", new BigDecimal(mes));
        query.setParameter("ANIO", new BigDecimal(anio));
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List lst = query.list();
        Map map = (Map) lst.get(0);
        if(map.get("PUNTOS_INDIVIDUAL") == null){
            return 0;
        }
        return ((BigDecimal) map.get("PUNTOS_INDIVIDUAL")).intValue();
    }

    @Override
    public int sumPuntosGrupalesDescendientes(int idDistribuidor, int mes, int anio) {
        SQLQuery query = getSession().createSQLQuery("SELECT SUM(PUNTOS_GRUPAL) AS PUNTOS_GRU FROM TSA_HISTORICO_DISTRIBUIDOR H "
                + "INNER JOIN TSA_DISTRIBUIDOR D "
                + "ON H.ID_DISTRIBUIDOR = D.ID_DISTRIBUIDOR "
                + "WHERE D.ID_DISTRIBUIDOR_PADRE = :ID_PADRE "
                + "AND MES_HISTORICO = :MES "
                + "AND ANIO_HISTORICO = :ANIO");
        query.setParameter("ID_PADRE", idDistribuidor);
        query.setParameter("MES", new BigDecimal(mes));
        query.setParameter("ANIO", new BigDecimal(anio));
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List lst = query.list();
        Map map = (Map) lst.get(0);
        if(map.get("PUNTOS_GRU") == null){
            return 0;
        }
        return ((BigDecimal) map.get("PUNTOS_GRU")).intValue();
    }

    @Override
    public BigDecimal sumVentasIndividualesDescendientes(int idDistribuidor, int mes, int anio) {
        SQLQuery query = getSession().createSQLQuery("SELECT SUM(VENTAS_SOLES_IND) AS VENTAS_IND FROM TSA_HISTORICO_DISTRIBUIDOR H "
                + "INNER JOIN TSA_DISTRIBUIDOR D "
                + "ON H.ID_DISTRIBUIDOR = D.ID_DISTRIBUIDOR "
                + "WHERE D.ID_DISTRIBUIDOR_PADRE = :ID_PADRE "
                + "AND MES_HISTORICO = :MES "
                + "AND ANIO_HISTORICO = :ANIO");
        query.setParameter("ID_PADRE", idDistribuidor);
        query.setParameter("MES", new BigDecimal(mes));
        query.setParameter("ANIO", new BigDecimal(anio));
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List lst = query.list();
        Map map = (Map) lst.get(0);
        if(map.get("VENTAS_SOLES_IND") == null){
            return new BigDecimal(0);
        }
        return (BigDecimal)map.get("VENTAS_SOLES_IND");
    }

    @Override
    public BigDecimal sumVentasGrupalesDescendientes(int idDistribuidor, int mes, int anio) {
        SQLQuery query = getSession().createSQLQuery("SELECT SUM(VENTAS_SOLES_GRUPAL) AS VENTAS_GRU FROM TSA_HISTORICO_DISTRIBUIDOR H "
                + "INNER JOIN TSA_DISTRIBUIDOR D "
                + "ON H.ID_DISTRIBUIDOR = D.ID_DISTRIBUIDOR "
                + "WHERE D.ID_DISTRIBUIDOR_PADRE = :ID_PADRE "
                + "AND MES_HISTORICO = :MES "
                + "AND ANIO_HISTORICO = :ANIO");
        query.setParameter("ID_PADRE", idDistribuidor);
        query.setParameter("MES", new BigDecimal(mes));
        query.setParameter("ANIO", new BigDecimal(anio));
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List lst = query.list();
        Map map = (Map) lst.get(0);
        
        if(map.get("VENTAS_SOLES_GRUPAL") == null){
            return new BigDecimal(0);
        }
        return (BigDecimal)map.get("VENTAS_SOLES_GRUPAL");
    }

    

}
