package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Investtinstalmentpayment;

public interface InvesttinstalmentpaymentDAO extends Dao<Integer,Investtinstalmentpayment> {
    public Investtinstalmentpayment findInvesttinstalmentpaymentById(Integer idInvesttinstalmentpayment);
}
