package pe.com.brunominelli.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Politica")
@Table(name = "TSA_POLITICAS")
public class PoliticaTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_politica")
    private int idPolitica;

    @Column(name = "desc_politica")
    private String descPolitica;

    @Column(name = "min_puntos_ind")
    private int minPuntosIndividual;

    @Column(name = "max_puntos_ind")
    private int maxPuntosIndividual;

    @Column(name = "min_puntos_grupal")
    private int minPuntosGrupal;

    @Column(name = "max_puntos_grupal")
    private int maxPuntosGrupal;

    @Column(name = "porcentaje_descuento")
    private BigDecimal porcentajeDescuento;

    public PoliticaTO() {
    }

    public int getIdPolitica() {
        return idPolitica;
    }

    public void setIdPolitica(int idPolitica) {
        this.idPolitica = idPolitica;
    }

    public String getDescPolitica() {
        return descPolitica;
    }

    public void setDescPolitica(String descPolitica) {
        this.descPolitica = descPolitica;
    }

    public int getMinPuntosIndividual() {
        return minPuntosIndividual;
    }

    public void setMinPuntosIndividual(int minPuntosIndividual) {
        this.minPuntosIndividual = minPuntosIndividual;
    }

    public int getMaxPuntosIndividual() {
        return maxPuntosIndividual;
    }

    public void setMaxPuntosIndividual(int maxPuntosIndividual) {
        this.maxPuntosIndividual = maxPuntosIndividual;
    }

    public int getMinPuntosGrupal() {
        return minPuntosGrupal;
    }

    public void setMinPuntosGrupal(int minPuntosGrupal) {
        this.minPuntosGrupal = minPuntosGrupal;
    }

    public int getMaxPuntosGrupal() {
        return maxPuntosGrupal;
    }

    public void setMaxPuntosGrupal(int maxPuntosGrupal) {
        this.maxPuntosGrupal = maxPuntosGrupal;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idPolitica;
        hash = 59 * hash + Objects.hashCode(this.descPolitica);
        hash = 59 * hash + this.minPuntosIndividual;
        hash = 59 * hash + this.maxPuntosIndividual;
        hash = 59 * hash + this.minPuntosGrupal;
        hash = 59 * hash + this.maxPuntosGrupal;
        hash = 59 * hash + Objects.hashCode(this.porcentajeDescuento);
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
        final PoliticaTO other = (PoliticaTO) obj;
        if (this.idPolitica != other.idPolitica) {
            return false;
        }
        if (this.minPuntosIndividual != other.minPuntosIndividual) {
            return false;
        }
        if (this.maxPuntosIndividual != other.maxPuntosIndividual) {
            return false;
        }
        if (this.minPuntosGrupal != other.minPuntosGrupal) {
            return false;
        }
        if (this.maxPuntosGrupal != other.maxPuntosGrupal) {
            return false;
        }
        if (!Objects.equals(this.descPolitica, other.descPolitica)) {
            return false;
        }
        if (!Objects.equals(this.porcentajeDescuento, other.porcentajeDescuento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PoliticaTO{" + "idPolitica=" + idPolitica + ", descPolitica=" + descPolitica + ", minPuntosIndividual=" + minPuntosIndividual + ", maxPuntosIndividual=" + maxPuntosIndividual + ", minPuntosGrupal=" + minPuntosGrupal + ", maxPuntosGrupal=" + maxPuntosGrupal + ", porcentajeDescuento=" + porcentajeDescuento + '}';
    }

}
