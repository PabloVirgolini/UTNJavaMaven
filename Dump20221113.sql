-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: java
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `idcargo` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Encargado de Mantenimiento'),(2,'Jefe Mantenimiento'),(3,'Encargado de Sector'),(5,'PRUEBACARGO');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoreparacion`
--

DROP TABLE IF EXISTS `estadoreparacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadoreparacion` (
  `id` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoreparacion`
--

LOCK TABLES `estadoreparacion` WRITE;
/*!40000 ALTER TABLE `estadoreparacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadoreparacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidencia`
--

DROP TABLE IF EXISTS `incidencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidencia` (
  `idincidencia` int NOT NULL AUTO_INCREMENT,
  `fechaApertura` date DEFAULT NULL,
  `descripcionProblema` text,
  `idPersonaApertura` int DEFAULT NULL,
  `idPersonaAsignada` int DEFAULT NULL,
  `fechaCierre` date DEFAULT NULL,
  `idMaquina` int DEFAULT NULL,
  PRIMARY KEY (`idincidencia`),
  KEY `fkIncidenciaMaquina_idx` (`idMaquina`),
  KEY `fkIncidenciaPersonaApertura_idx` (`idPersonaApertura`),
  KEY `fkIncidenciaPersonaAsignada_idx` (`idPersonaAsignada`),
  CONSTRAINT `fkIncidenciaMaquina` FOREIGN KEY (`idMaquina`) REFERENCES `maquina` (`idmaquina`),
  CONSTRAINT `fkIncidenciaPersonaApertura` FOREIGN KEY (`idPersonaApertura`) REFERENCES `persona` (`id`),
  CONSTRAINT `fkIncidenciaPersonaAsignada` FOREIGN KEY (`idPersonaAsignada`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidencia`
--

LOCK TABLES `incidencia` WRITE;
/*!40000 ALTER TABLE `incidencia` DISABLE KEYS */;
INSERT INTO `incidencia` VALUES (1,'2022-12-21','Problemon',1,7,NULL,1),(3,'2022-11-10','gdfsgfdsg',1,NULL,NULL,1),(4,'2022-11-25','Prueba K10. Encargado 7. El 25/11\r\nSon dos lineas',1,NULL,NULL,4),(5,'2022-11-17','sgsdfdsfsdfsdfs',1,7,NULL,2),(6,'2022-11-04','44444444444444444',1,7,NULL,1),(7,'2022-11-17','sasas',1,7,NULL,3);
/*!40000 ALTER TABLE `incidencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maquina`
--

DROP TABLE IF EXISTS `maquina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `maquina` (
  `idmaquina` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `fechaAlta` date DEFAULT NULL,
  `fechaBaja` date DEFAULT NULL,
  `sectorAsignado` int DEFAULT NULL,
  PRIMARY KEY (`idmaquina`),
  KEY `fkMaquinaSeccion_idx` (`sectorAsignado`),
  CONSTRAINT `fkMaquinaSeccion` FOREIGN KEY (`sectorAsignado`) REFERENCES `seccion` (`idSeccion`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maquina`
--

LOCK TABLES `maquina` WRITE;
/*!40000 ALTER TABLE `maquina` DISABLE KEYS */;
INSERT INTO `maquina` VALUES (1,'K50-07','2000-01-01',NULL,1),(2,'K50-08','2000-08-01',NULL,1),(3,'K50-09','2001-09-01',NULL,1),(4,'K50-10','2002-10-01',NULL,1),(5,'K50-11','2003-11-01',NULL,1),(6,'K50-12','2004-12-01',NULL,1),(7,'3710-01','1994-01-01',NULL,1),(8,'3710-02','1994-01-01',NULL,1),(9,'3710-03','1996-01-05',NULL,1),(10,'3710-04','1996-01-05',NULL,1),(11,'3710-05','1996-06-06',NULL,1),(12,'3710-06','1996-06-06',NULL,1),(13,'3710-00','1997-01-01',NULL,1),(14,'EXTRUSORA 1','1994-01-01',NULL,1),(15,'EXTRUSORA 2','1994-01-01',NULL,1),(16,'EXTRUSORA 3','1996-01-05',NULL,1),(17,'EXTRUSORA 4','1996-01-05',NULL,1),(18,'EXTRUSORA 5','1996-06-06',NULL,1),(19,'MOLINO 1','1994-01-01',NULL,1),(20,'MOLINO 2','1994-01-01',NULL,1),(21,'MOLINO 3','1995-02-02',NULL,1),(22,'MOLINO 4','1995-09-02',NULL,1),(23,'MOLINO 5','1999-07-20',NULL,1),(24,'IMPRESORA OMSO 1','1994-01-01','1999-09-12',2),(25,'IMPRESORA OMSO 2','1994-02-01','2000-01-12',2),(26,'IMPRESORA OMSO 3','1996-01-01','1997-12-12',2),(27,'IMPRESORA OMSO 4','1996-01-01','1997-12-12',2),(28,'IMPRESORA OMSO 5','1999-01-01','2002-05-12',2),(29,'IMPRESORA POLYTYPE 12','1999-09-12',NULL,2),(30,'IMPRESORA POLYTYPE 13','2000-01-12',NULL,2),(31,'IMPRESORA POLYTYPE 14','2001-03-03',NULL,2),(32,'IMPRESORA POLYTYPE 15','2001-04-12',NULL,2),(33,'IMPRESORA POLYTYPE 16','2002-05-12',NULL,2),(34,'IMPRESORA VNDAM 6','1995-12-24',NULL,2),(35,'IMPRESORA VNDAM 7','1996-12-26',NULL,2),(36,'IMPRESORA VNDAM 11','1997-12-12',NULL,2);
/*!40000 ALTER TABLE `maquina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo_doc` varchar(10) NOT NULL,
  `nro_doc` varchar(45) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `habilitado` tinyint(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `idCargo` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_persona_cargo_idx` (`idCargo`),
  CONSTRAINT `fk_persona_cargo` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'dni  ','10101010  ','Juan','Perez  ','jp@gmail.com','4101010  ',1,'jperez',3),(2,'dni','12121212','John','Doe','contacto@jd','4121212',0,'jdoe',3),(3,'dni','13131313','Nadie','Sabe','ns@ns.com','4131313',1,'nsabe',3),(4,'cuit','14141414141','Identidad','Desconocida','unknown@gmail.com','4141414',0,'idesconocida',3),(5,'cuit','15151515151','Alguien','Más','am@gmail.com','4151515',0,'amas',3),(6,'dni','16161616','Otra','Persona','op@gmail.com','4161616',0,'opersona',3),(7,'dni','12345678','NomEncargado','ApeMantenimiento','encargado@mantenimiento','4111111',0,'encargadomantenimiento',1),(8,'dni','01234567','Jefe','Mantenimiento','jefe@mantenimiento','4111111',0,'jefemantenimiento',2);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_persona`
--

DROP TABLE IF EXISTS `rol_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol_persona` (
  `id_persona` int NOT NULL,
  `id_rol` int NOT NULL,
  PRIMARY KEY (`id_persona`,`id_rol`),
  KEY `rol_persona_rol_fk` (`id_rol`),
  CONSTRAINT `rol_persona_persona_fk` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`),
  CONSTRAINT `rol_persona_rol_fk` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_persona`
--

LOCK TABLES `rol_persona` WRITE;
/*!40000 ALTER TABLE `rol_persona` DISABLE KEYS */;
INSERT INTO `rol_persona` VALUES (1,1),(3,1),(2,2),(3,2),(4,2),(5,2),(6,2);
/*!40000 ALTER TABLE `rol_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seccion` (
  `idSeccion` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idSeccion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccion`
--

LOCK TABLES `seccion` WRITE;
/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` VALUES (1,'Termoformado'),(2,'Impresoras'),(3,'Carton');
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-13 23:07:34
