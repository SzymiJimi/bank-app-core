package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Investpaymentschedule;

import java.util.List;

public interface InvestpaymentscheduleDAO extends Dao <Integer, Investpaymentschedule> {
    List<Investpaymentschedule> findInvestpaymentscheduleByIdInvestment(Integer idInvestment);

}
