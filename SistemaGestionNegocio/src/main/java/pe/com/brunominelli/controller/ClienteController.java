package pe.com.brunominelli.controller;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.brunominelli.dto.CarritoTO;
import pe.com.brunominelli.dto.PedidoTO;
import pe.com.brunominelli.dto.UsuarioTO;
import pe.com.brunominelli.mapper.ResponseMapper;
import pe.com.brunominelli.service.CarritoService;
import pe.com.brunominelli.service.PedidoService;

@Controller
public class ClienteController {

    @Autowired
    private CarritoService carritoService;

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/carrito/detalle", method = RequestMethod.GET)
    public String obtenerCarrito(HttpSession session, Model model) {

        /* Hallamos el usuario logeado */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        /* Carrito actual del usuario cliente o distribuidor */
        CarritoTO carrito = carritoService.findByUsuario(idUsuario);

        model.addAttribute("carrito", carrito);

        return "cliente/carrito";

    }

    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode nuevoPedido(HttpSession session) {
        /* Hallamos el usuario logeado */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        /* Creamos el pedido */
        String rpta = pedidoService.nuevoPedido(idUsuario);

        JsonNode jsonRespuesta = ResponseMapper.nuevoPedidoMapper(rpta);

        return jsonRespuesta;
    }
    
    @RequestMapping(value = "/cliente/listapedidos", method = RequestMethod.GET)
    public String obtenerListaPedidos(HttpSession session, Model model) {

        /* Hallamos el usuario logeado */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();
        model.addAttribute("usuario", usuario);
        
        /* Pedidos del usuario cliente o distribuidor */
        List<PedidoTO> pedidos = pedidoService.findPedidoByIdUsuario(idUsuario);
        model.addAttribute("pedidos", pedidos);

        return "cliente/pedidos";
    }
    
    @RequestMapping(value = "/informacion/acercade", method = RequestMethod.GET)
    public String mostarInformacion(HttpSession session, Model model) {

        return "informacion/acercade";
    }
    
}
