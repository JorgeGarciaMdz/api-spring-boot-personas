-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: sicos
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `PROVINCIA_ID` bigint NOT NULL,
  `DELETED` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_ciudad_provincia` (`PROVINCIA_ID`) USING BTREE,
  CONSTRAINT `FK_ciudad_provincia` FOREIGN KEY (`PROVINCIA_ID`) REFERENCES `provincia` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'BANDERA',5,0),(2,'OLAVARRIA',2,0),(3,'BOLIVAR',2,0),(4,'LA PLATA',2,0),(5,'METAN',3,0),(6,'ORAN',3,0),(7,'LOS ANDES',3,0),(8,'CAFAYATE',3,0),(9,'HUMAHUACA',4,0),(10,'TILCARA',4,0),(11,'PALPALA',4,0),(12,'RESISTENCIA',5,0),(13,'VILLA ANGELA',5,0),(14,'BARRANQUERAS',5,0),(15,'CLORINDA',6,0),(16,'HERRADURA',6,0),(17,'LAS LOMITAS',6,0),(18,'MERCEDES',7,0),(19,'ITATI',7,0),(20,'GOYA',7,0),(21,'POSADAS',8,0),(22,'PUERTO IGUAZU',8,0),(23,'MONTECARLO',8,0),(24,'CHIMBAS',9,0),(25,'RIVADAVIA',9,0),(26,'POCITO',9,0),(27,'SAN LUIS',10,0),(28,'VILLA MERCEDES',10,0),(29,'MERLO',10,0),(30,'VENADO TUERTO',11,0),(31,'RUFINO',11,0),(32,'SUNCHALES',11,0),(33,'ALTA GRACIA',12,0),(34,'VILLA CARLOS PAZ',12,0),(35,'JESUS MARIA',12,0),(36,'COSQUIN',12,0),(37,'RIO CUARTO',12,0),(38,'PARANA',13,0),(39,'CONCORDIA',13,0),(40,'GUALEGUAYCHU',13,0),(41,'BARILOCHE',14,0),(42,'VIEDMA',14,0),(43,'CIPOLLETTI',14,0),(44,'JUNIN DE LOS ANDES',15,0),(45,'SAN MARTIN DE LOS ANDES',15,0),(46,'PIEDRA DEL AGUILA',15,0),(47,'CALAFATE',16,0),(48,'RIO GALLEGOS',16,0),(49,'PUERTO DESEADO',16,0),(50,'USUAHIA',17,0),(51,'SAN SEBASTIAN',17,0),(52,'LAGO ESCONDIDO',17,0),(53,'SANTA ROSA',18,0),(54,'GENERAL PICO',18,0),(55,'GENERAL ACHA',18,0),(56,'GUAMALLEN',19,0),(57,'LAS HERAS',19,0),(58,'GODOY CRUZ',19,0),(59,'SAN RAFAEL',19,0),(60,'CONCEPCION',20,0),(61,'BELLA VISTA',20,0),(62,'TAFI DEL VALLE',20,0),(63,'PUERTO MADRYN',21,0),(64,'RAWSON',21,0),(65,'COMODORO RIVADAVIA',21,0),(66,'CHILECITO',22,0),(67,'VILLA SANAGASTA',22,0),(68,'CHEPES',22,0),(69,'VALLE VIEJO',23,0),(70,'SANTA MARIA',23,0),(71,'LOS ALTOS',23,0),(72,'COLONIA DORA',1,0),(73,'CLODOMIRA',1,0);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parentesco`
--

DROP TABLE IF EXISTS `parentesco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parentesco` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `DELETED` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parentesco`
--

LOCK TABLES `parentesco` WRITE;
/*!40000 ALTER TABLE `parentesco` DISABLE KEYS */;
INSERT INTO `parentesco` VALUES (1,'Primos',0),(2,'Primo',0);
/*!40000 ALTER TABLE `parentesco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `APELLIDO` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `DNI` int NOT NULL,
  `FECHA_NAC` date NOT NULL,
  `CIUDAD_ID` bigint NOT NULL,
  `DELETED` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_persona_ciudad` (`CIUDAD_ID`) USING BTREE,
  CONSTRAINT `FK_persona_ciudad` FOREIGN KEY (`CIUDAD_ID`) REFERENCES `ciudad` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Pedro','Picapiedra',1000,'2022-07-01',1,0),(2,'Pablo','Marmol',2234,'2022-06-02',13,0),(3,'Juan segundo','Perez',34343,'2022-06-06',1,1),(4,'Alf','Alf',425252,'2022-07-19',1,0),(5,'Simon','Dice',111111,'2022-06-28',1,0);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincia` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `DELETED` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'SANTIAGO DEL ESTERO',0),(2,'BUENOS AIRES',0),(3,'SALTA',0),(4,'JUJUY',0),(5,'CHACO',0),(6,'FORMOSA',0),(7,'CORRIENTES',0),(8,'MISIONES',0),(9,'SAN JUAN',0),(10,'SAN LUIS',0),(11,'SANTA FE',0),(12,'CORDOBA',0),(13,'ENTRE RIOS',0),(14,'RIO NEGRO',0),(15,'NEUQUEN',0),(16,'SANTA CRUZ',0),(17,'TIERRA DEL FUEGO',0),(18,'LA PAMPA',0),(19,'MENDOZA',0),(20,'TUCUMAN',0),(21,'CHUBUT',0),(22,'LA RIOJA',0),(23,'CATAMARCA',0);
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relacion_parentesco`
--

DROP TABLE IF EXISTS `relacion_parentesco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relacion_parentesco` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `DESDE_RELACION` bigint NOT NULL,
  `HASTA_RELACION` bigint NOT NULL,
  `PARENTESCO_ID` bigint NOT NULL,
  `DELETED` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK__persona` (`DESDE_RELACION`) USING BTREE,
  KEY `FK__persona_2` (`HASTA_RELACION`) USING BTREE,
  KEY `FK_relacion_parentesco_parentesco` (`PARENTESCO_ID`) USING BTREE,
  CONSTRAINT `FK__persona` FOREIGN KEY (`DESDE_RELACION`) REFERENCES `persona` (`ID`),
  CONSTRAINT `FK__persona_2` FOREIGN KEY (`HASTA_RELACION`) REFERENCES `persona` (`ID`),
  CONSTRAINT `FK_relacion_parentesco_parentesco` FOREIGN KEY (`PARENTESCO_ID`) REFERENCES `parentesco` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relacion_parentesco`
--

LOCK TABLES `relacion_parentesco` WRITE;
/*!40000 ALTER TABLE `relacion_parentesco` DISABLE KEYS */;
INSERT INTO `relacion_parentesco` VALUES (1,2,2,1,0),(2,2,2,2,1);
/*!40000 ALTER TABLE `relacion_parentesco` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-17 12:20:56
