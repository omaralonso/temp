package pe.com.brunominelli.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.brunominelli.dao.ClienteDAO;
import pe.com.brunominelli.dao.UsuarioDAO;
import pe.com.brunominelli.dto.ClienteTO;
import pe.com.brunominelli.dto.UsuarioTO;
import pe.com.brunominelli.service.DatosPersonalesService;
import pe.com.brunominelli.util.Constantes;
import pe.com.brunominelli.util.HashPassword;

@Service("datosPersonalesService")
@Transactional
public class DatosPersonalesServiceImpl implements DatosPersonalesService{

    @Autowired
    private ClienteDAO clienteDao;
    
    @Autowired
    private UsuarioDAO usuarioDao;
    
    @Override
    public ClienteTO findClienteByUsuario(int idUsuario) {
        return clienteDao.findByUsuario(idUsuario);
    }

    @Override
    public void actualizarDatosCliente(ClienteTO cliente) {
        if(cliente != null){
            ClienteTO entity = clienteDao.findById(cliente.getIdCliente());
            entity.setDireccion(cliente.getDireccion());
            entity.setEmail(cliente.getEmail());
            entity.setTelefonoCelular(cliente.getTelefonoCelular());
            entity.setTelefonoFijo(cliente.getTelefonoFijo());
            clienteDao.save(entity);
        }
    }

    @Override
    public String validarPassword(String passwordActual, String passwordNueva, String passwordConfirmacion, UsuarioTO usuario) {
        String rpta = null;
        
        /* vemos si las contrase�as coinciden */
        if(!passwordNueva.equals(passwordConfirmacion)){
            rpta = Constantes.ERROR_CONTRASEÑAS_NO_COINCIDEN;
            return rpta;
        }
        
        /* vemos si la contrase�a es correcta */
        String hashedPasswordActual = HashPassword.hashPassword(passwordActual);
        if(!hashedPasswordActual.equals(usuario.getPassUsuario())){
            rpta = Constantes.ERROR_AUTENTICACION_PASSWORD;
            return rpta;
        }
        
        return rpta;
    }

    @Override
    public UsuarioTO actualizarPassword(UsuarioTO usuario) {
        if(usuario != null){
            UsuarioTO entity = usuarioDao.findById(usuario.getIdUsuario());
            if(entity != null){
                entity.setPassUsuario(HashPassword.hashPassword(usuario.getPassUsuario()));
                usuarioDao.saveUsuario(entity);
            }
            return entity;
        }
        return null;
    }

    @Override
    public String nombrePerfil(int idUsuario, int swCliente) {
        if(swCliente == 1){
            ClienteTO cliente = clienteDao.findByUsuario(idUsuario);
            return cliente.getPrimerNombre().substring(0,1) + cliente.getPrimerNombre().substring(1).toLowerCase()
                    + " " + cliente.getPrimerApellido().substring(0,1) + cliente.getPrimerApellido().substring(1).toLowerCase();
        }
        return "";        
    } 
    
}
