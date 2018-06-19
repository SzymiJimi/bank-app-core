package com.pai2.bank.app.controller;


import com.pai2.bank.app.dao.CreditCardDao;
import com.pai2.bank.app.model.Creditcard;
import com.pai2.bank.app.model.JsonMessage;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("card")
public class CreditCardController {

    @EJB(beanInterface = CreditCardDao.class, beanName = "CreditCardDaoImpl")
    private CreditCardDao creditCardDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{bankAccId}")
    public Response getCreditCardsByBankAcc(@PathParam("bankAccId")Integer bankAccId )
    {
        try{
            List<Creditcard> cards =  creditCardDao.findCreditCardByAccountId(bankAccId);
            System.out.println("Znalezione karty: "+cards);
            return Response.ok().entity(cards).build();
        }catch(Exception e)
        {
            System.out.println("Authentication not found");
            System.out.println(e.toString());
            return Response.status(403).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/changePin")
    public Response getCreditCardsByBankAcc(Creditcard creditcard )
    {
        try{
            Creditcard result=  creditCardDao.merge(creditcard);
            System.out.println("karta z nowym pinem: "+result.getPinCode());
            return Response.ok().entity(result).build();
        }catch(Exception e)
        {
            System.out.println("Authentication not found");
            System.out.println(e.toString());
            return Response.status(403).build();
        }
    }


}
