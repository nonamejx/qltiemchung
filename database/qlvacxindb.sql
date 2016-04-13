-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: qlvacxindb
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `canbo`
--

DROP TABLE IF EXISTS `canbo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `canbo` (
  `maCanBo` int(11) NOT NULL AUTO_INCREMENT,
  `tenCanBo` varchar(100) DEFAULT NULL,
  `tenDangNhap` varchar(100) DEFAULT NULL,
  `matKhau` varchar(100) DEFAULT NULL,
  `gioiTinh` int(11) DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `soDienThoai` varchar(30) DEFAULT NULL,
  `diaChi` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`maCanBo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Bang thong tin can bo';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canbo`
--

LOCK TABLES `canbo` WRITE;
/*!40000 ALTER TABLE `canbo` DISABLE KEYS */;
INSERT INTO `canbo` VALUES (1,'Cán bộ 1','user1','123456',3,'1995-01-01','01643446789','Đà Nẵng                     '),(2,'Admin','admin','123456',1,'1994-01-02','01643446917','Danang'),(3,'Can bo 2','user2','123456',3,'1994-12-23','1234567890','dia chi 1');
/*!40000 ALTER TABLE `canbo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doituong`
--

DROP TABLE IF EXISTS `doituong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doituong` (
  `maDoiTuong` int(11) NOT NULL AUTO_INCREMENT,
  `tenDoiTuong` varchar(50) DEFAULT NULL,
  `ghiChu` varchar(300) DEFAULT NULL,
  `batDau` int(11) DEFAULT NULL,
  `ketThuc` int(11) DEFAULT NULL,
  PRIMARY KEY (`maDoiTuong`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='Bang thong tin doi tuong';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doituong`
--

LOCK TABLES `doituong` WRITE;
/*!40000 ALTER TABLE `doituong` DISABLE KEYS */;
INSERT INTO `doituong` VALUES (1,'Sơ sinh','',0,1),(2,'1,5-2 tháng tuổi','',1,2),(3,'2 tháng tuổi','',2,3),(4,'3 tháng tuổi','',3,4),(5,'4 tháng tuổi','',4,5),(6,'9 tháng tuổi','',9,10),(7,'12 tháng tuổi','',12,13),(8,'24 tháng tuổi','',24,25);
/*!40000 ALTER TABLE `doituong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ketqua`
--

DROP TABLE IF EXISTS `ketqua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ketqua` (
  `maKhach` int(11) NOT NULL,
  `maVacxin` int(11) NOT NULL,
  `maLich` int(11) NOT NULL,
  `ngayTiem` datetime DEFAULT NULL,
  `bacSi` varchar(100) DEFAULT NULL,
  `diaDiem` varchar(200) DEFAULT NULL,
  `trangThai` bit(1) DEFAULT NULL,
  `ghiChu` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`maKhach`,`maVacxin`,`maLich`),
  KEY `ketqua_lichtiem_idx` (`maLich`),
  KEY `ketqua_vacxin_idx` (`maVacxin`),
  CONSTRAINT `ketqua_khachtiem` FOREIGN KEY (`maKhach`) REFERENCES `khachtiem` (`maKhach`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ketqua_lichtiem` FOREIGN KEY (`maLich`) REFERENCES `lichtiemphong` (`maLich`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ketqua_vacxin` FOREIGN KEY (`maVacxin`) REFERENCES `vacxin` (`maVacxin`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Bang ket qua tiem';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ketqua`
--

LOCK TABLES `ketqua` WRITE;
/*!40000 ALTER TABLE `ketqua` DISABLE KEYS */;
/*!40000 ALTER TABLE `ketqua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachtiem`
--

DROP TABLE IF EXISTS `khachtiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khachtiem` (
  `maKhach` int(11) NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(100) DEFAULT NULL,
  `gioiTinh` int(11) DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `diaChi` varchar(100) DEFAULT NULL,
  `tenDangNhap` varchar(100) DEFAULT NULL,
  `matKhau` varchar(100) DEFAULT NULL,
  `cmnd` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `soDienThoai` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`maKhach`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Bang thong tin khach tiem';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachtiem`
--

LOCK TABLES `khachtiem` WRITE;
/*!40000 ALTER TABLE `khachtiem` DISABLE KEYS */;
INSERT INTO `khachtiem` VALUES (1,'khach tiem 1',1,'1994-01-01','Đà Nẵng','khachtiem1','123456','201654333','khach1@gmail.com','0905668790');
/*!40000 ALTER TABLE `khachtiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichtiemphong`
--

DROP TABLE IF EXISTS `lichtiemphong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lichtiemphong` (
  `maLich` int(11) NOT NULL AUTO_INCREMENT,
  `maDoiTuong` int(11) NOT NULL,
  `maLoaiVacxin` int(11) NOT NULL,
  `lanTiem` int(11) NOT NULL,
  `ghiChu` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`maLich`),
  KEY `lichtiem_doituong_idx` (`maDoiTuong`),
  KEY `lichtiem_loaivacxin_idx` (`maLoaiVacxin`),
  CONSTRAINT `lichtiem_doituong` FOREIGN KEY (`maDoiTuong`) REFERENCES `doituong` (`maDoiTuong`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `lichtiem_loaivacxin` FOREIGN KEY (`maLoaiVacxin`) REFERENCES `loaivacxin` (`maLoai`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Bang lich tiem phong';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichtiemphong`
--

LOCK TABLES `lichtiemphong` WRITE;
/*!40000 ALTER TABLE `lichtiemphong` DISABLE KEYS */;
/*!40000 ALTER TABLE `lichtiemphong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaitintuc`
--

DROP TABLE IF EXISTS `loaitintuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loaitintuc` (
  `maLoai` int(11) NOT NULL AUTO_INCREMENT,
  `tenLoaiTin` varchar(100) DEFAULT NULL,
  `moTa` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`maLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Bang loai tin tuc';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaitintuc`
--

LOCK TABLES `loaitintuc` WRITE;
/*!40000 ALTER TABLE `loaitintuc` DISABLE KEYS */;
INSERT INTO `loaitintuc` VALUES (1,'loai tin 1',' mo ta loai tin 1');
/*!40000 ALTER TABLE `loaitintuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaivacxin`
--

DROP TABLE IF EXISTS `loaivacxin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loaivacxin` (
  `maLoai` int(11) NOT NULL AUTO_INCREMENT,
  `tenLoai` varchar(100) DEFAULT NULL,
  `moTa` varchar(200) DEFAULT NULL,
  `ghiChu` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`maLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='Loai vac xin';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaivacxin`
--

LOCK TABLES `loaivacxin` WRITE;
/*!40000 ALTER TABLE `loaivacxin` DISABLE KEYS */;
INSERT INTO `loaivacxin` VALUES (2,'Lao','',''),(3,'Viêm gan B','',''),(4,'Viêm dạ dày ruột do Rota virus (Bỉ)','',''),(5,'Bạch hầu, Ho gà - Uốn ván - Bại Liệt','',''),(6,'Viêm màng não mủ, viêm họng, viêm phế quản, viêm phổi… do Haemophilus influenza tyb B','',''),(7,'Cúm','',''),(8,'Sởi-Quai bị-Rubella','',''),(9,'Thủy đậu','',''),(10,'Viêm não Nhật Bản','',''),(11,'Viêm gan A','',''),(12,'Viêm màng não do não mô cầu ','',''),(13,'Viêm phổi do Phế cầu khuẩn','',''),(14,'Thương hàn','','');
/*!40000 ALTER TABLE `loaivacxin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tintuc`
--

DROP TABLE IF EXISTS `tintuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tintuc` (
  `maTin` int(11) NOT NULL AUTO_INCREMENT,
  `maLoaiTin` int(11) NOT NULL,
  `nguoiViet` int(11) NOT NULL,
  `ngayViet` datetime DEFAULT NULL,
  `tieuDe` varchar(200) DEFAULT NULL,
  `noiDung` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`maTin`),
  KEY `tintuc_canbo_idx` (`nguoiViet`),
  KEY `tintuc_ibfk_1` (`maLoaiTin`),
  CONSTRAINT `tintuc_canbo` FOREIGN KEY (`nguoiViet`) REFERENCES `canbo` (`maCanBo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tintuc_ibfk_1` FOREIGN KEY (`maLoaiTin`) REFERENCES `loaitintuc` (`maLoai`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Bang thong tin Tin Tuc';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tintuc`
--

LOCK TABLES `tintuc` WRITE;
/*!40000 ALTER TABLE `tintuc` DISABLE KEYS */;
INSERT INTO `tintuc` VALUES (1,1,1,'2016-04-02 00:00:00','Tieu de tin 1','Noi dung tin 1');
/*!40000 ALTER TABLE `tintuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacxin`
--

DROP TABLE IF EXISTS `vacxin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacxin` (
  `maVacxin` int(11) NOT NULL AUTO_INCREMENT,
  `tenVacxin` varchar(100) DEFAULT NULL,
  `tacDung` varchar(200) DEFAULT NULL,
  `chiDinh` varchar(200) DEFAULT NULL,
  `chongChiDinh` varchar(200) DEFAULT NULL,
  `tacDungPhu` varchar(200) DEFAULT NULL,
  `maLoai` int(11) DEFAULT NULL,
  PRIMARY KEY (`maVacxin`),
  KEY `vacxin_loaivacxin_idx` (`maLoai`),
  CONSTRAINT `vacxin_loaivacxin` FOREIGN KEY (`maLoai`) REFERENCES `loaivacxin` (`maLoai`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Thong tin vacxin';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacxin`
--

LOCK TABLES `vacxin` WRITE;
/*!40000 ALTER TABLE `vacxin` DISABLE KEYS */;
INSERT INTO `vacxin` VALUES (2,'vacxin 1','tac dung 1','chi dinh 1','chong chi dinh 1','tacdung phu 1',2);
/*!40000 ALTER TABLE `vacxin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'qlvacxindb'
--

--
-- Dumping routines for database 'qlvacxindb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-13 15:36:53
