package com.example.tppoo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.example.tppoo.Priorite.low;

public class Utilisateur {
    public String pseudo;
    private Calendrier Cal;
    private Projet[] projets;
    private Planning[] historique;//pas sure
    private Badges badge;
    private Tache[] tachenonplan;


    public void ajouterProjet(){

    }

    public void setpreference(){}


    public Creneaux ajoutertache(String a,int b,String c, String d, String e, String f, Creneaux Cr) {
        Tache tache = new TacheDecomposee(a, b, c, d, e, f);
        Duration duree= Duration.ofMinutes(b);
        if(Duration.between(Cr.HeureDebut, Cr.HeureFin).compareTo(duree)>0&&(Cr.verifDureeMin()))

        {   Cr.decomposition(tache);
            Cr.tachescr = tache;

        }else {
            ((TacheDecomposee) tache).decomposition(tache);
        }
            return Cr;
        }

    public void classerTache(){

    }


    public Tache setpriorite(Priorite pr, Tache tach){
        tach.priorite=pr;
        return tach;
    }




    public Creneaux plannifierTache(){
        Creneaux Cr=new Creneaux();//choisir parmis les créneaux libres
    String a="", c="",d="",e="",f="";
    int b=30;
    ajoutertache(a,b,c,d,e,f,Cr);

    boolean bol=false;
    if(bol){Cr.bloquer();}

    return Cr;

    }

    public Planning setCrLibres(Planning planning){
        LocalDate date;
        int day=0,month=0,year=0;//select day//create creneaux for it
        date=LocalDate.of(year,month,day);

        Creneaux[] creneauxlibres= new Creneaux[5];

        for (int i = 0; i < 5; i++) {
            planning.creneauxlibres[i] = new Creneaux();
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



/*
    public Planning creerPlanning(boolean man) {
        Planning plan= new Planning();


        if(){
            return(planificationManuelle(plan));
        }
        else{
            return(planificationAuto(plan));
        }

        return null;
         }
*/


        public Planning planificationManuelle (Planning planning){

            return null;
        }

        public Planning planificationAuto (Planning planning){


            return planning;
        }




}



