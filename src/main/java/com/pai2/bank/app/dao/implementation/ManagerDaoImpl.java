package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.Dao;
import com.pai2.bank.app.dao.ManagerDAO;
import com.pai2.bank.app.model.Manager;
import com.pai2.bank.app.model.User;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless(name = "ManagerDaoImpl", mappedName = "ManagerDaoImpl")
public class ManagerDaoImpl extends DaoImpl<Integer,Manager> implements ManagerDAO {


    @Override
    public Manager findManagerWithUserId(Integer userId) {

        try{
            Query query =getEntityManager().createNamedQuery("Manager.findByIdUser");
            query.setParameter("idUser", userId);
            return (Manager) query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
}
