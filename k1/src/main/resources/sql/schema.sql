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