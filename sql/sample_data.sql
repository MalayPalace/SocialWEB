-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: socialweb
-- ------------------------------------------------------
-- Server version	5.5.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `FRIENDS_DETAILS`
--

LOCK TABLES `FRIENDS_DETAILS` WRITE;
/*!40000 ALTER TABLE `FRIENDS_DETAILS` DISABLE KEYS */;
INSERT INTO `FRIENDS_DETAILS` VALUES (10,5,8,0,'2015-08-29 07:07:46',0),(11,5,7,0,'2015-08-29 07:08:04',0);
/*!40000 ALTER TABLE `FRIENDS_DETAILS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `USER_DETAILS`
--

LOCK TABLES `USER_DETAILS` WRITE;
/*!40000 ALTER TABLE `USER_DETAILS` DISABLE KEYS */;
INSERT INTO `USER_DETAILS` VALUES (5,'malay_Shah','malayShah','malayshah182@hotmail.com','2015-08-18 19:43:46',0),(6,'malayShah','shahmalay','shah@mail.com','2015-08-18 19:45:02',0),(7,'shah007','malay','malayshah182@gmail.com','2015-08-18 19:48:07',0),(8,'Chetna','Shah','chetnashah@gmail.com','2015-08-29 07:07:30',0),(9,'Nik','nik','nik@gmail.com','2015-09-02 19:42:05',0),(10,'Chetna_Shah','malayshah','malayshah@yahoo.com','2015-09-06 07:24:35',0);
/*!40000 ALTER TABLE `USER_DETAILS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-12 20:54:55
