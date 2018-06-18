/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pai2.bank.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Odbiorca
 */
@Entity
@Table(name = "creditcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditcard.findAll", query = "SELECT c FROM Creditcard c")
    , @NamedQuery(name = "Creditcard.findByIdCreditCard", query = "SELECT c FROM Creditcard c WHERE c.idCreditCard = :idCreditCard")
    , @NamedQuery(name = "Creditcard.findByName", query = "SELECT c FROM Creditcard c WHERE c.name = :name")
    , @NamedQuery(name = "Creditcard.findByCreditCardNumber", query = "SELECT c FROM Creditcard c WHERE c.creditCardNumber = :creditCardNumber")
    , @NamedQuery(name = "Creditcard.findByPinCode", query = "SELECT c FROM Creditcard c WHERE c.pinCode = :pinCode")
    , @NamedQuery(name = "Creditcard.findByState", query = "SELECT c FROM Creditcard c WHERE c.state = :state")
    , @NamedQuery(name = "Creditcard.findByExpirationDate", query = "SELECT c FROM Creditcard c WHERE c.expirationDate = :expirationDate")
    , @NamedQuery(name = "Creditcard.findByType", query = "SELECT c FROM Creditcard c WHERE c.type = :type")
    , @NamedQuery(name = "Creditcard.findByDayLimit", query = "SELECT c FROM Creditcard c WHERE c.dayLimit = :dayLimit")
    , @NamedQuery(name = "Creditcard.findByMonthLimit", query = "SELECT c FROM Creditcard c WHERE c.monthLimit = :monthLimit")})
public class Creditcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCreditCard")
    private Integer idCreditCard;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "creditCardNumber")
    private String creditCardNumber;
    @Size(max = 4)
    @Column(name = "pinCode")
    private String pinCode;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Size(max = 20)
    @Column(name = "expirationDate")
    private String expirationDate;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dayLimit")
    private BigDecimal dayLimit;
    @Column(name = "monthLimit")
    private BigDecimal monthLimit;
    @JoinColumn(name = "idBankAccount", referencedColumnName = "idBankAccount")
    @ManyToOne(optional = false)
    private Bankaccount idBankAccount;

    public Creditcard() {
    }

    public Creditcard(Integer idCreditCard) {
        this.idCreditCard = idCreditCard;
    }

    public Integer getIdCreditCard() {
        return idCreditCard;
    }

    public void setIdCreditCard(Integer idCreditCard) {
        this.idCreditCard = idCreditCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Bankaccount getIdBankAccount() {
        return idBankAccount;
    }

    public void setIdBankAccount(Bankaccount idBankAccount) {
        this.idBankAccount = idBankAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCreditCard != null ? idCreditCard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditcard)) {
            return false;
        }
        Creditcard other = (Creditcard) object;
        if ((this.idCreditCard == null && other.idCreditCard != null) || (this.idCreditCard != null && !this.idCreditCard.equals(other.idCreditCard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Creditcard[ idCreditCard=" + idCreditCard + " ]";
    }
    
}
