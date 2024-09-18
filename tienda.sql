-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para tienda
CREATE DATABASE IF NOT EXISTS `tienda` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tienda`;

-- Volcando estructura para tabla tienda.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla tienda.categoria: ~3 rows (aproximadamente)
INSERT INTO `categoria` (`id`, `nombre`) VALUES
	(1, 'Alimento'),
	(2, 'Herramienta'),
	(3, 'Electronica');

-- Volcando estructura para tabla tienda.coeficientes_reconocimiento
CREATE TABLE IF NOT EXISTS `coeficientes_reconocimiento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hasta_dos_productos` double NOT NULL,
  `mas_de_dos_productos` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla tienda.coeficientes_reconocimiento: ~1 rows (aproximadamente)
INSERT INTO `coeficientes_reconocimiento` (`id`, `hasta_dos_productos`, `mas_de_dos_productos`) VALUES
	(1, 0.05, 0.1);

-- Volcando estructura para tabla tienda.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `categoria_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkxdt4u9c4w6vveo7ylph4pd09` (`codigo`),
  KEY `FKodqr7965ok9rwquj1utiamt0m` (`categoria_id`),
  CONSTRAINT `FKodqr7965ok9rwquj1utiamt0m` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla tienda.producto: ~4 rows (aproximadamente)
INSERT INTO `producto` (`id`, `codigo`, `nombre`, `precio`, `categoria_id`) VALUES
	(1, 'PROD001', 'Pan', 2000, 1),
	(2, 'PROD002', 'Pizza', 7500, 1),
	(3, 'PROD003', 'Martillo', 15000, 2),
	(4, 'PROD004', 'Microfono', 25000, 3);

-- Volcando estructura para tabla tienda.vendedor
CREATE TABLE IF NOT EXISTS `vendedor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `dni` double NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `sueldo` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKl6pg3ooa1s92b7j1k8xj769bc` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla tienda.vendedor: ~1 rows (aproximadamente)
INSERT INTO `vendedor` (`id`, `apellido`, `codigo`, `dni`, `nombre`, `sueldo`) VALUES
	(1, 'Puddini', 'VEN001', 44395233, 'Elias', 450000);

-- Volcando estructura para tabla tienda.venta
CREATE TABLE IF NOT EXISTS `venta` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `total` double NOT NULL,
  `vendedor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK4e2obucvhvadmspx337jj0nex` (`codigo`),
  KEY `FKsr0rod3g9vfdle64ypjgbyajr` (`vendedor_id`),
  CONSTRAINT `FKsr0rod3g9vfdle64ypjgbyajr` FOREIGN KEY (`vendedor_id`) REFERENCES `vendedor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla tienda.venta: ~1 rows (aproximadamente)
INSERT INTO `venta` (`id`, `codigo`, `fecha`, `total`, `vendedor_id`) VALUES
	(1, 'VENT001', '2024-09-18 15:18:38.099830', 42000, 1);

-- Volcando estructura para tabla tienda.venta_producto
CREATE TABLE IF NOT EXISTS `venta_producto` (
  `venta_id` bigint NOT NULL,
  `producto_id` bigint NOT NULL,
  KEY `FKb2il57tnln4f0a9w4stemgkf` (`producto_id`),
  KEY `FKronca5o2jla5egtlku8lm1dbn` (`venta_id`),
  CONSTRAINT `FKb2il57tnln4f0a9w4stemgkf` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`),
  CONSTRAINT `FKronca5o2jla5egtlku8lm1dbn` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla tienda.venta_producto: ~3 rows (aproximadamente)
INSERT INTO `venta_producto` (`venta_id`, `producto_id`) VALUES
	(1, 1),
	(1, 3),
	(1, 4);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
