package pe.com.brunominelli.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.brunominelli.dao.CarritoDAO;
import pe.com.brunominelli.dao.ClienteDAO;
import pe.com.brunominelli.dao.DetalleCarritoDAO;
import pe.com.brunominelli.dao.ProductoDAO;
import pe.com.brunominelli.dto.CarritoTO;
import pe.com.brunominelli.dto.ClienteTO;
import pe.com.brunominelli.dto.DetalleCarritoTO;
import pe.com.brunominelli.dto.ProductoTO;
import pe.com.brunominelli.service.CarritoService;
import pe.com.brunominelli.util.Constantes;

@Service("carritoService")
@Transactional
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoDAO carritoDao;

    @Autowired
    private ClienteDAO clienteDao;

    @Autowired
    private ProductoDAO productoDao;

    @Autowired
    private DetalleCarritoDAO detalleCarritoDao;

    @Override
    public String insertarDetalleAndCarrito(ClienteTO cliente, int idProducto, int cantidad) {
        /* Hallamos el producto */
        ProductoTO producto = productoDao.findById(idProducto);

        /* Creamos un carrito */
        CarritoTO carrito = new CarritoTO();
        carrito.setCliente(cliente);
        carrito.setFechaCreacion(new Date());
        carrito.setFechaModificacion(new Date());

        BigDecimal precioDetalle = producto.getPrecioProducto().multiply(new BigDecimal(cantidad));
        int puntosDetalle = producto.getPuntosProducto() * cantidad;

        carrito.setPrecioAcumuladoCarrito(precioDetalle);
        carrito.setPuntosAcumuladoCarrito(puntosDetalle);

        carritoDao.save(carrito);

        /* Creamos el detalle del carrito */
        carrito = carritoDao.findByCliente(cliente.getIdCliente());

        DetalleCarritoTO detalle = new DetalleCarritoTO();

        detalle.setCarrito(carrito);
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setPrecioDetalleCarrito(precioDetalle);
        detalle.setPuntosDetalleCarrito(puntosDetalle);

        detalleCarritoDao.save(detalle);

        return Constantes.PRODUCTO_CARRITO_EXITO;
    }

    @Override
    public String insertarDetalle(int idUsuario, int idProducto, int cantidad) {
        ClienteTO cliente = clienteDao.findByUsuario(idUsuario);
        if (cliente != null) {
            int idCliente = cliente.getIdCliente();
            /* Verificamos si ya existe un carrito */
            CarritoTO carrito = carritoDao.findByCliente(idCliente);
            if (carrito != null) {

                /* Verificamos si ya existe un detalle */
                DetalleCarritoTO detalle = detalleCarritoDao.findByProducto(idProducto);

                if (detalle != null) {
                    /* Hallamos el producto */
                    ProductoTO producto = productoDao.findById(idProducto);

                    /* Actualizamos el detalle */
                    BigDecimal precioSumarDetalle = producto.getPrecioProducto().multiply(new BigDecimal(cantidad));
                    int puntosSumarDetalle = producto.getPuntosProducto() * cantidad;

                    detalle.setPrecioDetalleCarrito(detalle.getPrecioDetalleCarrito().add(precioSumarDetalle));
                    detalle.setPuntosDetalleCarrito(detalle.getPuntosDetalleCarrito() + puntosSumarDetalle);
                    detalle.setCantidad(detalle.getCantidad() + cantidad);

                    detalleCarritoDao.save(detalle);

                    /* Actualizamos el carrito */
                    carrito.setPrecioAcumuladoCarrito(carrito.getPrecioAcumuladoCarrito().add(precioSumarDetalle));
                    carrito.setPuntosAcumuladoCarrito(carrito.getPuntosAcumuladoCarrito() + puntosSumarDetalle);
                    carrito.setFechaModificacion(new Date());

                    carritoDao.save(carrito);
                    return Constantes.PRODUCTO_CARRITO_EXITO;
                }
                /* Creamos uno nuevo si no existe */
                detalle = new DetalleCarritoTO();
                detalle.setCarrito(carrito);

                /* Hallamos el producto */
                ProductoTO producto = productoDao.findById(idProducto);

                BigDecimal precioDetalle = producto.getPrecioProducto().multiply(new BigDecimal(cantidad));
                int puntosDetalle = producto.getPuntosProducto() * cantidad;

                detalle.setCantidad(cantidad);
                detalle.setProducto(producto);
                detalle.setPrecioDetalleCarrito(precioDetalle);
                detalle.setPuntosDetalleCarrito(puntosDetalle);

                /* Guardamos el detalle*/
                detalleCarritoDao.save(detalle);

                /* Actualizamos el carrito */
                carrito.setFechaModificacion(new Date());
                carrito.setPrecioAcumuladoCarrito(carrito.getPrecioAcumuladoCarrito().add(precioDetalle));
                carrito.setPuntosAcumuladoCarrito(carrito.getPuntosAcumuladoCarrito() + puntosDetalle);

                /* Guardamos el carrito */
                carritoDao.save(carrito);
                return Constantes.PRODUCTO_CARRITO_EXITO;
            }
            return insertarDetalleAndCarrito(cliente, idProducto, cantidad);
        }
        return Constantes.ERROR_NO_SE_ENCONTRO_CLIENTE;
    }

    @Override
    public CarritoTO findByUsuario(int idUsuario) {
        ClienteTO cliente = clienteDao.findByUsuario(idUsuario);
        CarritoTO carrito = carritoDao.findByCliente(cliente.getIdCliente());

        if (carrito != null) {
            Hibernate.initialize(carrito.getCliente());
            Hibernate.initialize(carrito.getDetalleCarritos());

            for (DetalleCarritoTO detalle : carrito.getDetalleCarritos()) {
                Hibernate.initialize(detalle.getProducto());
            }

        }

        return carrito;

    }

}
