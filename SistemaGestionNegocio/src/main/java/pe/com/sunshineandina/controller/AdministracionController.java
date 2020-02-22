/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.sunshineandina.dto.EmpleadoTO;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.PoliticaTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.service.EmpleadoService;
import pe.com.sunshineandina.service.PoliticaService;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author alonsorn
 */
@Controller
@RequestMapping("/admin")
public class AdministracionController {

    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    private PoliticaService politicaService;

    @RequestMapping(value = "/listaEmpleados", method = RequestMethod.GET)
    public String listaEmpleados(Model model) {
        /* Hallamos todos los empleados OJO HAY QUE CAMBIAR POR PAGINADO*/
        List<EmpleadoTO> lstEmpleados = empleadoService.findAllEmpleados();
        model.addAttribute("lstEmpleados", lstEmpleados);
        return "admin/lista_empleados";
    }

    @RequestMapping(value = "/saveEmpleado", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode nuevoEmpleado(
            @RequestParam("idEmpleado") int idEmpleado,
            @RequestParam("ruc") String ruc,
            @RequestParam("primerNombre") String primerNombre,
            @RequestParam(value = "segundoNombre", defaultValue = "") String segundoNombre,
            @RequestParam("primerApellido") String primerApellido,
            @RequestParam("segundoApellido") String segundoApellido,
            @RequestParam("telefonoFijo") String telefonoFijo,
            @RequestParam("telefonoCelular") String telefonoCelular,
            @RequestParam("email") String email,
            @RequestParam("usuario") String usuario,
            @RequestParam(value="password", defaultValue = "") String password,
            @RequestParam("perfiles[]") String[] perfiles) {
        /* Creamos el usuario */
        UsuarioTO usuarioEntity = new UsuarioTO();
        usuarioEntity.setRegistroUsuario(usuario);
        if(password!="")
            usuarioEntity.setPassUsuario(password);     
        usuarioEntity.setEstadoUsuario(Constantes.ESTADO_ACTIVO);
        usuarioEntity.setFechaRegistro(new Date());
        ObjectMapper mapper = new ObjectMapper();       
        JsonNode jsonNode = mapper.createObjectNode();
        boolean b=false;
        if(empleadoService.usuarioRepetido(usuario))
        {
            if(idEmpleado==0)
            {
                ((ObjectNode) jsonNode).put("respuesta", "repetido");
                b=true;
            }else if(!empleadoService.idRepetido(idEmpleado,usuario))
            {
                ((ObjectNode) jsonNode).put("respuesta", "repetido");
                b=true;              
            }       
        }
        if(empleadoService.rucRepetido(ruc))
        {
            if(idEmpleado==0)
            {
                ((ObjectNode) jsonNode).put("rucrespuesta", "rucrepetido");
                b=true;
            }else if(!empleadoService.idRucRepetido(idEmpleado,ruc))
            {
                ((ObjectNode) jsonNode).put("rucrespuesta", "rucrepetido");
                b=true;              
            }       
        }
        if(b){
            return jsonNode;
        }
        /* Creamos el empleado */
        EmpleadoTO empleadoEntity = new EmpleadoTO();
        empleadoEntity.setPrimerNombre(primerNombre.toUpperCase());
        empleadoEntity.setSegundoNombre(segundoNombre.toUpperCase());
        empleadoEntity.setPrimerApellido(primerApellido.toUpperCase());
        empleadoEntity.setSegundoApellido(segundoApellido.toUpperCase());
        empleadoEntity.setRuc(ruc);
        empleadoEntity.setTelefonoCelular(telefonoCelular);
        empleadoEntity.setTelefonoFijo(telefonoFijo);
        empleadoEntity.setEmail(email.toUpperCase());
        empleadoEntity.setUsuario(usuarioEntity);
        /* Guardamos el nuevo empleado */
        if(idEmpleado==0)
        {
            empleadoService.addEmpleado(empleadoEntity, perfiles);
        }
        //Hidden editar con id
        else{
            
            empleadoEntity.setIdEmpleado(idEmpleado);
            empleadoService.editEmpleado(empleadoEntity, perfiles);
        }
        ((ObjectNode) jsonNode).put("respuesta", "");
        ((ObjectNode) jsonNode).put("rucrespuesta", "");
            return jsonNode;
    }

    @RequestMapping(value = "/nuevoEmpleado", method = RequestMethod.GET)
    public String nuevoUsuario(Model model) {
        /* Obtenemos lista de perfiles */
        List<PerfilTO> lstPerfiles = empleadoService.findAllPerfiles();

        model.addAttribute("lstPerfiles", lstPerfiles);
        return "admin/empleado";
    }
    
    @RequestMapping(value = "/listaEmpleados", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonNode inactivaEmpleado(@RequestBody ObjectNode nodoJson){
        /* Obtenemos el id del usuario relacionado con el empleado */
        int idUsuario = nodoJson.get("idUsuario").asInt();
        
        /* Actualizamos el empleado */
        empleadoService.inactivarEmpleado(idUsuario);
        
        /* Json de respuesta */
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonRpta = mapper.createObjectNode();
        ((ObjectNode)jsonRpta).put("rpta", "ok");
        
        return jsonRpta;
    } 

    @RequestMapping(value = "/listaPoliticas", method = RequestMethod.GET)
    public String listaPoliticas(Model model) {
        List<PoliticaTO> lstPoliticas = politicaService.findAllPoliticas();
        
        model.addAttribute("lstPoliticas", lstPoliticas);
        
        return "admin/lista_politicas";
    }
    
    @RequestMapping(value = "/editarPolitica", method = RequestMethod.POST)
    @ResponseBody
    public PoliticaTO editarPolitica(@RequestBody ObjectNode nodoJson){
        /* Obtenemos el id del json */
        int idPolitica = nodoJson.get("idPolitica").asInt();
        
        /* Hallamos la politica relacionada */
        PoliticaTO politica = politicaService.findById(idPolitica);
        
        return politica;
    }
    
    @RequestMapping(value = "/actualizarPolitica", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode actualizarPolitica(@RequestBody PoliticaTO politica){
        politicaService.actualizarPolitica(politica);
        ObjectMapper mapper = new ObjectMapper();
        
        JsonNode jsonRpta = mapper.createObjectNode();
        
        ((ObjectNode) jsonRpta).put("rpta", "ok");
        
        return jsonRpta;
    }
    
    @RequestMapping(value = "/editarEmpleado", method = RequestMethod.GET)
        public String redireccionarEditar(){
            return "redirect:/admin/listaEmpleados";
        }
        
    @RequestMapping(value = "/editarEmpleado", method = RequestMethod.POST)
    public String empleadoEditar(@RequestParam("idEmpleado") int id, Model model){
        List<PerfilTO> lstPerfiles = empleadoService.findAllPerfiles();
        model.addAttribute("lstPerfiles", lstPerfiles);
            int idEmpleado=id;
            EmpleadoTO empleado=empleadoService.findEmpleadoById(idEmpleado);
            model.addAttribute("empleado",empleado);
            String passUsuario=empleado.getUsuario().getPassUsuario();
            model.addAttribute("passUsuario",passUsuario);
            model.addAttribute("swEditar",1);
        return "admin/empleado";
    }
    
    @RequestMapping(value = "/cambiarEstadoUsuario", method = RequestMethod.POST)
    @ResponseBody
    public void cambiarEstado(@RequestParam("idUsuario") int idUsuario)
    {
        UsuarioTO usuario=empleadoService.findUsuario(idUsuario);
        empleadoService.changeUsuarioState(usuario);
    } 
}
