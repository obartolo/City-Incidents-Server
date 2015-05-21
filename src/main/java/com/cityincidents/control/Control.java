package com.cityincidents.control;

import com.cityincidents.base.Incident;
import com.cityincidents.base.Person;
import com.cityincidents.util.Database;
import com.cityincidents.util.HibernateUtil;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Oscar on 02/05/2015.
 */

@RestController
public class Control {

    @RequestMapping("/singin")
    public boolean singin(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass){
        boolean ok;
        HibernateUtil.buildSessionFactory();//TODO esto no va aqui

        Person person = new Person();
        person.setEmail(email);
        person.setPass(pass);
        ok = new Database().singIn(person);
        return ok;
    }

    @RequestMapping("/login")
    public Person login(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass){
        HibernateUtil.buildSessionFactory();//TODO esto no va aqui

        Person person = new Database().logIn(email, pass);
        if (person == null){
            return new Person();
        }
        return person;
    }

    @RequestMapping("/getincidents")
    public List<Incident> getIncidents(){
        HibernateUtil.buildSessionFactory();//TODO esto no va aqui

        List<Incident> incidents = new Database().getIncidents();

        if (incidents == null){
            incidents = new ArrayList<>();
        }

        return incidents;
    }

    @RequestMapping("/getnearincidents")
    public List<Incident> getNearIncidents(@RequestParam(value = "lat") String lat, @RequestParam(value = "long") String lon){
        HibernateUtil.buildSessionFactory();//TODO esto no va aqui

        List<Incident> incidents = new Database().getNearIncidents(lat, lon);

        if (incidents == null){
            incidents = new ArrayList<>();
        }

        return incidents;
    }

    @RequestMapping("/addincident")
    public boolean addIncident(@RequestParam(value = "address") String address, @RequestParam(value = "description") String description,
                               @RequestParam(value = "img") byte[] img, @RequestParam(value = "lat") String lat,
                               @RequestParam(value = "lon") String lon){

        Incident incident = new Incident();
        incident.setAddress(address);
        incident.setDescription(description);
        incident.setImage(img);
        incident.setLatitude(lat);
        incident.setLongitude(lon);
        incident.setCreatedate(new Timestamp(new Date().getTime()));

        new Database().addIncident(incident);

        //TODO comprobar que se ha creado
        return true;
    }


}
