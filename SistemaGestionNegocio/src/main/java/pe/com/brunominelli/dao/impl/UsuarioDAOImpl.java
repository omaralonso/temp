package pe.com.brunominelli.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.brunominelli.dao.AbstractDAO;
import pe.com.brunominelli.dao.UsuarioDAO;
import pe.com.brunominelli.dto.UsuarioTO;
import pe.com.brunominelli.util.Constantes;

@Repository("usuarioDao")
public class UsuarioDAOImpl extends AbstractDAO<Integer, UsuarioTO> implements UsuarioDAO{

    @Override
    public UsuarioTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void saveUsuario(UsuarioTO usuario) {
        persist(usuario);
    }

    @Override
    public UsuarioTO findByRegistro(String registro) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("registroUsuario", registro));
        criteria.add(Restrictions.eq("estadoUsuario", Constantes.ESTADO_ACTIVO));
        return (UsuarioTO)criteria.uniqueResult();
    }
    
    @Override
    public UsuarioTO findByNombre(String nombreUsuario) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("registroUsuario", nombreUsuario));
        return (UsuarioTO) criteria.uniqueResult();
    }
    
}
