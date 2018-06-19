package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Bankaccountoffer;
import com.pai2.bank.app.model.Person;

public interface PersonDAO extends Dao<Integer,Person> {



//    public Set<Person> getPersonList();
    Person findPersonData(Integer userId);

    public void save(Person person);


}
