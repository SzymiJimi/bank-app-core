/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pai2.bank.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "banktransfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banktransfer.findAll", query = "SELECT b FROM Banktransfer b")
    , @NamedQuery(name = "Banktransfer.findByIdBankTransfer", query = "SELECT b FROM Banktransfer b WHERE b.idBankTransfer = :idBankTransfer")
    , @NamedQuery(name = "Banktransfer.findByDateOfOrder", query = "SELECT b FROM Banktransfer b WHERE b.dateOfOrder = :dateOfOrder")
    , @NamedQuery(name = "Banktransfer.findUserByOwner", query = "SELECT u FROM  User u, Client cl, Bankaccount bac WHERE cl.idUser.idUser = u.idUser AND bac.idClient.idClient = cl.idClient AND  bac.idBankAccount =: bankAcc")
    , @NamedQuery(name = "Banktransfer.findByRecipient", query = "SELECT b FROM Banktransfer b WHERE b.recipient = :recipient")
    , @NamedQuery(name = "Banktransfer.findByAddress", query = "SELECT b FROM Banktransfer b WHERE b.address = :address")
    , @NamedQuery(name = "Banktransfer.findByDescription", query = "SELECT b FROM Banktransfer b WHERE b.description = :description")
    , @NamedQuery(name = "Banktransfer.findByState", query = "SELECT b FROM Banktransfer b WHERE b.state = :state")
    , @NamedQuery(name = "Banktransfer.findByAmount", query = "SELECT b FROM Banktransfer b WHERE b.amount = :amount")
    , @NamedQuery(name = "Banktransfer.findByAmountStateBefore", query = "SELECT b FROM Banktransfer b WHERE b.amountStateBefore = :amountStateBefore")
    , @NamedQuery(name = "Banktransfer.findByDateOfExecution", query = "SELECT b FROM Banktransfer b WHERE b.dateOfExecution = :dateOfExecution")
    , @NamedQuery(name = "Banktransfer.findByType", query = "SELECT b FROM Banktransfer b WHERE b.type = :type")})
public class Banktransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBankTransfer")
    private Integer idBankTransfer;
    @Size(max = 20)
    @Column(name = "dateOfOrder")
    private String dateOfOrder;
    @Size(max = 45)
    @Column(name = "recipient")
    private String recipient;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private  BigDecimal amount;
    @Column(name = "amountStateBefore")
    private  BigDecimal amountStateBefore;
    @Size(max = 20)
    @Column(name = "dateOfExecution")
    private String dateOfExecution;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "toAccount", referencedColumnName = "recipientAccount")
    @ManyToOne
    private  Accounttransfer toAccount;
    @JoinColumn(name = "fromAccount", referencedColumnName = "idBankAccount")
    @ManyToOne
    private Bankaccount fromAccount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLastBankTransfer")
    private transient  List<Recurringbanktransfers> recurringbanktransfersList;

//    public Banktransfer( ) {
//        System.out.println("Weszło w bank transfer");
////        System.out.println("Weszło w nowy");
////        this.address=address;
////        this.amount= amount;
////        this.amountStateBefore = amountStateBefore;
////        this.dateOfExecution = dateOfExecution;
////        this.dateOfOrder = dateOfOrder;
////        this.description = description;
////        this.fromAccount = fromAccount;
////        this.recipient= recipient;
////        this.state = state;
////        this.toAccount = toAccount;
////        this.type =type;
//    }


    public Banktransfer() {
        System.out.println("Wywołał się konstruktow bez args");
    }

    @JsonCreator
    public Banktransfer(@JsonProperty("dateOfOrder")String dateOfOrder, @JsonProperty("recipient")String recipient,  @JsonProperty("address")String address, @JsonProperty("description")String description, @JsonProperty("state")String state, @JsonProperty("amount")BigDecimal amount, @JsonProperty("amountStateBefore")BigDecimal amountStateBefore,  @JsonProperty("dateOfExecution")String dateOfExecution,  @JsonProperty("type")String type, @JsonProperty("toAccount")Accounttransfer toAccount, @JsonProperty("fromAccount")Bankaccount fromAccount) {
        System.out.println("Wywołał się konstruktow all args");
        this.dateOfOrder = dateOfOrder;
        this.recipient = recipient;
        this.address = address;
        this.description = description;
        this.state = state;
        this.amount = amount;
        this.amountStateBefore = amountStateBefore;
        this.dateOfExecution = dateOfExecution;
        this.type = type;
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
    }

    public Banktransfer(Integer idBankTransfer) {
        this.idBankTransfer = idBankTransfer;
    }

    public Integer getIdBankTransfer() {
        return idBankTransfer;
    }

    public void setIdBankTransfer(Integer idBankTransfer) {
        this.idBankTransfer = idBankTransfer;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountStateBefore() {
        return amountStateBefore;
    }

    public void setAmountStateBefore(BigDecimal amountStateBefore) {
        this.amountStateBefore = amountStateBefore;
    }

    public String getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(String dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Accounttransfer getToAccount() {
        return toAccount;
    }

    public void setToAccount(Accounttransfer toAccount) {
        this.toAccount = toAccount;
    }

    public Bankaccount getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Bankaccount fromAccount) {
        this.fromAccount = fromAccount;
    }

    @XmlTransient
    public List<Recurringbanktransfers> getRecurringbanktransfersList() {
        return recurringbanktransfersList;
    }

    public void setRecurringbanktransfersList(List<Recurringbanktransfers> recurringbanktransfersList) {
        this.recurringbanktransfersList = recurringbanktransfersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBankTransfer != null ? idBankTransfer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banktransfer)) {
            return false;
        }
        Banktransfer other = (Banktransfer) object;
        if ((this.idBankTransfer == null && other.idBankTransfer != null) || (this.idBankTransfer != null && !this.idBankTransfer.equals(other.idBankTransfer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Banktransfer[ idBankTransfer=" + idBankTransfer + " ]";
    }
    
}
