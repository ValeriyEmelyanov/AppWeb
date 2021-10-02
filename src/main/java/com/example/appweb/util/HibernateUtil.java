package com.example.appweb.util;

import com.example.appweb.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * Factory of hibernate session factory.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        Properties settings = new Properties();
        settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        settings.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/appusers");
        settings.put("hibernate.connection.username", "postgres");
        settings.put("hibernate.connection.password", "postgres");
        settings.put("hibernate.hbm2ddl.auto", "update");
        settings.put("hibernate.show_sql", "true");

        Configuration configuration = new Configuration();
        configuration.setProperties(settings);
        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
