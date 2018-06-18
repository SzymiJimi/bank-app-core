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
import com.pai2.bank.app.service.TransferAuthenticationService;
import com.pai2.bank.app.service.TransferService;
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

    @Inject
    TransferAuthenticationService transferAuthenticationService;

    @EJB(beanInterface = BankTransferDao.class, beanName = "BankTransferDaoImpl")
    private BankTransferDao bankTransferDao;

    @EJB(beanInterface = TransferService.class, beanName = "TransferService")
    private TransferService transferService;


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

        try{
            User foundUser = bankTransferDao.findUser( bankTransfer.getFromAccount().getIdBankAccount());
            String code= transferAuthenticationService.generateCode();
            String email = sendEmailService.createEmailWithCode(code);
            sendEmailService.sendEmail(foundUser.getEmail(), email, "Potwierdzenie przelewu");
            return Response.ok().entity(code).build();
        }catch(Exception e ){
            e.printStackTrace();
            return Response.status(403).build();
        }


//            return Response.status(403).build();


    }

    @POST
    @Produces("text/plain")
    @Consumes("application/json")
    @Path("register")
    public Response registerTransaction( Banktransfer bankTransfer){

        try{
            transferService.registerTransaction(bankTransfer);

            return Response.ok().entity("Pozytywnie stworzono transfer").build();
        }catch(Exception e ){
            e.printStackTrace();
            return Response.status(403).build();
        }


    }

}
