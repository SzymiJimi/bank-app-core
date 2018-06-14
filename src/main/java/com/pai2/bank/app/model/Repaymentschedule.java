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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Odbiorca
 */
@Entity
@Table(name = "repaymentschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repaymentschedule.findAll", query = "SELECT r FROM Repaymentschedule r")
    , @NamedQuery(name = "Repaymentschedule.findByIdRepaymentSchedule", query = "SELECT r FROM Repaymentschedule r WHERE r.idRepaymentSchedule = :idRepaymentSchedule")
    , @NamedQuery(name = "Repaymentschedule.findByNumberOfInstalment", query = "SELECT r FROM Repaymentschedule r WHERE r.numberOfInstalment = :numberOfInstalment")
    , @NamedQuery(name = "Repaymentschedule.findByExpectedPayment", query = "SELECT r FROM Repaymentschedule r WHERE r.expectedPayment = :expectedPayment")
    , @NamedQuery(name = "Repaymentschedule.findByIdCredit", query = "SELECT r FROM Repaymentschedule r WHERE r.idCredit.idCredit = :idCredit")
    , @NamedQuery(name = "Repaymentschedule.findByActualRepayment", query = "SELECT r FROM Repaymentschedule r WHERE r.actualRepayment = :actualRepayment")})
public class Repaymentschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRepaymentSchedule")
    private Integer idRepaymentSchedule;
    @Column(name = "numberOfInstalment")
    private Integer numberOfInstalment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "expectedPayment")
    private BigDecimal expectedPayment;
    @Column(name = "actualRepayment")
    private BigDecimal actualRepayment;
    @OneToMany(mappedBy = "idRepaymentSchedule")
    private transient List<Instalmentpayment> instalmentpaymentList;
    @JoinColumn(name = "idCredit", referencedColumnName = "idCredit")
    @ManyToOne
    private Credit idCredit;

    public Repaymentschedule() {
    }

    public Repaymentschedule(Integer idRepaymentSchedule) {
        this.idRepaymentSchedule = idRepaymentSchedule;
    }

    public Integer getIdRepaymentSchedule() {
        return idRepaymentSchedule;
    }

    public void setIdRepaymentSchedule(Integer idRepaymentSchedule) {
        this.idRepaymentSchedule = idRepaymentSchedule;
    }

    public Integer getNumberOfInstalment() {
        return numberOfInstalment;
    }

    public void setNumberOfInstalment(Integer numberOfInstalment) {
        this.numberOfInstalment = numberOfInstalment;
    }

    public BigDecimal getExpectedPayment() {
        return expectedPayment;
    }

    public void setExpectedPayment(BigDecimal expectedPayment) {
        this.expectedPayment = expectedPayment;
    }

    public BigDecimal getActualRepayment() {
        return actualRepayment;
    }

    public void setActualRepayment(BigDecimal actualRepayment) {
        this.actualRepayment = actualRepayment;
    }

    @XmlTransient
    public List<Instalmentpayment> getInstalmentpaymentList() {
        return instalmentpaymentList;
    }

    public void setInstalmentpaymentList(List<Instalmentpayment> instalmentpaymentList) {
        this.instalmentpaymentList = instalmentpaymentList;
    }

    public Credit getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(Credit idCredit) {
        this.idCredit = idCredit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepaymentSchedule != null ? idRepaymentSchedule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repaymentschedule)) {
            return false;
        }
        Repaymentschedule other = (Repaymentschedule) object;
        if ((this.idRepaymentSchedule == null && other.idRepaymentSchedule != null) || (this.idRepaymentSchedule != null && !this.idRepaymentSchedule.equals(other.idRepaymentSchedule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Repaymentschedule[ idRepaymentSchedule=" + idRepaymentSchedule + " ]";
    }
    
}
