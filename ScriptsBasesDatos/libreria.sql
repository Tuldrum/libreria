-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-07-2022 a las 17:22:18
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libreria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `car`
--

CREATE TABLE `car` (
  `car_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `car`
--

INSERT INTO `car` (`car_id`, `user_id`) VALUES
(4, 21),
(5, 22),
(6, 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `car_items`
--

CREATE TABLE `car_items` (
  `id` int(11) NOT NULL,
  `libro_id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT 0,
  `modificado` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `car_items`
--

INSERT INTO `car_items` (`id`, `libro_id`, `car_id`, `cantidad`, `modificado`) VALUES
(18, 2, 5, 2, '2022-07-01 03:11:42'),
(20, 12, 5, 2, '2022-07-02 15:16:32');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `lb_id` int(11) NOT NULL,
  `lb_titulo` varchar(100) NOT NULL,
  `lb_ano` varchar(4) NOT NULL,
  `lb_images` varchar(1000) NOT NULL DEFAULT 'http://drive.google.com/uc?export=view&id=1mHY0EtifhcVS2LyjNFAK9x2c3e-fs6_m',
  `lb_precio` float NOT NULL,
  `lb_cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`lb_id`, `lb_titulo`, `lb_ano`, `lb_images`, `lb_precio`, `lb_cantidad`) VALUES
(1, 'El idiota', '1869', 'http://drive.google.com/uc?export=view&id=1nJjlS8l6Q0WRfbeukWAMkkWdjTc_G7u4', 57000, 14),
(2, 'El extranjero', '1942', 'http://drive.google.com/uc?export=view&id=1gd_4HVxc6MNp6RmNgTA910a4ND-cOMog ', 47000, 13),
(12, 'La peste', '1947', 'http://drive.google.com/uc?export=view&id=1NteeEskQi7KQ-6hU9vF6WkUD6dPpd8t2', 78000, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`car_id`,`user_id`);

--
-- Indices de la tabla `car_items`
--
ALTER TABLE `car_items`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`lb_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `car`
--
ALTER TABLE `car`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `car_items`
--
ALTER TABLE `car_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `lb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
