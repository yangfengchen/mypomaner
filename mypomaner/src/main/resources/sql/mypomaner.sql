-- MySQL dump 10.13  Distrib 8.2.0, for macos13 (x86_64)
--
-- Host: localhost    Database: mypomaner
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `TBL_DICT_DATA`
--

DROP TABLE IF EXISTS `TBL_DICT_DATA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_DICT_DATA` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DICT_LABEL` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签',
  `DICT_VALUE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签值',
  `DICT_SORT` int DEFAULT NULL COMMENT '排序',
  `DICT_CODE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字典编码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典数据表;';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_DICT_DATA`
--

LOCK TABLES `TBL_DICT_DATA` WRITE;
/*!40000 ALTER TABLE `TBL_DICT_DATA` DISABLE KEYS */;
INSERT INTO `TBL_DICT_DATA` VALUES ('679615758153547776',NULL,NULL,NULL,'2023-12-30 20:21:45',NULL,'2024-01-01 17:03:25','mybatis-plugs','mybatis-plugs',0,'codeFrameType'),('696299859153518592',NULL,NULL,NULL,'2024-02-14 21:24:35',NULL,'2024-02-14 21:24:35','mysql','mysql',NULL,'dbType'),('696301469074194432',NULL,NULL,NULL,'2024-02-14 21:24:46',NULL,'2024-02-14 21:24:46','oracle','oracle',NULL,'dbType'),('696301558459006976',NULL,NULL,NULL,'2024-02-14 21:25:34',NULL,'2024-02-14 21:25:34','基本字符串','varchar',NULL,'fieldDbType'),('696301713535008768',NULL,NULL,NULL,'2024-02-14 21:25:59',NULL,'2024-02-14 21:25:59','基本整数','number',NULL,'fieldDbType'),('696301816614223872',NULL,NULL,NULL,'2024-02-14 21:26:26',NULL,'2024-02-14 21:26:26','基本小数','double',NULL,'fieldDbType'),('696301930787373056',NULL,NULL,NULL,'2024-02-14 21:26:47',NULL,'2024-02-14 21:26:47','长字符串','longtext',NULL,'fieldDbType'),('696302114179121152',NULL,NULL,NULL,'2024-02-14 21:28:36',NULL,'2024-02-14 21:28:36','布尔类型','boolean',NULL,'fieldDbType'),('696328071422148608',NULL,NULL,NULL,'2024-02-14 23:10:46',NULL,'2024-02-14 23:10:46','时间类型','datetime',NULL,'fieldDbType');
/*!40000 ALTER TABLE `TBL_DICT_DATA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_DICT_TYPE`
--

DROP TABLE IF EXISTS `TBL_DICT_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_DICT_TYPE` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DICT_NAME` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名称',
  `DICT_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字典表;';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_DICT_TYPE`
--

LOCK TABLES `TBL_DICT_TYPE` WRITE;
/*!40000 ALTER TABLE `TBL_DICT_TYPE` DISABLE KEYS */;
INSERT INTO `TBL_DICT_TYPE` VALUES ('1738608413450981377','1',1,NULL,'2023-12-24 01:22:15',NULL,'2023-12-24 01:22:15','技术框架','codeFrameType'),('677141344929447936','1',1,NULL,'2023-12-24 00:29:08',NULL,'2023-12-24 01:22:15','数据库类型','dbType'),('680371021995311104',NULL,NULL,NULL,'2024-01-01 22:23:36',NULL,'2024-01-01 22:23:36','数据库基本类型','fieldDbType');
/*!40000 ALTER TABLE `TBL_DICT_TYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_FIELD_CONFIG`
--

DROP TABLE IF EXISTS `TBL_FIELD_CONFIG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_FIELD_CONFIG` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `DATABASE_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库类型',
  `FIELD_DB_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段数据库类型',
  `FIELD_CODE_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段编码类型',
  `FIELD_BASE_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段基础类型',
  `FIELD_DEF_LEN` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段默认长度',
  `FIELD_DEF_DECIMAL` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段默认小数',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='项目配置;';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_FIELD_CONFIG`
--

LOCK TABLES `TBL_FIELD_CONFIG` WRITE;
/*!40000 ALTER TABLE `TBL_FIELD_CONFIG` DISABLE KEYS */;
INSERT INTO `TBL_FIELD_CONFIG` VALUES ('0c1b2bd4-7c2c-42d5-a936-27908cf04179',NULL,NULL,NULL,'2024-02-17 01:33:46',NULL,'2024-02-17 01:33:46','mysql','double','Double','Double','',''),('104006f5-bade-4763-9ea9-b01ebae6c244',NULL,NULL,NULL,'2024-02-17 01:33:46',NULL,'2024-02-17 01:33:46','mysql','datetime','LocalDateTime','dateTime','',''),('1757778688528646146',NULL,NULL,NULL,'2024-02-17 01:33:46',NULL,'2024-02-17 01:33:46','mysql','varchar','String','varchar','50',''),('44dff482-5640-4ba9-b898-d581e9e5f5f8',NULL,NULL,NULL,'2024-02-17 01:33:46',NULL,'2024-02-17 01:33:46','mysql','longtext','String','text','',''),('6de68de3-5db0-4822-9111-f487194a2fed',NULL,NULL,NULL,'2024-02-15 10:31:34',NULL,'2024-02-15 10:31:34',NULL,NULL,NULL,NULL,NULL,NULL),('9906c5c0-bcae-4603-924f-91f76a59b635',NULL,NULL,NULL,'2024-02-17 01:33:46',NULL,'2024-02-17 01:33:46','mysql','number','Integer','Integer','',''),('bf0cb685-aa97-462b-9a2d-7d941424987b',NULL,NULL,NULL,'2024-02-17 01:33:46',NULL,'2024-02-17 01:33:46','mysql','boolean','Boolean','tinyint','1','');
/*!40000 ALTER TABLE `TBL_FIELD_CONFIG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_FIELD_TEMPLATE`
--

DROP TABLE IF EXISTS `TBL_FIELD_TEMPLATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_FIELD_TEMPLATE` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `FIELD_CODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段代码',
  `FIELD_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段名称',
  `FIELD_PRIMARY` int DEFAULT NULL COMMENT '字段是否主键',
  `FIELD_NULL` int DEFAULT NULL COMMENT '字段是否空',
  `FIELD_AUTO` int DEFAULT NULL COMMENT '字段是否自增',
  `FIELD_TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段类型',
  `FIELD_DATA_TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段数据类型',
  `FIELD_LEN` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段长度',
  `FIELD_DECIMAL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段小数位',
  `FIELD_DEC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段说明',
  `FIELD_DEFAULT_VAL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段默认值',
  `FIELD_HTML_TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段html类型',
  `TABLE_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表id',
  `ENABLED` int DEFAULT NULL COMMENT '是否启用',
  `FIELD_DTO_STATUS` int DEFAULT NULL,
  `FIELD_VO_STATUS` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字段模板表;';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_FIELD_TEMPLATE`
--

LOCK TABLES `TBL_FIELD_TEMPLATE` WRITE;
/*!40000 ALTER TABLE `TBL_FIELD_TEMPLATE` DISABLE KEYS */;
INSERT INTO `TBL_FIELD_TEMPLATE` VALUES ('1758150108068708353',NULL,NULL,NULL,'2024-02-15 23:23:45',NULL,NULL,'id','唯一主键',1,1,0,'','varchar','50','','','','','code001',1,1,1),('1758150108072902657',NULL,NULL,NULL,'2024-02-15 23:23:45',NULL,NULL,'create_account','创建账号',0,1,0,'','varchar','50','','','','','code001',1,0,0),('1758150108072902658',NULL,NULL,NULL,'2024-02-15 23:23:45',NULL,NULL,'create_time','创建时间',0,1,0,'','datetime','','','','','','code001',1,0,0),('1758150108077096961',NULL,NULL,NULL,'2024-02-15 23:23:45',NULL,NULL,'last_update_account','最后修改账号',0,1,0,'','varchar','50','','','','','code001',1,0,0),('1758150108081291265',NULL,NULL,NULL,'2024-02-15 23:23:45',NULL,NULL,'last_update_time','最后修改时间',0,1,0,'','datetime','','','','','','code001',1,0,0),('1758150108081291266',NULL,NULL,NULL,'2024-02-15 23:23:45',NULL,NULL,'trace_id','链路id',0,1,0,'','varchar','50','','','','','code001',1,0,0),('1758150108085485569',NULL,NULL,NULL,'2024-02-15 23:23:45',NULL,NULL,'revision','乐观锁',0,1,0,'','varchar','50','','','','','code001',1,0,0);
/*!40000 ALTER TABLE `TBL_FIELD_TEMPLATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_PROJECT_CONFIG`
--

DROP TABLE IF EXISTS `TBL_PROJECT_CONFIG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_PROJECT_CONFIG` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `PROJECT_CODE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '项目编码',
  `TABLE_TEMPLATE_CODE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表模板编码',
  `DATABASE_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '数据库类型',
  `CODE_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '编码类型',
  `PREFIX_NAME_REPICE` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '前缀名称替换',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='项目配置;';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_PROJECT_CONFIG`
--

LOCK TABLES `TBL_PROJECT_CONFIG` WRITE;
/*!40000 ALTER TABLE `TBL_PROJECT_CONFIG` DISABLE KEYS */;
INSERT INTO `TBL_PROJECT_CONFIG` VALUES ('696630890154950656',NULL,NULL,NULL,'2024-02-15 19:13:38',NULL,NULL,'my-demo','code001','mysql','mybatis-plugs',NULL);
/*!40000 ALTER TABLE `TBL_PROJECT_CONFIG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_PROJECT_FIELD`
--

DROP TABLE IF EXISTS `TBL_PROJECT_FIELD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_PROJECT_FIELD` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `FIELD_CODE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段代码',
  `FIELD_NAME` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段名称',
  `FIELD_PRIMARY` int DEFAULT NULL COMMENT '字段是否主键',
  `FIELD_NULL` int DEFAULT NULL COMMENT '字段是否空',
  `FIELD_AUTO` int DEFAULT NULL COMMENT '字段是否自增',
  `FIELD_TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段类型',
  `FIELD_DATA_TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段数据类型',
  `FIELD_LEN` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段长度',
  `FIELD_DECIMAL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段小数位',
  `FIELD_DEC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段说明',
  `FIELD_DEFAULT_VAL` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段默认值',
  `FIELD_HTML_TYPE` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段html类型',
  `TABLE_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表id',
  `ENABLED` int DEFAULT NULL COMMENT '是否启用',
  `PROJECT_CODE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '项目编码',
  `FIELD_DTO_STATUS` int DEFAULT NULL,
  `FIELD_VO_STATUS` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='项目字段表;';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_PROJECT_FIELD`
--

LOCK TABLES `TBL_PROJECT_FIELD` WRITE;
/*!40000 ALTER TABLE `TBL_PROJECT_FIELD` DISABLE KEYS */;
INSERT INTO `TBL_PROJECT_FIELD` VALUES ('697001929858875392',NULL,NULL,NULL,NULL,NULL,NULL,'id','唯一主键',1,1,0,'','varchar','50','','','','','697001929800155136',1,'my-demo',1,1),('697001929858875393',NULL,NULL,NULL,NULL,NULL,NULL,'create_account','创建账号',0,1,0,'','varchar','50','','','','','697001929800155136',1,'my-demo',0,0),('697001929858875394',NULL,NULL,NULL,NULL,NULL,NULL,'create_time','创建时间',0,1,0,'','datetime','','','','','','697001929800155136',1,'my-demo',0,0),('697001929858875395',NULL,NULL,NULL,NULL,NULL,NULL,'last_update_account','最后修改账号',0,1,0,'','varchar','50','','','','','697001929800155136',1,'my-demo',0,0),('697001929858875396',NULL,NULL,NULL,NULL,NULL,NULL,'last_update_time','最后修改时间',0,1,0,'','datetime','','','','','','697001929800155136',1,'my-demo',0,0),('697001929858875397',NULL,NULL,NULL,NULL,NULL,NULL,'trace_id','链路id',0,1,0,'','varchar','50','','','','','697001929800155136',1,'my-demo',0,0),('697001929858875398',NULL,NULL,NULL,NULL,NULL,NULL,'revision','乐观锁',0,1,0,'','varchar','50','','','','','697001929800155136',1,'my-demo',0,0);
/*!40000 ALTER TABLE `TBL_PROJECT_FIELD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_PROJECT_INFO`
--

DROP TABLE IF EXISTS `TBL_PROJECT_INFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_PROJECT_INFO` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `PROJECT_NAME` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '项目名称',
  `PROJECT_CODE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '项目编码',
  `PROJECT_ZN_NAME` varchar(500) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '项目中文名称',
  `PACKAGE_NAME` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='项目信息表;';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_PROJECT_INFO`
--

LOCK TABLES `TBL_PROJECT_INFO` WRITE;
/*!40000 ALTER TABLE `TBL_PROJECT_INFO` DISABLE KEYS */;
INSERT INTO `TBL_PROJECT_INFO` VALUES ('1758087162873622530',NULL,NULL,NULL,'2024-02-15 19:13:38',NULL,'2024-02-15 19:19:57','my-demo','my-demo','我的测试项目','com.ddzj.demo');
/*!40000 ALTER TABLE `TBL_PROJECT_INFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_PROJECT_TABLE`
--

DROP TABLE IF EXISTS `TBL_PROJECT_TABLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_PROJECT_TABLE` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `PREFIX_NAME` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '前缀名称',
  `NAME` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表名称',
  `ENABLED` int DEFAULT NULL COMMENT '是否生效',
  `PROJECT_CODE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '项目表编码',
  `ZN_NAME` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CODE_NAME` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `PACKAGE_NAME` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='项目表管理;';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_PROJECT_TABLE`
--

LOCK TABLES `TBL_PROJECT_TABLE` WRITE;
/*!40000 ALTER TABLE `TBL_PROJECT_TABLE` DISABLE KEYS */;
INSERT INTO `TBL_PROJECT_TABLE` VALUES ('697001929800155136',NULL,NULL,NULL,'2024-02-16 19:48:35',NULL,'2024-02-16 19:48:35',NULL,'tbl_user',1,'my-demo','用户表','User','com.ddzj.demo');
/*!40000 ALTER TABLE `TBL_PROJECT_TABLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_TABLE_TEMPLATE`
--

DROP TABLE IF EXISTS `TBL_TABLE_TEMPLATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_TABLE_TEMPLATE` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `PREFIX_NAME` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '前缀名称',
  `NAME` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表名称',
  `ENABLED` int DEFAULT NULL COMMENT '是否生效',
  `CODE` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='表模板;';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_TABLE_TEMPLATE`
--

LOCK TABLES `TBL_TABLE_TEMPLATE` WRITE;
/*!40000 ALTER TABLE `TBL_TABLE_TEMPLATE` DISABLE KEYS */;
INSERT INTO `TBL_TABLE_TEMPLATE` VALUES ('1758004148510076929',NULL,NULL,NULL,'2024-02-15 13:43:46',NULL,'2024-02-15 13:43:46',NULL,'乐观锁和链路',1,'code001');
/*!40000 ALTER TABLE `TBL_TABLE_TEMPLATE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-17  1:38:25
