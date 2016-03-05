package nao.cycledev.addressbook.service;

import javafx.collections.ObservableList;
import nao.cycledev.addressbook.repository.PersonRepository;
import nao.cycledev.addressbook.view.PersonView;
import nao.cycledev.addressbook.view.PersonViewFactory;
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

}
