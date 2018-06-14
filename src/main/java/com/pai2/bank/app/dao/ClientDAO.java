package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Client;
import com.pai2.bank.app.model.User;

public interface ClientDAO extends Dao<Integer,Client> {

    Client findClientWithUserId(Integer userId);


}
