package com.example.tppoo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.example.tppoo.Priorite.*;

public class Utilisateur {
    public String pseudo;


    private Calendrier Cal;
    private Projet[] projets;
    private Planning[] historique;
    private Badges badge;
    private Tache[] tachenonplan;


    public void ajouterProjet() {

    }

    public void setpreference() {
    }

    public Creneau ajoutertache(Tache tache, Creneau Cr, Planning plan, int i) {
        tache.Jour = Cr.getJour();
        //boolean decomposable=false;
        if (tache instanceof TacheDecomposee) {

            Duration duree = Duration.ofMinutes(tache.duree);
            if (Duration.between(Cr.getHeureDebut(), Cr.getHeureFin()).compareTo(duree) > 0 && (Cr.verifDureeMin())) {
                Cr.decomposition(tache, Cr, plan, i);
                plan.trouverJour(Cr.getJour()).TachesDuJour[plan.trouverJour(Cr.getJour()).TachesDuJour.length] = tache;


            } else {
                ((TacheDecomposee) tache).decomposition(tache, Cr, plan, i);
                ajoutertache(tache, plan.creneauxlibres[i], plan, i);

            }
        } else { //tache simple

            Duration duree = Duration.ofMinutes(tache.duree);
            if (Duration.between(Cr.getHeureDebut(), Cr.getHeureFin()).compareTo(duree) > 0 && (Cr.verifDureeMin())) {
                Cr.decomposition(tache, Cr, plan, i);
                tache.HeureDebut = Cr.getHeureDebut();
                plan.trouverJour(Cr.getJour()).TachesDuJour[plan.trouverJour(Cr.getJour()).TachesDuJour.length] = tache;


            } else {
                //impossible de planifier la tache dans ce créneau
                //exception
            }


        }

        return Cr;
    }

    public void classerTache() {

    }


    public Tache setpriorite(Priorite pr, Tache tach) {
        tach.priorite = pr;
        return tach;
    }


    public Planning plannifierTache(Planning planning, Creneau Cr, Tache tache, int i) {
        //int i=rang fu cr libre

        ajoutertache(tache, Cr, planning, i);
        for (int j = i; j < planning.creneauxlibres.length - 1; j++) {  //suppression du créneau libre
            planning.creneauxlibres[j] = planning.creneauxlibres[j + 1]; //si elle n'est pas planifié exceptiob
        }
        planning.creneauxlibres[planning.creneauxlibres.length - 1] = null;

        boolean bol = false;  //bloquer creneau
        if (bol) {
            Cr.bloque = true;
        }

        return planning;
    }


    public void setCrLibres(Planning planning, LocalDate date) {
        //LocalDate date = planning.datedebut;
        int p = (int) planning.period;
        Creneau[] creneauxlibres = new Creneau[p];

        for (int i = 0; i < p; i++) {
            creneauxlibres[i] = new Creneau();//lecture des horraires par l'utilisateur
            creneauxlibres[i].setJour(date);
            date = date.plusDays(1);

        }
        planning.creneauxlibres = creneauxlibres;
    }


    public Planning setPeriode(int day, int month, int year, int day2, int month2, int year2) {
        Planning planning = new Planning();

        planning.datedebut = LocalDate.of(year, month, day);//exception date du jour
        planning.datefin = LocalDate.of(year2, month2, day2);
        planning.period = ChronoUnit.DAYS.between(planning.datedebut, planning.datefin);



        return planning;
    }


    public Planning planificationAuto(Planning planning, Tache[] taches) {  // introduire tableau de taches à planifier

        taches = planning.TriTaches(taches);
        int i = 0, j = 0;
        while (i < taches.length + 1) {
            if (taches[i].priorite == high) {

                plannifierTache(planning, planning.creneauxlibres[j], taches[i], j);

            }
            i++;
            j++;
        }
        i = 0;
        while (i < taches.length + 1) {
            if (taches[i].priorite == medium) {

                plannifierTache(planning, planning.creneauxlibres[j], taches[i], j);

            }
            i++;
            j++;

        }
        i = 0;
        while (i < taches.length + 1) {
            if (taches[i].priorite == low) {

                plannifierTache(planning, planning.creneauxlibres[j], taches[i], j);

            }
            i++;
            j++;

        }


        return planning;
    }


    public Planning planificationManuelle(Planning planning, String a, int b, String c, String d, String e, String f, boolean decomposable) {   //planning.afficherCrLibres();
        //selectionner créneau vide
        int i = 2;//par exemple
        Tache task;
        Creneau Cr = planning.creneauxlibres[i];
        if (decomposable) {
            task = new TacheDecomposee(a, b, c, d, e, f);
        } else {
            task = new TacheSimple(a, b, c, d, e, f);

        }
        plannifierTache(planning, Cr, task, i);


        return planning;

    }


    public Projet creerProjet(String nom, String desc, Tache[] tachespr) {
        Projet projet = new Projet(nom, desc,tachespr);

        //projets[projets.length]=projet;

        return projet;
    }

}

