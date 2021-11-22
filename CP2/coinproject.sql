CREATE DATABASE  IF NOT EXISTS `coinproject` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `coinproject`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: coinproject
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `b_no` int NOT NULL AUTO_INCREMENT,
  `m_no` int NOT NULL,
  `b_title` varchar(100) NOT NULL,
  `b_contents` varchar(5000) NOT NULL,
  `b_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `b_type` int NOT NULL,
  `c_no` int DEFAULT NULL,
  PRIMARY KEY (`b_no`),
  KEY `m_no` (`m_no`),
  KEY `c_no` (`c_no`),
  CONSTRAINT `board_ibfk_1` FOREIGN KEY (`m_no`) REFERENCES `member` (`m_no`),
  CONSTRAINT `board_ibfk_2` FOREIGN KEY (`c_no`) REFERENCES `coin` (`c_no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,10,'aaaa','aaaa','2021-11-18 12:59:23',2,1),(2,2,'fd','fsd','2021-11-18 13:54:54',2,1),(3,2,'dfdas','fdsaf','2021-11-18 13:55:05',2,1),(4,2,'fd','fd','2021-11-18 13:55:13',2,1),(5,10,'fds','fdfs','2021-11-18 13:55:41',2,1),(6,10,'231','ewqeqw','2021-11-18 13:55:50',2,1),(7,10,'rwqe','reqwqr','2021-11-18 13:58:19',2,2),(8,10,'fdsa','fewqrewqrweq','2021-11-18 13:58:40',2,1),(9,10,'111','111','2021-11-18 13:58:49',2,1),(10,10,'새로고침','새로고침','2021-11-18 13:59:57',2,1),(11,10,'ewq','easedasd','2021-11-18 14:09:29',2,1),(12,10,'edfasf','asfasdasda','2021-11-18 14:09:34',2,1),(13,10,'fds','adasd','2021-11-18 14:09:41',2,1),(14,10,'FDSA','FDSAFAS','2021-11-18 14:09:46',2,1),(15,10,'dsa','asdasdasd','2021-11-18 14:09:51',2,1),(16,10,'dddd','dddd','2021-11-18 14:10:30',2,1),(17,10,'ddd22','ddd222','2021-11-18 14:10:57',2,1),(18,10,'1234','1234','2021-11-18 14:11:16',2,1),(19,10,'wwww','wwww','2021-11-18 14:12:10',2,1),(20,10,'sss','sss','2021-11-18 14:12:27',2,1),(21,10,'wwww','wwww','2021-11-18 14:14:25',2,1),(22,10,'sdasd','addsadaas','2021-11-18 14:14:45',2,1),(23,10,'qweqw','ewqeqw','2021-11-18 14:38:35',2,1),(24,10,'dsa','dsadasd','2021-11-18 14:38:40',2,1),(25,10,'qqqq','qqqq','2021-11-18 14:38:44',2,1),(26,10,'wwww','wwww','2021-11-18 14:38:48',2,1),(27,10,'aaaa','aaaa','2021-11-18 14:40:06',2,1),(28,10,'wwww','wwww','2021-11-18 14:40:13',2,1),(29,10,'eeee','eeee','2021-11-18 14:40:18',2,1),(30,10,'fd','fd','2021-11-18 14:40:31',2,1),(31,10,'fds','fd','2021-11-18 14:40:41',2,1),(32,10,'wwww','wwww','2021-11-18 14:48:12',2,1),(33,10,'eee','eeee','2021-11-18 14:48:18',2,1),(34,10,'ewq','ewq','2021-11-18 14:49:33',2,1),(35,10,'123','123','2021-11-18 14:49:55',2,1),(36,10,'ssss','ssss','2021-11-18 14:58:55',2,1),(37,10,'wwww','wwww','2021-11-18 14:59:04',2,1),(38,10,'fsdafsd','dsafasdf','2021-11-18 15:06:07',2,1),(39,10,'다나옴','다나옴','2021-11-18 15:25:21',2,1),(40,10,'fds','fwefw','2021-11-18 15:26:16',2,1),(41,10,'나나','얼레','2021-11-18 16:04:56',2,1),(44,2,'aaa','aaa','2021-11-19 13:16:17',3,1),(45,2,'aaa','aaa','2021-11-19 13:16:40',3,NULL),(47,2,'aaa','aaa','2021-11-19 13:24:19',3,NULL),(50,10,'dsadas','dsadas','2021-11-19 14:49:43',3,NULL),(51,10,'fdasf','fdasfdas','2021-11-19 14:50:01',3,NULL),(52,10,'fsdafdas','dsafdsafa','2021-11-19 15:09:57',2,3),(54,10,'ewq','ewqeqw','2021-11-20 01:26:28',3,NULL),(57,10,' 지금','이순간','2021-11-20 02:09:41',3,NULL),(58,10,'Re : aaaa','aaaa','2021-11-20 02:14:22',3,NULL),(59,11,'111','111','2021-11-20 02:38:54',1,NULL),(60,10,'eeee','eeee','2021-11-20 07:57:10',2,1),(61,10,'qweqweqwe','wqeeqw','2021-11-20 07:57:31',3,NULL),(62,10,'ffff','f1`31212','2021-11-20 08:06:14',2,1),(63,10,'21321312','12321331','2021-11-20 08:06:31',3,NULL),(65,10,'fdsafs','fasdfdasd','2021-11-20 11:31:05',3,NULL),(68,10,'fasfd','fdsafa','2021-11-20 17:16:28',3,NULL),(69,10,'fdsafdas1111','111fdaffdas','2021-11-21 04:48:24',2,1),(70,10,'1111','1111','2021-11-21 04:48:31',2,3),(72,2,'제목, aa','a','2021-11-21 06:54:55',3,NULL),(73,10,'dfsasd','dsaA','2021-11-21 12:59:22',2,1),(74,10,'지금이순간','오후 9시 59분','2021-11-21 12:59:41',3,NULL),(75,11,'fadf','fdsaf','2021-11-21 13:01:09',1,NULL),(76,10,'1234567','asfasdf','2021-11-22 00:53:50',2,1),(77,10,'asdf','1234','2021-11-22 00:54:33',3,NULL),(79,10,'fdsafa','fsdafa','2021-11-22 01:48:08',2,1);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coin`
--

DROP TABLE IF EXISTS `coin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coin` (
  `c_no` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(40) NOT NULL,
  `c_price` int NOT NULL,
  `c_maxcoin` int NOT NULL,
  PRIMARY KEY (`c_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coin`
--

LOCK TABLES `coin` WRITE;
/*!40000 ALTER TABLE `coin` DISABLE KEYS */;
INSERT INTO `coin` VALUES (1,'비트코인',2061935,1000),(2,'메이져',3354751,1000),(3,'캘린더',1999586,1000);
/*!40000 ALTER TABLE `coin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `m_no` int NOT NULL AUTO_INCREMENT,
  `m_id` varchar(45) NOT NULL,
  `m_pw` varchar(45) NOT NULL,
  `m_name` varchar(45) NOT NULL,
  `m_email` varchar(45) NOT NULL,
  `m_money` int NOT NULL,
  `m_holdingcoin` int NOT NULL,
  `m_inputcoinname` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`m_no`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (2,'1111','1111','11','11@11',0,0,'비트코인, 이더리움'),(7,'qqqq','1234','name','a@aaa',0,0,NULL),(8,'ssss','ssss','ss','ss@ss',0,0,NULL),(9,'wwww','ssss','ssss','ss@ss',0,0,NULL),(10,'aaaa','aaaa','aaaa','aa@aa',0,0,'비트코인, 이더리움'),(11,'admin','1234','관리자','admin@',0,0,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reply` (
  `r_no` int NOT NULL AUTO_INCREMENT,
  `r_contents` varchar(1000) NOT NULL,
  `r_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `b_no` int NOT NULL,
  PRIMARY KEY (`r_no`),
  KEY `reply_ibfk_3_idx` (`b_no`),
  CONSTRAINT `reply_ibfk_3` FOREIGN KEY (`b_no`) REFERENCES `board` (`b_no`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (15,'bbb','2021-11-20 12:12:25',1),(16,'ccc','2021-11-20 12:12:26',1),(17,'ddd','2021-11-20 12:12:26',1),(18,'eeee','2021-11-20 12:12:26',1),(19,'fff','2021-11-20 12:12:26',1),(20,'111','2021-11-20 12:12:26',1),(21,'cdd','2021-11-20 13:48:40',20),(22,'ceee','2021-11-20 13:50:23',20),(23,'ceee','2021-11-20 13:50:33',13),(24,'fdasfadsf','2021-11-20 15:11:25',63),(25,'','2021-11-20 15:11:40',65),(26,'지금','2021-11-20 15:11:44',65),(27,'fdafadf','2021-11-20 15:14:22',63),(28,'','2021-11-20 15:15:34',63),(29,'fdsafdsafdas','2021-11-20 15:15:36',63),(30,'fdadsas','2021-11-20 15:16:35',57),(31,'fdafdasf','2021-11-20 15:33:42',61),(32,'','2021-11-20 15:34:05',61),(33,'','2021-11-20 15:34:15',61),(34,'141243243','2021-11-20 15:34:19',61),(35,'fasfads','2021-11-20 15:42:28',65),(36,'','2021-11-20 15:42:34',65),(37,'시작','2021-11-20 15:42:39',65),(38,'afdaf','2021-11-20 15:44:17',57),(39,'fsafdafa','2021-11-20 15:50:03',65),(40,'그랙','2021-11-20 15:50:08',65),(41,'arwrew','2021-11-20 15:51:33',61),(42,'qweqweeqwe','2021-11-20 15:57:38',58),(43,'1111111','2021-11-20 15:57:48',65),(44,'aaa','2021-11-20 16:08:52',58),(45,'나ㅓ나','2021-11-20 16:10:11',65),(46,'fdsafadfa','2021-11-20 16:53:14',58),(47,'fdsafafa','2021-11-20 16:53:18',58),(48,'1111111111','2021-11-20 16:53:28',65),(49,'222222','2021-11-20 16:53:35',65),(50,'33333','2021-11-20 16:53:44',65),(51,'4444','2021-11-20 16:53:56',65),(52,'fdafda','2021-11-20 17:09:18',58),(53,'12312312','2021-11-20 17:09:27',63),(54,'31231231','2021-11-20 17:09:37',63),(55,'afafa','2021-11-20 17:11:35',58),(56,'3131','2021-11-20 17:11:45',65),(57,'111','2021-11-20 17:12:43',61),(58,'2222','2021-11-20 17:12:45',61),(59,'1231313','2021-11-21 04:47:30',68),(60,'1q111','2021-11-21 13:00:36',74),(61,'asdf','2021-11-22 00:55:55',77),(62,'fdasfas','2021-11-22 01:00:13',77),(63,'888','2021-11-22 01:45:13',74),(64,'fdasfdasfas','2021-11-22 01:50:35',77),(65,'fdsafas','2021-11-22 01:58:43',74);
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trade` (
  `t_no` int NOT NULL AUTO_INCREMENT,
  `t_tradeprice` int NOT NULL,
  `m_no` int NOT NULL,
  `c_no` int NOT NULL,
  PRIMARY KEY (`t_no`),
  KEY `m_no` (`m_no`),
  KEY `c_no` (`c_no`),
  CONSTRAINT `trade_ibfk_1` FOREIGN KEY (`m_no`) REFERENCES `member` (`m_no`),
  CONSTRAINT `trade_ibfk_2` FOREIGN KEY (`c_no`) REFERENCES `coin` (`c_no`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
/*!40000 ALTER TABLE `trade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-22 11:45:17
