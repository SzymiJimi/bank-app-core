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
@Table(name = "externalaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Externalaccount.findAll", query = "SELECT e FROM Externalaccount e")
    , @NamedQuery(name = "Externalaccount.findByIdExternalAccount", query = "SELECT e FROM Externalaccount e WHERE e.idExternalAccount = :idExternalAccount")
    , @NamedQuery(name = "Externalaccount.findByAccountNumber", query = "SELECT e FROM Externalaccount e WHERE e.accountNumber = :accountNumber")})
public class Externalaccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idExternalAccount")
    private Integer idExternalAccount;
    @Size(max = 26)
    @Column(name = "accountNumber")
    private String accountNumber;
    @OneToMany(mappedBy = "idExternalAccount")
    private transient List<Accounttransfer> accounttransferList;

    public Externalaccount() {
    }

    public Externalaccount(Integer idExternalAccount) {
        this.idExternalAccount = idExternalAccount;
    }

    public Integer getIdExternalAccount() {
        return idExternalAccount;
    }

    public void setIdExternalAccount(Integer idExternalAccount) {
        this.idExternalAccount = idExternalAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @XmlTransient
    public List<Accounttransfer> getAccounttransferList() {
        return accounttransferList;
    }

    public void setAccounttransferList(List<Accounttransfer> accounttransferList) {
        this.accounttransferList = accounttransferList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExternalAccount != null ? idExternalAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Externalaccount)) {
            return false;
        }
        Externalaccount other = (Externalaccount) object;
        if ((this.idExternalAccount == null && other.idExternalAccount != null) || (this.idExternalAccount != null && !this.idExternalAccount.equals(other.idExternalAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Externalaccount[ idExternalAccount=" + idExternalAccount + " ]";
    }
    
}
