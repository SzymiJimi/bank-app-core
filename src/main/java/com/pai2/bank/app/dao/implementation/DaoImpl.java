package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.Dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.NotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class DaoImpl <K, E> implements Dao<K, E> {

    protected Class<E> entityClass;

    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext(unitName = "bank-app")
    private EntityManager entityManager;

    public DaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    @PostConstruct
    public void createEntityManager() {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("bank-app");
            entityManager = entityManagerFactory.createEntityManager();
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.toString());
        }

    }

    @PreDestroy
    private void closeEntityManager() {
        entityManager.close();
        entityManagerFactory.close();
    }


    /**
     * Deletes the entity.
     *
     * @param id entity
     * @throws NotFoundException if the entity does not exist in database.
     */
    @Override
    public E findById(K id) {
        E entity = getEntityManager().find(entityClass, id);
//        getEntityManager().clear();
        if (entity != null) {
            return entity;
        }
        return null;
    }

    /**
     * Finds all objects of an entity class.
     *
     * @return List with objects
     */
    @Override
    public Set<E> getAll() {
        Query query = getEntityManager().createQuery("from " + entityClass.getCanonicalName() + " e", entityClass);
        List<E> res = query.getResultList();

        return new HashSet<E>(res);
    }

    @Override
    public E merge(E entity)
    {
        try {
            getEntityManager().getTransaction().begin();
            entity = getEntityManager().merge(entity);
            getEntityManager().flush();
            getEntityManager().clear();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
        return entity;
    }


    @Override
    public E persist(E entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<E>> constraintViolations = validator.validate(entity);
        if(constraintViolations.size() > 0){
            Iterator<ConstraintViolation<E>> iterator = constraintViolations.iterator();
            while(iterator.hasNext()){
                ConstraintViolation<E> cv = iterator.next();
                System.err.println(cv.getRootBeanClass().getName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
            }

        }else{
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().flush();
            getEntityManager().clear();
            getEntityManager().getTransaction().commit();


//            getEntityManager().close();
        }
        return entity;
    }


    protected EntityManager getEntityManager() {
        return entityManager;
    }



}
