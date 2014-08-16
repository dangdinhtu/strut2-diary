-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 16, 2014 at 05:52 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `diary`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) CHARACTER SET utf8 NOT NULL,
  `DESCRIPT` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `ACTIVE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `diary_book`
--

CREATE TABLE IF NOT EXISTS `diary_book` (
  `DBK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) CHARACTER SET utf8 NOT NULL,
  `DATE_CREATE` date NOT NULL,
  `COVER_PHOTO` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BACKGROUND-IMAGES` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BACKGROUND_AUDIO` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `AUDIO_AUTOPLAY` bit(1) DEFAULT NULL,
  `CATEGORY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DBK_ID`),
  KEY `RefCATEGORY155` (`CATEGORY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `diary_book_content`
--

CREATE TABLE IF NOT EXISTS `diary_book_content` (
  `DBC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `CONTENT` text COLLATE utf8_unicode_ci,
  `DATE_WRITTEN` date DEFAULT NULL,
  `PAGE` int(11) DEFAULT NULL,
  `DBK_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DBC_ID`),
  KEY `RefDIARY_BOOK156` (`DBK_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `divination`
--

CREATE TABLE IF NOT EXISTS `divination` (
  `DIVINATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `DESCRIPT` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `DCY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DIVINATION_ID`),
  KEY `RefDIVINATION_CATEGORY187` (`DCY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `divination_category`
--

CREATE TABLE IF NOT EXISTS `divination_category` (
  `DCY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET utf8 NOT NULL,
  `DESCRIPT` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`DCY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `divination_fast`
--

CREATE TABLE IF NOT EXISTS `divination_fast` (
  `DFN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPT` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `NAME` text COLLATE utf8_unicode_ci NOT NULL,
  `DIVINATION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DFN_ID`),
  KEY `RefDIVINATION189` (`DIVINATION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `divination_long`
--

CREATE TABLE IF NOT EXISTS `divination_long` (
  `DLG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IMAGES` char(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NAME` text COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPT` varchar(500) CHARACTER SET utf8 DEFAULT NULL,
  `DIVINATION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DLG_ID`),
  KEY `RefDIVINATION181` (`DIVINATION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `divination_long_contents`
--

CREATE TABLE IF NOT EXISTS `divination_long_contents` (
  `DLC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUESTION` text COLLATE utf8_unicode_ci NOT NULL,
  `A` text COLLATE utf8_unicode_ci NOT NULL,
  `B` text COLLATE utf8_unicode_ci NOT NULL,
  `D` text COLLATE utf8_unicode_ci NOT NULL,
  `C` text COLLATE utf8_unicode_ci NOT NULL,
  `MARK_A` int(11) DEFAULT NULL,
  `MARK_B` int(11) DEFAULT NULL,
  `MARK_C` int(11) DEFAULT NULL,
  `MARK_D` int(11) DEFAULT NULL,
  `DLG_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DLC_ID`),
  KEY `RefDIVINATION_LONG186` (`DLG_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `function`
--

CREATE TABLE IF NOT EXISTS `function` (
  `RESOURCE_ID` int(11) NOT NULL,
  `NAME` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `NOTE` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `STATUS` bit(1) DEFAULT b'1',
  PRIMARY KEY (`RESOURCE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `funny_images`
--

CREATE TABLE IF NOT EXISTS `funny_images` (
  `FIS_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`FIS_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE IF NOT EXISTS `permission` (
  `PERM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `DESCRIPT` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `STATUS` bit(1) DEFAULT b'1',
  PRIMARY KEY (`PERM_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `remind`
--

CREATE TABLE IF NOT EXISTS `remind` (
  `REMIND_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `CONTENT` text COLLATE utf8_unicode_ci NOT NULL,
  `CALENDAR_REMINDER` date DEFAULT NULL,
  `STATUS` bit(1) DEFAULT NULL,
  PRIMARY KEY (`REMIND_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `resource`
--

CREATE TABLE IF NOT EXISTS `resource` (
  `RESOURCE_KEY` char(100) COLLATE utf8_unicode_ci NOT NULL,
  `RESOURCE_VALUE` text COLLATE utf8_unicode_ci,
  `DESCRIPT` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`RESOURCE_KEY`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `results_divination_couples`
--

CREATE TABLE IF NOT EXISTS `results_divination_couples` (
  `RDC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SCORE_MIN` int(11) DEFAULT NULL,
  `SCORE_MAX` int(11) DEFAULT NULL,
  `COUPLES_ZODIAC` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `RESULT_CONTENT` text COLLATE utf8_unicode_ci NOT NULL,
  `DIVINATION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RDC_ID`),
  KEY `RefDIVINATION188` (`DIVINATION_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `results_divination_fast`
--

CREATE TABLE IF NOT EXISTS `results_divination_fast` (
  `RDF_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IMAGES` char(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ANSWER` text COLLATE utf8_unicode_ci NOT NULL,
  `RESULT` text COLLATE utf8_unicode_ci NOT NULL,
  `DFN_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RDF_ID`),
  KEY `RefDIVINATION_FAST185` (`DFN_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `results_divination_long`
--

CREATE TABLE IF NOT EXISTS `results_divination_long` (
  `RDL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SCORE_MAX` int(11) NOT NULL,
  `SCORE_MIN` int(11) NOT NULL,
  `RESULTS` text COLLATE utf8_unicode_ci NOT NULL,
  `DLG_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RDL_ID`),
  KEY `RefDIVINATION_LONG190` (`DLG_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `DESCRIPT` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  `STATUS` bit(1) DEFAULT b'1',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `role_perm`
--

CREATE TABLE IF NOT EXISTS `role_perm` (
  `RPM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PERM_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  `RESOURCE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RPM_ID`),
  KEY `RefFUNCTION191` (`RESOURCE_ID`),
  KEY `RefROLE106` (`ROLE_ID`),
  KEY `RefPERMISSION108` (`PERM_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `USERNAME` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `AVARTAR` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `PHONE` char(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMAIL` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GENDER` bit(1) DEFAULT NULL,
  `PASSWORD` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ACTIVE` bit(1) DEFAULT b'1',
  PRIMARY KEY (`USER_ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=108 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`USER_ID`, `NAME`, `USERNAME`, `BIRTHDAY`, `AVARTAR`, `ADDRESS`, `PHONE`, `EMAIL`, `GENDER`, `PASSWORD`, `ACTIVE`) VALUES
(1, 'Dang Tu', 'admin', '2014-08-04', 'hoa.jpg', 'HY', '1111', 'dangdinhtu@gmail.com', '1', '123456', '1'),
(2, 'Le Trang', 'admin', '2014-08-04', NULL, 'Ha Noi', '1111', 'dangdinhtu@gmail.com', '1', '123456', '1'),
(3, 'aâ', 'aâ', '2014-08-12', NULL, 'aâ', 'â', 'â', '0', 'aâ', '0'),
(4, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(5, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(6, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(7, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(8, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(9, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(10, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(11, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(12, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(13, 'qq', 'aa', '2014-08-12', NULL, 'aa', '', '', '0', 'aa', '0'),
(14, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(15, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(16, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(17, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(18, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(19, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(20, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(21, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(22, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(23, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(24, '111', '111', '2014-08-12', NULL, '1111', '', '', '0', '111', '0'),
(25, '222', '222', '2014-08-12', NULL, '', '', '', '0', '222', '0'),
(26, '222', '222', '2014-08-12', NULL, '', '', '', '0', '222', '0'),
(27, '222', '222', '2014-08-12', NULL, '', '', '', '0', '222', '0'),
(28, '222', '222', '2014-08-12', NULL, '', '', '', '0', '222', '0'),
(29, '33', '333', '2014-08-12', NULL, '', '', '', '0', '333', '0'),
(30, '44', '44', '2014-08-12', NULL, '', '', '', '0', '444', '0'),
(31, '44', '44', '2014-08-12', NULL, '', '', '', '0', '444', '0'),
(32, '44', '44', '2014-08-12', NULL, '', '', '', '0', '444', '0'),
(33, '555', '5555', '2014-08-12', NULL, '', '', '', '0', '', '0'),
(34, 'eee', 'ee', '2014-08-12', NULL, '', '', '', '0', 'ee', '0'),
(35, 'eee', 'ee', '2014-08-12', NULL, '', '', '', '0', 'ee', '0'),
(36, 'eee', 'ee', '2014-08-12', NULL, '', '', '', '0', 'ee', '0'),
(37, 'eee', 'ee', '2014-08-12', NULL, '', '', '', '0', 'ee', '0'),
(38, 'eee', 'ee', '2014-08-12', NULL, '', '', '', '0', 'ee', '0'),
(39, 'eee', 'ee', '2014-08-12', NULL, '', '', '', '0', 'ee', '0'),
(40, 'eee', 'ee', '2014-08-12', NULL, '', '', '', '0', 'ee', '0'),
(41, 'eee', 'ee', '2014-08-12', NULL, '', '', '', '0', 'ee', '0'),
(42, 'eee', 'ee', '2014-08-12', NULL, '', '', '', '0', 'ee', '0'),
(43, ' a', 'ddd', '2014-08-12', NULL, 'dd', '09999', 'ducdung@gmail.com', '0', '123', '0'),
(44, ' a', 'ddd', '2014-08-12', NULL, 'dd', '09999', 'ducdung@gmail.com', '0', '123', '0'),
(45, 'kaka', 'kaka', '2014-08-12', NULL, 'kaka', '099999', 'haingoai@gmail.com', '0', 'kaka', '0'),
(46, 'kaka', 'kaka', '2014-08-12', NULL, 'kaka', '099999', 'haingoai@gmail.com', '0', 'kaka', '0'),
(47, 'test', 'test', '2014-08-12', NULL, 'test', '888888', 'test@gmail.com', '0', 'test', '0'),
(48, 'test', 'test', '2014-08-12', NULL, 'test', '888888', 'test@gmail.com', '0', 'test', '0'),
(49, 'test', 'test', '2014-08-12', NULL, 'test', '888888', 'test@gmail.com', '0', 'test', '0'),
(50, 'test', 'test', '2014-08-12', NULL, 'test', '888888', 'test@gmail.com', '0', 'test', '0'),
(51, 'test', 'test', '2014-08-12', NULL, 'test', '888888', 'test@gmail.com', '0', 'test', '0'),
(52, 'test', 'test', '2014-08-12', NULL, 'test', '888888', 'test@gmail.com', '0', 'test', '0'),
(53, 'rrrr', 'rrrrr', '2014-08-12', NULL, 'rrrr', '555', 'test@gmail.com', '0', 'rrrr', '0'),
(54, 'rrrr', 'rrrrr', '2014-08-12', NULL, 'rrrr', '555', 'test@gmail.com', '0', 'rrrr', '0'),
(55, 'rrrr', 'rrrrr', '2014-08-12', NULL, 'rrrr', '555', 'test@gmail.com', '0', 'rrrr', '0'),
(56, 'rrrr', 'rrrrr', '2014-08-12', NULL, 'rrrr', '555', 'test@gmail.com', '0', 'rrrr', '0'),
(57, 'dfdf', 'fdfdf', '2014-08-12', NULL, 'ttttt', '44444', 'fff@gd.vom', '0', 'fdfdf', '0'),
(58, 'dfdf', 'fdfdf', '2014-08-12', NULL, 'ttttt', '44444', 'fff@gd.vom', '0', 'fdfdf', '0'),
(59, 'yyyy', 'yyyy', '2014-08-12', NULL, '', '', '', '0', 'yyyy', '0'),
(60, 'yyyy', 'yyyy', '2014-08-12', NULL, '', '', '', '0', 'yyyy', '0'),
(61, 'ooo', 'ooo', '2014-08-12', NULL, '', '', '', '0', 'ô', '0'),
(62, 'ppp', 'ppp', '2014-08-12', NULL, '', '', '', '0', 'pp', '0'),
(63, 'ppp', 'ppp', '2014-08-12', NULL, '', '', '', '0', 'pp', '0'),
(64, 'lll', 'll', '2014-08-12', NULL, '', '', '', '0', 'lll', '0'),
(65, 'lll', 'll', '2014-08-12', NULL, '', '', '', '0', 'lll', '0'),
(66, 'lll', 'll', '2014-08-12', NULL, '', '', '', '0', 'lll', '0'),
(67, 'lll', 'll', '2014-08-12', NULL, '', '', '', '0', 'lll', '0'),
(68, 'lll', 'll', '2014-08-12', NULL, '', '', '', '0', 'lll', '0'),
(69, 'mmm', 'mmm', '2014-08-12', NULL, '', '', '', '0', 'mmm', '0'),
(70, 'mmm', 'mmm', '2014-08-12', NULL, '', '', '', '0', 'mmm', '0'),
(71, 'mmm', 'mmm', '2014-08-12', NULL, '', '', '', '0', 'mmm', '0'),
(72, 'mmm', 'mmm', '2014-08-12', NULL, '', '', '', '0', 'mmm', '0'),
(73, 'mmm', 'mmm', '2014-08-12', NULL, '', '', '', '0', 'mmm', '0'),
(74, 'mmm', 'mmm', '2014-08-12', NULL, '', '', '', '0', 'mmm', '0'),
(75, 'mmm', 'mmm', '2014-08-12', NULL, '', '', '', '0', 'mmm', '0'),
(76, 'het', 'het', '2014-08-12', NULL, '', '', '', '0', 'het', '0'),
(77, 'het', 'het', '2014-08-12', NULL, '', '', '', '0', 'het', '0'),
(78, 'hhkk', 'hhkk', '2014-08-12', NULL, '', '', '', '0', 'hhkk', '0'),
(79, 'hhkk', 'hhkk', '2014-08-12', NULL, '', '', '', '0', 'hhkk', '0'),
(80, 'hhkk', 'hhkk', '2014-08-12', NULL, '', '', '', '0', 'hhkk', '0'),
(81, 'bb', 'bbb', '2014-08-12', NULL, '', '', '', '0', 'bbb', '0'),
(82, 'bb', 'bbb', '2014-08-12', NULL, '', '', '', '0', 'bbb', '0'),
(101, 'ok baby', 'ok baby', '2014-08-12', NULL, '', '', '', '0', '', '0'),
(103, 'are you ok123', 'are you ok11', '2014-08-12', NULL, 'are you ok', '', '', '0', '', '0');

-- --------------------------------------------------------

--
-- Table structure for table `user_diary_book`
--

CREATE TABLE IF NOT EXISTS `user_diary_book` (
  `UDB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATUS` bit(1) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `DBK_ID` int(11) DEFAULT NULL,
  `REMIND_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`UDB_ID`),
  KEY `RefUSER152` (`USER_ID`),
  KEY `RefDIARY_BOOK154` (`DBK_ID`),
  KEY `RefREMIND164` (`REMIND_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `ERE` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `ROLE_ID` int(11) DEFAULT NULL,
  `STATUS` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ERE`),
  KEY `RefUSER148` (`USER_ID`),
  KEY `RefROLE119` (`ROLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `zodiac`
--

CREATE TABLE IF NOT EXISTS `zodiac` (
  `ZODIAC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) CHARACTER SET utf8 NOT NULL,
  `DATE` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `IMAGES` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ZODIAC_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
