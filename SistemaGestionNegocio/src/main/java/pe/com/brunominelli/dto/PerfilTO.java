package pe.com.brunominelli.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Perfil")
@Table(name = "TSA_PERFIL")
public class PerfilTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private int idPerfil;

    @Column(name = "codigo_perfil")
    private String codigoPerfil;

    @Column(name = "desc_perfil")
    private String descPerfil;

    @ManyToMany(mappedBy = "perfiles")
    private List<UsuarioTO> usuarios;

    public PerfilTO() {
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public String getDescPerfil() {
        return descPerfil;
    }

    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }

    public List<UsuarioTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioTO> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idPerfil;
        hash = 67 * hash + Objects.hashCode(this.codigoPerfil);
        hash = 67 * hash + Objects.hashCode(this.descPerfil);
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
        final PerfilTO other = (PerfilTO) obj;
        if (this.idPerfil != other.idPerfil) {
            return false;
        }
        if (!Objects.equals(this.codigoPerfil, other.codigoPerfil)) {
            return false;
        }
        if (!Objects.equals(this.descPerfil, other.descPerfil)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PerfilTO{" + "idPerfil=" + idPerfil + ", codigoPerfil=" + codigoPerfil + ", descPerfil=" + descPerfil + '}';
    }

}
