package com.javafxdemo.addressbook.repository;

import com.javafxdemo.addressbook.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonMemoryRepository implements PersonRepository {

    private List<Person> persons = new ArrayList(Arrays.asList(
            new Person("Hans", "Muster", "hmuster"),
            new Person("Ruth", "Mueller", "rmueller"),
            new Person("Heinz", "Kurz", "hkurz"),
            new Person("Cornelia", "Meier", "cmeiner")));

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public void save(Person person) {
        persons.add(person);
    }

}
