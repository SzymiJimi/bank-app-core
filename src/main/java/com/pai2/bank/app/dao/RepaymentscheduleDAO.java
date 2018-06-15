package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Repaymentschedule;

import java.util.List;

public interface RepaymentscheduleDAO extends Dao<Integer,Repaymentschedule> {
    public Repaymentschedule findRepaymentscheduleById(Integer idRepaymentschedule);
    public List<Repaymentschedule> findRepaymentSchedulesByIdCredit(Integer idCredit);
}
