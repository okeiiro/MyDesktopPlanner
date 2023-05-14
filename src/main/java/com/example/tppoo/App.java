package com.example.tppoo;

public class App {
    public Utilisateur[] getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Utilisateur[] utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    private Utilisateur[] utilisateurs;


    public void ajouterUtilisateur(int i,String nom){
       // utilisateurs[i+1]= new Utilisateur;
        utilisateurs[i+1].pseudo=nom;
    }
    public Utilisateur[] start() {

        Utilisateur[] utilisateurs = new Utilisateur[10];
        return utilisateurs;
    }




    public Utilisateur authentification(String nom,Utilisateur[]users) {

    Utilisateur user= new Utilisateur();
    boolean find=false;


    int i=0;
        while( users[i]!=null){
            if (users[i].pseudo.toUpperCase().equals(nom.toUpperCase())) {
                user=users[i];
                find=true;
                System.out.println("l'utilisateur existe déjà");

            }
            i++;

        }
        if(find==false){
            user.pseudo=nom;
            users[i]=user;
        }
        System.out.println(user.pseudo);
        this.utilisateurs=users;

        return user;
    }
}
