package com.pai2.bank.app.controller;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pai2.bank.app.dao.BankTransferDao;
import com.pai2.bank.app.model.Banktransfer;
import com.pai2.bank.app.model.Credentials;
import com.pai2.bank.app.model.JsonMessage;
import com.pai2.bank.app.model.User;
import com.pai2.bank.app.service.SendEmailService;
import org.jboss.logging.annotations.Param;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Controller
@Path("transfer")
public class BankTransferController {


    @Inject
    SendEmailService sendEmailService;

    @EJB(beanInterface = BankTransferDao.class, beanName = "BankTransferDaoImpl")
    private BankTransferDao bankTransferDao;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sendMail")
    public Response sendEmail(){


//        sendEmailService.sendEmail();

//        if(loggedUser!=null){
//
//            System.out.println("Logged USER : "+ loggedUser.getUsername()+", "+ loggedUser.getEmail());
        JsonMessage message = new JsonMessage("Po wysłaniu:", 2);
            return Response.ok().entity(message).build();
//        }else
//        {
//            System.out.println("User not foud");
//            return Response.status(403).build();
//        }
    }




    @POST
    @Produces("text/plain")
    @Consumes("application/json")
    @Path("make")
    public Response makeTransaction( Banktransfer bankTransfer){



        System.out.println("Wchodzi"+ bankTransfer.getAddress());
        System.out.println("Wchodzi"+ bankTransfer.getDescription());
        System.out.println("Wchodzi przed waznym id"+ bankTransfer.getFromAccount());
        System.out.println("Wchodzi ważne id:"+ bankTransfer.getFromAccount().getIdBankAccount());
        User foundUser = bankTransferDao.findUser( bankTransfer.getFromAccount().getIdBankAccount());
        System.out.println("Email: "+foundUser.getEmail());
            return Response.ok().entity("Siema").build();

//            return Response.status(403).build();


    }

}
