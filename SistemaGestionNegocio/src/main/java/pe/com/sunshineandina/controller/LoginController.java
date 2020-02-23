/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.service.DatosPersonalesService;
import pe.com.sunshineandina.service.LoginService;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author alonsorn
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @Autowired
    private DatosPersonalesService datosPersonalesService;

    @RequestMapping("/")
    public String index() {

        return "general/login";
    }

    @RequestMapping("/login")
    public String login(
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String password,
            HttpSession session) {

        /* Usuario a comprobar si es el autentico*/
        UsuarioTO usuarioPosible = new UsuarioTO();
        usuarioPosible.setRegistroUsuario(usuario);
        usuarioPosible.setPassUsuario(password);

        /* Verificamos si es autentico*/
        Map<String, Object> mapResultado = loginService.autenticacion(usuarioPosible);

        UsuarioTO usuarioReal = (UsuarioTO) mapResultado.get("usuario");

        /* Si no existe el usuario*/
        if (usuarioReal == null) {
            return "redirect:/";
        }

        usuarioReal.setPerfiles(loginService.perfilesUsuario(usuarioReal));
        session.setAttribute("usuario", usuarioReal);
        
        /* Determinamos si es cliente o empleado */
        int swCliente = loginService.esCliente(usuarioReal.getIdUsuario());
        session.setAttribute("swCliente", loginService.esCliente(usuarioReal.getIdUsuario()));
        /* Hallamos el nombre para mostrar */
        session.setAttribute("nombrePerfil", datosPersonalesService.nombrePerfil(usuarioReal.getIdUsuario(), swCliente));

        /* Obtenemos el perfil*/
        PerfilTO perfil = usuarioReal.getPerfiles().get(0);
        session.setAttribute("perfil", perfil);
        /* DEPENDIENDO DEL PERFIL, LLEVAMOS A LA PAGINA DE INICIO*/
        switch (perfil.getCodigoPerfil()) {
            case Constantes.PERFIL_ENCARGADO_INV:
                return "redirect:/inventario/listaProductos";
            case Constantes.PERFIL_ENCARGADO_ADM:
                return "redirect:/admin/listaEmpleados";
            case Constantes.PERFIL_ENCARGADO_VENTAS:
                return "redirect:/ventas/listaPedidos";
            case Constantes.PERFIL_CLIENTE:
                return "redirect:/tienda/productos";
            default:
                return "redirect:/tienda/productos";
        }
    }

    @RequestMapping("/cerrarSesion")
    public String cerrarSession(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }
}
