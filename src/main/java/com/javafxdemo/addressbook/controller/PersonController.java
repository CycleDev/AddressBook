package com.javafxdemo.addressbook.controller;

import com.javafxdemo.addressbook.utils.DialogUtils;
import com.javafxdemo.addressbook.utils.SpringFxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.javafxdemo.addressbook.service.PersonService;
import com.javafxdemo.addressbook.view.PersonView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
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

    private Stage primaryStage;

    public PersonController() {
    }

    @FXML
    private void initialize() {
        userNameColumn.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());
        personTable.setItems(personService.getAll());

        showPersonDetails(null);

        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));

        personTable.getSelectionModel().select(0);
    }

    @FXML
    private void handleNewPerson() {
        PersonView person = new PersonView();
        boolean okClicked = showPersonEditDialog(person);
        if (okClicked) {
            personService.save(person);
            personTable.getItems().add(person);
            personTable.getSelectionModel().select(person);
        }
    }

    @FXML
    private void handleEditPerson() {
/*        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }*/
    }


    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();

        if (selectedIndex >=0) {
            if(DialogUtils.confirm("Remove Person", "Do you want remove person?")) {
                personTable.getItems().remove(selectedIndex);
            }
        } else {
            DialogUtils.warn("No Selection", "No Person Selected", "Please select a person in the table.");
        }
    }

    public boolean showPersonEditDialog(PersonView person) {
        SpringFxmlLoader springFxmlLoader = new SpringFxmlLoader();
        AnchorPane page = (AnchorPane)springFxmlLoader.load("/fxml/personEditDialog.fxml");

        Stage dialogStage = new Stage();
        dialogStage.setTitle("New/Edit Person");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        PersonEditDialogController controller = springFxmlLoader.getLoader().getController();
        controller.setDialogStage(dialogStage);
        controller.setPerson(person);

        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    private void showPersonDetails(PersonView person) {
        if (person == null) {
            firstName.setText("");
            lastName.setText("");
            userName.setText("");
        } else {
            firstName.setText(person.getFirstName());
            lastName.setText(person.getLastName());
            userName.setText(person.getUserName());
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
