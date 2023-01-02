CREATE DATABASE  IF NOT EXISTS `zth_1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `zth_1`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: zth_1
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `ref_user_sample`
--

DROP TABLE IF EXISTS `ref_user_sample`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_user_sample` (
  `sample_id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_user_sample`
--

LOCK TABLES `ref_user_sample` WRITE;
/*!40000 ALTER TABLE `ref_user_sample` DISABLE KEYS */;
INSERT INTO `ref_user_sample` VALUES ('test1','55190827'),('test1','55190828'),('test2','55190827'),('test2','55190828'),('0','123'),('null','123'),('null','123'),('123','123'),('123','1'),('12345','123'),('12345','123'),('N12345','1126'),('N12345','55190827'),('','20220528'),('NU2022','20220528');
/*!40000 ALTER TABLE `ref_user_sample` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample`
--

DROP TABLE IF EXISTS `sample`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sample` (
  `state` varchar(50) DEFAULT NULL,
  `test_no` varchar(50) NOT NULL,
  `sample_time` varchar(45) DEFAULT NULL,
  `upload_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`test_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample`
--

LOCK TABLES `sample` WRITE;
/*!40000 ALTER TABLE `sample` DISABLE KEYS */;
INSERT INTO `sample` VALUES ('unknow','','2022-05-28 20:06:07',NULL),('negative','123',NULL,'2022-05-27 22:28:29'),('positive','12345','2022-05-27 18:12:37','2022-05-27 22:33:20'),('negative','N12345','2022-05-27 22:39:37','2022-05-27 22:40:10'),('positive','NU2022','2022-05-28 20:07:22','2022-05-28 20:08:50'),('unknow','null',NULL,NULL),('negative','test1',NULL,NULL),('positive','test2',NULL,NULL);
/*!40000 ALTER TABLE `sample` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `stu_number` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stu_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('1','a','zth1','123456','student'),('1126','zgq','zgq','zgq','student'),('123','22','4444','22','doctor'),('1234','123','123','1','doctor'),('20220528','test1','test1','test1','student'),('20220529','test2','test2','test2','doctor'),('20220530','test3','test3','test3','uploader'),('55100825','d','z3','z3','uploader'),('55190822','zzz','zzz','zzz','student'),('55190827','b','z1','z1','student'),('55190828','zth','zth','123456','admin');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-28 20:42:53
