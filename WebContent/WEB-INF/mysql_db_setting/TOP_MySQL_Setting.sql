-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.7.14-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- mshop 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `mshop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mshop`;


-- 테이블 mshop.admin_notice 구조 내보내기
CREATE TABLE IF NOT EXISTS `admin_notice` (
  `BOARD_NUM` int(11) NOT NULL,
  `BOARD_NAME` varchar(20) DEFAULT NULL,
  `BOARD_PASS` varchar(15) DEFAULT NULL,
  `BOARD_SUBJECT` varchar(50) DEFAULT NULL,
  `BOARD_CONTENT` varchar(2000) DEFAULT NULL,
  `BOARD_RE_REF` int(11) DEFAULT NULL,
  `BOARD_RE_LEV` int(11) DEFAULT NULL,
  `BOARD_RE_SEQ` int(11) DEFAULT NULL,
  `BOARD_READCOUNT` int(11) DEFAULT NULL,
  `BOARD_DATE` date DEFAULT NULL,
  PRIMARY KEY (`BOARD_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mshop.buyer_qna 구조 내보내기
CREATE TABLE IF NOT EXISTS `buyer_qna` (
  `BOARD_NUM` int(11) NOT NULL,
  `BOARD_NAME` varchar(20) DEFAULT NULL,
  `BOARD_PASS` varchar(15) DEFAULT NULL,
  `BOARD_SUBJECT` varchar(50) DEFAULT NULL,
  `BOARD_CONTENT` varchar(2000) DEFAULT NULL,
  `BOARD_RE_REF` int(11) DEFAULT NULL,
  `BOARD_RE_LEV` int(11) DEFAULT NULL,
  `BOARD_RE_SEQ` int(11) DEFAULT NULL,
  `BOARD_READCOUNT` int(11) DEFAULT NULL,
  `BOARD_DATE` date DEFAULT NULL,
  PRIMARY KEY (`BOARD_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mshop.seller_notice 구조 내보내기
CREATE TABLE IF NOT EXISTS `seller_notice` (
  `BOARD_NUM` int(11) NOT NULL,
  `BOARD_NAME` varchar(20) DEFAULT NULL,
  `BOARD_PASS` varchar(15) DEFAULT NULL,
  `BOARD_SUBJECT` varchar(50) DEFAULT NULL,
  `BOARD_CONTENT` varchar(2000) DEFAULT NULL,
  `BOARD_RE_REF` int(11) DEFAULT NULL,
  `BOARD_RE_LEV` int(11) DEFAULT NULL,
  `BOARD_RE_SEQ` int(11) DEFAULT NULL,
  `BOARD_READCOUNT` int(11) DEFAULT NULL,
  `BOARD_DATE` date DEFAULT NULL,
  PRIMARY KEY (`BOARD_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mshop.top_bucket 구조 내보내기
CREATE TABLE IF NOT EXISTS `top_bucket` (
  `B_CODE` varchar(20) NOT NULL,
  `P_CODE` varchar(20) NOT NULL,
  `P_NAME` varchar(20) NOT NULL,
  `P_PRICE` varchar(20) NOT NULL,
  `M_ID` varchar(20) NOT NULL,
  PRIMARY KEY (`B_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mshop.top_member 구조 내보내기
CREATE TABLE IF NOT EXISTS `top_member` (
  `M_ID` varchar(20) NOT NULL,
  `M_PW` varchar(20) NOT NULL,
  `M_NAME` varchar(20) NOT NULL,
  `M_LEVEL` int(11) NOT NULL,
  `M_ADDR` varchar(20) NOT NULL,
  `M_AGE` int(11) NOT NULL,
  `M_PHONE` varchar(20) NOT NULL,
  `M_EMAIL` varchar(20) NOT NULL,
  PRIMARY KEY (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mshop.top_order 구조 내보내기
CREATE TABLE IF NOT EXISTS `top_order` (
  `O_CODE` varchar(20) NOT NULL,
  `P_CODE` varchar(20) NOT NULL,
  `M_ID` varchar(20) NOT NULL,
  `O_DATE` date NOT NULL,
  `O_PRICE` int(11) NOT NULL,
  `O_QUANTITY` int(11) NOT NULL,
  `O_STATE` int(11) NOT NULL,
  `O_ADDR` varchar(20) NOT NULL,
  PRIMARY KEY (`O_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mshop.top_product 구조 내보내기
CREATE TABLE IF NOT EXISTS `top_product` (
  `P_CODE` varchar(20) NOT NULL,
  `P_CATE` varchar(20) NOT NULL,
  `P_NAME` varchar(20) NOT NULL,
  `P_PRICE` int(11) NOT NULL,
  `P_COUNT` int(11) NOT NULL,
  `P_DATE` date NOT NULL,
  `P_DETAIL` varchar(500) NOT NULL,
  `M_ID` varchar(20) NOT NULL,
  PRIMARY KEY (`P_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
