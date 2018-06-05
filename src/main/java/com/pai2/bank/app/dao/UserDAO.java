package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.UserEntity;
import com.pai2.bank.app.model.UserEntity;

import java.util.Set;

public interface UserDAO extends Dao<Integer,UserEntity>{

    public Set<UserEntity> getUserList();

}
