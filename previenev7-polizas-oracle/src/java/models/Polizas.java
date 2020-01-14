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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "POLIZAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polizas.findAll", query = "SELECT p FROM Polizas p"),
    @NamedQuery(name = "Polizas.findByIdPoliza", query = "SELECT p FROM Polizas p WHERE p.idPoliza = :idPoliza"),
    @NamedQuery(name = "Polizas.findByFecVigDesde", query = "SELECT p FROM Polizas p WHERE p.fecVigDesde = :fecVigDesde"),
    @NamedQuery(name = "Polizas.findByFecVigHasta", query = "SELECT p FROM Polizas p WHERE p.fecVigHasta = :fecVigHasta"),
    @NamedQuery(name = "Polizas.findByValorPrima", query = "SELECT p FROM Polizas p WHERE p.valorPrima = :valorPrima"),
    @NamedQuery(name = "Polizas.findByNroCoutas", query = "SELECT p FROM Polizas p WHERE p.nroCoutas = :nroCoutas"),
    @NamedQuery(name = "Polizas.findBySnEnPagos", query = "SELECT p FROM Polizas p WHERE p.snEnPagos = :snEnPagos")})
public class Polizas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_POLIZA")
    private Long idPoliza;

    @Column(name = "FEC_VIG_DESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVigDesde;

    @Column(name = "FEC_VIG_HASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVigHasta;

    @Column(name = "VALOR_PRIMA")
    private BigDecimal valorPrima;

    @Column(name = "NRO_COUTAS")
    private Integer nroCoutas;

    @Column(name = "SN_EN_PAGOS")
    private Character snEnPagos;
    
    @JoinColumn(name = "ID_ASEGURADO", referencedColumnName = "ID_ASEGURADO")
    @ManyToOne(optional = false)
    private Asegurado asegurado;
    
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private EstadoPoliza estadoPoliza;
  
    @JoinColumn(name = "ID_RAMO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ramos ramos;

    public Polizas() {
    }

    public Polizas(Long idPoliza) {
        this.idPoliza = idPoliza;
    }

    public Polizas(Long idPoliza, Date fecVigDesde, Date fecVigHasta, BigDecimal valorPrima, Integer nroCoutas, Character snEnPagos) {
        this.idPoliza = idPoliza;
        this.fecVigDesde = fecVigDesde;
        this.fecVigHasta = fecVigHasta;
        this.valorPrima = valorPrima;
        this.nroCoutas = nroCoutas;
        this.snEnPagos = snEnPagos;
    }

    public Long getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Long idPoliza) {
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
        return asegurado;
    }

    public void setAsegurado(Asegurado asegurado) {
        this.asegurado = asegurado;
    }

    public EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public Ramos getRamos() {
        return ramos;
    }

    public void setRamos(Ramos ramos) {
        this.ramos = ramos;
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
