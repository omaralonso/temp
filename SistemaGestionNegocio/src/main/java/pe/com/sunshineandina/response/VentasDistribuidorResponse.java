/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.response;

import java.math.BigDecimal;

/**
 *
 * @author alonsorn
 */
public class VentasDistribuidorResponse {

    private int idHistoricoDistribuidor;
    private String nombreDistribuidor;
    private BigDecimal ventasSoles;

    public VentasDistribuidorResponse() {
    }

    public int getIdHistoricoDistribuidor() {
        return idHistoricoDistribuidor;
    }

    public void setIdHistoricoDistribuidor(int idHistoricoDistribuidor) {
        this.idHistoricoDistribuidor = idHistoricoDistribuidor;
    }

    public String getNombreDistribuidor() {
        return nombreDistribuidor;
    }

    public void setNombreDistribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public BigDecimal getVentasSoles() {
        return ventasSoles;
    }

    public void setVentasSoles(BigDecimal ventasSoles) {
        this.ventasSoles = ventasSoles;
    }

}
