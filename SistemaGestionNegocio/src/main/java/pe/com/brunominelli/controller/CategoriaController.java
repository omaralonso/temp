package pe.com.brunominelli.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.brunominelli.dto.CategoriaTO;
import pe.com.brunominelli.service.CategoriaService;

@Controller
@RequestMapping("/inventario")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping(value = "/listaCategorias",  method = RequestMethod.GET)
    public String listaCategorias(Model model) {
        List<CategoriaTO> listaCategorias = categoriaService.findAllCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        return "inventario/lista_categorias";
    }
    
    @RequestMapping(value = "/editarCategoria", method = RequestMethod.GET)
        public String redireccionarEditar(){
            return "redirect:/inventario/listaCategorias";
        }
    
    @RequestMapping(value = "/editarCategoria",  method = RequestMethod.POST)
    public String listaCategorias(@RequestParam("idCategoria") int id ,Model model) {
        List<CategoriaTO> listaCategorias = categoriaService.findAllCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
            int idCategoria=id ;
            CategoriaTO categoria=categoriaService.findCategoriaById(idCategoria);
            System.out.println(categoria.getDescCategoria());
            model.addAttribute("categoria",categoria);
            model.addAttribute("swEditar",1);
        return "inventario/lista_categorias";
    }
    
    @RequestMapping(value = "/saveCategoria", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode addOrEditCategoria(
            @RequestParam("idCategoria") int idCategoria,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            Model model){
        ObjectMapper mapper = new ObjectMapper();       
        JsonNode jsonNode = mapper.createObjectNode();
        if(categoriaService.nombreRepetido(nombre))
        {
            if(idCategoria==0)
            {
                ((ObjectNode) jsonNode).put("respuesta", "repetido");
                return jsonNode;
            }else if(!categoriaService.idRepetido(idCategoria,nombre))
            {
                ((ObjectNode) jsonNode).put("respuesta", "repetido");
                return jsonNode;              
            }
            
        }
        CategoriaTO categoriaNew= new CategoriaTO();
        categoriaNew.setNombreCategoria(nombre);
        categoriaNew.setDescCategoria(descripcion);
        categoriaNew.setEstadoCategoria(1);
        if(idCategoria==0)
        {
            categoriaService.addCategoria(categoriaNew);
        }
        //Hidden editar con id
        else{
            categoriaNew.setIdCategoria(idCategoria);
            categoriaService.updateCategoria(categoriaNew);
        }
        ((ObjectNode) jsonNode).put("respuesta", "");
            return jsonNode;
    }
    
    @RequestMapping(value = "/cambiarEstadoCategoria", method = RequestMethod.POST)
    @ResponseBody
    public void cambiarEstado(@RequestParam("idCategoria") int idCategoria)
    {
        CategoriaTO categoria=categoriaService.findCategoriaById(idCategoria);
        categoriaService.changeCategoriasState(categoria);
    }
}
