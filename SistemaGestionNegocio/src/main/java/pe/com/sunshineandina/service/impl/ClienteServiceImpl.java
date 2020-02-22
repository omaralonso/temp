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
import pe.com.sunshineandina.dao.DistribuidorDAO;
import pe.com.sunshineandina.dao.TipoLiderDAO;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.DistribuidorTO;
import pe.com.sunshineandina.dto.TipoLiderTO;
import pe.com.sunshineandina.service.ClienteService;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author FERNANDO
 */
@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    ClienteDAO clienteDao;
    
    @Autowired
    DistribuidorDAO distribuidorDao;
    
    @Autowired
    TipoLiderDAO liderDao;
    
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
    public void cambiarTipoCliente(ClienteTO cliente, String tipoCliente) {
        if(cliente != null){
            DistribuidorTO distribuidor=distribuidorDao.findByCliente(cliente.getIdCliente());
            if(tipoCliente.equals("NORMAL")&&distribuidor!=null)
            {
                distribuidor.setEstadoDistribuidor(Constantes.ESTADO_INACTIVO);
                distribuidorDao.save(distribuidor);               
            }   
            if(tipoCliente.equals("DISTRIBUIDOR")&&distribuidor==null)
            {
                //NO OLVIDAR EL FORMATO PARA EL CODIGO DE DISTRIBUIDOR
                DistribuidorTO distribuidorUpd=new DistribuidorTO();
                ClienteTO clienteUpd=clienteDao.findById(cliente.getIdCliente());
                TipoLiderTO lider=liderDao.findById(Constantes.TIPO_LIDER_DEFECTO);
                distribuidorUpd.setTipoLider(lider);
                distribuidorUpd.setCliente(clienteUpd);
                distribuidorUpd.setEstadoDistribuidor(Constantes.ESTADO_ACTIVO);
                distribuidorDao.save(distribuidorUpd);
            }
            else if(tipoCliente.equals("DISTRIBUIDOR")&&distribuidor!=null)
            {
                distribuidor.setEstadoDistribuidor(Constantes.ESTADO_ACTIVO);
                distribuidorDao.save(distribuidor);
            }
        }
    }

    @Override
    public ClienteTO findByDni(String dni) {
        return clienteDao.findByDni(dni);
    }

}
