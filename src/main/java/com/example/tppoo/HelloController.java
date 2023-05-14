package com.example.tppoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    protected App app;
    private Stage stage;
    private Parent root;
    private Scene scene;

   // @FXML
    //private VBox scene;
   @FXML
   private Button switchToScene2;
    @FXML
    private Button strt;
    @FXML
    private TextField champseudo;

    @FXML

    private Label welcomeText;

    @FXML
    void retour(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



    @FXML
    void Start(ActionEvent event) {
        app= new App();
        Utilisateur[] users =app.start();
        app.setUtilisateurs(users);
    }


    @FXML
    void Authentification(ActionEvent event) throws IOException {

        String pseudo=champseudo.getText();
        app.authentification(pseudo,app.getUtilisateurs());
        Parent root= FXMLLoader.load(getClass().getResource("Calendar.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



}