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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "credit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credit.findAll", query = "SELECT c FROM Credit c")
    , @NamedQuery(name = "Credit.findByIdCredit", query = "SELECT c FROM Credit c WHERE c.idCredit = :idCredit")
    , @NamedQuery(name = "Credit.findByAmount", query = "SELECT c FROM Credit c WHERE c.amount = :amount")
    , @NamedQuery(name = "Credit.findByMonthlyInstalment", query = "SELECT c FROM Credit c WHERE c.monthlyInstalment = :monthlyInstalment")
    , @NamedQuery(name = "Credit.findByAnnualPercentageRate", query = "SELECT c FROM Credit c WHERE c.annualPercentageRate = :annualPercentageRate")
    , @NamedQuery(name = "Credit.findByDayForPayInstalments", query = "SELECT c FROM Credit c WHERE c.dayForPayInstalments = :dayForPayInstalments")
    , @NamedQuery(name = "Credit.findByNumberOfInstalments", query = "SELECT c FROM Credit c WHERE c.numberOfInstalments = :numberOfInstalments")
    , @NamedQuery(name = "Credit.findByNumberOfInstallmentsRepaid", query = "SELECT c FROM Credit c WHERE c.numberOfInstallmentsRepaid = :numberOfInstallmentsRepaid")
    , @NamedQuery(name = "Credit.findByCreationDate", query = "SELECT c FROM Credit c WHERE c.creationDate = :creationDate")
    , @NamedQuery(name = "Credit.findByDateOfNextInstalment", query = "SELECT c FROM Credit c WHERE c.dateOfNextInstalment = :dateOfNextInstalment")})
public class Credit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCredit")
    private Integer idCredit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "monthlyInstalment")
    private BigDecimal monthlyInstalment;
    @Column(name = "annualPercentageRate")
    private BigDecimal annualPercentageRate;
    @Column(name = "dayForPayInstalments")
    private Integer dayForPayInstalments;
    @Column(name = "numberOfInstalments")
    private Integer numberOfInstalments;
    @Column(name = "numberOfInstallmentsRepaid")
    private Integer numberOfInstallmentsRepaid;
    @Size(max = 20)
    @Column(name = "creationDate")
    private String creationDate;
    @Size(max = 20)
    @Column(name = "dateOfNextInstalment")
    private String dateOfNextInstalment;
    @ManyToMany(mappedBy = "creditList")
    private List<Client> clientList;
    @JoinColumn(name = "idConsultant", referencedColumnName = "idConsultant")
    @ManyToOne
    private Consultant idConsultant;
    @JoinColumn(name = "idCreditOffer", referencedColumnName = "idCreditOffer")
    @ManyToOne(optional = false)
    private Creditoffer idCreditOffer;
    @JoinColumn(name = "idIncome", referencedColumnName = "idIncome")
    @ManyToOne
    private Income idIncome;
    @OneToMany(mappedBy = "idCredit")
    private transient List<Repaymentschedule> repaymentscheduleList;

    public Credit() {
    }

    public Credit(Integer idCredit) {
        this.idCredit = idCredit;
    }

    public Integer getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(Integer idCredit) {
        this.idCredit = idCredit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getMonthlyInstalment() {
        return monthlyInstalment;
    }

    public void setMonthlyInstalment(BigDecimal monthlyInstalment) {
        this.monthlyInstalment = monthlyInstalment;
    }

    public BigDecimal getAnnualPercentageRate() {
        return annualPercentageRate;
    }

    public void setAnnualPercentageRate(BigDecimal annualPercentageRate) {
        this.annualPercentageRate = annualPercentageRate;
    }

    public Integer getDayForPayInstalments() {
        return dayForPayInstalments;
    }

    public void setDayForPayInstalments(Integer dayForPayInstalments) {
        this.dayForPayInstalments = dayForPayInstalments;
    }

    public Integer getNumberOfInstalments() {
        return numberOfInstalments;
    }

    public void setNumberOfInstalments(Integer numberOfInstalments) {
        this.numberOfInstalments = numberOfInstalments;
    }

    public Integer getNumberOfInstallmentsRepaid() {
        return numberOfInstallmentsRepaid;
    }

    public void setNumberOfInstallmentsRepaid(Integer numberOfInstallmentsRepaid) {
        this.numberOfInstallmentsRepaid = numberOfInstallmentsRepaid;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDateOfNextInstalment() {
        return dateOfNextInstalment;
    }

    public void setDateOfNextInstalment(String dateOfNextInstalment) {
        this.dateOfNextInstalment = dateOfNextInstalment;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public Consultant getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant(Consultant idConsultant) {
        this.idConsultant = idConsultant;
    }

    public Creditoffer getIdCreditOffer() {
        return idCreditOffer;
    }

    public void setIdCreditOffer(Creditoffer idCreditOffer) {
        this.idCreditOffer = idCreditOffer;
    }

    public Income getIdIncome() {
        return idIncome;
    }

    public void setIdIncome(Income idIncome) {
        this.idIncome = idIncome;
    }

    @XmlTransient
    public List<Repaymentschedule> getRepaymentscheduleList() {
        return repaymentscheduleList;
    }

    public void setRepaymentscheduleList(List<Repaymentschedule> repaymentscheduleList) {
        this.repaymentscheduleList = repaymentscheduleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCredit != null ? idCredit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credit)) {
            return false;
        }
        Credit other = (Credit) object;
        if ((this.idCredit == null && other.idCredit != null) || (this.idCredit != null && !this.idCredit.equals(other.idCredit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Credit[ idCredit=" + idCredit + " ]";
    }
    
}
