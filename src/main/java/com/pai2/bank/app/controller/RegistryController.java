package com.pai2.bank.app.controller;

import com.pai2.bank.app.dao.*;
import com.pai2.bank.app.dao.implementation.*;
import com.pai2.bank.app.model.*;
import com.pai2.bank.app.service.AuthenticationService;
import com.pai2.bank.app.service.TransferAuthenticationService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Szymon on 19.06.2018.
 */
@Controller
@Path("person")
public class RegistryController {

    @Inject
    TransferAuthenticationService transferAuthenticationService;

        @EJB(beanInterface = PersonDAO.class , beanName = "PersonDAOImpl")
        private PersonDAO personDAO;

        @EJB(beanInterface = UserDAO.class , beanName = "UserDaoImpl")
        private UserDAO userDAO;

       @EJB(beanInterface = ClientDAO.class, beanName = "ClientDaoImpl")
        private ClientDAO clientDAO;

       @EJB(beanInterface = BankAccountDao.class, beanName = "BankAccountDaoImpl")
       private  BankAccountDao bankAccountDao;

       @EJB(beanInterface = CreditCardDao.class, beanName = "CreditCardDaoImpl")
       private CreditCardDao creditCardDao;

        @Path("new")
        @POST
        @Produces((MediaType.APPLICATION_JSON))
        @Consumes("application/json")
        public Response saveTest(Person person){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.now();
            String date = dtf.format(localDate);
            System.out.println("dotarlem");
             Person person1 = new Person();
            person1.setName("tadek");
            Person savedPerson = personDAO.persist(person);
 //           Person tmp = person.getIdPerson();
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


    @Path("save")
    @POST
    @Produces((MediaType.APPLICATION_JSON))
    @Consumes((MediaType.APPLICATION_JSON))
    public Response saveToDb(User user){
        System.out.println("dotarlem");
        User savedUser = userDAO.persist(user);
        Client client = new Client();

        client.setIdUser(savedUser);
        System.out.println("zapisalem" );
        return Response.ok(client).build();


    }

    @Path("client")
    @POST
    @Produces((MediaType.APPLICATION_JSON))
    @Consumes((MediaType.APPLICATION_JSON))
    public Response saveCLient(Client client){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        System.out.println("dodawanie clienta");
        Client savedClient = clientDAO.persist(client);
        Bankaccountoffer bankaccountoffer = new Bankaccountoffer();
        bankaccountoffer.setIdBankAccountOffer(1);
        Bankaccount bankaccount = new Bankaccount();
        bankaccount.setIdClient(savedClient);
        bankaccount.setAccountNumber(transferAuthenticationService.generateBankAccount());
        bankaccount.setIdBankAccountOffer(bankaccountoffer);
        bankaccount.setCreationDate(date);
        bankaccount.setState("ACTIVE");
        Bankaccount savedBankAccount =  bankAccountDao.persist(bankaccount);
        Creditcard creditcard = new Creditcard();
        creditcard.setName("MasterCard");
        creditcard.setCreditCardNumber(transferAuthenticationService.generateCreditCardNumber());
        creditcard.setPinCode(transferAuthenticationService.generatePinCode());
        creditcard.setState("ACTIVE");
        creditcard.setExpirationDate(date+1);
        creditcard.setType("Płatnicza");
        creditcard.setIdBankAccount(savedBankAccount);
        creditCardDao.persist(creditcard);
        System.out.println("karta kredytowa " +creditcard);
        System.out.println(bankaccount);
        System.out.println("zapisałem clienta " +client);
        return Response.ok(client).build();
    }




    }

