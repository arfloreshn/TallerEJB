/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "ASEGURADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asegurado.findAll", query = "SELECT a FROM Asegurado a"),
    @NamedQuery(name = "Asegurado.findByIdAsegurado", query = "SELECT a FROM Asegurado a WHERE a.idAsegurado = :idAsegurado"),
    @NamedQuery(name = "Asegurado.findByNroDocumento", query = "SELECT a FROM Asegurado a WHERE a.nroDocumento = :nroDocumento"),
    @NamedQuery(name = "Asegurado.findByNombreCompleto", query = "SELECT a FROM Asegurado a WHERE a.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "Asegurado.findByFecNacimiento", query = "SELECT a FROM Asegurado a WHERE a.fecNacimiento = :fecNacimiento"),
    @NamedQuery(name = "Asegurado.findByFecAlta", query = "SELECT a FROM Asegurado a WHERE a.fecAlta = :fecAlta"),
    @NamedQuery(name = "Asegurado.findByFecBaja", query = "SELECT a FROM Asegurado a WHERE a.fecBaja = :fecBaja"),
    @NamedQuery(name = "Asegurado.findByTipoAsegurado", query = "SELECT a FROM Asegurado a WHERE a.tipoAsegurado = :tipoAsegurado"),
    @NamedQuery(name = "Asegurado.findByTipoDocumento", query = "SELECT a FROM Asegurado a WHERE a.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Asegurado.findByTipoSexo", query = "SELECT a FROM Asegurado a WHERE a.tipoSexo = :tipoSexo")})
public class Asegurado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_ASEGURADO")
    private Long idAsegurado;
    
    @NotNull
    @Column(name = "NRO_DOCUMENTO")
    private String nroDocumento;
    
    @NotNull
    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;
    
    @Column(name = "FEC_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNacimiento;
    
    @Column(name = "FEC_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAlta;
    
    @Column(name = "FEC_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecBaja;
 
    @Column(name = "TIPO_ASEGURADO")
    private Character tipoAsegurado;
    @Basic(optional = false)
    
    @Column(name = "TIPO_DOCUMENTO")
    private Character tipoDocumento;
    
    @Column(name = "TIPO_SEXO")
    private Character tipoSexo;
  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asegurado")
    private List<Polizas> polizasList;

    public Asegurado() {
    }

    public Asegurado(Long idAsegurado) {
        this.idAsegurado = idAsegurado;
    }

    public Asegurado(Long idAsegurado, String nroDocumento, String nombreCompleto, Character tipoAsegurado, Character tipoDocumento, Character tipoSexo) {
        this.idAsegurado = idAsegurado;
        this.nroDocumento = nroDocumento;
        this.nombreCompleto = nombreCompleto;
        this.tipoAsegurado = tipoAsegurado;
        this.tipoDocumento = tipoDocumento;
        this.tipoSexo = tipoSexo;
    }

    public Long getIdAsegurado() {
        return idAsegurado;
    }

    public void setIdAsegurado(Long idAsegurado) {
        this.idAsegurado = idAsegurado;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public Date getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Date fecAlta) {
        this.fecAlta = fecAlta;
    }

    public Date getFecBaja() {
        return fecBaja;
    }

    public void setFecBaja(Date fecBaja) {
        this.fecBaja = fecBaja;
    }

    public Character getTipoAsegurado() {
        return tipoAsegurado;
    }

    public void setTipoAsegurado(Character tipoAsegurado) {
        this.tipoAsegurado = tipoAsegurado;
    }

    public Character getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Character tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Character getTipoSexo() {
        return tipoSexo;
    }

    public void setTipoSexo(Character tipoSexo) {
        this.tipoSexo = tipoSexo;
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
        hash += (idAsegurado != null ? idAsegurado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asegurado)) {
            return false;
        }
        Asegurado other = (Asegurado) object;
        if ((this.idAsegurado == null && other.idAsegurado != null) || (this.idAsegurado != null && !this.idAsegurado.equals(other.idAsegurado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Asegurado[ idAsegurado=" + idAsegurado + " ]";
    }
    
}