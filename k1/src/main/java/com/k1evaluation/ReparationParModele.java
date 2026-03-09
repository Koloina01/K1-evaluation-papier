package com.k1evaluation;

public class ReparationParModele {

    private String marque;
    private String modele;
    private int nbreReparation;

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setNbreReparation(int nbreReparation) {
        this.nbreReparation = nbreReparation;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public int getNbreReparation() {
        return nbreReparation;
    }

    @Override
    public String toString() {
        return "ReparationParModele{" +
                "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", nbreReparation=" + nbreReparation +
                '}';
    }
}
