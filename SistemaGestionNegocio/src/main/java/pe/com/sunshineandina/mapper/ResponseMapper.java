/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import java.util.List;
import pe.com.sunshineandina.dto.HistoricoDistribuidorTO;
import pe.com.sunshineandina.response.VentasDistribuidorResponse;

/**
 *
 * @author alonsorn
 * Colocar en el nombre del metodo el mismo nombre
 * que el response que se esta mapeando
 */
public class ResponseMapper {
    
    public static JsonNode nuevoPedidoMapper(String rpta){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonRespuesta = mapper.createObjectNode();
        
        ((ObjectNode)jsonRespuesta).put("nuevoPedidoResponse", rpta);
        return jsonRespuesta;
    }
    
    public static JsonNode ventasDistribuidorMapper(List<HistoricoDistribuidorTO> lstVentas){
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonRespuesta = mapper.createObjectNode();
        ArrayNode arrayVentasResponse = mapper.createArrayNode();
        
        for(HistoricoDistribuidorTO historico : lstVentas){
            VentasDistribuidorResponse ventasDistribuidorResponse = new VentasDistribuidorResponse();
            ventasDistribuidorResponse.setIdHistoricoDistribuidor(historico.getIdHistoricoDistribuidor());
            /* Armamos la cadena del nombre */
            String primerNombre = historico.getDistribuidor().getCliente().getPrimerNombre();
            String primerApellido = historico.getDistribuidor().getCliente().getPrimerApellido();
            String nombreDistribuidor = primerNombre.substring(0, 1) + primerNombre.substring(1).toLowerCase()
                    + " " + primerApellido.substring(0,1) + primerApellido.substring(1).toLowerCase();
            ventasDistribuidorResponse.setNombreDistribuidor(nombreDistribuidor);
            /* Obtenemos el total de ventas */
            BigDecimal ventasSoles = historico.getVentaSolesIndividual().add(historico.getVentaSolesGrupal());
            ventasDistribuidorResponse.setVentasSoles(ventasSoles);
            
            arrayVentasResponse.addPOJO(ventasDistribuidorResponse);
        }
        ((ObjectNode) jsonRespuesta).putArray("listaVentas").addAll(arrayVentasResponse);
        return jsonRespuesta;
    }
}
