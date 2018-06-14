/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pai2.bank.app.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Odbiorca
 */
@Entity
@Table(name = "income")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Income.findAll", query = "SELECT i FROM Income i")
    , @NamedQuery(name = "Income.findByIdIncome", query = "SELECT i FROM Income i WHERE i.idIncome = :idIncome")
    , @NamedQuery(name = "Income.findBySourceOfIncome", query = "SELECT i FROM Income i WHERE i.sourceOfIncome = :sourceOfIncome")
    , @NamedQuery(name = "Income.findByNetIncome", query = "SELECT i FROM Income i WHERE i.netIncome = :netIncome")
    , @NamedQuery(name = "Income.findByCurrencyOfIncome", query = "SELECT i FROM Income i WHERE i.currencyOfIncome = :currencyOfIncome")
    , @NamedQuery(name = "Income.findByNumberOfDependents", query = "SELECT i FROM Income i WHERE i.numberOfDependents = :numberOfDependents")
    , @NamedQuery(name = "Income.findByFormOfEmployment", query = "SELECT i FROM Income i WHERE i.formOfEmployment = :formOfEmployment")
    , @NamedQuery(name = "Income.findByLiabilitiesAndExpenses", query = "SELECT i FROM Income i WHERE i.liabilitiesAndExpenses = :liabilitiesAndExpenses")
    , @NamedQuery(name = "Income.findByMonthlyFees", query = "SELECT i FROM Income i WHERE i.monthlyFees = :monthlyFees")
    , @NamedQuery(name = "Income.findByMonthlyBenefits", query = "SELECT i FROM Income i WHERE i.monthlyBenefits = :monthlyBenefits")
    , @NamedQuery(name = "Income.findByMonthlyInstalmentsInOtherInstitutions", query = "SELECT i FROM Income i WHERE i.monthlyInstalmentsInOtherInstitutions = :monthlyInstalmentsInOtherInstitutions")})
public class Income implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIncome")
    private Integer idIncome;
    @Size(max = 45)
    @Column(name = "sourceOfIncome")
    private String sourceOfIncome;
    @Size(max = 45)
    @Column(name = "netIncome")
    private String netIncome;
    @Size(max = 45)
    @Column(name = "currencyOfIncome")
    private String currencyOfIncome;
    @Size(max = 45)
    @Column(name = "numberOfDependents")
    private String numberOfDependents;
    @Size(max = 45)
    @Column(name = "formOfEmployment")
    private String formOfEmployment;
    @Column(name = "liabilitiesAndExpenses")
    private Integer liabilitiesAndExpenses;
    @Size(max = 45)
    @Column(name = "monthlyFees")
    private String monthlyFees;
    @Size(max = 45)
    @Column(name = "monthlyBenefits")
    private String monthlyBenefits;
    @Size(max = 45)
    @Column(name = "monthlyInstalmentsInOtherInstitutions")
    private String monthlyInstalmentsInOtherInstitutions;
    @OneToMany(mappedBy = "idIncome")
    private transient List<Credit> creditList;

    public Income() {
    }

    public Income(Integer idIncome) {
        this.idIncome = idIncome;
    }

    public Integer getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(Integer idIncome) {
        this.idIncome = idIncome;
    }

    public String getSourceOfIncome() {
        return sourceOfIncome;
    }

    public void setSourceOfIncome(String sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }

    public String getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(String netIncome) {
        this.netIncome = netIncome;
    }

    public String getCurrencyOfIncome() {
        return currencyOfIncome;
    }

    public void setCurrencyOfIncome(String currencyOfIncome) {
        this.currencyOfIncome = currencyOfIncome;
    }

    public String getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(String numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public String getFormOfEmployment() {
        return formOfEmployment;
    }

    public void setFormOfEmployment(String formOfEmployment) {
        this.formOfEmployment = formOfEmployment;
    }

    public Integer getLiabilitiesAndExpenses() {
        return liabilitiesAndExpenses;
    }

    public void setLiabilitiesAndExpenses(Integer liabilitiesAndExpenses) {
        this.liabilitiesAndExpenses = liabilitiesAndExpenses;
    }

    public String getMonthlyFees() {
        return monthlyFees;
    }

    public void setMonthlyFees(String monthlyFees) {
        this.monthlyFees = monthlyFees;
    }

    public String getMonthlyBenefits() {
        return monthlyBenefits;
    }

    public void setMonthlyBenefits(String monthlyBenefits) {
        this.monthlyBenefits = monthlyBenefits;
    }

    public String getMonthlyInstalmentsInOtherInstitutions() {
        return monthlyInstalmentsInOtherInstitutions;
    }

    public void setMonthlyInstalmentsInOtherInstitutions(String monthlyInstalmentsInOtherInstitutions) {
        this.monthlyInstalmentsInOtherInstitutions = monthlyInstalmentsInOtherInstitutions;
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
        hash += (idIncome != null ? idIncome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Income)) {
            return false;
        }
        Income other = (Income) object;
        if ((this.idIncome == null && other.idIncome != null) || (this.idIncome != null && !this.idIncome.equals(other.idIncome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Income[ idIncome=" + idIncome + " ]";
    }
    
}
