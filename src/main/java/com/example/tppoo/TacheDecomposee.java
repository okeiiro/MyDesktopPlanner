package com.example.tppoo;

public class TacheDecomposee extends Tache implements Decomposable{


    public TacheDecomposee(String a, int b, String c, String d, String e, String f) {
    }

    public boolean valider() {

        return false;
    }

    public void evaluerAvancement() {


    }

    public TacheDecomposee()
    {
        super();
    }

    @Override
    public void decomposition(Tache tache) {

    }
}
