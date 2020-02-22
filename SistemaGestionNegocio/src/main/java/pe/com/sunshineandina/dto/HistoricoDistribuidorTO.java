/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alonsorn
 */
@Entity(name = "HistoricoDistribuidor")
@Table(name = "TSA_HISTORICO_DISTRIBUIDOR")
public class HistoricoDistribuidorTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historico_distribuidor")
    private int idHistoricoDistribuidor;

    @Column(name = "puntos_individual")
    private int puntosIndividual;

    @Column(name = "puntos_grupal")
    private int puntosGrupal;

    @Column(name = "ventas_soles_ind")
    private BigDecimal ventaSolesIndividual;

    @Column(name = "ventas_soles_grupal")
    private BigDecimal ventaSolesGrupal;

    @Column(name = "mes_historico")
    private int mesHistorico;

    @Column(name = "anio_historico")
    private int anioHistorico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_distribuidor")
    private DistribuidorTO distribuidor;

    public HistoricoDistribuidorTO() {
    }

    public int getIdHistoricoDistribuidor() {
        return idHistoricoDistribuidor;
    }

    public void setIdHistoricoDistribuidor(int idHistoricoDistribuidor) {
        this.idHistoricoDistribuidor = idHistoricoDistribuidor;
    }

    public int getPuntosIndividual() {
        return puntosIndividual;
    }

    public void setPuntosIndividual(int puntosIndividual) {
        this.puntosIndividual = puntosIndividual;
    }

    public int getPuntosGrupal() {
        return puntosGrupal;
    }

    public void setPuntosGrupal(int puntosGrupal) {
        this.puntosGrupal = puntosGrupal;
    }

    public BigDecimal getVentaSolesIndividual() {
        return ventaSolesIndividual;
    }

    public void setVentaSolesIndividual(BigDecimal ventaSolesIndividual) {
        this.ventaSolesIndividual = ventaSolesIndividual;
    }

    public BigDecimal getVentaSolesGrupal() {
        return ventaSolesGrupal;
    }

    public void setVentaSolesGrupal(BigDecimal ventaSolesGrupal) {
        this.ventaSolesGrupal = ventaSolesGrupal;
    }

    public int getMesHistorico() {
        return mesHistorico;
    }

    public void setMesHistorico(int mesHistorico) {
        this.mesHistorico = mesHistorico;
    }

    public int getAnioHistorico() {
        return anioHistorico;
    }

    public void setAnioHistorico(int anioHistorico) {
        this.anioHistorico = anioHistorico;
    }

    public DistribuidorTO getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(DistribuidorTO distribuidor) {
        this.distribuidor = distribuidor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idHistoricoDistribuidor;
        hash = 59 * hash + this.puntosIndividual;
        hash = 59 * hash + this.puntosGrupal;
        hash = 59 * hash + Objects.hashCode(this.ventaSolesIndividual);
        hash = 59 * hash + Objects.hashCode(this.ventaSolesGrupal);
        hash = 59 * hash + this.mesHistorico;
        hash = 59 * hash + this.anioHistorico;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HistoricoDistribuidorTO other = (HistoricoDistribuidorTO) obj;
        if (this.idHistoricoDistribuidor != other.idHistoricoDistribuidor) {
            return false;
        }
        if (this.puntosIndividual != other.puntosIndividual) {
            return false;
        }
        if (this.puntosGrupal != other.puntosGrupal) {
            return false;
        }
        if (this.mesHistorico != other.mesHistorico) {
            return false;
        }
        if (this.anioHistorico != other.anioHistorico) {
            return false;
        }
        if (!Objects.equals(this.ventaSolesIndividual, other.ventaSolesIndividual)) {
            return false;
        }
        if (!Objects.equals(this.ventaSolesGrupal, other.ventaSolesGrupal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HistoricoDistribuidorTO{" + "idHistoricoDistribuidor=" + idHistoricoDistribuidor + ", puntosIndividual=" + puntosIndividual + ", puntosGrupal=" + puntosGrupal + ", ventaSolesIndividual=" + ventaSolesIndividual + ", ventaSolesGrupal=" + ventaSolesGrupal + ", mesHistorico=" + mesHistorico + ", anioHistorico=" + anioHistorico + '}';
    }

}
