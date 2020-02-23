package pe.com.brunominelli.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Oferta")
@Table(name = "TSA_OFERTA")
public class OfertaTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta")
    private int idOferta;

    @Column(name = "porcentaje_oferta")
    private BigDecimal porcentajeOferta;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin")
    private Date fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaTO categoria;

    public OfertaTO() {
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public BigDecimal getPorcentajeOferta() {
        return porcentajeOferta;
    }

    public void setPorcentajeOferta(BigDecimal porcentajeOferta) {
        this.porcentajeOferta = porcentajeOferta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public CategoriaTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTO categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idOferta;
        hash = 97 * hash + Objects.hashCode(this.porcentajeOferta);
        hash = 97 * hash + Objects.hashCode(this.fechaInicio);
        hash = 97 * hash + Objects.hashCode(this.fechaFin);
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
        final OfertaTO other = (OfertaTO) obj;
        if (this.idOferta != other.idOferta) {
            return false;
        }
        if (!Objects.equals(this.porcentajeOferta, other.porcentajeOferta)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OfertaTO{" + "idOferta=" + idOferta + ", porcentajeOferta=" + porcentajeOferta + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

}
