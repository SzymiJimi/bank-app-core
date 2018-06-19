package com.pai2.bank.app.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.pai2.bank.app.dao.BankAccountDao;
import com.pai2.bank.app.dao.BankTransferDao;
import com.pai2.bank.app.model.Bankaccount;
import com.pai2.bank.app.model.Banktransfer;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("bankAccount")
public class BankAccountController {

    @EJB(beanInterface = BankAccountDao.class, beanName = "BankAccountDaoImpl")
    private BankAccountDao bankAccountDao;

    @EJB(beanInterface = BankTransferDao.class, beanName = "BankTransferDaoImpl")
    private BankTransferDao bankTransferDao;


    @GET
    @Consumes("application/json")
    @Produces("application/json")
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

    @GET
    @Produces("application/json")
    @Path("/history/{accountId}")
    public Response getAccountHistory(@PathParam("accountId")Integer accountId )
    {
        try{
            System.out.println("Id konta: "+accountId);
            List<Banktransfer> accounts =  bankTransferDao.getListByAccountId(accountId);
            return Response.ok().entity(accounts).build();
        }catch(Exception e)
        {
            System.out.println("Authentication not found");
            System.out.println("Wyjątek przy pobieraniu historii transferów: "+e.toString());
            return Response.status(403).build();
        }
    }

}
