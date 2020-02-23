package pe.com.brunominelli.service;

import java.util.List;
import java.util.Map;
import pe.com.brunominelli.dto.PerfilTO;
import pe.com.brunominelli.dto.UsuarioTO;

public interface LoginService {
    
    Map<String, Object> autenticacion(UsuarioTO usuarioPosible);
    
    List<PerfilTO> perfilesUsuario(UsuarioTO usuario); 
    
    int esCliente(int idUsuario);
}
