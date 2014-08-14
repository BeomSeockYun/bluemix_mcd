-- --------------------------------------------------------
-- 호스트:                          10.240.135.199
-- 서버 버전:                        5.6.19 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 mcd의 구조를 덤프합니다. analytics
CREATE TABLE IF NOT EXISTS `analytics` (
  `idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '인덱스',
  `event_info` varchar(45) DEFAULT NULL COMMENT '이벤트 정보',
  `attendance_count` int(11) DEFAULT NULL COMMENT '참석인원수',
  `attendance_group` int(11) DEFAULT NULL COMMENT '참석연령대',
  `start_schedule` datetime DEFAULT NULL COMMENT '시작일시',
  `end_schecule` datetime DEFAULT NULL COMMENT '종료일시',
  `location` varchar(45) DEFAULT NULL COMMENT '이벤트장소',
  `distance` varchar(45) DEFAULT NULL COMMENT '매장과의거리',
  `alert_time` datetime DEFAULT NULL COMMENT '알람일시',
  `alert_confirm` tinyint(4) DEFAULT NULL COMMENT '알람착신컨펌',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='분석데이터 (소셜이벤트와 예측값)';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. bom
CREATE TABLE IF NOT EXISTS `bom` (
  `idx` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '인덱스',
  `product_id` varchar(50) NOT NULL COMMENT '상품아이디',
  `item_id` varchar(50) NOT NULL COMMENT '아이템아이디',
  `assembly_order` int(3) unsigned zerofill DEFAULT NULL COMMENT '조립순서',
  `value_of_need` varchar(50) DEFAULT NULL COMMENT '투입량',
  `unit` varchar(50) DEFAULT NULL COMMENT '단위',
  `description` text COMMENT '상세설명',
  PRIMARY KEY (`idx`),
  UNIQUE KEY `idx_UNIQUE` (`idx`),
  KEY `fk_bom_item1_idx1` (`item_id`),
  KEY `fk_bom_product1_idx1` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Bill of Material -( item - 필요한 양)';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. category_info
CREATE TABLE IF NOT EXISTS `category_info` (
  `category_id` varchar(10) NOT NULL COMMENT '카테고리 ID',
  `category_name` varchar(45) DEFAULT NULL COMMENT '카테고리 명',
  `parent_category_id` varchar(10) DEFAULT NULL COMMENT '부모 카테고리 ID',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='카테고리 관련 테이블';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. dashboard
CREATE TABLE IF NOT EXISTS `dashboard` (
  `idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '인덱스',
  `group_id` varchar(50) DEFAULT NULL COMMENT '그룹아이디',
  `product_id` varchar(50) DEFAULT NULL COMMENT '상품아이디',
  `product_name` varchar(50) DEFAULT NULL COMMENT '상품명',
  `product_count` int(11) DEFAULT NULL COMMENT '상품판매개수',
  `product_price` int(11) DEFAULT NULL COMMENT '상품매출액',
  `product_total_price` int(11) DEFAULT NULL COMMENT '상품매출총합계',
  `sales_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '매출집계일시',
  PRIMARY KEY (`idx`),
  KEY `fk_dash_group_id_idx` (`group_id`),
  KEY `fk_dash_product_id_idx` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='대쉬보드 -상품판매실적';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. forecast
CREATE TABLE IF NOT EXISTS `forecast` (
  `idx` int(11) NOT NULL COMMENT '인덱스',
  `event_info` varchar(45) DEFAULT NULL COMMENT '이벤트정보',
  `period_time` timestamp NULL DEFAULT NULL COMMENT '예측일시',
  `traffic_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '미사용',
  `customer_cnt` int(11) DEFAULT NULL COMMENT '예상방문고객수',
  `bigmac_cnt` int(11) DEFAULT NULL COMMENT '예상빅맥 판매수량',
  `beverage_cnt` int(11) DEFAULT NULL COMMENT '예상음료수 판매수량',
  `frenchfry_cnt` int(11) DEFAULT NULL COMMENT '예상 프랜치프라이 판매수량',
  `total_kitchen_crew` int(11) DEFAULT NULL COMMENT '총 예상 제조 투입인원수',
  `total_serving_crew` int(11) DEFAULT NULL COMMENT '총 예상 서빙 투입인원수',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='예측데이터';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. group
CREATE TABLE IF NOT EXISTS `group` (
  `idx` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '인덱스',
  `group_id` varchar(50) NOT NULL COMMENT '매장(회사) ID',
  `group_name` varchar(100) DEFAULT NULL COMMENT '매장(회사) 명',
  `group_desc` text COMMENT '상세 설명',
  `address` varchar(128) DEFAULT NULL COMMENT '매장 의 주소',
  `group_tel_nr` varchar(50) DEFAULT NULL COMMENT '매장 전화번호',
  `email` varchar(50) DEFAULT NULL COMMENT '매장 대표 이메일',
  `anniversary_day` date DEFAULT NULL COMMENT '매장 설립(개설)일',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '최소 입력 일시',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '업데이트 일시',
  `is_active` tinyint(4) DEFAULT NULL COMMENT '매장의 active 여부(개점/폐점)',
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `idx_UNIQUE` (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='그룹(매장)';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. group_product_mapping
CREATE TABLE IF NOT EXISTS `group_product_mapping` (
  `group_id` varchar(50) NOT NULL COMMENT '그룹아이디',
  `product_id` varchar(50) NOT NULL COMMENT '상품아이디',
  KEY `fk_group_product_mapping_product1_idx` (`product_id`),
  KEY `fk_group_product_mapping_group1_idx` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='그룹-상품-매핑';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. group_user_mapping
CREATE TABLE IF NOT EXISTS `group_user_mapping` (
  `group_id` varchar(50) NOT NULL COMMENT '그룹아이디',
  `user_id` varchar(50) NOT NULL COMMENT '사용자아이디',
  KEY `fk_group_user_mapping_group1_idx` (`group_id`),
  KEY `fk_group_user_mapping_user1_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='그룹-사용자-매핑';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. happiness_report
CREATE TABLE IF NOT EXISTS `happiness_report` (
  `idx` int(11) NOT NULL AUTO_INCREMENT COMMENT '인덱스',
  `group_id` varchar(50) DEFAULT NULL COMMENT '그룹아이디',
  `happiness` tinyint(1) DEFAULT NULL COMMENT '만족여부(0: 불만족, 1:만족)',
  `product_idx` int(10) unsigned DEFAULT NULL COMMENT '상품인덱스',
  `date` timestamp NULL DEFAULT NULL COMMENT '조사일시',
  PRIMARY KEY (`idx`),
  KEY `product_idx` (`product_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='만족도리포트';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. item
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` varchar(50) NOT NULL COMMENT '아이템아이디',
  `has_child` tinyint(1) DEFAULT NULL COMMENT '0- 단품, 1- 여러 아이템 조합',
  `parent_item_id` varchar(50) DEFAULT NULL COMMENT 'item이 여러 item의 조합일 경우',
  `item_name` varchar(100) DEFAULT NULL COMMENT '아이템명',
  `value_of_item` int(11) DEFAULT NULL COMMENT '아이템 양/개수(낱개 값 빵1개, 양파 3g)',
  `category` varchar(100) DEFAULT NULL COMMENT '카테고리',
  `value_of_stock` int(11) DEFAULT NULL COMMENT '적재량/개수',
  `stock_unit` varchar(50) DEFAULT NULL COMMENT '적재단위(박스, 버킷..)',
  `item_unit` varchar(50) DEFAULT NULL COMMENT '아이템단위(g, ml, cc)',
  `capacity_unit` varchar(50) DEFAULT NULL COMMENT '적재용량단위(Kg, Liter)',
  `number_of_stock_unit` int(11) DEFAULT NULL COMMENT '적재단위의 아이템낱개 환산값(1박스=100개들이, 1Kg=1000g)',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='창고에 있는 아이템현황정보 (적재단위와 아이템낱개단위를 함께 표시)';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. preludebuser
CREATE TABLE IF NOT EXISTS `preludebuser` (
  `user_id` varchar(50) DEFAULT NULL COMMENT 'user Id',
  `password` varchar(256) DEFAULT NULL COMMENT 'password',
  `is_account_non_expired` tinyint(1) DEFAULT NULL COMMENT '계정유효여부 1 - OK, 0 - account expired',
  `is_account_non_locked` tinyint(1) DEFAULT NULL COMMENT '계정열림여부 1 - OK, 0 - account locked',
  `is_credentials_non_expired` tinyint(1) DEFAULT NULL COMMENT '암호유효여부 1 - OK, 0 - token expired',
  `is_enabled` tinyint(1) DEFAULT NULL COMMENT '계정사용여부 1 - OK, 0- account off',
  `unlock_try` int(1) DEFAULT NULL COMMENT '암호입력 재시도 3 retry - disable account',
  `locked_date` timestamp NULL DEFAULT NULL COMMENT '계정잠김 날짜',
  `account_expire_date` timestamp NULL DEFAULT NULL COMMENT '계정유효기간',
  `cedentials_expire_date` timestamp NULL DEFAULT NULL COMMENT '암호유효기간',
  `disabled_date` timestamp NULL DEFAULT NULL COMMENT '계정 비활성 날짜'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='spring security 용 계정';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. product
CREATE TABLE IF NOT EXISTS `product` (
  `idx` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '인덱스',
  `product_id` varchar(50) NOT NULL COMMENT '상품 아이디',
  `product_name` varchar(100) NOT NULL COMMENT '상품명',
  `category_id` varchar(50) DEFAULT NULL COMMENT '카테고리 아이디',
  `pirce` decimal(10,2) DEFAULT NULL COMMENT '가격',
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `idx_UNIQUE` (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='상품';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. set_product_mapping
CREATE TABLE IF NOT EXISTS `set_product_mapping` (
  `set_product_id` varchar(50) NOT NULL COMMENT '세트상품아이디',
  `product_id` varchar(50) NOT NULL COMMENT 'product_id (상품 ID)',
  `group_id` varchar(50) DEFAULT NULL COMMENT 'group_id (매장)',
  `set_product_name` varchar(50) DEFAULT NULL COMMENT '세트 상품 명',
  PRIMARY KEY (`set_product_id`),
  KEY `fk_set_proc_id_idx` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='세트 메뉴 구성정보';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. stock_action_history
CREATE TABLE IF NOT EXISTS `stock_action_history` (
  `sn` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '인덱스',
  `item_id` varchar(50) NOT NULL COMMENT '아이템(재료) 아이디',
  `group_id` varchar(50) DEFAULT NULL COMMENT '그룹아이디',
  `action` int(1) DEFAULT NULL COMMENT '액션 1-add , 2-remove, 3-반영완료',
  `value_of_stock` int(11) unsigned DEFAULT NULL COMMENT '주문(삭제) 수량',
  `unit` int(11) DEFAULT NULL COMMENT '단위',
  `op_date` timestamp NULL DEFAULT NULL COMMENT '주문(삭제) 일시',
  PRIMARY KEY (`sn`),
  UNIQUE KEY `sn_UNIQUE` (`sn`),
  KEY `fk_item_idx` (`item_id`),
  KEY `fk_group_id_idx` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='재고-액션-이력';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. stock_inventory
CREATE TABLE IF NOT EXISTS `stock_inventory` (
  `item_id` varchar(50) NOT NULL COMMENT '아이템 ID',
  `group_id` varchar(50) NOT NULL COMMENT 'group id(매장)',
  `current_level` int(11) NOT NULL COMMENT '현재 보유 수량',
  `minimum_level` int(11) NOT NULL COMMENT '최소 보유 수량',
  `alarm_level` int(11) NOT NULL COMMENT '경고 수량',
  `recommended_level` int(11) NOT NULL COMMENT '추천 보유 수량',
  `category_id` varchar(10) DEFAULT NULL COMMENT '카테고리 아이디',
  `update_datetime` timestamp NULL DEFAULT NULL COMMENT '업데이트 일시',
  `insert_datetime` timestamp NULL DEFAULT NULL COMMENT '최초 입력일',
  PRIMARY KEY (`item_id`,`group_id`),
  KEY `gup_idx` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='재고현황';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. to_do_list
CREATE TABLE IF NOT EXISTS `to_do_list` (
  `idx` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '인덱스',
  `to_do_id` varchar(50) NOT NULL COMMENT 'to do list id',
  `owner_id` varchar(100) DEFAULT NULL COMMENT 'owner id',
  `is_checked` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '체크여부 0 - No, 1- Checked',
  `is_canceled` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '캔슬여부 0 - false, 1- true (event trigger) ',
  `is_modified` tinyint(1) unsigned zerofill DEFAULT '0' COMMENT '수정여부 0 - false, 1- true (event trigger) set 0 after sending msg',
  `is_new` tinyint(1) unsigned zerofill DEFAULT '1' COMMENT '신규여부 0 - false, 1- true ( event trigger)',
  `title` varchar(100) DEFAULT NULL COMMENT '타이틀',
  `category` varchar(100) DEFAULT NULL COMMENT '카테고리',
  `detail` text COMMENT '상세설명',
  `comment` text COMMENT '코멘트',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '생성일시',
  `created_by` varchar(100) DEFAULT NULL COMMENT '생성자',
  `remind_date` timestamp NULL DEFAULT NULL COMMENT '리마인드알람일시',
  `start_date` timestamp NULL DEFAULT NULL COMMENT '스케줄 시작일시',
  `end_date` timestamp NULL DEFAULT NULL COMMENT '스케줄 종료일시',
  `checked_date` timestamp NULL DEFAULT NULL COMMENT '완료체크일시',
  `priority` int(1) unsigned zerofill DEFAULT '4' COMMENT '1-critical, 2-high 3-medium, 4-low',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='체크리스트';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(50) NOT NULL COMMENT '사용자아이디',
  `user_name` varchar(100) DEFAULT NULL COMMENT '사용자명',
  `cellphone_nr` varchar(50) DEFAULT NULL COMMENT '핸드폰번호',
  `push_register_key` text COMMENT 'GCMPush-registration Id',
  `email` varchar(50) DEFAULT NULL COMMENT '이메일주소',
  `birth_day` date DEFAULT NULL COMMENT '생일',
  `anniversary_day` date DEFAULT NULL COMMENT '입사일',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '생성일시',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사용자';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `idx` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '인덱스',
  `role_id` varchar(50) NOT NULL COMMENT '역할아이디',
  `role_name` varchar(50) DEFAULT NULL COMMENT '역할명',
  `category` varchar(50) DEFAULT NULL COMMENT '카테고리',
  `description` text COMMENT '상세설명',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `idx_UNIQUE` (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사용자역할';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. user_role_mapping
CREATE TABLE IF NOT EXISTS `user_role_mapping` (
  `user_id` varchar(50) NOT NULL COMMENT '사용자아이디',
  `role_id` varchar(50) NOT NULL COMMENT '역할아이디',
  KEY `fk_user_role_mapping_user1_idx` (`user_id`),
  KEY `fk_user_role_mapping_user_role1_idx` (`role_id`),
  CONSTRAINT `fk_user_role_mapping_user_role1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='사용자-역할-매핑';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. visitor_history
CREATE TABLE IF NOT EXISTS `visitor_history` (
  `idx` int(11) NOT NULL COMMENT '인덱스',
  `period_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '측정일시',
  `customer_cnt` int(11) NOT NULL COMMENT '방문고객수',
  `bigmac_cnt_past` int(11) DEFAULT NULL COMMENT '빅맥판매수',
  `beverage_cnt_past` int(11) DEFAULT NULL COMMENT '음료수판매수',
  `frenchfry_cnt_past` int(11) DEFAULT NULL COMMENT '프랜치프라이판매수',
  `total_kitchen_crew_past` int(11) DEFAULT NULL COMMENT '총 생산투입인력수',
  `total_serving_crew_past` int(11) DEFAULT NULL COMMENT '총 서빙투입인력수',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='방문자수-상품판매수-직원수 이력';

-- 내보낼 데이터가 선택되어 있지 않습니다.


-- 테이블 mcd의 구조를 덤프합니다. visitor_today
CREATE TABLE IF NOT EXISTS `visitor_today` (
  `idx` int(11) NOT NULL COMMENT '인덱스',
  `period_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '측정일시',
  `customer_cnt` int(11) NOT NULL COMMENT '방문고객수',
  `bigmac_cnt_real` int(11) NOT NULL COMMENT '빅맥판매수',
  `beverage_cnt_real` int(11) NOT NULL COMMENT '음료수판매수',
  `frenchfry_cnt_real` int(11) NOT NULL COMMENT '프랜치파이판매수',
  `total_kitchen_crew_real` int(11) NOT NULL COMMENT '총 생산투입인력수',
  `total_serving_crew_real` int(11) NOT NULL COMMENT '총 서빙투입인력수',
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='방문자수-상품판매수-직원수 현황';

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
