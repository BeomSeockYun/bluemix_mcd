CREATE TABLE IF NOT EXISTS `batch_raw_report` (
  `date` text,
  `impressions` text,
  `clicks` text,
  `earning` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='배치 샘플 테스트';


CREATE TABLE IF NOT EXISTS `batch_tb_cm_mbr` (
  `mbr_id` varchar(100) DEFAULT NULL,
  `mbr_nm` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='배치샘플테스트';

-- Dumping data for table mcd.batch_tb_cm_mbr: ~128 rows (대략적)
/*!40000 ALTER TABLE `batch_tb_cm_mbr` DISABLE KEYS */;
INSERT INTO `batch_tb_cm_mbr` (`mbr_id`, `mbr_nm`) VALUES
	('2', 'b'),
	('1', 'a');
	