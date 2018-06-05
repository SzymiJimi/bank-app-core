package com.pai2.bank.app.controller;


//import com.pai2.bank.app.dao.UserDAO;


import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.model.UserEntity;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Controller
@Stateless
@Path("home")
@Produces({MediaType.APPLICATION_JSON})
public class HomeController {

//    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
//            .createEntityManagerFactory("bank-app");


    @EJB(beanInterface = UserDAO.class, beanName = "UserDaoImpl")
    private UserDAO userDAO;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity sayHello() throws SystemException, NotSupportedException {

//        EntityManager em = ENTITY_MANAGER_FACTORY().c
//        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction transaction = null;
        UserEntity tmpuser = new UserEntity(1, "SzymiJimi", "Szymon", "Jarząbek" , "rekas1@tlen.pl", "661000006", 1);
//        manager.persist(tmpuser);
        Set<UserEntity> users= userDAO.getUserList();

        for (UserEntity user :users) {
            System.out.println(user.getUsername());
        }
        // Commit the transaction
//        transaction.commit();
        return tmpuser ;
    }
}
