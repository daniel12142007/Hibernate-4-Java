package org.example.repository;

import org.example.config.DBConfig;
import org.example.entity.Person;
import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class PersonRepository {
    private final SessionFactory sessionFactory = DBConfig.getSessionFactory();

    public void save(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public Person findById(Long id) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    public List<Person> findAll() {
        Session session = sessionFactory.openSession();
        Query<Person> query = session.createQuery("select p from Person p");
        List<Person> list = query.getResultList();
        session.close();
        return list;
    }

    public void update(Long id, Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person1 = session.get(Person.class, id);
        person1.setName(person.getName());
        person1.setAge(person.getAge());
        session.update(person1);
        transaction.commit();
        session.close();
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.delete(person);
        transaction.commit();
        session.close();
    }

    public void deleteAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> query = session.createQuery("delete from Person p");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}