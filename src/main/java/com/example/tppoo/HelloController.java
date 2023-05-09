package com.example.tppoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HelloController {

    protected Application app;


    @FXML
    private VBox scene;
    @FXML
    private Button strt;
    @FXML
    private TextField champseudo;

    @FXML
    private Label welcomeText;


    @FXML
    void Start(ActionEvent event) {
        app= new Application();
        Utilisateur[] users =app.start();
        app.utilisateurs=users;
    }


    @FXML
    void Authentification(ActionEvent event) {

        String pseudo=champseudo.getText();
        app.authentification(pseudo,app.utilisateurs);


    }

}
