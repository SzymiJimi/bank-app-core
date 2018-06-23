package com.pai2.bank.app.controller;

import com.pai2.bank.app.dao.BankAccountOfferDao;
import com.pai2.bank.app.dao.ManagerDAO;
import com.pai2.bank.app.dao.PersonDAO;
import com.pai2.bank.app.dao.implementation.BankAccountOfferDaoImpl;
import com.pai2.bank.app.dao.implementation.PersonDAOImpl;
import com.pai2.bank.app.model.Bankaccountoffer;
import com.pai2.bank.app.model.Creditcard;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;

/**
 * Created by Szymon on 18.06.2018.
 */

@Controller
@Stateless
@Path("offer")
@Produces((MediaType.APPLICATION_JSON))
public class BankAccountOfferController {
    @EJB(beanInterface = PersonDAO.class , beanName = "PersonDAOImpl")
    private PersonDAO personDAO;

    @EJB(beanInterface = ManagerDAO.class , beanName = "ManagerDaoImpl")
    private ManagerDAO managerDAO;

    @EJB(beanInterface = BankAccountOfferDao.class, beanName = "BankAccountOfferDaoImpl")
     private BankAccountOfferDao bankAccountOfferDao;

    @Path("new")
    @POST
    @Produces((MediaType.APPLICATION_JSON))
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveTest(Bankaccountoffer ob){
        System.out.println("dotarlem");
        bankAccountOfferDao.persist(ob);
        System.out.println("zapisalem" + ob);
        return Response.ok(ob).build();

    }





    }




