package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.UserDAO;
import com.pai2.bank.app.model.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Stateless(name = "UserDaoImpl", mappedName = "AccountsDaoImpl")
public class UserDaoImpl extends DaoImpl<Integer, UserEntity> implements UserDAO {

    @Override
    public Set<UserEntity> getUserList(){
        Query query = getEntityManager().createQuery("SELECT e FROM UserEntity e ");
        return new HashSet<UserEntity>(query.getResultList());

    }
}
