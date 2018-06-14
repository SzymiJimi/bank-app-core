package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.PersonDAO;
import com.pai2.bank.app.model.Person;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless(name = "PersonDAOImpl", mappedName = "PersonDaoImpl")
public class PersonDAOImpl extends DaoImpl<Integer, Person> implements PersonDAO {

    @Override
    public Person findPersonData(Integer userId){

        return null;
    }

    @Override
    public Person findPersonByPeselNumber(String peselNumber) {
        try{
            Query query = getEntityManager().createNamedQuery("Person.findByPeselNumber", Person.class);
            query.setParameter("peselNumber", peselNumber);
            return (Person) query.getSingleResult();
        }catch (Exception ex){
            return null;
        }
    }

}
