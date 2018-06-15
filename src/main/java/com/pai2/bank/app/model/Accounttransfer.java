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
@Table(name = "accounttransfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounttransfer.findAll", query = "SELECT a FROM Accounttransfer a")
    , @NamedQuery(name = "Accounttransfer.findByRecipientAccount", query = "SELECT a FROM Accounttransfer a WHERE a.recipientAccount = :recipientAccount")})
public class Accounttransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "recipientAccount")
    private String recipientAccount;
    @OneToMany(mappedBy = "toAccount")
    private transient List<Banktransfer> banktransferList;
    @JoinColumn(name = "idInternalAccount", referencedColumnName = "idBankAccount")
    @ManyToOne
    private Bankaccount idInternalAccount;
    @JoinColumn(name = "idExternalAccount", referencedColumnName = "idExternalAccount")
    @ManyToOne
    private Externalaccount idExternalAccount;

    public Accounttransfer() {
    }

    public Accounttransfer(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    @XmlTransient
    public List<Banktransfer> getBanktransferList() {
        return banktransferList;
    }

    public void setBanktransferList(List<Banktransfer> banktransferList) {
        this.banktransferList = banktransferList;
    }

    public Bankaccount getIdInternalAccount() {
        return idInternalAccount;
    }

    public void setIdInternalAccount(Bankaccount idInternalAccount) {
        this.idInternalAccount = idInternalAccount;
    }

    public Externalaccount getIdExternalAccount() {
        return idExternalAccount;
    }

    public void setIdExternalAccount(Externalaccount idExternalAccount) {
        this.idExternalAccount = idExternalAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipientAccount != null ? recipientAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounttransfer)) {
            return false;
        }
        Accounttransfer other = (Accounttransfer) object;
        if ((this.recipientAccount == null && other.recipientAccount != null) || (this.recipientAccount != null && !this.recipientAccount.equals(other.recipientAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Accounttransfer[ recipientAccount=" + recipientAccount + " ]";
    }
    
}
