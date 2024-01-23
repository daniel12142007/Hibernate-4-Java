package org.example.repository;

import org.example.config.DBConfig;
import org.example.entity.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CatRepository {
    private final SessionFactory sessionFactory = DBConfig.getSessionFactory();

    public void save(Cat person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public Cat findById(Long id) {
        Session session = sessionFactory.openSession();
        Cat person = session.get(Cat.class, id);
        session.close();
        return person;
    }

    public List<Cat> findAll() {
        Session session = sessionFactory.openSession();
        Query<Cat> query = session.createQuery("select p from Cat p");
        List<Cat> list = query.getResultList();
        session.close();
        return list;
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Cat person = session.get(Cat.class, id);
        session.delete(person);
        transaction.commit();
        session.close();
    }

    public void deleteAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> query = session.createQuery("delete from Cat p");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}