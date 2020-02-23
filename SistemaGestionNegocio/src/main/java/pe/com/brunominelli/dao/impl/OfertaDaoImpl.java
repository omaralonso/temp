package pe.com.brunominelli.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.brunominelli.dao.AbstractDAO;
import pe.com.brunominelli.dao.OfertaDAO;
import pe.com.brunominelli.dto.OfertaTO;

@Repository("ofertaDao")
public class OfertaDaoImpl extends AbstractDAO<Integer, OfertaTO> implements OfertaDAO {

    @Override
    public OfertaTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public List<OfertaTO> findAllOfertas() {
        Criteria criteria = createEntityCriteria();
        return (List<OfertaTO>) criteria.list();
    }

    @Override
    public List<OfertaTO> findByCategoria(int idCategoria) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("categoria.idCategoria", idCategoria));
        return (List<OfertaTO>) criteria.list();
    }

    @Override
    public void save(OfertaTO oferta) {
        persist(oferta);
    }

}
