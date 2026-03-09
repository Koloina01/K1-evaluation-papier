package com.k1evaluation;

public class CoutReparation {

    private String marque;
    private String nomMecanicien;
    private double coutReparation;

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setNomMecanicien(String nomMecanicien) {
        this.nomMecanicien = nomMecanicien;
    }

    public void setCoutReparation(double coutReparation) {
        this.coutReparation = coutReparation;
    }

    public String getMarque() {
        return marque;
    }

    public String getNomMecanicien() {
        return nomMecanicien;
    }

    public double getCoutReparation() {
        return coutReparation;
    }

    @Override
    public String toString() {
        return "CoutReparation{" +
                "marque='" + marque + '\'' +
                ", nomMecanicien='" + nomMecanicien + '\'' +
                ", coutReparation=" + coutReparation +
                '}';
    }
}
