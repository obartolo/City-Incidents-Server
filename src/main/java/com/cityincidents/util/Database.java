package com.cityincidents.util;

import com.cityincidents.base.Person;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Oscar on 05/05/2015.
 */
public class Database {

    public Database(){

    }

    public Person logIn(String email, String pass){
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Person Where email = '" + email + "' AND pass = '" + pass + "'" );

        Person person = (Person) query.uniqueResult();

        return person;
    }

    public void singIn(Person person){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

}
