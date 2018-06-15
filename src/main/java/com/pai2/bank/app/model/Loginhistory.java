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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Odbiorca
 */
@Entity
@Table(name = "loginhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loginhistory.findAll", query = "SELECT l FROM Loginhistory l")
    , @NamedQuery(name = "Loginhistory.findByIdLoginHistory", query = "SELECT l FROM Loginhistory l WHERE l.idLoginHistory = :idLoginHistory")
        , @NamedQuery(name = "Loginhistory.findByIdUser", query = "SELECT l FROM Loginhistory l WHERE l.idUser.idUser = :idUser")
    , @NamedQuery(name = "Loginhistory.findByDate", query = "SELECT l FROM Loginhistory l WHERE l.date = :date")})
public class Loginhistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLoginHistory")
    private Integer idLoginHistory;
    @Size(max = 20)
    @Column(name = "date")
    private String date;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;

    public Loginhistory() {
    }

    public Loginhistory(Integer idLoginHistory) {
        this.idLoginHistory = idLoginHistory;
    }

    public Integer getIdLoginHistory() {
        return idLoginHistory;
    }

    public void setIdLoginHistory(Integer idLoginHistory) {
        this.idLoginHistory = idLoginHistory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLoginHistory != null ? idLoginHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loginhistory)) {
            return false;
        }
        Loginhistory other = (Loginhistory) object;
        if ((this.idLoginHistory == null && other.idLoginHistory != null) || (this.idLoginHistory != null && !this.idLoginHistory.equals(other.idLoginHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Loginhistory[ idLoginHistory=" + idLoginHistory + " ]";
    }
    
}
