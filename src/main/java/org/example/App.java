package org.example;

import org.example.entity.Person;
import org.example.repository.PersonRepository;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        personRepository.deleteAll();
    }
}
