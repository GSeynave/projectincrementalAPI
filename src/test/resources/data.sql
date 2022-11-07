DELETE FROM monstre;
DELETE FROM zone;
DELETE FROM statistique;

INSERT INTO public.statistique
(id, air, critique_chance, critique_dommage, dexterite, eau, energie, feu, hate, niveau, "precision", puissance, resistance_air, resistance_eau, resistance_feu, resistance_terre, sagesse, terre, vie)
VALUES(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT INTO public."zone"
(id, nom)
VALUES(1, 'Zone 1');

INSERT INTO public."zone"
(id, nom)
VALUES(2, 'Zone 2');



INSERT INTO monstre (id, nom, statistique_id, zone_id) VALUES (1, 'Blob de Feu', 1, 1);
INSERT INTO monstre (id, nom, statistique_id, zone_id) VALUES (2, 'Blob de Terre', 1, 1);
INSERT INTO monstre (id, nom, statistique_id, zone_id) VALUES (3, 'Blob d''Eau', 1, 1);
INSERT INTO monstre (id, nom, statistique_id, zone_id) VALUES (4, 'Blob de Vent', 1, 1);