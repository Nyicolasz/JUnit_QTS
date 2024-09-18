-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13/09/2023 às 03:27
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pizzaria_mysql`
create database `pizzaria_MySql`;
use `pizzaria_MySql`;
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `cod_cliente` int(11) NOT NULL,
  `nome_cliente` varchar(50) NOT NULL,
  `telefone_cliente` varchar(20) NOT NULL,
  `endereco_cliente` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cliente`
--

INSERT INTO `cliente` (`cod_cliente`, `nome_cliente`, `telefone_cliente`, `endereco_cliente`) VALUES
(2, 'erik', '(11) 11111-1111', 'R. Girafales, 111'),
(3, 'gewgvesg', '(55) 55555-5555', 'grdrsg'),
(4, 'gsgs', '(11) 11111-1111', '[~´çlfjhg'),
(5, 'jhg', '(25) 24257-0870', 'zcsvb'),
(6, 'dafsf', '(88) 88888-8888', 'dsfdnfhm');

-- --------------------------------------------------------

--
-- Estrutura para tabela `complemento`
--

CREATE TABLE `complemento` (
  `cod_pizza` int(11) NOT NULL,
  `cod_ingrediente` int(11) NOT NULL,
  `quantidade_ingrediente` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `compra`
--

CREATE TABLE `compra` (
  `cod_compra` int(11) NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  `data_compra` varchar(20) NOT NULL,
  `cod_funcionario` int(11) NOT NULL,
  `cod_pizza` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `compra`
--

INSERT INTO `compra` (`cod_compra`, `cod_cliente`, `data_compra`, `cod_funcionario`, `cod_pizza`) VALUES
(8, 6, '02/05/2000', 1, 9),
(7, 5, '02/05/2000', 1, 8),
(6, 4, '02/05/2000', 1, 7),
(9, 4, '02/05/2000', 1, 7),
(10, 4, '02/05/2000', 1, 7);

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `cod_funcionario` int(11) NOT NULL,
  `usuario_funcionario` varchar(20) NOT NULL,
  `senha_funcionario` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `funcionario`
--

INSERT INTO `funcionario` (`cod_funcionario`, `usuario_funcionario`, `senha_funcionario`) VALUES
(1, 'admin', 123);

-- --------------------------------------------------------

--
-- Estrutura para tabela `ingrediente`
--

CREATE TABLE `ingrediente` (
  `cod_ingrediente` int(11) NOT NULL,
  `nome_ingrediente` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pizza`
--

CREATE TABLE `pizza` (
  `cod_pizza` int(11) NOT NULL,
  `preco_pizza` float NOT NULL,
  `nome_pizza` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pizza`
--

INSERT INTO `pizza` (`cod_pizza`, `preco_pizza`, `nome_pizza`) VALUES
(6, 80.03, 'pepinohfdn'),
(5, 80, 'pepino'),
(7, 50, 'cas'),
(8, 80.05, 'pepinoífh'),
(9, 90, 'jtx');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_cliente`);

--
-- Índices de tabela `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`cod_compra`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`cod_funcionario`);

--
-- Índices de tabela `ingrediente`
--
ALTER TABLE `ingrediente`
  ADD PRIMARY KEY (`cod_ingrediente`);

--
-- Índices de tabela `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`cod_pizza`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cod_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `compra`
--
ALTER TABLE `compra`
  MODIFY `cod_compra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `cod_funcionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `ingrediente`
--
ALTER TABLE `ingrediente`
  MODIFY `cod_ingrediente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pizza`
--
ALTER TABLE `pizza`
  MODIFY `cod_pizza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
