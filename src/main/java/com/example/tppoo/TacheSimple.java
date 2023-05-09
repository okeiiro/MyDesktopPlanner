package com.example.tppoo;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TacheSimple extends Tache {
    public int periodicite;


    public void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
    }


    public TacheSimple(String a, int b, String c, String d, String e, String f) {

    }

    public void TachePeriodique(Utilisateur user, Planning planning){
        LocalDate date = LocalDate.parse(dateDebut).plusDays(periodicite);
        while(date.compareTo(planning.datefin)  <0)
        {
            date = LocalDate.parse(dateDebut).plusDays(periodicite);
            Creneau creneauTrouve = null;
            //String jourRecherche = date;

            // Recherche du créneau avec l'attribut jour égal à date
            for (Creneau creneau : planning.creneauxlibres) {
                if (creneau.jour.equals(date)) {
                    creneauTrouve = creneau;//si ce jour existe déjà dans le planning on


                    break;
                }
            }

           /* if (creneauTrouve != null) {
                System.out.println("Le créneau trouvé est : " + creneauTrouve.jour);
            } else {
                System.out.println("Aucun créneau trouvé avec le jour " + date);
            }*/

        }
    }


}