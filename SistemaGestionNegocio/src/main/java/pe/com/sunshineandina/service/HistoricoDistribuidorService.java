/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.math.BigDecimal;

/**
 *
 * @author alonsorn
 */
public interface HistoricoDistribuidorService {
    
    void updateBaseRegistro(String dniCliente, BigDecimal ventas, int puntos);
    
    void updateAncestrosRegistro(int idDistribuidor, BigDecimal ventas, int puntos, int mes, int anio);
}
