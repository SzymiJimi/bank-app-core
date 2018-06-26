package com.pai2.bank.app.controller;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pai2.bank.app.dao.BankAccountDao;
import com.pai2.bank.app.dao.BankTransferDao;
import com.pai2.bank.app.model.*;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@Path("transfer")
public class BankTransferController {


    @Inject
    private SendEmailService sendEmailService;

    @Inject
    private TransferAuthenticationService transferAuthenticationService;

    @EJB(beanInterface = BankTransferDao.class, beanName = "BankTransferDaoImpl")
    private BankTransferDao bankTransferDao;

    @EJB(beanInterface = TransferService.class, beanName = "TransferService")
    private TransferService transferService;

    @EJB(beanInterface = BankAccountDao.class, beanName = "BankAccountDaoImpl")
    private BankAccountDao bankAccountDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sendMail")
    public Response sendEmail(){

        JsonMessage message = new JsonMessage("Po wysłaniu:", 2);
            return Response.ok().entity(message).build();

    }




    @POST
    @Produces("text/plain")
    @Consumes("application/json")
    @Path("make")
    public Response makeTransaction( Banktransfer bankTransfer){

        Boolean state = analizeTransferData(bankTransfer);
        System.out.println("CEApp Stan wszystkich checków: " +state );
        if(state){
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
        }else{
            return Response.status(403).build();
        }



    }

    @POST
    @Produces("text/plain")
    @Consumes("application/json")
    @Path("register")
    public Response registerTransaction( Banktransfer bankTransfer){

        try{
            transferService.registerTransaction(bankTransfer);

            return Response.ok().entity("CEApp Pozytywnie stworzono transfer").build();
        }catch(Exception e ){
            System.out.println("CEApp Nieudane dodanie transferu: "+ e.toString());
            return Response.status(403).build();
        }


    }

    private boolean analizeTransferData(Banktransfer bankTransfer){
        boolean state=true;
        String dateOfOrder =  bankTransfer.getDateOfOrder();
        state = analizeDate(dateOfOrder);
        System.out.println("CEApp Stan po pierwszym sprawdzeniu: "+state);
        bankTransfer.setState(stateAnalize(bankTransfer.getState()));
        state = fromAccountAnalize(bankTransfer.getFromAccount());
        System.out.println("CEApp Stan po drugim sprawdzeniu: "+state);
        state = toAccountAnalize(bankTransfer.getToAccount().getRecipientAccount());
        System.out.println("CEApp Stan po trzecim sprawdzeniu: "+state);
        return state;
    }

    private boolean analizeDate(String dateOfOrder){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date orderDate = df.parse(dateOfOrder);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("CEApp BankTransfer error: Unknown date format...");
            return false;
        }

    }

    private String stateAnalize(String state){
        if (!state.equals("CREATED")){
            return "CREATED";
        }else{
            return state;
        }

    }

    private boolean fromAccountAnalize(Bankaccount bankaccount){
        try{
            bankAccountDao.findById(bankaccount.getIdBankAccount());
            return true;
        }catch(Exception e)
        {
            System.out.println("CEApp Error with fromBankAccount in make transfer");
            e.printStackTrace();
            return false;
        }
    }

    private boolean toAccountAnalize(String toAccount){
        if(toAccount.length()==26)
        {
            String upperText = toAccount.toUpperCase();
            String lowerText = toAccount.toLowerCase();
            return upperText.equals(lowerText);
        }
        System.out.println("CEApp Error with toAccount in make transfer");
        return false;

    }



}
