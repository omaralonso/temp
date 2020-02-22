/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.OfertaDAO;
import pe.com.sunshineandina.dto.OfertaTO;
import pe.com.sunshineandina.service.OfertaService;

/**
 *
 * @author FERNANDO
 */
@Service("ofertaService")
@Transactional
public class OfertaServiceImpl implements OfertaService{
    
    @Autowired
    OfertaDAO ofertaDao;
    
    @Override
    public List<OfertaTO> findAllOfertas() {
        List<OfertaTO> listaOfertas=ofertaDao.findAllOfertas();
        for(OfertaTO oferta : listaOfertas){
            Hibernate.initialize(oferta.getCategoria());
        }
        return listaOfertas;
    }

    @Override
    public OfertaTO findById(int idOferta) {
        OfertaTO oferta=ofertaDao.findById(idOferta);
        Hibernate.initialize(oferta.getCategoria());
        return oferta;
    }

    @Override
    public void addOferta(OfertaTO oferta) {
        ofertaDao.save(oferta);
    }

    @Override
    public void editOferta(OfertaTO oferta) {
        if(oferta != null){
            OfertaTO ofertaUpd = ofertaDao.findById(oferta.getIdOferta());
            ofertaUpd.setPorcentajeOferta(oferta.getPorcentajeOferta());
            ofertaUpd.setFechaInicio(oferta.getFechaInicio());
            ofertaUpd.setFechaFin(oferta.getFechaFin());
            ofertaUpd.setCategoria(oferta.getCategoria());
            ofertaDao.save(ofertaUpd);
        }
    }
}
