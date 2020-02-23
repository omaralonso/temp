package pe.com.brunominelli.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pe.com.brunominelli.dao.AbstractDAO;
import pe.com.brunominelli.dao.DetallePedidoDAO;
import pe.com.brunominelli.dto.DetallePedidoTO;

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
