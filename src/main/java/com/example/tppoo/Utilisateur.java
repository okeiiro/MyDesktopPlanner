package com.example.tppoo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.example.tppoo.Priorite.*;

public class Utilisateur {
    private List<Tache> taches;
    private List<Categorie> categories;
    private List<Creneau> creneaus;
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
            System.out.println("tache décomposable!");
            Duration duree = Duration.ofMinutes(tache.duree);
            if (((Duration.between(Cr.getHeureDebut(), Cr.getHeureFin()).compareTo(duree)) > 0) && (Cr.verifDureeMin())) {
                System.out.println("on va decomposer le creneau");
                Cr.decomposition(tache, Cr, plan, i);
                System.out.println("heure debut apres decomposition: "+Cr.getHeureDebut());
                System.out.println("heure fin de la tache: "+tache.HeureFin);
                plan.trouverJour(Cr.getJour()).TachesDuJour=new Tache[30];
                plan.trouverJour(Cr.getJour()).TachesDuJour[plan.trouverJour(Cr.getJour()).TachesDuJour.length-1]= tache;
                //la dernière case du tableau TachesDuJour de la journée concerné reçoit la nouvelle tache


            } else if(Cr.verifDureeMin()) {
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
        //int i=rang du cr libre

        ajoutertache(tache, Cr, planning, i);

        boolean bol = false;  //bloquer creneau
        if (bol) {
            Cr.bloque = true;
        }

        return planning;
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
            if (taches[i].priorite == high) {//commencer par planifier les taches de haute priorité

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


    public Planning planificationManuelle(Planning planning, String a, int b, String c, String d, boolean decomposable, int i) {   //planning.afficherCrLibres();
        //i c'est l'indice du créneau libre choisi
        Tache task;
        Creneau Cr = planning.creneauxlibres[i];
        if (decomposable) {
            task = new TacheDecomposee(a, b, c, d);
            System.out.println("duree manuelle: "+task.duree);

        } else {
            task = new TacheSimple(a, b, c, d);

        }
        plannifierTache(planning, Cr, task, i);


        return planning;

    }


    public Projet creerProjet(String nom, String desc, Tache[] tachespr) {
        Projet projet = new Projet(nom, desc,tachespr);

        //projets[projets.length]=projet;

        return projet;
    }
    public String getPseudo() {
        return pseudo;
    }

}

