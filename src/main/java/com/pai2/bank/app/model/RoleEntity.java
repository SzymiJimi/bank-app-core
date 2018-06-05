package com.pai2.bank.app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "bankapp")
public class RoleEntity {
    private int idRole;
    private String name;

    @Id
    @Column(name = "idRole")
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return idRole == that.idRole &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idRole, name);
    }
}
