package com.cityincidents;

import com.cityincidents.util.HibernateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Created by Oscar on 01/05/2015.
 */

@SpringBootApplication
public class Server {
    public static void main(String[] args){
        SpringApplication.run(Server.class, args);
    }
}
