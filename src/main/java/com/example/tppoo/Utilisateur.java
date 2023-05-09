package com.example.tppoo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Utilisateur {
    public String pseudo;
    private Calendrier Cal;
    private Projet[] projets;
    private Planning[] historique;
    private Badges badge;
    private Tache[] tachenonplan;


    public void ajouterProjet(){

    }

    public void setpreference(){}


    public Creneau ajoutertache(String a, int b, String c, String d, String e, String f, Creneau Cr, Planning plan) {

        boolean decomposable=false;
        if(decomposable) {
            Tache tache = new TacheDecomposee(a, b, c, d, e, f); //choisir entre tache simple ou decomposée
            Duration duree = Duration.ofMinutes(b);
            if (Duration.between(Cr.HeureDebut, Cr.HeureFin).compareTo(duree) > 0 && (Cr.verifDureeMin())) {
                Cr.decomposition(tache, Cr, plan);


            } else {
                ((TacheDecomposee) tache).decomposition(tache, Cr, plan);
            }
        }
        else { //tache simple

            Tache tache = new TacheSimple(a, b, c, d, e, f); //choisir entre tache simple ou decomposée
            Duration duree = Duration.ofMinutes(b);
            if (Duration.between(Cr.HeureDebut, Cr.HeureFin).compareTo(duree) > 0 && (Cr.verifDureeMin())) {
                Cr.decomposition(tache, Cr, plan);


            } else {
                //impossible de planifier la tache dans ce créneau
                //exception
            }


        }

            return Cr;
        }

    public void classerTache(){

    }


    public Tache setpriorite(Priorite pr, Tache tach){
        tach.priorite=pr;
        return tach;
    }




    public Planning plannifierTache(Planning planning){
        int i=0;
        Creneau Cr=planning.creneauxlibres[i];//selectionner parmis les créneaux libres
    String a="", c="",d="",e="",f="";
    int b=30;
    ajoutertache(a,b,c,d,e,f,Cr,planning);
        for (int j = i; j < planning.creneauxlibres.length - 1; j++) {  //suppression du créneau libre
            planning.creneauxlibres[j] = planning.creneauxlibres[j + 1];
        }
        planning.creneauxlibres[planning.creneauxlibres.length - 1] = null;

    boolean bol=false;
    if(bol){Cr.bloque=true;}

    return planning;
    }


    public Planning setCrLibres(Planning planning){
        LocalDate date =planning.datedebut;
        int p=(int) planning.period;
        Creneau[] creneauxlibres= new Creneau[p];

        for (int i = 0; i < p; i++) {
            creneauxlibres[i] = new Creneau();//lecture des horraires par l'utilisateur
            date = date.plusDays(1);
        }
        planning.creneauxlibres=creneauxlibres;
    return planning;}



    public Planning setPeriode(){
        Planning planning=new Planning() ;

        int day=0,month=0,year=0, day2=0,month2=0,year2=0;
        planning.datedebut=LocalDate.of(year,month,day);//exception date du jour
        planning.datefin=LocalDate.of(year,month,day);
        planning.period= ChronoUnit.DAYS.between(planning.datedebut, planning.datefin);


    return planning; }







        public Planning planificationAuto (Planning planning){



            return planning;
        }




}



