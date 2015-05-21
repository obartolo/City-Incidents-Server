package com.cityincidents.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Oscar on 06/02/2015.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;

    /**
     * Crea la factoria de sesiones
     */
    public static void buildSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Abre una nueva sesión
     */
    public static void openSession() {

        session = sessionFactory.openSession();
    }

    /**
     * Devuelve la sesión actual
     * @return
     */
    public static Session getCurrentSession() {
        if (session == null)
            openSession();

        if (!session.isOpen())
            openSession();

        return session;
    }

    /**
     * Cierra Hibernate
     */
    public static void closeSessionFactory() {

        if (session != null)
            session.close();

        if (sessionFactory != null)
            sessionFactory.close();
    }
}
