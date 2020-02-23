package pe.com.brunominelli.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.brunominelli.dao.ClienteDAO;
import pe.com.brunominelli.dao.UsuarioDAO;
import pe.com.brunominelli.dto.PerfilTO;
import pe.com.brunominelli.dto.UsuarioTO;
import pe.com.brunominelli.service.LoginService;
import pe.com.brunominelli.util.Constantes;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsuarioDAO usuarioDao;
    
    @Autowired
    private ClienteDAO clienteDao;

    @Override
    public Map<String, Object> autenticacion(UsuarioTO usuarioPosible) {
        Map<String, Object> mapResultado = new HashMap<>();
        boolean swResultado = true;
        String mensajeError = "";

        UsuarioTO usuario = usuarioDao.findByRegistro(usuarioPosible.getRegistroUsuario());

        // No existe el usuario
        if (usuario == null) {
            swResultado = false;
            mensajeError = Constantes.ERROR_AUTENTICACION_USERNAME;
            mapResultado.put("mensajeError", mensajeError);
            mapResultado.put("swResultado", swResultado);
            mapResultado.put("usuario", usuario);

            return mapResultado;
        }

        
        String hashedPassword = usuarioPosible.getPassUsuario();

        // Password equivocada
        if (!usuario.getPassUsuario().equals(hashedPassword)) {
            swResultado = false;
            mensajeError = Constantes.ERROR_AUTENTICACION_PASSWORD;
            usuario = null;
            mapResultado.put("mensajeError", mensajeError);
            mapResultado.put("swResultado", swResultado);
            mapResultado.put("usuario", usuario);

            return mapResultado;
        }
        
        
        
        // Credenciales correctas
        mapResultado.put("mensajeError", mensajeError);
        mapResultado.put("swResultado", swResultado);
        mapResultado.put("usuario", usuario);

        return mapResultado;
    }

    @Override
    public List<PerfilTO> perfilesUsuario(UsuarioTO usuario) {
        usuario = usuarioDao.findById(usuario.getIdUsuario());
        Hibernate.initialize(usuario.getPerfiles());
        return usuario.getPerfiles();
    }

    @Override
    public int esCliente(int idUsuario) {
        if(clienteDao.findByUsuario(idUsuario) != null){
            return 1;
        }
        return 0;
    }

}
