package pe.com.brunominelli.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.brunominelli.dao.AbstractDAO;
import pe.com.brunominelli.dao.DetalleCarritoDAO;
import pe.com.brunominelli.dto.DetalleCarritoTO;

@Repository("detalleCarritoDao")
public class DetalleCarritoDaoImpl extends AbstractDAO<Integer, DetalleCarritoTO> implements DetalleCarritoDAO {

    @Override
    public DetalleCarritoTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(DetalleCarritoTO detalleCarrito) {
        persist(detalleCarrito);
    }

    @Override
    public List<DetalleCarritoTO> findByCarrito(int idCarrito) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("carrito.idPedido", idCarrito));
        return (List<DetalleCarritoTO>) criteria.list();
    }

    @Override
    public DetalleCarritoTO findByProducto(int idProducto) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("producto.idProducto", idProducto));
        return (DetalleCarritoTO) criteria.uniqueResult();
    }

}
