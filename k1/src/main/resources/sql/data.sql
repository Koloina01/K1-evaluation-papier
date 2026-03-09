INSERT INTO Modele_voiture (marque, modele) VALUES
('FORD', 'RANGER'),
('FORD', 'EVEREST'),
('GMC', 'YUKON'),
('DODGE', 'RAM');

INSERT INTO Mecanicien (nom, marque) VALUES
('Rakoto', 'FORD'),
('Rabe', 'DODGE'),
('Jean', 'GMC');

INSERT INTO Reparation (id_mecanicien, id_modele_voiture, cout) VALUES
(1,1,100000),
(1,1,220000),
(1,2,150000),
(2,4,35000),
(3,3,100000);