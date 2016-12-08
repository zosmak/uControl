-- phpMyAdmin SQL Dump
-- version 4.6.5.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 07, 2016 at 05:04 PM
-- Server version: 10.1.18-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id134248_base_dados_projeto`
--
CREATE DATABASE IF NOT EXISTS `id134248_base_dados_projeto` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id134248_base_dados_projeto`;

-- --------------------------------------------------------

--
-- Table structure for table `alarme`
--

CREATE TABLE `alarme` (
  `idAlarme` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `sensor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ar_condicionado`
--

CREATE TABLE `ar_condicionado` (
  `idArCondicionado` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `temperatura` float NOT NULL,
  `modo` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `audio`
--

CREATE TABLE `audio` (
  `idAudio` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `dispositivos` int(10) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dispositivo`
--

CREATE TABLE `dispositivo` (
  `idDispositivo` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `divisao`
--

CREATE TABLE `divisao` (
  `idDivisao` int(30) NOT NULL,
  `descricao` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `estore`
--

CREATE TABLE `estore` (
  `idEstore` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `gravacoes`
--

CREATE TABLE `gravacoes` (
  `idGravacao` int(30) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `iluminacao`
--

CREATE TABLE `iluminacao` (
  `idIluminacao` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `porta`
--

CREATE TABLE `porta` (
  `idPorta` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sensor`
--

CREATE TABLE `sensor` (
  `idSensor` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tv`
--

CREATE TABLE `tv` (
  `idTv` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `canal` int(11) NOT NULL,
  `gravacao` int(30) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alarme`
--
ALTER TABLE `alarme`
  ADD PRIMARY KEY (`idAlarme`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `sensor` (`sensor`);

--
-- Indexes for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD PRIMARY KEY (`idArCondicionado`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `audio`
--
ALTER TABLE `audio`
  ADD PRIMARY KEY (`idAudio`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `dispositivos` (`dispositivos`),
  ADD KEY `dispositivos_2` (`dispositivos`);

--
-- Indexes for table `dispositivo`
--
ALTER TABLE `dispositivo`
  ADD PRIMARY KEY (`idDispositivo`),
  ADD KEY `idDispositivo` (`idDispositivo`),
  ADD KEY `idDispositivo_2` (`idDispositivo`);

--
-- Indexes for table `divisao`
--
ALTER TABLE `divisao`
  ADD PRIMARY KEY (`idDivisao`);

--
-- Indexes for table `estore`
--
ALTER TABLE `estore`
  ADD PRIMARY KEY (`idEstore`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `gravacoes`
--
ALTER TABLE `gravacoes`
  ADD PRIMARY KEY (`idGravacao`),
  ADD KEY `idGravacao` (`idGravacao`);

--
-- Indexes for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD PRIMARY KEY (`idIluminacao`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `porta`
--
ALTER TABLE `porta`
  ADD PRIMARY KEY (`idPorta`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `sensor`
--
ALTER TABLE `sensor`
  ADD PRIMARY KEY (`idSensor`),
  ADD KEY `idSensor` (`idSensor`);

--
-- Indexes for table `tv`
--
ALTER TABLE `tv`
  ADD PRIMARY KEY (`idTv`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `gravacao` (`gravacao`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alarme`
--
ALTER TABLE `alarme`
  ADD CONSTRAINT `alarme_ibfk_1` FOREIGN KEY (`Divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alarme_ibfk_2` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`idSensor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD CONSTRAINT `ar_condicionado_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `audio`
--
ALTER TABLE `audio`
  ADD CONSTRAINT `audio_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `audio_ibfk_2` FOREIGN KEY (`dispositivos`) REFERENCES `dispositivo` (`idDispositivo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `estore`
--
ALTER TABLE `estore`
  ADD CONSTRAINT `estore_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD CONSTRAINT `iluminacao_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `porta`
--
ALTER TABLE `porta`
  ADD CONSTRAINT `porta_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tv`
--
ALTER TABLE `tv`
  ADD CONSTRAINT `tv_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tv_ibfk_2` FOREIGN KEY (`gravacao`) REFERENCES `gravacoes` (`idGravacao`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Database: `id134248_base_dados_projeto`
--
CREATE DATABASE IF NOT EXISTS `id134248_base_dados_projeto` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id134248_base_dados_projeto`;

-- --------------------------------------------------------

--
-- Table structure for table `alarme`
--

CREATE TABLE `alarme` (
  `idAlarme` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `sensor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ar_condicionado`
--

CREATE TABLE `ar_condicionado` (
  `idArCondicionado` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `temperatura` float NOT NULL,
  `modo` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `audio`
--

CREATE TABLE `audio` (
  `idAudio` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `dispositivos` int(10) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dispositivo`
--

CREATE TABLE `dispositivo` (
  `idDispositivo` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `divisao`
--

CREATE TABLE `divisao` (
  `idDivisao` int(30) NOT NULL,
  `descricao` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `estore`
--

CREATE TABLE `estore` (
  `idEstore` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `gravacoes`
--

CREATE TABLE `gravacoes` (
  `idGravacao` int(30) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `iluminacao`
--

CREATE TABLE `iluminacao` (
  `idIluminacao` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `porta`
--

CREATE TABLE `porta` (
  `idPorta` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sensor`
--

CREATE TABLE `sensor` (
  `idSensor` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tv`
--

CREATE TABLE `tv` (
  `idTv` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `canal` int(11) NOT NULL,
  `gravacao` int(30) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alarme`
--
ALTER TABLE `alarme`
  ADD PRIMARY KEY (`idAlarme`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `sensor` (`sensor`);

--
-- Indexes for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD PRIMARY KEY (`idArCondicionado`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `audio`
--
ALTER TABLE `audio`
  ADD PRIMARY KEY (`idAudio`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `dispositivos` (`dispositivos`),
  ADD KEY `dispositivos_2` (`dispositivos`);

--
-- Indexes for table `dispositivo`
--
ALTER TABLE `dispositivo`
  ADD PRIMARY KEY (`idDispositivo`),
  ADD KEY `idDispositivo` (`idDispositivo`),
  ADD KEY `idDispositivo_2` (`idDispositivo`);

--
-- Indexes for table `divisao`
--
ALTER TABLE `divisao`
  ADD PRIMARY KEY (`idDivisao`);

--
-- Indexes for table `estore`
--
ALTER TABLE `estore`
  ADD PRIMARY KEY (`idEstore`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `gravacoes`
--
ALTER TABLE `gravacoes`
  ADD PRIMARY KEY (`idGravacao`),
  ADD KEY `idGravacao` (`idGravacao`);

--
-- Indexes for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD PRIMARY KEY (`idIluminacao`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `porta`
--
ALTER TABLE `porta`
  ADD PRIMARY KEY (`idPorta`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `sensor`
--
ALTER TABLE `sensor`
  ADD PRIMARY KEY (`idSensor`),
  ADD KEY `idSensor` (`idSensor`);

--
-- Indexes for table `tv`
--
ALTER TABLE `tv`
  ADD PRIMARY KEY (`idTv`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `gravacao` (`gravacao`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alarme`
--
ALTER TABLE `alarme`
  ADD CONSTRAINT `alarme_ibfk_1` FOREIGN KEY (`Divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alarme_ibfk_2` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`idSensor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD CONSTRAINT `ar_condicionado_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `audio`
--
ALTER TABLE `audio`
  ADD CONSTRAINT `audio_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `audio_ibfk_2` FOREIGN KEY (`dispositivos`) REFERENCES `dispositivo` (`idDispositivo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `estore`
--
ALTER TABLE `estore`
  ADD CONSTRAINT `estore_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD CONSTRAINT `iluminacao_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `porta`
--
ALTER TABLE `porta`
  ADD CONSTRAINT `porta_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tv`
--
ALTER TABLE `tv`
  ADD CONSTRAINT `tv_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tv_ibfk_2` FOREIGN KEY (`gravacao`) REFERENCES `gravacoes` (`idGravacao`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Database: `id134248_base_dados_projeto`
--
CREATE DATABASE IF NOT EXISTS `id134248_base_dados_projeto` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id134248_base_dados_projeto`;

-- --------------------------------------------------------

--
-- Table structure for table `alarme`
--

CREATE TABLE `alarme` (
  `idAlarme` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `sensor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ar_condicionado`
--

CREATE TABLE `ar_condicionado` (
  `idArCondicionado` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `temperatura` float NOT NULL,
  `modo` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `audio`
--

CREATE TABLE `audio` (
  `idAudio` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `dispositivos` int(10) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dispositivo`
--

CREATE TABLE `dispositivo` (
  `idDispositivo` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `divisao`
--

CREATE TABLE `divisao` (
  `idDivisao` int(30) NOT NULL,
  `descricao` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `estore`
--

CREATE TABLE `estore` (
  `idEstore` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `gravacoes`
--

CREATE TABLE `gravacoes` (
  `idGravacao` int(30) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `iluminacao`
--

CREATE TABLE `iluminacao` (
  `idIluminacao` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `porta`
--

CREATE TABLE `porta` (
  `idPorta` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sensor`
--

CREATE TABLE `sensor` (
  `idSensor` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tv`
--

CREATE TABLE `tv` (
  `idTv` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `canal` int(11) NOT NULL,
  `gravacao` int(30) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alarme`
--
ALTER TABLE `alarme`
  ADD PRIMARY KEY (`idAlarme`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `sensor` (`sensor`);

--
-- Indexes for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD PRIMARY KEY (`idArCondicionado`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `audio`
--
ALTER TABLE `audio`
  ADD PRIMARY KEY (`idAudio`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `dispositivos` (`dispositivos`),
  ADD KEY `dispositivos_2` (`dispositivos`);

--
-- Indexes for table `dispositivo`
--
ALTER TABLE `dispositivo`
  ADD PRIMARY KEY (`idDispositivo`),
  ADD KEY `idDispositivo` (`idDispositivo`),
  ADD KEY `idDispositivo_2` (`idDispositivo`);

--
-- Indexes for table `divisao`
--
ALTER TABLE `divisao`
  ADD PRIMARY KEY (`idDivisao`);

--
-- Indexes for table `estore`
--
ALTER TABLE `estore`
  ADD PRIMARY KEY (`idEstore`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `gravacoes`
--
ALTER TABLE `gravacoes`
  ADD PRIMARY KEY (`idGravacao`),
  ADD KEY `idGravacao` (`idGravacao`);

--
-- Indexes for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD PRIMARY KEY (`idIluminacao`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `porta`
--
ALTER TABLE `porta`
  ADD PRIMARY KEY (`idPorta`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `sensor`
--
ALTER TABLE `sensor`
  ADD PRIMARY KEY (`idSensor`),
  ADD KEY `idSensor` (`idSensor`);

--
-- Indexes for table `tv`
--
ALTER TABLE `tv`
  ADD PRIMARY KEY (`idTv`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `gravacao` (`gravacao`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alarme`
--
ALTER TABLE `alarme`
  ADD CONSTRAINT `alarme_ibfk_1` FOREIGN KEY (`Divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alarme_ibfk_2` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`idSensor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD CONSTRAINT `ar_condicionado_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `audio`
--
ALTER TABLE `audio`
  ADD CONSTRAINT `audio_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `audio_ibfk_2` FOREIGN KEY (`dispositivos`) REFERENCES `dispositivo` (`idDispositivo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `estore`
--
ALTER TABLE `estore`
  ADD CONSTRAINT `estore_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD CONSTRAINT `iluminacao_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `porta`
--
ALTER TABLE `porta`
  ADD CONSTRAINT `porta_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tv`
--
ALTER TABLE `tv`
  ADD CONSTRAINT `tv_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tv_ibfk_2` FOREIGN KEY (`gravacao`) REFERENCES `gravacoes` (`idGravacao`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Database: `id134248_base_dados_projeto`
--
CREATE DATABASE IF NOT EXISTS `id134248_base_dados_projeto` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id134248_base_dados_projeto`;

-- --------------------------------------------------------

--
-- Table structure for table `alarme`
--

CREATE TABLE `alarme` (
  `idAlarme` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `sensor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ar_condicionado`
--

CREATE TABLE `ar_condicionado` (
  `idArCondicionado` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `temperatura` float NOT NULL,
  `modo` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `audio`
--

CREATE TABLE `audio` (
  `idAudio` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `dispositivos` int(10) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dispositivo`
--

CREATE TABLE `dispositivo` (
  `idDispositivo` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `divisao`
--

CREATE TABLE `divisao` (
  `idDivisao` int(30) NOT NULL,
  `descricao` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `estore`
--

CREATE TABLE `estore` (
  `idEstore` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `gravacoes`
--

CREATE TABLE `gravacoes` (
  `idGravacao` int(30) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `iluminacao`
--

CREATE TABLE `iluminacao` (
  `idIluminacao` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `porta`
--

CREATE TABLE `porta` (
  `idPorta` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sensor`
--

CREATE TABLE `sensor` (
  `idSensor` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tv`
--

CREATE TABLE `tv` (
  `idTv` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `canal` int(11) NOT NULL,
  `gravacao` int(30) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alarme`
--
ALTER TABLE `alarme`
  ADD PRIMARY KEY (`idAlarme`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `sensor` (`sensor`);

--
-- Indexes for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD PRIMARY KEY (`idArCondicionado`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `audio`
--
ALTER TABLE `audio`
  ADD PRIMARY KEY (`idAudio`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `dispositivos` (`dispositivos`),
  ADD KEY `dispositivos_2` (`dispositivos`);

--
-- Indexes for table `dispositivo`
--
ALTER TABLE `dispositivo`
  ADD PRIMARY KEY (`idDispositivo`),
  ADD KEY `idDispositivo` (`idDispositivo`),
  ADD KEY `idDispositivo_2` (`idDispositivo`);

--
-- Indexes for table `divisao`
--
ALTER TABLE `divisao`
  ADD PRIMARY KEY (`idDivisao`);

--
-- Indexes for table `estore`
--
ALTER TABLE `estore`
  ADD PRIMARY KEY (`idEstore`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `gravacoes`
--
ALTER TABLE `gravacoes`
  ADD PRIMARY KEY (`idGravacao`),
  ADD KEY `idGravacao` (`idGravacao`);

--
-- Indexes for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD PRIMARY KEY (`idIluminacao`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `porta`
--
ALTER TABLE `porta`
  ADD PRIMARY KEY (`idPorta`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `sensor`
--
ALTER TABLE `sensor`
  ADD PRIMARY KEY (`idSensor`),
  ADD KEY `idSensor` (`idSensor`);

--
-- Indexes for table `tv`
--
ALTER TABLE `tv`
  ADD PRIMARY KEY (`idTv`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `gravacao` (`gravacao`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alarme`
--
ALTER TABLE `alarme`
  ADD CONSTRAINT `alarme_ibfk_1` FOREIGN KEY (`Divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alarme_ibfk_2` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`idSensor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD CONSTRAINT `ar_condicionado_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `audio`
--
ALTER TABLE `audio`
  ADD CONSTRAINT `audio_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `audio_ibfk_2` FOREIGN KEY (`dispositivos`) REFERENCES `dispositivo` (`idDispositivo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `estore`
--
ALTER TABLE `estore`
  ADD CONSTRAINT `estore_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD CONSTRAINT `iluminacao_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `porta`
--
ALTER TABLE `porta`
  ADD CONSTRAINT `porta_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tv`
--
ALTER TABLE `tv`
  ADD CONSTRAINT `tv_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tv_ibfk_2` FOREIGN KEY (`gravacao`) REFERENCES `gravacoes` (`idGravacao`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Database: `id134248_base_dados_projeto`
--
CREATE DATABASE IF NOT EXISTS `id134248_base_dados_projeto` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id134248_base_dados_projeto`;

-- --------------------------------------------------------

--
-- Table structure for table `alarme`
--

CREATE TABLE `alarme` (
  `idAlarme` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `sensor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ar_condicionado`
--

CREATE TABLE `ar_condicionado` (
  `idArCondicionado` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `temperatura` float NOT NULL,
  `modo` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `audio`
--

CREATE TABLE `audio` (
  `idAudio` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `dispositivos` int(10) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dispositivo`
--

CREATE TABLE `dispositivo` (
  `idDispositivo` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `divisao`
--

CREATE TABLE `divisao` (
  `idDivisao` int(30) NOT NULL,
  `descricao` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `estore`
--

CREATE TABLE `estore` (
  `idEstore` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `gravacoes`
--

CREATE TABLE `gravacoes` (
  `idGravacao` int(30) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `iluminacao`
--

CREATE TABLE `iluminacao` (
  `idIluminacao` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `porta`
--

CREATE TABLE `porta` (
  `idPorta` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sensor`
--

CREATE TABLE `sensor` (
  `idSensor` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tv`
--

CREATE TABLE `tv` (
  `idTv` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `canal` int(11) NOT NULL,
  `gravacao` int(30) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alarme`
--
ALTER TABLE `alarme`
  ADD PRIMARY KEY (`idAlarme`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `sensor` (`sensor`);

--
-- Indexes for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD PRIMARY KEY (`idArCondicionado`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `audio`
--
ALTER TABLE `audio`
  ADD PRIMARY KEY (`idAudio`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `dispositivos` (`dispositivos`),
  ADD KEY `dispositivos_2` (`dispositivos`);

--
-- Indexes for table `dispositivo`
--
ALTER TABLE `dispositivo`
  ADD PRIMARY KEY (`idDispositivo`),
  ADD KEY `idDispositivo` (`idDispositivo`),
  ADD KEY `idDispositivo_2` (`idDispositivo`);

--
-- Indexes for table `divisao`
--
ALTER TABLE `divisao`
  ADD PRIMARY KEY (`idDivisao`);

--
-- Indexes for table `estore`
--
ALTER TABLE `estore`
  ADD PRIMARY KEY (`idEstore`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `gravacoes`
--
ALTER TABLE `gravacoes`
  ADD PRIMARY KEY (`idGravacao`),
  ADD KEY `idGravacao` (`idGravacao`);

--
-- Indexes for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD PRIMARY KEY (`idIluminacao`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `porta`
--
ALTER TABLE `porta`
  ADD PRIMARY KEY (`idPorta`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `sensor`
--
ALTER TABLE `sensor`
  ADD PRIMARY KEY (`idSensor`),
  ADD KEY `idSensor` (`idSensor`);

--
-- Indexes for table `tv`
--
ALTER TABLE `tv`
  ADD PRIMARY KEY (`idTv`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `gravacao` (`gravacao`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alarme`
--
ALTER TABLE `alarme`
  ADD CONSTRAINT `alarme_ibfk_1` FOREIGN KEY (`Divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alarme_ibfk_2` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`idSensor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD CONSTRAINT `ar_condicionado_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `audio`
--
ALTER TABLE `audio`
  ADD CONSTRAINT `audio_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `audio_ibfk_2` FOREIGN KEY (`dispositivos`) REFERENCES `dispositivo` (`idDispositivo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `estore`
--
ALTER TABLE `estore`
  ADD CONSTRAINT `estore_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD CONSTRAINT `iluminacao_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `porta`
--
ALTER TABLE `porta`
  ADD CONSTRAINT `porta_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tv`
--
ALTER TABLE `tv`
  ADD CONSTRAINT `tv_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tv_ibfk_2` FOREIGN KEY (`gravacao`) REFERENCES `gravacoes` (`idGravacao`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Database: `id134248_base_dados_projeto`
--
CREATE DATABASE IF NOT EXISTS `id134248_base_dados_projeto` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id134248_base_dados_projeto`;

-- --------------------------------------------------------

--
-- Table structure for table `alarme`
--

CREATE TABLE `alarme` (
  `idAlarme` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `sensor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ar_condicionado`
--

CREATE TABLE `ar_condicionado` (
  `idArCondicionado` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `temperatura` float NOT NULL,
  `modo` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `audio`
--

CREATE TABLE `audio` (
  `idAudio` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `dispositivos` int(10) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dispositivo`
--

CREATE TABLE `dispositivo` (
  `idDispositivo` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `divisao`
--

CREATE TABLE `divisao` (
  `idDivisao` int(30) NOT NULL,
  `descricao` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `estore`
--

CREATE TABLE `estore` (
  `idEstore` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `gravacoes`
--

CREATE TABLE `gravacoes` (
  `idGravacao` int(30) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `iluminacao`
--

CREATE TABLE `iluminacao` (
  `idIluminacao` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `intensidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `porta`
--

CREATE TABLE `porta` (
  `idPorta` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sensor`
--

CREATE TABLE `sensor` (
  `idSensor` int(10) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tv`
--

CREATE TABLE `tv` (
  `idTv` int(30) NOT NULL,
  `divisao` int(30) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `canal` int(11) NOT NULL,
  `gravacao` int(30) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alarme`
--
ALTER TABLE `alarme`
  ADD PRIMARY KEY (`idAlarme`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `sensor` (`sensor`);

--
-- Indexes for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD PRIMARY KEY (`idArCondicionado`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `audio`
--
ALTER TABLE `audio`
  ADD PRIMARY KEY (`idAudio`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `dispositivos` (`dispositivos`),
  ADD KEY `dispositivos_2` (`dispositivos`);

--
-- Indexes for table `dispositivo`
--
ALTER TABLE `dispositivo`
  ADD PRIMARY KEY (`idDispositivo`),
  ADD KEY `idDispositivo` (`idDispositivo`),
  ADD KEY `idDispositivo_2` (`idDispositivo`);

--
-- Indexes for table `divisao`
--
ALTER TABLE `divisao`
  ADD PRIMARY KEY (`idDivisao`);

--
-- Indexes for table `estore`
--
ALTER TABLE `estore`
  ADD PRIMARY KEY (`idEstore`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `gravacoes`
--
ALTER TABLE `gravacoes`
  ADD PRIMARY KEY (`idGravacao`),
  ADD KEY `idGravacao` (`idGravacao`);

--
-- Indexes for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD PRIMARY KEY (`idIluminacao`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `porta`
--
ALTER TABLE `porta`
  ADD PRIMARY KEY (`idPorta`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `sensor`
--
ALTER TABLE `sensor`
  ADD PRIMARY KEY (`idSensor`),
  ADD KEY `idSensor` (`idSensor`);

--
-- Indexes for table `tv`
--
ALTER TABLE `tv`
  ADD PRIMARY KEY (`idTv`),
  ADD KEY `divisao` (`divisao`),
  ADD KEY `gravacao` (`gravacao`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alarme`
--
ALTER TABLE `alarme`
  ADD CONSTRAINT `alarme_ibfk_1` FOREIGN KEY (`Divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alarme_ibfk_2` FOREIGN KEY (`sensor`) REFERENCES `sensor` (`idSensor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD CONSTRAINT `ar_condicionado_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `audio`
--
ALTER TABLE `audio`
  ADD CONSTRAINT `audio_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `audio_ibfk_2` FOREIGN KEY (`dispositivos`) REFERENCES `dispositivo` (`idDispositivo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `estore`
--
ALTER TABLE `estore`
  ADD CONSTRAINT `estore_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD CONSTRAINT `iluminacao_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `porta`
--
ALTER TABLE `porta`
  ADD CONSTRAINT `porta_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tv`
--
ALTER TABLE `tv`
  ADD CONSTRAINT `tv_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`idDivisao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tv_ibfk_2` FOREIGN KEY (`gravacao`) REFERENCES `gravacoes` (`idGravacao`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
