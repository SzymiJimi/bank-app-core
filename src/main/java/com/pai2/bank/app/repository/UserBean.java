//package com.pai2.bank.app.repository;
//
//import com.pai2.bank.app.model.User;
//
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Stateless
//public class UserBean {
//
//        @PersistenceContext
//        private EntityManager em;
//
//        @SuppressWarnings("unchecked")
//        public List<User> get() {
//            return em.createNativeQuery("select * from USER", User.class).getResultList();
//        }
//}
