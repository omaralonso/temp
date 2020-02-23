package pe.com.brunominelli.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.brunominelli.dao.AbstractDAO;
import pe.com.brunominelli.dao.PerfilDAO;
import pe.com.brunominelli.dto.PerfilTO;

@Repository("perfilDao")
public class PerfilDaoImpl extends AbstractDAO<Integer, PerfilTO> implements PerfilDAO{

    @Override
    public PerfilTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public List<PerfilTO> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<PerfilTO>) criteria.list();
    }

    @Override
    public PerfilTO findByCodigoPerfil(String codigoPerfil) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("codigoPerfil", codigoPerfil));
        return (PerfilTO) criteria.uniqueResult();
    }
    
}
