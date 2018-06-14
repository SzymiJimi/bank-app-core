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
import javax.persistence.CascadeType;
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
@Table(name = "consultant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultant.findAll", query = "SELECT c FROM Consultant c")
    , @NamedQuery(name = "Consultant.findByIdConsultant", query = "SELECT c FROM Consultant c WHERE c.idConsultant = :idConsultant")
    , @NamedQuery(name = "Consultant.findByIdUser", query = "SELECT c FROM Consultant c WHERE c.idUser.idUser = :idUser")
    , @NamedQuery(name = "Consultant.findBySalary", query = "SELECT c FROM Consultant c WHERE c.salary = :salary")
    , @NamedQuery(name = "Consultant.findByPosition", query = "SELECT c FROM Consultant c WHERE c.position = :position")})
public class Consultant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idConsultant")
    private Integer idConsultant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private BigDecimal salary;
    @Size(max = 45)
    @Column(name = "position")
    private String position;
    @OneToMany(mappedBy = "idConsultant")
    private transient List<Credit> creditList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConsultant")
    private transient List<Bankaccountevent> bankaccounteventList;
    @OneToMany(mappedBy = "idConsultant")
    private transient List<Investment> investmentList;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User idUser;

    public Consultant() {
    }

    public Consultant(Integer idConsultant) {
        this.idConsultant = idConsultant;
    }

    public Integer getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant(Integer idConsultant) {
        this.idConsultant = idConsultant;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @XmlTransient
    public List<Credit> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<Credit> creditList) {
        this.creditList = creditList;
    }

    @XmlTransient
    public List<Bankaccountevent> getBankaccounteventList() {
        return bankaccounteventList;
    }

    public void setBankaccounteventList(List<Bankaccountevent> bankaccounteventList) {
        this.bankaccounteventList = bankaccounteventList;
    }

    @XmlTransient
    public List<Investment> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(List<Investment> investmentList) {
        this.investmentList = investmentList;
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
        hash += (idConsultant != null ? idConsultant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultant)) {
            return false;
        }
        Consultant other = (Consultant) object;
        if ((this.idConsultant == null && other.idConsultant != null) || (this.idConsultant != null && !this.idConsultant.equals(other.idConsultant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Consultant[ idConsultant=" + idConsultant + " ]";
    }
    
}
