/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
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
@Table(name = "RAMOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ramos.findAll", query = "SELECT r FROM Ramos r"),
    @NamedQuery(name = "Ramos.findById", query = "SELECT r FROM Ramos r WHERE r.id = :id"),
    @NamedQuery(name = "Ramos.findByNomRamo", query = "SELECT r FROM Ramos r WHERE r.nomRamo = :nomRamo")})
public class Ramos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOM_RAMO")
    private String nomRamo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ramos")
    private List<Polizas> polizasList;

    public Ramos() {
    }

    public Ramos(Short id) {
        this.id = id;
    }

    public Ramos(Short id, String nomRamo) {
        this.id = id;
        this.nomRamo = nomRamo;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNomRamo() {
        return nomRamo;
    }

    public void setNomRamo(String nomRamo) {
        this.nomRamo = nomRamo;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ramos)) {
            return false;
        }
        Ramos other = (Ramos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Ramos[ id=" + id + " ]";
    }
    
}
