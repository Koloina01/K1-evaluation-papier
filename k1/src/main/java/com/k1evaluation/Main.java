package com.k1evaluation;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataRetriever dr = new DataRetriever();

        System.out.println("=== Nombre de réparations par marque et modèle ===");
        List<ReparationParModele> reparations = dr.getReparationParModele();
        for (ReparationParModele r : reparations) {
            System.out.println(r);
        }

        System.out.println("\n=== Pourcentage de réparations par modèle ===");
        PourcentageReparation pourcentage = dr.getPourcentageReparation();
        System.out.println(pourcentage);

        System.out.println("\n=== Coût des réparations par marque et mécanicien ===");
        List<CoutReparation> couts = dr.getCoutReparation();
        for (CoutReparation c : couts) {
            System.out.println(c);
        }

        System.out.println("\n=== Mécanicien qui a rapporté le moins ===");
        MecanicienMoinsRentable moinsRentable = dr.getMecanicienMoinsRentable();
        System.out.println(moinsRentable);
    }
}