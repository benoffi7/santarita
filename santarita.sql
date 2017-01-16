-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-01-2017 a las 14:44:45
-- Versión del servidor: 10.1.10-MariaDB
-- Versión de PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `santarita`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `adicionales`
--

CREATE TABLE `adicionales` (
  `id` int(11) NOT NULL,
  `idAd` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `adicionales`
--

INSERT INTO `adicionales` (`id`, `idAd`) VALUES
(66, 39),
(66, 40),
(66, 41),
(66, 42),
(66, 43),
(66, 46),
(66, 47),
(66, 48),
(67, 39),
(67, 40),
(67, 41),
(67, 42),
(67, 43),
(67, 46),
(67, 47),
(67, 48),
(68, 39),
(68, 40),
(68, 41),
(68, 42),
(68, 43),
(68, 46),
(68, 47),
(68, 48),
(69, 39),
(69, 40),
(69, 41),
(69, 42),
(69, 43),
(69, 46),
(69, 47),
(69, 48),
(72, 39),
(72, 40),
(72, 41),
(72, 42),
(72, 43),
(72, 46),
(72, 47),
(72, 48),
(73, 39),
(73, 40),
(73, 41),
(73, 42),
(73, 43),
(73, 46),
(73, 47),
(73, 48),
(82, 44),
(82, 45),
(82, 46),
(83, 44),
(83, 45),
(83, 46),
(84, 44),
(84, 45),
(84, 46),
(96, 39),
(96, 40),
(96, 41),
(96, 42),
(96, 43),
(96, 46),
(70, 39),
(70, 40),
(70, 41),
(70, 42),
(70, 43),
(70, 46),
(70, 47),
(70, 48),
(99, 39),
(99, 40),
(99, 41),
(99, 42),
(99, 43),
(99, 46),
(99, 47),
(99, 48);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL,
  `adicional` int(11) NOT NULL,
  `categoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `codigo`, `nombre`, `precio`, `adicional`, `categoria`) VALUES
(1, '2', 'Mejillones pulpa', 200, 0, 'Platos fríos'),
(2, '3', 'Calamar provenzal', 140, 0, 'Platos fríos'),
(3, '7', 'Ensalada de langostinos', 200, 0, 'Platos fríos'),
(4, '8', 'Langostinos pelados', 220, 0, 'Platos fríos'),
(5, '9', 'Ensalada de mariscos provenzal', 220, 0, 'Platos fríos'),
(6, '10', 'Calamar a la criolla', 140, 0, 'Platos fríos'),
(8, '14', 'Filet Merluza Escabeche', 120, 0, 'Platos fríos'),
(9, '15', 'Mayonesa de atún', 90, 0, 'Platos fríos'),
(10, '91', 'Picada Santa Rita fría', 360, 0, 'Platos fríos'),
(11, '17', 'Atún a la Italiana', 110, 0, 'Platos fríos'),
(12, '97', 'Chipirones Provenzal/Criolla', 210, 0, 'Platos fríos'),
(13, '211', 'Kanikama', 175, 0, 'Platos fríos'),
(14, '19', 'Cazuela de mariscos', 160, 0, 'Platos calientes'),
(15, '20', 'Cazuela de calamar', 150, 0, 'Platos calientes'),
(16, '257', 'Cazuela de pulpo', 480, 0, 'Platos calientes'),
(17, '21', 'Mejillones provenzal', 210, 0, 'Platos calientes'),
(18, '181', 'Mejillones a la Recanatti', 275, 0, 'Platos calientes'),
(19, '206', 'Mejillones Renata', 275, 0, 'Platos calientes'),
(20, '23', 'Fideos con mariscos', 280, 0, 'Platos calientes'),
(21, '27', 'Fideos con calamar', 260, 0, 'Platos calientes'),
(22, '29', 'Fideos con mejillones', 270, 0, 'Platos calientes'),
(23, '175', 'Fideos con chipirones', 320, 0, 'Platos calientes'),
(24, '77', 'Fideos con langostinos', 320, 0, 'Platos calientes'),
(25, '202', 'Sorrentinos de salmón', 200, 0, 'Platos calientes'),
(26, '30', 'Empanada gallega', 60, 0, 'Platos calientes'),
(27, '31', 'Arroz con calamar', 260, 0, 'Platos calientes'),
(28, '22', 'Arroz con mariscos', 280, 0, 'Platos calientes'),
(29, '99', 'Arroz con mejillones', 270, 0, 'Platos calientes'),
(30, '221', 'Arroz con chipirones', 320, 0, 'Platos calientes'),
(31, '122', 'Arroz con langostinos', 320, 0, 'Platos calientes'),
(32, '124', 'Canelones de atún', 160, 0, 'Platos calientes'),
(34, '262', 'Vieyras', 280, 0, 'Platos calientes'),
(35, '24', 'Chupín de abadejo', 275, 0, 'Platos calientes'),
(36, '25', 'Pulpo a la Gallega', 480, 0, 'Platos calientes'),
(37, '90', 'Gambas al Ajillo', 380, 0, 'Platos calientes'),
(38, '249', 'Wok de langostinos', 250, 0, 'Platos calientes'),
(39, '101', 'Al toque', 45, 1, 'Salsas'),
(40, '253', 'Salsa de Verdeo', 45, 1, 'Salsas'),
(41, '254', 'Manteca Negra', 45, 1, 'Salsas'),
(42, '255', 'Crema de langostinos', 45, 1, 'Salsas'),
(43, '256', 'Roquefort', 45, 1, 'Salsas'),
(44, '1000', 'Fileto', 45, 1, 'Salsas'),
(45, '1001', 'Manteca', 45, 1, 'Salsas'),
(46, '1002', 'Solo', 45, 1, 'Salsas'),
(47, '1003', 'Provenzal', 45, 1, 'Salsas'),
(48, '1004', 'Vasca', 45, 1, 'Salsas'),
(49, '78', 'Calamarettes', 160, 0, 'Frituras'),
(50, '79', 'Cornalitos', 80, 0, 'Frituras'),
(51, '80', 'Rabas', 120, 0, 'Frituras'),
(52, '119', 'Rabas a la Francesa', 140, 0, 'Frituras'),
(53, '81', 'Bocaditos de brótola', 110, 0, 'Frituras'),
(54, '82', 'Palitos de brótola', 110, 0, 'Frituras'),
(55, '83', 'Filet de merluza', 110, 0, 'Frituras'),
(56, '89', 'Filet de palo', 110, 0, 'Frituras'),
(57, '203', 'Langostinos empanados', 220, 0, 'Frituras'),
(59, '86', 'Empanada de atún Horno', 25, 0, 'Frituras'),
(60, '208', 'Empanada de atún Frita', 25, 0, 'Frituras'),
(61, '247', 'Empanada de langostinos', 30, 0, 'Frituras'),
(62, '250', 'Empanada de salmón', 30, 0, 'Frituras'),
(63, '87', 'Picada Santa Rita Cte', 360, 0, 'Frituras'),
(64, '205', 'Muslito de cangrejo', 25, 0, 'Frituras'),
(65, '121', 'Papas fritas', 60, 0, 'Frituras'),
(66, '141', 'Merluzón', 185, 0, 'A la plancha'),
(67, '32', 'Salmón', 185, 0, 'A la plancha'),
(68, '33', 'Salmón rosado', 290, 0, 'A la plancha'),
(69, '34', 'Filet de lenguado', 190, 0, 'A la plancha'),
(70, '35', 'Filet de abadejo', 200, 0, 'A la plancha'),
(71, '39', 'Pizza de pescado', 165, 0, 'A la plancha'),
(72, '139', 'Chernia', 280, 0, 'A la plancha'),
(74, '41', 'Rusa', 60, 0, 'Ensaladas'),
(75, '42', 'Tomate', 50, 0, 'Ensaladas'),
(76, '43', 'Rúcula', 50, 0, 'Ensaladas'),
(77, '44', 'Lechuga', 40, 0, 'Ensaladas'),
(78, '47', 'Zanahoria', 50, 0, 'Ensaladas'),
(79, '49', 'Choclo', 40, 0, 'Ensaladas'),
(80, '128', 'Chaucha', 40, 0, 'Ensaladas'),
(81, '50', 'Mixta', 60, 0, 'Ensaladas'),
(82, '28', 'Fideos', 80, 0, 'Otros platos'),
(83, '143', 'Ñoquis', 80, 0, 'Otros platos'),
(84, '144', 'Ravioles', 80, 0, 'Otros platos'),
(85, '300', 'Panzotti', 190, 0, 'Otros platos'),
(86, '26', 'Arroz blanco', 50, 0, 'Otros platos'),
(87, '125', 'Puré', 50, 0, 'Otros platos'),
(88, '245', 'Papas al natural', 45, 0, 'Otros platos'),
(89, '107', 'Infantil Patitas', 90, 0, 'Otros platos'),
(90, '85', 'Infantil Hamburguesa', 90, 0, 'Otros platos'),
(91, '40', 'Pan', 5, 0, 'Otros platos'),
(93, '260', 'Menú del día', 180, 0, 'Otros platos'),
(94, '45', 'Ensalada de atún', 175, 0, 'Platos fríos'),
(95, '258', 'Langostinos Olivia', 350, 0, 'Platos calientes'),
(96, '84', 'Filet de lenguado', 140, 0, 'Frituras'),
(97, '251', 'Ensalada de mariscos escabeche', 220, 0, 'Platos fríos'),
(98, '46', 'Repollo', 40, 0, 'Ensaladas'),
(99, '140', 'Besugo', 180, 0, 'A la plancha'),
(100, '11', 'Pulpo a la provenzal', 480, 0, 'Platos fríos'),
(101, '121', 'Papas fritas', 60, 0, 'Celiaco'),
(103, '104', 'Paella', 380, 0, 'Celiaco'),
(104, '104', 'Paella', 380, 0, 'Platos calientes'),
(105, '129', 'Don Roque', 480, 0, 'Otros platos');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
