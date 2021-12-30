-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 30 déc. 2021 à 15:33
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cinema`
--

-- --------------------------------------------------------

--
-- Structure de la table `acteur`
--

CREATE TABLE `acteur` (
                          `Id` int(4) NOT NULL,
                          `Nom` varchar(20) NOT NULL,
                          `Prenom` varchar(20) DEFAULT NULL,
                          `Naissance` date DEFAULT NULL,
                          `Deces` date DEFAULT NULL,
                          `image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `acteur`
--

INSERT INTO `acteur` (`Id`, `Nom`, `Prenom`, `Naissance`, `Deces`, `image`) VALUES
(1, 'Reno', 'Jean', '1948-07-30', NULL, ''),
(2, 'Portman', 'Natalie', '1981-06-09', NULL, ''),
(3, 'Dujardin', 'Jean', '1972-06-19', NULL, ''),
(4, 'Bourvil', 'André', '1917-07-27', '1970-09-23', ''),
(5, 'De Funes', 'Louis', '1914-08-31', '1983-01-27', ''),
(6, 'Anglade', 'Jean-Hugues', '1955-07-29', NULL, ''),
(10, 'Goubin', 'Fabien', '1999-05-09', NULL, '');

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
                             `Id` varchar(2) NOT NULL,
                             `Libelle` varchar(20) NOT NULL,
                             `Image` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`Id`, `Libelle`, `Image`) VALUES
('AC', 'Action', 'https://upload.wikimedia.org/wikipedia/commons/thu'),
('CO', 'Comédie', 'https://upload.wikimedia.org/wikipedia/commons/thu'),
('PO', 'Policier', 'https://upload.wikimedia.org/wikipedia/commons/thu'),
('WE', 'Western', 'https://upload.wikimedia.org/wikipedia/commons/5/5');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
                        `Id` int(4) NOT NULL,
                        `Titre` varchar(30) NOT NULL,
                        `Duree` int(3) NOT NULL,
                        `Datesortie` date NOT NULL,
                        `Budget` int(8) NOT NULL,
                        `Recette` int(8) NOT NULL,
                        `Norea` int(2) NOT NULL,
                        `Catid` varchar(2) NOT NULL,
                        `image` varchar(100) NOT NULL,
                        `note` decimal(10,1) NOT NULL,
                        `description` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`Id`, `Titre`, `Duree`, `Datesortie`, `Budget`, `Recette`, `Norea`, `Catid`, `image`, `note`, `description`) VALUES
(1, 'Léon', 110, '1994-04-14', 17531000, 69250000, 3, 'PO', '', '3.1', ''),
(2, 'Cash', 100, '2008-04-23', 18340000, 60340000, 4, 'PO', '', '6.5', ''),
(3, 'La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC', '', '9.7', ''),
(4, 'Goubin', 100, '1999-05-09', 54545, 1000, 3, 'PO', '', '3.4', '');

-- --------------------------------------------------------

--
-- Structure de la table `personnage`
--

CREATE TABLE `personnage` (
                              `Idfilm` int(4) NOT NULL,
                              `Idact` int(4) NOT NULL,
                              `Personnagenom` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personnage`
--

INSERT INTO `personnage` (`Idfilm`, `Idact`, `Personnagenom`) VALUES
(1, 1, 'Léon'),
(1, 2, 'Mathilda'),
(2, 1, 'Maxime Dubreuil'),
(2, 3, 'Cash'),
(3, 4, 'Augustin Bouvet'),
(3, 5, 'Stanislas Lefort'),
(4, 1, 'Le Batteur'),
(4, 6, 'Le Roller');

-- --------------------------------------------------------

--
-- Structure de la table `realisateur`
--

CREATE TABLE `realisateur` (
                               `Id` int(2) NOT NULL,
                               `Nom` varchar(20) NOT NULL,
                               `Prenom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `realisateur`
--

INSERT INTO `realisateur` (`Id`, `Nom`, `Prenom`) VALUES
(1, 'Oury', 'Gérard'),
(2, 'Chabrol', 'Claude'),
(3, 'Besson', 'Luc'),
(4, 'Besnard', 'Eric');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
                               `id` int(11) NOT NULL,
                               `surname` char(25) DEFAULT NULL,
                               `forname` char(25) DEFAULT NULL,
                               `salt` char(100) DEFAULT NULL,
                               `email` char(50) DEFAULT NULL,
                               `mdp` char(80) DEFAULT NULL,
                               `role` char(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `surname`, `forname`, `salt`, `email`, `mdp`, `role`) VALUES
(1, 'Doe', 'John', 'nC+LkxSBRR5r/uSLrtB7MB7laCpEWRs5uUpLm3N2JqA=', 'john.doe@email.com', 'WFGexk0cocZHcs7qJuPawA==', 'admin'),
(15, 'Felix', 'Goubin', 'nC+LkxSBRR5r/uSLrtB7MB7laCpEWRs5uUpLm3N2JqA=', 'fabien.goubin@email.com', 'WFGexk0cocZHcs7qJuPawA==', 'apprenant'),
(16, 'Tanguy', 'Geffrault', 'nC+LkxSBRR5r/uSLrtB7MB7laCpEWRs5uUpLm3N2JqA=', 'felix.geffrault@email.com', 'WFGexk0cocZHcs7qJuPawA==', 'apprenant'),
(17, 'Dojhfge', NULL, 'HnPh+cHbMHVtxeWMjJFW3BAhStRYc3w8L81W9W7CqP0=', 'ee', '/dwL4lSVgiOBbmT8xgOiyA==', 'apprenant');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `acteur`
--
ALTER TABLE `acteur`
    ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
    ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
    ADD PRIMARY KEY (`Id`),
  ADD KEY `NoRea` (`Norea`),
  ADD KEY `CodeCat` (`Catid`);

--
-- Index pour la table `personnage`
--
ALTER TABLE `personnage`
    ADD PRIMARY KEY (`Idfilm`,`Idact`),
  ADD KEY `NoFilm` (`Idfilm`),
  ADD KEY `NoAct` (`Idact`);

--
-- Index pour la table `realisateur`
--
ALTER TABLE `realisateur`
    ADD PRIMARY KEY (`Id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `acteur`
--
ALTER TABLE `acteur`
    MODIFY `Id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
    MODIFY `Id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `realisateur`
--
ALTER TABLE `realisateur`
    MODIFY `Id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
    ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`Norea`) REFERENCES `realisateur` (`Id`) ON DELETE CASCADE,
  ADD CONSTRAINT `film_ibfk_2` FOREIGN KEY (`Catid`) REFERENCES `categorie` (`Id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `personnage`
--
ALTER TABLE `personnage`
    ADD CONSTRAINT `personnage_ibfk_1` FOREIGN KEY (`Idfilm`) REFERENCES `film` (`Id`) ON DELETE CASCADE,
  ADD CONSTRAINT `personnage_ibfk_2` FOREIGN KEY (`Idact`) REFERENCES `acteur` (`Id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
