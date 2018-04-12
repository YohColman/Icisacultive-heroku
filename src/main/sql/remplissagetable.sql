INSERT INTO panier(idpanier, typepanier) VALUES (1, "Petit format");
INSERT INTO panier(idpanier, typepanier) VALUES (2, "Moyen format");
INSERT INTO panier(idpanier, typepanier) VALUES (3, "Format familial");

INSERT INTO lot(idlot, prix, nombrepanier, idpanier) VALUES (1, 24, 3, 1);
INSERT INTO lot(idlot, prix, nombrepanier, idpanier) VALUES (2, 48, 6, 1);
INSERT INTO lot(idlot, prix, nombrepanier, idpanier) VALUES (3, 24, 3, 2);
INSERT INTO lot(idlot, prix, nombrepanier, idpanier) VALUES (4, 24, 3, 3);

INSERT INTO utilisateur(idutilisateur, nom, prenom, telephone, mail, motdepasse, admin) VALUES (1, "Colman", "Yohann", 0652812986, "yohann.colman@hei.yncrea.fr", "yoyo", 1);