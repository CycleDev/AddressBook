package com.javafxdemo.addressbook.service;

import com.javafxdemo.addressbook.repository.PersonRepository;
import com.javafxdemo.addressbook.view.PersonFactory;
import javafx.collections.ObservableList;
import com.javafxdemo.addressbook.view.PersonView;
import com.javafxdemo.addressbook.view.PersonViewFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ObservableList<PersonView> getAll() {
        return PersonViewFactory.from(personRepository.getAll());
    }

    public void save(PersonView person) {
        personRepository.save(PersonFactory.from(person));
    }

}
