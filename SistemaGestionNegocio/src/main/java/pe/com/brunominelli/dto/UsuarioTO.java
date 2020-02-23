package pe.com.brunominelli.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Usuario")
@Table(name = "TSA_USUARIO")
public class UsuarioTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "registro_usuario")
    private String registroUsuario;

    @Column(name = "pass_usuario")
    private String passUsuario;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "estado_usuario")
    private int estadoUsuario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TSA_USUARIO_PERFIL",
            joinColumns = {
                @JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_perfil")})
    private List<PerfilTO> perfiles = new ArrayList<>();

    public UsuarioTO() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRegistroUsuario() {
        return registroUsuario;
    }

    public void setRegistroUsuario(String registroUsuario) {
        this.registroUsuario = registroUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(int estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public List<PerfilTO> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<PerfilTO> perfiles) {
        this.perfiles = perfiles;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idUsuario;
        hash = 59 * hash + Objects.hashCode(this.registroUsuario);
        hash = 59 * hash + Objects.hashCode(this.passUsuario);
        hash = 59 * hash + Objects.hashCode(this.fechaRegistro);
        hash = 59 * hash + this.estadoUsuario;
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
        final UsuarioTO other = (UsuarioTO) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.estadoUsuario != other.estadoUsuario) {
            return false;
        }
        if (!Objects.equals(this.registroUsuario, other.registroUsuario)) {
            return false;
        }
        if (!Objects.equals(this.passUsuario, other.passUsuario)) {
            return false;
        }
        if (!Objects.equals(this.fechaRegistro, other.fechaRegistro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioTO{" + "idUsuario=" + idUsuario + ", registroUsuario=" + registroUsuario + ", passUsuario=" + passUsuario + ", fechaRegistro=" + fechaRegistro + ", estadoUsuario=" + estadoUsuario + '}';
    }

}
