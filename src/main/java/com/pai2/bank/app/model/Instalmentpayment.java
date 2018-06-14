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
@Table(name = "instalmentpayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instalmentpayment.findAll", query = "SELECT i FROM Instalmentpayment i")
    , @NamedQuery(name = "Instalmentpayment.findByIdInstalmentPayment", query = "SELECT i FROM Instalmentpayment i WHERE i.idInstalmentPayment = :idInstalmentPayment")})
public class Instalmentpayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInstalmentPayment")
    private Integer idInstalmentPayment;
    @JoinColumn(name = "idPayment", referencedColumnName = "idPayment")
    @ManyToOne
    private Payment idPayment;
    @JoinColumn(name = "idRepaymentSchedule", referencedColumnName = "idRepaymentSchedule")
    @ManyToOne
    private Repaymentschedule idRepaymentSchedule;

    public Instalmentpayment() {
    }

    public Instalmentpayment(Integer idInstalmentPayment) {
        this.idInstalmentPayment = idInstalmentPayment;
    }

    public Integer getIdInstalmentPayment() {
        return idInstalmentPayment;
    }

    public void setIdInstalmentPayment(Integer idInstalmentPayment) {
        this.idInstalmentPayment = idInstalmentPayment;
    }

    public Payment getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Payment idPayment) {
        this.idPayment = idPayment;
    }

    public Repaymentschedule getIdRepaymentSchedule() {
        return idRepaymentSchedule;
    }

    public void setIdRepaymentSchedule(Repaymentschedule idRepaymentSchedule) {
        this.idRepaymentSchedule = idRepaymentSchedule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstalmentPayment != null ? idInstalmentPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instalmentpayment)) {
            return false;
        }
        Instalmentpayment other = (Instalmentpayment) object;
        if ((this.idInstalmentPayment == null && other.idInstalmentPayment != null) || (this.idInstalmentPayment != null && !this.idInstalmentPayment.equals(other.idInstalmentPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Instalmentpayment[ idInstalmentPayment=" + idInstalmentPayment + " ]";
    }
    
}
