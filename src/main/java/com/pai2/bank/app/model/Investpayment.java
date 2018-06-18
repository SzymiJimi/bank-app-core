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
@Table(name = "investpayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investpayment.findAll", query = "SELECT i FROM Investpayment i")
    , @NamedQuery(name = "Investpayment.findByIdInvestPayment", query = "SELECT i FROM Investpayment i WHERE i.idInvestPayment = :idInvestPayment")
    , @NamedQuery(name = "Investpayment.findByAmount", query = "SELECT i FROM Investpayment i WHERE i.amount = :amount")
    , @NamedQuery(name = "Investpayment.findByDate", query = "SELECT i FROM Investpayment i WHERE i.date = :date")})
public class Investpayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "idInvestPayment")
    private Integer idInvestPayment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Size(max = 20)
    @Column(name = "date")
    private String date;
    @OneToMany(mappedBy = "idInvestPayment")
    private transient List<Investtinstalmentpayment> investtinstalmentpaymentList;

    public Investpayment() {
    }

    public Investpayment(Integer idInvestPayment) {
        this.idInvestPayment = idInvestPayment;
    }

    public Integer getIdInvestPayment() {
        return idInvestPayment;
    }

    public void setIdInvestPayment(Integer idInvestPayment) {
        this.idInvestPayment = idInvestPayment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlTransient
    public List<Investtinstalmentpayment> getInvesttinstalmentpaymentList() {
        return investtinstalmentpaymentList;
    }

    public void setInvesttinstalmentpaymentList(List<Investtinstalmentpayment> investtinstalmentpaymentList) {
        this.investtinstalmentpaymentList = investtinstalmentpaymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvestPayment != null ? idInvestPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investpayment)) {
            return false;
        }
        Investpayment other = (Investpayment) object;
        if ((this.idInvestPayment == null && other.idInvestPayment != null) || (this.idInvestPayment != null && !this.idInvestPayment.equals(other.idInvestPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Investpayment[ idInvestPayment=" + idInvestPayment + " ]";
    }
    
}
