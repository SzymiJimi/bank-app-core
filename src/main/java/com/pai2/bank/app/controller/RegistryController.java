package com.pai2.bank.app.controller;

import com.pai2.bank.app.dao.PersonDAO;
import com.pai2.bank.app.model.Person;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Szymon on 19.06.2018.
 */
@Controller

@Path("person")
@Produces((MediaType.APPLICATION_JSON))
public class RegistryController {


        @EJB(beanInterface = PersonDAO.class , beanName = "PersonDAOImpl")
        private PersonDAO personDAO;


        @Path("new")
        @POST
        @Produces((MediaType.APPLICATION_JSON))
        @Consumes(MediaType.APPLICATION_JSON)
        public Response saveTest(Person person){

            System.out.println("dotarlem");
            personDAO.save(person);
            System.out.println("zapisalem" + person);
            return Response.ok(person).build();

        }
    }

