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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Odbiorca
 */
@Entity
@Table(name = "clientscredit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientscredit.findAll", query = "SELECT c FROM Clientscredit c")
    , @NamedQuery(name = "Clientscredit.findByIdClientsCredit", query = "SELECT c FROM Clientscredit c WHERE c.idClientsCredit = :idClientsCredit")})
public class Clientscredit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClientsCredit")
    private Integer idClientsCredit;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;
    @JoinColumn(name = "idCredit", referencedColumnName = "idCredit")
    @ManyToOne(optional = false)
    private Credit idCredit;

    public Clientscredit() {
    }

    public Clientscredit(Integer idClientsCredit) {
        this.idClientsCredit = idClientsCredit;
    }

    public Integer getIdClientsCredit() {
        return idClientsCredit;
    }

    public void setIdClientsCredit(Integer idClientsCredit) {
        this.idClientsCredit = idClientsCredit;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Credit getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(Credit idCredit) {
        this.idCredit = idCredit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientsCredit != null ? idClientsCredit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientscredit)) {
            return false;
        }
        Clientscredit other = (Clientscredit) object;
        if ((this.idClientsCredit == null && other.idClientsCredit != null) || (this.idClientsCredit != null && !this.idClientsCredit.equals(other.idClientsCredit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Clientscredit[ idClientsCredit=" + idClientsCredit + " ]";
    }
    
}
