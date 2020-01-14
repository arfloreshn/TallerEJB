/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "estado_poliza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPoliza.findAll", query = "SELECT e FROM EstadoPoliza e")
    , @NamedQuery(name = "EstadoPoliza.findByIdEstado", query = "SELECT e FROM EstadoPoliza e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadoPoliza.findByNomEstado", query = "SELECT e FROM EstadoPoliza e WHERE e.nomEstado = :nomEstado")})
public class EstadoPoliza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Short idEstado;
    @Size(max = 2147483647)
    @Column(name = "nom_estado")
    private String nomEstado;
    
    @OneToMany(mappedBy = "Estado")
    private List<Polizas> polizasList;

    public EstadoPoliza() {
    }

    public EstadoPoliza(Short idEstado) {
        this.idEstado = idEstado;
    }

    public Short getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Short idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomEstado() {
        return nomEstado;
    }

    public void setNomEstado(String nomEstado) {
        this.nomEstado = nomEstado;
    }

    @XmlTransient
    public List<Polizas> getPolizasList() {
        return polizasList;
    }

    public void setPolizasList(List<Polizas> polizasList) {
        this.polizasList = polizasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPoliza)) {
            return false;
        }
        EstadoPoliza other = (EstadoPoliza) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.EstadoPoliza[ idEstado=" + idEstado + " ]";
    }
    
}
