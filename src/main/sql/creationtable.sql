CREATE TABLE `commande` (
  `idcommande` int(11) NOT NULL AUTO_INCREMENT,
  `montant` int(10) unsigned DEFAULT NULL,
  `date` date NOT NULL,
  `paye` tinyint(1) DEFAULT NULL,
  `idutilisateur` int(11) NOT NULL,
  `idlot` int(11) NOT NULL,
  PRIMARY KEY (`idcommande`),
  KEY `idutilisateur_idx` (`idutilisateur`),
  KEY `idlot_idx` (`idlot`),
  CONSTRAINT `idlot` FOREIGN KEY (`idlot`) REFERENCES `lot` (`idlot`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idutilisateur` FOREIGN KEY (`idutilisateur`) REFERENCES `utilisateur` (`idutilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `lignedecommande` (
  `idlignedecommande` int(11) NOT NULL AUTO_INCREMENT,
  `receptionne` tinyint(1) DEFAULT NULL,
  `idcommande` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`idlignedecommande`),
  KEY `idcommande_idx` (`idcommande`),
  KEY `date_idx` (`date`),
  CONSTRAINT `date` FOREIGN KEY (`date`) REFERENCES `seancedistribution` (`dateseance`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idcommande` FOREIGN KEY (`idcommande`) REFERENCES `commande` (`idcommande`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `lot` (
  `idlot` int(11) NOT NULL AUTO_INCREMENT,
  `prix` int(10) unsigned NOT NULL,
  `nombrepanier` int(11) DEFAULT NULL,
  `idpanier` int(11) NOT NULL,
  PRIMARY KEY (`idlot`),
  KEY `idpanier_idx` (`idpanier`),
  CONSTRAINT `idpanier` FOREIGN KEY (`idpanier`) REFERENCES `panier` (`idpanier`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8

CREATE TABLE `panier` (
  `idpanier` int(11) NOT NULL AUTO_INCREMENT,
  `typepanier` varchar(45) NOT NULL,
  PRIMARY KEY (`idpanier`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8

CREATE TABLE `seancedistribution` (
  `dateseance` date NOT NULL,
  PRIMARY KEY (`dateseance`),
  UNIQUE KEY `dateseance_UNIQUE` (`dateseance`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `utilisateur` (
  `idutilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `telephone` int(11) DEFAULT NULL,
  `mail` varchar(70) NOT NULL,
  `motdepasse` varchar(100) NOT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idutilisateur`),
  UNIQUE KEY `mail_UNIQUE` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

