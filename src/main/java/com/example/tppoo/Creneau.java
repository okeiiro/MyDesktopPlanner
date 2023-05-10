package com.example.tppoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

public class Creneau implements Decomposable{

 protected LocalDate jour;
 protected LocalTime HeureDebut;
 protected LocalTime HeureFin;
 private static int dureeMin;
 protected Tache tachecr;
 protected boolean bloque;



    public boolean verifDureeMin(){
        boolean bool=false;
        Duration duree= Duration.ofMinutes(dureeMin);
        if(Duration.between(HeureDebut, HeureFin).compareTo(duree)<0)
        {bool=true;}
        else{bool=false;}

        return bool;
        }



    @Override
    public void decomposition(Tache tache, Creneau Cr, Planning planning,int i) {

        tache.HeureDebut=Cr.HeureDebut;
        tache.HeureFin=Cr.HeureDebut.plusMinutes(tache.duree);
        Cr.HeureDebut=Cr.HeureDebut.plusMinutes(tache.duree); //le nouveau créneau libre


        planning.creneauxlibres[i]=Cr; //prend la placement de l'ancien creneau libre dans creneauxlibres
       // Duration.ofMinutes(tache.duree);

        // exception



    }

   public void libererCreneau(){

   }




}
