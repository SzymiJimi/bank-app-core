package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.PersonDAO;
import com.pai2.bank.app.model.Person;

import javax.ejb.Stateless;

@Stateless(name = "PersonDAOImpl", mappedName = "PersonDaoImpl")
public class PersonDAOImpl extends DaoImpl<Integer, Person> implements PersonDAO {

    @Override
    public Person findPersonData(Integer userId){

        return null;
    }

}
