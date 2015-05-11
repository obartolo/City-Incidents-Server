package com.cityincidents.control;

import com.cityincidents.base.Person;
import com.cityincidents.util.Database;
import com.cityincidents.util.HibernateUtil;
import org.hibernate.Query;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Oscar on 02/05/2015.
 */

@RestController
public class Control {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //request mapping es lo que recibes
    @RequestMapping("/singin")
    public boolean singin(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass){
        Person person = new Person();
        person.setEmail(String.format(template, email));
        person.setPass(String.format(template, pass));
        new Database().singIn(person);
        return true;
    }

    @RequestMapping("/login")
    public Person login(@RequestParam(value = "email") String email, @RequestParam(value = "pass") String pass){
        boolean ok = false;

        //Person person = new Database().logIn(String.format(template, email), String.format(template, pass));
        Person person = new Person();
        person.setEmail(String.format(template, email));
        person.setPass(String.format(template, pass));
        if (person == null){
            return null;
        }
        //TODO devolver el usuario¿?
        return person;
    }

}
