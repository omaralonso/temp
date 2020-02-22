/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alonsorn
 */
@Entity(name = "Parametro")
@Table(name = "TSA_PARAMETROS")
public class ParametroTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro")
    private int idParametro;

    @Column(name = "desc_parametro")
    private String descParametro;

    @Column(name = "valor_parametro")
    private String valorParametro;

    @Column(name = "estado_parametro")
    private int estadoParametro;

    public ParametroTO() {
    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public String getDescParametro() {
        return descParametro;
    }

    public void setDescParametro(String descParametro) {
        this.descParametro = descParametro;
    }

    public String getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(String valorParametro) {
        this.valorParametro = valorParametro;
    }

    public int getEstadoParametro() {
        return estadoParametro;
    }

    public void setEstadoParametro(int estadoParametro) {
        this.estadoParametro = estadoParametro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idParametro;
        hash = 29 * hash + Objects.hashCode(this.descParametro);
        hash = 29 * hash + Objects.hashCode(this.valorParametro);
        hash = 29 * hash + this.estadoParametro;
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
        final ParametroTO other = (ParametroTO) obj;
        if (this.idParametro != other.idParametro) {
            return false;
        }
        if (this.estadoParametro != other.estadoParametro) {
            return false;
        }
        if (!Objects.equals(this.descParametro, other.descParametro)) {
            return false;
        }
        if (!Objects.equals(this.valorParametro, other.valorParametro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ParametroTO{" + "idParametro=" + idParametro + ", descParametro=" + descParametro + ", valorParametro=" + valorParametro + ", estadoParametro=" + estadoParametro + '}';
    }

}
