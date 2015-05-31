package com.cityincidents.control;

import com.cityincidents.base.Incident;
import com.cityincidents.base.Person;
import com.cityincidents.util.Database;
import com.cityincidents.util.HibernateUtil;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class Control {

    @RequestMapping("/singin")
    public @ResponseBody boolean singin(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass){
        boolean ok;
        HibernateUtil.buildSessionFactory();

        Person person = new Person();
        person.setEmail(email);
        person.setPass(pass);
        ok = new Database().singIn(person);
        return ok;
    }

    @RequestMapping("/login")
    public Person login(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass){
        HibernateUtil.buildSessionFactory();

        Person person = new Database().logIn(email, pass);
        if (person == null){
            return new Person();
        }
        return person;
    }

    @RequestMapping("/getincidents")
    public List<Incident> getIncidents(){
        HibernateUtil.buildSessionFactory();

        List<Incident> incidents = new Database().getIncidents();

        if (incidents == null){
            incidents = new ArrayList<>();
        }

        return incidents;
    }

    @RequestMapping("/getmyincidents")
    public List<Incident> getMyIncidents(@RequestParam(value = "id") int id){
        HibernateUtil.buildSessionFactory();

        List<Incident> incidents = new Database().getMyIncidents(id);

        if (incidents == null){
            incidents = new ArrayList<>();
        }

        return incidents;
    }

    @RequestMapping("/getoneincidents")
    public Incident getOneIncidents(@RequestParam(value = "id") int id){
        HibernateUtil.buildSessionFactory();

        Incident incident = new Database().getOneIncidents(id);

        if (incident == null){
            incident = new Incident();
        }

        return incident;
    }

    @RequestMapping("/getnearincidents")
    public List<Incident> getNearIncidents(@RequestParam(value = "lat") double lat, @RequestParam(value = "long") double lon){
        HibernateUtil.buildSessionFactory();

        List<Incident> incidents = new Database().getNearIncidents(lat, lon);

        if (incidents == null){
            incidents = new ArrayList<>();
        }

        return incidents;
    }

    @RequestMapping("/addincident")
    public @ResponseBody boolean addIncident(@RequestParam(value = "title") String address, @RequestParam(value = "description") String description,
                               @RequestParam(value = "img")  String image, @RequestParam(value = "lat") String lat,
                               @RequestParam(value = "lon") String lon, @RequestParam(value = "id") int idPerson){
        HibernateUtil.buildSessionFactory();

        Incident incident = new Incident();
        incident.setTitle(address);
        incident.setDescription(description);
        incident.setImage(image);
        incident.setLatitude(lat);
        incident.setLongitude(lon);
        incident.setCreatedate(new Timestamp(new Date().getTime()));

        new Database().addIncident(incident, idPerson);

        return true;
    }

}
