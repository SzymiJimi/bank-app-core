package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.ConsultantDAO;
import com.pai2.bank.app.model.Consultant;
import com.pai2.bank.app.model.User;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless(name = "ConsultantDaoImpl", mappedName = "ConsultantDaoImpl")
public class ConsultantDaoImpl extends DaoImpl<Integer,Consultant> implements ConsultantDAO {


    @Override
    public Consultant findConsultantWithUserId(Integer userId) {
        try{
            Query query =getEntityManager().createNamedQuery("Consultant.findByIdUser");
            query.setParameter("idUser", userId);
            return (Consultant) query.getSingleResult();
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
