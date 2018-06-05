package com.pai2.bank.app.controller;


import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.model.Credentials;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Stateless
@Path("login")
@Produces({MediaType.APPLICATION_JSON})
public class LoginController {

    @EJB(beanInterface = UserDAO.class, beanName = "UserDaoImpl")
    private UserDAO userDAO;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credentials credentials){

        System.out.println("Dane logowania: "+credentials.getUsername()+" "+credentials.getPassword());


        return null;
    }

}
