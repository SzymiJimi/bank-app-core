package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Consultant;

public interface ConsultantDAO extends Dao<Integer,Consultant> {

    Consultant findConsultantWithUserId(Integer userId);


}
