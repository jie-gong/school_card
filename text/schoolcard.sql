/*
Navicat MySQL Data Transfer

Source Server         : admin
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : schoolcard

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2022-09-26 14:49:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin` varchar(20) DEFAULT NULL COMMENT '管理员账号',
  `adminpass` varchar(20) DEFAULT NULL COMMENT '管理员密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('user1', '1234');

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  `gz` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('11', '2022-09-20 15:48:57', '2022-09-20 15:48:57', '0', '给的什么值，都会被 mysql 固定保存成 10 个字符。char 是固定长度，其单位也是字符，比如 char(10)，就表示不管你给的什么值，都会被 mysql 固定保存成 10 个字符。char 是固定长度，其单char 是固定长度，其单位也是字符，比如 char(10)，就表示不管你给的什么值，都会被 mysql 固定保存成 10 个字符。char 是固定长度，其单位也是字符，比如 char(10)，就表示不管你给的什么值，都会被 mysql 固定保存成 10 个字符。位也是字符，比如 char(10)，就表示不管你给的什么值，都会被 mysql 固定保存成 10 个字符。');
INSERT INTO `announcement` VALUES ('12', '2022-09-20 15:49:30', '2022-09-20 15:49:30', '0', '同学们早上好');
INSERT INTO `announcement` VALUES ('13', '2022-09-20 16:00:21', '2022-09-20 16:00:21', '0', '同学们签到了');
INSERT INTO `announcement` VALUES ('14', '2022-09-20 16:01:32', '2022-09-20 16:01:32', '0', '同学们下课了');
INSERT INTO `announcement` VALUES ('15', '2022-09-20 16:02:15', '2022-09-20 16:02:15', '0', '同学们晚上好');
INSERT INTO `announcement` VALUES ('16', '2022-09-21 09:50:59', '2022-09-21 09:50:59', '0', '同学们签到了');
INSERT INTO `announcement` VALUES ('17', '2022-09-21 11:56:01', '2022-09-21 11:56:01', '0', '        随着智能设备的普及化以及功能的集成化，现在人们出行只需要一部手机就可以了。但是如果你是在大学的话，就会知道，大学有校园卡这一说。学校会将校园的服务认证。集成到一张卡里面，只有通过卡片进行认证，才能获得学校的相关服务，例如：借书，洗澡，购物，吃饭，打水等等。           这种校园一卡通一般都是联网的，也就是说卡片的使用记录是会被存储到数据库中的，使用记录是可以查询的，金额是可以通过网络进行实时纠正的。这样的话，对于学校来说，学校的财产安全是得到保障的，不会被别有用心的人“偷钱用”，也就是不能通过更改卡中的金额数据来消费。数据库会对卡片中的金额进行纠正，当卡片中的金额与数据库中金额不匹配时，卡中的数据就会被修改成正确数据，来避免“盗刷”。           但是，这种卡对于学生来说，并不是很友好。卡片本身比较容易丢失，而且补办非常麻烦，且补办的费用也不便宜（可以说是暴利）。其实，丢失的风险是可以避免的，我们只要找到合理的方式就可以了。            下面我谈谈我的想法，最容易想到的就是把卡夹在手机壳后面。如果是软壳的话，放下一张卡是没有问题的，但如果是硬壳的话，根本不可能放得下。如果是多张卡的话，那完蛋了，软壳也是放不下的。            而且，就算软壳手机后面能放下卡，但是手机本身会对射频的读写产生影响，导致卡在手机后面是无法读写的，使用的时候还是要从后面拿出来，虽然不容易掉了，但还是很不方便。 ———————————————— 版权声明：本文为CSDN博主「cbirdfly.」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/C1664510416/article/details/95066160');
INSERT INTO `announcement` VALUES ('18', '2022-09-21 12:19:20', '2022-09-21 12:19:20', '0', '杨昱中');
INSERT INTO `announcement` VALUES ('19', '2022-09-21 19:33:25', '2022-09-21 19:33:25', '0', '钱钱钱钱钱钱钱钱钱');
INSERT INTO `announcement` VALUES ('20', '2022-09-21 19:59:39', '2022-09-21 19:59:39', '0', '同学们签到了');
INSERT INTO `announcement` VALUES ('21', '2022-09-22 09:46:09', '2022-09-22 09:46:09', '0', '朱兴旺是个大帅逼');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `studentid` int(10) NOT NULL AUTO_INCREMENT,
  `balance` varchar(10) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=2022 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('2001', '324', '0');
INSERT INTO `card` VALUES ('2002', '424', '0');
INSERT INTO `card` VALUES ('2003', '12', '0');
INSERT INTO `card` VALUES ('2009', '0', '0');
INSERT INTO `card` VALUES ('2017', '0', '0');
INSERT INTO `card` VALUES ('2018', '0', '0');
INSERT INTO `card` VALUES ('2019', '0', '0');
INSERT INTO `card` VALUES ('2020', '150', '0');
INSERT INTO `card` VALUES ('2021', '0', '0');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `studentid` int(20) NOT NULL,
  `balance` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('11', '2001', '0', '2022-09-12 11:59:16', '2022-09-12 11:59:16');
INSERT INTO `record` VALUES ('12', '2001', '22', '2022-09-12 12:02:47', '2022-09-12 12:02:47');
INSERT INTO `record` VALUES ('13', '2001', '20', '2022-09-15 20:12:54', '2022-09-15 20:12:54');
INSERT INTO `record` VALUES ('14', '2002', '20', '2022-09-16 08:31:39', '2022-09-16 08:31:39');
INSERT INTO `record` VALUES ('15', '2002', '20', '2022-09-16 08:31:40', '2022-09-16 08:31:40');
INSERT INTO `record` VALUES ('17', '2002', '20', '2022-09-16 08:31:42', '2022-09-16 08:31:42');
INSERT INTO `record` VALUES ('18', '2002', '20', '2022-09-16 08:31:42', '2022-09-16 08:31:42');
INSERT INTO `record` VALUES ('19', '2020', '30', '2022-09-21 19:57:18', '2022-09-21 19:57:18');
INSERT INTO `record` VALUES ('20', '2020', '30', '2022-09-22 09:45:18', '2022-09-22 09:45:18');
INSERT INTO `record` VALUES ('21', '2020', '30', '2022-09-22 09:45:21', '2022-09-22 09:45:21');
INSERT INTO `record` VALUES ('22', '2020', '30', '2022-09-22 09:45:23', '2022-09-22 09:45:23');
INSERT INTO `record` VALUES ('23', '2020', '30', '2022-09-22 09:45:23', '2022-09-22 09:45:23');

-- ----------------------------
-- Table structure for resul
-- ----------------------------
DROP TABLE IF EXISTS `resul`;
CREATE TABLE `resul` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `java` varchar(255) DEFAULT NULL,
  `html` varchar(255) DEFAULT NULL,
  `spring` varchar(255) DEFAULT NULL,
  `mybatis` varchar(255) DEFAULT NULL,
  `mysql` varchar(255) DEFAULT NULL,
  `bootstrap` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resul
-- ----------------------------
INSERT INTO `resul` VALUES ('1', '公杰', '99', '22', '33', '55', '66', '123');
INSERT INTO `resul` VALUES ('2', '朱兴旺', '99', '80', '99', '98', '70', '100');
INSERT INTO `resul` VALUES ('3', '史正龙', '100000000', '100000000', '1000000000', '100000000', '1000000000', '1000000000');
INSERT INTO `resul` VALUES ('4', '黄扬', '99', '80', '99', '98', '1111', '100');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `studentid` int(20) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `magor` varchar(20) DEFAULT NULL COMMENT '专业',
  `sex` int(2) DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(10) DEFAULT '0',
  `version` int(20) DEFAULT '1',
  `idcard` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=2022 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('史正龙', '2001', '软件技术', '0', '1222222', '2022-09-11 16:39:40', '2022-09-19 14:40:14', '0', '1', '11111111111111');
INSERT INTO `student` VALUES ('姬文博', '2002', '计算机应用技术', '1', '123', '2022-09-15 10:28:09', '2022-09-15 10:28:09', '0', '1', '11111111111111');
INSERT INTO `student` VALUES ('周杰伦', '2003', '歌手', '1', '15964878601', null, '2022-09-16 16:22:06', '0', '1', '11111111111111');
INSERT INTO `student` VALUES ('陈奕迅', '2009', '软件技术', '1', '123', '2022-09-16 15:43:29', '2022-09-16 15:43:29', '0', '1', '12345678901234567');
INSERT INTO `student` VALUES ('公杰', '2010', '1', '1', '1', '2022-09-18 12:23:25', '2022-09-18 12:23:25', '0', '1', '1');
INSERT INTO `student` VALUES ('罗永浩', '2015', '1', '1', '1', '2022-09-18 12:25:48', '2022-09-18 12:25:48', '0', '1', '1');
INSERT INTO `student` VALUES ('娄燕浩', '2017', '社会我浩哥 人狠话不多', '1', '11', '2022-09-18 12:26:46', '2022-09-21 20:42:21', '0', '1', '1');
INSERT INTO `student` VALUES ('黄扬', '2018', '唱跳raup', '1', '12345678999', '2022-09-18 13:07:08', '2022-09-18 13:07:08', '0', '1', '12345678912345678');
INSERT INTO `student` VALUES ('朱兴旺', '2019', '唱跳raup', '0', '11223344556', '2022-09-18 13:14:57', '2022-09-18 13:14:57', '0', '1', '1233212321232123');
INSERT INTO `student` VALUES ('队长', '2020', '美声专业', '1', '15964878601', '2022-09-19 08:47:02', '2022-09-19 08:47:02', '0', '1', '12345678901234567');
INSERT INTO `student` VALUES ('郭忠振', '2021', '唱跳raup', '1', '311311311311', '2022-09-20 15:38:35', '2022-09-20 15:38:35', '0', '1', '321456852963741');

-- ----------------------------
-- Table structure for studentcard
-- ----------------------------
DROP TABLE IF EXISTS `studentcard`;
CREATE TABLE `studentcard` (
  `cardid` int(20) NOT NULL AUTO_INCREMENT,
  `balance` varchar(10) DEFAULT NULL,
  `studentid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cardid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentcard
-- ----------------------------

-- ----------------------------
-- Table structure for testlogin
-- ----------------------------
DROP TABLE IF EXISTS `testlogin`;
CREATE TABLE `testlogin` (
  `test` varchar(20) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testlogin
-- ----------------------------
INSERT INTO `testlogin` VALUES ('123456', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `studentid` varchar(10) DEFAULT NULL,
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `kay` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT '0000-00-00 00:00:00',
  `deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2001', 'root', '123456', '1234', null, null, '0');
INSERT INTO `user` VALUES ('2', '2002', 'user1', '123456', '1234', null, null, '0');
INSERT INTO `user` VALUES ('7', '2003', 'user2', '123456', '1234', null, null, '0');
INSERT INTO `user` VALUES ('8', '2009', 'user3', '123456', '1234', null, null, '0');
INSERT INTO `user` VALUES ('9', '2010', 'user4', '123456', '1234', null, null, '0');
INSERT INTO `user` VALUES ('10', '2015', 'user5', '123456', '1234', null, null, '0');
INSERT INTO `user` VALUES ('11', '2017', 'user6', '123456', '1234', null, null, '0');
INSERT INTO `user` VALUES ('12', '2018', 'user7', '123456', '1234', '2022-09-20 16:45:27', '2022-09-20 16:45:31', '0');
INSERT INTO `user` VALUES ('13', '2019', 'user8', '123456', '1234', null, null, '0');
INSERT INTO `user` VALUES ('14', '2020', 'user9', '123456', '1234', null, null, '0');
INSERT INTO `user` VALUES ('15', '2021', 'user10', '123456', '1234', null, null, '0');
