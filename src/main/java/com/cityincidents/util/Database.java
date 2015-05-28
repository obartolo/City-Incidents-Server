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
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Person Where email = '" + email + "' AND pass = '" + pass + "'" );

        Person person;

        List<Person> personList = query.list();
        if (query.list().size() == 0){
            return null;
        }
        person = personList.get(0);

        return person;
    }

    public boolean singIn(Person person){
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Person Where email = '" + person.getEmail() + "'");

        if (query.list().size() >= 1){
            return false;
        }

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

    public List<Incident> getMyIncidents(int id){
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Incident WHERE id_person.id = " + id);

        List<Incident> incidents = query.list();

        return incidents;
    }

    public Incident getOneIncidents(int id){
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Incident WHERE id = " + id);

        List<Incident> incidents = query.list();

        return incidents.get(0);
    }

    public List<Incident> getNearIncidents(double lat, double lon){
        double latTop = lat - 2;
        double latBotton = lat + 2;
        double lonTop = lon - 2;
        double lonBotton = lon + 2;

        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Incident WHERE latitude BETWEEN  " + latTop + " AND " + latBotton + " AND longitude BETWEEN " + lonTop + " AND " + lonBotton);
        List<Incident> incidents = query.list();

        return incidents;
    }

    public void addIncident(Incident incident, int idPerson){
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Person Where id = " + idPerson);

        List<Person> personList = query.list();

        if (personList.size() != 0){
            incident.setId_person(personList.get(0));
        }


        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(incident);
        session.getTransaction().commit();
        session.close();
    }
}
