package com.example.tppoo;

import static com.example.tppoo.Priorite.low;

public class Tache {
    private String nom;
    private String duree;
    public Priorite priorite;
    private String deadline;
    private String dateDebut;
    private String dateFin;



    public Tache(String nom, String duree,String priorite, String deadline,String dateDebut,String dateFin) {
        this.nom = nom;
        this. duree= duree;
        this.deadline= deadline;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        if (priorite==("low")){
            this.priorite=low;
        }
    }

    public Tache() {

    }
}
