package com.example.tppoo;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.tppoo.Priorite.*;

public class Tache {
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEtat(EtatTache etat) {
        this.etat = etat;
    }

    private EtatTache etat;

    private Categorie cat;
    private String nom;
    public int duree;
    public Priorite priorite;

    public String getdeadline() {
        return deadline;
    }

    private String deadline;
    protected LocalTime HeureDebut;
    protected LocalTime HeureFin;
    protected LocalDate Jour;


    public Tache(String nom, int duree,String priorite, String deadline) {
        this.nom = nom;
        this. duree= duree;
        this.deadline= deadline;
       // this.HeureDebut =HeureDebut;
       // this.HeureFin =HeureFin;
        if (priorite==("low")){
            this.priorite=low;}
        else if (priorite==("high")){
            this.priorite=high;}
        else if (priorite==("medium")){
            this.priorite=medium;}
    }

    public Tache() {

    }
}
