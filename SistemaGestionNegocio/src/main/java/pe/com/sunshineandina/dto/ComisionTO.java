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
@Entity(name = "Comision")
@Table(name="TSA_COMISION")
public class ComisionTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comision")
    private int idComision;

    @Column(name = "monto_comision")
    private BigDecimal montoComision;

    @Column(name = "mes_comision")
    private int mesComision;

    @Column(name = "anio_comision")
    private int anioComision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_distribuidor")
    private DistribuidorTO distribuidor;

    public ComisionTO() {
    }

    public int getIdComision() {
        return idComision;
    }

    public void setIdComision(int idComision) {
        this.idComision = idComision;
    }

    public BigDecimal getMontoComision() {
        return montoComision;
    }

    public void setMontoComision(BigDecimal montoComision) {
        this.montoComision = montoComision;
    }

    public int getMesComision() {
        return mesComision;
    }

    public void setMesComision(int mesComision) {
        this.mesComision = mesComision;
    }

    public int getAnioComision() {
        return anioComision;
    }

    public void setAnioComision(int anioComision) {
        this.anioComision = anioComision;
    }

    public DistribuidorTO getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(DistribuidorTO distribuidor) {
        this.distribuidor = distribuidor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idComision;
        hash = 67 * hash + Objects.hashCode(this.montoComision);
        hash = 67 * hash + this.mesComision;
        hash = 67 * hash + this.anioComision;
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
        final ComisionTO other = (ComisionTO) obj;
        if (this.idComision != other.idComision) {
            return false;
        }
        if (this.mesComision != other.mesComision) {
            return false;
        }
        if (this.anioComision != other.anioComision) {
            return false;
        }
        if (!Objects.equals(this.montoComision, other.montoComision)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ComisionTO{" + "idComision=" + idComision + ", montoComision=" + montoComision + ", mesComision=" + mesComision + ", anioComision=" + anioComision + '}';
    }

}
