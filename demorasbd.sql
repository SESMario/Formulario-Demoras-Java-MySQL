-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: lanerabd
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `demora`
--

DROP TABLE IF EXISTS `demora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `demora` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `Inicio` time NOT NULL,
  `Fin` time NOT NULL,
  `Turno` int(5) NOT NULL,
  `Telar` int(5) NOT NULL,
  `Tipo` int(5) NOT NULL,
  `Descripcion` text DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Turno` (`Turno`),
  KEY `Telar` (`Telar`,`Tipo`),
  KEY `Tipo` (`Tipo`),
  FULLTEXT KEY `BuscaDesc` (`Descripcion`),
  CONSTRAINT `demora_ibfk_1` FOREIGN KEY (`Telar`) REFERENCES `telar` (`IDTelar`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `demora_ibfk_2` FOREIGN KEY (`Tipo`) REFERENCES `tipo` (`IDTipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `demora_ibfk_3` FOREIGN KEY (`Turno`) REFERENCES `turno` (`IDTurno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `demora`
--

LOCK TABLES `demora` WRITE;
/*!40000 ALTER TABLE `demora` DISABLE KEYS */;
INSERT INTO `demora` VALUES (1,'2019-08-16','14:39:00','16:27:00',1,25,1,''),(2,'2019-08-22','23:08:00','23:30:00',2,5,4,'Operador no se presento'),(3,'2019-08-20','15:09:00','15:24:22',3,5,3,'Problemas en la instalación eléctrica'),(5,'2019-08-21','21:12:00','22:12:00',1,4,3,'na'),(12,'2019-08-16','15:19:00','19:19:00',1,25,1,''),(13,'2019-08-01','01:10:00','01:48:00',2,29,1,'na1'),(14,'2019-08-15','15:12:00','15:28:00',3,30,4,'nada xd'),(15,'2019-08-15','18:27:00','23:50:00',3,30,4,'nada xd'),(17,'2019-08-22','15:17:00','15:27:00',1,1,1,''),(18,'2019-08-23','10:35:00','11:35:00',1,30,4,''),(23,'2019-08-20','20:59:00','21:59:00',1,1,3,'cambio de turno y suspeción'),(24,'2019-08-08','21:05:00','21:28:00',2,4,4,'Falta de luz'),(25,'2019-08-29','15:09:00','19:28:00',2,4,4,'nada'),(26,'2019-08-29','17:31:00','21:31:00',1,2,2,''),(27,'2019-08-30','16:40:00','17:54:00',1,3,1,''),(28,'2019-08-31','16:57:23','17:05:34',1,3,4,'Otros'),(29,'2019-08-03','17:15:24','17:51:24',1,1,1,'na');
/*!40000 ALTER TABLE `demora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `detdem`
--

DROP TABLE IF EXISTS `detdem`;
/*!50001 DROP VIEW IF EXISTS `detdem`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `detdem` (
  `ID` tinyint NOT NULL,
  `Fecha` tinyint NOT NULL,
  `Inicio` tinyint NOT NULL,
  `Fin` tinyint NOT NULL,
  `Duracion` tinyint NOT NULL,
  `turno` tinyint NOT NULL,
  `Telar` tinyint NOT NULL,
  `Codigo` tinyint NOT NULL,
  `Descripcion` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `telar`
--

DROP TABLE IF EXISTS `telar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telar` (
  `IDTelar` int(5) NOT NULL AUTO_INCREMENT,
  `Telar` int(3) NOT NULL,
  PRIMARY KEY (`IDTelar`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telar`
--

LOCK TABLES `telar` WRITE;
/*!40000 ALTER TABLE `telar` DISABLE KEYS */;
INSERT INTO `telar` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20),(21,21),(22,22),(23,23),(24,24),(25,25),(26,26),(27,27),(28,28),(29,29),(30,30);
/*!40000 ALTER TABLE `telar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `IDTipo` int(5) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(5) NOT NULL,
  `Descripcion` text DEFAULT NULL,
  PRIMARY KEY (`IDTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'A1','na'),(2,'B1','na'),(3,'C1','na'),(4,'D1','na');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turno` (
  `IDTurno` int(5) NOT NULL AUTO_INCREMENT,
  `Turno` varchar(45) NOT NULL,
  PRIMARY KEY (`IDTurno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'Primero'),(2,'Segundo'),(3,'Tercero');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `detdem`
--

/*!50001 DROP TABLE IF EXISTS `detdem`*/;
/*!50001 DROP VIEW IF EXISTS `detdem`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `detdem` AS select `demora`.`ID` AS `ID`,`demora`.`Fecha` AS `Fecha`,`demora`.`Inicio` AS `Inicio`,`demora`.`Fin` AS `Fin`,timestampdiff(MINUTE,`demora`.`Inicio`,`demora`.`Fin`) AS `Duracion`,`turno`.`Turno` AS `turno`,`demora`.`Telar` AS `Telar`,`tipo`.`Codigo` AS `Codigo`,`demora`.`Descripcion` AS `Descripcion` from ((`demora` join `turno`) join `tipo`) where `demora`.`Turno` = `turno`.`IDTurno` and `demora`.`Tipo` = `tipo`.`IDTipo` order by `demora`.`ID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-14 17:11:24
