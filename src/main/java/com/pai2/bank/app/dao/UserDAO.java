package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Credentials;
import com.pai2.bank.app.model.User;

import java.util.Set;

public interface UserDAO extends Dao<Integer,User>{

    public Set<User> getUserList();
    User findLoggingUser(Credentials credentials);
    public void saveUser(User user);

}
