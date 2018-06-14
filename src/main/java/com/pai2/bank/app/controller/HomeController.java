package com.pai2.bank.app.controller;


//import com.pai2.bank.app.dao.UserDAO;


import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
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
    public Set<User> sayHello() throws SystemException, NotSupportedException {

//        EntityManager em = ENTITY_MANAGER_FACTORY().c
//        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
//        EntityTransaction transaction = null;
//        User tmpuser = new User(1, "SzymiJimi", "Szymon", "Jarząbek" , "rekas1@tlen.pl", "661000006", 1);
//        manager.persist(tmpuser);
        Set<User> users= userDAO.getUserList();

        for (User user :users) {
            System.out.println(user.getUsername());
        }
        // Commit the transaction
//        transaction.commit();
        return users ;
    }
}
