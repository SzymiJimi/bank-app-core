package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Remember;
import com.pai2.bank.app.model.User;

public interface RememberDao extends Dao<Integer,Remember> {

    public User findUserByUuid(String uuid);

}
