package pe.com.sunshineandina.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.DetallePedidoDAO;
import pe.com.sunshineandina.dto.DetallePedidoTO;

public class DetallePedidoDaoImpl extends AbstractDAO<Integer, DetallePedidoTO> implements DetallePedidoDAO{

    @Override
    public void save(DetallePedidoTO detallePedido) {
        persist(detallePedido);
    }

    @Override
    public DetallePedidoTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public List<DetallePedidoDAO> findByPedido(int idPedido) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("pedido.idPedido", idPedido));
        return (List<DetallePedidoDAO>) criteria.list();
    }
    
    
}
