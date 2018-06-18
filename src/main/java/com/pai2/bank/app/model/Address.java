/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pai2.bank.app.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByIdAdress", query = "SELECT a FROM Address a WHERE a.idAdress = :idAdress")
    , @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city")
    , @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street")
    , @NamedQuery(name = "Address.findByNumberOfTheBuilding", query = "SELECT a FROM Address a WHERE a.numberOfTheBuilding = :numberOfTheBuilding")
    , @NamedQuery(name = "Address.findByApartmentNumber", query = "SELECT a FROM Address a WHERE a.apartmentNumber = :apartmentNumber")
    , @NamedQuery(name = "Address.findByPostCode", query = "SELECT a FROM Address a WHERE a.postCode = :postCode")
    , @NamedQuery(name = "Address.findByPostCity", query = "SELECT a FROM Address a WHERE a.postCity = :postCity")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdress")
    private Integer idAdress;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "street")
    private String street;
    @Size(max = 45)
    @Column(name = "numberOfTheBuilding")
    private String numberOfTheBuilding;
    @Size(max = 45)
    @Column(name = "apartmentNumber")
    private String apartmentNumber;
    @Size(max = 45)
    @Column(name = "postCode")
    private String postCode;
    @Size(max = 45)
    @Column(name = "postCity")
    private String postCity;
    @OneToMany(mappedBy = "idAddress")
    private transient List<Person> personList;
    @OneToMany(mappedBy = "idAddressForCorrespondence")
    private transient List<Person> personList1;

    public Address() {
    }

    public Address(Integer idAdress) {
        this.idAdress = idAdress;
    }

    public Integer getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(Integer idAdress) {
        this.idAdress = idAdress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfTheBuilding() {
        return numberOfTheBuilding;
    }

    public void setNumberOfTheBuilding(String numberOfTheBuilding) {
        this.numberOfTheBuilding = numberOfTheBuilding;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCity() {
        return postCity;
    }

    public void setPostCity(String postCity) {
        this.postCity = postCity;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @XmlTransient
    public List<Person> getPersonList1() {
        return personList1;
    }

    public void setPersonList1(List<Person> personList1) {
        this.personList1 = personList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdress != null ? idAdress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.idAdress == null && other.idAdress != null) || (this.idAdress != null && !this.idAdress.equals(other.idAdress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Address[ idAdress=" + idAdress + " ]";
    }
    
}
