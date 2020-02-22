/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.math.BigDecimal;
import java.util.List;
import pe.com.sunshineandina.dto.HistoricoDistribuidorTO;

/**
 *
 * @author alonsorn
 */
public interface HistoricoDistribuidorDAO {
    
    HistoricoDistribuidorTO findById(int id);
    
    void save(HistoricoDistribuidorTO historicoDistribuidor);
    
    List<HistoricoDistribuidorTO> findByParameters(int idDistribuidor, int mes, int anio);
    
    HistoricoDistribuidorTO findUnique(int idDistribuidor, int mes, int anio);
    
    int sumPuntosIndividualesDescendientes(int idDistribuidor, int mes, int anio);
    
    int sumPuntosGrupalesDescendientes(int idDistribuidor, int mes , int anio);
    
    BigDecimal sumVentasIndividualesDescendientes(int idDistribuidor, int mes, int anio);
    
    BigDecimal sumVentasGrupalesDescendientes(int idDistribuidor, int mes, int anio);
}
