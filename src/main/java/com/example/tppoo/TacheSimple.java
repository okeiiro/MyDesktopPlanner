package com.example.tppoo;
import java.time.LocalDate;

public class TacheSimple extends Tache {
    public int periodicite;


    public void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
    }


    public TacheSimple(String a, int b, String c, String d, String e, String f) {

    }

    public void TachePeriodique(Utilisateur user, Planning planning, Tache tache){
        LocalDate date = LocalDate.parse(tache.HeureDebut).plusDays(periodicite);
        while(date.compareTo(planning.datefin)  <0)
        {
            date = LocalDate.parse(tache.HeureDebut).plusDays(periodicite);
            Creneau creneauTrouve = null;

            // Recherche du créneau avec l'attribut jour égal à date
            for (Creneau creneau : planning.creneauxlibres) {
                if (creneau.jour.equals(date)) {
                    creneauTrouve = creneau;//si ce jour existe déjà dans le créneau libre c ok sinon exception
                    LocalDate dateRecherchee = date;

                    // Recherche du créneau avec l'attribut date égal à 2023-05-10
                       Journee JourRech=planning.trouverJour(date);
                        if (JourRech!=null) {
                            JourRech.TachesDuJour[JourRech.TachesDuJour.length+1] = creneau.tachecr;

                        } else {
                            Journee jour=new Journee();
                            jour.TachesDuJour[0]=tache;
                            jour.date=date;
                            planning.joursPlanning[planning.joursPlanning.length+1]= jour;//ajouter une journée au planning


                        }

                    break;
                }

            }



        }
    }


}