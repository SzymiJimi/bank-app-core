package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.RememberDao;
import com.pai2.bank.app.model.Remember;
import com.pai2.bank.app.model.User;

import javax.ejb.Stateless;
import javax.persistence.Query;
@Stateless(name = "RememberDaoImpl", mappedName = "RememberDaoImpl")
public class RememberDaoImpl extends DaoImpl<Integer, Remember> implements RememberDao  {


    @Override
    public User findUserByUuid(String uuid) {
        try{
            Query query =getEntityManager().createNamedQuery("Remember.findUserByUuid");
            query.setParameter("uuid", uuid);
            return (User) query.getSingleResult();
        }catch(Exception e){
            System.out.println("Mamy wyjątek jakiś w Remember Dao...: "+e.toString());
            return null;
        }
    }


}
