package pe.com.brunominelli.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import pe.com.brunominelli.dto.DetallePedidoTO;
import pe.com.brunominelli.dto.PedidoTO;
import pe.com.brunominelli.dto.ProductoTO;
import pe.com.brunominelli.request.RegistroPedidoRequest;

public class RequestMapper {
    
    public static RegistroPedidoRequest registroPedidoMapper(ObjectNode nodoJson){
        
        RegistroPedidoRequest registroPedidoRequest = new RegistroPedidoRequest();
        
        String dniCliente = nodoJson.get("dniCliente").asText();
        
        PedidoTO pedido = new PedidoTO();
        
        List<DetallePedidoTO> detalles = new ArrayList<>();
        
        JsonNode arrPedido = nodoJson.get("pedido");
        
        for(JsonNode detalleJson: arrPedido){
            /* Hallamos el producto */
            ProductoTO producto = new ProductoTO();
            producto.setIdProducto(detalleJson.get("idProducto").asInt());
            
            /* Creamos el detalle */
            DetallePedidoTO detalle = new DetallePedidoTO();
            detalle.setCantidad(detalleJson.get("cantidad").asInt());
            detalle.setPrecioDetallePedido(new BigDecimal(detalleJson.get("subtotal").asDouble()));
            detalle.setPuntosDetallePedido(detalleJson.get("subtotalPuntos").asInt());
            detalle.setProducto(producto);
            
            detalles.add(detalle);
            
        }
        
        pedido.setPrecioAcumuladoPedido(new BigDecimal(nodoJson.get("totalSoles").asDouble()));
        pedido.setPuntosAcumuladoPedido(nodoJson.get("totalPuntos").asInt());
        pedido.setDetallePedidos(detalles);
        
        registroPedidoRequest.setDniCliente(dniCliente);
        registroPedidoRequest.setPedido(pedido);
        
        return registroPedidoRequest;
    }
    
    
}
