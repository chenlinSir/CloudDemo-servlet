create database Couldcar default character set utf8 collate utf8_general_ci;
use Couldcar;
/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : couldcar

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2019-04-17 19:43:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for branch
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_name` varchar(50) NOT NULL,
  `b_remark` varchar(100) DEFAULT NULL,
  `b_usable` int(11) DEFAULT '1',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES ('1', '技术部', '技术支持的管理', '1');
INSERT INTO `branch` VALUES ('2', '后勤部', '卫生的事物管理', '1');
INSERT INTO `branch` VALUES ('3', '财务部', '财务的流动管理', '1');
INSERT INTO `branch` VALUES ('4', '前台部', '前台的接待的管理', '1');
INSERT INTO `branch` VALUES ('5', '人事部', '人员信息的管理', '1');
INSERT INTO `branch` VALUES ('6', '保卫部', '进行公司的安全吧', '1');
INSERT INTO `branch` VALUES ('7', '后勤安全部', '安全的管理哟', '0');

-- ----------------------------
-- Table structure for incomingparts
-- ----------------------------
DROP TABLE IF EXISTS `incomingparts`;
CREATE TABLE `incomingparts` (
  `i_partsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '配件入库ID',
  `i_title` varchar(100) NOT NULL COMMENT '入库标题',
  `i_time` datetime NOT NULL COMMENT '入库时间',
  `i_personnel` varchar(255) NOT NULL COMMENT '入库人员',
  PRIMARY KEY (`i_partsId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of incomingparts
-- ----------------------------
INSERT INTO `incomingparts` VALUES ('1', '购买东西', '2019-04-24 04:52:10', '张三');
INSERT INTO `incomingparts` VALUES ('2', '买东西', '2019-04-24 04:52:10', '王五');
INSERT INTO `incomingparts` VALUES ('3', '买烟', '2019-04-24 04:52:10', '赵六');
INSERT INTO `incomingparts` VALUES ('5', '买东西', '2019-04-24 04:52:10', '王五');
INSERT INTO `incomingparts` VALUES ('6', '买盐', '2019-04-24 04:52:10', '赵六');
INSERT INTO `incomingparts` VALUES ('7', '买东西', '2019-04-24 04:52:10', '王五');
INSERT INTO `incomingparts` VALUES ('9', '买东西', '2019-04-24 04:52:10', '王五');
INSERT INTO `incomingparts` VALUES ('10', '1', '2019-04-08 09:20:57', '1');
INSERT INTO `incomingparts` VALUES ('11', '进货', '2019-04-17 11:23:09', ' 陈某人');
INSERT INTO `incomingparts` VALUES ('12', 's ', '2019-04-04 19:18:45', 's ');

-- ----------------------------
-- Table structure for incomingpartsinfo
-- ----------------------------
DROP TABLE IF EXISTS `incomingpartsinfo`;
CREATE TABLE `incomingpartsinfo` (
  `i_partsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '配件入库详情ID',
  `i_incomingPartsId` int(11) NOT NULL COMMENT '配件入库ID,外键',
  `i_querytheWarehouseId` int(11) NOT NULL COMMENT '配件基本信息ID,外键',
  `i_number` int(11) NOT NULL COMMENT '入库数量',
  `i_totalPrice` decimal(10,0) NOT NULL COMMENT '总金额',
  PRIMARY KEY (`i_partsId`),
  KEY `FK_incomingPartsInfo_i_incomingPartsId` (`i_incomingPartsId`),
  KEY `FK_incomingPartsInfo_i_querytheWarehouseId` (`i_querytheWarehouseId`),
  CONSTRAINT `FK_incomingPartsInfo_i_querytheWarehouseId` FOREIGN KEY (`i_querytheWarehouseId`) REFERENCES `querythewarehouse` (`q_id`),
  CONSTRAINT `FK_incomingPartsInfo_i_incomingPartsId` FOREIGN KEY (`i_incomingPartsId`) REFERENCES `incomingparts` (`i_partsId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of incomingpartsinfo
-- ----------------------------
INSERT INTO `incomingpartsinfo` VALUES ('1', '2', '4', '1', '5000');
INSERT INTO `incomingpartsinfo` VALUES ('2', '2', '4', '1', '5000');
INSERT INTO `incomingpartsinfo` VALUES ('3', '2', '4', '1', '5000');
INSERT INTO `incomingpartsinfo` VALUES ('4', '2', '4', '1', '5000');
INSERT INTO `incomingpartsinfo` VALUES ('5', '2', '4', '1', '5000');
INSERT INTO `incomingpartsinfo` VALUES ('6', '2', '4', '1', '5000');
INSERT INTO `incomingpartsinfo` VALUES ('7', '10', '1', '1', '8888');
INSERT INTO `incomingpartsinfo` VALUES ('8', '11', '12', '5', '5000');
INSERT INTO `incomingpartsinfo` VALUES ('9', '12', '7', '1111', '888800');

-- ----------------------------
-- Table structure for largeservicetype
-- ----------------------------
DROP TABLE IF EXISTS `largeservicetype`;
CREATE TABLE `largeservicetype` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT,
  `lst_name` varchar(50) NOT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of largeservicetype
-- ----------------------------
INSERT INTO `largeservicetype` VALUES ('3', '汽车美容');
INSERT INTO `largeservicetype` VALUES ('4', '汽车修理');
INSERT INTO `largeservicetype` VALUES ('5', '汽车改装');

-- ----------------------------
-- Table structure for maintenancerecord
-- ----------------------------
DROP TABLE IF EXISTS `maintenancerecord`;
CREATE TABLE `maintenancerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `o_id` int(11) NOT NULL,
  `Begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `S_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of maintenancerecord
-- ----------------------------
INSERT INTO `maintenancerecord` VALUES ('1', '1', '2019-04-16 08:00:09', null, '2');
INSERT INTO `maintenancerecord` VALUES ('2', '1', '2019-04-16 08:04:53', null, '2');
INSERT INTO `maintenancerecord` VALUES ('3', '1', '2019-04-16 08:31:37', null, '2');
INSERT INTO `maintenancerecord` VALUES ('4', '4', '2019-04-17 11:30:27', null, '2');
INSERT INTO `maintenancerecord` VALUES ('5', '6', '2019-04-17 11:33:02', null, '5');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `msgId` int(20) NOT NULL AUTO_INCREMENT,
  `userface` varchar(50) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `userAsk` varchar(200) NOT NULL,
  `askTime` datetime NOT NULL,
  `email` varchar(50) NOT NULL,
  `msgReply` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`msgId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('15', null, '小王', '你好啊', '2019-04-17 10:16:11', '2671412803@qq.com', null);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `ramart` varchar(200) NOT NULL,
  `r_time` datetime NOT NULL,
  `s_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `out_id` int(11) DEFAULT NULL,
  `user_id` int(50) NOT NULL,
  `sta_id` int(50) NOT NULL,
  `service_type` int(11) NOT NULL,
  `discount` double(50,0) NOT NULL,
  `l_price` double(50,0) DEFAULT NULL,
  `pay_type` varchar(50) NOT NULL,
  `order_state` varchar(50) NOT NULL,
  `service_way` varchar(50) NOT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orders_out_id` (`out_id`),
  KEY `FK_orders_user_id` (`user_id`),
  CONSTRAINT `FK_orders_user_id` FOREIGN KEY (`user_id`) REFERENCES `userinfo` (`us_id`),
  CONSTRAINT `FK_orders_out_id` FOREIGN KEY (`out_id`) REFERENCES `outboundparts` (`o_outboundId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', null, '1', '1', '2', '9', null, '现金', '未付款', '上门服务', 'kjnjnknjknjk');
INSERT INTO `orders` VALUES ('4', null, '1', '1', '4', '9', null, '微信', '未付款', '在店服务', '第一次来嘛');
INSERT INTO `orders` VALUES ('5', null, '1', '1', '3', '9', null, '现金', '未付款', '在店服务', '打折了');
INSERT INTO `orders` VALUES ('6', null, '1', '4', '3', '8', null, '支付宝', '未付款', '在店服务', '老客户');

-- ----------------------------
-- Table structure for outboundparts
-- ----------------------------
DROP TABLE IF EXISTS `outboundparts`;
CREATE TABLE `outboundparts` (
  `o_outboundId` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库ID',
  `o_title` varchar(100) NOT NULL COMMENT '出库标题',
  `o_time` datetime NOT NULL COMMENT '出库时间',
  `o_cause` varchar(255) NOT NULL COMMENT '出库原因',
  `o_personnel` varchar(255) NOT NULL COMMENT '出库人员',
  `o_manager` varchar(255) NOT NULL COMMENT '仓库管理人员',
  PRIMARY KEY (`o_outboundId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outboundparts
-- ----------------------------
INSERT INTO `outboundparts` VALUES ('1', '维修', '2019-04-30 13:57:55', '维修汽车', '陈林', 'admin');
INSERT INTO `outboundparts` VALUES ('2', '大修', '2019-04-30 13:57:55', '大修汽车', '张三', 'admin');
INSERT INTO `outboundparts` VALUES ('3', '小修', '2019-04-30 13:57:55', '小修汽车', '李四', 'admin');
INSERT INTO `outboundparts` VALUES ('4', 's ', '2019-04-16 20:24:06', '1', '1', '1');
INSERT INTO `outboundparts` VALUES ('5', '1', '2019-04-30 20:24:25', '1', '1', '1');
INSERT INTO `outboundparts` VALUES ('6', '客户维修', '2019-04-17 11:24:19', '客户车子坏了', '陈某人', '陈某人');
INSERT INTO `outboundparts` VALUES ('7', '1', '2019-04-17 19:18:26', 's ', 's ', 's ');

-- ----------------------------
-- Table structure for outboundpartsinfo
-- ----------------------------
DROP TABLE IF EXISTS `outboundpartsinfo`;
CREATE TABLE `outboundpartsinfo` (
  `o_ouId` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库ID',
  `o_partsId2` int(11) NOT NULL COMMENT '配件出库ID,外键',
  `o_querytheWarehouseId2` int(11) NOT NULL COMMENT '配件基本信息ID,外键',
  `o_number` int(11) NOT NULL COMMENT '出库数量',
  `o_totalPrice` decimal(10,0) NOT NULL COMMENT '总金额',
  PRIMARY KEY (`o_ouId`),
  KEY `FK_outboundParts_o_partsId2` (`o_partsId2`),
  KEY `FK_outboundParts_o_querytheWarehouseId2` (`o_querytheWarehouseId2`),
  CONSTRAINT `FK_outboundParts_o_querytheWarehouseId2` FOREIGN KEY (`o_querytheWarehouseId2`) REFERENCES `querythewarehouse` (`q_id`),
  CONSTRAINT `FK_outboundParts_o_partsId2` FOREIGN KEY (`o_partsId2`) REFERENCES `outboundparts` (`o_outboundId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outboundpartsinfo
-- ----------------------------
INSERT INTO `outboundpartsinfo` VALUES ('1', '1', '1', '1', '9999');
INSERT INTO `outboundpartsinfo` VALUES ('2', '2', '2', '2', '9999');
INSERT INTO `outboundpartsinfo` VALUES ('3', '3', '3', '3', '9999');
INSERT INTO `outboundpartsinfo` VALUES ('4', '4', '6', '1', '138');
INSERT INTO `outboundpartsinfo` VALUES ('5', '5', '1', '10', '188880');
INSERT INTO `outboundpartsinfo` VALUES ('6', '6', '1', '1', '18888');
INSERT INTO `outboundpartsinfo` VALUES ('7', '7', '7', '25', '34700');

-- ----------------------------
-- Table structure for postinfo
-- ----------------------------
DROP TABLE IF EXISTS `postinfo`;
CREATE TABLE `postinfo` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_name` varchar(50) NOT NULL,
  `p_bId` int(11) NOT NULL,
  `p_remark` varchar(100) DEFAULT NULL,
  `p_usable` int(11) DEFAULT '1',
  PRIMARY KEY (`post_id`),
  KEY `p_bId` (`p_bId`),
  CONSTRAINT `p_bId` FOREIGN KEY (`p_bId`) REFERENCES `branch` (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of postinfo
-- ----------------------------
INSERT INTO `postinfo` VALUES ('1', '技术经理', '1', '物流管理哟', '1');
INSERT INTO `postinfo` VALUES ('2', '技术组长', '1', '物流管理哟', '1');
INSERT INTO `postinfo` VALUES ('3', '程序员', '1', '物流管理哟', '1');
INSERT INTO `postinfo` VALUES ('4', '后勤总管', '2', '物流管理哟', '1');
INSERT INTO `postinfo` VALUES ('5', '后勤人员', '2', '物流管理哟', '1');
INSERT INTO `postinfo` VALUES ('6', '财务经理', '3', '物流管理哟', '1');
INSERT INTO `postinfo` VALUES ('7', '财务组长', '3', '物流管理哟', '1');
INSERT INTO `postinfo` VALUES ('8', '大堂经理', '4', '物流管理哟', '1');
INSERT INTO `postinfo` VALUES ('9', '人事经理', '5', '物流管理哟', '1');
INSERT INTO `postinfo` VALUES ('10', '安全组长', '6', '负责管理安全人员哟', '0');

-- ----------------------------
-- Table structure for querythewarehouse
-- ----------------------------
DROP TABLE IF EXISTS `querythewarehouse`;
CREATE TABLE `querythewarehouse` (
  `q_id` int(11) NOT NULL AUTO_INCREMENT,
  `q_vehicleBrand` varchar(20) NOT NULL COMMENT '车型',
  `q_partsImg` varchar(255) NOT NULL COMMENT '配件图片（地址）',
  `q_partsName` varchar(20) NOT NULL COMMENT '配件名称',
  `q_partBrand` varchar(255) NOT NULL COMMENT '配件品牌',
  `q_number` int(11) NOT NULL COMMENT '数量',
  `q_unit` varchar(5) NOT NULL COMMENT '单位',
  `q_partType` varchar(255) NOT NULL COMMENT '配件型号',
  `q_partEffect` varchar(255) NOT NULL COMMENT '配件作用',
  `q_buyingRate` decimal(10,2) NOT NULL COMMENT '配件进价',
  `q_sellingPrice` decimal(10,2) NOT NULL COMMENT '售价',
  `q_noFollow` int(11) NOT NULL COMMENT '是否需要，1为需要，2为不需要',
  PRIMARY KEY (`q_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of querythewarehouse
-- ----------------------------
INSERT INTO `querythewarehouse` VALUES ('1', '宝马3系', 'fadongji.png', '发动机', '宝马牌', '0', '维修部', 'FDJ_BWM', '发动汽车', '8888.00', '18888.00', '2');
INSERT INTO `querythewarehouse` VALUES ('2', '奥迪全系', 'fangxiangpan.png', '方向盘', '奥迪牌', '1', '维修部', 'FXP_AD', '转弯', '88.00', '188.00', '2');
INSERT INTO `querythewarehouse` VALUES ('3', '保时捷', 'houshijing.png', '后视镜', '保时捷牌', '25', '维修部', 'HSJ_BS', '后视', '800.00', '1388.00', '2');
INSERT INTO `querythewarehouse` VALUES ('4', '宝骏B5', 'luntaiwaiquan.png', '轮胎外圈', '宝骏牌', '3', '维修部', 'LTWQ_BJ', '装钢圈', '888.00', '1999.00', '1');
INSERT INTO `querythewarehouse` VALUES ('5', '大众凌渡', 'gangquan.png', '钢圈', '大众牌', '4', '维修部', 'LTGQ_DZ', '套轮胎', '1000.00', '3000.00', '1');
INSERT INTO `querythewarehouse` VALUES ('6', '起亚K3', 'fangxiangpanqiya.png', '方向盘', '福特牌', '1', '维修部', 'FXP_QY', '转弯', '65.00', '138.00', '1');
INSERT INTO `querythewarehouse` VALUES ('7', '保时捷', 'houshijing.png', '后视镜', '保时捷', '1111', '维修部', 'HSJ_BS', '后视', '800.00', '1388.00', '1');
INSERT INTO `querythewarehouse` VALUES ('8', '宝骏B5', 'luntaiwaiquan.png', '好轮胎', '宝骏牌', '3', '维修部', 'LTWQ_BJ', '装钢圈', '888.00', '1999.00', '1');
INSERT INTO `querythewarehouse` VALUES ('9', '大众凌渡', 'gangquan.png', '钢圈', '大众牌', '4', '维修部', 'LTGQ_DZ', '套轮胎', '1000.00', '3000.00', '1');
INSERT INTO `querythewarehouse` VALUES ('10', '宝马3系', 'fadongji.png', '发动机', '宝马牌', '10', '维修部', 'FDJ_BWM', '发动汽车', '8888.00', '18888.00', '1');
INSERT INTO `querythewarehouse` VALUES ('11', '1', 'Penguins.jpg', '1', '1', '0', '1', '1', '1', '1.00', '1.00', '2');
INSERT INTO `querythewarehouse` VALUES ('12', '奔驰', 'Koala.jpg', '油箱', '奔驰牌', '5', '维修', 'BENCHI_YX', '防漏油', '1000.00', '10000.00', '1');
INSERT INTO `querythewarehouse` VALUES ('13', '魔鬼秀儿', 'Tulips.jpg', '魔鬼秀儿', '魔鬼秀儿', '0', '魔鬼秀儿', '魔鬼秀儿', '魔鬼秀儿', '1111.00', '1111.00', '1');

-- ----------------------------
-- Table structure for recruit
-- ----------------------------
DROP TABLE IF EXISTS `recruit`;
CREATE TABLE `recruit` (
  `reId` int(20) NOT NULL AUTO_INCREMENT,
  `post_id` int(20) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `sum` int(20) DEFAULT NULL,
  `b_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`reId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruit
-- ----------------------------
INSERT INTO `recruit` VALUES ('1', '1', '2019-04-10 00:00:00', '2019-04-12 00:00:00', '5', '1');
INSERT INTO `recruit` VALUES ('2', '1', '2019-01-12 00:00:00', '2019-05-12 00:00:00', '4', '1');
INSERT INTO `recruit` VALUES ('3', '1', '2012-04-10 00:00:00', '2012-04-11 00:00:00', '3', '1');
INSERT INTO `recruit` VALUES ('4', '1', '2019-04-17 00:00:00', '2019-04-17 00:00:00', '1', '1');
INSERT INTO `recruit` VALUES ('5', '5', '2019-04-17 00:00:00', '2019-05-17 00:00:00', '10', '5');

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `r_id` int(10) NOT NULL AUTO_INCREMENT,
  `r_name` varchar(20) NOT NULL,
  `r_pwd` varchar(20) NOT NULL,
  `r_qq` varchar(20) DEFAULT NULL,
  `r_phone` varchar(20) NOT NULL,
  PRIMARY KEY (`r_id`),
  UNIQUE KEY `r_id` (`r_id`),
  UNIQUE KEY `UQ_register_r_phone` (`r_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------
INSERT INTO `register` VALUES ('1', 'admain', '123456', null, '13595594303');

-- ----------------------------
-- Table structure for smallservicetypes
-- ----------------------------
DROP TABLE IF EXISTS `smallservicetypes`;
CREATE TABLE `smallservicetypes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sst_name` varchar(50) NOT NULL,
  `lst_id` int(11) NOT NULL,
  `sst_price` decimal(10,2) NOT NULL,
  `sst_remarks` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of smallservicetypes
-- ----------------------------
INSERT INTO `smallservicetypes` VALUES ('3', '洗车', '3', '20.00', '看情况收费');
INSERT INTO `smallservicetypes` VALUES ('4', '抛光', '3', '50.00', '按材料收费');
INSERT INTO `smallservicetypes` VALUES ('5', '增加尾翼', '5', '300.00', '比较帅');

-- ----------------------------
-- Table structure for sta_staffss
-- ----------------------------
DROP TABLE IF EXISTS `sta_staffss`;
CREATE TABLE `sta_staffss` (
  `S_id` int(11) NOT NULL AUTO_INCREMENT,
  `S_name` varchar(255) DEFAULT NULL,
  `S_sex` varchar(255) DEFAULT NULL,
  `S_birthday` varchar(255) DEFAULT NULL,
  `S_phone` varchar(255) DEFAULT NULL,
  `S_logname` varchar(255) DEFAULT NULL,
  `S_pwdss` varchar(255) DEFAULT NULL,
  `S_entrytime` varchar(255) DEFAULT NULL,
  `S_postss` int(11) DEFAULT NULL,
  `S_present` varchar(255) DEFAULT NULL,
  `S_natio` varchar(255) DEFAULT NULL,
  `S_place` varchar(255) DEFAULT NULL,
  `S_blood` varchar(255) DEFAULT NULL,
  `S_idcate` varchar(255) DEFAULT NULL,
  `S_marital` varchar(255) DEFAULT NULL,
  `S_politics` varchar(255) DEFAULT NULL,
  `S_maxeducation` varchar(255) DEFAULT NULL,
  `S_maxdegree` varchar(255) DEFAULT NULL,
  `S_Email` varchar(255) DEFAULT NULL,
  `S_emIP` varchar(255) DEFAULT NULL,
  `S_Englist` varchar(255) DEFAULT NULL,
  `S_computer` varchar(255) DEFAULT NULL,
  `S_img` varchar(255) DEFAULT NULL,
  `s_usable` int(11) DEFAULT '1',
  PRIMARY KEY (`S_id`),
  KEY `F_keys` (`S_postss`),
  CONSTRAINT `F_keys` FOREIGN KEY (`S_postss`) REFERENCES `postinfo` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sta_staffss
-- ----------------------------
INSERT INTO `sta_staffss` VALUES ('1', '张三', '男', '1999-12-28 ', '12345678911', '登录名', '密码', '2018-02-03', '1', '遵义', '汉族', '柳州', 'b型', '520203199211141234', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', 'null', '1');
INSERT INTO `sta_staffss` VALUES ('2', '李四', '男', '2019-02-05', '12345678911', '登录名', '密码', '2019-04-01 ', '2', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', 'a', '1');
INSERT INTO `sta_staffss` VALUES ('3', '王五', '女', '2019-03-05', '12345678911', '登录名', '密码', '2019-04-01 ', '3', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', 'a', '1');
INSERT INTO `sta_staffss` VALUES ('4', '赵六', '女', '2019-04-09 ', '12345678911', '登录名', '密码', '2019-04-01 ', '5', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', null, '1');
INSERT INTO `sta_staffss` VALUES ('5', '前期', '女', '2019-04-09 ', '12345678911', '登录名', '密码', '2019-04-01 ', '6', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', null, '1');
INSERT INTO `sta_staffss` VALUES ('6', '斐济', '女', '2019-04-09 ', '12345678911', '登录名', '密码', '2019-04-01 ', '6', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', null, '1');
INSERT INTO `sta_staffss` VALUES ('7', '哈吉', '女', '2019-04-09 ', '12345678911', '登录名', '密码', '2019-04-01 ', '7', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', null, '1');
INSERT INTO `sta_staffss` VALUES ('8', '南极', '女', '2019-04-09 ', '12345678911', '登录名', '密码', '2019-04-01 ', '8', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', null, '1');
INSERT INTO `sta_staffss` VALUES ('9', '护肤季 ', '女', '2019-04-09 ', '12345678911', '登录名', '密码', '2019-04-01 ', '9', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', null, '1');
INSERT INTO `sta_staffss` VALUES ('10', '哈哈 ', '女', '2019-04-09 ', '12345678911', '登录名', '密码', '2019-04-01 ', '6', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', null, '1');
INSERT INTO `sta_staffss` VALUES ('11', '恐怕 ', '女', '2019-04-09 ', '12345678911', '登录名', '密码', '2019-04-01 ', '2', '遵义', '汉族', '柳州', 'b型', '520203199211141234 ', '未婚', '群众', '本科', '博士', '123@qq.com', '123456789', '4级', '3级', null, '1');
INSERT INTO `sta_staffss` VALUES ('12', '麻仁', '男', '2019-04-11', '123456789', 'haha123456', 'e10adc3949ba59abbe56e057f20f883e', '2016-04-19', '4', '遵义', '贵族', '中国', 'A型', '520203177711272811', '未婚', '党员', '本科', '硕士', '123456@qq.com', '12345678911', '3级', '2级', 'a', '1');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `us_id` int(10) NOT NULL AUTO_INCREMENT,
  `us_name` varchar(20) NOT NULL,
  `us_sex` varchar(20) NOT NULL,
  `us_idcate` varchar(20) NOT NULL,
  `us_years` datetime DEFAULT NULL,
  `us_phone` varchar(11) DEFAULT NULL,
  `us_present` varchar(100) DEFAULT NULL,
  `us_Email` varchar(100) NOT NULL,
  PRIMARY KEY (`us_id`),
  UNIQUE KEY `us_id` (`us_id`),
  UNIQUE KEY `UQ_userinfo_us_phone` (`us_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '田七', '男', '22523484801988464160', '1999-04-15 17:43:04', '13546486435', '贵阳', '136@qq.com');
INSERT INTO `userinfo` VALUES ('2', '黑吧八', '女', '22523484801996091800', '1988-04-15 17:43:49', '14785236998', '遵义', '225@qq.com');

-- ----------------------------
-- Table structure for usermessage
-- ----------------------------
DROP TABLE IF EXISTS `usermessage`;
CREATE TABLE `usermessage` (
  `userId` int(20) NOT NULL AUTO_INCREMENT,
  `msgId` int(20) NOT NULL,
  `userface` varchar(50) DEFAULT NULL,
  `userName` varchar(50) NOT NULL,
  `userAsk` varchar(200) NOT NULL,
  `askTime` datetime NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `FK_usermessage_ID_msgId` (`msgId`),
  CONSTRAINT `FK_usermessage_ID_msgId` FOREIGN KEY (`msgId`) REFERENCES `message` (`msgId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usermessage
-- ----------------------------
