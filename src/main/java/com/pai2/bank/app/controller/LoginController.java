package com.pai2.bank.app.controller;


import com.pai2.bank.app.dao.RememberDao;
import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.model.Credentials;
import com.pai2.bank.app.model.JsonMessage;
import com.pai2.bank.app.model.Remember;
import com.pai2.bank.app.model.User;
import com.pai2.bank.app.service.AuthenticationService;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@Path("login")
public class LoginController {


    @Context protected HttpServletRequest request;

    @EJB(beanInterface = UserDAO.class, beanName = "UserDaoImpl")
    protected UserDAO userDAO;

    @EJB(beanInterface = RememberDao.class, beanName = "RememberDaoImpl")
    protected RememberDao rememberDao;

    @EJB(beanName = "AuthenticationService")
    AuthenticationService authenticationServiceImpl;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUserRemember(@CookieParam("uuid") Cookie uuid){
        if(request.getSession(false)==null){

            return Response.status(403).build();

        }else {
            User loggedUser = rememberDao.findUserByUuid(uuid.getValue());
            if(loggedUser!=null)
            {
                return Response.ok().entity(loggedUser).build();
            }else{
                return Response.status(403).build();
            }

        }
    }


    @GET
    @Path("/out")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@CookieParam("uuid") Cookie uuid){
        HttpSession session= request.getSession(false);
        if(session==null){

            return Response.status(403).build();

        }else {
            session.invalidate();
            NewCookie cookie1 = new NewCookie("uuid", "00" ,uuid.getPath(), uuid.getDomain(), "",-1, false);
                return Response.ok().cookie(cookie1).build();
            }

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser( Credentials credentials){
        User loggedUser=  userDAO.findLoggingUser(credentials);

        String uuid = UUID.randomUUID().toString();

        if(loggedUser!=null){
            request.getSession();
            Remember remember = new Remember(uuid, loggedUser);
            System.out.println(remember);
            userDAO.persist(loggedUser);
            Remember saved = rememberDao.persist(remember);
            NewCookie cookie = new NewCookie("uuid", uuid);
            return Response.ok().cookie(cookie).entity(loggedUser).build();
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


}
