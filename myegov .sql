-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 09 Mai 2016 à 20:13
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `myegov`
--

-- --------------------------------------------------------

--
-- Structure de la table `autorisationcirculation`
--

CREATE TABLE IF NOT EXISTS `autorisationcirculation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cin` int(11) NOT NULL,
  `CarteGrise` int(11) NOT NULL,
  `cpp` int(11) NOT NULL,
  `FinAutorisation` date NOT NULL,
  `etat` varchar(50) NOT NULL DEFAULT 'En Cours',
  `commentaire` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user` (`cin`),
  KEY `cpp` (`cpp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Structure de la table `cin`
--

CREATE TABLE IF NOT EXISTS `cin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `extrait` int(11) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `profession` varchar(50) NOT NULL,
  `lieu_creation` varchar(50) NOT NULL,
  `date_creation` date NOT NULL,
  `photo` varchar(500) DEFAULT NULL,
  `empreinte` varchar(500) DEFAULT NULL,
  `num_cin` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `extrait` (`extrait`),
  KEY `extrait_2` (`extrait`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `cin`
--

INSERT INTO `cin` (`id`, `extrait`, `adresse`, `profession`, `lieu_creation`, `date_creation`, `photo`, `empreinte`, `num_cin`) VALUES
(1, 1, 'thar haddad', 'etudiant', 'tunis', '2000-10-10', NULL, NULL, '04843134');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `num_compte` varchar(50) NOT NULL,
  `cin` int(10) NOT NULL,
  `montant` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user` (`cin`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`id`, `num_compte`, `cin`, `montant`) VALUES
(3, '5359762633451448', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE IF NOT EXISTS `demande` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `cin` int(11) NOT NULL,
  `etat` varchar(50) NOT NULL DEFAULT 'En Cours',
  `commentaire` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cin` (`cin`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `demande`
--

INSERT INTO `demande` (`id`, `type`, `cin`, `etat`, `commentaire`) VALUES
(2, 'CPP', 1, 'Validé', '00aaaaa'),
(3, 'B3', 1, 'En Cours', ''),
(4, 'CPP', 1, 'Validé', '');

-- --------------------------------------------------------

--
-- Structure de la table `demandeextrait`
--

CREATE TABLE IF NOT EXISTS `demandeextrait` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `lieu_naissance` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  `cin_pere` int(10) DEFAULT NULL,
  `cin_mere` int(10) DEFAULT NULL,
  `etat` varchar(50) NOT NULL DEFAULT 'En Cours',
  `commentaire` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cin_pere` (`cin_pere`),
  KEY `cin_mere` (`cin_mere`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `demandeextrait`
--

INSERT INTO `demandeextrait` (`id`, `nom`, `prenom`, `lieu_naissance`, `date_naissance`, `cin_pere`, `cin_mere`, `etat`, `commentaire`) VALUES
(1, 'k', 're', 't', '2016-04-17', 1, 1, 'Validé', 'done'),
(2, 'in', 'zazz', 'tunis', '2016-04-22', 1, 1, 'Validé', 'complet');

-- --------------------------------------------------------

--
-- Structure de la table `extraitnaissances`
--

CREATE TABLE IF NOT EXISTS `extraitnaissances` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `ville_naissance` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  `pere` varchar(50) DEFAULT NULL,
  `mere` varchar(50) DEFAULT NULL,
  `etat_civile` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `extraitnaissances`
--

INSERT INTO `extraitnaissances` (`id`, `nom`, `prenom`, `sexe`, `ville_naissance`, `date_naissance`, `pere`, `mere`, `etat_civile`) VALUES
(1, 'Romdhane', 'Khaled', 'Homme', 'Tunis', '1993-10-19', 'Samir', 'Amel', 'Marié');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cin` int(11) NOT NULL,
  `Type` varchar(25) NOT NULL,
  `Montant` int(11) NOT NULL,
  `PayerAvant` date NOT NULL,
  `etat` varchar(255) NOT NULL DEFAULT 'NonPayee',
  `commentaire` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_Facture` (`id`),
  KEY `cin` (`cin`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `facture`
--

INSERT INTO `facture` (`id`, `cin`, `Type`, `Montant`, `PayerAvant`, `etat`, `commentaire`) VALUES
(1, 1, 'sonede', 320, '2016-05-26', 'Validé', 'azeazeaze');

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

CREATE TABLE IF NOT EXISTS `fos_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `locked` tinyint(1) NOT NULL,
  `expired` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  `confirmation_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `credentials_expired` tinyint(1) NOT NULL,
  `credentials_expire_at` datetime DEFAULT NULL,
  `cin` int(10) DEFAULT NULL,
  `extraitnaissance` int(10) NOT NULL,
  `numtel` int(20) DEFAULT NULL,
  `poste` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nopass` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  KEY `cin` (`cin`),
  KEY `extraitnaissance` (`extraitnaissance`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Contenu de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `locked`, `expired`, `expires_at`, `confirmation_token`, `password_requested_at`, `roles`, `credentials_expired`, `credentials_expire_at`, `cin`, `extraitnaissance`, `numtel`, `poste`, `nopass`) VALUES
(1, 'iheb', 'iheb', 'iheb@live.fr', 'iheb@live.fr', 1, 'luyseimqvk0wkcscso80cwc0c4ocgo0', '0tBS/VF+lZs4owwrkQjaO4tWren0o+9M1rCG9qWSk36YwqFIZlbFBoGWaPuzDmHqNJeFKaGX0LCVYtE+i0ReeA==', '2016-04-18 18:34:46', 0, 0, NULL, NULL, NULL, 'a:1:{i:0;s:10:"ROLE_ADMIN";}', 0, NULL, 1, 1, NULL, 'Muni', '000');

-- --------------------------------------------------------

--
-- Structure de la table `importer`
--

CREATE TABLE IF NOT EXISTS `importer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CIN` int(11) NOT NULL,
  `PathCarte` varchar(255) NOT NULL,
  `PathPermis` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `importer`
--

INSERT INTO `importer` (`id`, `CIN`, `PathCarte`, `PathPermis`) VALUES
(1, 9, 'C:\\Users\\lenovo\\Desktop\\1..png', 'C:\\Users\\lenovo\\Desktop\\1..png'),
(2, 9187683, 'C:\\Users\\lenovo\\Desktop\\1..png', 'C:\\Users\\lenovo\\Desktop\\application html\\bouton-connexion.png');

-- --------------------------------------------------------

--
-- Structure de la table `mail`
--

CREATE TABLE IF NOT EXISTS `mail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `tel` int(11) NOT NULL,
  `fromm` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `text` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `mariage`
--

CREATE TABLE IF NOT EXISTS `mariage` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cin_homme` int(10) NOT NULL,
  `cin_femme` int(10) NOT NULL,
  `date_mariage` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cin_homme` (`cin_homme`),
  KEY `cin_femme` (`cin_femme`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE IF NOT EXISTS `reclamation` (
  `id` int(11) NOT NULL,
  `objet` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `utilisateur` int(11) NOT NULL,
  KEY `utilisateur` (`utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `autorisationcirculation`
--
ALTER TABLE `autorisationcirculation`
  ADD CONSTRAINT `autorisationcirculation_ibfk_2` FOREIGN KEY (`cpp`) REFERENCES `compte` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `autorisationcirculation_ibfk_1` FOREIGN KEY (`cin`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cin`
--
ALTER TABLE `cin`
  ADD CONSTRAINT `cin_ibfk_1` FOREIGN KEY (`extrait`) REFERENCES `extraitnaissances` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`cin`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `demande_ibfk_1` FOREIGN KEY (`cin`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `demandeextrait`
--
ALTER TABLE `demandeextrait`
  ADD CONSTRAINT `demandeextrait_ibfk_1` FOREIGN KEY (`cin_pere`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `demandeextrait_ibfk_2` FOREIGN KEY (`cin_mere`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`cin`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `fos_user`
--
ALTER TABLE `fos_user`
  ADD CONSTRAINT `fos_user_ibfk_1` FOREIGN KEY (`extraitnaissance`) REFERENCES `extraitnaissances` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fos_user_ibfk_2` FOREIGN KEY (`cin`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `mariage`
--
ALTER TABLE `mariage`
  ADD CONSTRAINT `mariage_ibfk_1` FOREIGN KEY (`cin_homme`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mariage_ibfk_2` FOREIGN KEY (`cin_femme`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `reclamation_ibfk_1` FOREIGN KEY (`utilisateur`) REFERENCES `cin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
