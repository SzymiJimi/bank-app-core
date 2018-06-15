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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Odbiorca
 */
@Entity
@Table(name = "creditoffer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditoffer.findAll", query = "SELECT c FROM Creditoffer c")
    , @NamedQuery(name = "Creditoffer.findByIdCreditOffer", query = "SELECT c FROM Creditoffer c WHERE c.idCreditOffer = :idCreditOffer")
    , @NamedQuery(name = "Creditoffer.findByName", query = "SELECT c FROM Creditoffer c WHERE c.name = :name")
    , @NamedQuery(name = "Creditoffer.findByDurationOfCreditRepayment", query = "SELECT c FROM Creditoffer c WHERE c.durationOfCreditRepayment = :durationOfCreditRepayment")
    , @NamedQuery(name = "Creditoffer.findByAnnualPercentageRate", query = "SELECT c FROM Creditoffer c WHERE c.annualPercentageRate = :annualPercentageRate")
    , @NamedQuery(name = "Creditoffer.findByInterest", query = "SELECT c FROM Creditoffer c WHERE c.interest = :interest")
    , @NamedQuery(name = "Creditoffer.findByCommission", query = "SELECT c FROM Creditoffer c WHERE c.commission = :commission")
    , @NamedQuery(name = "Creditoffer.findByStateOfOffer", query = "SELECT c FROM Creditoffer c WHERE c.stateOfOffer = :stateOfOffer")})
public class Creditoffer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCreditOffer")
    private Integer idCreditOffer;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 20)
    @Column(name = "durationOfCreditRepayment")
    private String durationOfCreditRepayment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "annualPercentageRate")
    private BigDecimal annualPercentageRate;
    @Column(name = "interest")
    private BigDecimal interest;
    @Column(name = "commission")
    private BigDecimal commission;
    @Size(max = 45)
    @Column(name = "stateOfOffer")
    private String stateOfOffer;
    @JoinColumn(name = "idManager", referencedColumnName = "idManager")
    @ManyToOne
    private Manager idManager;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCreditOffer")
    private transient List<Credit> creditList;

    public Creditoffer() {
    }

    public Creditoffer(Integer idCreditOffer) {
        this.idCreditOffer = idCreditOffer;
    }

    public Integer getIdCreditOffer() {
        return idCreditOffer;
    }

    public void setIdCreditOffer(Integer idCreditOffer) {
        this.idCreditOffer = idCreditOffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDurationOfCreditRepayment() {
        return durationOfCreditRepayment;
    }

    public void setDurationOfCreditRepayment(String durationOfCreditRepayment) {
        this.durationOfCreditRepayment = durationOfCreditRepayment;
    }

    public BigDecimal getAnnualPercentageRate() {
        return annualPercentageRate;
    }

    public void setAnnualPercentageRate(BigDecimal annualPercentageRate) {
        this.annualPercentageRate = annualPercentageRate;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getStateOfOffer() {
        return stateOfOffer;
    }

    public void setStateOfOffer(String stateOfOffer) {
        this.stateOfOffer = stateOfOffer;
    }

    public Manager getIdManager() {
        return idManager;
    }

    public void setIdManager(Manager idManager) {
        this.idManager = idManager;
    }

    @XmlTransient
    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCreditOffer != null ? idCreditOffer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditoffer)) {
            return false;
        }
        Creditoffer other = (Creditoffer) object;
        if ((this.idCreditOffer == null && other.idCreditOffer != null) || (this.idCreditOffer != null && !this.idCreditOffer.equals(other.idCreditOffer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Creditoffer[ idCreditOffer=" + idCreditOffer + " ]";
    }
    
}
