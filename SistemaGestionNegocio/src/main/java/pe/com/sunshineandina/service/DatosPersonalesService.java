/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.EmpleadoTO;
import pe.com.sunshineandina.dto.UsuarioTO;

/**
 *
 * @author alonsorn
 */
public interface DatosPersonalesService {
    
    EmpleadoTO findEmpleadoByUsuario(int idUsuario);
    
    ClienteTO findClienteByUsuario(int idUsuario);
    
    void actualizarDatosCliente(ClienteTO cliente);
    
    void actualizarDatosEmpleado(EmpleadoTO empleado);
    
    String validarPassword(String passwordActual, String passwordNueva, String passwordConfirmacion, UsuarioTO usuario);
    
    UsuarioTO actualizarPassword(UsuarioTO usuario);
    
    String nombrePerfil(int idUsuario, int swCliente);
}
