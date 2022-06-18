-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 18 juin 2022 à 16:21
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `family_event_finance`
--

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `ID` int(11) NOT NULL,
  `LIBELLE` varchar(255) NOT NULL,
  `DATE` date NOT NULL,
  `LIEU` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `evenement_participant`
--

CREATE TABLE `evenement_participant` (
  `ID_EVENEMENT` int(11) NOT NULL,
  `ID_PARTICIPANT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `ID` int(11) NOT NULL,
  `ID_EVENEMENT` int(11) NOT NULL,
  `ID_PARTICIPANT` int(11) NOT NULL,
  `MONTANT` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

CREATE TABLE PARTICIPANT (
  ID int(11) NOT NULL,
  NOM varchar(255) NOT NULL,
  PRENOM varchar(255) NOT NULL
);
--
-- Index pour les tables déchargées
--

--
-- Index pour la table `evenement`
--
ALTER TABLE EVENEMENT
  ADD PRIMARY KEY (ID);

--
-- Index pour la table `evenement_participant`
--
ALTER TABLE `evenement_participant`
  ADD KEY `ID_PARTICIPANT` (`ID_PARTICIPANT`),
  ADD KEY `ID_EVENEMENT` (`ID_EVENEMENT`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_PARTICIPANT` (`ID_PARTICIPANT`),
  ADD KEY `ID_EVENEMENT` (`ID_EVENEMENT`);

--
-- Index pour la table `participant`
--
ALTER TABLE `participant`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `participant`
--
ALTER TABLE `participant`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `evenement_participant`
--
ALTER TABLE `evenement_participant`
  ADD CONSTRAINT `evenement_participant_ibfk_1` FOREIGN KEY (`ID_PARTICIPANT`) REFERENCES `participant` (`ID`),
  ADD CONSTRAINT `evenement_participant_ibfk_2` FOREIGN KEY (`ID_PARTICIPANT`) REFERENCES `participant` (`ID`),
  ADD CONSTRAINT `evenement_participant_ibfk_3` FOREIGN KEY (`ID_EVENEMENT`) REFERENCES `evenement` (`ID`),
  ADD CONSTRAINT `evenement_participant_ibfk_4` FOREIGN KEY (`ID_EVENEMENT`) REFERENCES `evenement` (`ID`);

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `paiement_ibfk_1` FOREIGN KEY (`ID_PARTICIPANT`) REFERENCES `participant` (`ID`),
  ADD CONSTRAINT `paiement_ibfk_2` FOREIGN KEY (`ID_PARTICIPANT`) REFERENCES `participant` (`ID`),
  ADD CONSTRAINT `paiement_ibfk_3` FOREIGN KEY (`ID_EVENEMENT`) REFERENCES `evenement` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
