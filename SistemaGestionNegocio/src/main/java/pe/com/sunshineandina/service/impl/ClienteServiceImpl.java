/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.ClienteDAO;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.service.ClienteService;

/**
 *
 * @author FERNANDO
 */
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
