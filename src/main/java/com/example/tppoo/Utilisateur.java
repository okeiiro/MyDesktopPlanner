package com.example.tppoo;

import static com.example.tppoo.Priorite.low;

public class Utilisateur {
    public String pseudo;
    private Calendrier Cal;
    private Projet[] projets;
    private Planning[] historique;//pas sure
    private Badges badge;
    private Creneaux[] creneauxlibres;
    private Tache[] tachenonplan;


    public void ajouterProjet(){

    }

    public void setpreference(){}


    public void ajoutertache(){
        Tache tache= new Tache("aef","aef","low","ar","arfq","kjn");

        int i=tachenonplan.length;
        i++;
        tachenonplan[i]=tache;
    }

    public void classerTache(){}

    public Tache setpriorite(Priorite pr, Tache tach){
        tach.priorite=pr;
        return tach;
    }

    public void fixerperiode(String periode){

        // if periode < date du jour

    }


    public void plannifier(){



    }



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


            return null;
        }




}



