package pe.com.brunominelli.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.brunominelli.dto.CategoriaTO;
import pe.com.brunominelli.dto.ProductoTO;
import pe.com.brunominelli.service.CategoriaService;
import pe.com.brunominelli.service.ProductoService;
import pe.com.brunominelli.util.Constantes;

@Controller
@RequestMapping("/inventario")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping(value = "/listaProductos", method = RequestMethod.GET)
    public String listaProductos(Model model){
        List<ProductoTO> listaProductos=productoService.findAllProductosInventario();
        model.addAttribute("listaProductos", listaProductos);
        return "inventario/lista_productos";
    }
    
    @RequestMapping(value = "/nuevoProducto", method = RequestMethod.GET)
    public String listarCategoriasAgregar(Model model){
        List<CategoriaTO> listaCategorias = categoriaService.findAllCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        return "inventario/producto";
    }
    
    @RequestMapping(value = "/editarProducto", method = RequestMethod.GET)
        public String redireccionarEditar(){
            return "redirect:/inventario/listaProductos";
        }
        
    @RequestMapping(value = "/editarProducto", method = RequestMethod.POST)
    public String listarCategoriasEditar(@RequestParam("idProducto") int id, Model model){
        List<CategoriaTO> listaCategorias = categoriaService.findAllCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
            int idProducto=id;
            ProductoTO producto=productoService.findProductoById(idProducto);
            model.addAttribute("producto",producto);
            model.addAttribute("swEditar",1);
        return "inventario/producto";
    }
    
    @RequestMapping(value="/saveProducto", method=RequestMethod.POST)
    @ResponseBody
    public JsonNode addOrEditProducto(
            @RequestParam("idProducto") int idProducto,
            @RequestParam("categoria") int categoria,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") BigDecimal precio,
            @RequestParam("cantidad") int cantidad,
            @RequestParam("puntos") int puntos,
            Model model){
        /* Se arma el json de respuesta */
        ObjectMapper mapper = new ObjectMapper();       
        JsonNode jsonNode = mapper.createObjectNode();
        if(productoService.nombreRepetido(nombre))
        {
            if(idProducto==0)
            {
                ((ObjectNode) jsonNode).put("respuesta", "repetido");
                return jsonNode;
            }else if(!productoService.idRepetido(idProducto,nombre))
            {
                ((ObjectNode) jsonNode).put("respuesta", "repetido");
                return jsonNode;              
            }
            
        }
        CategoriaTO categoriaFind;
        categoriaFind=categoriaService.findCategoriaById(categoria);
        ProductoTO productoNew=new ProductoTO();
        productoNew.setCategoria(categoriaFind);
        productoNew.setNombreProducto(nombre);
        productoNew.setPrecioProducto(precio);
        productoNew.setStockProducto(cantidad);
        productoNew.setPuntosProducto(puntos);
        productoNew.setEstadoProducto(1);
        productoNew.setDescripcionProducto(descripcion);
        if(idProducto==0)
        {
            productoService.addProducto(productoNew);
        }
        //Hidden editar con id
        else{
            productoNew.setIdProducto(idProducto);
            productoService.editProducto(productoNew);
        }
        ((ObjectNode) jsonNode).put("respuesta", "");
            return jsonNode;
    }  
    
    @RequestMapping(value = "/cambiarEstadoProducto", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode cambiarEstado(@RequestParam("idProducto") int idProducto)
    {
        ProductoTO producto=productoService.findProductoById(idProducto);
        CategoriaTO categoria=categoriaService.findCategoriaById(producto.getCategoria().getIdCategoria());
        ObjectMapper mapper = new ObjectMapper();       
        JsonNode jsonNode = mapper.createObjectNode();
        if(producto.getEstadoProducto()==Constantes.ESTADO_INACTIVO&&categoria.getEstadoCategoria()==Constantes.ESTADO_INACTIVO)
        {
            ((ObjectNode) jsonNode).put("respuesta", "apagada");
            ((ObjectNode) jsonNode).put("idCategoria", categoria.getIdCategoria());
            return jsonNode;
        }else{
            productoService.changeProductState(producto);
            ((ObjectNode) jsonNode).put("respuesta", "");
            return jsonNode;
        }
    }
    
    @RequestMapping(value = "/cambiarEstadoProductoCategoria", method = RequestMethod.POST)
    @ResponseBody
    public void cambiarEstadoProductoCategoria(
            @RequestParam("idProducto") int idProducto,
            @RequestParam("idCategoria") int idCategoria)
    {
        ProductoTO producto=productoService.findProductoById(idProducto);
        CategoriaTO categoria=categoriaService.findCategoriaById(idCategoria);
        categoriaService.changeCategoriasState(categoria);
        productoService.changeProductState(producto);
    }
}