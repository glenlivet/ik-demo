# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.16)
# Database: study
# Generation Time: 2015-04-23 07:22:49 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `state_flag` int(11) DEFAULT '1',
  `balance` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;

INSERT INTO `account` (`id`, `username`, `password`, `state_flag`, `balance`)
VALUES
	(10001,'tt.t','pswd',1,50000);

/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table employee
# ------------------------------------------------------------

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` varchar(255) NOT NULL,
  `account_id` int(11) DEFAULT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `initials` varchar(255) DEFAULT NULL,
  `state_flag` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_account` (`account_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;

INSERT INTO `employee` (`id`, `account_id`, `firstname`, `lastname`, `initials`, `state_flag`)
VALUES
	('1001',10001,'Testy1','Tester1','T.Tester1',1);

/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table employee_view
# ------------------------------------------------------------

DROP VIEW IF EXISTS `employee_view`;

CREATE TABLE `employee_view` (
   `ID` VARCHAR(255) NOT NULL,
   `FULLNAME` VARCHAR(510) NULL DEFAULT NULL,
   `FIRSTNAME` VARCHAR(255) NOT NULL,
   `LASTNAME` VARCHAR(255) NOT NULL,
   `INITIALS` VARCHAR(255) NULL DEFAULT NULL,
   `STATE_FLAG` INT(11) NULL DEFAULT '1',
   `ACCOUNT_ID` INT(11) NULL DEFAULT '0',
   `USERNAME` VARCHAR(255) NULL DEFAULT NULL,
   `ACCOUNT_STATE` INT(11) NULL DEFAULT '1',
   `BALANCE` DOUBLE NULL DEFAULT '0'
) ENGINE=MyISAM;



# Dump of table sequence
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sequence`;

CREATE TABLE `sequence` (
  `keyname` varchar(255) NOT NULL,
  `number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`keyname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;

INSERT INTO `sequence` (`keyname`, `number`)
VALUES
	('empId',6);

/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;




# Replace placeholder table for employee_view with correct view syntax
# ------------------------------------------------------------

DROP TABLE `employee_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`study`@`localhost` SQL SECURITY DEFINER VIEW `employee_view`
AS SELECT
   `A`.`id` AS `ID`,concat(`A`.`firstname`,
   `A`.`lastname`) AS `FULLNAME`,
   `A`.`firstname` AS `FIRSTNAME`,
   `A`.`lastname` AS `LASTNAME`,
   `A`.`initials` AS `INITIALS`,
   `A`.`state_flag` AS `STATE_FLAG`,
   `B`.`id` AS `ACCOUNT_ID`,
   `B`.`username` AS `USERNAME`,
   `B`.`state_flag` AS `ACCOUNT_STATE`,
   `B`.`balance` AS `BALANCE`
FROM (`employee` `A` left join `account` `B` on((`A`.`account_id` = `B`.`id`)));

--
-- Dumping routines (PROCEDURE) for database 'study'
--
DELIMITER ;;

# Dump of PROCEDURE get_sequence
# ------------------------------------------------------------

/*!50003 DROP PROCEDURE IF EXISTS `get_sequence` */;;
/*!50003 SET SESSION SQL_MODE="STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`study`@`localhost`*/ /*!50003 PROCEDURE `get_sequence`(IN seqname VARCHAR(255), OUT seqvalue INT(11))
BEGIN
		DECLARE seq_exist int(11) DEFAULT 0; 
		
		-- declare duplicated key error handler
		DECLARE EXIT HANDLER FOR 1062 
		BEGIN
			SET seqvalue = -1;
		END;
		
		START TRANSACTION;
		SELECT count(*) INTO seq_exist FROM sequence t WHERE t.keyname = seqname;
		IF seq_exist = 0 THEN 
			INSERT INTO sequence(keyname) VALUES(seqname);
		ELSE 
			UPDATE sequence SET 
			number = (number + 1)
			WHERE keyname = seqname;
		END IF;
		SELECT number INTO seqvalue FROM sequence t WHERE t.keyname = seqname;
		COMMIT ;
	END */;;

/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE */;;
DELIMITER ;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
