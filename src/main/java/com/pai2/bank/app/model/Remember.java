package com.pai2.bank.app.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "Remember")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Remember.findAll", query = "SELECT r FROM Remember r")
        , @NamedQuery(name = "Remember.findByIdRemember", query = "SELECT r FROM Remember r WHERE r.idRemenber = :idRemember")
        , @NamedQuery(name = "Remember.findByIdUser", query = "SELECT r FROM Remember r WHERE r.idUser.idUser = :idUser")
        , @NamedQuery(name = "Remember.findUserByUuid", query = "SELECT u FROM Remember r, User u WHERE r.idUser.idUser=u.idUser AND r.uuid = :uuid")})
public class Remember implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRemenber")
    private Integer idRemenber;
    @Column(name = "uuid")
    private String uuid;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User idUser;

    public Remember() {
    }

    public Remember(String uuid, User idUser) {
        this.uuid = uuid;
        this.idUser = idUser;
    }

    public Integer getIdRemenber() {
        return idRemenber;
    }

    public void setIdRemenber(Integer idRemenber) {
        this.idRemenber = idRemenber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}
