/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.ComisionTO;
import pe.com.sunshineandina.dto.DistribuidorTO;
import pe.com.sunshineandina.dto.HistoricoDistribuidorTO;
import pe.com.sunshineandina.dto.PoliticaTO;

/**
 *
 * @author alonsorn
 */
public interface DistribuidorService {

    public DistribuidorTO findByUsuario(int idUsuario);

    public DistribuidorTO findById(int idDitribuidor);

    public List<ComisionTO> findComisionesByParameters(int idDistribuidor, int mes, int anio);

    public List<HistoricoDistribuidorTO> findVentasByPadreAndParameters(int idPadre, int mes, int anio);

    PoliticaTO findPoliticaByParameters(int puntosInd, int puntosGru);
    
    DistribuidorTO findByCliente(int idCliente);

    void updateComision(int idDistribuidor, int mes, int anio);
}
