package com.javafxdemo.addressbook.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogUtils {

    public static boolean confirm(String header, String message) {
        Alert alert = createAlert("Confirmation", header, message, Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> result = alert.showAndWait();
        return (result.get() == ButtonType.OK);
    }

    public static void warn(String title, String header, String message) {
        Alert alert = createAlert(title, header, message, Alert.AlertType.WARNING);
        alert.showAndWait();
    }

    public static void error(String title, String header, String message) {
        Alert alert = createAlert(title, header, message, Alert.AlertType.ERROR);
        alert.showAndWait();
    }

    private static Alert createAlert(String title, String header, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        return alert;
    }

}
