package com.pai2.bank.app.controller;


import com.pai2.bank.app.dao.AccountTransferDao;
import com.pai2.bank.app.dao.AddressDao;
import com.pai2.bank.app.model.Address;
import com.pai2.bank.app.model.Creditcard;

import javax.ejb.EJB;
import javax.mvc.Controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Path("address")
    public class AddressController {



    @EJB(beanInterface = AddressDao.class, beanName = "AddressDaoImpl")
    private AddressDao addressDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/changeAddress")
    public Response getCreditCardsByBankAcc(Address address )
    {
        try{
            Address result=  addressDao.merge(address);
            return Response.ok().entity(result).build();
        }catch(Exception e)
        {
            System.out.println("Authentication not found");
            System.out.println(e.toString());
            return Response.status(403).build();
        }
    }
}
