package org.example.config;

import org.example.entity.Cat;
import org.example.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DBConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
            properties.setProperty(Environment.USER, "postgres");
            properties.setProperty(Environment.PASS, "root");
            properties.setProperty(Environment.SHOW_SQL, "true");
            properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
            properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.setProperty(Environment.HBM2DDL_AUTO, "create");
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Cat.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}