package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.InvesttinstalmentpaymentDAO;
import com.pai2.bank.app.model.Investtinstalmentpayment;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless(name = "InvesttinstalmentpaymentDaoImpl", mappedName = "InvesttinstalmentpaymentDaoImpl")
public class InvesttinstalmentpaymentDaoImpl extends DaoImpl <Integer, Investtinstalmentpayment> implements InvesttinstalmentpaymentDAO {
    @Override
    public Investtinstalmentpayment findInvesttinstalmentpaymentById(Integer idInvesttinstalmentpayment) {
        try {
            Query query = getEntityManager().createNamedQuery("Investtinstalmentpayment.findByIdInvestInstalmentPayment", Investtinstalmentpayment.class);
            query.setParameter("idInvestInstalmentPayment", idInvesttinstalmentpayment);
            return (Investtinstalmentpayment) query.getSingleResult();
        }catch (Exception ex) {
            return null;
        }
    }
}
