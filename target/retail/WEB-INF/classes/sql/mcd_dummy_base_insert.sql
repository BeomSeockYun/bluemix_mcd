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
-- Dumping data for table mcd.bom: ~23 rows (대략적)
/*!40000 ALTER TABLE `bom` DISABLE KEYS */;
INSERT INTO `bom` (`idx`, `product_id`, `item_id`, `assembly_order`, `value_of_need`, `unit`, `description`) VALUES
	(0000000001, '', '', 001, '1', 'count(s)', '아래쪽 빵을 놓는다'),
	(0000000002, '', '', 006, '4', 'count(s)', '토마토 슬라이스를 놓는다'),
	(0000000003, '', '', 004, '1', 'count(s)', '패티를 놓는다'),
	(0000000004, '', '', 003, '2', 'count(s)', '상추를 놓는다'),
	(0000000005, '', '', 005, '4', 'count(s)', '양파를 놓는다'),
	(0000000006, '', '', 010, '10', 'count(s)', '오이피클을 놓는다'),
	(0000000007, '', '', 002, '1', 'count(s)', '치즈를 놓는다'),
	(0000000008, '', '', 006, '10', 'g', '케쳡을 뿌린다'),
	(0000000009, '', '', 011, '1', 'count(s)', '위쪽빵을 놓는다'),
	(0000000010, '', '', 007, '1', 'count(s)', '가운데빵을 놓는다'),
	(0000000011, '', '', 001, '1', 'count(s)', '아래쪽 빵을 놓는다'),
	(0000000012, '', '', 006, '4', 'count(s)', '토마토 슬라이스를 놓는다'),
	(0000000013, '', '', 003, '1', 'count(s)', '패티를 놓는다'),
	(0000000014, '', '', 005, '4', 'count(s)', '상추를 놓는다'),
	(0000000015, '', '', 007, '4', 'count(s)', '양파를 놓는다'),
	(0000000016, '', '', 009, '10', 'count(s)', '오이피클을 놓는다'),
	(0000000017, '', '', 002, '1', 'count(s)', '치즈를 놓는다'),
	(0000000018, '', '', 008, '10', 'g', '케쳡을 뿌린다'),
	(0000000019, '', '', 010, '1', 'count(s)', '위쪽빵을 놓는다'),
	(0000000020, '', '', 001, '1', 'count(s)', '아래빵을 놓는다'),
	(0000000021, '', '', 009, '1', 'count(s)', '패티를 놓는다'),
	(0000000022, '', '', 008, '2', 'count(s)', '상추를 놓는다'),
	(0000000023, '', '', 004, '1', 'count(s)', '치즈를 놓는다');
/*!40000 ALTER TABLE `bom` ENABLE KEYS */;

-- Dumping data for table mcd.group: ~2 rows (대략적)
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` (`idx`, `group_id`, `group_name`, `group_desc`, `address`, `group_tel_nr`, `email`, `anniversary_day`, `create_time`, `update_time`, `is_active`) VALUES
	(0000000001, 'mcd_0001', 'McDonald (Chicago)', 'McDonald in Chicago ', NULL, NULL, NULL, NULL, NULL, NULL, 1),
	(0000000002, 'mcd_0002', 'McDonald (Seoul)', 'McDonald in Seoul', NULL, NULL, NULL, NULL, NULL, NULL, 1);
/*!40000 ALTER TABLE `group` ENABLE KEYS */;

-- Dumping data for table mcd.group_product_mapping: ~9 rows (대략적)
/*!40000 ALTER TABLE `group_product_mapping` DISABLE KEYS */;
INSERT INTO `group_product_mapping` (`group_id`, `product_id`) VALUES
	('mcd_0001', 'prod_mcd_0001'),
	('mcd_0001', 'prod_mcd_0002'),
	('mcd_0001', 'prod_mcd_0003'),
	('mcd_0001', 'prod_mcd_0004'),
	('mcd_0001', 'prod_mcd_0005'),
	('mcd_0001', 'prod_mcd_0006'),
	('mcd_0001', 'prod_mcd_0007'),
	('mcd_0001', 'prod_mcd_0008'),
	('mcd_0001', 'prod_mcd_0009');
/*!40000 ALTER TABLE `group_product_mapping` ENABLE KEYS */;

-- Dumping data for table mcd.group_user_mapping: ~5 rows (대략적)
/*!40000 ALTER TABLE `group_user_mapping` DISABLE KEYS */;
INSERT INTO `group_user_mapping` (`group_id`, `user_id`) VALUES
	('mcd_0001', 'alice@mcd.com'),
	('mcd_0001', 'bob@mcd.com'),
	('mcd_0001', 'manager@mcd.com'),
	('mcd_0001', 'storekeeper@mcd.com'),
	('', '');
/*!40000 ALTER TABLE `group_user_mapping` ENABLE KEYS */;

-- Dumping data for table mcd.item: ~16 rows (대략적)
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`item_id`, `has_child`, `parent_item_id`, `item_name`, `value_of_item`, `category`, `value_of_stock`, `stock_unit`, `item_unit`, `capacity_unit`, `number_of_stock_unit`) VALUES
	('item_00001', NULL, NULL, 'bottom_bun', 100, NULL, 1, 'box', 'count', NULL, 100),
	('item_00002', NULL, NULL, 'top_bun', 100, NULL, 1, 'box', 'count', NULL, 100),
	('item_00003', NULL, NULL, 'beef_patty', 100, NULL, 1, 'box', 'count', NULL, 100),
	('item_00004', NULL, NULL, 'tomato', 100, NULL, 1, 'box', 'count', NULL, 100),
	('item_00005', NULL, NULL, 'pickeles', 100, NULL, 1, 'box', 'g', NULL, 100),
	('item_00006', NULL, NULL, 'onion', 100, NULL, 1, 'box', 'g', NULL, 100),
	('item_00007', NULL, NULL, 'cheese', 1000, NULL, 5, 'box', 'count', NULL, 200),
	('item_00008', NULL, NULL, 'ketchup', 500, NULL, 1, 'box', 'g', 'ml', 500),
	('item_00009', NULL, NULL, 'lettuce', 100, NULL, 1, 'box', 'g', NULL, 100),
	('item_00010', NULL, NULL, 'Coke', 100, NULL, 1, 'box', 'count', NULL, 100),
	('item_00011', NULL, NULL, 'middle_bun', 100, NULL, 1, 'box', 'count', NULL, 100),
	('item_00012', NULL, NULL, 'Coke', 100, NULL, 1, 'box', 'count', NULL, 100),
	('item_00013', NULL, NULL, 'Sprite', 100, NULL, 1, 'box', 'count', NULL, 100),
	('item_00014', NULL, NULL, 'Soft Ice', 1000, NULL, 1, 'box', 'Kg', NULL, 1000),
	('item_00015', NULL, NULL, 'Oreo', 1000, NULL, 1, 'box', 'Kg', NULL, 1000),
	('item_00016', NULL, NULL, 'egg', 30, NULL, 1, 'box', 'count', NULL, 100);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;

-- Dumping data for table mcd.preludebuser: ~5 rows (대략적)
/*!40000 ALTER TABLE `preludebuser` DISABLE KEYS */;
INSERT INTO `preludebuser` (`user_id`, `password`, `is_account_non_expired`, `is_account_non_locked`, `is_credentials_non_expired`, `is_enabled`, `unlock_try`, `locked_date`, `account_expire_date`, `cedentials_expire_date`, `disabled_date`) VALUES
	('alice@mcd.com', 'alice', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL),
	('admin@mcd.com', 'admin', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL),
	('rest@mcd.com', 'rest', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL),
	('bob@mcd.com', 'bob', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL),
	('manager@mcd.com', 'manager', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `preludebuser` ENABLE KEYS */;

-- Dumping data for table mcd.product: ~9 rows (대략적)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`idx`, `product_id`, `product_name`, `category_id`, `pirce`) VALUES
	(1, 'prod_mcd_0001', 'Big Mac', 'Hamburger', NULL),
	(2, 'prod_mcd_0002', 'Daily Double', 'Hamburger', NULL),
	(3, 'prod_mcd_0003\r\n', 'Veggle Burger', 'Hamburger', NULL),
	(4, 'prod_mcd_0004\r\n', 'Crunch Burger', 'Hamburger', NULL),
	(5, 'prod_mcd_0005', 'Quarter Pounder With Cheese', 'Hamburger', NULL),
	(6, 'prod_mcd_0006', 'McFlurry with M&M\'s®', 'Desserts & Shakes', NULL),
	(7, 'prod_mcd_0007', 'Coke', 'Beverage', NULL),
	(8, 'prod_mcd_0008', 'Sprite', 'Beverage', NULL),
	(9, 'prod_mcd_0009\r\n', 'Frenchfry', 'Frenchfry', NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping data for table mcd.to_do_list: ~77 rows (대략적)
/*!40000 ALTER TABLE `to_do_list` DISABLE KEYS */;
INSERT INTO `to_do_list` (`idx`, `to_do_id`, `owner_id`, `is_checked`, `is_canceled`, `is_modified`, `is_new`, `title`, `category`, `detail`, `comment`, `create_date`, `created_by`, `remind_date`, `start_date`, `end_date`, `checked_date`, `priority`) VALUES
	(0000000001, 'todo_00001', 'manager@mcd.com', 1, NULL, 0, 1, 'device ', 'check device  health', NULL, NULL, '2014-06-24 08:27:53', 'manager@mcd.com', NULL, '2014-07-03 20:40:00', '2014-07-24 08:28:05', '2014-07-29 16:45:07', 4),
	(0000000002, 'todo_00002', 'manager@mcd.com', 0, NULL, 0, 1, 'inventory', 'check inventory', NULL, NULL, '2014-06-24 08:27:53', 'manager@mcd.com', NULL, '2014-07-03 20:40:03', '2014-07-24 08:28:05', '2014-07-29 11:02:51', 4),
	(0000000003, 'todo_00003', 'manager@mcd.com', 0, NULL, 0, 1, 'attendance', 'check member', NULL, NULL, '2014-06-24 08:27:53', 'manager@mcd.com', NULL, '2014-07-03 20:40:04', '2014-07-24 08:28:05', '2014-07-29 11:02:51', 4),
	(0000000004, 'todo_00004', 'manager@mcd.com', 1, NULL, 0, 1, 'ETQ', 'check expected quantities\r', NULL, NULL, '2014-06-24 08:27:53', 'manager@mcd.com', NULL, '2014-07-03 20:40:05', '2014-07-24 08:28:05', '2014-07-29 11:02:51', 4),
	(0000000005, 'todo_00005', 'manager@mcd.com', 1, 1, 0, 1, 'device', 'Check device', 'check', 'check', '2014-06-24 08:27:53', 'manager@mcd.com', '2014-06-24 08:27:53', '2014-07-09 17:28:30', '2014-07-24 08:28:05', '2014-07-23 15:27:13', 4),
	(0000000006, 'todo_00006', 'manager@mcd.com', 1, 0, 0, 1, 'inventory', 'check inventry', NULL, NULL, '2014-06-24 08:27:53', 'manager@mcd.com', NULL, '2014-07-09 17:28:30', '2014-07-24 08:28:05', '2014-07-23 15:27:13', 4),
	(0000000007, 'todo_00007', 'manager@mcd.com', 0, 0, 0, 1, 'attendance', 'check member', NULL, NULL, '2014-06-24 08:27:53', 'manager@mcd.com', NULL, '2014-07-10 08:00:00', '2014-07-24 08:28:05', NULL, 4),
	(0000000008, 'todo_00008', 'manager@mcd.com', 1, 1, 0, 1, 'ETQ', 'check expected quantities', NULL, NULL, '2014-06-24 08:27:53', 'manager@mcd.com', NULL, '2014-07-10 08:00:00', '2014-07-24 08:28:05', '2014-07-21 14:54:03', 4),
	(0000000009, 'todo_00009', 'manager@mcd.com', 1, 1, 0, 1, 'inventory', 'check inventory', NULL, NULL, '2014-06-24 08:27:53', 'manager@mcd.com', NULL, '2014-07-10 08:00:00', '2014-07-24 08:28:05', '2014-07-21 14:54:03', 4),
	(0000000010, 'todo_00010', 'manager@mcd.com', 0, 0, 0, 1, 'device', 'check device health', NULL, NULL, '2014-06-24 08:00:00', 'manager@mcd.com', NULL, '2014-07-10 08:00:00', '2014-07-24 08:00:00', NULL, 4),
	(0000000011, 'todo_a2f75196-3449-46f3-b692-a5db65b5360e', 'manager@mcd.com', 0, 0, 0, 1, 'Attendance', 'Check member', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000012, 'todo_e5867d2d-8f38-4633-a8fd-7605f84daf4d', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Order new flags', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000013, 'todo_b0e9aa16-34c0-4256-ae9c-a784a4fcf3ff', 'manager@mcd.com', 0, 0, 0, 1, 'Device', '3 Cleaning Tasks to be completed', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000014, 'todo_54f4716c-f650-49b8-92d5-6a65a8fd9d24', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Order additional bacon', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000015, 'todo_9e7baab4-19f2-434e-946d-5596e99fcd69', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Review refrigerator stock levles', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000016, 'todo_2273d104-98ec-458a-8b3f-cbfe927f460d', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'IR Alert - Place cover on 3rd Fry vat', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000017, 'todo_ebf54014-8d04-4ce0-89c0-194f6f0b2084', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Check expected quantities', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000018, 'todo_4b89b4b2-c7ac-41a1-ad5a-8c608e1f9203', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Organize stockroom', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000019, 'todo_c645b0bd-67bc-40dd-aaa0-872ee85e9fd1', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Check inventory', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000020, 'todo_e701b275-1a64-4268-afed-0e19a68c4a7d', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Check device', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-28 08:00:00', '2014-07-28 23:59:59', NULL, 4),
	(0000000021, 'todo_d8fe0d21-7b17-4bbe-94b0-7e0f35be6ae9', 'manager@mcd.com', 1, 0, 0, 1, 'Inventory', 'Order additional bacon', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000022, 'todo_20e5a7d4-535f-4e9e-a4d5-bba414524081', 'manager@mcd.com', 1, 0, 0, 1, 'Attendance', 'Check member', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000023, 'todo_50fff3e1-cd8b-40ac-b33d-ec5da2285c8a', 'manager@mcd.com', 1, 0, 0, 1, 'ETQ', 'Organize stockroom', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000024, 'todo_fb6c6e69-7fa7-404a-b5de-2ab748126a5b', 'manager@mcd.com', 1, 0, 0, 1, 'Inventory', 'Check inventory', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000025, 'todo_a2473025-c88f-4050-87e3-feaca5ded37f', 'manager@mcd.com', 1, 0, 0, 1, 'ETQ', 'Review refrigerator stock levles', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000026, 'todo_c812cbde-5c7d-49af-bdad-1df16835b5b3', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Order new flags', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000027, 'todo_419c0d11-0278-4714-9cab-54fa8d01347d', 'manager@mcd.com', 0, 0, 0, 1, 'Device', '3 Cleaning Tasks to be completed', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000028, 'todo_7885b007-b331-4a2d-b50a-fed45d3f3292', 'manager@mcd.com', 1, 0, 0, 1, 'Device', 'Check device', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000029, 'todo_8854c8eb-f83c-4f4b-b53a-23dd65db80c2', 'manager@mcd.com', 1, 0, 0, 1, 'ETQ', 'Check expected quantities', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000030, 'todo_0c92af99-72f0-459c-b91d-3b46960b50ce', 'manager@mcd.com', 1, 0, 0, 1, 'Device', 'IR Alert - Place cover on 3rd Fry vat', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-29 08:00:00', '2014-07-29 23:59:59', '2014-07-29 20:26:28', 4),
	(0000000031, 'todo_1d6e5707-af9e-49af-bb7e-2a6a24eddcff', 'manager@mcd.com', 1, 0, 0, 1, 'Inventory', 'Check inventory', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000032, 'todo_fbbddead-33cf-45c1-ac32-6dcf5ef7e46d', 'manager@mcd.com', 1, 0, 0, 1, 'Device', 'IR Alert - Place cover on 3rd Fry vat', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000033, 'todo_c7c48a47-4429-4ba9-bafe-efbb9985db2c', 'manager@mcd.com', 1, 0, 0, 1, 'ETQ', 'Check expected quantities', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000034, 'todo_7c3157d3-03f0-48e4-a4d4-c1a17c0e5237', 'manager@mcd.com', 1, 0, 0, 1, 'Device', 'Check device', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000035, 'todo_1db92e7e-6fa4-442a-8ea3-dab4ce3bf782', 'manager@mcd.com', 1, 0, 0, 1, 'Device', '3 Cleaning Tasks to be completed', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000036, 'todo_9b9057a9-1df4-424d-8b00-7a4a192c7c7c', 'manager@mcd.com', 1, 0, 0, 1, 'ETQ', 'Organize stockroom', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000037, 'todo_bdb22c8d-b756-4c0b-bfbc-16faf745d52e', 'manager@mcd.com', 1, 0, 0, 1, 'Device', 'Order new flags', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000038, 'todo_1718a307-7c09-40fc-b679-dea833b56b88', 'manager@mcd.com', 1, 0, 0, 1, 'Attendance', 'Check member', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000039, 'todo_aeaccea2-996c-4eb9-9e3d-fb9715372d73', 'manager@mcd.com', 1, 0, 0, 1, 'ETQ', 'Review refrigerator stock levles', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000040, 'todo_fc4652ba-c67c-47d0-98b9-def403924a50', 'manager@mcd.com', 1, 0, 0, 1, 'Inventory', 'Order additional bacon', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-30 08:00:00', '2014-07-30 23:59:59', '2014-07-30 15:35:53', 4),
	(0000000041, 'todo_1d81c43b-0c1d-4b30-979c-67450b410084', 'manager@mcd.com', 0, 0, 0, 1, 'Attendance', 'Check member', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000042, 'todo_c2322b14-6f33-4cd3-bbd0-10bc65c17012', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Order additional bacon', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000043, 'todo_b9c5e682-6fee-4e14-902b-7ecd04c1fb0a', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Check device', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000044, 'todo_3acb2e62-f79d-449f-b7bb-1bb0c2f37398', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Check inventory', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000045, 'todo_dffe7a0d-2fbb-4d48-a5fe-bc923d5b599a', 'manager@mcd.com', 0, 0, 0, 1, 'Device', '3 Cleaning Tasks to be completed', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000046, 'todo_1021f945-1aee-43a5-8abb-1c860c12cd56', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Review refrigerator stock levles', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000047, 'todo_af4d719f-ca68-4b02-9378-195ab0a98223', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Organize stockroom', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000048, 'todo_e55085f2-9337-46f5-951c-9e9e7eba3434', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Check expected quantities', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000049, 'todo_6e11db82-eddf-4b4f-be01-f1350f8b7e22', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Order new flags', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000050, 'todo_7efe2eca-6d59-494e-9b8c-f0219dd18f59', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'IR Alert - Place cover on 3rd Fry vat', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-31 08:00:00', '2014-07-31 23:59:59', NULL, 4),
	(0000000051, 'todo_185dfc91-793e-4a75-9f11-72f480ebc90c', 'manager@mcd.com', 0, 0, 0, 1, 'Device', '3 Cleaning Tasks to be completed', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000052, 'todo_7c23391d-ade6-4e7b-91ab-3d0873100ed1', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'IR Alert - Place cover on 3rd Fry vat', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000053, 'todo_dbb6ad51-5d73-4df5-a1ae-6f977d366216', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Order additional bacon', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000054, 'todo_8dc96ac0-c005-46b4-9390-a612eddf995f', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Order new flags', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000055, 'todo_dc5d8066-5126-4d9b-8b3d-cb36c33a77ce', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Review refrigerator stock levles', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000056, 'todo_ab151a0f-df2f-443b-a0b7-a708c566d0d5', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Check expected quantities', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000057, 'todo_ca6af725-eb36-4d11-ba60-c62723d1c7af', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Check inventory', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000058, 'todo_45b6abd6-d54d-4d82-9b7e-11a1f8f0163d', 'manager@mcd.com', 0, 0, 0, 1, 'Attendance', 'Check member', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000059, 'todo_3ba995ad-e8c0-4c40-89ae-bb6244a3cac2', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Organize stockroom', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000060, 'todo_f865de2e-752c-497d-84bc-bacef1381318', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Check device', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-01 08:00:00', '2014-08-01 23:59:59', NULL, 4),
	(0000000061, 'todo_c10ea8c7-833a-46f4-b1ed-23dfbf71d15d', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Organize stockroom', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000062, 'todo_c5582dc6-b603-4ca5-b468-3d25264f3d7b', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Check device', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000063, 'todo_72ed7ef5-b062-4276-a182-d51f54fae559', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Review refrigerator stock levles', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000064, 'todo_14794ff7-24a6-4217-8eeb-c6e6b832f33b', 'manager@mcd.com', 0, 0, 0, 1, 'Device', '3 Cleaning Tasks to be completed', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000065, 'todo_dcef0f57-d5a3-433d-8593-5c68a3d71ff4', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Order new flags', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000066, 'todo_72c04558-8eeb-449e-9972-ee167cceede1', 'manager@mcd.com', 0, 0, 0, 1, 'Attendance', 'Check member', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000067, 'todo_d602ec02-e6b1-4789-9007-04e44b452e9a', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'IR Alert - Place cover on 3rd Fry vat', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000068, 'todo_836dcb4b-b83e-43c4-ab02-91495fcbdb21', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Check inventory', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000069, 'todo_d2961cfb-4d3e-4cb0-9e2d-feaf3ca490ed', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Order additional bacon', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000070, 'todo_355feed5-d3e6-431a-9f83-4e4d284e028e', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Check expected quantities', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-08-02 08:00:00', '2014-08-02 23:59:59', NULL, 4),
	(0000000081, 'todo_0996e590-a6ea-4f55-9874-960516235b17', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Organize stockroom', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', '2014-07-29 16:56:24', 4),
	(0000000082, 'todo_4e463b1b-f17e-4542-8e93-28fde5580f5e', 'manager@mcd.com', 1, 0, 0, 1, 'Device', '3 Cleaning Tasks to be completed', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', '2014-07-29 16:56:24', 4),
	(0000000083, 'todo_9ea095c8-ef65-4f36-97e2-2f10254c93d7', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Order additional bacon', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', NULL, 4),
	(0000000084, 'todo_a8a56a89-7e01-4eee-9f88-b4a22487539b', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Check device', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', NULL, 4),
	(0000000085, 'todo_8ec38411-bbc9-4df2-8916-748e41c94b91', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Review refrigerator stock levles', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', NULL, 4),
	(0000000086, 'todo_62d53a1a-8a9c-4138-a85c-9b270240257b', 'manager@mcd.com', 0, 0, 0, 1, 'Attendance', 'Check member', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', NULL, 4),
	(0000000087, 'todo_38bdd14b-1739-466c-8ca7-75ca56ad255c', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'Order new flags', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', NULL, 4),
	(0000000088, 'todo_07b86a8f-1c3a-4fba-af27-f182bf5a3e10', 'manager@mcd.com', 0, 0, 0, 1, 'Inventory', 'Check inventory', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', NULL, 4),
	(0000000089, 'todo_3aedfe0b-38c4-4ca1-bfc5-790326c6914f', 'manager@mcd.com', 0, 0, 0, 1, 'ETQ', 'Check expected quantities', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', NULL, 4),
	(0000000090, 'todo_77307dc8-9eb4-43cd-b87b-616d308e1447', 'manager@mcd.com', 0, 0, 0, 1, 'Device', 'IR Alert - Place cover on 3rd Fry vat', NULL, NULL, '2014-07-26 08:00:00', 'manager@mcd.com', NULL, '2014-07-24 08:00:00', '2014-07-24 23:59:59', NULL, 4);
/*!40000 ALTER TABLE `to_do_list` ENABLE KEYS */;

-- Dumping data for table mcd.user: ~7 rows (대략적)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `user_name`, `cellphone_nr`, `push_register_key`, `email`, `birth_day`, `anniversary_day`, `create_time`, `update_time`) VALUES
	('admin@mcd.com', 'Administrator', NULL, NULL, 'admin@mcd.com', '1980-07-04', '2013-07-04', '2014-07-04 14:56:08', NULL),
	('alice@mcd.com', 'Alice Alden', NULL, NULL, 'alice@mcd.com', '1981-07-04', '2013-07-04', '2014-07-04 14:56:04', NULL),
	('bob@mcd.com', 'Robert Brown', NULL, NULL, 'bob@mcd.com', '1995-07-04', '2013-07-04', '2014-07-04 14:56:05', NULL),
	('bs1031@mcd.com', 'BS YUN', NULL, NULL, 'bs1031@mcd.com', '1983-07-04', '2012-07-04', '2014-07-17 16:26:31', '2014-07-17 16:26:31'),
	('manager@mcd.com', 'Manager', '01011112222', 'APA91bH26aJIkvOswU0TZAF4-ZZiyQIPuHI2dVUMkhdj89QRkcfw_H6y4Xz6I75cWknJa8YT2xXmE07wgqdKRBbUtTVQut8dQ2I9-ZiZlecU-V2CWscVxH4dcXB1SkJfYleD2GWrWiTxQnUVSRlRIqwnTBs6ju67FA', 'manager@mcd.com', '1991-07-04', '2010-07-04', '2014-07-04 14:56:07', NULL),
	('rest@mcd.com', 'Rest API', NULL, NULL, 'rest@mcd.com', '1994-07-04', '2013-07-04', '2014-07-04 14:56:05', NULL),
	('storekeeper@mcd.com', 'Storekeeper', NULL, NULL, 'storekeeper@mcd.com', '1991-07-04', '2010-07-04', '2014-07-04 14:56:07', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping data for table mcd.user_role: ~9 rows (대략적)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`idx`, `role_id`, `role_name`, `category`, `description`) VALUES
	(0000000008, 'CHAT_MEMBER', 'MEMBER', 'CHAT', NULL),
	(0000000004, 'CHAT_OWNER', 'OWNER', 'CHAT', NULL),
	(0000000007, 'MCD_CREW', 'CREW', 'GROUP', NULL),
	(0000000006, 'MCD_MANAGER', 'MANAGER', 'GROUP', NULL),
	(0000000002, 'ROLE_ADMIN', 'ADMIN', 'SYSTEM', NULL),
	(0000000003, 'ROLE_API', 'API', 'SYSTEM', NULL),
	(0000000005, 'ROLE_MANAGER', 'MANAGER', 'SYSTEM', NULL),
	(0000000009, 'ROLE_STOREKEEPER', 'STOREKEEPER', 'SYSTEM', NULL),
	(0000000001, 'ROLE_USER', 'USER', 'SYSTEM', NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

-- Dumping data for table mcd.user_role_mapping: ~16 rows (대략적)
/*!40000 ALTER TABLE `user_role_mapping` DISABLE KEYS */;
INSERT INTO `user_role_mapping` (`user_id`, `role_id`) VALUES
	('admin@mcd.com', 'ROLE_ADMIN'),
	('admin@mcd.com', 'ROLE_USER'),
	('alice@mcd.com', 'MCD_CREW'),
	('alice@mcd.com', 'ROLE_USER'),
	('alice@mcd.com', 'CHAT_MEMBER'),
	('bob@mcd.com', 'MCD_CREW'),
	('bob@mcd.com', 'ROLE_USER'),
	('bob@mcd.com', 'CHAT_MEMBER'),
	('manager@mcd.com', 'MCD_MANAGER'),
	('manager@mcd.com', 'ROLE_USER'),
	('manager@mcd.com', 'CHAT_OWNER'),
	('rest@mcd.com', 'ROLE_API'),
	('storekeeper@mcd.com', 'ROLE_STOREKEEPER'),
	('storekeeper@mcd.com', 'ROLE_USER'),
	('', ''),
	('', '');
/*!40000 ALTER TABLE `user_role_mapping` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
