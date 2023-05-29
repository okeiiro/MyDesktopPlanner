package com.example.tppoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private static App app;

    public static void setI(int i) {
        HelloController.i = i;
    }

    public static int getI() {
        return i;
    }

    public static void setDate(LocalDate date) {
        HelloController.date = date;
    }

    public static LocalDate getDate() {
        return date;
    }

    private static LocalDate date;

    @FXML
    private Button valider;

    @FXML
    private Button creercreneau;
    @FXML
    private TextField hdfield;

    @FXML
    private TextField dureeminfield;

    public static Planning getPlan() {
        return plan;
    }

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

    protected static Utilisateur user;
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

        boolean dateValide = true;
        Creneau.setDureeMin(Integer.parseInt(dureeminfield.getText()));
        System.out.println("duree= " + Creneau.getDureeMin());

            LocalDate dateSaisie = LocalDate.of(year, month, day); // Obtenez la date saisie par l'utilisateur
            LocalDate dateSaisie2 = LocalDate.of(year2, month2, day2);
            LocalDate dateActuelle = LocalDate.now(); // Obtenez la date d'aujourd'hui

            if ((dateSaisie.isBefore(dateActuelle))||(dateSaisie2.isBefore(dateSaisie))) {
                dateValide = false;
            }


            if(!dateValide){
                // La date saisie est antérieure à la date d'aujourd'hui, affichez l'alerte
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Date invalide");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez saisir des dates valides.");

                alert.showAndWait();
            }




        else {
            plan = user.setPeriode(day, month, year, day2, month2, year2);
            plan.joursPlanning= new Journee[(int) plan.period];
            System.out.println(plan.period);

            Parent root = FXMLLoader.load(getClass().getResource("CreneauxLibres.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            i = 0;
            plan.creneauxlibres = new Creneau[(int) plan.period + 1];
            date = plan.datedebut;

        }




    }

    @FXML
    void suivant(ActionEvent event) {


    }





    @FXML
    void Start(ActionEvent event) {
        strt.setVisible(false);
        champseudo.setVisible(true);
        valider.setVisible(true);
        app= new App();
        Utilisateur[] users =app.start();
        app.setUtilisateurs(users);
    }


@Override
    public void initialize(URL location, ResourceBundle resources) {
        // Event handling code for scene initialization
        System.out.println("Scene is initialized");
        //strt.setVisible(true);
       // champseudo.setVisible(false);
      //  valider.setVisible(true);

        // Add your event handling logic here
    }




    
}

