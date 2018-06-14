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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Odbiorca
 */
@Entity
@Table(name = "manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m")
    , @NamedQuery(name = "Manager.findByIdManager", query = "SELECT m FROM Manager m WHERE m.idManager = :idManager")
    , @NamedQuery(name = "Manager.findByIdUser", query = "SELECT m FROM Manager m WHERE m.idUser.idUser = :idUser")
    , @NamedQuery(name = "Manager.findBySalary", query = "SELECT m FROM Manager m WHERE m.salary = :salary")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idManager")
    private Integer idManager;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private BigDecimal salary;
    @OneToMany(mappedBy = "idManager")
    private transient List<Creditoffer> creditofferList;
    @OneToMany(mappedBy = "idManager")
    private transient List<Investmentoffer> investmentofferList;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;
    @OneToMany(mappedBy = "idManager")
    private transient List<Bankaccountoffer> bankaccountofferList;

    public Manager() {
    }

    public Manager(Integer idManager) {
        this.idManager = idManager;
    }

    public Integer getIdManager() {
        return idManager;
    }

    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @XmlTransient
    public List<Creditoffer> getCreditofferList() {
        return creditofferList;
    }

    public void setCreditofferList(List<Creditoffer> creditofferList) {
        this.creditofferList = creditofferList;
    }

    @XmlTransient
    public List<Investmentoffer> getInvestmentofferList() {
        return investmentofferList;
    }

    public void setInvestmentofferList(List<Investmentoffer> investmentofferList) {
        this.investmentofferList = investmentofferList;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<Bankaccountoffer> getBankaccountofferList() {
        return bankaccountofferList;
    }

    public void setBankaccountofferList(List<Bankaccountoffer> bankaccountofferList) {
        this.bankaccountofferList = bankaccountofferList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idManager != null ? idManager.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.idManager == null && other.idManager != null) || (this.idManager != null && !this.idManager.equals(other.idManager))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Manager[ idManager=" + idManager + " ]";
    }
    
}
