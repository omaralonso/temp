package pe.com.brunominelli.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.brunominelli.dao.PoliticaDAO;
import pe.com.brunominelli.dto.PoliticaTO;
import pe.com.brunominelli.service.PoliticaService;

@Service("politicaService")
@Transactional
public class PoliticaServiceImpl implements PoliticaService{

    @Autowired
    private PoliticaDAO politicaDao;
    
    @Override
    public List<PoliticaTO> findAllPoliticas() {
        return politicaDao.findAll();
    }

    @Override
    public void actualizarPolitica(PoliticaTO politica) {
        if(politica != null){
            PoliticaTO politicaEntity = politicaDao.findById(politica.getIdPolitica());
            politicaEntity.setMinPuntosIndividual(politica.getMinPuntosIndividual());
            politicaEntity.setMaxPuntosIndividual(politica.getMaxPuntosIndividual());
            politicaEntity.setMinPuntosGrupal(politica.getMinPuntosGrupal());
            politicaEntity.setMaxPuntosGrupal(politica.getMaxPuntosGrupal());
            politicaEntity.setPorcentajeDescuento(politica.getPorcentajeDescuento());
            politicaDao.save(politicaEntity);
        }
    }

    @Override
    public PoliticaTO findById(int idPolitica) {
        return politicaDao.findById(idPolitica);
    }
    
}
