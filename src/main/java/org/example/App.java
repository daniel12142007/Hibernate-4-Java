package org.example;

import org.example.entity.Cat;
import org.example.entity.Person;
import org.example.repository.CatRepository;
import org.example.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        CatRepository catRepository = new CatRepository();
        List<Person> list = new ArrayList<>();


        Person person = new Person("Daniel", 17);
        list.add(person);
        personRepository.save(person);
        Cat cat = new Cat();
        cat.setName("Cat");
        cat.setPerson(list);
        catRepository.save(cat);


        Person person1 = new Person("Daniel", 17);
        list.add(person1);
        personRepository.save(person1);
        Cat cat1 = new Cat();
        cat1.setName("Cat");
        cat1.setPerson1(person1);
        catRepository.save(cat1);


//        Person person1 = personRepository.findById(1L);
//        System.out.println(person1.getCat());
    }
}
// default
// OneToOne eager
// OneToMany lazy
// ManyToOne eager
// ManyToMany lazy