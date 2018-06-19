package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.PersonDAO;
import com.pai2.bank.app.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "PersonDAOImpl", mappedName = "PersonDaoImpl")
public class PersonDAOImpl extends DaoImpl<Integer, Person> implements PersonDAO {

    @Override
    public Person findPersonData(Integer userId){

        return null;
    }
    @PersistenceContext(unitName = "bank-app")
    private EntityManager entityManager;



    public void save(Person person) {
        entityManager.persist(person);
    }

}
