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
@Table(name = "clientsinvestment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientsinvestment.findAll", query = "SELECT c FROM Clientsinvestment c")
    , @NamedQuery(name = "Clientsinvestment.findByIdClientInvestment", query = "SELECT c FROM Clientsinvestment c WHERE c.idClientInvestment = :idClientInvestment")})
public class Clientsinvestment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClientInvestment")
    private Integer idClientInvestment;
    @JoinColumn(name = "idInvestment", referencedColumnName = "idInvestment")
    @ManyToOne(optional = false)
    private Investment idInvestment;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;

    public Clientsinvestment() {
    }

    public Clientsinvestment(Integer idClientInvestment) {
        this.idClientInvestment = idClientInvestment;
    }

    public Integer getIdClientInvestment() {
        return idClientInvestment;
    }

    public void setIdClientInvestment(Integer idClientInvestment) {
        this.idClientInvestment = idClientInvestment;
    }

    public Investment getIdInvestment() {
        return idInvestment;
    }

    public void setIdInvestment(Investment idInvestment) {
        this.idInvestment = idInvestment;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientInvestment != null ? idClientInvestment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientsinvestment)) {
            return false;
        }
        Clientsinvestment other = (Clientsinvestment) object;
        if ((this.idClientInvestment == null && other.idClientInvestment != null) || (this.idClientInvestment != null && !this.idClientInvestment.equals(other.idClientInvestment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Clientsinvestment[ idClientInvestment=" + idClientInvestment + " ]";
    }
    
}
