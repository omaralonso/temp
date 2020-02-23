package pe.com.brunominelli.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.brunominelli.dto.PoliticaTO;
import pe.com.brunominelli.service.PoliticaService;

@Controller
@RequestMapping("/admin")
public class AdministracionController {

    @Autowired
    private PoliticaService politicaService;

    @RequestMapping(value = "/listaPoliticas", method = RequestMethod.GET)
    public String listaPoliticas(Model model) {
        List<PoliticaTO> lstPoliticas = politicaService.findAllPoliticas();
        
        model.addAttribute("lstPoliticas", lstPoliticas);
        
        return "admin/lista_politicas";
    }
    
    @RequestMapping(value = "/editarPolitica", method = RequestMethod.POST)
    @ResponseBody
    public PoliticaTO editarPolitica(@RequestBody ObjectNode nodoJson){
        /* Obtenemos el id del json */
        int idPolitica = nodoJson.get("idPolitica").asInt();
        
        /* Hallamos la politica relacionada */
        PoliticaTO politica = politicaService.findById(idPolitica);
        
        return politica;
    }
    
    @RequestMapping(value = "/actualizarPolitica", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode actualizarPolitica(@RequestBody PoliticaTO politica){
        politicaService.actualizarPolitica(politica);
        ObjectMapper mapper = new ObjectMapper();
        
        JsonNode jsonRpta = mapper.createObjectNode();
        
        ((ObjectNode) jsonRpta).put("rpta", "ok");
        
        return jsonRpta;
    }
     
}
