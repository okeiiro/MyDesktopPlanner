package com.example.tppoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

public class Creneaux implements Decomposable{

 private LocalDate jour;
 protected LocalTime HeureDebut;
 protected LocalTime HeureFin;
 private static int dureeMin;
 protected Tache tachescr;



    public boolean verifDureeMin(){
        boolean bool=false;
        Duration duree= Duration.ofMinutes(dureeMin);
        if(Duration.between(HeureDebut, HeureFin).compareTo(duree)<0)
        {bool=true;}
        else{bool=false;}

        return bool;
        }

        public void bloquer(){}

    @Override
    public void decomposition(Tache tache) {

        Duration.ofMinutes(tache.duree);


    }


}
