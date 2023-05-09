package com.example.tppoo;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TacheSimple extends Tache {
    public int periodicite;


    public void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
    }


    public TacheSimple(String a, int b, String c, String d, String e, String f) {

    }

    public void TachePeriodique(Utilisateur user){
        LocalDate date;
        date = LocalDate.parse(dateDebut).plusDays(periodicite);

    }


}