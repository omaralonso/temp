/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alonsorn
 */
@Entity(name = "TipoLider")
@Table(name = "TSA_TIPO_LIDER")
public class TipoLiderTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_lider")
    private int idTipoLider;

    @Column(name = "desc_tipo_lider")
    private String descTipoLider;

    @Column(name = "lideres_min")
    private int lideresMin;

    @Column(name = "lideres_max")
    private int lideresMax;

    @Column(name = "porcentaje")
    private BigDecimal porcentaje;

    @OneToMany(mappedBy = "tipoLider", fetch = FetchType.LAZY)
    private List<DistribuidorTO> distribuidores;

    public TipoLiderTO() {
    }

    public int getIdTipoLider() {
        return idTipoLider;
    }

    public void setIdTipoLider(int idTipoLider) {
        this.idTipoLider = idTipoLider;
    }

    public String getDescTipoLider() {
        return descTipoLider;
    }

    public void setDescTipoLider(String descTipoLider) {
        this.descTipoLider = descTipoLider;
    }

    public int getLideresMin() {
        return lideresMin;
    }

    public void setLideresMin(int lideresMin) {
        this.lideresMin = lideresMin;
    }

    public int getLideresMax() {
        return lideresMax;
    }

    public void setLideresMax(int lideresMax) {
        this.lideresMax = lideresMax;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public List<DistribuidorTO> getDistribuidores() {
        return distribuidores;
    }

    public void setDistribuidores(List<DistribuidorTO> distribuidores) {
        this.distribuidores = distribuidores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.idTipoLider;
        hash = 43 * hash + Objects.hashCode(this.descTipoLider);
        hash = 43 * hash + this.lideresMin;
        hash = 43 * hash + this.lideresMax;
        hash = 43 * hash + Objects.hashCode(this.porcentaje);
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
        final TipoLiderTO other = (TipoLiderTO) obj;
        if (this.idTipoLider != other.idTipoLider) {
            return false;
        }
        if (this.lideresMin != other.lideresMin) {
            return false;
        }
        if (this.lideresMax != other.lideresMax) {
            return false;
        }
        if (!Objects.equals(this.descTipoLider, other.descTipoLider)) {
            return false;
        }
        if (!Objects.equals(this.porcentaje, other.porcentaje)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoLiderTO{" + "idTipoLider=" + idTipoLider + ", descTipoLider=" + descTipoLider + ", lideresMin=" + lideresMin + ", lideresMax=" + lideresMax + ", porcentaje=" + porcentaje + '}';
    }

}
