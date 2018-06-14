/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pai2.bank.app.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Odbiorca
 */
@Entity
@Table(name = "recurringbanktransfers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recurringbanktransfers.findAll", query = "SELECT r FROM Recurringbanktransfers r")
    , @NamedQuery(name = "Recurringbanktransfers.findByIdRecurringBankTransfers", query = "SELECT r FROM Recurringbanktransfers r WHERE r.idRecurringBankTransfers = :idRecurringBankTransfers")
    , @NamedQuery(name = "Recurringbanktransfers.findByStartDate", query = "SELECT r FROM Recurringbanktransfers r WHERE r.startDate = :startDate")
    , @NamedQuery(name = "Recurringbanktransfers.findByEndDate", query = "SELECT r FROM Recurringbanktransfers r WHERE r.endDate = :endDate")
    , @NamedQuery(name = "Recurringbanktransfers.findByFrequency", query = "SELECT r FROM Recurringbanktransfers r WHERE r.frequency = :frequency")
    , @NamedQuery(name = "Recurringbanktransfers.findByNumberOfDay", query = "SELECT r FROM Recurringbanktransfers r WHERE r.numberOfDay = :numberOfDay")
    , @NamedQuery(name = "Recurringbanktransfers.findByIdQuickRecipients", query = "SELECT r FROM Recurringbanktransfers r WHERE r.idQuickRecipients = :idQuickRecipients")})
public class Recurringbanktransfers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRecurringBankTransfers")
    private Integer idRecurringBankTransfers;
    @Size(max = 20)
    @Column(name = "startDate")
    private String startDate;
    @Size(max = 20)
    @Column(name = "endDate")
    private String endDate;
    @Size(max = 45)
    @Column(name = "frequency")
    private String frequency;
    @Column(name = "numberOfDay")
    private Integer numberOfDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idQuickRecipients")
    private int idQuickRecipients;
    @JoinColumn(name = "idLastBankTransfer", referencedColumnName = "idBankTransfer")
    @ManyToOne(optional = false)
    private Banktransfer idLastBankTransfer;

    public Recurringbanktransfers() {
    }

    public Recurringbanktransfers(Integer idRecurringBankTransfers) {
        this.idRecurringBankTransfers = idRecurringBankTransfers;
    }

    public Recurringbanktransfers(Integer idRecurringBankTransfers, int idQuickRecipients) {
        this.idRecurringBankTransfers = idRecurringBankTransfers;
        this.idQuickRecipients = idQuickRecipients;
    }

    public Integer getIdRecurringBankTransfers() {
        return idRecurringBankTransfers;
    }

    public void setIdRecurringBankTransfers(Integer idRecurringBankTransfers) {
        this.idRecurringBankTransfers = idRecurringBankTransfers;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(Integer numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public int getIdQuickRecipients() {
        return idQuickRecipients;
    }

    public void setIdQuickRecipients(int idQuickRecipients) {
        this.idQuickRecipients = idQuickRecipients;
    }

    public Banktransfer getIdLastBankTransfer() {
        return idLastBankTransfer;
    }

    public void setIdLastBankTransfer(Banktransfer idLastBankTransfer) {
        this.idLastBankTransfer = idLastBankTransfer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecurringBankTransfers != null ? idRecurringBankTransfers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurringbanktransfers)) {
            return false;
        }
        Recurringbanktransfers other = (Recurringbanktransfers) object;
        if ((this.idRecurringBankTransfers == null && other.idRecurringBankTransfers != null) || (this.idRecurringBankTransfers != null && !this.idRecurringBankTransfers.equals(other.idRecurringBankTransfers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Recurringbanktransfers[ idRecurringBankTransfers=" + idRecurringBankTransfers + " ]";
    }
    
}
