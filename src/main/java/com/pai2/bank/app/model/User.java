package com.pai2.bank.app.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="idUser", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;
    @Column(name ="username")
    private String username;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="role_idRole")
    private Integer role_idRole;

    public User() {
    }

    public User(Integer idUser, String username, String name, String surname, String email, String phone, Integer role_idRole) {
        this.idUser = idUser;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.role_idRole = role_idRole;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole_idRole() {
        return role_idRole;
    }

    public void setRole_idRole(Integer role_idRole) {
        this.role_idRole = role_idRole;
    }
}
