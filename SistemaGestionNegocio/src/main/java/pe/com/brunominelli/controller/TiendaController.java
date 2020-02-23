package pe.com.brunominelli.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.brunominelli.dto.CategoriaTO;
import pe.com.brunominelli.dto.ProductoTO;
import pe.com.brunominelli.dto.UsuarioTO;
import pe.com.brunominelli.service.CarritoService;
import pe.com.brunominelli.service.CategoriaService;
import pe.com.brunominelli.service.ProductoService;

@Controller
@RequestMapping("/tienda")
public class TiendaController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CarritoService carritoService;

    @RequestMapping(value = "/productos", method = RequestMethod.GET)
    public String listaProductosVenta(Model model,
            @RequestParam(name = "selectCategoria", defaultValue = "0") String idCategoria) {
        /* Hallamos todas las categorias para el combo box */
        List<CategoriaTO> lstCategorias = categoriaService.findAllCategorias();
        model.addAttribute("lstCategorias", lstCategorias);

        int idCategoriaParsed = Integer.parseInt(idCategoria);
        List<ProductoTO> lstProductos;
        if (idCategoriaParsed > 0) {
            lstProductos = productoService.findByCategoria(idCategoriaParsed);
        } else {
            /* Hallamos la lista de productos paginados */
            lstProductos = productoService.findAllProductosInventario();

        }
        model.addAttribute("lstProductos", lstProductos);
        /* Nro de paginas y cantidad de productos*/
        return "cliente/listaProductos";
    }

    @RequestMapping(value = "/productos/{idProducto}", method = RequestMethod.GET)
    @ResponseBody
    public ProductoTO detalleProducto(@PathVariable(name = "idProducto") int idProducto) {
        ProductoTO producto = productoService.findProductoById(idProducto);

        ProductoTO productoJson = new ProductoTO();
        productoJson.setCategoria(new CategoriaTO());
        productoJson.getCategoria().setNombreCategoria(producto.getCategoria().getNombreCategoria());
        productoJson.setIdProducto(producto.getIdProducto());
        productoJson.setNombreProducto(producto.getNombreProducto());
        productoJson.setDescripcionProducto(producto.getDescripcionProducto());
        productoJson.setStockProducto(producto.getStockProducto());

        return productoJson;
    }

    @RequestMapping(value = "/carrito", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode agregarACarrito(HttpSession session, @RequestBody ObjectNode nodoJson) {
        /* Leemos la data del json */
        int idProducto = nodoJson.get("idProducto").asInt();
        int cantidad = nodoJson.get("cantidad").asInt();

        /* Hallamos el usuario logeado */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        String rpta = carritoService.insertarDetalle(idUsuario, idProducto, cantidad);

        return null;
    }

}
