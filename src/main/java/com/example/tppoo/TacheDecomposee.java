package com.example.tppoo;

public class TacheDecomposee extends Tache implements Decomposable{



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
    public void decomposition() {
    }
}
