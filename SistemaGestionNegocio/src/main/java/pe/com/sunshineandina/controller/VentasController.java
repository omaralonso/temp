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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.sunshineandina.dto.CategoriaTO;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.DistribuidorTO;
import pe.com.sunshineandina.dto.OfertaTO;
import pe.com.sunshineandina.dto.PedidoTO;
import pe.com.sunshineandina.dto.ProductoTO;
import pe.com.sunshineandina.mapper.RequestMapper;
import pe.com.sunshineandina.request.RegistroPedidoRequest;
import pe.com.sunshineandina.service.CategoriaService;
import pe.com.sunshineandina.service.ClienteService;
import pe.com.sunshineandina.service.DistribuidorService;
import pe.com.sunshineandina.service.HistoricoDistribuidorService;
import pe.com.sunshineandina.service.OfertaService;
import pe.com.sunshineandina.service.PedidoService;
import pe.com.sunshineandina.service.ProductoService;

/**
 *
 * @author FERNANDO
 */
@Controller
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private OfertaService ofertaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private HistoricoDistribuidorService historicoDistribuidorService;

    @Autowired
    private DistribuidorService distribuidorService;

    @RequestMapping(value = "/listaPedidos", method = RequestMethod.GET)
    public String listaPedidos(Model model) {
        List<PedidoTO> listaPedidos = pedidoService.findAllPedidos();
        model.addAttribute("listaPedidos", listaPedidos);
        return "ventas/lista_pedidos";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {

        return "ventas/dashboard";
    }

    @RequestMapping(value = "/listaClientes", method = RequestMethod.GET)
    public String listaClientes(Model model) {
        List<ClienteTO> listaClientes = clienteService.findAllClientes();
        model.addAttribute("listaClientes", listaClientes);
        return "ventas/lista_clientes";
    }

    @RequestMapping(value = "/listaOfertas", method = RequestMethod.GET)
    public String listaOfertas(Model model) {
        List<OfertaTO> listaOfertas = ofertaService.findAllOfertas();
        model.addAttribute("listaOfertas", listaOfertas);
        return "ventas/lista_ofertas";
    }

    @RequestMapping(value = "/editarPedido", method = RequestMethod.POST)
    @ResponseBody
    public PedidoTO editarPedido(@RequestBody ObjectNode nodoJson) {
        int idPedido = nodoJson.get("idPedido").asInt();
        PedidoTO pedido = pedidoService.findPedidoById(idPedido);
        PedidoTO pedidoJson = new PedidoTO();
        pedidoJson.setEstadoPedido(pedido.getEstadoPedido());
        return pedidoJson;
    }

    @RequestMapping(value = "/actualizarPedido", method = RequestMethod.POST)
    @ResponseBody
    public void actualizarPedido(
            @RequestParam("idPedido") int idPedido,
            @RequestParam("estadoPedido") String estadoPedido) {
        PedidoTO pedido = new PedidoTO();
        pedido.setIdPedido(idPedido);
        pedido.setEstadoPedido(estadoPedido);
        pedidoService.actualizarPedido(pedido);
    }

    @RequestMapping(value = "/editarCliente", method = RequestMethod.POST)
    @ResponseBody
    public ClienteTO editarCliente(@RequestBody ObjectNode nodoJson) {
        int idCliente = nodoJson.get("idCliente").asInt();
        ClienteTO cliente = clienteService.findById(idCliente);
        ClienteTO clienteJson = new ClienteTO();
        clienteJson.setIdCliente(cliente.getIdCliente());
        clienteJson.setPrimerNombre(cliente.getPrimerNombre());
        clienteJson.setPrimerApellido(cliente.getPrimerApellido());
        DistribuidorTO distribuidorJson = new DistribuidorTO();
        if (cliente.getDistribuidor() != null) {
            distribuidorJson.setIdDistribuidor(cliente.getDistribuidor().getIdDistribuidor());
            distribuidorJson.setEstadoDistribuidor(cliente.getDistribuidor().getEstadoDistribuidor());
        }
        clienteJson.setDistribuidor(distribuidorJson);
        return clienteJson;
    }

    @RequestMapping(value = "/actualizarCliente", method = RequestMethod.POST)
    @ResponseBody
    public void actualizarCliente(
            @RequestParam("idCliente") int idCliente,
            @RequestParam("tipoCliente") String tipoCliente) {
        ClienteTO cliente = new ClienteTO();
        cliente.setIdCliente(idCliente);
        clienteService.cambiarTipoCliente(cliente, tipoCliente);
    }

    @RequestMapping(value = "/nuevaOferta", method = RequestMethod.GET)
    public String listarCategoriasAgregarOferta(Model model) {
        List<CategoriaTO> listaCategorias = categoriaService.findAllCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        return "ventas/oferta";
    }

    @RequestMapping(value = "/saveOferta", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode addOrEditOferta(
            @RequestParam("idOferta") int idOferta,
            @RequestParam("porcentaje") BigDecimal porcentaje,
            @RequestParam("categoria") int categoria,
            @RequestParam("inicio") String inicioF,
            @RequestParam("fin") String finF,
            Model model) {
        /* Se arma el json de respuesta */
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.createObjectNode();
        CategoriaTO categoriaFind;
        categoriaFind = categoriaService.findCategoriaById(categoria);
        OfertaTO ofertaNew = new OfertaTO();
        ofertaNew.setCategoria(categoriaFind);
        ofertaNew.setPorcentajeOferta(porcentaje);
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date inicio = null;
        Date fin = null;
        try {
            inicio = formatoDelTexto.parse(inicioF);
            fin = formatoDelTexto.parse(finF);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        ofertaNew.setFechaInicio(inicio);
        ofertaNew.setFechaFin(fin);
        if (idOferta == 0) {
            ofertaService.addOferta(ofertaNew);
        } //Hidden editar con id
        else {
            ofertaNew.setIdOferta(idOferta);
            ofertaService.editOferta(ofertaNew);
        }
        ((ObjectNode) jsonNode).put("respuesta", "");
        return jsonNode;
    }

    @RequestMapping(value = "/editarOferta", method = RequestMethod.GET)
    public String redireccionarEditar() {
        return "redirect:/ventas/listaOfertas";
    }

    @RequestMapping(value = "/editarOferta", method = RequestMethod.POST)
    public String listarCategoriasEditar(@RequestParam("idOferta") int id, Model model) {
        List<CategoriaTO> listaCategorias = categoriaService.findAllCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        int idOferta = id;
        OfertaTO oferta = ofertaService.findById(idOferta);
        model.addAttribute("oferta", oferta);
        model.addAttribute("swEditar", 1);
        return "ventas/oferta";
    }

    @RequestMapping(value = "/pedido", method = RequestMethod.GET)
    public String nuevoPedido() {
        return "ventas/registrarPedido";
    }

    @RequestMapping(value = "/categoria", method = RequestMethod.GET)
    @ResponseBody
    public List<CategoriaTO> findCategorias() {
        List<CategoriaTO> lstCategorias = categoriaService.findAllCategorias();

        return lstCategorias;
    }

    @RequestMapping(value = "/categoria/{idCategoria}/producto", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductoTO> findProductoByCategoria(@PathVariable(name = "idCategoria") int idCategoria) {
        List<ProductoTO> lstProductos = productoService.findByCategoria(idCategoria);

        return lstProductos;
    }

    @RequestMapping(value = "/producto/{idProducto}", method = RequestMethod.GET)
    @ResponseBody
    public ProductoTO findProductoById(@PathVariable(name = "idProducto") int idProducto) {
        ProductoTO producto = productoService.findProductoById(idProducto);

        return producto;
    }

    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode registrarPedido(@RequestBody ObjectNode nodoJson) {
        RegistroPedidoRequest registroPedidoRequest = RequestMapper.registroPedidoMapper(nodoJson);

        String rpta = pedidoService.registroPedido(registroPedidoRequest.getDniCliente(),
                registroPedidoRequest.getPedido().getDetallePedidos(),
                registroPedidoRequest.getPedido());

        historicoDistribuidorService.updateBaseRegistro(registroPedidoRequest.getDniCliente(),
                registroPedidoRequest.getPedido().getPrecioAcumuladoPedido(),
                registroPedidoRequest.getPedido().getPuntosAcumuladoPedido());

        Calendar hoy = Calendar.getInstance();
        int mes = hoy.get(Calendar.MONTH) + 1;
        int anio = hoy.get(Calendar.YEAR);

        ClienteTO cliente = clienteService.findByDni(registroPedidoRequest.getDniCliente());
        DistribuidorTO distribuidor = distribuidorService.findByCliente(cliente.getIdCliente());

        if (distribuidor != null) {
            distribuidorService.updateComision(distribuidor.getIdDistribuidor(), mes, anio);
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode nodoJsonRpta = mapper.createObjectNode();

        ((ObjectNode) nodoJsonRpta).put("rpta", rpta);

        return nodoJsonRpta;

    }

}
