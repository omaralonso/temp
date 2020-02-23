package pe.com.brunominelli.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.brunominelli.dao.AbstractDAO;
import pe.com.brunominelli.dao.PoliticaDAO;
import pe.com.brunominelli.dto.PoliticaTO;

@Repository("politicaDao")
public class PoliticaDaoImpl extends AbstractDAO<Integer, PoliticaTO> implements PoliticaDAO {

    @Override
    public PoliticaTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public List<PoliticaTO> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<PoliticaTO>) criteria.list();
    }

    @Override
    public PoliticaTO findByDescPolitica(String descPolitica) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("descPolitica", descPolitica));
        return (PoliticaTO) criteria.uniqueResult();
    }

    @Override
    public void save(PoliticaTO politica) {
        persist(politica);
    }

    @Override
    public PoliticaTO findByParameters(int puntosInd, int puntosGru) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.le("minPuntosIndividual", puntosInd));
        criteria.add(Restrictions.gt("maxPuntosIndividual", puntosInd));
        criteria.add(Restrictions.le("minPuntosGrupal", puntosGru));
        criteria.add(Restrictions.gt("maxPuntosGrupal", puntosGru));
        return (PoliticaTO) criteria.uniqueResult();
    }

}
