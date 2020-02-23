package pe.com.brunominelli.service;

import pe.com.brunominelli.dto.ClienteTO;
import pe.com.brunominelli.dto.UsuarioTO;

public interface DatosPersonalesService {
    
    ClienteTO findClienteByUsuario(int idUsuario);
    
    void actualizarDatosCliente(ClienteTO cliente);
    
    String validarPassword(String passwordActual, String passwordNueva, String passwordConfirmacion, UsuarioTO usuario);
    
    UsuarioTO actualizarPassword(UsuarioTO usuario);
    
    String nombrePerfil(int idUsuario, int swCliente);
}
