/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.ClienteDAO;
import pe.com.sunshineandina.dao.DistribuidorDAO;
import pe.com.sunshineandina.dao.HistoricoDistribuidorDAO;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.DistribuidorTO;
import pe.com.sunshineandina.dto.HistoricoDistribuidorTO;
import pe.com.sunshineandina.service.HistoricoDistribuidorService;

/**
 *
 * @author alonsorn
 */
@Service("historicoDistribuidorService")
@Transactional
public class HistoricoDistribuidorServiceImpl implements HistoricoDistribuidorService {

    @Autowired
    private HistoricoDistribuidorDAO historicoDistribuidorDao;

    @Autowired
    private ClienteDAO clienteDao;

    @Autowired
    private DistribuidorDAO distribuidorDao;

    @Override
    public void updateBaseRegistro(String dniCliente, BigDecimal ventas, int puntos) {
        ClienteTO cliente = clienteDao.findByDni(dniCliente);

        DistribuidorTO distribuidor = distribuidorDao.findByCliente(cliente.getIdCliente());

        if (distribuidor != null) {
            Calendar hoy = Calendar.getInstance();

            int mes = hoy.get(Calendar.MONTH) + 1;
            int anio = hoy.get(Calendar.YEAR);

            int idDistribuidor = distribuidor.getIdDistribuidor();

            /* Vemos si ya tiene un registro, sino lo creamos */
            HistoricoDistribuidorTO historicoDistribuidor
                    = historicoDistribuidorDao.findUnique(distribuidor.getIdDistribuidor(), mes, anio);

            /* Creamos */
            if (historicoDistribuidor == null) {
                historicoDistribuidor = new HistoricoDistribuidorTO();
                historicoDistribuidor.setDistribuidor(distribuidor);
                historicoDistribuidor.setMesHistorico(mes);
                historicoDistribuidor.setAnioHistorico(anio);
                historicoDistribuidor.setPuntosIndividual(puntos);
                historicoDistribuidor.setVentaSolesIndividual(ventas);

                historicoDistribuidor.setVentaSolesGrupal(
                        historicoDistribuidorDao.sumVentasIndividualesDescendientes(idDistribuidor, mes, anio)
                                .add(historicoDistribuidorDao.sumVentasGrupalesDescendientes(idDistribuidor, mes, anio))
                );

                historicoDistribuidor.setPuntosGrupal(
                        historicoDistribuidorDao.sumPuntosIndividualesDescendientes(idDistribuidor, mes, anio)
                        + historicoDistribuidorDao.sumPuntosGrupalesDescendientes(idDistribuidor, mes, anio)
                );

            } else {
                historicoDistribuidor.setPuntosIndividual(historicoDistribuidor.getPuntosIndividual() + puntos);
                historicoDistribuidor.setVentaSolesIndividual(historicoDistribuidor.getVentaSolesIndividual().add(ventas));

            }

            historicoDistribuidorDao.save(historicoDistribuidor);

            Hibernate.initialize(distribuidor.getPadre());

            if (distribuidor.getPadre() != null) {
                updateAncestrosRegistro(distribuidor.getPadre().getIdDistribuidor(), ventas, puntos, mes, anio);
            }
        }

    }

    @Override
    public void updateAncestrosRegistro(int idDistribuidor, BigDecimal ventas, int puntos, int mes, int anio) {
        HistoricoDistribuidorTO historicoDistribuidor = historicoDistribuidorDao.findUnique(idDistribuidor, mes, anio);
        DistribuidorTO distribuidor = distribuidorDao.findById(idDistribuidor);
        
        if (historicoDistribuidor == null) {
            historicoDistribuidor = new HistoricoDistribuidorTO();
            historicoDistribuidor.setDistribuidor(distribuidor);
            historicoDistribuidor.setPuntosIndividual(0);
            historicoDistribuidor.setVentaSolesIndividual(new BigDecimal(0));
            historicoDistribuidor.setPuntosGrupal(puntos);
            historicoDistribuidor.setVentaSolesGrupal(ventas);
            historicoDistribuidor.setMesHistorico(mes);
            historicoDistribuidor.setAnioHistorico(anio);
        } else {
            historicoDistribuidor.setVentaSolesGrupal(historicoDistribuidor.getVentaSolesGrupal().add(ventas));
            historicoDistribuidor.setPuntosGrupal(historicoDistribuidor.getPuntosGrupal() + puntos);
        }
        historicoDistribuidorDao.save(historicoDistribuidor);
        
        Hibernate.initialize(distribuidor.getPadre());
        if(distribuidor.getPadre() != null){
            updateAncestrosRegistro(distribuidor.getPadre().getIdDistribuidor(), ventas, puntos, mes, anio);
        }
    }
}
