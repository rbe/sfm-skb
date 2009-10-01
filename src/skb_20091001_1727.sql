-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.4.2-beta-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema skb
--

CREATE DATABASE IF NOT EXISTS skb;
USE skb;

--
-- Definition of table `akvd`
--

DROP TABLE IF EXISTS `akvd`;
CREATE TABLE `akvd` (
  `FAB` varchar(45) NOT NULL,
  `PKTVWD` double NOT NULL,
  `PKTAKVD` double NOT NULL,
  `FALLVWD` double NOT NULL,
  `FALLAKVD` double NOT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`FAB`,`Datum`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akvd`
--

/*!40000 ALTER TABLE `akvd` DISABLE KEYS */;
INSERT INTO `akvd` (`FAB`,`PKTVWD`,`PKTAKVD`,`FALLVWD`,`FALLAKVD`,`Datum`) VALUES 
 ('HA1800',2557.29999999998,2558.10624313308,1344.99999999986,1346.48264479533,'2009-10-01');
/*!40000 ALTER TABLE `akvd` ENABLE KEYS */;


--
-- Definition of table `cognos_ach`
--

DROP TABLE IF EXISTS `cognos_ach`;
CREATE TABLE `cognos_ach` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumACH` double DEFAULT NULL,
  `kumOP` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `MonatACH` double DEFAULT NULL,
  `MonatOP` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_ach`
--

/*!40000 ALTER TABLE `cognos_ach` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_ach` ENABLE KEYS */;


--
-- Definition of table `cognos_anae`
--

DROP TABLE IF EXISTS `cognos_anae`;
CREATE TABLE `cognos_anae` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumAnae` double DEFAULT NULL,
  `kumAmbCarre` double DEFAULT NULL,
  `MonatAnae` double DEFAULT NULL,
  `MonatAmbCarre` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_anae`
--

/*!40000 ALTER TABLE `cognos_anae` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_anae` ENABLE KEYS */;


--
-- Definition of table `cognos_aug`
--

DROP TABLE IF EXISTS `cognos_aug`;
CREATE TABLE `cognos_aug` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` double NOT NULL,
  `kumAug` double DEFAULT NULL,
  `kumOPAug` double DEFAULT NULL,
  `MonatAug` double DEFAULT NULL,
  `MonatOPAug` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_aug`
--

/*!40000 ALTER TABLE `cognos_aug` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_aug` ENABLE KEYS */;


--
-- Definition of table `cognos_bkl`
--

DROP TABLE IF EXISTS `cognos_bkl`;
CREATE TABLE `cognos_bkl` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumBKL` double DEFAULT NULL,
  `kumOPBKL` double DEFAULT NULL,
  `MonatBKL` double DEFAULT NULL,
  `MonatOPBKL` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_bkl`
--

/*!40000 ALTER TABLE `cognos_bkl` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_bkl` ENABLE KEYS */;


--
-- Definition of table `cognos_dial`
--

DROP TABLE IF EXISTS `cognos_dial`;
CREATE TABLE `cognos_dial` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumDial` double DEFAULT NULL,
  `MonatDial` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_dial`
--

/*!40000 ALTER TABLE `cognos_dial` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_dial` ENABLE KEYS */;


--
-- Definition of table `cognos_gch`
--

DROP TABLE IF EXISTS `cognos_gch`;
CREATE TABLE `cognos_gch` (
  `Kostenart` varchar(45) NOT NULL,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumGCH` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `kumDSA` double DEFAULT NULL,
  `kumOP` double DEFAULT NULL,
  `kumOP6` double DEFAULT NULL,
  `kumDSAZOP` double DEFAULT NULL,
  `MonatGCH` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `MonatDSA` double DEFAULT NULL,
  `MonatOP` double DEFAULT NULL,
  `MonatOP6` double DEFAULT NULL,
  `MonatDSAZOP` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`Bezeichnung`,`Datum`,`Kostenart`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_gch`
--

/*!40000 ALTER TABLE `cognos_gch` DISABLE KEYS */;
INSERT INTO `cognos_gch` (`Kostenart`,`Bezeichnung`,`kumGCH`,`kumPflegeBereich`,`kumDSA`,`kumOP`,`kumOP6`,`kumDSAZOP`,`MonatGCH`,`MonatPflegeBereich`,`MonatDSA`,`MonatOP`,`MonatOP6`,`MonatDSAZOP`,`Datum`) VALUES 
 ('Arzneimittel','92320 DSA',0,0,-480.91,0,0,0,0,0,-71.66,0,0,0,'2009-10-01'),
 ('Blutprodukte','92320 DSA',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','92320 DSA',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','92320 DSA',0,0,-72805.59,0,0,0,0,0,-4155.03,0,0,0,'2009-10-01'),
 ('Konsile (extern)','92320 DSA',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','92320 DSA',0,0,-53338.85,0,0,0,0,0,-3065.68,0,0,0,'2009-10-01'),
 ('OP-Bedarf','92320 DSA',0,0,-243699.98,0,0,0,0,0,-25194.46,0,0,0,'2009-10-01'),
 ('Arzneimittel','92524 OP GCH',0,0,0,-13443.8,0,0,0,0,0,-1670.91,0,0,'2009-10-01'),
 ('Blutprodukte','92524 OP GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','92524 OP GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','92524 OP GCH',0,0,0,-739773.33,0,0,0,0,0,-61940.14,0,0,'2009-10-01'),
 ('Konsile (extern)','92524 OP GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','92524 OP GCH',0,0,0,-17338.26,0,0,0,0,0,-1255.37,0,0,'2009-10-01'),
 ('OP-Bedarf','92524 OP GCH',0,0,0,-195081.2,0,0,0,0,0,-32527,0,0,'2009-10-01'),
 ('Arzneimittel','92543 DSA Anlage im ZOP',0,0,0,0,0,-1497.76,0,0,0,0,0,-177.07,'2009-10-01'),
 ('Blutprodukte','92543 DSA Anlage im ZOP',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','92543 DSA Anlage im ZOP',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','92543 DSA Anlage im ZOP',0,0,0,0,0,-1499714.32,0,0,0,0,0,-127454,'2009-10-01'),
 ('Konsile (extern)','92543 DSA Anlage im ZOP',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','92543 DSA Anlage im ZOP',0,0,0,0,0,-47075.7,0,0,0,0,0,-5545.98,'2009-10-01'),
 ('OP-Bedarf','92543 DSA Anlage im ZOP',0,0,0,0,0,-572788.07,0,0,0,0,0,-70305.37,'2009-10-01'),
 ('Arzneimittel','92546 OP 6 GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','92546 OP 6 GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','92546 OP 6 GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','92546 OP 6 GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','92546 OP 6 GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','92546 OP 6 GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','92546 OP 6 GCH',0,0,0,0,-65,0,0,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','93002 Station 2',0,-532.76,0,0,0,0,0,-60.42,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','93002 Station 2',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','93002 Station 2',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','93002 Station 2',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','93002 Station 2',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','93002 Station 2',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','93002 Station 2',0,-408.19,0,0,0,0,0,-39.5,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94200 FB Gefäßchirurgie',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94200 FB Gefäßchirurgie',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94200 FB Gefäßchirurgie',-3077.3,0,0,0,0,0,-368.69,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94200 FB Gefäßchirurgie',-10593,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94200 FB Gefäßchirurgie',-397.36,0,0,0,0,0,-159.68,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94200 FB Gefäßchirurgie',-56.28,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94200 FB Gefäßchirurgie',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94201 Station 1 - GCH',-1341.42,0,0,0,0,0,-64.4,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94201 Station 1 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94201 Station 1 - GCH',-4404.72,0,0,0,0,0,-545.38,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94201 Station 1 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94201 Station 1 - GCH',-145.31,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94201 Station 1 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94201 Station 1 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94202 Station 2 - GCH',-30701.51,0,0,0,0,0,-4110.19,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94202 Station 2 - GCH',-205.28,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94202 Station 2 - GCH',-42660.42,0,0,0,0,0,-1910.29,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94202 Station 2 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94202 Station 2 - GCH',-3095.62,0,0,0,0,0,-414.08,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94202 Station 2 - GCH',-23389.56,0,0,0,0,0,-2349.1,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94202 Station 2 - GCH',-2795.91,0,0,0,0,0,-308.65,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94204 Station 4 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94204 Station 4 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94204 Station 4 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94204 Station 4 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94204 Station 4 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94204 Station 4 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94204 Station 4 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94209 Station 9 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94209 Station 9 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94209 Station 9 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94209 Station 9 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94209 Station 9 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94209 Station 9 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94209 Station 9 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94216 Station 16 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94216 Station 16 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94216 Station 16 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94216 Station 16 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94216 Station 16 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94216 Station 16 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94216 Station 16 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94218 Station 18 - GCH',-10621.98,0,0,0,0,0,-749.46,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94218 Station 18 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94218 Station 18 - GCH',-18086.62,0,0,0,0,0,-356.97,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94218 Station 18 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94218 Station 18 - GCH',-903.28,0,0,0,0,0,-490.08,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94218 Station 18 - GCH',-64.98,0,0,0,0,0,-32.49,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94218 Station 18 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94226 Station 26 - GCH - Liegend',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94226 Station 26 - GCH - Liegend',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94226 Station 26 - GCH - Liegend',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94226 Station 26 - GCH - Liegend',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94226 Station 26 - GCH - Liegend',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94226 Station 26 - GCH - Liegend',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94226 Station 26 - GCH - Liegend',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94240 Station 40 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94240 Station 40 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94240 Station 40 - GCH',-3.57,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94240 Station 40 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94240 Station 40 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94240 Station 40 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94240 Station 40 - GCH',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Arzneimittel','94291 GCH vor-nachstationär',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Blutprodukte','94291 GCH vor-nachstationär',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Fremduntersuchungen','94291 GCH vor-nachstationär',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Implantate','94291 GCH vor-nachstationär',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Konsile (extern)','94291 GCH vor-nachstationär',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('Medizinischer Sachbedarf','94291 GCH vor-nachstationär',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01'),
 ('OP-Bedarf','94291 GCH vor-nachstationär',0,0,0,0,0,0,0,0,0,0,0,0,'2009-10-01');
/*!40000 ALTER TABLE `cognos_gch` ENABLE KEYS */;


--
-- Definition of table `cognos_gyn`
--

DROP TABLE IF EXISTS `cognos_gyn`;
CREATE TABLE `cognos_gyn` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumGYN_GEB` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `kumOPGYN` double DEFAULT NULL,
  `MonatGYN_GEB` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `MonatOPGYN` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_gyn`
--

/*!40000 ALTER TABLE `cognos_gyn` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_gyn` ENABLE KEYS */;


--
-- Definition of table `cognos_hno`
--

DROP TABLE IF EXISTS `cognos_hno`;
CREATE TABLE `cognos_hno` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumHNO` double DEFAULT NULL,
  `kumOPHNO` double DEFAULT NULL,
  `MonatHNO` double DEFAULT NULL,
  `MonatOPHNO` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_hno`
--

/*!40000 ALTER TABLE `cognos_hno` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_hno` ENABLE KEYS */;


--
-- Definition of table `cognos_intim`
--

DROP TABLE IF EXISTS `cognos_intim`;
CREATE TABLE `cognos_intim` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumITS19` double DEFAULT NULL,
  `kumM4` double DEFAULT NULL,
  `kumZNA` double DEFAULT NULL,
  `MonatITS19` double DEFAULT NULL,
  `MonatM4` double DEFAULT NULL,
  `MonatZNA` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_intim`
--

/*!40000 ALTER TABLE `cognos_intim` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_intim` ENABLE KEYS */;


--
-- Definition of table `cognos_intop`
--

DROP TABLE IF EXISTS `cognos_intop`;
CREATE TABLE `cognos_intop` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumITS22` double DEFAULT NULL,
  `MonatITS22` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_intop`
--

/*!40000 ALTER TABLE `cognos_intop` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_intop` ENABLE KEYS */;


--
-- Definition of table `cognos_kort`
--

DROP TABLE IF EXISTS `cognos_kort`;
CREATE TABLE `cognos_kort` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumKORT` double DEFAULT NULL,
  `kumOPKORT` double DEFAULT NULL,
  `MonatKORT` double DEFAULT NULL,
  `MonatOPKORT` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_kort`
--

/*!40000 ALTER TABLE `cognos_kort` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_kort` ENABLE KEYS */;


--
-- Definition of table `cognos_m1`
--

DROP TABLE IF EXISTS `cognos_m1`;
CREATE TABLE `cognos_m1` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumM1` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `kumNEPH` double DEFAULT NULL,
  `MonatM1` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `MonatNEPH` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_m1`
--

/*!40000 ALTER TABLE `cognos_m1` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_m1` ENABLE KEYS */;


--
-- Definition of table `cognos_m2`
--

DROP TABLE IF EXISTS `cognos_m2`;
CREATE TABLE `cognos_m2` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumM2` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `kumEndo` double DEFAULT NULL,
  `MonatM2` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `MonatEndo` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_m2`
--

/*!40000 ALTER TABLE `cognos_m2` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_m2` ENABLE KEYS */;


--
-- Definition of table `cognos_m3`
--

DROP TABLE IF EXISTS `cognos_m3`;
CREATE TABLE `cognos_m3` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumM3` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `kumHKL` double DEFAULT NULL,
  `kumEKG` double DEFAULT NULL,
  `MonatM3` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `MonatHKL` double DEFAULT NULL,
  `MonatEKG` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_m3`
--

/*!40000 ALTER TABLE `cognos_m3` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_m3` ENABLE KEYS */;


--
-- Definition of table `cognos_neo`
--

DROP TABLE IF EXISTS `cognos_neo`;
CREATE TABLE `cognos_neo` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumNEO` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `MonatNEO` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_neo`
--

/*!40000 ALTER TABLE `cognos_neo` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_neo` ENABLE KEYS */;


--
-- Definition of table `cognos_op`
--

DROP TABLE IF EXISTS `cognos_op`;
CREATE TABLE `cognos_op` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumZOP` double DEFAULT NULL,
  `kumSteriZOP` double DEFAULT NULL,
  `kumGYN` double DEFAULT NULL,
  `kumBKL` double DEFAULT NULL,
  `kumPraxenCarre` double DEFAULT NULL,
  `kumOPCarre` double DEFAULT NULL,
  `kumOPKich` double DEFAULT NULL,
  `kumOPProkto` double DEFAULT NULL,
  `kumOPOral` double DEFAULT NULL,
  `kumOPUro` double DEFAULT NULL,
  `MonatZOP` double DEFAULT NULL,
  `MonatSteriOP` double DEFAULT NULL,
  `MonatGYN` double DEFAULT NULL,
  `MonatBKL` double DEFAULT NULL,
  `MonatPraxenCarre` double DEFAULT NULL,
  `MonatOPCarre` double DEFAULT NULL,
  `MonatOPKich` double DEFAULT NULL,
  `MonatOPProtko` double DEFAULT NULL,
  `MonatOPOral` double DEFAULT NULL,
  `MonatOPUro` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_op`
--

/*!40000 ALTER TABLE `cognos_op` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_op` ENABLE KEYS */;


--
-- Definition of table `cognos_ort`
--

DROP TABLE IF EXISTS `cognos_ort`;
CREATE TABLE `cognos_ort` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumORT` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `kumOP` double DEFAULT NULL,
  `kumOP4` double DEFAULT NULL,
  `kumOP5` double DEFAULT NULL,
  `MonatORT` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `MonatOP` double DEFAULT NULL,
  `MonatOP4` double DEFAULT NULL,
  `MonatOP5` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_ort`
--

/*!40000 ALTER TABLE `cognos_ort` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_ort` ENABLE KEYS */;


--
-- Definition of table `cognos_paed`
--

DROP TABLE IF EXISTS `cognos_paed`;
CREATE TABLE `cognos_paed` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumPAED` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `MonatPAED` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_paed`
--

/*!40000 ALTER TABLE `cognos_paed` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_paed` ENABLE KEYS */;


--
-- Definition of table `cognos_pal`
--

DROP TABLE IF EXISTS `cognos_pal`;
CREATE TABLE `cognos_pal` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumPAL` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `MonatPAL` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_pal`
--

/*!40000 ALTER TABLE `cognos_pal` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_pal` ENABLE KEYS */;


--
-- Definition of table `cognos_pflege`
--

DROP TABLE IF EXISTS `cognos_pflege`;
CREATE TABLE `cognos_pflege` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumJahr` double DEFAULT NULL,
  `Monat` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_pflege`
--

/*!40000 ALTER TABLE `cognos_pflege` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_pflege` ENABLE KEYS */;


--
-- Definition of table `cognos_station`
--

DROP TABLE IF EXISTS `cognos_station`;
CREATE TABLE `cognos_station` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumStat1` double DEFAULT NULL,
  `kumStat3` double DEFAULT NULL,
  `kumStat9` double DEFAULT NULL,
  `kumStat18` double DEFAULT NULL,
  `kumStat40` double DEFAULT NULL,
  `MonatStat1` double DEFAULT NULL,
  `MonatStat3` double DEFAULT NULL,
  `MonatStat9` double DEFAULT NULL,
  `MonatStat18` double DEFAULT NULL,
  `MonatStat40` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_station`
--

/*!40000 ALTER TABLE `cognos_station` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_station` ENABLE KEYS */;


--
-- Definition of table `cognos_uch`
--

DROP TABLE IF EXISTS `cognos_uch`;
CREATE TABLE `cognos_uch` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumUCH` double DEFAULT NULL,
  `kumPflegeBereich` double DEFAULT NULL,
  `kumOP` double DEFAULT NULL,
  `MonatUCH` double DEFAULT NULL,
  `MonatPflegeBereich` double DEFAULT NULL,
  `MonatOP` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_uch`
--

/*!40000 ALTER TABLE `cognos_uch` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_uch` ENABLE KEYS */;


--
-- Definition of table `cognos_wsch`
--

DROP TABLE IF EXISTS `cognos_wsch`;
CREATE TABLE `cognos_wsch` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) NOT NULL,
  `kumWSCH` double DEFAULT NULL,
  `kumOP` double DEFAULT NULL,
  `MonatWSCH` double DEFAULT NULL,
  `MonatOP` double DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cognos_wsch`
--

/*!40000 ALTER TABLE `cognos_wsch` DISABLE KEYS */;
/*!40000 ALTER TABLE `cognos_wsch` ENABLE KEYS */;


--
-- Definition of table `ppr_einstufung`
--

DROP TABLE IF EXISTS `ppr_einstufung`;
CREATE TABLE `ppr_einstufung` (
  `Fachrichtung` varchar(45) NOT NULL,
  `Station` varchar(45) NOT NULL,
  `A1_S1` int(10) unsigned NOT NULL,
  `A1_S2` int(10) unsigned NOT NULL,
  `A1_S3` int(10) unsigned NOT NULL,
  `A2_S1` int(10) unsigned NOT NULL,
  `A2_S2` int(10) unsigned NOT NULL,
  `A2_S3` int(10) unsigned NOT NULL,
  `A3_S1` int(10) unsigned NOT NULL,
  `A3_S2` int(10) unsigned NOT NULL,
  `A3_S3` int(10) unsigned NOT NULL,
  `Neugeborene` int(10) unsigned NOT NULL,
  `Aufnahmen` int(10) unsigned NOT NULL,
  `Falltage` int(10) unsigned NOT NULL,
  `ohne_Einstufung` int(10) unsigned NOT NULL,
  `Urlaub` int(10) unsigned NOT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`Fachrichtung`,`Station`,`Datum`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ppr_einstufung`
--

/*!40000 ALTER TABLE `ppr_einstufung` DISABLE KEYS */;
INSERT INTO `ppr_einstufung` (`Fachrichtung`,`Station`,`A1_S1`,`A1_S2`,`A1_S3`,`A2_S1`,`A2_S2`,`A2_S3`,`A3_S1`,`A3_S2`,`A3_S3`,`Neugeborene`,`Aufnahmen`,`Falltage`,`ohne_Einstufung`,`Urlaub`,`Datum`) VALUES 
 ('GCH','1',83,60,0,20,167,11,2,4,1,0,163,349,1,0,'2009-10-01'),
 ('GCH','11',1,3,0,1,10,0,0,1,0,0,4,16,0,0,'2009-10-01'),
 ('GCH','18',507,441,0,151,738,49,10,379,15,0,382,2293,3,0,'2009-10-01'),
 ('GCH','2',1072,897,1,210,2217,66,19,373,97,0,848,4969,17,0,'2009-10-01'),
 ('GCH','3',0,0,0,0,0,0,0,1,0,0,0,1,0,0,'2009-10-01'),
 ('GCH','40',3,0,0,4,8,0,0,4,0,0,6,19,0,0,'2009-10-01'),
 ('GCH','41',0,0,0,0,14,0,0,9,0,0,0,23,0,0,'2009-10-01');
/*!40000 ALTER TABLE `ppr_einstufung` ENABLE KEYS */;


--
-- Definition of table `ppr_wert`
--

DROP TABLE IF EXISTS `ppr_wert`;
CREATE TABLE `ppr_wert` (
  `Fachrichtung` varchar(45) NOT NULL,
  `Station` varchar(45) NOT NULL,
  `Fallwert` int(10) unsigned NOT NULL,
  `Grundwert` int(10) unsigned NOT NULL,
  `Minuten` int(10) unsigned NOT NULL,
  `Tage` int(10) unsigned NOT NULL,
  `Neugeborene` int(10) unsigned NOT NULL,
  `Mittelwert` int(10) unsigned NOT NULL,
  `Summe` int(10) unsigned NOT NULL,
  `Summe_mit_Ausgleich` int(10) unsigned NOT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`Fachrichtung`,`Station`,`Datum`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ppr_wert`
--

/*!40000 ALTER TABLE `ppr_wert` DISABLE KEYS */;
INSERT INTO `ppr_wert` (`Fachrichtung`,`Station`,`Fallwert`,`Grundwert`,`Minuten`,`Tage`,`Neugeborene`,`Mittelwert`,`Summe`,`Summe_mit_Ausgleich`,`Datum`) VALUES 
 ('GCH','1',11410,10455,30781,348,0,88,52646,52734,'2009-10-01'),
 ('GCH','11',280,480,1605,16,0,100,2365,2365,'2009-10-01'),
 ('GCH','18',26740,68760,231299,2290,0,101,326799,327102,'2009-10-01'),
 ('GCH','2',59360,148950,474701,4952,0,95,683011,684626,'2009-10-01'),
 ('GCH','3',0,30,189,1,0,189,219,219,'2009-10-01'),
 ('GCH','40',420,570,2168,19,0,114,3158,3158,'2009-10-01'),
 ('GCH','41',0,690,3213,23,0,139,3903,3903,'2009-10-01');
/*!40000 ALTER TABLE `ppr_wert` ENABLE KEYS */;


--
-- Definition of table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Vorname` varchar(45) DEFAULT NULL,
  `PLZ` varchar(45) DEFAULT NULL,
  `ORT` varchar(45) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`ID`,`Name`,`Vorname`,`PLZ`,`ORT`,`Datum`) VALUES 
 (1,'Brandes','Tim','48149','Münster','2009-10-01'),
 (2,'Czigalla','Sebastian','48150','Münster','2009-10-01'),
 (3,'Deukers','Frank','48151','Münster','2009-10-01'),
 (4,'Elland','Hans','48153','Münster','2009-10-01');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;


--
-- Definition of table `zop`
--

DROP TABLE IF EXISTS `zop`;
CREATE TABLE `zop` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Fallnummer` int(10) unsigned NOT NULL,
  `Fallstatus` varchar(45) NOT NULL,
  `OP_Datum` datetime NOT NULL,
  `FA_Kurz` varchar(45) DEFAULT NULL,
  `FA_Lang` varchar(45) DEFAULT NULL,
  `SN` int(10) unsigned DEFAULT NULL,
  `RZ` int(10) unsigned DEFAULT NULL,
  `KSTNR` int(10) unsigned DEFAULT NULL,
  `KSTBezeichnung` varchar(45) DEFAULT NULL,
  `Datum` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `zop`
--

/*!40000 ALTER TABLE `zop` DISABLE KEYS */;
/*!40000 ALTER TABLE `zop` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
