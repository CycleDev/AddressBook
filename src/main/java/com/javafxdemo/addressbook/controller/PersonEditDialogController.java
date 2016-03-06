package com.javafxdemo.addressbook.controller;

import com.javafxdemo.addressbook.utils.DialogUtils;
import com.javafxdemo.addressbook.view.PersonView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;


@Controller
public class PersonEditDialogController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField userName;

    private Stage dialogStage;
    private PersonView person;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(PersonView person) {
        this.person = person;

        firstName.setText(person.getFirstName());
        lastName.setText(person.getLastName());
        userName.setText(person.getUserName());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstName.getText());
            person.setLastName(lastName.getText());
            person.setUserName(userName.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (userName.getText() == null || userName.getText().length() == 0) {
            errorMessage += "No valid user name!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            DialogUtils.error("Error", "Invalid Fields", "Please correct invalid fields");
            return false;
        }
    }
}
