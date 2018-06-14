/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pai2.bank.app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Odbiorca
 */
@Entity
@Table(name = "investtinstalmentpayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investtinstalmentpayment.findAll", query = "SELECT i FROM Investtinstalmentpayment i")
    , @NamedQuery(name = "Investtinstalmentpayment.findByIdInvestInstalmentPayment", query = "SELECT i FROM Investtinstalmentpayment i WHERE i.idInvestInstalmentPayment = :idInvestInstalmentPayment")})
public class Investtinstalmentpayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInvestInstalmentPayment")
    private Integer idInvestInstalmentPayment;
    @JoinColumn(name = "idInvestPayment", referencedColumnName = "idInvestPayment")
    @ManyToOne
    private Investpayment idInvestPayment;
    @JoinColumn(name = "idPaymentSchedule", referencedColumnName = "idInvestPaymentSchedule")
    @ManyToOne
    private Investpaymentschedule idPaymentSchedule;

    public Investtinstalmentpayment() {
    }

    public Investtinstalmentpayment(Integer idInvestInstalmentPayment) {
        this.idInvestInstalmentPayment = idInvestInstalmentPayment;
    }

    public Integer getIdInvestInstalmentPayment() {
        return idInvestInstalmentPayment;
    }

    public void setIdInvestInstalmentPayment(Integer idInvestInstalmentPayment) {
        this.idInvestInstalmentPayment = idInvestInstalmentPayment;
    }

    public Investpayment getIdInvestPayment() {
        return idInvestPayment;
    }

    public void setIdInvestPayment(Investpayment idInvestPayment) {
        this.idInvestPayment = idInvestPayment;
    }

    public Investpaymentschedule getIdPaymentSchedule() {
        return idPaymentSchedule;
    }

    public void setIdPaymentSchedule(Investpaymentschedule idPaymentSchedule) {
        this.idPaymentSchedule = idPaymentSchedule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvestInstalmentPayment != null ? idInvestInstalmentPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investtinstalmentpayment)) {
            return false;
        }
        Investtinstalmentpayment other = (Investtinstalmentpayment) object;
        if ((this.idInvestInstalmentPayment == null && other.idInvestInstalmentPayment != null) || (this.idInvestInstalmentPayment != null && !this.idInvestInstalmentPayment.equals(other.idInvestInstalmentPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Investtinstalmentpayment[ idInvestInstalmentPayment=" + idInvestInstalmentPayment + " ]";
    }
    
}
