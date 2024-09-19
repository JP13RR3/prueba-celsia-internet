--
-- Base de datos: `celsiaInternet`
--

-- --------------------------------------------------------

--
-- tabla `clientes`
--

CREATE TABLE `clientes` (
  `identificacion` varchar(20) NOT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `tipoIdentificacion` varchar(255) DEFAULT NULL,
  `fechaNacimiento` date NOT NULL,
  `numeroCelular` varchar(255) DEFAULT NULL,
  `correoElectronico` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- --------------------------------------------------------

--
--  tabla `servicios`
--

CREATE TABLE `servicios` (
  `identificacion` varchar(20) NOT NULL,
  `servicio` varchar(255) NOT NULL,
  `fechaInicio` date NOT NULL,
  `ultimaFacturacion` date NOT NULL,
  `ultimoPago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`identificacion`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`identificacion`,`servicio`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD CONSTRAINT `servicios_FK1` FOREIGN KEY (`identificacion`) REFERENCES `clientes` (`identificacion`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

