package nao.cycledev.addressbook.repository;

import nao.cycledev.addressbook.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PersonMemoryRepository implements PersonRepository {

    @Override
    public List<Person> getAll() {
        return Arrays.asList(
                new Person("Hans", "Muster", "hmuster"),
                new Person("Ruth", "Mueller", "rmueller"),
                new Person("Heinz", "Kurz", "hkurz"),
                new Person("Cornelia", "Meier", "cmeiner")
        );
    }

}
