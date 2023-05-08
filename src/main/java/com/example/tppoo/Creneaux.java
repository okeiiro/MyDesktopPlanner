package com.example.tppoo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Creneaux implements Decomposable{

 private LocalDate jour;
 private LocalTime HeureDebut;
 private LocalTime HeureFin;
 private static int dureeMin;



    public boolean verifDureeMin(){
        return false;
    }


    @Override
    public void decomposition() {


    }


}
