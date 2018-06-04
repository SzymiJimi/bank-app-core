package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.User;

import java.util.Set;

public interface UserDAO extends Dao<Integer,User>{

    public Set<User> getUserList();

}
