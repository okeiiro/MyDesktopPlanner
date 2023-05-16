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
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class HelloController {

    private static App app;
    private static LocalDate date;


    @FXML
    private TextField hdfield;
    @FXML
    private TextField hffield;
    @FXML
    private Text dayDisplay;

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Utilisateur getUser() {
        return user;
    }

    private static Utilisateur user;
    private static Planning plan;
    private static int i;
    private Stage stage;
    private Parent root;
    private Scene scene;

   // @FXML
    //private VBox scene;
   @FXML
   private Button confirm;

    @FXML
    private TextField dayfield;

    @FXML
    private TextField dayfield2;

    @FXML
    private TextField monthfield;

    @FXML
    private TextField monthfield2;

    @FXML
    private TextField yearfield;

    @FXML
    private TextField yearfield2;


   @FXML
   private Button switchToScene2;
    @FXML
    private Button strt;
    @FXML
    private TextField champseudo;

    @FXML

    private Label welcomeText;



    @FXML
    void Authentification(ActionEvent event) throws IOException {
        user= new Utilisateur();
        String pseudo=champseudo.getText();
        setUser(app.authentification(pseudo,app.getUtilisateurs()));

        Parent root= FXMLLoader.load(getClass().getResource("Calendar.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("pseudo="+getUser().pseudo);

    }





    @FXML
    void retour(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



    @FXML
    void periode(ActionEvent event) throws IOException {

        int day= Integer.parseInt(dayfield.getText());
        int month= Integer.parseInt(monthfield.getText());
        int year= Integer.parseInt(yearfield.getText());
        int day2= Integer.parseInt(dayfield2.getText());
        int month2= Integer.parseInt(monthfield2.getText());
        int year2= Integer.parseInt(yearfield2.getText());

        plan=user.setPeriode(day,month,year,day2,month2,year2);
        System.out.println(plan.period);

        Parent root= FXMLLoader.load(getClass().getResource("CreneauxLibres.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        i=0;
        plan.creneauxlibres =new Creneau[(int) plan.period];
        date= plan.datedebut;





    }


    @FXML
    void setCreneau(ActionEvent event) {
        //dayDisplay.setText(String.valueOf(plan.datedebut));

        int p=(int)plan.period;
       // Creneau[] creneauxlibres =new Creneau[p];
        if(i<p) {
            plan.creneauxlibres[i]= new Creneau();
            plan.creneauxlibres[i].setHeureDebut(LocalTime.parse(hdfield.getText()));
            plan.creneauxlibres[i].setHeureDebut(LocalTime.parse(hffield.getText()));
            plan.creneauxlibres[i].setJour(date);
            date = date.plusDays(1);
            System.out.println(i);
            System.out.println(date);

            dayDisplay.setText(String.valueOf(date));
            System.out.println(plan.creneauxlibres[i].getHeureDebut());
            i++;

        }
        }




    @FXML
    void Start(ActionEvent event) {
        app= new App();
        Utilisateur[] users =app.start();
        app.setUtilisateurs(users);
    }






}