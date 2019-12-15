/*
Navicat MySQL Data Transfer

Source Server         : XMAPP-MYSQL
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : stupaysys

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-12-09 13:05:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bundle`
-- ----------------------------
DROP TABLE IF EXISTS `bundle`;
CREATE TABLE `bundle` (
  `bundleid` int(12) NOT NULL,
  `bundlename` varchar(50) NOT NULL,
  `bundlevalidtime` int(5) NOT NULL,
  `bundlestate` int(1) NOT NULL,
  `bundleprice` double NOT NULL,
  `bundleinfo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bundleid`),
  KEY `bundleid` (`bundleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of bundle
-- ----------------------------
INSERT INTO `bundle` VALUES ('1', '宽带包月20M-1', '1', '1', '50', '宽带20M50元包月套餐');
INSERT INTO `bundle` VALUES ('2', '宽带包月100M-1', '1', '1', '70', '宽带100M70元包月套餐');
INSERT INTO `bundle` VALUES ('3', '宽带包年50M-1', '12', '1', '420', '宽带50M420元包年套餐');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `custid` int(12) NOT NULL,
  `custname` varchar(50) NOT NULL,
  `custcreateid` int(12) DEFAULT NULL,
  `custdor` varchar(10) NOT NULL,
  `custphone` varchar(11) DEFAULT NULL,
  `custcreatedate` date DEFAULT NULL,
  `custbundleid` int(12) DEFAULT NULL,
  `custnetvaliddate` datetime DEFAULT NULL,
  PRIMARY KEY (`custid`),
  KEY `custname` (`custname`),
  KEY `custcreateid` (`custcreateid`),
  KEY `custbundleid` (`custbundleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('3000', '陈迪思', '2000', 'S4610', '18752368741', '2019-12-04', '1', '2020-01-04 00:00:00');
INSERT INTO `customer` VALUES ('3001', '吕伟卜', '2000', 'N5702', '13952647189', '2019-12-03', '2', '2020-01-03 00:00:00');
INSERT INTO `customer` VALUES ('3002', '牛度恩', '2000', 'S2203', '15236285641', '2019-12-05', '3', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(12) NOT NULL,
  `ordercustid` int(12) NOT NULL,
  `orderbundleid` int(12) NOT NULL,
  `ordercreateuserid` int(12) NOT NULL,
  `ordercreatetime` datetime NOT NULL,
  `orderpaytime` datetime NOT NULL,
  `orderstate` int(1) NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `ordercustid` (`ordercustid`),
  KEY `orderbundleid` (`orderbundleid`),
  KEY `ordercreateuserid` (`ordercreateuserid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '3000', '1', '2000', '2019-12-04 14:32:30', '2019-12-05 14:32:36', '1');
INSERT INTO `orders` VALUES ('2', '3001', '2', '2000', '2019-12-03 14:33:14', '2019-12-03 14:33:18', '1');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userid` int(12) NOT NULL,
  `username` varchar(50) NOT NULL,
  `userpassword` varchar(30) NOT NULL,
  `userlimit` varchar(1) NOT NULL,
  `userstate` varchar(1) NOT NULL,
  PRIMARY KEY (`userid`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1000', '管理员', '123456', '1', '1');
INSERT INTO `userinfo` VALUES ('2000', '李经理', '123456', '2', '1');
INSERT INTO `userinfo` VALUES ('3000', '陈迪思', '123456', '3', '1');
INSERT INTO `userinfo` VALUES ('3001', '吕伟卜', '123456', '3', '1');
INSERT INTO `userinfo` VALUES ('3002', '牛度恩', '123456', '3', '1');
