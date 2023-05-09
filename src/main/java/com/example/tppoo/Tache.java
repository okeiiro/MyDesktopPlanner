package com.example.tppoo;

import static com.example.tppoo.Priorite.*;

public class Tache {
    private String nom;
    public int duree;
    public Priorite priorite;
    private String deadline;
    protected String dateDebut;
    protected String dateFin;



    public Tache(String nom, int duree,String priorite, String deadline,String dateDebut,String dateFin) {
        this.nom = nom;
        this. duree= duree;
        this.deadline= deadline;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
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
