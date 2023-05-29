package com.example.tppoo;

import java.time.LocalDate;
import java.util.Locale;

public class Journee {
    protected LocalDate date;
    protected int nbTachTotales=0;
    protected Tache[] TachesDuJour; //peuvent être plusieurs
    protected static int nbTacheMin = 3;
    protected static int nbReussite=0;
   protected static int nbTachRealise=0;


    public void SetEtat(String state) {
        int i=0;
        while ( i<TachesDuJour.length)
        {
            if(state.toUpperCase(Locale.ROOT).equals("COMPLETED"))
            { TachesDuJour[i].setEtat(EtatTache.Completed);
                nbTachRealise++; //si l'état de la tache est completed, le nombre de taches réalisées dans ce jour est incrémenté
            }

            if(state.toUpperCase(Locale.ROOT).equals("NOTREALIZED"))
            { TachesDuJour[i].setEtat(EtatTache.NotRealized);}

            if(state.toUpperCase(Locale.ROOT).equals("CANCELLED"))
            { TachesDuJour[i].setEtat(EtatTache.Cancelled);}

            if(state.toUpperCase(Locale.ROOT).equals("DELAYED"))
            { TachesDuJour[i].setEtat(EtatTache.Delayed);}

            if(state.toUpperCase(Locale.ROOT).equals("INPROGRESS"))
            { TachesDuJour[i].setEtat(EtatTache.InProgress);}
        }

    }

    public void feliciterUser(Utilisateur user)
    {
        if(nbTachRealise==nbTacheMin)
        {
            nbReussite++;
        }
        if(nbReussite==5){


        }
        if(nbReussite==15){
         //   planning.()=

        }
        if(nbReussite==45){
           // user.setBadges()=

        }

    }

void Journee(){
        this.TachesDuJour=TachesDuJour;
        this.date=date;

}

}
