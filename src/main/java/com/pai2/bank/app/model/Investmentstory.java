///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pai2.bank.app.model;
//
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author Odbiorca
// */
//@Entity
//@Table(name = "investmentstory")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Investmentstory.findAll", query = "SELECT i FROM Investmentstory i")
//    , @NamedQuery(name = "Investmentstory.findByIdInvestmentStory", query = "SELECT i FROM Investmentstory i WHERE i.idInvestmentStory = :idInvestmentStory")
//    , @NamedQuery(name = "Investmentstory.findByType", query = "SELECT i FROM Investmentstory i WHERE i.type = :type")
//    , @NamedQuery(name = "Investmentstory.findByAmountBefore", query = "SELECT i FROM Investmentstory i WHERE i.amountBefore = :amountBefore")
//    , @NamedQuery(name = "Investmentstory.findByAmountAfter", query = "SELECT i FROM Investmentstory i WHERE i.amountAfter = :amountAfter")
//    , @NamedQuery(name = "Investmentstory.findByDate", query = "SELECT i FROM Investmentstory i WHERE i.date = :date")})
//public class Investmentstory implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "idInvestmentStory")
//    private Integer idInvestmentStory;
//    @Size(max = 45)
//    @Column(name = "type")
//    private String type;
//    @Column(name = "amountBefore")
//    private Integer amountBefore;
//    @Column(name = "amountAfter")
//    private Integer amountAfter;
//    @Size(max = 26)
//    @Column(name = "date")
//    private String date;
//    @JoinColumn(name = "idInvestment", referencedColumnName = "idInvestment")
//    @ManyToOne(optional = false)
//    private Investment idInvestment;
//
//    public Investmentstory() {
//    }
//
//    public Investmentstory(Integer idInvestmentStory) {
//        this.idInvestmentStory = idInvestmentStory;
//    }
//
//    public Integer getIdInvestmentStory() {
//        return idInvestmentStory;
//    }
//
//    public void setIdInvestmentStory(Integer idInvestmentStory) {
//        this.idInvestmentStory = idInvestmentStory;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public Integer getAmountBefore() {
//        return amountBefore;
//    }
//
//    public void setAmountBefore(Integer amountBefore) {
//        this.amountBefore = amountBefore;
//    }
//
//    public Integer getAmountAfter() {
//        return amountAfter;
//    }
//
//    public void setAmountAfter(Integer amountAfter) {
//        this.amountAfter = amountAfter;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public Investment getIdInvestment() {
//        return idInvestment;
//    }
//
//    public void setIdInvestment(Investment idInvestment) {
//        this.idInvestment = idInvestment;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idInvestmentStory != null ? idInvestmentStory.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Investmentstory)) {
//            return false;
//        }
//        Investmentstory other = (Investmentstory) object;
//        if ((this.idInvestmentStory == null && other.idInvestmentStory != null) || (this.idInvestmentStory != null && !this.idInvestmentStory.equals(other.idInvestmentStory))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.pai2.bank.app.model.Investmentstory[ idInvestmentStory=" + idInvestmentStory + " ]";
//    }
//
//}
