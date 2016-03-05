package nao.cycledev.addressbook.repository;

import nao.cycledev.addressbook.model.Person;

import java.util.List;

public interface PersonRepository {
    List<Person> getAll();
}
