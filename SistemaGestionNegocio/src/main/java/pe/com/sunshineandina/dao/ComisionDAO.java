/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.List;
import pe.com.sunshineandina.dto.ComisionTO;

/**
 *
 * @author alonsorn
 */
public interface ComisionDAO {

    ComisionTO findById(int id);

    void save(ComisionTO comision);

    List<ComisionTO> findByParameters(int idDistribuidor, int mes, int anio);

    ComisionTO findUnique(int idDistribuidor, int mes, int anio);
}
