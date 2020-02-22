/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.PedidoDAO;
import pe.com.sunshineandina.dto.PedidoTO;

/**
 *
 * @author alonsorn
 */
@Repository("pedidoDao")
public class PedidoDaoImpl extends AbstractDAO<Integer, PedidoTO> implements PedidoDAO{

    @Override
    public PedidoTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(PedidoTO pedido) {
        persist(pedido);
    }
    
    @Override
    public List<PedidoTO> findAllPedidos() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("idPedido"));
        /*criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);*/
        return (List<PedidoTO>) criteria.list();
    }

    @Override
    public List<PedidoTO> findByCliente(int idCliente) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cliente.idCliente", idCliente));
        return (List<PedidoTO>) criteria.list();
    }

    @Override
    public List<PedidoTO> findByClienteFecha(int idCliente, Date fechaInicio, Date fechaFin) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cliente.idCliente", idCliente));
        criteria.add(Restrictions.between("fechaModificacion", fechaInicio, fechaFin));
        criteria.addOrder(Order.desc("fechaModificacion"));
        return (List<PedidoTO>) criteria.list();
    }

    @Override
    public List<PedidoTO> findByClienteFechaPaginado(int idCliente, Date fechaInicio, Date fechaFin, int inicio, int cantidadPagina) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cliente.idCliente", idCliente));
        criteria.add(Restrictions.between("fechaModificacion", fechaInicio, fechaFin));
        criteria.addOrder(Order.desc("fechaModificacion"));
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);
        return (List<PedidoTO>) criteria.list();
    }
    
}
