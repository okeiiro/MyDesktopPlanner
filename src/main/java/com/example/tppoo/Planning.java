package com.example.tppoo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class Planning {
    protected LocalDate datedebut;//periode specifié par l'utilisateur
    protected LocalDate datefin;
    protected long period;  //en jours
    protected Journee[] joursPlanning; // ordonnés
    protected Creneau[] creneauxlibres; //ordonnés


    public Journee trouverJour(LocalDate dateRech) { //renvoie le jour recherché sinon renvoie
        boolean trouv = false;
        int i = 0;
        joursPlanning[i]=new Journee();
        joursPlanning[i].TachesDuJour=new Tache[30];
        joursPlanning[i].TachesDuJour[0]= new Tache();
        if (dateRech.isBefore(datefin)){//date recherché avant date limite periode
            while(joursPlanning!=null)
            for (i = 0; i < joursPlanning.length; i++) { //si le jour se trouve déjà dans le planning
                joursPlanning[i]=new Journee();
                if (joursPlanning[i].date.equals(dateRech)) {
                    trouv = true;
                    break;
                }
            }
        if (trouv = false) {
            i = joursPlanning.length + 1;


        }

    }
        if(joursPlanning.length==0){
            i=0; //remplir la 1ère case du tableau s'il est vide



        }
        System.out.println("jourPlanning[i]: "+joursPlanning[i].date);

        return joursPlanning[i];

    }

/***si planning ordonné***/

/*
    public Journee trouverJour(LocalDate dateRech) { //renvoie le jour recherché sinon renvoie
        boolean trouv = false;
        int i = 0;
        if (dateRech.isBefore(datefin)){//date recherché avant date liite periode
            while (dateRech.isBefore(joursPlanning[i].date)&&(!trouv)) { //si le jour se trouve déjà dans le planning

                if (joursPlanning[i].date.equals(dateRech)) {
                    trouv = true;


                }
            }

        }
        return joursPlanning[i];

    }

    */

    public Tache[] TriTaches(Tache[] tachesTri){

        // Define a custom Comparator that compares Tasks by due date
        Comparator<Tache> byDueDate = Comparator.comparing(Tache::getdeadline);

// Sort the array using the Comparator
        Arrays.sort(tachesTri, byDueDate);

    return tachesTri;
    }

 public void afficherCrLibres(){

        for (int i = 0; i < creneauxlibres.length; i++) {

            System.out.println(creneauxlibres[i].getHeureDebut() +" "+ creneauxlibres[i].getHeureFin());

        }


 }

 void Planning(){

 }




}