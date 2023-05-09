package com.example.tppoo;

import java.time.LocalDate;

public class Planning {
    protected LocalDate datedebut;//periode specifié par l'utilisateur
    protected LocalDate datefin;
    protected long period;  //en jours
    protected Journee[] joursPlanning;
    protected Creneau[] creneauxlibres;

}
