package nao.cycledev.addressbook.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nao.cycledev.addressbook.model.Person;

import java.util.List;

public class PersonViewFactory {

    public static PersonView from(Person person) {
        return new PersonView(person.getFirstName(),
                              person.getFirstName(),
                              person.getUserName());
    }

    public static ObservableList<PersonView> from(List<Person> persons) {
        ObservableList<PersonView> views = FXCollections.observableArrayList();
        persons.forEach(p -> views.add(from(p)));

        return views;
    }

}
