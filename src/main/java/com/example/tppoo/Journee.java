package com.example.tppoo;

import java.time.LocalDate;
import java.util.Locale;

public class Journee {
    protected LocalDate date;
    //  private Creneau creneauLibre;  ?
    protected Tache[] TachesDuJour; //peuvent être plusieurs
    static int nbTacheMin = 3;
    static int nbReussite=0;
    private int nbTachRealise=0;


    public void SetEtat() {
        int i=0;
        while ( i<TachesDuJour.length)
        {   String state="";
            if(state.toUpperCase(Locale.ROOT).equals("COMPLETED"))
            { TachesDuJour[i].setEtat(EtatTache.Completed);
                nbTachRealise++;
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
           // planning.setBadges()=

        }
        if(nbReussite==15){
         //   planning.()=

        }
        if(nbReussite==45){
           // user.setBadges()=

        }

    }



}
