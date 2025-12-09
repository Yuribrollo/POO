-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 09, 2025 at 07:15 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gjmanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `avaliação`
--

CREATE TABLE `avaliação` (
  `idAval` int(11) NOT NULL,
  `notaAval` enum('0','1','2','3','4','5') NOT NULL,
  `comentAval` text NOT NULL,
  `idJogoAval` int(11) NOT NULL,
  `idUsuAval` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `avaliação`
--

INSERT INTO `avaliação` (`idAval`, `notaAval`, `comentAval`, `idJogoAval`, `idUsuAval`) VALUES
(6, '5', 'shjhtrjhtejet', 5, 10);

-- --------------------------------------------------------

--
-- Table structure for table `equipe`
--

CREATE TABLE `equipe` (
  `idEquipe` int(11) NOT NULL,
  `nomeEquipe` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `equipe`
--

INSERT INTO `equipe` (`idEquipe`, `nomeEquipe`) VALUES
(2, 'The Feitos'),
(3, 'nananna'),
(4, 'fhdfhrrh'),
(5, 'eeeeee'),
(6, 'aaaa'),
(7, 'Timão'),
(8, 'Equipe'),
(9, 'Time Tal'),
(10, 'Nova Equipe');

-- --------------------------------------------------------

--
-- Table structure for table `equipe_usuario`
--

CREATE TABLE `equipe_usuario` (
  `idEquipe` int(11) NOT NULL,
  `idUsu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `equipe_usuario`
--

INSERT INTO `equipe_usuario` (`idEquipe`, `idUsu`) VALUES
(4, 7),
(5, 7),
(6, 7),
(7, 1),
(7, 6),
(7, 7),
(8, 1),
(8, 6),
(8, 7),
(8, 9),
(9, 1),
(10, 1),
(10, 6),
(10, 7),
(10, 9),
(10, 10);

-- --------------------------------------------------------

--
-- Table structure for table `gamejam`
--

CREATE TABLE `gamejam` (
  `idGJ` int(11) NOT NULL,
  `nomeGJ` varchar(100) NOT NULL,
  `temaGJ` varchar(100) NOT NULL,
  `duraGJ` text NOT NULL,
  `premioGJ` varchar(500) NOT NULL,
  `descGJ` varchar(800) NOT NULL,
  `dataInicioGJ` text NOT NULL,
  `dataFimGJ` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gamejam`
--

INSERT INTO `gamejam` (`idGJ`, `nomeGJ`, `temaGJ`, `duraGJ`, `premioGJ`, `descGJ`, `dataInicioGJ`, `dataFimGJ`) VALUES
(3, 'Game Jam do yuri', 'um tema muito bom', '10 mil anos', 'Nada', 'Não vou desrever', 'Ontem', 'Nunca'),
(4, 'Game Jam POW', 'POW', 'POW', 'POW', 'Achou q eu ia escrever POW né?', 'POW', 'WOP');

-- --------------------------------------------------------

--
-- Table structure for table `jogo`
--

CREATE TABLE `jogo` (
  `idJogo` int(11) NOT NULL,
  `nomeJogo` varchar(100) NOT NULL,
  `generoJogo` varchar(100) NOT NULL,
  `descJogo` varchar(500) NOT NULL,
  `idEquipeJogo` int(11) NOT NULL,
  `idGJJogo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jogo`
--

INSERT INTO `jogo` (`idJogo`, `nomeJogo`, `generoJogo`, `descJogo`, `idEquipeJogo`, `idGJJogo`) VALUES
(4, 'Joguinho Tal', 'Simulação', 'jogo de plataforma', 9, 3),
(5, 'Oloco Meu!', 'VR', 'OLOCO MEU!', 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsu` int(11) NOT NULL,
  `nomeUsu` varchar(100) NOT NULL,
  `emailUsu` varchar(100) NOT NULL,
  `senhaUsu` varchar(100) NOT NULL,
  `tipoUsu` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`idUsu`, `nomeUsu`, `emailUsu`, `senhaUsu`, `tipoUsu`) VALUES
(1, 'Yuri Brollo', 'yuribrollo97@gmail.com', '', 'participante'),
(6, 'Fulano', 'fulanodasilva@gmail.com', '', 'organizador'),
(7, 'Beltrano', 'beltrano@gmail.com', '456', 'jogador'),
(9, 'Alalalulu', 'alalalulu@gmail.com', '', 'organizador'),
(10, 'Marvena', 'mar@gmail.com', '', 'organizador');

--
-- Triggers `usuarios`
--
DELIMITER $$
CREATE TRIGGER `inserir_participante` AFTER INSERT ON `usuarios` FOR EACH ROW BEGIN
    IF NEW.tipoUsu = 'participante' THEN
        INSERT INTO participantes (idUsu)
        VALUES (NEW.idUsu);
    END IF;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `avaliação`
--
ALTER TABLE `avaliação`
  ADD PRIMARY KEY (`idAval`),
  ADD KEY `idJogoAval` (`idJogoAval`),
  ADD KEY `idUsuAval` (`idUsuAval`);

--
-- Indexes for table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`idEquipe`);

--
-- Indexes for table `equipe_usuario`
--
ALTER TABLE `equipe_usuario`
  ADD PRIMARY KEY (`idEquipe`,`idUsu`),
  ADD KEY `idUsu` (`idUsu`);

--
-- Indexes for table `gamejam`
--
ALTER TABLE `gamejam`
  ADD PRIMARY KEY (`idGJ`);

--
-- Indexes for table `jogo`
--
ALTER TABLE `jogo`
  ADD PRIMARY KEY (`idJogo`),
  ADD KEY `idEquipeJogo` (`idEquipeJogo`),
  ADD KEY `idGJJogo` (`idGJJogo`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsu`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `avaliação`
--
ALTER TABLE `avaliação`
  MODIFY `idAval` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `idEquipe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `gamejam`
--
ALTER TABLE `gamejam`
  MODIFY `idGJ` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `jogo`
--
ALTER TABLE `jogo`
  MODIFY `idJogo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `avaliação`
--
ALTER TABLE `avaliação`
  ADD CONSTRAINT `idJogoAval` FOREIGN KEY (`idJogoAval`) REFERENCES `jogo` (`idJogo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idUsuAval` FOREIGN KEY (`idUsuAval`) REFERENCES `usuarios` (`idUsu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `equipe_usuario`
--
ALTER TABLE `equipe_usuario`
  ADD CONSTRAINT `equipe_usuario_ibfk_1` FOREIGN KEY (`idEquipe`) REFERENCES `equipe` (`idEquipe`),
  ADD CONSTRAINT `equipe_usuario_ibfk_2` FOREIGN KEY (`idUsu`) REFERENCES `usuarios` (`idUsu`);

--
-- Constraints for table `jogo`
--
ALTER TABLE `jogo`
  ADD CONSTRAINT `idEquipeJogo` FOREIGN KEY (`idEquipeJogo`) REFERENCES `equipe` (`idEquipe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idGJJogo` FOREIGN KEY (`idGJJogo`) REFERENCES `gamejam` (`idGJ`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
