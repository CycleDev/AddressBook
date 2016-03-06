package com.javafxdemo.addressbook.repository;

import com.javafxdemo.addressbook.model.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> getAll();
    void save(Person person);
}
