package pe.com.brunominelli.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.brunominelli.dao.ClienteDAO;
import pe.com.brunominelli.dto.ClienteTO;
import pe.com.brunominelli.service.ClienteService;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    ClienteDAO clienteDao;
    
    @Override
    public List<ClienteTO> findAllClientes() {
        List<ClienteTO> listaClientes=clienteDao.findAllClientes();
        return listaClientes;
    }

    @Override
    public ClienteTO findById(int idCliente){
        ClienteTO cliente=clienteDao.findById(idCliente);
        return cliente;
    }

    @Override
    public ClienteTO findByDni(String dni) {
        return clienteDao.findByDni(dni);
    }

}
