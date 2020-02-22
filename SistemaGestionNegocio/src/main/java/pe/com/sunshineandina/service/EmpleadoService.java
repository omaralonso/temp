/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.EmpleadoTO;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.UsuarioTO;

/**
 *
 * @author alonsorn
 */
public interface EmpleadoService {
    
    List<PerfilTO> findAllPerfiles();
    
    List<EmpleadoTO> findAllEmpleados();
    
    EmpleadoTO findEmpleadoById(int id);
    
    UsuarioTO findUsuario(int id);
    
    void editEmpleado(EmpleadoTO empleado, String[] perfiles);
    
    EmpleadoTO findEmpleadoByUsuario(int idUsuario);
    
    void addEmpleado(EmpleadoTO empleado, String[] perfiles);
    
    void inactivarEmpleado(int idUsuario);
    
    void activarEmpleado(int idUsuario);
    
    boolean usuarioRepetido(String nombre);
    
    boolean idRepetido(int id,String nombre);
    
    boolean rucRepetido(String ruc);
    
    boolean idRucRepetido(int id,String ruc);
    
    void changeUsuarioState(UsuarioTO usuario);
    
}
