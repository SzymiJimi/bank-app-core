package com.pai2.bank.app.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private Integer idRole;
    private String name;

    public Role() {
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
