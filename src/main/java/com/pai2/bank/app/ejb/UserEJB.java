//package com.pai2.bank.app.ejb;
//
//import com.pai2.bank.app.model.UserEntity;
//
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
//
//@LocalBean
//@Stateless
//public class UserEJB {
//
//    @PersistenceContext
//    EntityManager em;
//
//    public void saveUser(UserEntity user) {
//        em.merge(user);
//    }
//
//    public void delteUser(UserEntity user) {
//        em.remove(user);
//    }
//
//    public List<UserEntity> getAll() {
//        Query q = em.createQuery("SELECT user FROM UserEntity user");
//        return (List<UserEntity>) q.getResultList();
//    }
//
//}