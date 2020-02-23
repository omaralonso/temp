package pe.com.brunominelli.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.brunominelli.dao.AbstractDAO;
import pe.com.brunominelli.dao.ClienteDAO;
import pe.com.brunominelli.dto.ClienteTO;

@Repository("clienteDao")
public class ClienteDaoImpl extends AbstractDAO<Integer, ClienteTO> implements ClienteDAO {

    @Override
    public ClienteTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(ClienteTO cliente) {
        persist(cliente);
    }

    @Override
    public ClienteTO findByDni(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni", dni));
        return (ClienteTO) criteria.uniqueResult();
    }

    @Override
    public ClienteTO findByUsuario(int idUsuario) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("usuario.idUsuario", idUsuario));
        return (ClienteTO) criteria.uniqueResult();
    }

    @Override
    public List<ClienteTO> findAllClientes() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("primerNombre"));
         /*criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);*/
        return (List<ClienteTO>) criteria.list();
    }

}
