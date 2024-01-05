package com.javafx.navesgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class JuegoController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}