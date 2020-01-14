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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "asegurado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asegurado.findAll", query = "SELECT a FROM Asegurado a")
    , @NamedQuery(name = "Asegurado.findByIdAsegurado", query = "SELECT a FROM Asegurado a WHERE a.idAsegurado = :idAsegurado")
    , @NamedQuery(name = "Asegurado.findByNroDocumento", query = "SELECT a FROM Asegurado a WHERE a.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "Asegurado.findByNombreCompleto", query = "SELECT a FROM Asegurado a WHERE a.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Asegurado.findByFecNacimiento", query = "SELECT a FROM Asegurado a WHERE a.fecNacimiento = :fecNacimiento")
    , @NamedQuery(name = "Asegurado.findByFecAlta", query = "SELECT a FROM Asegurado a WHERE a.fecAlta = :fecAlta")
    , @NamedQuery(name = "Asegurado.findByFecBaja", query = "SELECT a FROM Asegurado a WHERE a.fecBaja = :fecBaja")
    , @NamedQuery(name = "Asegurado.findBySexo", query = "SELECT a FROM Asegurado a WHERE a.tipo_sexo = :tipo_sexo")
    , @NamedQuery(name = "Asegurado.findByTipoAsegurado", query = "SELECT a FROM Asegurado a WHERE a.tipo_asegurado = :tipo_asegurado")
    , @NamedQuery(name = "Asegurado.findByTipoDocumento", query = "SELECT a FROM Asegurado a WHERE a.tipo_documento = :tipo_documento")})
public class Asegurado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asegurado")
    private Short idAsegurado;
    @Size(max = 50)
    @Column(name = "nro_documento")
    private String nroDocumento;
    @Size(max = 2147483647)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "fec_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fecNacimiento;
    @Column(name = "fec_alta")
    @Temporal(TemporalType.DATE)
    private Date fecAlta;
    @Column(name = "fec_baja")
    @Temporal(TemporalType.DATE)
    private Date fecBaja;

    
    private char tipo_sexo;

    private char tipo_asegurado;

    private char tipo_documento;

    @OneToMany(mappedBy = "Asegurado")
    private List<Polizas> polizasList;

    public Asegurado() {
    }

    public Asegurado(Short idAsegurado) {
        this.idAsegurado = idAsegurado;
    }

    public Short getIdAsegurado() {
        return idAsegurado;
    }

    public void setIdAsegurado(Short idAsegurado) {
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

    public char getTipo_sexo() {
        return tipo_sexo;
    }

    public void setTipo_sexo(char tipo_sexo) {
        this.tipo_sexo = tipo_sexo;
    }

    public char getTipo_asegurado() {
        return tipo_asegurado;
    }

    public void setTipo_asegurado(char tipo_asegurado) {
        this.tipo_asegurado = tipo_asegurado;
    }

    public char getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(char tipo_documento) {
        this.tipo_documento = tipo_documento;
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
