package com.example.tppoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

public class Creneau implements Decomposable{

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    private LocalDate jour;

    public void setHeureDebut(LocalTime heureDebut) {
        HeureDebut = heureDebut;
    }

    public LocalTime getHeureDebut() {
        return HeureDebut;
    }

    private LocalTime HeureDebut;

    public void setHeureFin(LocalTime heureFin) {
        HeureFin = heureFin;
    }

    public LocalTime getHeureFin() {
        return HeureFin;
    }

    private LocalTime HeureFin;

    public static void setDureeMin(int dureeMin) {
        Creneau.dureeMin = dureeMin;
    }

    public static int getDureeMin() {
        return dureeMin;
    }

    private static int dureeMin=15;


    public LocalDate getJour() {


        return jour;
    }

    public Tache getTachecr() {
        return tachecr;
    }

    private Tache tachecr;
 protected boolean bloque;



    public boolean verifDureeMin(){
        boolean bool=false;
        Duration duree= Duration.ofMinutes(dureeMin);
        if(Duration.between(HeureDebut, HeureFin).compareTo(duree)>0)
        {        System.out.println(" duree du creneau est ok ");


            bool=true;}
        else{bool=false;}

        return bool;
        }



    @Override
    public void decomposition(Tache tache, Creneau Cr, Planning planning,int i) {

        tache.HeureDebut=Cr.HeureDebut;
        tache.HeureFin=Cr.HeureDebut.plusMinutes(tache.duree);
        Cr.HeureDebut=Cr.HeureDebut.plusMinutes(tache.duree); //le nouveau créneau libre
        //heure fin du nouveau créneau va prendre l'heure fin de la tache

        planning.creneauxlibres[i]=Cr; //prend la placement de l'ancien creneau libre dans creneauxlibres


        // exception



    }

   public void libererCreneau(){

   }




}
