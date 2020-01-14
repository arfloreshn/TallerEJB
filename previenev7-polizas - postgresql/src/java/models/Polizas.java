/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "polizas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polizas.findAll", query = "SELECT p FROM Polizas p")
    , @NamedQuery(name = "Polizas.findByIdPoliza", query = "SELECT p FROM Polizas p WHERE p.idPoliza = :idPoliza")
    , @NamedQuery(name = "Polizas.findByFecVigDesde", query = "SELECT p FROM Polizas p WHERE p.fecVigDesde = :fecVigDesde")
    , @NamedQuery(name = "Polizas.findByFecVigHasta", query = "SELECT p FROM Polizas p WHERE p.fecVigHasta = :fecVigHasta")
    , @NamedQuery(name = "Polizas.findByValorPrima", query = "SELECT p FROM Polizas p WHERE p.valorPrima = :valorPrima")
    , @NamedQuery(name = "Polizas.findByNroCoutas", query = "SELECT p FROM Polizas p WHERE p.nroCoutas = :nroCoutas")
    , @NamedQuery(name = "Polizas.findBySnEnPagos", query = "SELECT p FROM Polizas p WHERE p.snEnPagos = :snEnPagos")})
public class Polizas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_poliza")
    private Short idPoliza;
    @Column(name = "fec_vig_desde")
    @Temporal(TemporalType.DATE)
    private Date fecVigDesde;
    @Column(name = "fec_vig_hasta")
    @Temporal(TemporalType.DATE)
    private Date fecVigHasta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_prima")
    private BigDecimal valorPrima;
    @Column(name = "nro_coutas")
    private Integer nroCoutas;
    @Column(name = "sn_en_pagos")
    private Character snEnPagos;
    
    @JoinColumn(name = "id_asegurado", referencedColumnName = "id_asegurado")
    @ManyToOne
    private Asegurado Asegurado;
    
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private EstadoPoliza Estado;
    
    @JoinColumn(name = "id_ramo", referencedColumnName = "id")
    @ManyToOne
    private Ramos Ramo;

    public Polizas() {
    }

    public Polizas(Short idPoliza) {
        this.idPoliza = idPoliza;
    }

    public Short getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Short idPoliza) {
        this.idPoliza = idPoliza;
    }

    public Date getFecVigDesde() {
        return fecVigDesde;
    }

    public void setFecVigDesde(Date fecVigDesde) {
        this.fecVigDesde = fecVigDesde;
    }

    public Date getFecVigHasta() {
        return fecVigHasta;
    }

    public void setFecVigHasta(Date fecVigHasta) {
        this.fecVigHasta = fecVigHasta;
    }

    public BigDecimal getValorPrima() {
        return valorPrima;
    }

    public void setValorPrima(BigDecimal valorPrima) {
        this.valorPrima = valorPrima;
    }

    public Integer getNroCoutas() {
        return nroCoutas;
    }

    public void setNroCoutas(Integer nroCoutas) {
        this.nroCoutas = nroCoutas;
    }

    public Character getSnEnPagos() {
        return snEnPagos;
    }

    public void setSnEnPagos(Character snEnPagos) {
        this.snEnPagos = snEnPagos;
    }

    public Asegurado getAsegurado() {
        return Asegurado;
    }

    public void setAsegurado(Asegurado Asegurado) {
        this.Asegurado = Asegurado;
    }

    public EstadoPoliza getEstado() {
        return Estado;
    }

    public void setEstado(EstadoPoliza Estado) {
        this.Estado = Estado;
    }

    public Ramos getRamo() {
        return Ramo;
    }

    public void setRamo(Ramos Ramo) {
        this.Ramo = Ramo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoliza != null ? idPoliza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polizas)) {
            return false;
        }
        Polizas other = (Polizas) object;
        if ((this.idPoliza == null && other.idPoliza != null) || (this.idPoliza != null && !this.idPoliza.equals(other.idPoliza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Polizas[ idPoliza=" + idPoliza + " ]";
    }
    
}
