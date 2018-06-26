package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Manager;
import com.pai2.bank.app.model.User;

public interface ManagerDAO extends Dao<Integer,Manager> {

    Manager findManagerWithUserId(Integer userId);
    public void saveManager(Manager manager);
}
