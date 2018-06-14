package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Payment;

public interface PaymentDAO extends Dao<Integer,Payment>  {
    public Payment findPaymentById(Integer idPayment);

}
