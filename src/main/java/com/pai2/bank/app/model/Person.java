/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pai2.bank.app.model;

import java.io.Serializable;
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
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByIdPerson", query = "SELECT p FROM Person p WHERE p.idPerson = :idPerson")
    , @NamedQuery(name = "Person.findByName", query = "SELECT p FROM Person p WHERE p.name = :name")
    , @NamedQuery(name = "Person.findBySurname", query = "SELECT p FROM Person p WHERE p.surname = :surname")
    , @NamedQuery(name = "Person.findByPeselNumber", query = "SELECT p FROM Person p WHERE p.peselNumber = :peselNumber")
    , @NamedQuery(name = "Person.findByIdCardNumber", query = "SELECT p FROM Person p WHERE p.idCardNumber = :idCardNumber")
    , @NamedQuery(name = "Person.findByCitizenship", query = "SELECT p FROM Person p WHERE p.citizenship = :citizenship")
    , @NamedQuery(name = "Person.findByMothersName", query = "SELECT p FROM Person p WHERE p.mothersName = :mothersName")
    , @NamedQuery(name = "Person.findByFathersName", query = "SELECT p FROM Person p WHERE p.fathersName = :fathersName")
    , @NamedQuery(name = "Person.findByTelepohoneNumber", query = "SELECT p FROM Person p WHERE p.telepohoneNumber = :telepohoneNumber")
    , @NamedQuery(name = "Person.findByMothersMaidenName", query = "SELECT p FROM Person p WHERE p.mothersMaidenName = :mothersMaidenName")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerson")
    private Integer idPerson;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "surname")
    private String surname;
    @Size(max = 45)
    @Column(name = "peselNumber")
    private String peselNumber;
    @Size(max = 45)
    @Column(name = "idCardNumber")
    private String idCardNumber;
    @Size(max = 45)
    @Column(name = "citizenship")
    private String citizenship;
    @Size(max = 45)
    @Column(name = "mothersName")
    private String mothersName;
    @Size(max = 45)
    @Column(name = "fathersName")
    private String fathersName;
    @Size(max = 45)
    @Column(name = "telepohoneNumber")
    private String telepohoneNumber;
    @Size(max = 45)
    @Column(name = "mothersMaidenName")
    private String mothersMaidenName;
    @JoinColumn(name = "idAddress", referencedColumnName = "idAdress")
    @ManyToOne
    private Address idAddress;
    @JoinColumn(name = "idAddressForCorrespondence", referencedColumnName = "idAdress")
    @ManyToOne
    private Address idAddressForCorrespondence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerson")
    private List<User> userList;

    public Person() {
    }

    public Person(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPeselNumber() {
        return peselNumber;
    }

    public void setPeselNumber(String peselNumber) {
        this.peselNumber = peselNumber;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getTelepohoneNumber() {
        return telepohoneNumber;
    }

    public void setTelepohoneNumber(String telepohoneNumber) {
        this.telepohoneNumber = telepohoneNumber;
    }

    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }

    public Address getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Address idAddress) {
        this.idAddress = idAddress;
    }

    public Address getIdAddressForCorrespondence() {
        return idAddressForCorrespondence;
    }

    public void setIdAddressForCorrespondence(Address idAddressForCorrespondence) {
        this.idAddressForCorrespondence = idAddressForCorrespondence;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pai2.bank.app.model.Person[ idPerson=" + idPerson + " ]";
    }
    
}
