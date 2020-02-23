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
    
}
