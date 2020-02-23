package pe.com.brunominelli.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.brunominelli.dao.CategoriaDAO;
import pe.com.brunominelli.dao.ProductoDAO;
import pe.com.brunominelli.dto.CategoriaTO;
import pe.com.brunominelli.dto.ProductoTO;
import pe.com.brunominelli.service.CategoriaService;
import pe.com.brunominelli.util.Constantes;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaDAO categoriaDao;

    @Autowired
    ProductoDAO productoDao;

    @Override
    public List<CategoriaTO> findAllCategorias() {
        List<CategoriaTO> listaCategorias = categoriaDao.findAll();
        return listaCategorias;
    }

    @Override
    public CategoriaTO findCategoriaById(int id) {
        return categoriaDao.findById(id);
    }

    @Override
    public boolean nombreRepetido(String nombre) {
        CategoriaTO categoria=categoriaDao.findByNombre(nombre);
        if(categoria==null)
        {
            return false;
        }          
        return true;
    }
    
    @Override
    public boolean idRepetido(int id,String nombre) {
        CategoriaTO categoria=categoriaDao.findByIdAndNombre(id,nombre);
        if(categoria==null)
        {
            return false;
        }          
        return true;
    }
    
    @Override
    public void addCategoria(CategoriaTO categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void updateCategoria(CategoriaTO categoria) {
        if (categoria != null) {
            CategoriaTO categoriaUpd = categoriaDao.findById(categoria.getIdCategoria());
            categoriaUpd.setNombreCategoria(categoria.getNombreCategoria());
            categoriaUpd.setDescCategoria(categoria.getDescCategoria());
            categoriaDao.save(categoriaUpd);
        }
    }

    @Override
    public CategoriaTO findCategoriaByNombre(String nombre) {
        return categoriaDao.findByNombreCategoria(nombre);
    }

    @Override
    public void changeCategoriasState(CategoriaTO categoria) {
        if (categoria != null) {
            CategoriaTO categoriaUpd = categoriaDao.findById(categoria.getIdCategoria());
            List<ProductoTO> listaProductos = productoDao.findByCategoria(categoria.getIdCategoria());
            System.out.println(listaProductos.size());
            if (categoria.getEstadoCategoria() == Constantes.ESTADO_ACTIVO) {
                for (ProductoTO producto : listaProductos) {
                    producto.setEstadoProducto(Constantes.ESTADO_INACTIVO);
                    productoDao.save(producto);
                }
                categoriaUpd.setEstadoCategoria(Constantes.ESTADO_INACTIVO);
            } else if (categoria.getEstadoCategoria() == Constantes.ESTADO_INACTIVO) {
                categoriaUpd.setEstadoCategoria(Constantes.ESTADO_ACTIVO);
            }
            categoriaDao.save(categoriaUpd);
        }
    }

}
