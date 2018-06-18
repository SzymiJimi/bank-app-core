package com.pai2.bank.app.service;

import com.pai2.bank.app.dao.ClientDAO;
import com.pai2.bank.app.dao.ConsultantDAO;
import com.pai2.bank.app.dao.ManagerDAO;
import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.model.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "AuthenticationService", mappedName = "AuthenticationService")
public class AuthenticationService {

    public static String MANAGER="MANAGER";
    public static String CONSULTANT="CONSULTANT";
    public static String CLIENT="CLIENT";

    @EJB(beanInterface = ClientDAO.class, beanName = "ClientDaoImpl")
    private ClientDAO clientDAO;

    @EJB(beanInterface = ManagerDAO.class, beanName = "ManagerDaoImpl")
    private ManagerDAO managerDAO;

    @EJB(beanInterface = ConsultantDAO.class, beanName = "ConsultantDaoImpl")
    private ConsultantDAO consultantDAO;



    public JsonMessage getUserAuth(Integer userId){

        Manager manager = managerDAO.findManagerWithUserId(userId);
            if(manager!=null)
            {
                return new JsonMessage( AuthenticationService.MANAGER, manager.getIdManager());
            }else{
                Consultant consultant = consultantDAO.findConsultantWithUserId(userId);
                if(consultant!=null)
                {
                    return new JsonMessage( AuthenticationService.CONSULTANT, consultant.getIdConsultant());
                }else{
                    Client client = clientDAO.findClientWithUserId(userId);
                    if(client!= null)
                    {
                        return new JsonMessage( AuthenticationService.CLIENT, client.getIdClient());

                    }
                    return new JsonMessage( AuthenticationService.CLIENT, -1);
                }
            }


    }


}
