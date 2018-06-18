package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.LoginhistoryDAO;
import com.pai2.bank.app.model.Loginhistory;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "LoginhistoryDaoImpl", mappedName = "LoginhistoryDaoImpl")
public class LoginhistoryDaoImpl extends DaoImpl<Integer,Loginhistory> implements LoginhistoryDAO {
    @Override
    public Loginhistory findLoginhistoryById(Integer idLoginhistory) {
        try {
            System.out.println("Jestem DaoImpl");
            Query query = getEntityManager().createNamedQuery("Loginhistory.findByIdLoginHistory", Loginhistory.class);
            query.setParameter("idLoginHistory", idLoginhistory);
            return (Loginhistory) query.getSingleResult();
        }catch(Exception ex){
            return null;
        }

    }

    @Override
    public List<Loginhistory> findUsersLoginHistory(Integer idUser) {
        try {
            Query query = getEntityManager().createNamedQuery("Loginhistory.findByIdUser", Loginhistory.class);
            query.setParameter("idUser", idUser);
            return (List<Loginhistory>) query.getResultList();
        }catch (Exception ex) {
            return null;
        }
    }
}
