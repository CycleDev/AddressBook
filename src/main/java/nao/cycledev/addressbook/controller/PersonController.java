package nao.cycledev.addressbook.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import nao.cycledev.addressbook.service.PersonService;
import nao.cycledev.addressbook.view.PersonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
//@Scope("prototype")
public class PersonController {

    @Autowired
    private PersonService personService;

    @FXML
    private TableView<PersonView> personTable;
    @FXML
    private TableColumn<PersonView, String> userNameColumn;

    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label userName;

    public PersonController() {
    }

    @FXML
    private void initialize() {
        userNameColumn.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
        personTable.setItems(personService.getAll());
    }
}
