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
@Table(name = "bankaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankaccount.findAll", query = "SELECT b FROM Bankaccount b")
    , @NamedQuery(name = "Bankaccount.findByIdBankAccount", query = "SELECT b FROM Bankaccount b WHERE b.idBankAccount = :idBankAccount")
    , @NamedQuery(name = "Bankaccount.findByAccountNumber", query = "SELECT b FROM Bankaccount b WHERE b.accountNumber = :accountNumber")
    , @NamedQuery(name = "Bankaccount.findByAmount", query = "SELECT b FROM Bankaccount b WHERE b.amount = :amount")
    , @NamedQuery(name = "Bankaccount.findByCreationDate", query = "SELECT b FROM Bankaccount b WHERE b.creationDate = :creationDate")
    , @NamedQuery(name = "Bankaccount.findByDayLimit", query = "SELECT b FROM Bankaccount b WHERE b.dayLimit = :dayLimit")
    , @NamedQuery(name = "Bankaccount.findByMonthLimit", query = "SELECT b FROM Bankaccount b WHERE b.monthLimit = :monthLimit")
    , @NamedQuery(name = "Bankaccount.findByState", query = "SELECT b FROM Bankaccount b WHERE b.state = :state")})
public class Bankaccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBankAccount")
    private Integer idBankAccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "accountNumber")
    private String accountNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private BigDecimal amount;
    @Size(max = 26)
    @Column(name = "creationDate")
    private String creationDate;
    @Column(name = "dayLimit")
    private BigDecimal dayLimit;
    @Column(name = "monthLimit")
    private BigDecimal monthLimit;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "idBankAccountOffer", referencedColumnName = "idBankAccountOffer")
    @ManyToOne(optional = false)
    private Bankaccountoffer idBankAccountOffer;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;
    @OneToMany(mappedBy = "fromAccount")
    private List<Banktransfer> banktransferList;
    @OneToMany(mappedBy = "idInternalAccount")
    private List<Accounttransfer> accounttransferList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBankAccount")
    private List<Bankaccountevent> bankaccounteventList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBankAccount")
    private List<Creditcard> creditcardList;

    public Bankaccount() {
    }

    public Bankaccount(Integer idBankAccount) {
        this.idBankAccount = idBankAccount;
    }

    public Bankaccount(Integer idBankAccount, String accountNumber) {
        this.idBankAccount = idBankAccount;
        this.accountNumber = accountNumber;
    }

    public Integer getIdBankAccount() {
        return idBankAccount;
    }

    public void setIdBankAccount(Integer idBankAccount) {
        this.idBankAccount = idBankAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public BigDecimal getDayLimit() {
        return dayLimit;
    }

    public void setDayLimit(BigDecimal dayLimit) {
        this.dayLimit = dayLimit;
    }

    public BigDecimal getMonthLimit() {
        return monthLimit;
    }

    public void setMonthLimit(BigDecimal monthLimit) {
        this.monthLimit = monthLimit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Bankaccountoffer getIdBankAccountOffer() {
        return idBankAccountOffer;
    }

    public void setIdBankAccountOffer(Bankaccountoffer idBankAccountOffer) {
        this.idBankAccountOffer = idBankAccountOffer;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    @XmlTransient
    public List<Banktransfer> getBanktransferList() {
        return banktransferList;
    }

    public void setBanktransferList(List<Banktransfer> banktransferList) {
        this.banktransferList = banktransferList;
    }

    @XmlTransient
    public List<Accounttransfer> getAccounttransferList() {
        return accounttransferList;
    }

    public void setAccounttransferList(List<Accounttransfer> accounttransferList) {
        this.accounttransferList = accounttransferList;
    }

    @XmlTransient
    public List<Bankaccountevent> getBankaccounteventList() {
        return bankaccounteventList;
    }

    public void setBankaccounteventList(List<Bankaccountevent> bankaccounteventList) {
        this.bankaccounteventList = bankaccounteventList;
    }

    @XmlTransient
    public List<Creditcard> getCreditcardList() {
        return creditcardList;
    }

    public void setCreditcardList(List<Creditcard> creditcardList) {
        this.creditcardList = creditcardList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBankAccount != null ? idBankAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankaccount)) {
            return false;
        }
        Bankaccount other = (Bankaccount) object;
        if ((this.idBankAccount == null && other.idBankAccount != null) || (this.idBankAccount != null && !this.idBankAccount.equals(other.idBankAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Bankaccount[ idBankAccount=" + idBankAccount + " ]";
    }
    
}
