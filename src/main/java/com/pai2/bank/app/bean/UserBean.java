//package com.pai2.bank.app.bean;
//
//import com.pai2.bank.app.ejb.UserEJB;
//import com.pai2.bank.app.model.UserEntity;
//
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
//import javax.inject.Inject;
//import java.util.List;
//
//@ApplicationScoped
//@ManagedBean
//public class UserBean {
//
//    @Inject
//    UserEJB userEJB;
//
//    public List<UserEntity> getAllUsers() {
//        return userEJB.getAll();
//    }
//
//    public void add() {
//        UserEntity user = new UserEntity();
//        user.setUsername("John Doe2");
//
//        userEJB.saveUser(user);
//
//        UserEntity user2 = new UserEntity();
//        user2.setUsername("John Doe3");
//
//        userEJB.saveUser(user2);
//
//        UserEntity user3 = new UserEntity();
//        user3.setUsername("John Doe4");
//
//        userEJB.saveUser(user3);
//    }
//}