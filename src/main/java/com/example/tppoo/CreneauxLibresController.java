package com.example.tppoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import static com.example.tppoo.HelloController.*;

public class CreneauxLibresController implements Initializable {
    @FXML
    private Button creercreneau;
    @FXML
    private TextField hdfield;
    @FXML
    private TextField hffield;
    @FXML
    private Text dayDisplay;
    private Stage stage;
    private Scene scene;


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
            setDate( getDate().plusDays(1));
            System.out.println(getI());
            System.out.println(getDate());


            setI(getI()+1);
            dayDisplay.setText(String.valueOf(getDate()));

        }

        if(getI()==p){
            creercreneau.setVisible(true);



        }



    }




    @FXML
    void AfficherCreneau(ActionEvent event) throws IOException {

        for (Creneau element : HelloController.getPlan().creneauxlibres) {
            System.out.println("jour: "+element.getJour()+" de "+element.getHeureDebut()+"à "+element.getHeureFin());
        }

        Parent root= FXMLLoader.load(getClass().getResource("Planner.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Event handling code for scene initialization
        dayDisplay.setText(String.valueOf(getPlan().datedebut));
        //strt.setVisible(true);
        // champseudo.setVisible(false);
        //  valider.setVisible(true);

        // Add your event handling logic here
    }




}
