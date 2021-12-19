-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.3.27-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 spring5fs.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `REGDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 테이블 데이터 spring5fs.member:~6 rows (대략적) 내보내기
DELETE FROM `member`;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`ID`, `EMAIL`, `PASSWORD`, `NAME`, `REGDATE`) VALUES
	(1, 'dagh1218@naver.com', '0x1.8a9f2c9170e5p-5', 'jkh', '2021-09-04 17:13:21'),
	(2, '0905195214@test.com', '0905195214', '0905195214', '2021-09-05 19:52:14'),
	(3, '0905195459@test.com', '0905195459', '0905195459', '2021-09-05 19:54:59'),
	(4, '1114164102@test.com', '1114164102', '1114164102', '2021-11-14 16:41:02'),
	(5, '1114171613@test.com', '1114171613', '1114171613', '2021-11-14 17:16:13'),
	(6, '1206160814@test.com', '1206160814', '1206160814', '2021-12-06 16:08:14');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
