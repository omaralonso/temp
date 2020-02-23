package pe.com.brunominelli.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Carrito")
@Table(name = "TSA_CARRITO")
public class CarritoTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private int idCarrito;

    @Column(name = "precio_acumulado_carrito")
    private BigDecimal precioAcumuladoCarrito;

    @Column(name = "puntos_acumulado_carrito")
    private int puntosAcumuladoCarrito;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @OneToMany(mappedBy = "carrito", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DetalleCarritoTO> detalleCarritos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteTO cliente;

    public CarritoTO() {
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public BigDecimal getPrecioAcumuladoCarrito() {
        return precioAcumuladoCarrito;
    }

    public void setPrecioAcumuladoCarrito(BigDecimal precioAcumuladoCarrito) {
        this.precioAcumuladoCarrito = precioAcumuladoCarrito;
    }

    public int getPuntosAcumuladoCarrito() {
        return puntosAcumuladoCarrito;
    }

    public void setPuntosAcumuladoCarrito(int puntosAcumuladoCarrito) {
        this.puntosAcumuladoCarrito = puntosAcumuladoCarrito;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public List<DetalleCarritoTO> getDetalleCarritos() {
        return detalleCarritos;
    }

    public void setDetalleCarritos(List<DetalleCarritoTO> detalleCarritos) {
        this.detalleCarritos = detalleCarritos;
    }

    public ClienteTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteTO cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idCarrito;
        hash = 83 * hash + Objects.hashCode(this.precioAcumuladoCarrito);
        hash = 83 * hash + this.puntosAcumuladoCarrito;
        hash = 83 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 83 * hash + Objects.hashCode(this.fechaModificacion);
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
        final CarritoTO other = (CarritoTO) obj;
        if (this.idCarrito != other.idCarrito) {
            return false;
        }
        if (this.puntosAcumuladoCarrito != other.puntosAcumuladoCarrito) {
            return false;
        }
        if (!Objects.equals(this.precioAcumuladoCarrito, other.precioAcumuladoCarrito)) {
            return false;
        }
        if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) {
            return false;
        }
        if (!Objects.equals(this.fechaModificacion, other.fechaModificacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CarritoTO{" + "idCarrito=" + idCarrito + ", precioAcumuladoCarrito=" + precioAcumuladoCarrito + ", puntosAcumuladoCarrito=" + puntosAcumuladoCarrito + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + '}';
    }

}
