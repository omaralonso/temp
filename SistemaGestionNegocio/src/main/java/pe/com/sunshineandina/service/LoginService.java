package pe.com.sunshineandina.service;

import java.util.List;
import java.util.Map;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.UsuarioTO;

public interface LoginService {
    
    Map<String, Object> autenticacion(UsuarioTO usuarioPosible);
    
    List<PerfilTO> perfilesUsuario(UsuarioTO usuario); 
    
    int esCliente(int idUsuario);
}
