-- MySQL dump 10.13  Distrib 5.5.9, for Win64 (x86)
--
-- Host: localhost    Database: academiccache
-- ------------------------------------------------------
-- Server version	5.5.9

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
-- Table structure for table `bookdetailmaster`
--

DROP TABLE IF EXISTS `bookdetailmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookdetailmaster` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) DEFAULT '',
  `Author` varchar(100) DEFAULT '',
  `Publication_Year` int(11) DEFAULT '2013',
  `Description` varchar(500) DEFAULT '',
  `Category` varchar(50) DEFAULT '',
  `Tags` varchar(200) DEFAULT '',
  `Used_For` varchar(200) DEFAULT '',
  `Used_Year` int(11) DEFAULT '2013',
  `Creation_Date` date DEFAULT '2013-01-01',
  `Access_Type` varchar(25) DEFAULT 'Public',
  `Upload_Path` varchar(200) DEFAULT '',
  `User_Id` int(11) NOT NULL,
  `Size` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `fk_bookdetailmaster_usermaster1` (`User_Id`),
  CONSTRAINT `fk_bookdetailmaster_usermaster1` FOREIGN KEY (`User_Id`) REFERENCES `usermaster` (`User_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookdetailmaster`
--

LOCK TABLES `bookdetailmaster` WRITE;
/*!40000 ALTER TABLE `bookdetailmaster` DISABLE KEYS */;
INSERT INTO `bookdetailmaster` VALUES (1,'java','Swati',2011,'errors','study','n/a','study',2011,'2013-07-23','Public','D:Advance javaUpload',1,20),(3,'jasper reports','David R. Heffelfinger',2006,'JasperReports is an open-source Java class library designed to aid developers with the\r\ntask of adding reporting capabilities to Java applications by providing an API to facilitate\r\nthe ability to generate reports from any kind of Java application. Though primarily\r\nused to add reporting capabilities to web-based applications, it can also be used to create\r\nstandalone desktop or command-line Java applications for report generation.\r\n','JReports','1. What is JasperReports?\r\n2. Adding Reporting Capabilities to Java Applications\r\n3. Creating a JRXML Report Template    \r\n','Creating Reports',2012,'2012-08-02','Private','/home/student/BrainYardData/2/jreports.pdf',2,9521448),(14,'a','a',2012,'a','a','a','a',2011,'2013-07-09','Public','D:\\Advance java\\Upload\\Untitlenjd.png',2,6766),(15,'abc','a',2012,'kjxdcs','ksod','isj','swd',2011,'2013-07-19','Public','D:\\Advance java\\Upload\\projectVle.htm',1,61493);
/*!40000 ALTER TABLE `bookdetailmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citymaster`
--

DROP TABLE IF EXISTS `citymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citymaster` (
  `City_Id` int(11) NOT NULL,
  `City_Name` varchar(100) DEFAULT '',
  `State_Id` int(11) NOT NULL,
  `Status` varchar(10) DEFAULT 'Active',
  PRIMARY KEY (`City_Id`),
  KEY `fk_citymaster_statemaster1` (`State_Id`),
  CONSTRAINT `fk_citymaster_statemaster1` FOREIGN KEY (`State_Id`) REFERENCES `statemaster` (`State_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citymaster`
--

LOCK TABLES `citymaster` WRITE;
/*!40000 ALTER TABLE `citymaster` DISABLE KEYS */;
INSERT INTO `citymaster` VALUES (1,'Gidderbaha',1,'Active'),(2,'Mansa',1,'Active'),(3,'Moga',1,'Active'),(4,'Barnala',1,'Active'),(5,'Ropar',1,'Active'),(6,'Kotkapura',1,'Active'),(7,'Mohali',1,'Active'),(8,'Jalabad',1,'Active'),(9,'Ferozpur',1,'Active'),(10,'Fridkot',1,'Active'),(11,'Pathankot',1,'Active'),(12,'Bathinda',1,'Active'),(13,'Abhor',1,'Active'),(14,'Sarhind',1,'Active'),(15,'Ludhiana',1,'Active'),(16,'Amritsar',1,'Active'),(17,'Noida',5,'Active'),(18,'Gurgaon',4,'Active');
/*!40000 ALTER TABLE `citymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countrymaster`
--

DROP TABLE IF EXISTS `countrymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countrymaster` (
  `Country_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Country_Name` varchar(100) DEFAULT '',
  `Status` varchar(10) DEFAULT 'Active',
  PRIMARY KEY (`Country_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countrymaster`
--

LOCK TABLES `countrymaster` WRITE;
/*!40000 ALTER TABLE `countrymaster` DISABLE KEYS */;
INSERT INTO `countrymaster` VALUES (1,'Afghanistan','Active'),(2,'Austria','Active'),(3,'Antarctica','Active'),(4,'South Africa','Active'),(5,'Russia','Active'),(6,'Pakistan','Active'),(7,'New Zealand','Active'),(8,'Japan','Active'),(9,'Iran','Active'),(10,'India','Active'),(11,'Iceland','Active'),(12,'Hong Kong','Active'),(13,'Greenland','Active'),(14,'Germany','Active'),(15,'France','Active'),(16,'Egypt','Active'),(17,'Colombia','Active'),(18,'China','Active'),(19,'Canada','Active'),(20,'Bhutan','Active'),(21,'Brazil','Active'),(22,'Bangladesh','Active'),(23,'Switzerland','Active');
/*!40000 ALTER TABLE `countrymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeemaster`
--

DROP TABLE IF EXISTS `employeemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeemaster` (
  `Employee_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) DEFAULT '',
  `Password` varchar(50) DEFAULT '',
  `User_Type` varchar(20) DEFAULT 'Administrator',
  `User_Status` varchar(10) DEFAULT 'Active',
  `Name` varchar(100) DEFAULT '',
  `Gender` varchar(6) DEFAULT 'Male',
  `Contact_Number` varchar(15) DEFAULT '',
  `Email` varchar(100) DEFAULT '',
  `DOJ` date DEFAULT '2013-01-01',
  `Create_Date` datetime DEFAULT '2013-01-13 00:00:00',
  PRIMARY KEY (`Employee_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeemaster`
--

LOCK TABLES `employeemaster` WRITE;
/*!40000 ALTER TABLE `employeemaster` DISABLE KEYS */;
INSERT INTO `employeemaster` VALUES (2,'anuja','anuja','Administrator','Active','Anuja Aneja','Female','1234567890','anuja@gmail.com','2012-07-07','2013-07-05 14:17:11'),(4,'sa@as.com','saas','Employee','Active','saas','Female','9878765439','sa@as.com','2011-09-08','2013-07-06 13:10:11'),(5,'admin','admin','Administrator','Active','administrator','Male','9878765439','admin@gmail.com','2013-06-06','2013-07-06 15:22:35');
/*!40000 ALTER TABLE `employeemaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multimediamaster`
--

DROP TABLE IF EXISTS `multimediamaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `multimediamaster` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) DEFAULT '',
  `Description` varchar(500) DEFAULT '',
  `Label` varchar(100) DEFAULT '',
  `Used_For` varchar(200) DEFAULT '',
  `Tags` varchar(150) DEFAULT '',
  `Upload_Date` date DEFAULT '2013-01-01',
  `Used_Year` int(11) DEFAULT '2013',
  `Access_Type` varchar(25) DEFAULT 'Public',
  `Media_Type` varchar(15) DEFAULT 'Audio',
  `Upload_Path` varchar(200) DEFAULT '',
  `User_Id` int(11) NOT NULL,
  `Size` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `fk_multimediamaster_usermaster1` (`User_Id`),
  CONSTRAINT `fk_multimediamaster_usermaster1` FOREIGN KEY (`User_Id`) REFERENCES `usermaster` (`User_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multimediamaster`
--

LOCK TABLES `multimediamaster` WRITE;
/*!40000 ALTER TABLE `multimediamaster` DISABLE KEYS */;
INSERT INTO `multimediamaster` VALUES (1,'Learn Java','Tutorials','Learn java in 6 weeks','java Programming','Thread,Socket,RMI','2012-08-02',2012,'Public','Audio','/home/student/BrainYardData/1/Maid with the Flaxen Hair.mp3',1,4113874),(2,'Let Us Learn Java','complete Reference to learn java','learn Java','Java Programming','RMI,Socket,Threading,Applet,Swing,Exception Handeling and many more....','2012-08-02',2012,'Private','Audio','/home/student/BrainYardData/1/Kalimba.mp3',1,8414449),(3,'Computer Hopes','The Site of Objective Type Questions','Computer Hopes','Aptitude Question in Technical Tests..','ECE,CE,ME','2012-08-02',2012,'Private','Audio','/home/student/BrainYardData/2/Maid with the Flaxen Hair.mp3',1,4113874),(4,'w3schools','Tutorial of HTML,.NET,Java','w3schools','to learn the Progrmming Lnguages','HTML,XML,Java,JRXML','2012-08-02',2012,'Private','Audio','/home/student/BrainYardData/2/Kalimba.mp3',2,8414449),(6,'soft songs','sad song','aaa','fkjhd','n/a','2013-01-01',2012,'Public','Audio','D:\\Advance java\\Upload\\share_digg.gif',1,227),(7,'sad Song','jhjgja','gooddd..','relex','n/a','2013-01-01',2012,'Public','Audio','D:\\Advance java\\Upload\\small-logo.png',1,1499);
/*!40000 ALTER TABLE `multimediamaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planmaster`
--

DROP TABLE IF EXISTS `planmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planmaster` (
  `Plan_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Plan_Name` varchar(50) DEFAULT '',
  `Space_Allowed` int(11) DEFAULT '0',
  `Cost` int(11) DEFAULT '0',
  `Validity_Months` int(11) DEFAULT '3',
  `Status` varchar(15) DEFAULT 'Active',
  `Creation_Date` date DEFAULT '2013-01-01',
  PRIMARY KEY (`Plan_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planmaster`
--

LOCK TABLES `planmaster` WRITE;
/*!40000 ALTER TABLE `planmaster` DISABLE KEYS */;
INSERT INTO `planmaster` VALUES (1,'Platinum',500,1200,12,'Active','2013-07-06'),(2,'Gold',300,900,12,'Active','2013-07-08'),(3,'Silver',200,500,9,'Active','2013-07-08');
/*!40000 ALTER TABLE `planmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportdetails`
--

DROP TABLE IF EXISTS `reportdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportdetails` (
  `Report_Detail_Id` int(11) NOT NULL,
  `Report_Id` int(11) NOT NULL,
  `Report_Subject` varchar(100) DEFAULT '',
  `Description` text,
  `Report_Date` datetime DEFAULT '2013-01-01 00:00:00',
  `Attachment_Path` varchar(200) DEFAULT '',
  `Report_User_Id` int(11) NOT NULL,
  PRIMARY KEY (`Report_Detail_Id`),
  KEY `fk_reportdetails_1` (`Report_User_Id`),
  KEY `fk_reportdetails_2` (`Report_Id`),
  CONSTRAINT `fk_reportdetails_1` FOREIGN KEY (`Report_User_Id`) REFERENCES `usermaster` (`User_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reportdetails_2` FOREIGN KEY (`Report_Id`) REFERENCES `reportmaster` (`Report_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportdetails`
--

LOCK TABLES `reportdetails` WRITE;
/*!40000 ALTER TABLE `reportdetails` DISABLE KEYS */;
INSERT INTO `reportdetails` VALUES (2,2,'book','errors','2013-12-12 00:00:00','D:swatiupload',2);
/*!40000 ALTER TABLE `reportdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportmaster`
--

DROP TABLE IF EXISTS `reportmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportmaster` (
  `Report_Id` int(11) NOT NULL,
  `Id` int(11) NOT NULL,
  `Type` varchar(10) DEFAULT 'Book',
  `Response` text,
  `Response_Date` datetime DEFAULT '2013-01-01 00:00:00',
  `Response_User_Id` int(11) NOT NULL,
  PRIMARY KEY (`Report_Id`),
  KEY `fk_reportmaster_1` (`Response_User_Id`),
  CONSTRAINT `fk_reportmaster_1` FOREIGN KEY (`Response_User_Id`) REFERENCES `employeemaster` (`Employee_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportmaster`
--

LOCK TABLES `reportmaster` WRITE;
/*!40000 ALTER TABLE `reportmaster` DISABLE KEYS */;
INSERT INTO `reportmaster` VALUES (2,3,'book','good','2012-12-12 00:00:00',2);
/*!40000 ALTER TABLE `reportmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resourcesharemaster`
--

DROP TABLE IF EXISTS `resourcesharemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resourcesharemaster` (
  `Share_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id` int(11) NOT NULL,
  `Title` varchar(100) DEFAULT '',
  `Type` varchar(20) DEFAULT 'Book',
  `Share_Code` varchar(25) DEFAULT '',
  `Date_Shared` date DEFAULT '2013-01-01',
  `Comment` varchar(500) DEFAULT '',
  `Emails_Shared_With` varchar(1000) DEFAULT '',
  `User_Id` int(11) NOT NULL,
  PRIMARY KEY (`Share_Id`),
  KEY `fk_resourcesharemaster_usermaster1` (`User_Id`),
  CONSTRAINT `fk_resourcesharemaster_usermaster1` FOREIGN KEY (`User_Id`) REFERENCES `usermaster` (`User_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resourcesharemaster`
--

LOCK TABLES `resourcesharemaster` WRITE;
/*!40000 ALTER TABLE `resourcesharemaster` DISABLE KEYS */;
INSERT INTO `resourcesharemaster` VALUES (2,3,'jasper reports','Books','SHWeBwdRMPEsHsmS','2012-08-02','abc','manu123@yahoo.in',2),(8,15,'abc','Book','cddefbeffacecaad','2013-07-22','fads','skk',1),(15,15,'abc','Book','bbfdbaccadccafdd','2013-07-22','jk','juhc',1),(16,7,'sad Song','Audio','ddfbdefbadceafef','2013-07-22','dghihg','kjv',1),(17,3,'abc','web','debaeeedabefaaae','2013-07-22','uweri','iudiffyg',1);
/*!40000 ALTER TABLE `resourcesharemaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sharerequestmaster`
--

DROP TABLE IF EXISTS `sharerequestmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sharerequestmaster` (
  `Request_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Id` int(11) NOT NULL,
  `Title` varchar(100) DEFAULT '',
  `Type` varchar(35) DEFAULT 'Book',
  `Share_Code` varchar(50) DEFAULT '',
  `Request_Date` datetime DEFAULT '2013-01-01 00:00:00',
  `Comment` varchar(200) DEFAULT '',
  `Request_Status` varchar(25) DEFAULT 'Pending',
  `User_Id` int(11) NOT NULL,
  PRIMARY KEY (`Request_Id`),
  KEY `fk_sharerequestmaster_usermaster1` (`User_Id`),
  CONSTRAINT `fk_sharerequestmaster_usermaster1` FOREIGN KEY (`User_Id`) REFERENCES `usermaster` (`User_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sharerequestmaster`
--

LOCK TABLES `sharerequestmaster` WRITE;
/*!40000 ALTER TABLE `sharerequestmaster` DISABLE KEYS */;
INSERT INTO `sharerequestmaster` VALUES (1,3,'jreports','Books','J2cr4ZBXUREHz7CG','2012-08-02 03:02:01','Pls share this............','Approved',1),(2,2,'Best.Practices.Java.Design.Patterns.Automation','Books','hpOTP5uIOSnIwK4a','2012-08-02 03:02:33','Pls Share This..........','Disapproved',2),(3,14,'a','books','a123','2013-07-09 15:33:59','aaa','approved',2);
/*!40000 ALTER TABLE `sharerequestmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statemaster`
--

DROP TABLE IF EXISTS `statemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statemaster` (
  `State_Id` int(11) NOT NULL AUTO_INCREMENT,
  `State_Name` varchar(100) DEFAULT '',
  `Status` varchar(10) DEFAULT '',
  `Country_Id` int(11) NOT NULL,
  PRIMARY KEY (`State_Id`),
  KEY `fk_statemaster_countrymaster1` (`Country_Id`),
  CONSTRAINT `fk_statemaster_countrymaster1` FOREIGN KEY (`Country_Id`) REFERENCES `countrymaster` (`Country_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statemaster`
--

LOCK TABLES `statemaster` WRITE;
/*!40000 ALTER TABLE `statemaster` DISABLE KEYS */;
INSERT INTO `statemaster` VALUES (1,'Punjab','Active',10),(2,'Bihar','Active',10),(3,'Himachal','Active',10),(4,'Haryana','Active',10),(5,'Utter Pardesh','Activce',10);
/*!40000 ALTER TABLE `statemaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetailmaster`
--

DROP TABLE IF EXISTS `userdetailmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userdetailmaster` (
  `User_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT '',
  `Qualification` varchar(45) DEFAULT 'MCA',
  `Country_Id` int(11) NOT NULL,
  `State_Id` int(11) NOT NULL,
  `City_Id` int(11) NOT NULL,
  PRIMARY KEY (`User_Id`),
  KEY `fk_userdetailmaster_countrymaster1` (`Country_Id`),
  KEY `fk_userdetailmaster_statemaster1` (`State_Id`),
  KEY `fk_userdetailmaster_citymaster1` (`City_Id`),
  CONSTRAINT `fk_userdetailmaster_citymaster1` FOREIGN KEY (`City_Id`) REFERENCES `citymaster` (`City_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userdetailmaster_countrymaster1` FOREIGN KEY (`Country_Id`) REFERENCES `countrymaster` (`Country_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userdetailmaster_statemaster1` FOREIGN KEY (`State_Id`) REFERENCES `statemaster` (`State_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userdetailmaster_usermaster1` FOREIGN KEY (`User_Id`) REFERENCES `usermaster` (`User_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetailmaster`
--

LOCK TABLES `userdetailmaster` WRITE;
/*!40000 ALTER TABLE `userdetailmaster` DISABLE KEYS */;
INSERT INTO `userdetailmaster` VALUES (1,'Ranjeet Sing ','BCA',10,1,3),(2,'Ravi Pratap Singh','MCA',10,1,7),(11,'Sushmita','MCA',10,1,5);
/*!40000 ALTER TABLE `userdetailmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermaster`
--

DROP TABLE IF EXISTS `usermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermaster` (
  `User_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(100) DEFAULT '',
  `Password` varchar(50) DEFAULT '',
  `User_Type` varchar(20) DEFAULT '',
  `User_Status` varchar(10) DEFAULT 'Blocked',
  `Registration_Date` date DEFAULT '2013-01-01',
  `Confirmation_Code` varchar(45) DEFAULT '',
  `Is_Temp` int(11) DEFAULT '0',
  PRIMARY KEY (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (1,'ranjeetbrar@gmail.com','ssss','User','Active','2012-08-02','djqptSVdYFZj2jHv',0),(2,'user@gmail.com','user','User','Active','2012-08-02','dy2ns9bheZY5SLjS',0),(3,'abcd@gmail.com','abcd','user','Active','2013-07-04','HpjYwgrr39mhLUhl',1),(4,'as@sa.com','assa','user','Active','2013-07-04','7yvKv6A9kAXLOg9g',1),(5,'sa@as.com','sasa','user','Active','2013-07-04','YnakuVtxLOEYUE4q',1),(6,'swa@gmail.com','1234','user','Inactive','2013-07-22','excPv98qHJoAP9zr',0),(7,'swa@gmail.com','1234','user','Inactive','2013-07-22','mhDKnxYkRe8q7RCI',0),(8,'sww@gmail.com','12345','user','Inactive','2013-07-22','PcSg3L8dGHrK8HDH',0),(9,'jhxz@gmail.com','1234','user','Inactive','2013-07-22','08e6ZvpKS4whGvuQ',0),(10,'sush@gmail.com','sush','user','Inactive','2013-07-25','X1hB8fQ1fZrhVgRF',0),(11,'saaas@gmail.com','1111','user','Active','2013-07-25','GlUYOsZ3dgmbdZMX',1);
/*!40000 ALTER TABLE `usermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userplanmaster`
--

DROP TABLE IF EXISTS `userplanmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userplanmaster` (
  `User_Plan_Id` int(11) NOT NULL,
  `User_Id` int(11) NOT NULL,
  `Plan_Id` int(11) NOT NULL,
  `Start_Date` date DEFAULT '2013-01-01',
  `End_Date` date DEFAULT '2013-03-30',
  `Plan_Status` varchar(15) DEFAULT 'Active',
  PRIMARY KEY (`User_Plan_Id`),
  KEY `fk_userplanmaster_usermaster1` (`User_Id`),
  KEY `fk_userplanmaster_planmaster1` (`Plan_Id`),
  CONSTRAINT `fk_userplanmaster_planmaster1` FOREIGN KEY (`Plan_Id`) REFERENCES `planmaster` (`Plan_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userplanmaster_usermaster1` FOREIGN KEY (`User_Id`) REFERENCES `usermaster` (`User_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userplanmaster`
--

LOCK TABLES `userplanmaster` WRITE;
/*!40000 ALTER TABLE `userplanmaster` DISABLE KEYS */;
INSERT INTO `userplanmaster` VALUES (1,1,3,'2013-07-26','2014-04-26','Active'),(2,2,2,'2013-07-26','2014-07-26','Active'),(3,11,2,'2013-07-26','2014-07-26','Active');
/*!40000 ALTER TABLE `userplanmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weblinkmaster`
--

DROP TABLE IF EXISTS `weblinkmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weblinkmaster` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) DEFAULT '',
  `Link` varchar(200) DEFAULT '',
  `Description` varchar(500) DEFAULT '',
  `Used_For` varchar(200) DEFAULT '',
  `Category` varchar(20) DEFAULT '',
  `Creation_Date` date DEFAULT '2013-01-01',
  `Access_Type` varchar(25) DEFAULT '',
  `Tags` varchar(100) DEFAULT '',
  `User_Id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_weblinkmaster_usermaster1` (`User_Id`),
  CONSTRAINT `fk_weblinkmaster_usermaster1` FOREIGN KEY (`User_Id`) REFERENCES `usermaster` (`User_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weblinkmaster`
--

LOCK TABLES `weblinkmaster` WRITE;
/*!40000 ALTER TABLE `weblinkmaster` DISABLE KEYS */;
INSERT INTO `weblinkmaster` VALUES (3,'abc','http://www.edu.com','zjshflkakl','study','book','2013-07-07','Public','n/a',2);
/*!40000 ALTER TABLE `weblinkmaster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-26 12:45:34
