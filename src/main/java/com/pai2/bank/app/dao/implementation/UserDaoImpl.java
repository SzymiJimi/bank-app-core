package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.model.User;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Stateless(name = "UserDaoImpl", mappedName = "AccountsDaoImpl")
public class UserDaoImpl extends DaoImpl<Integer, User> implements UserDAO {

    @Override
    public Set<User> getUserList(){
//        Query query = getEntityManager().createQuery("FROM " +entityClass.getCanonicalName()+ " e");
//        return new HashSet<User>(query.getResultList());
        return null;
    }
}
