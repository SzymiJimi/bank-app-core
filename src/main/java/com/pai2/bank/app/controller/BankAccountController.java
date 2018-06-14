package com.pai2.bank.app.controller;


import com.pai2.bank.app.dao.BankAccountDao;
import com.pai2.bank.app.model.Bankaccount;
import com.pai2.bank.app.model.JsonMessage;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Controller
@Stateless
@Path("bankAccount")
@Produces({MediaType.APPLICATION_JSON})
public class BankAccountController {

    @EJB(beanInterface = BankAccountDao.class, beanName = "BankAccountDaoImpl")
    private BankAccountDao bankAccountDao;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{clientId}")
    public Response getClientBankAcc(@PathParam("clientId")Integer clientId )
    {
        try{
            System.out.println("Id clienta: "+clientId);
            List<Bankaccount> accounts =  bankAccountDao.findBankAccountsByClientId(clientId);
            return Response.ok().entity(accounts).build();
        }catch(Exception e)
        {
            System.out.println("Authentication not found");
            System.out.println("Wyjątek przy pobieraniu kont: "+e.toString());
            return Response.status(403).build();
        }
    }

}
