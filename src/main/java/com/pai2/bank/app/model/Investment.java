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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "investment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Investment.findAll", query = "SELECT i FROM Investment i")
    , @NamedQuery(name = "Investment.findByIdInvestment", query = "SELECT i FROM Investment i WHERE i.idInvestment = :idInvestment")
    , @NamedQuery(name = "Investment.findByTarget", query = "SELECT i FROM Investment i WHERE i.target = :target")
    , @NamedQuery(name = "Investment.findByAmount", query = "SELECT i FROM Investment i WHERE i.amount = :amount")
    , @NamedQuery(name = "Investment.findByCreationDate", query = "SELECT i FROM Investment i WHERE i.creationDate = :creationDate")
    , @NamedQuery(name = "Investment.findByNumberOfInstalments", query = "SELECT i FROM Investment i WHERE i.numberOfInstalments = :numberOfInstalments")
    , @NamedQuery(name = "Investment.findByNumberOfInstalmentsRepaid", query = "SELECT i FROM Investment i WHERE i.numberOfInstalmentsRepaid = :numberOfInstalmentsRepaid")
    , @NamedQuery(name = "Investment.findByMonthlyInstalment", query = "SELECT i FROM Investment i WHERE i.monthlyInstalment = :monthlyInstalment")})
public class Investment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInvestment")
    private Integer idInvestment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "target")
    private BigDecimal target;
    @Column(name = "amount")
    private BigDecimal amount;
    @Size(max = 20)
    @Column(name = "creationDate")
    private String creationDate;
    @Column(name = "numberOfInstalments")
    private Integer numberOfInstalments;
    @Column(name = "numberOfInstalmentsRepaid")
    private Integer numberOfInstalmentsRepaid;
    @Size(max = 45)
    @Column(name = "monthlyInstalment")
    private String monthlyInstalment;
    @JoinTable(name = "clientsinvestment", joinColumns = {
        @JoinColumn(name = "idInvestment", referencedColumnName = "idInvestment")}, inverseJoinColumns = {
        @JoinColumn(name = "idClient", referencedColumnName = "idClient")})
    @ManyToMany
    private List<Client> clientList;
    @OneToMany(mappedBy = "idInvestment")
    private transient List<Investpaymentschedule> investpaymentscheduleList;
    @JoinColumn(name = "idConsultant", referencedColumnName = "idConsultant")
    @ManyToOne
    private Consultant idConsultant;
    @JoinColumn(name = "idInvestmentOffer", referencedColumnName = "idInvestmentOffer")
    @ManyToOne(optional = false)
    private transient Investmentoffer idInvestmentOffer;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInvestment")
//    private transient List<Investmentstory> investmentstoryList;

    public Investment() {
    }

    public Investment(Integer idInvestment) {
        this.idInvestment = idInvestment;
    }

    public Integer getIdInvestment() {
        return idInvestment;
    }

    public void setIdInvestment(Integer idInvestment) {
        this.idInvestment = idInvestment;
    }

    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getNumberOfInstalments() {
        return numberOfInstalments;
    }

    public void setNumberOfInstalments(Integer numberOfInstalments) {
        this.numberOfInstalments = numberOfInstalments;
    }

    public Integer getNumberOfInstalmentsRepaid() {
        return numberOfInstalmentsRepaid;
    }

    public void setNumberOfInstalmentsRepaid(Integer numberOfInstalmentsRepaid) {
        this.numberOfInstalmentsRepaid = numberOfInstalmentsRepaid;
    }

    public String getMonthlyInstalment() {
        return monthlyInstalment;
    }

    public void setMonthlyInstalment(String monthlyInstalment) {
        this.monthlyInstalment = monthlyInstalment;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @XmlTransient
    public List<Investpaymentschedule> getInvestpaymentscheduleList() {
        return investpaymentscheduleList;
    }

    public void setInvestpaymentscheduleList(List<Investpaymentschedule> investpaymentscheduleList) {
        this.investpaymentscheduleList = investpaymentscheduleList;
    }

    public Consultant getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant(Consultant idConsultant) {
        this.idConsultant = idConsultant;
    }

    public Investmentoffer getIdInvestmentOffer() {
        return idInvestmentOffer;
    }

    public void setIdInvestmentOffer(Investmentoffer idInvestmentOffer) {
        this.idInvestmentOffer = idInvestmentOffer;
    }

//    @XmlTransient
//    public List<Investmentstory> getInvestmentstoryList() {
//        return investmentstoryList;
//    }
//
//    public void setInvestmentstoryList(List<Investmentstory> investmentstoryList) {
//        this.investmentstoryList = investmentstoryList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvestment != null ? idInvestment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Investment)) {
            return false;
        }
        Investment other = (Investment) object;
        if ((this.idInvestment == null && other.idInvestment != null) || (this.idInvestment != null && !this.idInvestment.equals(other.idInvestment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Investment[ idInvestment=" + idInvestment + " ]";
    }
    
}
