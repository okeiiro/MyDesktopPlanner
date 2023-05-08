package com.example.tppoo;

public class Application {
    private Utilisateur[] utilisateurs;


    public void ajouterUtilisateur(int i,String nom){
       // utilisateurs[i+1]= new Utilisateur;
        utilisateurs[i+1].pseudo=nom;
    }

    public Utilisateur authentification(String nom) {
    int i=0;
        while( i<utilisateurs.length){
            if (utilisateurs[i].pseudo == nom) {
                return (utilisateurs[i]);
            }
            else{
                ajouterUtilisateur(i, nom);
                return (utilisateurs[i+1]);
            }
        }

        return null;
    }
}
