package com.pai2.bank.app.controller;


import com.pai2.bank.app.dao.CreditCardDao;
import com.pai2.bank.app.model.Creditcard;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Stateless
@Path("card")
@Produces({MediaType.APPLICATION_JSON})
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
            return Response.ok().entity(cards).build();
        }catch(Exception e)
        {
            System.out.println("Authentication not found");
            System.out.println(e.toString());
            return Response.status(403).build();
        }
    }


}
