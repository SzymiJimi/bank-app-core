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
import java.util.Set;


public class HomeController {


    @EJB(beanInterface = UserDAO.class, beanName = "UserDaoImpl")
    private UserDAO userDAO;



    public Set<User> sayHello() throws SystemException, NotSupportedException {

        Set<User> users= userDAO.getUserList();

        for (User user :users) {
            System.out.println(user.getUsername());
        }

        return users ;
    }
}
