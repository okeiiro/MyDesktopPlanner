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
    public void decomposition(Tache tache, Creneau Cr, Planning planning) {

        Cr.HeureFin= LocalTime.parse(tache.HeureDebut);
        Cr.tachecr =tache;
        Creneau CrDecompose= new Creneau();
        CrDecompose.HeureDebut=LocalTime.parse(tache.HeureDebut);
        CrDecompose.HeureFin=LocalTime.parse(tache.HeureFin);

        planning.creneauxlibres[planning.creneauxlibres.length+1]=CrDecompose;
        Duration.ofMinutes(tache.duree);



    }

   public void libererCreneau(){

   }


}
