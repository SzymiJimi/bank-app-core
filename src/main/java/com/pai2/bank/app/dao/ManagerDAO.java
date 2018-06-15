package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Manager;

public interface ManagerDAO extends Dao<Integer,Manager> {

    Manager findManagerWithUserId(Integer userId);

}
