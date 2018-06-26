package com.pai2.bank.app.controller;

import com.pai2.bank.app.dao.BankAccountOfferDao;
import com.pai2.bank.app.dao.ManagerDAO;
import com.pai2.bank.app.dao.PersonDAO;
import com.pai2.bank.app.dao.implementation.BankAccountOfferDaoImpl;
import com.pai2.bank.app.dao.implementation.PersonDAOImpl;
import com.pai2.bank.app.model.Bankaccount;
import com.pai2.bank.app.model.Bankaccountoffer;
import com.pai2.bank.app.model.Creditcard;
import com.pai2.bank.app.model.Manager;

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





    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{idManager}")
    public Response getManagerOffers(@PathParam("idManager")Integer idManager){

           try {
               System.out.println("manager id " + idManager);
               List<Bankaccountoffer> offers = bankAccountOfferDao.findOfferByManagerId(idManager);
               return Response.ok().entity(offers).build();
           }catch(Exception e)
           {
               System.out.println("Authentication not found");
               System.out.println("Wyjątek przy pobieraniu kont: "+e.toString());
               return Response.status(403).build();
           }
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/find/{idOffer}")
    public Response getOffer(@PathParam("idOffer")Integer id){
       Bankaccountoffer offer = bankAccountOfferDao.findById(id);
       return Response.ok().entity(offer).build();

    }


    @Path("new")
    @POST
    @Produces((MediaType.APPLICATION_JSON))
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveTest(Bankaccountoffer ob){
        System.out.println("dotarlem");
        Manager manager = new Manager();
        manager.setIdManager(1);
        ob.setIdManager(manager);
        bankAccountOfferDao.persist(ob);
        System.out.println("zapisalem" + ob);
        return Response.ok(ob).build();

    }




    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("manager/{offerId}")
    public Response getOfferById(@PathParam("offerId")Integer offerId){
        try{
            List<Bankaccountoffer> offers = bankAccountOfferDao.findByIdOffer(offerId);
            System.out.println("Oferty " +offers);
            return Response.ok().entity(offers).build();
        }catch(Exception e){
            System.out.println("Blad");
            System.out.println(e.toString());
            return Response.status(403).build();
        }
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/changeOffer")
    public Response getOffer(Bankaccountoffer bankaccountoffer){
        try{
            Manager manager = new Manager();
            manager.setIdManager(1);
            bankaccountoffer.setIdManager(manager);
            Bankaccountoffer result = bankAccountOfferDao.merge(bankaccountoffer);
            System.out.println("Nowa oferta " +  bankaccountoffer);
            return Response.ok().entity(result).build();
        }catch(Exception e)
        {
            System.out.println("Authentication not found");
            System.out.println(e.toString());
            return Response.status(403).build();
        }
    }




    }




