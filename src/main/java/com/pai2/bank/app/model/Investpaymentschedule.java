/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pai2.bank.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Odbiorca
 */
@Entity
@Table(name = "investpaymentschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investpaymentschedule.findAll", query = "SELECT i FROM Investpaymentschedule i")
        , @NamedQuery(name = "Investpaymentschedule.findByExpectedPayment", query = "SELECT i FROM Investpaymentschedule i WHERE i.expectedPayment = :expectedPayment")
    , @NamedQuery(name = "Investpaymentschedule.findByIdInvestPaymentSchedule", query = "SELECT i FROM Investpaymentschedule i WHERE i.idInvestPaymentSchedule = :idInvestPaymentSchedule")
    , @NamedQuery(name = "Investpaymentschedule.findByNumberOfPayment", query = "SELECT i FROM Investpaymentschedule i WHERE i.numberOfPayment = :numberOfPayment")
    , @NamedQuery(name = "Investpaymentschedule.findByActualPayment", query = "SELECT i FROM Investpaymentschedule i WHERE i.actualPayment = :actualPayment")
    , @NamedQuery(name = "Investpaymentschedule.findByExpectedPayment", query = "SELECT i FROM Investpaymentschedule i WHERE i.expectedPayment = :expectedPayment")})
public class Investpaymentschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "idInvestPaymentSchedule")
    private Integer idInvestPaymentSchedule;
    @Column(name = "numberOfPayment")
    private Integer numberOfPayment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "actualPayment")
    private BigDecimal actualPayment;
    @Size(max = 45)
    @Column(name = "expectedPayment")
    private String expectedPayment;
    @OneToMany(mappedBy = "idPaymentSchedule")
    private transient List<Investtinstalmentpayment> investtinstalmentpaymentList;
    @JoinColumn(name = "idInvestment", referencedColumnName = "idInvestment")
    @ManyToOne
    private Investment idInvestment;

    public Investpaymentschedule() {
    }

    public Investpaymentschedule(Integer idInvestPaymentSchedule) {
        this.idInvestPaymentSchedule = idInvestPaymentSchedule;
    }

    public Integer getIdInvestPaymentSchedule() {
        return idInvestPaymentSchedule;
    }

    public void setIdInvestPaymentSchedule(Integer idInvestPaymentSchedule) {
        this.idInvestPaymentSchedule = idInvestPaymentSchedule;
    }

    public Integer getNumberOfPayment() {
        return numberOfPayment;
    }

    public void setNumberOfPayment(Integer numberOfPayment) {
        this.numberOfPayment = numberOfPayment;
    }

    public BigDecimal getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(BigDecimal actualPayment) {
        this.actualPayment = actualPayment;
    }

    public String getExpectedPayment() {
        return expectedPayment;
    }

    public void setExpectedPayment(String expectedPayment) {
        this.expectedPayment = expectedPayment;
    }

    @XmlTransient
    public List<Investtinstalmentpayment> getInvesttinstalmentpaymentList() {
        return investtinstalmentpaymentList;
    }

    public void setInvesttinstalmentpaymentList(List<Investtinstalmentpayment> investtinstalmentpaymentList) {
        this.investtinstalmentpaymentList = investtinstalmentpaymentList;
    }

    public Investment getIdInvestment() {
        return idInvestment;
    }

    public void setIdInvestment(Investment idInvestment) {
        this.idInvestment = idInvestment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvestPaymentSchedule != null ? idInvestPaymentSchedule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investpaymentschedule)) {
            return false;
        }
        Investpaymentschedule other = (Investpaymentschedule) object;
        if ((this.idInvestPaymentSchedule == null && other.idInvestPaymentSchedule != null) || (this.idInvestPaymentSchedule != null && !this.idInvestPaymentSchedule.equals(other.idInvestPaymentSchedule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Investpaymentschedule[ idInvestPaymentSchedule=" + idInvestPaymentSchedule + " ]";
    }
    
}
