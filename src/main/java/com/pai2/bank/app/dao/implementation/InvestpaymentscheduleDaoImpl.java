package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.InvestpaymentscheduleDAO;
import com.pai2.bank.app.model.Investpaymentschedule;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "InvestpaymentscheduleDaoImpl", mappedName = "InvestpaymentscheduleDaoImpl")
public class InvestpaymentscheduleDaoImpl extends DaoImpl<Integer, Investpaymentschedule> implements InvestpaymentscheduleDAO {
    @Override
    public List<Investpaymentschedule> findInvestpaymentscheduleByIdInvestment(Integer idInvestment) {
        try {
            Query query = getEntityManager().createNamedQuery("Investpaymentschedule.findByIdInvestment", Investpaymentschedule.class);
            query.setParameter("idInvestment", idInvestment);
            return (List<Investpaymentschedule>) query.getResultList();
        }catch(Exception ex){
            return null;
        }

    }
}
