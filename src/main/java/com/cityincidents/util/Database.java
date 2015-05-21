package com.cityincidents.util;

import com.cityincidents.base.Incident;
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
        //TODO y si hay dos
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Person Where email = '" + email + "' AND pass = '" + pass + "'" );

        Person person = (Person) query.uniqueResult();

        return person;
    }

    public boolean singIn(Person person){
        //TODO comprobar que no hay otro, si no devolver falso

        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public List<Incident> getIncidents(){
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Incident");

        List<Incident> incidents = query.list();

        return incidents;
    }

    public List<Incident> getNearIncidents(String lat, String lon){
        //TODO añadir where lat long sumando restando unas grados que habra que calcular
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Incident WHERE latitude = '" + lat + "' AND longitude = '" + lon + "'");

        List<Incident> incidents = query.list();

        return incidents;
    }

    public void addIncident(Incident incident){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(incident);
        session.getTransaction().commit();
        session.close();
    }
}
