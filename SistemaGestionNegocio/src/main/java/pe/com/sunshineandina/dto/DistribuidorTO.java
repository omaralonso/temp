/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dto;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author alonsorn
 */
@Entity(name = "Distribuidor")
@Table(name = "TSA_DISTRIBUIDOR")
public class DistribuidorTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distribuidor")
    private int idDistribuidor;

    @Column(name = "codigo_distribuidor")
    private String codigoDistribuidor;

    @Column(name = "estado_distribuidor")
    private int estadoDistribuidor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_lider")
    private TipoLiderTO tipoLider;

    @OneToMany(mappedBy = "distribuidor", fetch = FetchType.LAZY)
    private List<ComisionTO> comisiones;

    @OneToMany(mappedBy = "distribuidor", fetch = FetchType.LAZY)
    private List<HistoricoDistribuidorTO> historicos;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente")
    private ClienteTO cliente;

    @OneToMany(mappedBy = "padre", fetch = FetchType.LAZY)
    private List<DistribuidorTO> descendientes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_distribuidor_padre")
    private DistribuidorTO padre;

    public DistribuidorTO() {
    }

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getCodigoDistribuidor() {
        return codigoDistribuidor;
    }

    public void setCodigoDistribuidor(String codigoDistribuidor) {
        this.codigoDistribuidor = codigoDistribuidor;
    }

    public TipoLiderTO getTipoLider() {
        return tipoLider;
    }

    public void setTipoLider(TipoLiderTO tipoLider) {
        this.tipoLider = tipoLider;
    }

    public List<ComisionTO> getComisiones() {
        return comisiones;
    }

    public void setComisiones(List<ComisionTO> comisiones) {
        this.comisiones = comisiones;
    }

    public List<HistoricoDistribuidorTO> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoDistribuidorTO> historicos) {
        this.historicos = historicos;
    }

    public ClienteTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteTO cliente) {
        this.cliente = cliente;
    }

    public List<DistribuidorTO> getDescendientes() {
        return descendientes;
    }

    public void setDescendientes(List<DistribuidorTO> descendientes) {
        this.descendientes = descendientes;
    }

    public DistribuidorTO getPadre() {
        return padre;
    }

    public void setPadre(DistribuidorTO padre) {
        this.padre = padre;
    }

    public int getEstadoDistribuidor() {
        return estadoDistribuidor;
    }

    public void setEstadoDistribuidor(int estadoDistribuidor) {
        this.estadoDistribuidor= estadoDistribuidor;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.idDistribuidor;
        hash = 19 * hash + Objects.hashCode(this.codigoDistribuidor);
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
        final DistribuidorTO other = (DistribuidorTO) obj;
        if (this.idDistribuidor != other.idDistribuidor) {
            return false;
        }
        if (!Objects.equals(this.codigoDistribuidor, other.codigoDistribuidor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DistribuidorTO{" + "idDistribuidor=" + idDistribuidor + ", codigoDistribuidor=" + codigoDistribuidor + '}';
    }

}
