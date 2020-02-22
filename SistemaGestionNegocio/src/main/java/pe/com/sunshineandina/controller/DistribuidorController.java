/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.sunshineandina.dto.ComisionTO;
import pe.com.sunshineandina.dto.DistribuidorTO;
import pe.com.sunshineandina.dto.HistoricoDistribuidorTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.mapper.ResponseMapper;
import pe.com.sunshineandina.service.DistribuidorService;

/**
 *
 * @author alonsorn
 */
@Controller
@RequestMapping("/distribuidor")
public class DistribuidorController {

    @Autowired
    private DistribuidorService distribuidorService;

    @RequestMapping(value = "/listaComisiones", method = RequestMethod.GET)
    public String listaComisiones(HttpSession session, Model model) {
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        /* Hallamos el distribuidor logeado */
        DistribuidorTO distribuidorActual = distribuidorService.findByUsuario(usuario.getIdUsuario());

        Calendar hoy = Calendar.getInstance();
        int mes = hoy.get(Calendar.MONTH) + 1;
        int anio = hoy.get(Calendar.YEAR);

        List<ComisionTO> comisiones = distribuidorService.findComisionesByParameters(distribuidorActual.getIdDistribuidor(), mes, anio);

        if (!comisiones.isEmpty()) {
            model.addAttribute("comision", comisiones.get(0));
        }

        model.addAttribute("distribuidor", distribuidorActual);
        return "distribuidor/comisiones";
    }

    @RequestMapping(value = "/obtenerComisiones", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode obtenerComisiones(@RequestBody ObjectNode nodoJson) {

        int idDistribuidor = nodoJson.get("idDistribuidor").asInt();

        Calendar calendar = Calendar.getInstance();

        List<HistoricoDistribuidorTO> lstVentasDescendientes
                = distribuidorService.findVentasByPadreAndParameters(idDistribuidor,
                        calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
        JsonNode jsonRpta = ResponseMapper.ventasDistribuidorMapper(lstVentasDescendientes);

        return jsonRpta;
    }

    @RequestMapping(value = "/listaPedidos", method = RequestMethod.GET)
    public String listaPedidos() {
        /* ACA DEBE DIRECCIONAR A LO DE PEDIDOS EN CLIENTE */
        return null;
    }

    @RequestMapping(value = "/tienda", method = RequestMethod.GET)
    public String listaProductos() {
        /* ACA DEBE DIRECCIONAR A LO DE LA TIENDA EN CLIENTE */
        return null;
    }
}
