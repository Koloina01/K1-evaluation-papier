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

TRUNCATE TABLE Reparation;

INSERT INTO Reparation (id_mecanicien, id_modele_voiture, cout) VALUES
(1,1,100000),
(1,1,110000),
(1,1,120000),
(1,1,130000),
(1,1,140000),
(1,1,150000),
(1,1,160000),
(1,1,170000),
(1,1,180000),
(1,1,190000),
(1,2,200000),
(1,2,210000),
(1,2,220000),
(1,2,230000),
(1,2,240000),
(1,2,250000),
(1,2,260000),
(1,2,270000),
(1,2,280000),
(1,2,290000),
(1,2,300000),
(1,2,310000),
(1,2,320000),
(1,2,330000),
(1,2,340000),
(3,3,100000),
(3,3,120000),
(2,4,35000);