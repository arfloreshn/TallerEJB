/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "ESTADO_POLIZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPoliza.findAll", query = "SELECT e FROM EstadoPoliza e"),
    @NamedQuery(name = "EstadoPoliza.findByIdEstado", query = "SELECT e FROM EstadoPoliza e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "EstadoPoliza.findByNomEstado", query = "SELECT e FROM EstadoPoliza e WHERE e.nomEstado = :nomEstado")})
public class EstadoPoliza implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTADO")
    private Integer idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOM_ESTADO")
    private String nomEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoPoliza")
    private List<Polizas> polizasList;

    public EstadoPoliza() {
    }

    public EstadoPoliza(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoPoliza(Integer idEstado, String nomEstado) {
        this.idEstado = idEstado;
        this.nomEstado = nomEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
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
