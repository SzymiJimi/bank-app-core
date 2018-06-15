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
@Table(name = "investmentoffer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investmentoffer.findAll", query = "SELECT i FROM Investmentoffer i")
    , @NamedQuery(name = "Investmentoffer.findByIdInvestmentOffer", query = "SELECT i FROM Investmentoffer i WHERE i.idInvestmentOffer = :idInvestmentOffer")
    , @NamedQuery(name = "Investmentoffer.findByName", query = "SELECT i FROM Investmentoffer i WHERE i.name = :name")
    , @NamedQuery(name = "Investmentoffer.findByTimeOfInvestment", query = "SELECT i FROM Investmentoffer i WHERE i.timeOfInvestment = :timeOfInvestment")
    , @NamedQuery(name = "Investmentoffer.findByCapitalization", query = "SELECT i FROM Investmentoffer i WHERE i.capitalization = :capitalization")
    , @NamedQuery(name = "Investmentoffer.findByInterest", query = "SELECT i FROM Investmentoffer i WHERE i.interest = :interest")
    , @NamedQuery(name = "Investmentoffer.findByStateOfOffer", query = "SELECT i FROM Investmentoffer i WHERE i.stateOfOffer = :stateOfOffer")
    , @NamedQuery(name = "Investmentoffer.findByMinimumAmount", query = "SELECT i FROM Investmentoffer i WHERE i.minimumAmount = :minimumAmount")
    , @NamedQuery(name = "Investmentoffer.findByMaximumAmount", query = "SELECT i FROM Investmentoffer i WHERE i.maximumAmount = :maximumAmount")
    , @NamedQuery(name = "Investmentoffer.findByNumberOfInstalments", query = "SELECT i FROM Investmentoffer i WHERE i.numberOfInstalments = :numberOfInstalments")})
public class Investmentoffer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInvestmentOffer")
    private Integer idInvestmentOffer;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "timeOfInvestment")
    private String timeOfInvestment;
    @Size(max = 45)
    @Column(name = "capitalization")
    private String capitalization;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "interest")
    private BigDecimal interest;
    @Size(max = 45)
    @Column(name = "stateOfOffer")
    private String stateOfOffer;
    @Column(name = "minimumAmount")
    private BigDecimal minimumAmount;
    @Column(name = "maximumAmount")
    private BigDecimal maximumAmount;
    @Column(name = "numberOfInstalments")
    private Integer numberOfInstalments;
    @JoinColumn(name = "idManager", referencedColumnName = "idManager")
    @ManyToOne
    private Manager idManager;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInvestmentOffer")
    private transient List<Investment> investmentList;

    public Investmentoffer() {
    }

    public Investmentoffer(Integer idInvestmentOffer) {
        this.idInvestmentOffer = idInvestmentOffer;
    }

    public Integer getIdInvestmentOffer() {
        return idInvestmentOffer;
    }

    public void setIdInvestmentOffer(Integer idInvestmentOffer) {
        this.idInvestmentOffer = idInvestmentOffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeOfInvestment() {
        return timeOfInvestment;
    }

    public void setTimeOfInvestment(String timeOfInvestment) {
        this.timeOfInvestment = timeOfInvestment;
    }

    public String getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(String capitalization) {
        this.capitalization = capitalization;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public String getStateOfOffer() {
        return stateOfOffer;
    }

    public void setStateOfOffer(String stateOfOffer) {
        this.stateOfOffer = stateOfOffer;
    }

    public BigDecimal getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(BigDecimal minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public BigDecimal getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(BigDecimal maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Integer getNumberOfInstalments() {
        return numberOfInstalments;
    }

    public void setNumberOfInstalments(Integer numberOfInstalments) {
        this.numberOfInstalments = numberOfInstalments;
    }

    public Manager getIdManager() {
        return idManager;
    }

    public void setIdManager(Manager idManager) {
        this.idManager = idManager;
    }

    @XmlTransient
    public List<Investment> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(List<Investment> investmentList) {
        this.investmentList = investmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvestmentOffer != null ? idInvestmentOffer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investmentoffer)) {
            return false;
        }
        Investmentoffer other = (Investmentoffer) object;
        if ((this.idInvestmentOffer == null && other.idInvestmentOffer != null) || (this.idInvestmentOffer != null && !this.idInvestmentOffer.equals(other.idInvestmentOffer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Investmentoffer[ idInvestmentOffer=" + idInvestmentOffer + " ]";
    }
    
}
