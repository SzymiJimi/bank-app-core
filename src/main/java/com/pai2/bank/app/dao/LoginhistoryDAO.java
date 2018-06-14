package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Loginhistory;

import java.util.List;

public interface LoginhistoryDAO extends Dao<Integer,Loginhistory>  {
    public Loginhistory findLoginhistoryById(Integer idLoginhistory);
    public List<Loginhistory> findUsersLoginHistory(Integer idUser);
}
