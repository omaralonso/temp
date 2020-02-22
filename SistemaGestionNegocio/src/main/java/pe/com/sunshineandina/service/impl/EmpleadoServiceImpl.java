/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.EmpleadoDAO;
import pe.com.sunshineandina.dao.PerfilDAO;
import pe.com.sunshineandina.dao.UsuarioDAO;
import pe.com.sunshineandina.dto.EmpleadoTO;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.service.EmpleadoService;
import pe.com.sunshineandina.util.Constantes;
import pe.com.sunshineandina.util.HashPassword;

/**
 *
 * @author alonsorn
 */
@Service("empleadoService")
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoDAO empleadoDao;
    
    @Autowired
    private UsuarioDAO usuarioDao;
    
    @Autowired
    private PerfilDAO perfilDao;
    
    @Override
    public List<PerfilTO> findAllPerfiles() {
        List<PerfilTO> lstPerfiles = perfilDao.findAll();
        lstPerfiles.remove(0); // CLIENTE
        lstPerfiles.remove(0); // DISTRIBUIDOR
        return lstPerfiles;
    }

    @Override
    public EmpleadoTO findEmpleadoById(int id) {
        EmpleadoTO empleado=empleadoDao.findById(id);
        Hibernate.initialize(empleado.getUsuario().getPerfiles());
        return empleado;
    }

    @Override
    public EmpleadoTO findEmpleadoByUsuario(int idUsuario) {
        return empleadoDao.findByUsuario(idUsuario);
    }
    
    @Override
    public boolean usuarioRepetido(String nombre) {
        UsuarioTO usuario=usuarioDao.findByNombre(nombre);
        if(usuario==null)
        {
            return false;
        }          
        return true;
    }
    
    @Override
    public boolean rucRepetido(String ruc) {
        EmpleadoTO empleado=empleadoDao.findByRuc(ruc);
        if(empleado==null)
        {
            return false;
        }          
        return true;
    }
    
    @Override
    public boolean idRucRepetido(int id,String ruc) {
        EmpleadoTO empleado=empleadoDao.findByIdAndRuc(id,ruc);
        if(empleado==null)
        {
            return false;
        }          
        return true;
    }
    
    @Override
    public boolean idRepetido(int id,String nombre) {
        UsuarioTO usuario=usuarioDao.findByNombre(nombre);
        EmpleadoTO empleado=empleadoDao.findByUsuario(usuario.getIdUsuario());
        if(empleado.getIdEmpleado()==id)
        {
            return true;
        }          
        return false;
    }

    @Override
    public void addEmpleado(EmpleadoTO empleado, String[] perfiles) {
        /* Hash password */
        empleado.getUsuario().setPassUsuario(HashPassword.hashPassword(empleado.getUsuario().getPassUsuario()));
        
        /* Obtenemos los Perfiles */
        List<PerfilTO> lstPerfiles = new ArrayList<>();
        for(int i = 0; i < perfiles.length; i++){
            PerfilTO perfil = perfilDao.findByCodigoPerfil(perfiles[i]);
            if(perfil != null){
                lstPerfiles.add(perfil);
            }
        }
        empleado.getUsuario().setPerfiles(lstPerfiles);
        
        empleadoDao.save(empleado);
    }
    
    @Override
    public void editEmpleado(EmpleadoTO empleado, String[] perfiles) {
        EmpleadoTO empleadoUpd=empleadoDao.findById(empleado.getIdEmpleado());
        UsuarioTO usuarioExistente=usuarioDao.findById(empleadoUpd.getUsuario().getIdUsuario());
        usuarioExistente.setRegistroUsuario(empleado.getUsuario().getRegistroUsuario());
        String pass=empleado.getUsuario().getPassUsuario();
        empleadoUpd.setUsuario(usuarioExistente);
        empleadoUpd.setPrimerNombre(empleado.getPrimerNombre());
        empleadoUpd.setSegundoNombre(empleado.getSegundoNombre());
        empleadoUpd.setPrimerApellido(empleado.getPrimerApellido());
        empleadoUpd.setSegundoApellido(empleado.getSegundoApellido());
        empleadoUpd.setRuc(empleado.getRuc());
        empleadoUpd.setEmail(empleado.getEmail());
        empleadoUpd.setTelefonoFijo(empleado.getTelefonoFijo());
        empleadoUpd.setTelefonoCelular(empleado.getTelefonoCelular());
        /* Hash password */
        if(pass.length()!=0)
        {
            System.out.println("ano"+pass+"pene");
            empleadoUpd.getUsuario().setPassUsuario(HashPassword.hashPassword(empleado.getUsuario().getPassUsuario()));
        }
            
        
        /* Obtenemos los Perfiles */
        List<PerfilTO> lstPerfiles = new ArrayList<>();
        for(int i = 0; i < perfiles.length; i++){
            PerfilTO perfil = perfilDao.findByCodigoPerfil(perfiles[i]);
            if(perfil != null){
                lstPerfiles.add(perfil);
            }
        }
        empleadoUpd.getUsuario().setPerfiles(lstPerfiles);
        
        empleadoDao.save(empleadoUpd);
    }
    

    @Override
    public List<EmpleadoTO> findAllEmpleados() {
        List<EmpleadoTO> lstEmpleados = empleadoDao.findAll();
        for(EmpleadoTO empleado: lstEmpleados){
            Hibernate.initialize(empleado.getUsuario());
            Hibernate.initialize(empleado.getUsuario().getPerfiles());
        }
        return lstEmpleados;
    }

    @Override
    public void inactivarEmpleado(int idUsuario) {
        UsuarioTO usuario = usuarioDao.findById(idUsuario);
        System.out.println("id: " + usuario.getIdUsuario());
        usuario.setEstadoUsuario(Constantes.ESTADO_INACTIVO);
        usuarioDao.saveUsuario(usuario);
    }

    @Override
    public void activarEmpleado(int idUsuario) {
        UsuarioTO usuario = usuarioDao.findById(idUsuario);
        usuario.setEstadoUsuario(Constantes.ESTADO_ACTIVO);
        usuarioDao.saveUsuario(usuario);
    }

    @Override
    public UsuarioTO findUsuario(int id) {
        return usuarioDao.findById(id);
    }
    
    @Override
    public void changeUsuarioState(UsuarioTO usuario) {
        if (usuario != null) {
            UsuarioTO usuarioUpd = usuarioDao.findById(usuario.getIdUsuario());
            if (usuario.getEstadoUsuario()== Constantes.ESTADO_ACTIVO) {              
                usuarioUpd.setEstadoUsuario(Constantes.ESTADO_INACTIVO);
            } else if (usuario.getEstadoUsuario()== Constantes.ESTADO_INACTIVO) {
                usuarioUpd.setEstadoUsuario(Constantes.ESTADO_ACTIVO);
            }
            usuarioDao.saveUsuario(usuarioUpd);
        }
    }
    
}
