package com.example.tppoo;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class TacheController {
    @FXML
    private TableView<Creneau> creneauTableView;
    @FXML
    private TableColumn<?, ?> heuredebutColumn;

    @FXML
    private TableColumn<?, ?> heurefinColumn;

    @FXML
    private TableColumn<?, ?> jourColumn;
    @FXML
    private TextField nomField;
    @FXML
    private TextField dureeField;
    @FXML
    private TextField prioriteField;

    @FXML
    private TextField deadlineField;


    private ObservableList<Creneau> creneauxList;
    @FXML
    void AfficherCreneau(ActionEvent event) throws IOException {

        jourColumn.setCellValueFactory(new PropertyValueFactory<>("jour"));
        heuredebutColumn.setCellValueFactory(new PropertyValueFactory<>("heuredebut"));
        heurefinColumn.setCellValueFactory(new PropertyValueFactory<>("heurefin"));

        // Assuming you have the creneauxlibres array
        for (int i = 0; i < HelloController.getPlan().creneauxlibres.length; i++) {
            creneauxList.add(HelloController.getPlan().creneauxlibres[i]);
        }

        creneauTableView.setItems(creneauxList);
    }

    // Rest of the controller code



    // Rest of the controller code

/*
        Parent root= FXMLLoader.load(getClass().getResource("Planner.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        */





    @FXML
    private void ajouterTache() {
        // Récupérer les valeurs des champs de texte et effectuer les actions nécessaires
        String nom = nomField.getText();
        int duree = Integer.parseInt(dureeField.getText());
        String priorite = prioriteField.getText();
        String deadline = deadlineField.getText();

        // Créer une instance de la classe Tache avec les valeurs saisies
        Tache tache = new Tache(nom, duree, priorite, deadline);

        // Effectuer les actions supplémentaires nécessaires avec la nouvelle tâche
        Utilisateur user= HelloController.user;
       // Tache task = new Tache(nom, duree, priorite, deadline, category, user);
       // user.ajoutertache(tache,);
        // Réinitialiser les champs de texte
        nomField.clear();
        dureeField.clear();
        prioriteField.clear();
        deadlineField.clear();
    }

}
