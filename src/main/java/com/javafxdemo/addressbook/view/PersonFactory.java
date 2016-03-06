package com.javafxdemo.addressbook.view;

import com.javafxdemo.addressbook.model.Person;

public class PersonFactory {

    public static Person from(PersonView person) {
        return new Person(person.getFirstName(),
                          person.getLastName(),
                          person.getUserName());
    }

}
