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

@Entity(name = "Pedido")
@Table(name = "TSA_PEDIDO")
public class PedidoTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int idPedido;

    @Column(name = "estado_pedido")
    private String estadoPedido;

    @Column(name = "precio_acumulado_pedido")
    private BigDecimal precioAcumuladoPedido;

    @Column(name = "puntos_acumulado_pedido")
    private int puntosAcumuladoPedido;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DetallePedidoTO> detallePedidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteTO cliente;

    public PedidoTO() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public BigDecimal getPrecioAcumuladoPedido() {
        return precioAcumuladoPedido;
    }

    public void setPrecioAcumuladoPedido(BigDecimal precioAcumuladoPedido) {
        this.precioAcumuladoPedido = precioAcumuladoPedido;
    }

    public int getPuntosAcumuladoPedido() {
        return puntosAcumuladoPedido;
    }

    public void setPuntosAcumuladoPedido(int puntosAcumuladoPedido) {
        this.puntosAcumuladoPedido = puntosAcumuladoPedido;
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

    public List<DetallePedidoTO> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedidoTO> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public ClienteTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteTO cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idPedido;
        hash = 29 * hash + Objects.hashCode(this.estadoPedido);
        hash = 29 * hash + Objects.hashCode(this.precioAcumuladoPedido);
        hash = 29 * hash + this.puntosAcumuladoPedido;
        hash = 29 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 29 * hash + Objects.hashCode(this.fechaModificacion);
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
        final PedidoTO other = (PedidoTO) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.puntosAcumuladoPedido != other.puntosAcumuladoPedido) {
            return false;
        }
        if (!Objects.equals(this.estadoPedido, other.estadoPedido)) {
            return false;
        }
        if (!Objects.equals(this.precioAcumuladoPedido, other.precioAcumuladoPedido)) {
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
        return "PedidoTO{" + "idPedido=" + idPedido + ", estadoPedido=" + estadoPedido + ", precioAcumuladoPedido=" + precioAcumuladoPedido + ", puntosAcumuladoPedido=" + puntosAcumuladoPedido + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + '}';
    }

}
