package org.example.lab3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField contactField;

    @FXML
    private TextField postalField;

    @FXML
    private Text outputText;

    @FXML
    private Button btn;

    @FXML
    private Label outputLabel;

    @FXML
    public void initialize() {
        btn.setOnAction(event -> handleValidation());
    }

    public void handleValidation() {
        String name = nameField.getText();
        String contact = contactField.getText();
        String postal = postalField.getText();

        // Validate name
        boolean nameValid = name.matches("[A-Z][a-zA-Z]*");

        // Validate contact number
        boolean contactValid = contact.matches("\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{4}");

        // Validate postal code
        boolean postalValid = postal.matches("[A-Za-z]\\d[A-Za-z][-\\s]?\\d[A-Za-z]\\d");

        if (nameValid && contactValid && postalValid) {
            outputText.setText("All fields are valid.");
            // Display entered information in outputLabel
            outputLabel.setText("Name: " + name + "\nContact: " + contact + "\nPostal Code: " + postal);
        } else {
            outputText.setText("Some fields are invalid. Please check your input.");
            outputLabel.setText("");
        }
    }
}
