CREATE TYPE marque_enum AS ENUM ('FORD', 'GMC', 'DODGE');
CREATE TYPE modele_enum AS ENUM ('RANGER', 'EVEREST', 'YUKON', 'RAM');
CREATE TABLE Modele_voiture (
    id SERIAL PRIMARY KEY,
    marque marque_enum,
    modele modele_enum
);
CREATE TABLE Mecanicien (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100),
    marque marque_enum
);

CREATE TABLE Reparation (
    id SERIAL PRIMARY KEY,
    id_mecanicien INT,
    id_modele_voiture INT,
    cout INT,
    
    FOREIGN KEY (id_mecanicien) REFERENCES Mecanicien(id),
    FOREIGN KEY (id_modele_voiture) REFERENCES Modele_voiture(id)
);

SELECT mv.marque, mv.modele, COUNT(r.id) AS nbre_reparation
FROM Reparation r
JOIN Modele_voiture mv ON r.id_modele_voiture = mv.id
GROUP BY mv.marque, mv.modele;

SELECT
100.0 * SUM(CASE WHEN mv.modele='RANGER' THEN 1 ELSE 0 END) / COUNT(*) AS nbre_reparation_ranger,
100.0 * SUM(CASE WHEN mv.modele='EVEREST' THEN 1 ELSE 0 END) / COUNT(*) AS nbre_reparation_everest,
100.0 * SUM(CASE WHEN mv.modele='YUKON' THEN 1 ELSE 0 END) / COUNT(*) AS nbre_reparation_yukon,
100.0 * SUM(CASE WHEN mv.modele='RAM' THEN 1 ELSE 0 END) / COUNT(*) AS nbre_reparation_ram
FROM Reparation r
JOIN Modele_voiture mv ON r.id_modele_voiture = mv.id;
