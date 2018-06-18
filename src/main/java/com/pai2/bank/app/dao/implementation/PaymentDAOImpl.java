package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.PaymentDAO;
import com.pai2.bank.app.model.Payment;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless(name = "PaymentDAOImpl", mappedName = "PaymentDAOImpl")

public class PaymentDAOImpl extends DaoImpl<Integer,Payment> implements PaymentDAO {
    @Override
    public Payment findPaymentById(Integer idPayment) {
        try{
            Query query = getEntityManager().createNamedQuery("Payment.findByIdPayment", Payment.class);
            query.setParameter("idPayment", idPayment);
            return (Payment) query.getSingleResult();

        }catch(Exception ex){
            return null;
        }
    }
}
