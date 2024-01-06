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
-- Table structure for table `TBL_FILE_TEMPLATE`
--

DROP TABLE IF EXISTS `TBL_FILE_TEMPLATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_FILE_TEMPLATE` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `FILE_CODE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段代码',
  `FILE_NAME` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段名称',
  `FILE_PRIMARY` int DEFAULT NULL COMMENT '字段是否主键',
  `FILE_NULL` int DEFAULT NULL COMMENT '字段是否空',
  `FILE_AUTO` int DEFAULT NULL COMMENT '字段是否自增',
  `FILE_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段类型',
  `FILE_DATA_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段数据类型',
  `FILE_LEN` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段长度',
  `FILE_DECIMAL` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段小数位',
  `FILE_DEC` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段说明',
  `FILE_DEFAULT_VAL` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段默认值',
  `FILE_HTML_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段html类型',
  `TABLE_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表id',
  `ENABLED` int DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='字段模板表;';
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `TBL_PROJECT_FILED`
--

DROP TABLE IF EXISTS `TBL_PROJECT_FILED`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TBL_PROJECT_FILED` (
  `ID` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'id',
  `TENANT_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '租户号',
  `REVISION` bigint DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `FILED_CODE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段代码',
  `FILED_NAME` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段名称',
  `FILED_PRIMARY` int DEFAULT NULL COMMENT '字段是否主键',
  `FILED_NULL` int DEFAULT NULL COMMENT '字段是否空',
  `FILED_AUTO` int DEFAULT NULL COMMENT '字段是否自增',
  `FILED_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段类型',
  `FILED_DATA_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段数据类型',
  `FILED_LEN` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段长度',
  `FILED_DECIMAL` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段小数位',
  `FILED_DEC` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段说明',
  `FILED_DEFAULT_VAL` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段默认值',
  `FILED_HTML_TYPE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '字段html类型',
  `TABLE_ID` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '表id',
  `ENABLED` int DEFAULT NULL COMMENT '是否启用',
  `PROJECT_CODE` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '项目编码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='项目字段表;';
/*!40101 SET character_set_client = @saved_cs_client */;

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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='项目信息表;';
/*!40101 SET character_set_client = @saved_cs_client */;

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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='项目表管理;';
/*!40101 SET character_set_client = @saved_cs_client */;

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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='表模板;';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-23 11:01:59
