package pe.com.brunominelli.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ResponseMapper {
    
    public static JsonNode nuevoPedidoMapper(String rpta){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonRespuesta = mapper.createObjectNode();
        
        ((ObjectNode)jsonRespuesta).put("nuevoPedidoResponse", rpta);
        return jsonRespuesta;
    }
    
}
