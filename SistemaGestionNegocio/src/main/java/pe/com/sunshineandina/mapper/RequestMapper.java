/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import pe.com.sunshineandina.dto.DetallePedidoTO;
import pe.com.sunshineandina.dto.PedidoTO;
import pe.com.sunshineandina.dto.ProductoTO;
import pe.com.sunshineandina.request.RegistroPedidoRequest;

/**
 *
 * @author alonsorn
 */
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
