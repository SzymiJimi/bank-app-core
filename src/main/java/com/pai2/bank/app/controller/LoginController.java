package com.pai2.bank.app.controller;


import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.model.Credentials;
import com.pai2.bank.app.model.JsonMessage;
import com.pai2.bank.app.model.User;
import com.pai2.bank.app.service.AuthenticationService;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Path("login")
public class LoginController {

    @EJB(beanInterface = UserDAO.class, beanName = "UserDaoImpl")
    private UserDAO userDAO;

    @EJB(beanName = "AuthenticationService")
    AuthenticationService authenticationServiceImpl;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credentials credentials){
        System.out.println("Pobrany username:"+credentials.getUsername()+", hasło: "+credentials.getPassword());
        User loggedUser=  userDAO.findLoggingUser(credentials);
        if(loggedUser!=null){

            System.out.println("Logged USER : "+ loggedUser.getUsername()+", "+ loggedUser.getEmail());
            return Response.ok().entity(loggedUser).build();
        }else
        {
            System.out.println("User not foud");
            return Response.status(403).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response getUserAuthentications(@PathParam("userId")Integer userId )
    {

        JsonMessage response= authenticationServiceImpl.getUserAuth(userId);
        if(response.id!=-1){
            return Response.ok().entity(response).build();
        }else
        {
            System.out.println("Authentication not found");
            return Response.status(403).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/history")
    public Response saveSignIn(Integer userId){

//        if(loggedUser!=null){
//
//            System.out.println("Logged USER : "+ loggedUser.getUsername()+", "+ loggedUser.getEmail());
//            return Response.ok().entity(loggedUser).build();
//        }else
//        {
//            System.out.println("User not foud");
//            return Response.status(403).build();
//        }
        return null;
    }


}
