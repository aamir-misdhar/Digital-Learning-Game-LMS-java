CREATE DATABASE  IF NOT EXISTS `digital_learning_game` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `digital_learning_game`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: digital_learning_game
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `science`
--

DROP TABLE IF EXISTS `science`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `science` (
  `stdRegisterId` int NOT NULL,
  `electronicConfigurationLevel1_marks` varchar(5) DEFAULT '0',
  `electronicConfigurationLevel1_completed` varchar(5) DEFAULT '0',
  `electronicConfigurationLevel2_marks` varchar(5) DEFAULT '0',
  `electronicConfigurationLevel2_completed` varchar(5) DEFAULT '0',
  `electronicConfigurationLevel2_marks_II` varchar(5) DEFAULT '0',
  `electronicConfigurationLevel2_complete_II` varchar(5) DEFAULT '0',
  `mapMarkingDignestiveSystem_marks` varchar(5) DEFAULT '0',
  `mapMarkingDignestiveSystem_completed` varchar(5) DEFAULT '0',
  `mapMarkingRespiratorySystem_marks` varchar(5) DEFAULT '0',
  `mapMarkingRespiratorySystem_completed` varchar(5) DEFAULT '0',
  `mapMarkingUrinarySystem_marks` varchar(5) DEFAULT '0',
  `mapMarkingUrinarySystem_completed` varchar(5) DEFAULT '0',
  `scienceTotalMarks` varchar(5) DEFAULT '0',
  `scienceTotalComplete` varchar(5) DEFAULT '0',
  PRIMARY KEY (`stdRegisterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-10 13:09:54