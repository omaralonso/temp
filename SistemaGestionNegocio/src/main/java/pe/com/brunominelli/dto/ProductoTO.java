package pe.com.brunominelli.dto;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Producto")
@Table(name = "TSA_PRODUCTO")
public class ProductoTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "precio_producto")
    private BigDecimal precioProducto;

    @Column(name = "puntos_producto")
    private int puntosProducto;

    @Column(name = "stock_producto")
    private int stockProducto;

    @Column(name = "imagen_producto")
    private String imagenProducto;

    @Column(name = "estado_producto")
    private int estadoProducto;
    
    @Column(name = "descripcion_producto")
    private String descripcionProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaTO categoria;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetallePedidoTO> detallePedidos;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleCarritoTO> detalleCarritos;

    public ProductoTO() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getPuntosProducto() {
        return puntosProducto;
    }

    public void setPuntosProducto(int puntosProducto) {
        this.puntosProducto = puntosProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public int getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(int estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
    
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public CategoriaTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTO categoria) {
        this.categoria = categoria;
    }

    public List<DetallePedidoTO> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedidoTO> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }

    public List<DetalleCarritoTO> getDetalleCarritos() {
        return detalleCarritos;
    }

    public void setDetalleCarritos(List<DetalleCarritoTO> detalleCarritos) {
        this.detalleCarritos = detalleCarritos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idProducto;
        hash = 97 * hash + Objects.hashCode(this.nombreProducto);
        hash = 97 * hash + Objects.hashCode(this.precioProducto);
        hash = 97 * hash + this.puntosProducto;
        hash = 97 * hash + this.stockProducto;
        hash = 97 * hash + this.estadoProducto;
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
        final ProductoTO other = (ProductoTO) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.puntosProducto != other.puntosProducto) {
            return false;
        }
        if (this.stockProducto != other.stockProducto) {
            return false;
        }
        if (this.estadoProducto != other.estadoProducto) {
            return false;
        }
        if (!Objects.equals(this.nombreProducto, other.nombreProducto)) {
            return false;
        }
        if (!Objects.equals(this.precioProducto, other.precioProducto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductoTO{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", puntosProducto=" + puntosProducto + ", stockProducto=" + stockProducto + ", estadoProducto=" + estadoProducto + ", descripcionProducto=" + descripcionProducto + '}';
    }

}
