package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.model.Credentials;
import com.pai2.bank.app.model.User;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

@Stateless(name = "UserDaoImpl", mappedName = "UserDaoImpl")
public class UserDaoImpl extends DaoImpl<Integer, User> implements UserDAO {

    @Override
    public Set<User> getUserList(){
        Query query = getEntityManager().createQuery("SELECT e FROM User e ");
        return new HashSet<User>(query.getResultList());

    }

    @Override
    public User findLoggingUser(Credentials credentials){
//        try{
            Query query =getEntityManager().createQuery("SELECT e FROM User e " +
                    "WHERE e.username='"+ credentials.getUsername()+"' AND e.password='"+ credentials.getPassword()+"'");
            return (User)query.getSingleResult();
//        }catch(Exception e){
//            System.out.println("Nieudane pobranie: "+e.toString());
//            return null;
//        }


    }
}
