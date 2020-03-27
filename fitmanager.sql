/*
 Navicat Premium Data Transfer

 Source Server         : 本机mysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 127.0.0.1:3306
 Source Schema         : fitmanager

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 27/03/2020 14:26:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_used` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_4s
-- ----------------------------
DROP TABLE IF EXISTS `t_4s`;
CREATE TABLE `t_4s`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `c_4s_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `c_4s_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_4s
-- ----------------------------
INSERT INTO `t_4s` VALUES (1, '74', '47');
INSERT INTO `t_4s` VALUES (2, '58', '69');

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` int(2) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`account_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES (1, '2323', '4343', 1);
INSERT INTO `t_account` VALUES (2, 'rere', 'tryr', 1);
INSERT INTO `t_account` VALUES (8, 'simba', '123', 1);
INSERT INTO `t_account` VALUES (9, 'admin', 'admin', 2);
INSERT INTO `t_account` VALUES (10, '12288888888', '123456', 1);
INSERT INTO `t_account` VALUES (11, 'liyuanbo', '54645', 0);
INSERT INTO `t_account` VALUES (12, '133888888888', '123456', 1);
INSERT INTO `t_account` VALUES (13, '144888888888', '123456', 2);
INSERT INTO `t_account` VALUES (14, '17775480980', '123456', 2);
INSERT INTO `t_account` VALUES (15, '13388888888', '123456', 1);
INSERT INTO `t_account` VALUES (16, '11454531921', '123456', 1);
INSERT INTO `t_account` VALUES (17, '123456789111', '46546546', 1);
INSERT INTO `t_account` VALUES (18, '321432', '3143213', 1);
INSERT INTO `t_account` VALUES (19, '3143431431', '134321432', 1);
INSERT INTO `t_account` VALUES (20, '1243314', '134134', 1);
INSERT INTO `t_account` VALUES (21, '124331467', '134134', 1);
INSERT INTO `t_account` VALUES (22, '13431431', '3143434', 1);
INSERT INTO `t_account` VALUES (23, '124324312', '4314134', 1);
INSERT INTO `t_account` VALUES (24, '124334', '3141324', 1);
INSERT INTO `t_account` VALUES (25, '13432432', '21433243', 1);
INSERT INTO `t_account` VALUES (26, '134314324', '32143241', 1);
INSERT INTO `t_account` VALUES (27, '32432', '321432', 1);
INSERT INTO `t_account` VALUES (28, '1338888888', '123456', 1);
INSERT INTO `t_account` VALUES (29, '1333', '123456', 1);
INSERT INTO `t_account` VALUES (30, '1234', '234', 1);
INSERT INTO `t_account` VALUES (31, '12341234123', '1343241', 1);
INSERT INTO `t_account` VALUES (32, '12345678901', '123456', 1);
INSERT INTO `t_account` VALUES (33, '', '', 2);
INSERT INTO `t_account` VALUES (34, '1', '', 2);
INSERT INTO `t_account` VALUES (35, '12', '121212', 2);
INSERT INTO `t_account` VALUES (36, '17775385979', '123456', 1);
INSERT INTO `t_account` VALUES (37, '123456', '123456', 1);
INSERT INTO `t_account` VALUES (38, '12345678902', '123456', 2);

-- ----------------------------
-- Table structure for t_account_4s
-- ----------------------------
DROP TABLE IF EXISTS `t_account_4s`;
CREATE TABLE `t_account_4s`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `account_id` int(255) NOT NULL,
  `c_4s_id` int(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `account_id`(`account_id`) USING BTREE,
  INDEX `4s_id`(`c_4s_id`) USING BTREE,
  CONSTRAINT `4s_id` FOREIGN KEY (`c_4s_id`) REFERENCES `t_4s` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `account_id` FOREIGN KEY (`account_id`) REFERENCES `t_account` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_fit
-- ----------------------------
DROP TABLE IF EXISTS `t_fit`;
CREATE TABLE `t_fit`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `icid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `active_time` datetime(0) NULL DEFAULT NULL,
  `is_active` int(2) NULL DEFAULT 0,
  `is_bad` int(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `icid`(`icid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_fit
-- ----------------------------
INSERT INTO `t_fit` VALUES (17, '12345678901234567899', 0, '2019-05-28 01:50:15', '2019-05-27 03:01:54', 1, 1);
INSERT INTO `t_fit` VALUES (18, '12345678901234567898', 0, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (19, '123455678901234567897', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (20, '12345678901234567890', 1, '2019-05-24 06:22:48', '2019-05-27 03:01:54', 1, 0);
INSERT INTO `t_fit` VALUES (21, '1234567890123456', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (22, '12345678901234561234', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (23, '12345678901234565678', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (24, '12345678901234561235', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (25, '12345678901234561236', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (26, '12345678901234561237', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (27, '12345678901234561238', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (28, '12345678901234561239', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (29, '12345678901234561230', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (30, '12345678901234562345', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (31, '12345678901234562346', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (32, '12345678901234562347', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (33, '12345678901234562348', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (34, '12345678901234562349', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (35, '12345678901234562340', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (36, '12345678901234563456', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (37, '12345678901234563457', 1, '2019-05-28 01:50:15', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (38, 'd123456', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (39, 'e123456', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (40, 'd123457', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (41, 'e123457', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (42, 'd123458', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (43, 'e123458', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (44, 'd123459', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (45, 'e123459', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (46, 'd123460', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (47, 'e123460', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (48, 'd123461', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (49, 'e123461', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (50, 'd123462', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (51, 'e123462', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (52, 'd123463', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (53, 'e123463', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (54, 'd123464', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (55, 'e123464', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (56, 'd123465', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (57, 'e123465', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (58, 'd123466', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (59, 'e123466', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (60, 'd123467', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (61, 'e123467', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (62, 'd123468', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (63, 'e123468', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (64, 'd123469', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (65, 'e123469', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (66, 'd123470', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (67, 'e123470', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (68, 'd123471', 1, '2019-05-27 02:54:09', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (69, '445515', 1, '2019-05-24 17:12:30', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (70, '215454', 1, '2019-05-24 17:12:30', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (71, '554515', 1, '2019-05-24 17:12:30', NULL, 0, 0);
INSERT INTO `t_fit` VALUES (72, '515115', 1, '2019-05-24 17:12:30', NULL, 0, 0);

-- ----------------------------
-- Table structure for t_fit_change
-- ----------------------------
DROP TABLE IF EXISTS `t_fit_change`;
CREATE TABLE `t_fit_change`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `old_icid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `new_icid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `change_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `c_4s_id` int(255) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `c_4s_id`(`c_4s_id`) USING BTREE,
  CONSTRAINT `t_fit_change_ibfk_1` FOREIGN KEY (`c_4s_id`) REFERENCES `t_4s` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_fit_change
-- ----------------------------
INSERT INTO `t_fit_change` VALUES (3, '12345678901234567890', '12345678901234567891', '2019-05-23 13:34:54', 1);

-- ----------------------------
-- Table structure for t_fit_unbind
-- ----------------------------
DROP TABLE IF EXISTS `t_fit_unbind`;
CREATE TABLE `t_fit_unbind`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `icid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `relieve_time` datetime(0) NOT NULL,
  `relieve_car` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_fit_unbind
-- ----------------------------
INSERT INTO `t_fit_unbind` VALUES (1, '12345678901234567890', '2019-05-23 07:37:39', NULL);
INSERT INTO `t_fit_unbind` VALUES (2, 'e123469', '2019-05-24 08:34:37', NULL);
INSERT INTO `t_fit_unbind` VALUES (3, 'e123469', '2019-05-24 08:34:54', NULL);
INSERT INTO `t_fit_unbind` VALUES (4, '12345678901234561239', '2019-05-27 02:56:05', NULL);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '$2a$10$5xHujrYBrS2tThnOceiIuuvP0DEvblSM3FqrLw4I2cgvpNPu7u7.O', 'ROLE_ADMIN');
INSERT INTO `t_user` VALUES (2, '12345678901', '$2a$10$GuL/PEAWD2UtnB2eu1kNv.JlpBPR3PvY6eUHVF8Y4MSCIXLoncZ0O', 'ROLE_ADMIN');
INSERT INTO `t_user` VALUES (3, '12345678902', '$2a$10$cjKxjWgXma/tozdunUqxBeibeLTlfJp0QaMk2yc1s8y4wvApRx6zG', '4s');
INSERT INTO `t_user` VALUES (4, '147258369', '$2a$10$PWleRwjF85Q006LmC8Fxs.gZYVAcnyBhFLevJweqZrHbJDmCUbsRy', 'admin');
INSERT INTO `t_user` VALUES (5, '258', '$2a$10$8HQgoLSlgpftwRKlczf1..u.bKbtlsIChD8XyGyMqgsUrYqxK35Oa', 'admin');
INSERT INTO `t_user` VALUES (6, '123', '$2a$10$P.6hXrqgdupyoOxjSojCLukTyxhwSi2WlbYFVH57EfZ232ZUplCzu', 'ROLE_ADMIN');
INSERT INTO `t_user` VALUES (7, '369', '$2a$10$0ccMygQVfAN6f6kRcf6RGOp1SjbNgFDnRKoxPkaruRRUt75axOOsG', 'ROLE_4S');
INSERT INTO `t_user` VALUES (8, 'admin1', '$2a$10$w7gB.lq6jhM9KKb1HupZleQ4K/zNeM5NisnaycEWDkqj931zr5e2y', 'ROLE_ADMIN');

SET FOREIGN_KEY_CHECKS = 1;
