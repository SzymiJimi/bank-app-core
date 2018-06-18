package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.RepaymentscheduleDAO;
import com.pai2.bank.app.model.Repaymentschedule;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "RepaymentscheduleDaoImpl", mappedName = "RepaymentscheduleDaoImpl")

public class RepaymentscheduleDaoImpl extends DaoImpl<Integer, Repaymentschedule> implements RepaymentscheduleDAO {

    @Override
    public Repaymentschedule findRepaymentscheduleById(Integer idRepaymentschedule) {
        try {
            Query query = getEntityManager().createNamedQuery("Repaymentschedule.findByIdRepaymentSchedule", Repaymentschedule.class);
            query.setParameter("idRepaymentSchedule", idRepaymentschedule);
            return (Repaymentschedule) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<Repaymentschedule> findRepaymentSchedulesByIdCredit(Integer idCredit) {
        try{
            Query query = getEntityManager().createNamedQuery("Repaymentschedule.findByIdCredit", Repaymentschedule.class);
            query.setParameter("idCredit", idCredit);
            return (List<Repaymentschedule>)query.getResultList();
        }
        catch (Exception ex) {
            return null;
        }
    }
}
