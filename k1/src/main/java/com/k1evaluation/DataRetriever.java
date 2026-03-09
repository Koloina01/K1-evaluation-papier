package com.k1evaluation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    public List<ReparationParModele> getReparationParModele() {

        DBConnection dbConnection = new DBConnection();
        List<ReparationParModele> results = new ArrayList<>();

        String sql = """
            SELECT mv.marque, mv.modele, COUNT(r.id) AS nbre_reparation
            FROM Reparation r
            JOIN Modele_voiture mv ON r.id_modele_voiture = mv.id
            GROUP BY mv.marque, mv.modele
        """;

        try (
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while(rs.next()){
                ReparationParModele obj = new ReparationParModele();
                obj.setMarque(rs.getString("marque"));
                obj.setModele(rs.getString("modele"));
                obj.setNbreReparation(rs.getInt("nbre_reparation"));
                results.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    
    public PourcentageReparation getPourcentageReparation() {

        DBConnection dbConnection = new DBConnection();
        PourcentageReparation reparation = new PourcentageReparation();

        String sql = """
            SELECT
            100.0 * SUM(CASE WHEN mv.modele='RANGER' THEN 1 ELSE 0 END) / COUNT(*) AS ranger,
            100.0 * SUM(CASE WHEN mv.modele='EVEREST' THEN 1 ELSE 0 END) / COUNT(*) AS everest,
            100.0 * SUM(CASE WHEN mv.modele='YUKON' THEN 1 ELSE 0 END) / COUNT(*) AS yukon,
            100.0 * SUM(CASE WHEN mv.modele='RAM' THEN 1 ELSE 0 END) / COUNT(*) AS ram
            FROM Reparation r
            JOIN Modele_voiture mv ON r.id_modele_voiture = mv.id
        """;

        try (
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            if(rs.next()){
                reparation.setRanger(rs.getDouble("ranger"));
                reparation.setEverest(rs.getDouble("everest"));
                reparation.setYukon(rs.getDouble("yukon"));
                reparation.setRam(rs.getDouble("ram"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reparation;
    }

    public List<CoutReparation> getCoutReparation() {

        DBConnection dbConnection = new DBConnection();
        List<CoutReparation> results = new ArrayList<>();

        String sql = """
            SELECT mv.marque, m.nom AS nom_mecanicien, SUM(r.cout) AS cout_reparation
            FROM Reparation r
            JOIN Mecanicien m ON r.id_mecanicien = m.id
            JOIN Modele_voiture mv ON r.id_modele_voiture = mv.id
            GROUP BY mv.marque, m.nom
        """;

        try (
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while(rs.next()){
                CoutReparation obj = new CoutReparation();
                obj.setMarque(rs.getString("marque"));
                obj.setNomMecanicien(rs.getString("nom_mecanicien"));
                obj.setCoutReparation(rs.getDouble("cout_reparation"));
                results.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public MecanicienMoinsRentable getMecanicienMoinsRentable() {

        DBConnection dbConnection = new DBConnection();
        MecanicienMoinsRentable rentable = new MecanicienMoinsRentable();

        String sql = """
            SELECT m.nom AS mecanicien, SUM(r.cout) AS cout_reparation_rapporte
            FROM Reparation r
            JOIN Mecanicien m ON r.id_mecanicien = m.id
            GROUP BY m.nom
            ORDER BY cout_reparation_rapporte ASC
            LIMIT 1
        """;

        try (
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            if(rs.next()){
                rentable.setMecanicien(rs.getString("mecanicien"));
                rentable.setCoutReparationRapporte(rs.getDouble("cout_reparation_rapporte"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rentable;
    }
}
