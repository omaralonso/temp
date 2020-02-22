/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.EmpleadoTO;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.service.DatosPersonalesService;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author alonsorn
 */
@Controller
public class GenericoController {

    @Autowired
    private DatosPersonalesService datosPersonalesService;

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String perfil(Model model, HttpSession session) {
        /* obtenemos el usuario logeado */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");

        /* obtenemos el codigo de perfil */
        PerfilTO perfil = (PerfilTO) session.getAttribute("perfil");
        String codPerfil = perfil.getCodigoPerfil();

        /* 1 si es Cliente, 0 si no lo es */
        switch (codPerfil) {
            case Constantes.PERFIL_CLIENTE:
            case Constantes.PERFIL_DISTRIBUIDOR:
                ClienteTO cliente = datosPersonalesService.findClienteByUsuario(usuario.getIdUsuario());
                model.addAttribute("primerNombre", cliente.getPrimerNombre());
                model.addAttribute("segundoNombre", cliente.getSegundoNombre());
                model.addAttribute("primerApellido", cliente.getPrimerApellido());
                model.addAttribute("segundoApellido", cliente.getSegundoApellido());
                model.addAttribute("telFijo", cliente.getTelefonoFijo());
                model.addAttribute("telCelular", cliente.getTelefonoCelular());
                model.addAttribute("direccion", cliente.getDireccion());
                model.addAttribute("dni", cliente.getDni());
                model.addAttribute("direccion", cliente.getDireccion());
                model.addAttribute("email", cliente.getEmail());
                break;
            case Constantes.PERFIL_ENCARGADO_INV:
            case Constantes.PERFIL_ENCARGADO_ADM:
            case Constantes.PERFIL_ENCARGADO_VENTAS:
                EmpleadoTO empleado = datosPersonalesService.findEmpleadoByUsuario(usuario.getIdUsuario());
                model.addAttribute("primerNombre", empleado.getPrimerNombre());
                model.addAttribute("segundoNombre", empleado.getSegundoNombre());
                model.addAttribute("primerApellido", empleado.getPrimerApellido());
                model.addAttribute("segundoApellido", empleado.getSegundoApellido());
                model.addAttribute("telFijo", empleado.getTelefonoFijo());
                model.addAttribute("telCelular", empleado.getTelefonoCelular());
                model.addAttribute("email", empleado.getEmail());
                model.addAttribute("ruc", empleado.getRuc());
                break;
        }

        return "general/perfil";
    }

    @RequestMapping(value = "/actualizarDatos", method = RequestMethod.GET)
    public String editarDatosPerfil(Model model, HttpSession session) {
        /* obtenemos el usuario logeado */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");

        /* obtenemos el codigo de perfil */
        PerfilTO perfil = (PerfilTO) session.getAttribute("perfil");
        String codPerfil = perfil.getCodigoPerfil();

        /* 1 si es Cliente, 0 si no lo es */
        switch (codPerfil) {
            case Constantes.PERFIL_CLIENTE:
            case Constantes.PERFIL_DISTRIBUIDOR:
                ClienteTO cliente = datosPersonalesService.findClienteByUsuario(usuario.getIdUsuario());
                model.addAttribute("primerNombre", cliente.getPrimerNombre());
                model.addAttribute("segundoNombre", cliente.getSegundoNombre());
                model.addAttribute("primerApellido", cliente.getPrimerApellido());
                model.addAttribute("segundoApellido", cliente.getSegundoApellido());
                model.addAttribute("telFijo", cliente.getTelefonoFijo());
                model.addAttribute("telCelular", cliente.getTelefonoCelular());
                model.addAttribute("direccion", cliente.getDireccion());
                model.addAttribute("dni", cliente.getDni());
                model.addAttribute("direccion", cliente.getDireccion());
                model.addAttribute("email", cliente.getEmail());
                break;
            case Constantes.PERFIL_ENCARGADO_INV:
            case Constantes.PERFIL_ENCARGADO_ADM:
            case Constantes.PERFIL_ENCARGADO_VENTAS:
                EmpleadoTO empleado = datosPersonalesService.findEmpleadoByUsuario(usuario.getIdUsuario());
                model.addAttribute("primerNombre", empleado.getPrimerNombre());
                model.addAttribute("segundoNombre", empleado.getSegundoNombre());
                model.addAttribute("primerApellido", empleado.getPrimerApellido());
                model.addAttribute("segundoApellido", empleado.getSegundoApellido());
                model.addAttribute("telFijo", empleado.getTelefonoFijo());
                model.addAttribute("telCelular", empleado.getTelefonoCelular());
                model.addAttribute("email", empleado.getEmail());
                model.addAttribute("ruc", empleado.getRuc());
                break;
        }
        
        return "general/editarPerfil";
    }

    @RequestMapping(value = "/actualizarDatos", method = RequestMethod.POST)
    public String actualizaDatosPerfil(HttpSession session,
            @RequestParam("telFijo") String telFijo,
            @RequestParam("telCelular") String telCelular,
            @RequestParam("email") String email,
            @RequestParam(name = "direccion", defaultValue = "") String direccion) {

        /* Obtenemos el id del usuario */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        /* Vemos si es cliente o no, y actualizamos dependiendo de esto*/
        int swCliente = Integer.parseInt(session.getAttribute("swCliente").toString());

        if (swCliente == 1) {
            ClienteTO cliente = datosPersonalesService.findClienteByUsuario(idUsuario);
            cliente.setDireccion(direccion);
            cliente.setEmail(email);
            cliente.setTelefonoFijo(telFijo);
            cliente.setTelefonoCelular(telCelular);
            datosPersonalesService.actualizarDatosCliente(cliente);
        } else {
            EmpleadoTO empleado = datosPersonalesService.findEmpleadoByUsuario(idUsuario);
            empleado.setEmail(email);
            empleado.setTelefonoCelular(telCelular);
            empleado.setTelefonoFijo(telFijo);
            datosPersonalesService.actualizarDatosEmpleado(empleado);
        }

        return "redirect:/perfil";
    }
    
    @RequestMapping(value = "/cambiarContraseña", method = RequestMethod.GET)
    public String cambiarContraseña(){
        
        return "general/cambiarContraseña";
    }
    
    @RequestMapping(value = "/passwordCorrecta", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode verificarPasswordCorrecta(@RequestBody ObjectNode nodoJson, HttpSession session){
        /* Obtenemos las contrase�as del json */
        String passwordPosible = nodoJson.get("passwordActual").asText();
        String passwordNueva = nodoJson.get("passwordNueva").asText();
        String passwordConfirmacion = nodoJson.get("passwordConfirmacion").asText();
        
        /* Usuario en la sesion */
        UsuarioTO usuario = (UsuarioTO)session.getAttribute("usuario");
        
        /* String para responder el call ajax */
        String rpta = datosPersonalesService.validarPassword(passwordPosible, passwordNueva, passwordConfirmacion, usuario);
        
        /* Si paso todos los filtros */
        if(rpta == null){
            UsuarioTO actualizado = new UsuarioTO();
            actualizado.setIdUsuario(usuario.getIdUsuario());
            actualizado.setPassUsuario(passwordNueva);
            actualizado = datosPersonalesService.actualizarPassword(actualizado);
            session.setAttribute("usuario", actualizado);
        }
        
        /* Se arma el json de respuesta */
        ObjectMapper mapper = new ObjectMapper();
        
        JsonNode jsonNode = mapper.createObjectNode();
        ((ObjectNode) jsonNode).put("rpta", rpta);
        return jsonNode;
    }

}
