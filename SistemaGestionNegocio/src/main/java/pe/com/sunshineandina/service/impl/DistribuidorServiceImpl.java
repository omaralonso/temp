/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.ComisionDAO;
import pe.com.sunshineandina.dao.DistribuidorDAO;
import pe.com.sunshineandina.dao.HistoricoDistribuidorDAO;
import pe.com.sunshineandina.dao.PoliticaDAO;
import pe.com.sunshineandina.dto.ComisionTO;
import pe.com.sunshineandina.dto.DistribuidorTO;
import pe.com.sunshineandina.dto.HistoricoDistribuidorTO;
import pe.com.sunshineandina.dto.PoliticaTO;
import pe.com.sunshineandina.service.DistribuidorService;

/**
 *
 * @author alonsorn
 */
@Service("distribuidorService")
@Transactional
public class DistribuidorServiceImpl implements DistribuidorService {

    @Autowired
    private DistribuidorDAO distribuidorDao;

    @Autowired
    private ComisionDAO comisionDao;

    @Autowired
    private HistoricoDistribuidorDAO historicoDistribuidorDao;

    @Autowired
    private PoliticaDAO politicaDao;

    @Override
    public DistribuidorTO findByUsuario(int idUsuario) {
        return distribuidorDao.findByUsuario(idUsuario);
    }

    @Override
    public List<ComisionTO> findComisionesByParameters(int idDistribuidor, int mes, int anio) {
        return comisionDao.findByParameters(idDistribuidor, mes, anio);
    }

    @Override
    public List<HistoricoDistribuidorTO> findVentasByPadreAndParameters(int idPadre, int mes, int anio) {
        /* List para guardar los historicos de los descendientes */
        List<HistoricoDistribuidorTO> ventasDescendientes = new ArrayList<>();
        /* Hallamos el distribuidor padre */
        DistribuidorTO padre = distribuidorDao.findById(idPadre);
        /* Obtenemos los descendientes */
        Hibernate.initialize(padre.getDescendientes());
        List<DistribuidorTO> descendientes = padre.getDescendientes();

        for (DistribuidorTO descendiente : descendientes) {
            HistoricoDistribuidorTO historicoDescendiente
                    = historicoDistribuidorDao.findUnique(descendiente.getIdDistribuidor(), mes, anio);
            Hibernate.initialize(historicoDescendiente.getDistribuidor());
            Hibernate.initialize(historicoDescendiente.getDistribuidor().getCliente());
            ventasDescendientes.add(historicoDescendiente);
        }
        return ventasDescendientes;
    }

    @Override
    public DistribuidorTO findById(int idDitribuidor) {
        return distribuidorDao.findById(idDitribuidor);
    }

    @Override
    public PoliticaTO findPoliticaByParameters(int puntosInd, int puntosGru) {
        return politicaDao.findByParameters(puntosInd, puntosGru);
    }

    @Override
    public void updateComision(int idDistribuidor, int mes, int anio) {
        ComisionTO miComision = comisionDao.findUnique(idDistribuidor, mes, anio);
        HistoricoDistribuidorTO miHistorico = historicoDistribuidorDao.findUnique(idDistribuidor, mes, anio);
        PoliticaTO miPorcentaje = politicaDao.findByParameters(miHistorico.getPuntosIndividual(), miHistorico.getPuntosGrupal()
                + miHistorico.getPuntosIndividual());
        DistribuidorTO distribuidor = distribuidorDao.findById(idDistribuidor);
        double monto;

        if (miPorcentaje != null) {
            BigDecimal miPct = miPorcentaje.getPorcentajeDescuento();

            if (miComision == null) {

                miComision = new ComisionTO();
                miComision.setDistribuidor(distribuidor);
                miComision.setAnioComision(anio);
                miComision.setMesComision(mes);

                /* calculamos el monto */
                monto = 0;
            } else {
                monto = miComision.getMontoComision().doubleValue();
            }

            Hibernate.initialize(distribuidor.getDescendientes());
            List<DistribuidorTO> descendientes = distribuidor.getDescendientes();
            for (DistribuidorTO descendiente : descendientes) {
                HistoricoDistribuidorTO historicoDescendiente = historicoDistribuidorDao.findUnique(descendiente.getIdDistribuidor(),
                        mes, anio);
                if (historicoDescendiente != null) {
                    BigDecimal pctDescendiente;
                    PoliticaTO porcentajeDescendiente = politicaDao
                            .findByParameters(historicoDescendiente.getPuntosIndividual(), historicoDescendiente.getPuntosGrupal());
                    if (porcentajeDescendiente == null) {
                        pctDescendiente = new BigDecimal(0);
                    } else {
                        pctDescendiente = porcentajeDescendiente.getPorcentajeDescuento();
                    }
                    if (miPct.doubleValue() <= pctDescendiente.doubleValue()) {

                    } else {
                        BigDecimal pctVerdadero = miPct.subtract(pctDescendiente);
                        BigDecimal montoDescendiente = historicoDescendiente.getVentaSolesGrupal()
                                .add(historicoDescendiente.getVentaSolesIndividual());
                        monto += (montoDescendiente.multiply(pctVerdadero)).doubleValue();
                    }

                }
            }
            BigDecimal mult = miHistorico.getVentaSolesIndividual().multiply(miPct);
            monto += mult.doubleValue();
            miComision.setMontoComision(new BigDecimal(monto));
            comisionDao.save(miComision);
        }

        Hibernate.initialize(distribuidor.getPadre());
        if (distribuidor.getPadre() != null) {
            updateComision(distribuidor.getPadre().getIdDistribuidor(), mes, anio);
        }
    }

    @Override
    public DistribuidorTO findByCliente(int idCliente) {
        return distribuidorDao.findByCliente(idCliente);
    }

}
