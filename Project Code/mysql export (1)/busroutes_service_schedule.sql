CREATE DATABASE  IF NOT EXISTS `busroutes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `busroutes`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: busroutes
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `service_schedule`
--

DROP TABLE IF EXISTS `service_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `service_schedule` (
  `reg_no` int(11) NOT NULL,
  `day` set('monday','tuesday','wednesday','thursday','friday','saturday','sunday') NOT NULL,
  `departure_time` time NOT NULL,
  `route_id` int(11) NOT NULL,
  PRIMARY KEY (`reg_no`,`day`,`departure_time`),
  CONSTRAINT `reg_no` FOREIGN KEY (`reg_no`) REFERENCES `bus_runs_on` (`reg_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_schedule`
--

LOCK TABLES `service_schedule` WRITE;
/*!40000 ALTER TABLE `service_schedule` DISABLE KEYS */;
INSERT INTO `service_schedule` VALUES (11111,'monday','14:30:00',1001),(11111,'tuesday','10:15:00',1001),(11111,'wednesday','06:25:00',1001),(11111,'thursday','20:02:00',1001),(11111,'friday','06:30:00',1001),(11111,'saturday','14:30:00',1001),(11111,'sunday','10:15:00',1001),(11112,'monday','06:30:00',1002),(11112,'wednesday','22:30:00',1002),(11112,'friday','23:30:00',1002),(11113,'tuesday','06:30:00',1001),(11113,'thursday','22:30:00',1001),(11114,'tuesday','06:30:00',1002),(11114,'thursday','07:30:00',1002),(11114,'saturday','08:30:00',1002),(11115,'monday','10:15:00',1003),(11115,'tuesday','05:30:00',1003),(11116,'monday','08:30:00',1004),(11116,'tuesday','14:30:00',1004),(11116,'wednesday','06:30:00',1004),(11116,'thursday','10:15:00',1004),(11117,'saturday','09:30:00',1005),(11117,'sunday','10:30:00',1005),(11118,'friday','13:30:00',1004);
/*!40000 ALTER TABLE `service_schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `service_schedule_BEFORE_INSERT` BEFORE INSERT ON `service_schedule` FOR EACH ROW BEGIN
if (new.route_id not in (select route_id from route))
then SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'This route id does not exists!';
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12 17:05:07
