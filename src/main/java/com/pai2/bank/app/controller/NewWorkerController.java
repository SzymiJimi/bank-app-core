package com.pai2.bank.app.controller;

import com.pai2.bank.app.dao.ConsultantDAO;
import com.pai2.bank.app.dao.ManagerDAO;
import com.pai2.bank.app.dao.PersonDAO;
import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.dao.implementation.ConsultantDaoImpl;
import com.pai2.bank.app.dao.implementation.ManagerDaoImpl;
import com.pai2.bank.app.dao.implementation.PersonDAOImpl;
import com.pai2.bank.app.model.*;
import com.pai2.bank.app.service.TransferAuthenticationService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Szymon on 23.06.2018.
 */
@Controller
@Path("worker")
public class NewWorkerController {

        @Inject
    TransferAuthenticationService transferAuthenticationService;

        @EJB(beanInterface = PersonDAO.class, beanName = "PersonDAOImpl")
        private PersonDAO personDAO;

        @EJB(beanInterface = UserDAO.class , beanName = "UserDaoImpl")
        private UserDAO userDAO;

    @EJB(beanInterface = ManagerDAO.class , beanName = "ManagerDaoImpl")
    private ManagerDAO managerDAO;
    @EJB(beanInterface = ConsultantDAO.class , beanName = "ConsultantDaoImpl")
    private ConsultantDAO consultantDAO;

    @Path("new")
    @POST
    @Produces((MediaType.APPLICATION_JSON))
    @Consumes("application/json")
    public Response saveTest(Person person){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        System.out.println("dotarlem");
        Person savedPerson = personDAO.persist(person);
        User user = new User();
        user.setIdPerson(savedPerson);
        user.setUsername(transferAuthenticationService.generateCode());
        user.setEmail(transferAuthenticationService.generateEmail());
        user.setPassword(transferAuthenticationService.generateCode());
        user.setRegisterDate("");
        user.setRegisterDate(date);
        System.out.println(user.getUsername() + user.getPassword());

        return Response.ok(user).build();


    }


    @Path("savemanager")
    @POST
    @Produces((MediaType.APPLICATION_JSON))
    @Consumes((MediaType.APPLICATION_JSON))
    public Response saveToDb(User user){
        System.out.println("dotarlem");
        User savedUser = userDAO.persist(user);
        Manager manager = new Manager();

        manager.setIdUser(savedUser);
        System.out.println("zapisalem" );
        return Response.ok(manager).build();


    }

    @Path("manager")
    @POST
    @Produces((MediaType.APPLICATION_JSON))
    @Consumes((MediaType.APPLICATION_JSON))
    public Response saveManager(Manager manager){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        System.out.println("dodawanie clienta");

        managerDAO.persist(manager);


        System.out.println("zapisałem menagera " +manager);
        return Response.ok(manager).build();
    }

    @Path("saveconsultant")
    @POST
    @Produces((MediaType.APPLICATION_JSON))
    @Consumes((MediaType.APPLICATION_JSON))
    public Response saveToDbCon(User user){
        System.out.println("dotarlem");
        User savedUser = userDAO.persist(user);
        Consultant consultant = new Consultant();

        consultant.setIdUser(savedUser);
        System.out.println("zapisalem" );
        return Response.ok(consultant).build();


    }

    @Path("consultant")
    @POST
    @Produces((MediaType.APPLICATION_JSON))
    @Consumes((MediaType.APPLICATION_JSON))
    public Response saveConsultant(Consultant consultant){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        System.out.println("dodawanie clienta");

        consultantDAO.persist(consultant);


        System.out.println("zapisałem consultanta " +consultant);
        return Response.ok(consultant).build();
    }


}
