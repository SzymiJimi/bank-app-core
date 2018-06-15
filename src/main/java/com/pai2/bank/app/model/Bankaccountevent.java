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
@Table(name = "bankaccountevent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankaccountevent.findAll", query = "SELECT b FROM Bankaccountevent b")
    , @NamedQuery(name = "Bankaccountevent.findByIdBankAccountEvent", query = "SELECT b FROM Bankaccountevent b WHERE b.idBankAccountEvent = :idBankAccountEvent")
    , @NamedQuery(name = "Bankaccountevent.findByType", query = "SELECT b FROM Bankaccountevent b WHERE b.type = :type")
    , @NamedQuery(name = "Bankaccountevent.findByDescription", query = "SELECT b FROM Bankaccountevent b WHERE b.description = :description")})
public class Bankaccountevent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "idBankAccountEvent")
    private Integer idBankAccountEvent;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "idConsultant", referencedColumnName = "idConsultant")
    @ManyToOne(optional = false)
    private Consultant idConsultant;
    @JoinColumn(name = "idBankAccount", referencedColumnName = "idBankAccount")
    @ManyToOne(optional = false)
    private Bankaccount idBankAccount;

    public Bankaccountevent() {
    }

    public Bankaccountevent(Integer idBankAccountEvent) {
        this.idBankAccountEvent = idBankAccountEvent;
    }

    public Integer getIdBankAccountEvent() {
        return idBankAccountEvent;
    }

    public void setIdBankAccountEvent(Integer idBankAccountEvent) {
        this.idBankAccountEvent = idBankAccountEvent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Consultant getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant(Consultant idConsultant) {
        this.idConsultant = idConsultant;
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
        hash += (idBankAccountEvent != null ? idBankAccountEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankaccountevent)) {
            return false;
        }
        Bankaccountevent other = (Bankaccountevent) object;
        if ((this.idBankAccountEvent == null && other.idBankAccountEvent != null) || (this.idBankAccountEvent != null && !this.idBankAccountEvent.equals(other.idBankAccountEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Bankaccountevent[ idBankAccountEvent=" + idBankAccountEvent + " ]";
    }
    
}
