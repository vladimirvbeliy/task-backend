-- create user rest pass rest
CREATE USER 'rest'@'localhost' IDENTIFIED BY 'rest';
GRANT ALL PRIVILEGES ON * . * TO 'rest'@'localhost';

-- create db
DROP SCHEMA IF EXISTS `landmark_client`;

CREATE SCHEMA `landmark_client`;

USE `landmark_client`;

SET FOREIGN_KEY_CHECKS = 0;


-- DT LIST

-- ***********************************************************************************

-- QUOTE

create table if not exists test.payment
(
	id bigint auto_increment
		primary key,
	date_cr varchar(255) null,
	filia_name varchar(255) null,
	filia_num bigint null,
	full_lines int null,
	full_sum int null,
	mfo_filia bigint null,
	opfu_code bigint null,
	opfu_name varchar(255) null,
	payment_id bigint null
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `QUOTE`

CREATE TABLE `QUOTE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RELEASE_VERSION` varchar(255) DEFAULT NULL,
  `UPRN` bigint(20) DEFAULT NULL,
  `CANCELLATIONS_ID` bigint(20) DEFAULT NULL,
  `EGL_ID` bigint(20) DEFAULT NULL,
  `RENEWALS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_b0r1vfjbjtr0ohi9khiui52t1` (`UPRN`),
  KEY `FKeuvm85tvg8wip8t3ccldhasy5` (`CANCELLATIONS_ID`),
  KEY `FK69ke8ncb97w812hsvuaygxrui` (`EGL_ID`),
  KEY `FKo3gye8qcjhgvrqyojlniml2ij` (`RENEWALS_ID`),
  CONSTRAINT `FK69ke8ncb97w812hsvuaygxrui` FOREIGN KEY (`EGL_ID`) REFERENCES `EGL_RESPONSE` (`ID`),
  CONSTRAINT `FKeuvm85tvg8wip8t3ccldhasy5` FOREIGN KEY (`CANCELLATIONS_ID`) REFERENCES `CANCELLATIONS_RESPONSE` (`ID`),
  CONSTRAINT `FKo3gye8qcjhgvrqyojlniml2ij` FOREIGN KEY (`RENEWALS_ID`) REFERENCES `RENEWALS_RESPONSE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- *******************************************************************

-- EGL_RESPONSE

DROP TABLE IF EXISTS `EGL_RESPONSE`

CREATE TABLE `EGL_RESPONSE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `REASON_CODES` varchar(255) DEFAULT NULL,
  `UNDERWRITING_FLAG` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- *******************************************************************

-- POLICY

DROP TABLE IF EXISTS `POLICY`

CREATE TABLE `POLICY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONFIDENCE` varchar(255) DEFAULT NULL,
  `COVER` varchar(255) DEFAULT NULL,
  `EGL_RESPONSE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKfya031t2c5iaw5ojakce7hu8u` (`EGL_RESPONSE_ID`),
  CONSTRAINT `FKfya031t2c5iaw5ojakce7hu8u` FOREIGN KEY (`EGL_RESPONSE_ID`) REFERENCES `EGL_RESPONSE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- *******************************************************************

-- EGL

DROP TABLE IF EXISTS `EGL`

CREATE TABLE `EGL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PERIL` varchar(255) DEFAULT NULL,
  `VALUE` double DEFAULT NULL,
  `POLICY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKoddgwiwq43i22lbaqwx50yflr` (`POLICY_ID`),
  CONSTRAINT `FKoddgwiwq43i22lbaqwx50yflr` FOREIGN KEY (`POLICY_ID`) REFERENCES `POLICY` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- *******************************************************************

-- RENEWALS_RESPONSE

DROP TABLE IF EXISTS `RENEWALS_RESPONSE`

CREATE TABLE `RENEWALS_RESPONSE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- ******************************************************************

-- RENEWALS_PROBABILITY

DROP TABLE IF EXISTS `RENEWALS_PROBABILITY`


CREATE TABLE `RENEWALS_PROBABILITY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PROBABILITY` double DEFAULT NULL,
  `RENEWALS_MODEL` varchar(255) DEFAULT NULL,
  `REN_RESPONSE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKbh9sje36mat3s8f18ecmw3opw` (`REN_RESPONSE_ID`),
  CONSTRAINT `FKbh9sje36mat3s8f18ecmw3opw` FOREIGN KEY (`REN_RESPONSE_ID`) REFERENCES `RENEWALS_RESPONSE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- *****************************************************************

-- CANCELLATIONS_RESPONSE

DROP TABLE IF EXISTS `CANCELLATIONS_RESPONSE`


CREATE TABLE `CANCELLATIONS_RESPONSE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- ******************************************************************

-- CANCELLATIONS_PROBABILITY

DROP TABLE IF EXISTS `CANCELLATIONS_PROBABILITY`

CREATE TABLE `CANCELLATIONS_PROBABILITY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CANCELLATIONS_MODEL` varchar(255) DEFAULT NULL,
  `PROBABILITY` double DEFAULT NULL,
  `CAN_RESPONSE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKc3uysg2i6x8en1s38ueyedvdu` (`CAN_RESPONSE_ID`),
  CONSTRAINT `FKc3uysg2i6x8en1s38ueyedvdu` FOREIGN KEY (`CAN_RESPONSE_ID`) REFERENCES `CANCELLATIONS_RESPONSE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- ***********************************************************************

SET FOREIGN_KEY_CHECKS = 1;
