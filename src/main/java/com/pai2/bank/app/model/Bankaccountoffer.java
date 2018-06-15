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
@Table(name = "bankaccountoffer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankaccountoffer.findAll", query = "SELECT b FROM Bankaccountoffer b")
    , @NamedQuery(name = "Bankaccountoffer.findByIdBankAccountOffer", query = "SELECT b FROM Bankaccountoffer b WHERE b.idBankAccountOffer = :idBankAccountOffer")
    , @NamedQuery(name = "Bankaccountoffer.findByName", query = "SELECT b FROM Bankaccountoffer b WHERE b.name = :name")
    , @NamedQuery(name = "Bankaccountoffer.findByBankTransferPrice", query = "SELECT b FROM Bankaccountoffer b WHERE b.bankTransferPrice = :bankTransferPrice")
    , @NamedQuery(name = "Bankaccountoffer.findByAccountManagementPrice", query = "SELECT b FROM Bankaccountoffer b WHERE b.accountManagementPrice = :accountManagementPrice")
    , @NamedQuery(name = "Bankaccountoffer.findByCardPrice", query = "SELECT b FROM Bankaccountoffer b WHERE b.cardPrice = :cardPrice")
    , @NamedQuery(name = "Bankaccountoffer.findByStateOfOffer", query = "SELECT b FROM Bankaccountoffer b WHERE b.stateOfOffer = :stateOfOffer")})
public class Bankaccountoffer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBankAccountOffer")
    private Integer idBankAccountOffer;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "bankTransferPrice")
    private Integer bankTransferPrice;
    @Column(name = "accountManagementPrice")
    private Integer accountManagementPrice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cardPrice")
    private BigDecimal cardPrice;
    @Size(max = 45)
    @Column(name = "stateOfOffer")
    private String stateOfOffer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBankAccountOffer")
    private transient List<Bankaccount> bankaccountList;
    @JoinColumn(name = "idManager", referencedColumnName = "idManager")
    @ManyToOne
    private Manager idManager;

    public Bankaccountoffer() {
    }

    public Bankaccountoffer(Integer idBankAccountOffer) {
        this.idBankAccountOffer = idBankAccountOffer;
    }

    public Integer getIdBankAccountOffer() {
        return idBankAccountOffer;
    }

    public void setIdBankAccountOffer(Integer idBankAccountOffer) {
        this.idBankAccountOffer = idBankAccountOffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBankTransferPrice() {
        return bankTransferPrice;
    }

    public void setBankTransferPrice(Integer bankTransferPrice) {
        this.bankTransferPrice = bankTransferPrice;
    }

    public Integer getAccountManagementPrice() {
        return accountManagementPrice;
    }

    public void setAccountManagementPrice(Integer accountManagementPrice) {
        this.accountManagementPrice = accountManagementPrice;
    }

    public BigDecimal getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(BigDecimal cardPrice) {
        this.cardPrice = cardPrice;
    }

    public String getStateOfOffer() {
        return stateOfOffer;
    }

    public void setStateOfOffer(String stateOfOffer) {
        this.stateOfOffer = stateOfOffer;
    }

    @XmlTransient
    public List<Bankaccount> getBankaccountList() {
        return bankaccountList;
    }

    public void setBankaccountList(List<Bankaccount> bankaccountList) {
        this.bankaccountList = bankaccountList;
    }

    public Manager getIdManager() {
        return idManager;
    }

    public void setIdManager(Manager idManager) {
        this.idManager = idManager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBankAccountOffer != null ? idBankAccountOffer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankaccountoffer)) {
            return false;
        }
        Bankaccountoffer other = (Bankaccountoffer) object;
        if ((this.idBankAccountOffer == null && other.idBankAccountOffer != null) || (this.idBankAccountOffer != null && !this.idBankAccountOffer.equals(other.idBankAccountOffer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Bankaccountoffer[ idBankAccountOffer=" + idBankAccountOffer + " ]";
    }
    
}
