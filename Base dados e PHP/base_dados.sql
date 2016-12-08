-- phpMyAdmin SQL Dump
-- version 4.6.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 09, 2016 at 12:46 AM
-- Server version: 10.1.18-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id122177_domotica`
--

-- --------------------------------------------------------

--
-- Table structure for table `alarme`
--

CREATE TABLE `alarme` (
  `id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `divisao` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ligado` tinyint(1) NOT NULL,
  `tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ar_condicionado`
--

CREATE TABLE `ar_condicionado` (
  `id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `divisao` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ligado` tinyint(1) NOT NULL,
  `temperatura` int(11) NOT NULL,
  `intensidade` int(11) NOT NULL,
  `modo` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `audio`
--

CREATE TABLE `audio` (
  `id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `divisao` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ligado` tinyint(1) NOT NULL,
  `radio` tinyint(1) NOT NULL,
  `cd_dvd` tinyint(1) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `divisao`
--

CREATE TABLE `divisao` (
  `id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `descricao` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `divisao`
--

INSERT INTO `divisao` (`id`, `descricao`) VALUES
('300', 'hall'),
('500', 'quarto'),
('501', 'hall'),
('6', 'quarto');

-- --------------------------------------------------------

--
-- Table structure for table `estore`
--

CREATE TABLE `estore` (
  `id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `divisao` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `aberto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `iluminacao`
--

CREATE TABLE `iluminacao` (
  `id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `divisao` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ligado` tinyint(1) NOT NULL,
  `intensidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `porta`
--

CREATE TABLE `porta` (
  `id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `divisao` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `aberto` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tv`
--

CREATE TABLE `tv` (
  `id` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `divisao` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ligado` tinyint(1) NOT NULL,
  `canal` int(11) NOT NULL,
  `gravacao` tinyint(1) NOT NULL,
  `volume` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alarme`
--
ALTER TABLE `alarme`
  ADD PRIMARY KEY (`id`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `audio`
--
ALTER TABLE `audio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `divisao`
--
ALTER TABLE `divisao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `estore`
--
ALTER TABLE `estore`
  ADD PRIMARY KEY (`id`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `porta`
--
ALTER TABLE `porta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `divisao` (`divisao`);

--
-- Indexes for table `tv`
--
ALTER TABLE `tv`
  ADD PRIMARY KEY (`id`),
  ADD KEY `divisao` (`divisao`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `alarme`
--
ALTER TABLE `alarme`
  ADD CONSTRAINT `alarme_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ar_condicionado`
--
ALTER TABLE `ar_condicionado`
  ADD CONSTRAINT `ar_condicionado_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `audio`
--
ALTER TABLE `audio`
  ADD CONSTRAINT `audio_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `estore`
--
ALTER TABLE `estore`
  ADD CONSTRAINT `estore_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `iluminacao`
--
ALTER TABLE `iluminacao`
  ADD CONSTRAINT `iluminacao_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `porta`
--
ALTER TABLE `porta`
  ADD CONSTRAINT `porta_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tv`
--
ALTER TABLE `tv`
  ADD CONSTRAINT `tv_ibfk_1` FOREIGN KEY (`divisao`) REFERENCES `divisao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;