package com.example.tppoo;

import java.time.LocalTime;

public class TacheDecomposee extends Tache implements Decomposable{


    public TacheDecomposee(String a, int b, String c, String d, String e, String f) {//enlever e et f
    }

    public boolean valider() {

        return false;
    }

    public void evaluerAvancement() {


    }

    public TacheDecomposee()
    {
        super();
    }

    @Override
    public void decomposition(Tache tache, Creneau Cr, Planning planning, int i) {

        tache.HeureFin= Cr.getHeureFin();
        Tache tache2= new Tache();
        tache2=tache;
        tache2.setNom(tache.getNom().concat("2"));
        planning.trouverJour(Cr.getJour()).TachesDuJour[planning.trouverJour(Cr.getJour()).TachesDuJour.length]=tache;
        tache=tache2; //condition d'arret ou exceptions jsp
        i++;

    }
}
