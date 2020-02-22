/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.CarritoDAO;
import pe.com.sunshineandina.dto.CarritoTO;

/**
 *
 * @author alonsorn
 */
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
