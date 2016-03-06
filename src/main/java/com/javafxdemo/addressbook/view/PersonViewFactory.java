package com.javafxdemo.addressbook.view;

import com.javafxdemo.addressbook.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class PersonViewFactory {

    public static PersonView from(Person person) {
        return new PersonView(person.getFirstName(),
                              person.getLastName(),
                              person.getUserName());
    }

    public static ObservableList<PersonView> from(List<Person> persons) {
        ObservableList<PersonView> views = FXCollections.observableArrayList();
        persons.forEach(p -> views.add(from(p)));

        return views;
    }

}
