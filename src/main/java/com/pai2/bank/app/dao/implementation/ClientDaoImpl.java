package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.ClientDAO;
import com.pai2.bank.app.model.Client;
import com.pai2.bank.app.model.User;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless(name = "ClientDaoImpl", mappedName = "ClientDaoImpl")
public class ClientDaoImpl extends DaoImpl<Integer,Client> implements ClientDAO {


    @Override
    public Client findClientWithUserId(Integer userId) {
        try{
            System.out.println("User ID: "+ userId);

            Query query =getEntityManager().createNamedQuery("Client.findByIdUser");
            query.setParameter("idUser", userId);
            System.out.println( "Wynik: "+ query.getSingleResult());
            return (Client) query.getSingleResult();
        }catch(Exception e){
            System.out.println("Mamy wyjątek jakiś...: "+e.toString());
            return null;
        }

    }
}
