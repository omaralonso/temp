package pe.com.brunominelli.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.brunominelli.dao.AbstractDAO;
import pe.com.brunominelli.dao.CarritoDAO;
import pe.com.brunominelli.dto.CarritoTO;

@Repository("carritoDao")
public class CarritoDaoImpl extends AbstractDAO<Integer, CarritoTO> implements CarritoDAO {

    @Override
    public CarritoTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(CarritoTO carrito) {
        persist(carrito);
    }

    @Override
    public void destroy(CarritoTO carrito) {
        delete(carrito);
    }

    @Override
    public CarritoTO findByCliente(int idCliente) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cliente.idCliente", idCliente));
        return (CarritoTO) criteria.uniqueResult();
    }

}
