package com.example.tppoo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.tppoo.HelloController.*;

public class CreneauxLibresController implements Initializable {
    @FXML
    private Button creercreneau;

    @FXML
    private Button ajouterTacheButton;
    @FXML
    private Button terminer;


    @FXML
    private TextField hdfield;
    @FXML
    private TextField hffield;
    @FXML
    private Text dayDisplay;
    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<String> selectedTimesListView;

    private ObservableList<String> selectedTimes;

    @FXML

    void setCreneau(ActionEvent event) throws IOException {
        //dayDisplay.setText(String.valueOf(plan.datedebut));

        int p=(int)HelloController.getPlan().period;
        // Creneau[] creneauxlibres =new Creneau[p];
        if(getI()<p+1) {


            HelloController.getPlan().creneauxlibres[getI()]= new Creneau();
            HelloController.getPlan().creneauxlibres[getI()].setHeureDebut(LocalTime.parse(hdfield.getText()));
            HelloController.getPlan().creneauxlibres[getI()].setHeureFin(LocalTime.parse(hffield.getText()));
            HelloController.getPlan().creneauxlibres[getI()].setJour(getDate());
            try {
                if (!(HelloController.getPlan().creneauxlibres[getI()].verifDureeMin()))
            {
                System.out.println("durre");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Creneau invalide");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez saisir un créneau de durée superieure à la durée minimale.");

                alert.showAndWait();
                   }
            }catch (Exception e){

            }
            setDate( getDate().plusDays(1));
            System.out.println(getI());
            System.out.println(getDate());



            dayDisplay.setText(String.valueOf(getDate()));



        }

        if(getI()==p){
            terminer.setVisible(true);



        }





    }

    @FXML
    private TextField nomTacheField;

    @FXML
    private TextField prioriteTacheField;

    @FXML
    private TextField deadlineTacheField;
    @FXML
    private TextField dureeTacheField;



    @FXML
    private Text Numero;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Event handling code for scene initialization
        setI(0);
        nomTacheField.setVisible(false);
        dureeTacheField.setVisible(false);
        prioriteTacheComboBox.setVisible(false);
        deadlineTachePicker.setVisible(false);
        ajouterTacheButton.setVisible(false);
        decomposable.setVisible(false);
        couleurTachePicker.setVisible(false);
        numCr.setVisible(false);
        Numero.setVisible(false);
        categorieTacheField.setVisible(false);
        terminer.setVisible(false);


        dayDisplay.setText(String.valueOf(getPlan().datedebut));
        selectedTimes = FXCollections.observableArrayList();
        selectedTimesListView.setItems(selectedTimes);
       // nomTache.setVisible(true);
        // champseudo.setVisible(false);
        //  valider.setVisible(true);

        // Add your event handling logic here
        // Masquer les champs de texte et le bouton "Ajouter Tâche"

    }







    @FXML
    private void ajouterTache() {
        // Récupérer les valeurs des champs de texte et effectuer les actions nécessaires
        String nom = nomTacheField.getText();
        int duree = Integer.parseInt(dureeTacheField.getText());
        System.out.println("duree: "+duree);
        String priorite = prioriteTacheComboBox.getValue();
        String deadline = deadlineTachePicker.getEditor().getText();
        boolean decomp= decomposable.isSelected();
        setI(Integer.parseInt(numCr.getText()));

        // Créer une instance de la classe Tache avec les valeurs saisies
        HelloController.user.planificationManuelle(HelloController.getPlan(),nom,duree,priorite,deadline,decomp,getI());
        // Effectuer les actions supplémentaires nécessaires avec la nouvelle tâche

        // Réinitialiser les champs de texte
        nomTacheField.clear();
        dureeTacheField.clear();
        //prioriteTacheComboBox.clear();
        //deadlineTachePicker.;

    }




    @FXML
    private void addSelectedTime() {


        int p=(int)HelloController.getPlan().period;
        // Creneau[] creneauxlibres =new Creneau[p];
        if(getI()<p+1) {


            HelloController.getPlan().creneauxlibres[getI()]= new Creneau();
            HelloController.getPlan().creneauxlibres[getI()].setHeureDebut(LocalTime.parse(hdfield.getText()));
            HelloController.getPlan().creneauxlibres[getI()].setHeureFin(LocalTime.parse(hffield.getText()));
            HelloController.getPlan().creneauxlibres[getI()].setJour(getDate());
            setDate( getDate().plusDays(1));
            System.out.println(getI());
            System.out.println(getDate());



            dayDisplay.setText(String.valueOf(getDate()));



        }

        if(getI()==p){
            terminer.setVisible(true);



        }

        String selectedTime = getI() + " " + "Heure début: "+ HelloController.getPlan().creneauxlibres[getI()].getHeureDebut() + " Heure fin: "  + HelloController.getPlan().creneauxlibres[getI()].getHeureFin();
        selectedTimesListView.getItems().add(selectedTime + " (Date: " + HelloController.getPlan().creneauxlibres[getI()].getJour() + ")");
        setI(getI()+1);
    }

    @FXML
    private AnchorPane rootPane;




    // Other existing code...

    @FXML
    private DatePicker deadlineTachePicker;
    @FXML
    private ComboBox<String> prioriteTacheComboBox;

    @FXML
    private TextField categorieTacheField;
    @FXML
    private ColorPicker couleurTachePicker;
    @FXML
    private CheckBox decomposable;
    @FXML
    private TextField numCr;

    @FXML
    private Button planifierTacheButton;

    @FXML
    private void planifierTache(ActionEvent event) throws IOException {
        // Afficher les champs de texte et le bouton "Ajouter Tâche"


    }



    @FXML
    void suivant(ActionEvent event) {

        nomTacheField.setVisible(true);
        dureeTacheField.setVisible(true);
        prioriteTacheComboBox.setVisible(true);
        deadlineTachePicker.setVisible(true);
        ajouterTacheButton.setVisible(true);
        couleurTachePicker.setVisible(true);
        numCr.setVisible(true);
        Numero.setVisible(true);
        decomposable.setVisible(true);
        categorieTacheField.setVisible(true);
    }








}
