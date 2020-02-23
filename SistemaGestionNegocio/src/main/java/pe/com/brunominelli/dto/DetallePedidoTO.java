package pe.com.brunominelli.dto;

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

@Entity(name = "DetallePedido")
@Table(name = "TSA_DETALLE_PEDIDO")
public class DetallePedidoTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private int idDetallePedido;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_detalle_pedido")
    private BigDecimal precioDetallePedido;

    @Column(name = "puntos_detalle_pedido")
    private int puntosDetallePedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private ProductoTO producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private PedidoTO pedido;

    public DetallePedidoTO() {
    }

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioDetallePedido() {
        return precioDetallePedido;
    }

    public void setPrecioDetallePedido(BigDecimal precioDetallePedido) {
        this.precioDetallePedido = precioDetallePedido;
    }

    public int getPuntosDetallePedido() {
        return puntosDetallePedido;
    }

    public void setPuntosDetallePedido(int puntosDetallePedido) {
        this.puntosDetallePedido = puntosDetallePedido;
    }

    public ProductoTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoTO producto) {
        this.producto = producto;
    }

    public PedidoTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoTO pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idDetallePedido;
        hash = 97 * hash + this.cantidad;
        hash = 97 * hash + Objects.hashCode(this.precioDetallePedido);
        hash = 97 * hash + this.puntosDetallePedido;
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
        final DetallePedidoTO other = (DetallePedidoTO) obj;
        if (this.idDetallePedido != other.idDetallePedido) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.puntosDetallePedido != other.puntosDetallePedido) {
            return false;
        }
        if (!Objects.equals(this.precioDetallePedido, other.precioDetallePedido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetallePedidoTO{" + "idDetallePedido=" + idDetallePedido + ", cantidad=" + cantidad + ", precioDetallePedido=" + precioDetallePedido + ", puntosDetallePedido=" + puntosDetallePedido + '}';
    }

}
