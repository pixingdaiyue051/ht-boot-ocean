/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1_mysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 127.0.0.1:3306
 Source Schema         : local_demo

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 23/11/2020 13:01:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `area_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `priority` int NOT NULL DEFAULT 0,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES (73, 'test-2', 4, '2020-11-16 10:29:53', '2020-11-16 10:29:53');
INSERT INTO `tb_area` VALUES (74, 'test-2', 4, '2020-11-16 10:29:53', '2020-11-16 10:29:53');
INSERT INTO `tb_area` VALUES (75, 'test-2', 4, '2020-11-16 16:40:46', '2020-11-16 16:40:46');
INSERT INTO `tb_area` VALUES (76, 'test-2', 4, '2020-11-16 16:40:46', '2020-11-16 16:40:46');

-- ----------------------------
-- Table structure for um_data_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `um_data_dictionary`;
CREATE TABLE `um_data_dictionary`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类别编码',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '类别名称',
  `value_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '值编码',
  `value_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '值名称',
  `compare_value` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '比较字段(待使用)',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1354 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of um_data_dictionary
-- ----------------------------
INSERT INTO `um_data_dictionary` VALUES (1, 'JHFL', '计划分类', '11', '小五金杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (2, 'JHFL', '计划分类', '09', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (3, 'JHFL', '计划分类', '06', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (4, 'JHFL', '计划分类', '05', '化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (5, 'JHFL', '计划分类', '07', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (6, 'JHFL', '计划分类', '14', '网络乙烯绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (7, 'JHFL', '计划分类', '15', '大小绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (8, 'JHFL', '计划分类', '08', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (9, 'JHFL', '计划分类', '10', '工具设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (10, 'JHFL', '计划分类', '04', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (11, 'JHFL', '计划分类', '16', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (12, 'JHFL', '计划分类', '12', '加固材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (13, 'JHFL', '计划分类', '01', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (14, 'JHFL', '计划分类', '03', '港机电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (15, 'JHFL', '计划分类', '13', '蓬布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (16, 'JHFL', '计划分类', '17', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (17, 'JHFL', '计划分类', '18', '缝包机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (18, 'JHFL', '计划分类', '19', '卫生保洁', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (19, 'JHFL', '计划分类', '20', '消防', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (20, 'JHFL', '计划分类', '21', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (21, 'JHFL', '计划分类', '22', '办公用品―-印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (22, 'JHFL', '计划分类', '23', '办公用品―-低值易耗', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (23, 'JHFL', '计划分类', '24', '信息化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (24, 'JHFL', '计划分类', '25', '宣教', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (25, 'JHFL', '计划分类', '09', '固定办公物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (26, 'JHFL', '计划分类', '10', '分公司维修装修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (27, 'JHFL', '计划分类', '05', '混凝土生产材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (28, 'JHFL', '计划分类', '04', '工程---电气材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (29, 'JHFL', '计划分类', '03', '工程---水暖材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (30, 'JHFL', '计划分类', '02', '工程---装修材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (31, 'JHFL', '计划分类', '01', '工程---土建材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (32, 'JHFL', '计划分类', '07', '连锁块生产材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (33, 'JHFL', '计划分类', '08', '日常办公物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (34, 'JHFL', '计划分类', '06', '备品配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (35, 'JHFL', '计划分类', '11', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (36, 'JHFL', '计划分类', '12', '工程---设备（外付款', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (37, 'JHFL', '计划分类', 'XX', '信息化用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (38, 'JHFL', '计划分类', 'SG', '设备维护_钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (39, 'JHFL', '计划分类', 'SL', '设备维护_轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (40, 'JHFL', '计划分类', 'SR', '设备维护_润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (41, 'JHFL', '计划分类', 'SP', '设备维护_电瓶', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (42, 'JHFL', '计划分类', 'SJ', '设备维护_机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (43, 'JHFL', '计划分类', 'SP', '设备维护_电器配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (44, 'JHFL', '计划分类', 'SD', '设备维护_大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (45, 'JHFL', '计划分类', 'SX', '设备维护_小五金杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (46, 'JHFL', '计划分类', 'SY', '设备维护_油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (47, 'JHFL', '计划分类', 'SQ', '设备维护_其它', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (48, 'JHFL', '计划分类', 'RD', '日常消耗_大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (49, 'JHFL', '计划分类', 'RX', '日常消耗_小五金杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (50, 'JHFL', '计划分类', 'RJ', '日常消耗_建材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (51, 'JHFL', '计划分类', 'RP', '日常消耗_篷布网络', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (52, 'JHFL', '计划分类', 'RG', '日常消耗_工具备品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (53, 'JHFL', '计划分类', 'RL', '日常消耗_劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (54, 'JHFL', '计划分类', 'RB', '日常消耗_办公', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (55, 'JHFL', '计划分类', 'RQ', '日常消耗_其它', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (56, 'JHFL', '计划分类', 'RD', '日常消耗_大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (57, 'JHFL', '计划分类', 'RX', '日常消耗_小五金杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (58, 'JHFL', '计划分类', 'RJ', '日常消耗_建材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (59, 'JHFL', '计划分类', 'RP', '日常消耗_篷布网络', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (60, 'JHFL', '计划分类', 'RG', '日常消耗_工具备品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (61, 'JHFL', '计划分类', 'RL', '日常消耗_劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (62, 'JHFL', '计划分类', 'RB', '日常消耗_办公', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (63, 'JHFL', '计划分类', 'RQ', '日常消耗_其它', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (64, 'JHFL', '计划分类', 'SG', '设备维护_钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (65, 'JHFL', '计划分类', 'SC', '设备维护_输送带', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (66, 'JHFL', '计划分类', 'SR', '设备维护_润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (67, 'JHFL', '计划分类', 'SP', '设备维护_电瓶', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (68, 'JHFL', '计划分类', 'SJ', '设备维护_机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (69, 'JHFL', '计划分类', 'SL', '设备维护_电器配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (70, 'JHFL', '计划分类', 'SD', '设备维护_大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (71, 'JHFL', '计划分类', 'SX', '设备维护_小五金杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (72, 'JHFL', '计划分类', 'SY', '设备维护_油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (73, 'JHFL', '计划分类', 'SQ', '设备维护_其它', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (74, 'JHFL', '计划分类', 'SP', '食品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (75, 'JHFL', '计划分类', '26', '食品蔬菜', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (76, 'JHFL', '计划分类', 'YH', '怡之航冷库', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (77, 'JHFL', '计划分类', '', '设备材料 ', 0, '2019-05-18 12:17:06', '2019-06-02 10:38:58');
INSERT INTO `um_data_dictionary` VALUES (78, 'JHFL', '计划分类', '', '信息化', 0, '2019-05-18 12:17:06', '2019-06-02 10:38:58');
INSERT INTO `um_data_dictionary` VALUES (79, 'JHFL', '计划分类', '', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:38:58');
INSERT INTO `um_data_dictionary` VALUES (80, 'JHFL', '计划分类', '', '', 0, '2019-05-18 12:17:06', '2019-06-02 10:39:09');
INSERT INTO `um_data_dictionary` VALUES (81, 'JHFL', '计划分类', '01', '现场作业组', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (82, 'JHFL', '计划分类', '02', '设备设施组王连德', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (83, 'JHFL', '计划分类', '03', '客服计划组', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (84, 'JHFL', '计划分类', '04', '安全监管组', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (85, 'JHFL', '计划分类', '05', '办公室', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (86, 'JHFL', '计划分类', '06', '财务部', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (87, 'JHFL', '计划分类', '07', '青岛库', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (88, 'JHFL', '计划分类', '08', '保税库', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (89, 'JHFL', '计划分类', '09', '设备设施组丁', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (90, 'JHFL', '计划分类', '27', '维修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (91, 'JHFL', '计划分类', '', '孙明森', 0, '2019-05-18 12:17:06', '2019-06-02 10:38:58');
INSERT INTO `um_data_dictionary` VALUES (92, 'JHFL', '计划分类', '王', '王洪林', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (93, 'JHFL', '计划分类', '28', '安全生产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (94, 'JHFL', '计划分类', '01', 'AGV', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (95, 'JHFL', '计划分类', '02', 'STS', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (96, 'JHFL', '计划分类', '03', 'ASC', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (97, 'JHFL', '计划分类', '04', '码头设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (98, 'JHFL', '计划分类', '05', '综合', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (99, 'JHFL', '计划分类', '06', '公共', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (100, 'CSZH', '传送账号', '0101', '港机分公司', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (101, 'CSZH', '传送账号', '18400', 'QQCTU', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (102, 'JHFL', '计划分类', '02', '港机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (103, 'CWLB', '财务类别', '98', '电脑', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (104, 'CWLB', '财务类别', 'gjpj', '固机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (105, 'CSZH', '传送账号', '18600', 'QQCTUA', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (106, 'CWLB', '财务类别', '900', '办', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (107, 'CWLB', '财务类别', '98', '电脑', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (108, 'CWLB', '财务类别', 'kkkj', '7788', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (109, 'JHFL', '计划分类', '01', '工程材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (110, 'JHFL', '计划分类', '02', '维修材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (111, 'JHFL', '计划分类', '03', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (112, 'JHFL', '计划分类', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (113, 'JHFL', '计划分类', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (114, 'JHFL', '计划分类', '08', '后勤材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (115, 'JHFL', '计划分类', 'RH', '润滑油品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (116, 'GZWP', '高值物品', '10901', '2000', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (117, 'JHFL', '计划分类', 'GS', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (118, 'JHFL', '计划分类', 'TG', '托辊', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (119, 'JHFL', '计划分类', 'LT', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (120, 'JHFL', '计划分类', 'CB', '衬板及加工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (121, 'JHFL', '计划分类', 'YQ', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (122, 'JHFL', '计划分类', 'ZC', '装载机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (123, 'JHFL', '计划分类', 'CL', '其他车辆配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (124, 'JHFL', '计划分类', 'JD', '机电配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (125, 'JHFL', '计划分类', 'WJ', '五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (126, 'JHFL', '计划分类', 'SJ', '属具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (127, 'JHFL', '计划分类', 'GC', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (128, 'JHFL', '计划分类', 'PD', '皮带', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (129, 'JHFL', '计划分类', 'JD', '交电', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (130, 'JHFL', '计划分类', 'TC', '土产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (131, 'JHFL', '计划分类', 'TL', '铁路器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (132, 'JHFL', '计划分类', 'XX', '信息化备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (133, 'JHFL', '计划分类', 'PJ', '设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (134, 'JHFL', '计划分类', 'GC', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (135, 'JHFL', '计划分类', 'GJ', '手持工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (136, 'JHFL', '计划分类', 'XF', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (137, 'JHFL', '计划分类', 'DQ', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (138, 'JHFL', '计划分类', 'YQ', '油漆涂料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (139, 'JHFL', '计划分类', 'TJ', '土建材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (140, 'JHFL', '计划分类', 'QT', '其他物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (141, 'JHFL', '计划分类', 'XC', '宣传材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (142, 'JHFL', '计划分类', 'JN', '礼品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (143, 'JHFL', '计划分类', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (144, 'JHFL', '计划分类', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (145, 'JHFL', '计划分类', 'DQ', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (146, 'JHFL', '计划分类', 'GC', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (147, 'JHFL', '计划分类', 'GJ', '手持工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (148, 'JHFL', '计划分类', 'LP', '礼品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (149, 'JHFL', '计划分类', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (150, 'JHFL', '计划分类', 'PJ', '设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (151, 'JHFL', '计划分类', 'TJ', '土建材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (152, 'JHFL', '计划分类', 'XC', '宣传材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (153, 'JHFL', '计划分类', 'XF', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (154, 'JHFL', '计划分类', 'YQ', '油漆材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (155, 'JHFL', '计划分类', 'QT', '其他物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (156, 'JHFL', '计划分类', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (157, 'JHFL', '计划分类', 'FM', '阀门', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (158, 'JHFL', '计划分类', 'FM', '阀门', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (159, 'JHFL', '计划分类', '04', '安全生产部（保税库）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (160, 'JHFL', '计划分类', '02', '安全生产部（青岛库）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (161, 'JHFL', '计划分类', '03', '业务部', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (162, 'JHFL', '计划分类', '01', '机关', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (163, 'JHFL', '计划分类', '06', '安全生产部（矿石）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (164, 'JHFL', '计划分类', 'XJ', '宣教、标识', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (165, 'JHFL', '计划分类', 'XF', '消防', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (166, 'JHFL', '计划分类', 'XD', '蓄电池', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (167, 'JHFL', '计划分类', 'GT', '滚筒', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (168, 'JHFL', '计划分类', 'BP', '备品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (169, 'JHFL', '计划分类', 'HG', '化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (170, 'JHFL', '计划分类', '15', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (171, 'JHFL', '计划分类', '01', '通信配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (172, 'JHFL', '计划分类', '02', '工程材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (173, 'JHFL', '计划分类', '03', '工程设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (174, 'JHFL', '计划分类', '04', '销售物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (175, 'JHFL', '计划分类', '05', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (176, 'JHFL', '计划分类', '06', '电脑及网络', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (177, 'JHFL', '计划分类', '07', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (178, 'JHFL', '计划分类', '08', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (179, 'JHFL', '计划分类', '09', '车辆配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (180, 'JHFL', '计划分类', '10', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (181, 'JHFL', '计划分类', 'DN', '电脑', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (182, 'JHFL', '计划分类', '11', '生产材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (183, 'JHFL', '计划分类', '', '港机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:38:58');
INSERT INTO `um_data_dictionary` VALUES (184, 'JHFL', '计划分类', '', '小五金杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:38:58');
INSERT INTO `um_data_dictionary` VALUES (185, 'JHFL', '计划分类', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (186, 'JHFL', '计划分类', '02', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (187, 'JHFL', '计划分类', '03', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (188, 'JHFL', '计划分类', '04', '其他物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (189, 'JHFL', '计划分类', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (190, 'JHFL', '计划分类', '05', '工会', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (191, 'GZWP', '高值物品', '10900', '10', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (192, 'JHFL', '计划分类', '', '', 0, '2019-05-18 12:17:06', '2019-06-02 10:39:09');
INSERT INTO `um_data_dictionary` VALUES (193, 'RKLB', '入库类别', '01', '采购入库', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (194, 'RKLB', '入库类别', '04', '自购入库', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (195, 'CWLB', '财务类别', '001', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (196, 'CWLB', '财务类别', '002', '港机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (197, 'CWLB', '财务类别', '003', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (198, 'CWLB', '财务类别', '004', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (199, 'CWLB', '财务类别', '005', '化工制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (200, 'CWLB', '财务类别', '006', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (201, 'CWLB', '财务类别', '007', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (202, 'CWLB', '财务类别', '008', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (203, 'CWLB', '财务类别', '009', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (204, 'CWLB', '财务类别', '010', '刀具、量具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (205, 'CWLB', '财务类别', '011', '五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (206, 'CWLB', '财务类别', '012', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (207, 'CWLB', '财务类别', '013', '篷布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (208, 'CWLB', '财务类别', '014', '网络', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (209, 'CWLB', '财务类别', '015', '大小绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (210, 'CWLB', '财务类别', '016', '普通电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (211, 'CWLB', '财务类别', '017', '乙烯绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (212, 'CWLB', '财务类别', '018', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (213, 'CWLB', '财务类别', '019', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (214, 'CWLB', '财务类别', '020', '蓄电池', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (215, 'CWLB', '财务类别', '021', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (216, 'CWLB', '财务类别', '022', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (217, 'CWLB', '财务类别', '023', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (218, 'CWLB', '财务类别', '024', '建材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (219, 'CWLB', '财务类别', '025', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (220, 'CWLB', '财务类别', '026', '水暖件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (221, 'CWLB', '财务类别', '027', '微机耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (222, 'CWLB', '财务类别', '028', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (223, 'CWLB', '财务类别', '099', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (224, 'CWLB', '财务类别', '30', '自动化设备耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (225, 'CWLB', '财务类别', '０', '其他物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (226, 'CWLB', '财务类别', '01', '机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (227, 'CWLB', '财务类别', '02', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (228, 'CWLB', '财务类别', '03', '土杂产品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (229, 'CWLB', '财务类别', '04', '电气配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (230, 'CWLB', '财务类别', '05', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (231, 'CWLB', '财务类别', '06', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (232, 'CWLB', '财务类别', '07', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (233, 'CWLB', '财务类别', '08', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (234, 'CWLB', '财务类别', '09', '通信设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (235, 'CWLB', '财务类别', '10', '信息化设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (236, 'CWLB', '财务类别', '11', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (237, 'CWLB', '财务类别', '12', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (238, 'CWLB', '财务类别', '13', '消防设施材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (239, 'CWLB', '财务类别', '14', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (240, 'CWLB', '财务类别', '15', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (241, 'CWLB', '财务类别', '16', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (242, 'CWLB', '财务类别', '17', '篷布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (243, 'CWLB', '财务类别', '18', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (244, 'CWLB', '财务类别', '19', '其他物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (245, 'CWLB', '财务类别', '20', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (246, 'CWLB', '财务类别', '21', '工程用料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (247, 'CWLB', '财务类别', '01', '办公', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (248, 'CWLB', '财务类别', '02', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (249, 'CWLB', '财务类别', '04', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (250, 'CWLB', '财务类别', '05', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (251, 'CWLB', '财务类别', '06', '电器类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (252, 'CWLB', '财务类别', '08', '设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (253, 'CWLB', '财务类别', '09', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (254, 'CWLB', '财务类别', '10', '其它物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (255, 'CWLB', '财务类别', '11', '宣传品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (256, 'CWLB', '财务类别', '13', '工属具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (257, 'CWLB', '财务类别', '14', '润滑', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (258, 'CWLB', '财务类别', '15', '油漆稀料类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (259, 'CWLB', '财务类别', '16', '消防器材类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (260, 'CWLB', '财务类别', '001', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (261, 'CWLB', '财务类别', '002', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (262, 'CWLB', '财务类别', '003', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (263, 'CWLB', '财务类别', '004', '拖车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (264, 'CWLB', '财务类别', '005', '叉车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (265, 'CWLB', '财务类别', '006', '油品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (266, 'CWLB', '财务类别', '007', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (267, 'CWLB', '财务类别', '008', '信息化设备及耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (268, 'CWLB', '财务类别', '009', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (269, 'CWLB', '财务类别', '01', '信息化耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (270, 'CWLB', '财务类别', '02', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (271, 'CWLB', '财务类别', '03', '机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (272, 'CWLB', '财务类别', '04', '信息化耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (273, 'CWLB', '财务类别', '05', '信息化耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (274, 'CWLB', '财务类别', '10', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (275, 'CWLB', '财务类别', '11', '液压管件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (276, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (277, 'CWLB', '财务类别', 'DL', '供电电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (278, 'CWLB', '财务类别', 'DP', '电瓶及附件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (279, 'CWLB', '财务类别', 'GC', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (280, 'CWLB', '财务类别', 'GS', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (281, 'CWLB', '财务类别', 'GSJ', '工属具、备品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (282, 'CWLB', '财务类别', 'HG', '胶料、化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (283, 'CWLB', '财务类别', 'JC', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (284, 'CWLB', '财务类别', 'JD', '交电', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (285, 'CWLB', '财务类别', 'JG', '机加工、衬板', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (286, 'CWLB', '财务类别', 'KDP', '矿电器配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (287, 'CWLB', '财务类别', 'KJP', '矿机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (288, 'CWLB', '财务类别', 'KPD', '矿皮带', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (289, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (290, 'CWLB', '财务类别', 'LT', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (291, 'CWLB', '财务类别', 'MDP', '煤电器配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (292, 'CWLB', '财务类别', 'MJP', '煤机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (293, 'CWLB', '财务类别', 'MPD', '煤皮带', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (294, 'CWLB', '财务类别', 'QC', '其他车辆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (295, 'CWLB', '财务类别', 'RH', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (296, 'CWLB', '财务类别', 'TC', '土产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (297, 'CWLB', '财务类别', 'TL', '铁路配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (298, 'CWLB', '财务类别', 'WJ', '五金、工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (299, 'CWLB', '财务类别', 'WX', '委外维修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (300, 'CWLB', '财务类别', 'XF', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (301, 'CWLB', '财务类别', 'XJ', '宣教用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (302, 'CWLB', '财务类别', 'YQ', '油漆、稀料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (303, 'CWLB', '财务类别', 'ZC', '轴承及座', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (304, 'CWLB', '财务类别', 'ZZJ', '装载机', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (305, 'CWLB', '财务类别', '01', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (306, 'CWLB', '财务类别', '02', '港机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (307, 'CWLB', '财务类别', '03', '港机电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (308, 'CWLB', '财务类别', '04', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (309, 'CWLB', '财务类别', '05', '化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (310, 'CWLB', '财务类别', '06', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (311, 'CWLB', '财务类别', '07', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (312, 'CWLB', '财务类别', '08', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (313, 'CWLB', '财务类别', '09', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (314, 'CWLB', '财务类别', '10', '工具设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (315, 'CWLB', '财务类别', '11', '小五金、杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (316, 'CWLB', '财务类别', '12', '加固材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (317, 'CWLB', '财务类别', '13', '篷布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (318, 'CWLB', '财务类别', '14', '网络、乙烯绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (319, 'CWLB', '财务类别', '15', '大小绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (320, 'CWLB', '财务类别', '16', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (321, 'CWLB', '财务类别', '17', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (322, 'CWLB', '财务类别', '18', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (323, 'CWLB', '财务类别', '19', '信息化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (324, 'CWLB', '财务类别', '20', '防疫保洁', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (325, 'CWLB', '财务类别', '21', '警卫消防', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (326, 'CWLB', '财务类别', '22', '宣教用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (327, 'CWLB', '财务类别', '1', '危险品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (328, 'CWLB', '财务类别', '10', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (329, 'CWLB', '财务类别', '11', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (330, 'CWLB', '财务类别', '12', '机修设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (331, 'CWLB', '财务类别', '13', '油化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (332, 'CWLB', '财务类别', '14', '化工材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (333, 'CWLB', '财务类别', '15', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (334, 'CWLB', '财务类别', '16', '外协件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (335, 'CWLB', '财务类别', '17', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (336, 'CWLB', '财务类别', '18', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (337, 'CWLB', '财务类别', '19', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (338, 'CWLB', '财务类别', '2', '五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (339, 'CWLB', '财务类别', '20', '船用配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (340, 'CWLB', '财务类别', '21', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (341, 'CWLB', '财务类别', '22', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (342, 'CWLB', '财务类别', '23', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (343, 'CWLB', '财务类别', '24', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (344, 'CWLB', '财务类别', '25', '通讯设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (345, 'CWLB', '财务类别', '26', '通用机电配套产品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (346, 'CWLB', '财务类别', '27', '电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (347, 'CWLB', '财务类别', '3', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (348, 'CWLB', '财务类别', '4', '黑色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (349, 'CWLB', '财务类别', '5', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (350, 'CWLB', '财务类别', '6', '有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (351, 'CWLB', '财务类别', '7', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (352, 'CWLB', '财务类别', '8', '管件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (353, 'CWLB', '财务类别', '9', '焊材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (354, 'CWLB', '财务类别', '1', '危险品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (355, 'CWLB', '财务类别', '10', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (356, 'CWLB', '财务类别', '11', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (357, 'CWLB', '财务类别', '12', '机修设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (358, 'CWLB', '财务类别', '13', '油化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (359, 'CWLB', '财务类别', '14', '化工材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (360, 'CWLB', '财务类别', '15', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (361, 'CWLB', '财务类别', '16', '外协件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (362, 'CWLB', '财务类别', '17', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (363, 'CWLB', '财务类别', '18', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (364, 'CWLB', '财务类别', '19', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (365, 'CWLB', '财务类别', '2', '五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (366, 'CWLB', '财务类别', '20', '船用配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (367, 'CWLB', '财务类别', '21', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (368, 'CWLB', '财务类别', '22', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (369, 'CWLB', '财务类别', '23', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (370, 'CWLB', '财务类别', '24', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (371, 'CWLB', '财务类别', '25', '通讯设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (372, 'CWLB', '财务类别', '26', '通用机电配套产品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (373, 'CWLB', '财务类别', '27', '电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (374, 'CWLB', '财务类别', '28', '锻件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (375, 'CWLB', '财务类别', '29', '铸件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (376, 'CWLB', '财务类别', '3', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (377, 'CWLB', '财务类别', '30', '黑色金属2', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (378, 'CWLB', '财务类别', '31', '电器2', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (379, 'CWLB', '财务类别', '33', 'W―危险品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (380, 'CWLB', '财务类别', '34', 'W―工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (381, 'CWLB', '财务类别', '35', 'W―五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (382, 'CWLB', '财务类别', '36', 'W―黑色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (383, 'CWLB', '财务类别', '37', 'W―焊材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (384, 'CWLB', '财务类别', '38', 'W―电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (385, 'CWLB', '财务类别', '39', 'W―轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (386, 'CWLB', '财务类别', '4', '黑色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (387, 'CWLB', '财务类别', '40', 'W―橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (388, 'CWLB', '财务类别', '41', 'W―办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (389, 'CWLB', '财务类别', '42', 'W―土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (390, 'CWLB', '财务类别', '43', 'W―劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (391, 'CWLB', '财务类别', '44', 'W―油化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (392, 'CWLB', '财务类别', '45', 'W―润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (393, 'CWLB', '财务类别', '46', 'W―有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (394, 'CWLB', '财务类别', '47', 'W―通用机电配套产品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (395, 'CWLB', '财务类别', '48', 'W―轮胎翻新', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (396, 'CWLB', '财务类别', '49', 'W―滚筒包胶', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (397, 'CWLB', '财务类别', '5', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (398, 'CWLB', '财务类别', '50', 'W―汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (399, 'CWLB', '财务类别', '51', 'W―液压管件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (400, 'CWLB', '财务类别', '52', '外协件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (401, 'CWLB', '财务类别', '53', 'W—托辊材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (402, 'CWLB', '财务类别', '6', '有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (403, 'CWLB', '财务类别', '7', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (404, 'CWLB', '财务类别', '8', '管件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (405, 'CWLB', '财务类别', '9', '焊材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (406, 'CWLB', '财务类别', '01', '生产材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (407, 'CWLB', '财务类别', '02', '工程材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (408, 'CWLB', '财务类别', '03', '工程设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (409, 'CWLB', '财务类别', '04', '销售物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (410, 'CWLB', '财务类别', '05', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (411, 'CWLB', '财务类别', '06', '车辆配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (412, 'CWLB', '财务类别', '07', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (413, 'CWLB', '财务类别', '08', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (414, 'CWLB', '财务类别', '09', '电脑及网络', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (415, 'CWLB', '财务类别', '10', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (416, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (417, 'CWLB', '财务类别', '02', '信息化设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (418, 'CWLB', '财务类别', '03', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (419, 'CWLB', '财务类别', '05', '车辆维修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (420, 'CWLB', '财务类别', '06', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (421, 'CWLB', '财务类别', '07', '劳动保护用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (422, 'CWLB', '财务类别', '08', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (423, 'CWLB', '财务类别', '09', '其他办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (424, 'CWLB', '财务类别', '01', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (425, 'CWLB', '财务类别', '02', '港机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (426, 'CWLB', '财务类别', '03', '港机电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (427, 'CWLB', '财务类别', '04', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (428, 'CWLB', '财务类别', '05', '化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (429, 'CWLB', '财务类别', '06', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (430, 'CWLB', '财务类别', '07', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (431, 'CWLB', '财务类别', '08', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (432, 'CWLB', '财务类别', '09', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (433, 'CWLB', '财务类别', '10', '工具设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (434, 'CWLB', '财务类别', '11', '小五金、杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (435, 'CWLB', '财务类别', '12', '加固材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (436, 'CWLB', '财务类别', '13', '篷布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (437, 'CWLB', '财务类别', '14', '网络、乙烯绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (438, 'CWLB', '财务类别', '15', '大小绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (439, 'CWLB', '财务类别', '16', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (440, 'CWLB', '财务类别', '17', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (441, 'CWLB', '财务类别', '18', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (442, 'CWLB', '财务类别', '19', '信息化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (443, 'CWLB', '财务类别', '20', '防疫保洁', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (444, 'CWLB', '财务类别', '21', '警卫消防', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (445, 'CWLB', '财务类别', '22', '宣教用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (446, 'CWLB', '财务类别', '23', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (447, 'CWLB', '财务类别', '24', '委外维修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (448, 'CWLB', '财务类别', '25', '安全管理', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (449, 'CWLB', '财务类别', '01', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (450, 'CWLB', '财务类别', '09', '建材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (451, 'CWLB', '财务类别', '1', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (452, 'CWLB', '财务类别', '10', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (453, 'CWLB', '财务类别', '11', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (454, 'CWLB', '财务类别', '12', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (455, 'CWLB', '财务类别', '13', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (456, 'CWLB', '财务类别', '14', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (457, 'CWLB', '财务类别', '15', '在产品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (458, 'CWLB', '财务类别', '16', '设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (459, 'CWLB', '财务类别', '17', '其它', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (460, 'CWLB', '财务类别', '18', '电缆 ', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (461, 'CWLB', '财务类别', '2', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (462, 'CWLB', '财务类别', '3', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (463, 'CWLB', '财务类别', '4', '配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (464, 'CWLB', '财务类别', '5', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (465, 'CWLB', '财务类别', '6', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (466, 'CWLB', '财务类别', '7', '皮带', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (467, 'CWLB', '财务类别', '8', '润滑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (468, 'CWLB', '财务类别', '9', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (469, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (470, 'CWLB', '财务类别', '02', '车辆配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (471, 'CWLB', '财务类别', '03', '微机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (472, 'CWLB', '财务类别', '04', '办公家具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (473, 'CWLB', '财务类别', '05', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (474, 'CWLB', '财务类别', '06', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (475, 'CWLB', '财务类别', '07', '维修材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (476, 'CWLB', '财务类别', '08', '材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (477, 'CWLB', '财务类别', '09', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (478, 'CWLB', '财务类别', '1', '135系列0204备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (479, 'CWLB', '财务类别', '10', '家用电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (480, 'CWLB', '财务类别', '11', '通讯导航', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (481, 'CWLB', '财务类别', '12', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (482, 'CWLB', '财务类别', '13', '办公设备及耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (483, 'CWLB', '财务类别', '14', '电瓶类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (484, 'CWLB', '财务类别', '15', '锚链及附件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (485, 'CWLB', '财务类别', '16', '缆绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (486, 'CWLB', '财务类别', '17', '消防救生', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (487, 'CWLB', '财务类别', '18', '橡塑石棉类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (488, 'CWLB', '财务类别', '19', '餐具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (489, 'CWLB', '财务类别', '2', '主机系列0204(国外备件)', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (490, 'CWLB', '财务类别', '20', '清洁用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (491, 'CWLB', '财务类别', '21', '卧具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (492, 'CWLB', '财务类别', '22', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (493, 'CWLB', '财务类别', '23', '淡水', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (494, 'CWLB', '财务类别', '24', '燃油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (495, 'CWLB', '财务类别', '25', '汽油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (496, 'CWLB', '财务类别', '26', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (497, 'CWLB', '财务类别', '27', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (498, 'CWLB', '财务类别', '28', '计算机', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (499, 'CWLB', '财务类别', '29', '空压机', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (500, 'CWLB', '财务类别', '3', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (501, 'CWLB', '财务类别', '30', '文化宣教类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (502, 'CWLB', '财务类别', '36', '主机系列(国产备件)', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (503, 'CWLB', '财务类别', '4', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (504, 'CWLB', '财务类别', '5', '碰垫', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (505, 'CWLB', '财务类别', '6', '油漆类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (506, 'CWLB', '财务类别', '7', '五金工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (507, 'CWLB', '财务类别', '8', '电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (508, 'CWLB', '财务类别', '9', '电工器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (509, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (510, 'CWLB', '财务类别', 'DQ', '通用电器件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (511, 'CWLB', '财务类别', 'GC', '黑色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (512, 'CWLB', '财务类别', 'GJ', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (513, 'CWLB', '财务类别', 'GS', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (514, 'CWLB', '财务类别', 'JC', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (515, 'CWLB', '财务类别', 'JS', '有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (516, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (517, 'CWLB', '财务类别', 'MS', '码头岸线设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (518, 'CWLB', '财务类别', 'PB', '船舶设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (519, 'CWLB', '财务类别', 'PC', '车辆配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (520, 'CWLB', '财务类别', 'PD', '电动装卸机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (521, 'CWLB', '财务类别', 'PF', '发动机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (522, 'CWLB', '财务类别', 'PG', '供电设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (523, 'CWLB', '财务类别', 'PJ', '机修设配配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (524, 'CWLB', '财务类别', 'PL', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (525, 'CWLB', '财务类别', 'PS', '港口施工机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (526, 'CWLB', '财务类别', 'PT', '通讯设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (527, 'CWLB', '财务类别', 'PU', '锅炉配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (528, 'CWLB', '财务类别', 'PX', '信息化设备及配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (529, 'CWLB', '财务类别', 'PZ', '自动化控制设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (530, 'CWLB', '财务类别', 'RH', '润滑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (531, 'CWLB', '财务类别', 'RL', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (532, 'CWLB', '财务类别', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (533, 'CWLB', '财务类别', 'TJ', '通用机械产品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (534, 'CWLB', '财务类别', 'TL', '铁路器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (535, 'CWLB', '财务类别', 'WJ', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (536, 'CWLB', '财务类别', 'XF', '消防设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (537, 'CWLB', '财务类别', 'XJ', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (538, 'CWLB', '财务类别', 'YB', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (539, 'CWLB', '财务类别', 'YH', '油漆化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (540, 'CWLB', '财务类别', 'ZC', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (541, 'CWLB', '财务类别', '01', '维修材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (542, 'CWLB', '财务类别', '02', '清洁用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (543, 'CWLB', '财务类别', '03', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (544, 'CWLB', '财务类别', '04', '印刷用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (545, 'CWLB', '财务类别', '05', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (546, 'CWLB', '财务类别', '06', '微机材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (547, 'CWLB', '财务类别', '07', '总务低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (548, 'CWLB', '财务类别', '08', '医用低值耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (549, 'CWLB', '财务类别', '09', '医用高值耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (550, 'CWLB', '财务类别', '10', '西药', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (551, 'CWLB', '财务类别', '11', '中药', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (552, 'CWLB', '财务类别', '12', '草药', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (553, 'CWLB', '财务类别', '001', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (554, 'CWLB', '财务类别', '002', '电缆电线', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (555, 'CWLB', '财务类别', '003', '电缆附件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (556, 'CWLB', '财务类别', '004', '电工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (557, 'CWLB', '财务类别', '005', '灯具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (558, 'CWLB', '财务类别', '006', '三类物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (559, 'CWLB', '财务类别', '007', '防爆类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (560, 'CWLB', '财务类别', '008', '紧固类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (561, 'CWLB', '财务类别', '009', '金属类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (562, 'CWLB', '财务类别', '01', '材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (563, 'CWLB', '财务类别', '010', '桥架类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (564, 'CWLB', '财务类别', '011', '仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (565, 'CWLB', '财务类别', '012', '油漆化工类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (566, 'CWLB', '财务类别', '013', '汽车类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (567, 'CWLB', '财务类别', '014', '设备类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (568, 'CWLB', '财务类别', '015', '二类电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (569, 'CWLB', '财务类别', '016', '办公用品.', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (570, 'CWLB', '财务类别', '02', '燃油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (571, 'CWLB', '财务类别', '04', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (572, 'CWLB', '财务类别', '05', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (573, 'CWLB', '财务类别', '06', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (574, 'CWLB', '财务类别', '08', '甲供材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (575, 'CWLB', '财务类别', '16', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (576, 'CWLB', '财务类别', '21', '委外维修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (577, 'CWLB', '财务类别', '22', '低值易耗品(劳保)', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (578, 'CWLB', '财务类别', '23', '低值易耗品（消防）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (579, 'CWLB', '财务类别', '24', '甲供调拨', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (580, 'CWLB', '财务类别', '01', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (581, 'CWLB', '财务类别', '02', '托辊材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (582, 'CWLB', '财务类别', '03', '轮胎翻新材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (583, 'CWLB', '财务类别', '04', '滚筒包胶材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (584, 'CWLB', '财务类别', '05', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (585, 'CWLB', '财务类别', '06', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (586, 'CWLB', '财务类别', '07', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (587, 'CWLB', '财务类别', '08', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (588, 'CWLB', '财务类别', '09', '油漆类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (589, 'CWLB', '财务类别', '10', '焊条', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (590, 'CWLB', '财务类别', '11', '螺栓', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (591, 'CWLB', '财务类别', '12', '管子件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (592, 'CWLB', '财务类别', '13', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (593, 'CWLB', '财务类别', '14', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (594, 'CWLB', '财务类别', '15', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (595, 'CWLB', '财务类别', '16', '油类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (596, 'CWLB', '财务类别', '17', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (597, 'CWLB', '财务类别', '18', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (598, 'CWLB', '财务类别', '19', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (599, 'CWLB', '财务类别', '20', '委外维修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (600, 'CWLB', '财务类别', '20', '低耗', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (601, 'CWLB', '财务类别', '201', '配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (602, 'CWLB', '财务类别', '01', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (603, 'CWLB', '财务类别', '02', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (604, 'CWLB', '财务类别', '03', '电器配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (605, 'CWLB', '财务类别', '04', '信息化物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (606, 'CWLB', '财务类别', '05', '通信物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (607, 'CWLB', '财务类别', '06', '油漆类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (608, 'CWLB', '财务类别', '07', '消防设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (609, 'CWLB', '财务类别', '08', '其他物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (610, 'CWLB', '财务类别', '09', '机械备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (611, 'CWLB', '财务类别', '26', '油类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (612, 'CWLB', '财务类别', '28', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (613, 'CWLB', '财务类别', '29', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (614, 'CWLB', '财务类别', '001', '中心', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (615, 'CWLB', '财务类别', '002', '开发一部', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (616, 'CWLB', '财务类别', '003', '开发二部', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (617, 'CWLB', '财务类别', '004', '研发部', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (618, 'CWLB', '财务类别', '005', '运维部', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (619, 'CWLB', '财务类别', '01', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (620, 'CWLB', '财务类别', '02', '建材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (621, 'CWLB', '财务类别', '03', '信息化设备及配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (622, 'CWLB', '财务类别', '04', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (623, 'CWLB', '财务类别', '5', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (624, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (625, 'CWLB', '财务类别', 'CHB', '衬板', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (626, 'CWLB', '财务类别', 'CL', '车辆配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (627, 'CWLB', '财务类别', 'DL', '电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (628, 'CWLB', '财务类别', 'DQ', '通用电气件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (629, 'CWLB', '财务类别', 'DZH', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (630, 'CWLB', '财务类别', 'GC', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (631, 'CWLB', '财务类别', 'GDZ', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (632, 'CWLB', '财务类别', 'GJ', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (633, 'CWLB', '财务类别', 'GSS', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (634, 'CWLB', '财务类别', 'JC', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (635, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (636, 'CWLB', '财务类别', 'LJ', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (637, 'CWLB', '财务类别', 'LT', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (638, 'CWLB', '财务类别', 'PD', '输送带', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (639, 'CWLB', '财务类别', 'QT', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (640, 'CWLB', '财务类别', 'RH', '油品、润滑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (641, 'CWLB', '财务类别', 'SJ', '索具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (642, 'CWLB', '财务类别', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (643, 'CWLB', '财务类别', 'WJ', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (644, 'CWLB', '财务类别', 'WL', '篷布网络', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (645, 'CWLB', '财务类别', 'XC', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (646, 'CWLB', '财务类别', 'XF', '消防设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (647, 'CWLB', '财务类别', 'XJ', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (648, 'CWLB', '财务类别', 'XXI', '信息化设备及配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (649, 'CWLB', '财务类别', 'YB', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (650, 'CWLB', '财务类别', 'YH', '油漆化工类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (651, 'CWLB', '财务类别', 'YS', '有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (652, 'CWLB', '财务类别', 'ZC', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (653, 'CWLB', '财务类别', 'ZD', '专用电气件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (654, 'CWLB', '财务类别', 'ZX', '码头装卸机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (655, 'CWLB', '财务类别', '01', '办公', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (656, 'CWLB', '财务类别', '02', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (657, 'CWLB', '财务类别', '01', '通用件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (658, 'CWLB', '财务类别', '02', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (659, 'CWLB', '财务类别', '03', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (660, 'CWLB', '财务类别', '04', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (661, 'CWLB', '财务类别', '05', '加固物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (662, 'CWLB', '财务类别', '06', '固机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (663, 'CWLB', '财务类别', '07', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (664, 'CWLB', '财务类别', '08', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (665, 'CWLB', '财务类别', '09', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (666, 'CWLB', '财务类别', '10', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (667, 'CWLB', '财务类别', '11', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (668, 'CWLB', '财务类别', '12', '低值易耗', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (669, 'CWLB', '财务类别', '13', '通用电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (670, 'CWLB', '财务类别', '14', '油漆化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (671, 'CWLB', '财务类别', '15', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (672, 'CWLB', '财务类别', '10', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (673, 'CWLB', '财务类别', '11', '油品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (674, 'CWLB', '财务类别', '12', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (675, 'CWLB', '财务类别', '13', '机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (676, 'CWLB', '财务类别', '14', '非生产生产用车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (677, 'CWLB', '财务类别', '15', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (678, 'CWLB', '财务类别', '16', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (679, 'CWLB', '财务类别', '2', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (680, 'CWLB', '财务类别', '3', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (681, 'CWLB', '财务类别', '4', '劳动保护品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (682, 'CWLB', '财务类别', '5', '消防设施材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (683, 'CWLB', '财务类别', '6', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (684, 'CWLB', '财务类别', '7', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (685, 'CWLB', '财务类别', '8', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (686, 'CWLB', '财务类别', '9', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (687, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (688, 'CWLB', '财务类别', '02', '劳保土产日杂', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (689, 'CWLB', '财务类别', '03', '五金钢材配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (690, 'CWLB', '财务类别', '04', '电器电缆仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (691, 'CWLB', '财务类别', '05', '信息化设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (692, 'CWLB', '财务类别', '06', '装饰建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (693, 'CWLB', '财务类别', '07', '消防设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (694, 'CWLB', '财务类别', '08', '绿化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (695, 'CWLB', '财务类别', '09', '其它', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (696, 'CWLB', '财务类别', 'AQ', '安全', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (697, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (698, 'CWLB', '财务类别', 'cb', '衬板', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (699, 'CWLB', '财务类别', 'cl', '车辆配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (700, 'CWLB', '财务类别', 'dl', '电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (701, 'CWLB', '财务类别', 'dq', '通用电气件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (702, 'CWLB', '财务类别', 'dzh', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (703, 'CWLB', '财务类别', 'gc', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (704, 'CWLB', '财务类别', 'gd', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (705, 'CWLB', '财务类别', 'GJ', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (706, 'CWLB', '财务类别', 'gss', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (707, 'CWLB', '财务类别', 'HB', '环保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (708, 'CWLB', '财务类别', 'jc', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (709, 'CWLB', '财务类别', 'lb', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (710, 'CWLB', '财务类别', 'lj', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (711, 'CWLB', '财务类别', 'lt', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (712, 'CWLB', '财务类别', 'qt', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (713, 'CWLB', '财务类别', 'rh', '油品、润滑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (714, 'CWLB', '财务类别', 'sj', '索具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (715, 'CWLB', '财务类别', 'ssd', '输送带', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (716, 'CWLB', '财务类别', 'tc', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (717, 'CWLB', '财务类别', 'wj', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (718, 'CWLB', '财务类别', 'wl', '篷布网络', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (719, 'CWLB', '财务类别', 'xc', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (720, 'CWLB', '财务类别', 'xf', '消防设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (721, 'CWLB', '财务类别', 'xj', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (722, 'CWLB', '财务类别', 'xxh', '信息化设备及配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (723, 'CWLB', '财务类别', 'yb', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (724, 'CWLB', '财务类别', 'yh', '油漆化工类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (725, 'CWLB', '财务类别', 'ys', '有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (726, 'CWLB', '财务类别', 'zc', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (727, 'CWLB', '财务类别', 'zd', '专用电气件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (728, 'CWLB', '财务类别', 'zx', '码头装卸机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (729, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (730, 'CWLB', '财务类别', '010', '集团-办公日常', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (731, 'CWLB', '财务类别', '011', '办公用品-日常', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (732, 'CWLB', '财务类别', '012', '办公用品-复印室', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (733, 'CWLB', '财务类别', '013', '办公用品-特殊事项', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (734, 'CWLB', '财务类别', '014', '股份-办公日常', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (735, 'CWLB', '财务类别', '015', '中心-办公日常', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (736, 'CWLB', '财务类别', '016', '集团-复印室', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (737, 'CWLB', '财务类别', '017', '集团-办公特殊', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (738, 'CWLB', '财务类别', '018', '股份-办公特殊', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (739, 'CWLB', '财务类别', '019', '中心-办公特殊', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (740, 'CWLB', '财务类别', '02', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (741, 'CWLB', '财务类别', '03', '材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (742, 'CWLB', '财务类别', '04', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (743, 'CWLB', '财务类别', '05', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (744, 'CWLB', '财务类别', '01', '材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (745, 'CWLB', '财务类别', '02', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (746, 'CWLB', '财务类别', '03', '备品配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (747, 'CWLB', '财务类别', '04', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (748, 'CWLB', '财务类别', '05', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (749, 'CWLB', '财务类别', '06', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (750, 'CWLB', '财务类别', '07', '工程物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (751, 'CWLB', '财务类别', '08', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (752, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (753, 'CWLB', '财务类别', 'CB', '衬板', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (754, 'CWLB', '财务类别', 'CL', '车辆配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (755, 'CWLB', '财务类别', 'DL', '电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (756, 'CWLB', '财务类别', 'DQ', '通用电器件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (757, 'CWLB', '财务类别', 'DZH', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (758, 'CWLB', '财务类别', 'GC', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (759, 'CWLB', '财务类别', 'GD', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (760, 'CWLB', '财务类别', 'GJ', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (761, 'CWLB', '财务类别', 'GSS', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (762, 'CWLB', '财务类别', 'JC', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (763, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (764, 'CWLB', '财务类别', 'LJ', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (765, 'CWLB', '财务类别', 'LT', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (766, 'CWLB', '财务类别', 'RH', '油品/润滑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (767, 'CWLB', '财务类别', 'SJ', '索具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (768, 'CWLB', '财务类别', 'SSD', '输送带', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (769, 'CWLB', '财务类别', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (770, 'CWLB', '财务类别', 'WJ', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (771, 'CWLB', '财务类别', 'WL', '篷布网络', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (772, 'CWLB', '财务类别', 'XC', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (773, 'CWLB', '财务类别', 'XF', '消防设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (774, 'CWLB', '财务类别', 'XJ', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (775, 'CWLB', '财务类别', 'XXH', '信息化设备及配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (776, 'CWLB', '财务类别', 'YB', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (777, 'CWLB', '财务类别', 'YH', '油气化工类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (778, 'CWLB', '财务类别', 'YQ', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (779, 'CWLB', '财务类别', 'YS', '有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (780, 'CWLB', '财务类别', 'ZC', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (781, 'CWLB', '财务类别', 'ZD', '专用电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (782, 'CWLB', '财务类别', 'ZH', '码头装卸机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (783, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (784, 'CWLB', '财务类别', 'CL', '材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (785, 'CWLB', '财务类别', 'DZ', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (786, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (787, 'CWLB', '财务类别', 'QT', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (788, 'CWLB', '财务类别', 'WX', '维修配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (789, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (790, 'CWLB', '财务类别', '02', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (791, 'CWLB', '财务类别', '03', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (792, 'CWLB', '财务类别', '04', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (793, 'CWLB', '财务类别', '05', '信息化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (794, 'CWLB', '财务类别', '06', '五金、工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (795, 'CWLB', '财务类别', 'BG', '办公', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (796, 'CWLB', '财务类别', '1', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (797, 'CWLB', '财务类别', '10', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (798, 'CWLB', '财务类别', '2', '固机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (799, 'CWLB', '财务类别', '3', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (800, 'CWLB', '财务类别', '4', '普通电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (801, 'CWLB', '财务类别', '5', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (802, 'CWLB', '财务类别', '6', '油漆化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (803, 'CWLB', '财务类别', '7', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (804, 'CWLB', '财务类别', '8', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (805, 'CWLB', '财务类别', '9', '装卸工属具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (806, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (807, 'CWLB', '财务类别', 'DZ', '低值易耗', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (808, 'CWLB', '财务类别', 'GC', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (809, 'CWLB', '财务类别', 'GZ', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (810, 'CWLB', '财务类别', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (811, 'CWLB', '财务类别', 'XXH', '信息化设备及配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (812, 'CWLB', '财务类别', 'AQ', '安全', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (813, 'CWLB', '财务类别', 'BG', '办公', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (814, 'CWLB', '财务类别', 'CB', '衬板', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (815, 'CWLB', '财务类别', 'CL', '车辆配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (816, 'CWLB', '财务类别', 'DC', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (817, 'CWLB', '财务类别', 'DL', '电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (818, 'CWLB', '财务类别', 'DQ', '通用电气', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (819, 'CWLB', '财务类别', 'DZH', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (820, 'CWLB', '财务类别', 'GC', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (821, 'CWLB', '财务类别', 'GD', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (822, 'CWLB', '财务类别', 'GJ', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (823, 'CWLB', '财务类别', 'GSS', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (824, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (825, 'CWLB', '财务类别', 'LD', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (826, 'CWLB', '财务类别', 'LJ', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (827, 'CWLB', '财务类别', 'QT', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (828, 'CWLB', '财务类别', 'RH', '油品润滑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (829, 'CWLB', '财务类别', 'SJ', '索具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (830, 'CWLB', '财务类别', 'SSD', '输送带', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (831, 'CWLB', '财务类别', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (832, 'CWLB', '财务类别', 'WJ', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (833, 'CWLB', '财务类别', 'WL', '篷布网络', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (834, 'CWLB', '财务类别', 'XC', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (835, 'CWLB', '财务类别', 'XF', '消防设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (836, 'CWLB', '财务类别', 'XJ', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (837, 'CWLB', '财务类别', 'XXH', '信息化设备及配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (838, 'CWLB', '财务类别', 'YB', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (839, 'CWLB', '财务类别', 'YH', '油漆化工类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (840, 'CWLB', '财务类别', 'YS', '有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (841, 'CWLB', '财务类别', 'ZC', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (842, 'CWLB', '财务类别', 'ZD', '专用电气件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (843, 'CWLB', '财务类别', 'ZX', '码头装卸机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (844, 'CWLB', '财务类别', '001', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (845, 'CWLB', '财务类别', '002', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (846, 'CWLB', '财务类别', '003', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (847, 'CWLB', '财务类别', '004', 'IT设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (848, 'CWLB', '财务类别', '005', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (849, 'CWLB', '财务类别', '006', '五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (850, 'CWLB', '财务类别', '01', '工程---土建材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (851, 'CWLB', '财务类别', '02', '工程---装修材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (852, 'CWLB', '财务类别', '03', '工程---水暖材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (853, 'CWLB', '财务类别', '04', '工程---电气材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (854, 'CWLB', '财务类别', '05', '混凝土生产材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (855, 'CWLB', '财务类别', '06', '备品配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (856, 'CWLB', '财务类别', '07', '连锁块生产材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (857, 'CWLB', '财务类别', '08', '日常办公物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (858, 'CWLB', '财务类别', '09', '固定办公物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (859, 'CWLB', '财务类别', '10', '分公司维修装修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (860, 'CWLB', '财务类别', '11', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (861, 'CWLB', '财务类别', '12', '工程---设备（外付款）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (862, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (863, 'CWLB', '财务类别', 'DQ', '电器配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (864, 'CWLB', '财务类别', 'DWJ', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (865, 'CWLB', '财务类别', 'GC', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (866, 'CWLB', '财务类别', 'GCL', '工程用料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (867, 'CWLB', '财务类别', 'GJ', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (868, 'CWLB', '财务类别', 'JX', '机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (869, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (870, 'CWLB', '财务类别', 'LT', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (871, 'CWLB', '财务类别', 'PB', '篷布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (872, 'CWLB', '财务类别', 'QT', '其他物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (873, 'CWLB', '财务类别', 'RHY', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (874, 'CWLB', '财务类别', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (875, 'CWLB', '财务类别', 'TX', '通信设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (876, 'CWLB', '财务类别', 'XC', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (877, 'CWLB', '财务类别', 'XF', '消防设施材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (878, 'CWLB', '财务类别', 'XWJ', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (879, 'CWLB', '财务类别', 'XXH', '信息化设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (880, 'CWLB', '财务类别', 'YB', '仪表仪器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (881, 'CWLB', '财务类别', 'YQ', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (882, 'CWLB', '财务类别', 'YSP', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (883, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (884, 'CWLB', '财务类别', '02', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (885, 'CWLB', '财务类别', '03', '信息化物品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (886, 'CWLB', '财务类别', '04', '广告印刷', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (887, 'CWLB', '财务类别', '01', '新建新购固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (888, 'CWLB', '财务类别', '02', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (889, 'CWLB', '财务类别', '03', '安全劳保用品（HSE）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (890, 'CWLB', '财务类别', '05', '普通电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (891, 'CWLB', '财务类别', '06', '备品备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (892, 'CWLB', '财务类别', '07', '通信设备、配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (893, 'CWLB', '财务类别', '08', '信息化设备、配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (894, 'CWLB', '财务类别', '11', '标示牌', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (895, 'CWLB', '财务类别', '12', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (896, 'CWLB', '财务类别', '13', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (897, 'CWLB', '财务类别', '14', '氮气', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (898, 'CWLB', '财务类别', '15', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (899, 'CWLB', '财务类别', '16', '宣传彩页、横幅', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (900, 'CWLB', '财务类别', '17', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (901, 'CWLB', '财务类别', '19', '篷布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (902, 'CWLB', '财务类别', '20', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (903, 'CWLB', '财务类别', '21', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (904, 'CWLB', '财务类别', '22', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (905, 'CWLB', '财务类别', '23', '消防设施材料（HSE）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (906, 'CWLB', '财务类别', '24', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (907, 'CWLB', '财务类别', '25', '工程设备、材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (908, 'CWLB', '财务类别', '26', '食品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (909, 'CWLB', '财务类别', '27', '厨房果蔬、材料、设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (910, 'CWLB', '财务类别', '29', '非生产用车用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (911, 'CWLB', '财务类别', '30', '实验气体', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (912, 'CWLB', '财务类别', '31', '环保应急物资（HSE）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (913, 'CWLB', '财务类别', '4', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (914, 'CWLB', '财务类别', '001', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (915, 'CWLB', '财务类别', '002', '大五金 ', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (916, 'CWLB', '财务类别', '003', '劳动保护品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (917, 'CWLB', '财务类别', '004', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (918, 'CWLB', '财务类别', '005', '港机电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (919, 'CWLB', '财务类别', '006', '普通电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (920, 'CWLB', '财务类别', '007', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (921, 'CWLB', '财务类别', '008', '固机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (922, 'CWLB', '财务类别', '009', '非生产用车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (923, 'CWLB', '财务类别', '010', '通信设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (924, 'CWLB', '财务类别', '011', '信息化设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (925, 'CWLB', '财务类别', '012', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (926, 'CWLB', '财务类别', '013', '加固材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (927, 'CWLB', '财务类别', '014', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (928, 'CWLB', '财务类别', '015', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (929, 'CWLB', '财务类别', '016', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (930, 'CWLB', '财务类别', '017', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (931, 'CWLB', '财务类别', '018', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (932, 'CWLB', '财务类别', '019', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (933, 'CWLB', '财务类别', '020', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (934, 'CWLB', '财务类别', '021', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (935, 'CWLB', '财务类别', '022', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (936, 'CWLB', '财务类别', '023', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (937, 'CWLB', '财务类别', '024', '消防设施材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (938, 'CWLB', '财务类别', '025', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (939, 'CWLB', '财务类别', '026', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (940, 'CWLB', '财务类别', '027', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (941, 'CWLB', '财务类别', '028', '教育用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (942, 'CWLB', '财务类别', '029', '篷布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (943, 'CWLB', '财务类别', '030', '大小绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (944, 'CWLB', '财务类别', '031', '网络乙烯绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (945, 'CWLB', '财务类别', '032', '液体化工材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (946, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (947, 'CWLB', '财务类别', 'DZY', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (948, 'CWLB', '财务类别', 'GJ', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (949, 'CWLB', '财务类别', 'GZ', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (950, 'CWLB', '财务类别', 'JC', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (951, 'CWLB', '财务类别', 'JX', '码头装卸机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (952, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (953, 'CWLB', '财务类别', 'LJ', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (954, 'CWLB', '财务类别', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (955, 'CWLB', '财务类别', 'TY', '通用电气件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (956, 'CWLB', '财务类别', 'XC', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (957, 'CWLB', '财务类别', '1', '135系列0204备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (958, 'CWLB', '财务类别', '10', '家用电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (959, 'CWLB', '财务类别', '11', '通讯导航', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (960, 'CWLB', '财务类别', '12', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (961, 'CWLB', '财务类别', '13', '办公设备及耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (962, 'CWLB', '财务类别', '14', '电瓶类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (963, 'CWLB', '财务类别', '15', '锚链及附件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (964, 'CWLB', '财务类别', '16', '缆绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (965, 'CWLB', '财务类别', '17', '消防救生', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (966, 'CWLB', '财务类别', '18', '橡塑石棉类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (967, 'CWLB', '财务类别', '19', '餐具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (968, 'CWLB', '财务类别', '2', '主机系列0204（国外备件）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (969, 'CWLB', '财务类别', '20', '清洁用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (970, 'CWLB', '财务类别', '21', '卧具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (971, 'CWLB', '财务类别', '22', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (972, 'CWLB', '财务类别', '23', '淡水', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (973, 'CWLB', '财务类别', '24', '燃油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (974, 'CWLB', '财务类别', '25', '汽油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (975, 'CWLB', '财务类别', '26', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (976, 'CWLB', '财务类别', '27', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (977, 'CWLB', '财务类别', '28', '计算机', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (978, 'CWLB', '财务类别', '29', '空压机', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (979, 'CWLB', '财务类别', '3', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (980, 'CWLB', '财务类别', '30', '文化宣教类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (981, 'CWLB', '财务类别', '36', '主机系列（国产备件）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (982, 'CWLB', '财务类别', '4', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (983, 'CWLB', '财务类别', '5', '碰垫', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (984, 'CWLB', '财务类别', '6', '油漆类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (985, 'CWLB', '财务类别', '7', '五金工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (986, 'CWLB', '财务类别', '8', '电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (987, 'CWLB', '财务类别', '9', '电工器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (988, 'CWLB', '财务类别', '1', '135系列0204备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (989, 'CWLB', '财务类别', '10', '家用电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (990, 'CWLB', '财务类别', '11', '通讯导航', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (991, 'CWLB', '财务类别', '12', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (992, 'CWLB', '财务类别', '13', '办公设备及耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (993, 'CWLB', '财务类别', '14', '电瓶类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (994, 'CWLB', '财务类别', '15', '锚链及附件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (995, 'CWLB', '财务类别', '16', '缆绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (996, 'CWLB', '财务类别', '17', '消防救生', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (997, 'CWLB', '财务类别', '18', '橡塑石棉类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (998, 'CWLB', '财务类别', '19', '餐具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (999, 'CWLB', '财务类别', '2', '主机系列0204（国外备件）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1000, 'CWLB', '财务类别', '20', '清洁用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1001, 'CWLB', '财务类别', '21', '卧具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1002, 'CWLB', '财务类别', '22', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1003, 'CWLB', '财务类别', '23', '淡水', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1004, 'CWLB', '财务类别', '24', '燃油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1005, 'CWLB', '财务类别', '25', '汽油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1006, 'CWLB', '财务类别', '26', '汽车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1007, 'CWLB', '财务类别', '27', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1008, 'CWLB', '财务类别', '28', '计算机', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1009, 'CWLB', '财务类别', '29', '空压机', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1010, 'CWLB', '财务类别', '3', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1011, 'CWLB', '财务类别', '30', '文化宣教类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1012, 'CWLB', '财务类别', '36', '主机系列（国产备件）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1013, 'CWLB', '财务类别', '4', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1014, 'CWLB', '财务类别', '5', '碰垫', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1015, 'CWLB', '财务类别', '6', '油漆类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1016, 'CWLB', '财务类别', '7', '五金工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1017, 'CWLB', '财务类别', '8', '电缆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1018, 'CWLB', '财务类别', '9', '电工器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1019, 'CWLB', '财务类别', '001', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1020, 'CWLB', '财务类别', '002', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1021, 'CWLB', '财务类别', '003', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1022, 'CWLB', '财务类别', '004', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1023, 'CWLB', '财务类别', '005', '普通电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1024, 'CWLB', '财务类别', '006', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1025, 'CWLB', '财务类别', '007', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1026, 'CWLB', '财务类别', '008', '教育用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1027, 'CWLB', '财务类别', '01', '办公', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1028, 'CWLB', '财务类别', '02', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1029, 'CWLB', '财务类别', '03', '宣传', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1030, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1031, 'CWLB', '财务类别', '02', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1032, 'CWLB', '财务类别', '03', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1033, 'CWLB', '财务类别', '04', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1034, 'CWLB', '财务类别', '05', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1035, 'CWLB', '财务类别', '06', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1036, 'CWLB', '财务类别', '07', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1037, 'CWLB', '财务类别', '08', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1038, 'CWLB', '财务类别', '09', '加固材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1039, 'CWLB', '财务类别', '10', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1040, 'CWLB', '财务类别', '11', '通信设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1041, 'CWLB', '财务类别', '12', '信息化设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1042, 'CWLB', '财务类别', '13', '普通电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1043, 'CWLB', '财务类别', '14', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1044, 'CWLB', '财务类别', '15', '固机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1045, 'CWLB', '财务类别', '16', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1046, 'CWLB', '财务类别', '17', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1047, 'CWLB', '财务类别', '18', '消防设施材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1048, 'CWLB', '财务类别', '19', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1049, 'CWLB', '财务类别', '20', '篷布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1050, 'CWLB', '财务类别', '21', '大小绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1051, 'CWLB', '财务类别', '22', '网络乙烯绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1052, 'CWLB', '财务类别', '23', '建材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1053, 'CWLB', '财务类别', '24', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1054, 'CWLB', '财务类别', '25', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1055, 'CWLB', '财务类别', '26', '劳动保护品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1056, 'CWLB', '财务类别', '001', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1057, 'CWLB', '财务类别', '002', '劳保服装', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1058, 'CWLB', '财务类别', '003', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1059, 'CWLB', '财务类别', '004', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1060, 'CWLB', '财务类别', '01', '低耗', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1061, 'CWLB', '财务类别', '02', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1062, 'CWLB', '财务类别', '03', '维修备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1063, 'CWLB', '财务类别', '04', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1064, 'CWLB', '财务类别', '01', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1065, 'CWLB', '财务类别', '02', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1066, 'CWLB', '财务类别', '03', '劳动保护品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1067, 'CWLB', '财务类别', '04', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1068, 'CWLB', '财务类别', '05', '港机电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1069, 'CWLB', '财务类别', '06', '普通电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1070, 'CWLB', '财务类别', '07', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1071, 'CWLB', '财务类别', '08', '固机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1072, 'CWLB', '财务类别', '09', '非生产用车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1073, 'CWLB', '财务类别', '10', '通信设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1074, 'CWLB', '财务类别', '11', '信息化设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1075, 'CWLB', '财务类别', '12', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1076, 'CWLB', '财务类别', '13', '加固材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1077, 'CWLB', '财务类别', '14', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1078, 'CWLB', '财务类别', '15', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1079, 'CWLB', '财务类别', '16', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1080, 'CWLB', '财务类别', '17', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1081, 'CWLB', '财务类别', '18', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1082, 'CWLB', '财务类别', '19', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1083, 'CWLB', '财务类别', '20', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1084, 'CWLB', '财务类别', '21', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1085, 'CWLB', '财务类别', '22', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1086, 'CWLB', '财务类别', '23', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1087, 'CWLB', '财务类别', '24', '教育用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1088, 'CWLB', '财务类别', '25', '篷布', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1089, 'CWLB', '财务类别', '26', '大小绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1090, 'CWLB', '财务类别', '27', '网络乙烯绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1091, 'CWLB', '财务类别', '01', '机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1092, 'CWLB', '财务类别', '02', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1093, 'CWLB', '财务类别', '03', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1094, 'CWLB', '财务类别', '04', '干柜修箱材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1095, 'CWLB', '财务类别', '05', '冻柜修箱材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1096, 'CWLB', '财务类别', '06', '液压管件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1097, 'CWLB', '财务类别', '07', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1098, 'CWLB', '财务类别', '09', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1099, 'CWLB', '财务类别', '10', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1100, 'CWLB', '财务类别', '11', '低值易耗', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1101, 'CWLB', '财务类别', '12', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1102, 'CWLB', '财务类别', '15', '网络耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1103, 'CWLB', '财务类别', '16', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1104, 'CWLB', '财务类别', '18', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1105, 'CWLB', '财务类别', '19', '电器材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1106, 'CWLB', '财务类别', '20', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1107, 'CWLB', '财务类别', '001', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1108, 'CWLB', '财务类别', '001', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1109, 'CWLB', '财务类别', '002', '车辆用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1110, 'CWLB', '财务类别', '003', '电脑', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1111, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1112, 'CWLB', '财务类别', '02', '工程材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1113, 'CWLB', '财务类别', '03', '工程设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1114, 'CWLB', '财务类别', '04', '机械设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1115, 'CWLB', '财务类别', '05', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1116, 'CWLB', '财务类别', '06', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1117, 'CWLB', '财务类别', '07', '通信材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1118, 'CWLB', '财务类别', '08', '劳保材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1119, 'CWLB', '财务类别', '09', '油漆化工类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1120, 'CWLB', '财务类别', '10', '五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1121, 'CWLB', '财务类别', '11', '润滑', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1122, 'CWLB', '财务类别', '12', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1123, 'CWLB', '财务类别', '13', '黑色金属和有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1124, 'CWLB', '财务类别', '14', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1125, 'CWLB', '财务类别', '15', '其它', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1126, 'CWLB', '财务类别', '16', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1127, 'CWLB', '财务类别', '17', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1128, 'CWLB', '财务类别', '18', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1129, 'CWLB', '财务类别', '19', '轴承', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1130, 'CWLB', '财务类别', '20', '铁路器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1131, 'CWLB', '财务类别', '01', '服装原材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1132, 'CWLB', '财务类别', '02', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1133, 'CWLB', '财务类别', '03', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1134, 'CWLB', '财务类别', '04', '设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1135, 'CWLB', '财务类别', '05', '五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1136, 'CWLB', '财务类别', '06', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1137, 'CWLB', '财务类别', '07', '黑色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1138, 'CWLB', '财务类别', '08', '有色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1139, 'CWLB', '财务类别', '09', '通用电气件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1140, 'CWLB', '财务类别', '10', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1141, 'CWLB', '财务类别', '11', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1142, 'CWLB', '财务类别', '12', '油漆化工类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1143, 'CWLB', '财务类别', '13', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1144, 'CWLB', '财务类别', '14', '通信材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1145, 'CWLB', '财务类别', '15', '工程设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1146, 'CWLB', '财务类别', '16', '工程材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1147, 'CWLB', '财务类别', '17', '篷布原材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1148, 'CWLB', '财务类别', '18', '密目网原材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1149, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1150, 'CWLB', '财务类别', '02', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1151, 'CWLB', '财务类别', '03', '机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1152, 'CWLB', '财务类别', '04', '通用电气', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1153, 'CWLB', '财务类别', '05', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1154, 'CWLB', '财务类别', '06', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1155, 'CWLB', '财务类别', '07', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1156, 'CWLB', '财务类别', '08', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1157, 'CWLB', '财务类别', '09', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1158, 'CWLB', '财务类别', '10', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1159, 'CWLB', '财务类别', '11', '信息化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1160, 'CWLB', '财务类别', '001', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1161, 'CWLB', '财务类别', '002', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1162, 'CWLB', '财务类别', '003', '修箱材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1163, 'CWLB', '财务类别', '004', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1164, 'CWLB', '财务类别', '005', '设备维修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1165, 'CWLB', '财务类别', '006', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1166, 'CWLB', '财务类别', '007', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1167, 'CWLB', '财务类别', '008', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1168, 'CWLB', '财务类别', '01', '材料库', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1169, 'CWLB', '财务类别', '02', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1170, 'CWLB', '财务类别', '03', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1171, 'CWLB', '财务类别', '04', '机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1172, 'CWLB', '财务类别', '05', '机械电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1173, 'CWLB', '财务类别', '06', '油漆化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1174, 'CWLB', '财务类别', '07', '油品类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1175, 'CWLB', '财务类别', '001', '机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1176, 'CWLB', '财务类别', '002', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1177, 'CWLB', '财务类别', '003', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1178, 'CWLB', '财务类别', '005', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1179, 'CWLB', '财务类别', '006', '消防器材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1180, 'CWLB', '财务类别', '007', '钢材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1181, 'CWLB', '财务类别', '008', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1182, 'CWLB', '财务类别', '009', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1183, 'CWLB', '财务类别', '010', 'LED灯', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1184, 'CWLB', '财务类别', '01', '气动元件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1185, 'CWLB', '财务类别', '02', '机械部件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1186, 'CWLB', '财务类别', '03', '电器部件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1187, 'CWLB', '财务类别', '04', '缝纫机部件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1188, 'CWLB', '财务类别', '05', '空压机部件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1189, 'CWLB', '财务类别', '06', '工  具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1190, 'CWLB', '财务类别', '07', '生产物资', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1191, 'CWLB', '财务类别', '08', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1192, 'CWLB', '财务类别', '09', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1193, 'CWLB', '财务类别', '01', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1194, 'CWLB', '财务类别', '02', '配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1195, 'CWLB', '财务类别', '1', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1196, 'CWLB', '财务类别', '2', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1197, 'CWLB', '财务类别', '3', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1198, 'CWLB', '财务类别', '4', '耗材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1199, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1200, 'CWLB', '财务类别', '02', '机械设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1201, 'CWLB', '财务类别', '03', '宣传广告', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1202, 'CWLB', '财务类别', '04', '安全设备', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1203, 'CWLB', '财务类别', '01', '装饰', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1204, 'CWLB', '财务类别', '02', '电气', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1205, 'CWLB', '财务类别', '001', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1206, 'CWLB', '财务类别', '002', '五金件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1207, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1208, 'CWLB', '财务类别', 'DQ', '通用电器件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1209, 'CWLB', '财务类别', 'DZ', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1210, 'CWLB', '财务类别', 'GD', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1211, 'CWLB', '财务类别', 'GJ', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1212, 'CWLB', '财务类别', 'GS', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1213, 'CWLB', '财务类别', 'JC', '建材', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1214, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1215, 'CWLB', '财务类别', 'PD', '电动装卸机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1216, 'CWLB', '财务类别', 'PL', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1217, 'CWLB', '财务类别', 'PX', '信息化', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1218, 'CWLB', '财务类别', 'RH', '润滑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1219, 'CWLB', '财务类别', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1220, 'CWLB', '财务类别', 'TJ', '通用机械产品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1221, 'CWLB', '财务类别', 'WJ', '五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1222, 'CWLB', '财务类别', 'WX', '委外维修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1223, 'CWLB', '财务类别', 'XC', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1224, 'CWLB', '财务类别', 'XF', '消防设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1225, 'CWLB', '财务类别', 'XJ', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1226, 'CWLB', '财务类别', 'YB', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1227, 'CWLB', '财务类别', 'YH', '油料化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1228, 'CWLB', '财务类别', 'YS', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1229, 'CWLB', '财务类别', 'ZD', '招待用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1230, 'CWLB', '财务类别', '01', '冻柜材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1231, 'CWLB', '财务类别', '02', '干柜材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1232, 'CWLB', '财务类别', '03', '挂衣箱材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1233, 'CWLB', '财务类别', '04', '油料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1234, 'CWLB', '财务类别', '05', '润料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1235, 'CWLB', '财务类别', '06', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1236, 'CWLB', '财务类别', '07', '配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1237, 'CWLB', '财务类别', '08', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1238, 'CWLB', '财务类别', '09', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1239, 'CWLB', '财务类别', '10', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1240, 'CWLB', '财务类别', '11', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1241, 'CWLB', '财务类别', '12', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1242, 'CWLB', '财务类别', '13', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1243, 'CWLB', '财务类别', '14', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1244, 'CWLB', '财务类别', '15', '委外维修', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1245, 'CWLB', '财务类别', 'BG', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1246, 'CWLB', '财务类别', 'DQ', '通用电器件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1247, 'CWLB', '财务类别', 'DZ', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1248, 'CWLB', '财务类别', 'GC', '黑色金属', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1249, 'CWLB', '财务类别', 'GJ', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1250, 'CWLB', '财务类别', 'GS', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1251, 'CWLB', '财务类别', 'JC', '建筑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1252, 'CWLB', '财务类别', 'JY', '教育用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1253, 'CWLB', '财务类别', 'LB', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1254, 'CWLB', '财务类别', 'PD', '电动装卸机械配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1255, 'CWLB', '财务类别', 'PL', '流机配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1256, 'CWLB', '财务类别', 'PT', '通信设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1257, 'CWLB', '财务类别', 'PX', '信息化设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1258, 'CWLB', '财务类别', 'RH', '润滑材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1259, 'CWLB', '财务类别', 'RL', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1260, 'CWLB', '财务类别', 'SA', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1261, 'CWLB', '财务类别', 'TC', '土产杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1262, 'CWLB', '财务类别', 'WJ', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1263, 'CWLB', '财务类别', 'XC', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1264, 'CWLB', '财务类别', 'XF', '消防设施', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1265, 'CWLB', '财务类别', 'XJ', '橡胶制品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1266, 'CWLB', '财务类别', 'YB', '仪器仪表', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1267, 'CWLB', '财务类别', 'YH', '油料化工', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1268, 'CWLB', '财务类别', 'YS', '印刷品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1269, 'CWLB', '财务类别', '01', '小五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1270, 'CWLB', '财务类别', '02', '大五金', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1271, 'CWLB', '财务类别', '03', '电器', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1272, 'CWLB', '财务类别', '04', '油漆', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1273, 'CWLB', '财务类别', '05', '杂品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1274, 'CWLB', '财务类别', '06', '润滑油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1275, 'CWLB', '财务类别', '07', '流机', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1276, 'CWLB', '财务类别', '08', '固机', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1277, 'CWLB', '财务类别', '09', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1278, 'CWLB', '财务类别', '10', '钢丝绳', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1279, 'CWLB', '财务类别', '11', '工具', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1280, 'CWLB', '财务类别', '12', '氧气乙炔', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1281, 'CWLB', '财务类别', '13', '劳保', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1282, 'CWLB', '财务类别', '14', '燃油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1283, 'CWLB', '财务类别', '15', '燃气', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1284, 'CWLB', '财务类别', '16', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1285, 'CWLB', '财务类别', '17', '保洁用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1286, 'CWLB', '财务类别', '18', '宣传用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1287, 'CWLB', '财务类别', '19', '安全费用', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1288, 'CWLB', '财务类别', '20', 'IT易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1289, 'CWLB', '财务类别', '21', '二期食堂', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1290, 'CWLB', '财务类别', '22', '三期食堂', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1291, 'CWLB', '财务类别', '23', '低值易耗品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1292, 'CWLB', '财务类别', '24', '其他', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1293, 'CWLB', '财务类别', '1', '生产材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1294, 'CWLB', '财务类别', '2', '燃料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1295, 'CWLB', '财务类别', '3', '设备配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1296, 'CWLB', '财务类别', '5', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1297, 'CWLB', '财务类别', '6', '工程材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1298, 'CWLB', '财务类别', '7', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1299, 'CWLB', '财务类别', '8', '其它', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1300, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1301, 'CWLB', '财务类别', '02', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1302, 'CWLB', '财务类别', '03', '修箱材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1303, 'CWLB', '财务类别', '04', '一般材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1304, 'CWLB', '财务类别', '01', '三类（一）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1305, 'CWLB', '财务类别', '02', '三类（二）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1306, 'CWLB', '财务类别', '03', '三类（三）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1307, 'CWLB', '财务类别', '04', '三类（四）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1308, 'CWLB', '财务类别', '05', '三类（五）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1309, 'CWLB', '财务类别', '06', '三类（六）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1310, 'CWLB', '财务类别', '07', '三类（七）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1311, 'CWLB', '财务类别', '08', '三类（八）', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1312, 'CWLB', '财务类别', '09', '新STR备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1313, 'CWLB', '财务类别', '10', '桥吊备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1314, 'CWLB', '财务类别', '11', '胎吊备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1315, 'CWLB', '财务类别', '12', '固机备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1316, 'CWLB', '财务类别', '13', '备件(一)', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1317, 'CWLB', '财务类别', '14', '备件(二)', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1318, 'CWLB', '财务类别', '15', '备件(三)', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1319, 'CWLB', '财务类别', '16', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1320, 'CWLB', '财务类别', '17', 'STR备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1321, 'CWLB', '财务类别', '18', 'VOLVO备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1322, 'CWLB', '财务类别', '19', 'NISSAN备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1323, 'CWLB', '财务类别', '20', '正面吊备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1324, 'CWLB', '财务类别', '21', 'CVS备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1325, 'CWLB', '财务类别', '22', 'KM备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1326, 'CWLB', '财务类别', '23', 'BOSS备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1327, 'CWLB', '财务类别', '24', 'TCM备件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1328, 'CWLB', '财务类别', '26', '油类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1329, 'CWLB', '财务类别', '27', '燃油', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1330, 'CWLB', '财务类别', '28', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1331, 'CWLB', '财务类别', '29', '办公类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1332, 'CWLB', '财务类别', '30', 'IT类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1333, 'CWLB', '财务类别', '01', '拖车配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1334, 'CWLB', '财务类别', '02', '空叉配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1335, 'CWLB', '财务类别', '03', '正面吊配件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1336, 'CWLB', '财务类别', '04', '油类', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1337, 'CWLB', '财务类别', '05', '轮胎', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1338, 'CWLB', '财务类别', '06', '其它材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1339, 'CWLB', '财务类别', '07', '修箱材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1340, 'CWLB', '财务类别', '08', '低值易耗材料', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1341, 'CWLB', '财务类别', '09', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1342, 'CWLB', '财务类别', '10', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1343, 'CWLB', '财务类别', '11', '固定资产', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1344, 'CWLB', '财务类别', '12', '业务费用', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1345, 'CWLB', '财务类别', '001', '办公', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1346, 'CWLB', '财务类别', '002', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1347, 'CWLB', '财务类别', '01', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1348, 'CWLB', '财务类别', '02', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1349, 'CWLB', '财务类别', '03', '信息化设备及附件', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1350, 'CWLB', '财务类别', '12', '办公用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1351, 'CWLB', '财务类别', '13', '劳保用品', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1352, 'CWLB', '财务类别', '001', '办公', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1353, 'CSZH', '传送账号', '0201', '航修分公司', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');
INSERT INTO `um_data_dictionary` VALUES (1354, 'RKLB', '入库类别', '07', '随机件入库', 0, '2019-05-18 12:17:06', '2019-06-02 10:36:11');

-- ----------------------------
-- Table structure for um_resource_info
-- ----------------------------
DROP TABLE IF EXISTS `um_resource_info`;
CREATE TABLE `um_resource_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `pid` int NOT NULL DEFAULT 0 COMMENT '父级资源id',
  `res_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色编号,具有唯一性',
  `res_zh_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '资源中文名',
  `res_cn_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '资源英文名',
  `grade` int NOT NULL DEFAULT 1 COMMENT '等级1一级菜单2二级菜单以此类推',
  `res_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '对应系统的访问路径',
  `seq` int NOT NULL DEFAULT 99 COMMENT '排列顺序',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of um_resource_info
-- ----------------------------
INSERT INTO `um_resource_info` VALUES (1, 0, '2000', '用户查询', 'user_query', 1, 'res_1_0', 1, '', '2019-05-18 12:17:06', '2019-07-21 11:24:10');
INSERT INTO `um_resource_info` VALUES (2, 0, '2001', '用户修改', 'user_update', 1, 'res_1_1', 2, '', '2019-05-18 12:17:06', '2019-07-21 12:09:48');
INSERT INTO `um_resource_info` VALUES (3, 0, '2002', '用户启用禁用', 'user_enable', 1, 'res_1_2', 3, '', '2019-05-18 12:17:06', '2019-07-21 11:24:20');
INSERT INTO `um_resource_info` VALUES (4, 0, '2003', '用户删除', 'user_delete', 1, 'res_1_3', 4, '', '2019-05-18 12:17:06', '2019-07-21 11:24:23');
INSERT INTO `um_resource_info` VALUES (5, 0, '2004', '用户新增', 'user_add', 1, 'res_1_4', 5, '', '2019-07-21 11:13:30', '2019-07-21 11:24:33');
INSERT INTO `um_resource_info` VALUES (6, 0, '2005', '用户信息绑定', 'user_bind', 1, 'res_1_5', 6, '', '2019-07-21 11:29:47', '2019-07-21 11:29:47');

-- ----------------------------
-- Table structure for um_role_info
-- ----------------------------
DROP TABLE IF EXISTS `um_role_info`;
CREATE TABLE `um_role_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色编号,具有唯一性',
  `role_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色名',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of um_role_info
-- ----------------------------
INSERT INTO `um_role_info` VALUES (1, '1000', 'role_admin', '管理员', '2019-05-18 12:17:06', '2019-06-30 11:15:23');
INSERT INTO `um_role_info` VALUES (2, '1001', 'role_user_q', '只能可以查询用户', '2019-05-18 12:17:06', '2019-07-21 11:16:18');
INSERT INTO `um_role_info` VALUES (3, '1003', 'role_user_op', '只能业务操作', '2019-05-18 12:17:06', '2019-07-21 11:21:03');

-- ----------------------------
-- Table structure for um_role_res
-- ----------------------------
DROP TABLE IF EXISTS `um_role_res`;
CREATE TABLE `um_role_res`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL DEFAULT 0 COMMENT '角色id',
  `res_id` int NOT NULL DEFAULT 0 COMMENT '资源id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_role`(`role_id`) USING BTREE,
  INDEX `index_res`(`res_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of um_role_res
-- ----------------------------
INSERT INTO `um_role_res` VALUES (1, 1, 1);
INSERT INTO `um_role_res` VALUES (2, 1, 2);
INSERT INTO `um_role_res` VALUES (3, 1, 3);
INSERT INTO `um_role_res` VALUES (4, 1, 4);
INSERT INTO `um_role_res` VALUES (5, 1, 5);
INSERT INTO `um_role_res` VALUES (6, 2, 1);
INSERT INTO `um_role_res` VALUES (7, 3, 2);
INSERT INTO `um_role_res` VALUES (8, 3, 3);
INSERT INTO `um_role_res` VALUES (9, 3, 4);
INSERT INTO `um_role_res` VALUES (10, 3, 5);
INSERT INTO `um_role_res` VALUES (11, 1, 6);
INSERT INTO `um_role_res` VALUES (12, 3, 6);

-- ----------------------------
-- Table structure for um_user_info
-- ----------------------------
DROP TABLE IF EXISTS `um_user_info`;
CREATE TABLE `um_user_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '登陆名',
  `true_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '真实姓名',
  `enabled` int NOT NULL DEFAULT 1 COMMENT '是否启用1启用0禁用',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '正确的email地址',
  `phone_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号码座机等',
  `contact_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '联系方式',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_uname_pwd`(`user_name`(10)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of um_user_info
-- ----------------------------
INSERT INTO `um_user_info` VALUES (1, 'admin', '管理员', 1, 'pixingdaiyue051@163.com', '15988814762', '', '2019-06-30 11:08:15', '2019-07-02 16:07:01');
INSERT INTO `um_user_info` VALUES (2, 'aaa', 'aaa', 1, '', '13455237616', '', '2019-07-02 10:52:20', '2019-07-21 13:54:53');
INSERT INTO `um_user_info` VALUES (3, 'bbb', 'bbb', 1, '', '', '', '2019-07-02 10:53:38', '2020-11-23 09:28:15');
INSERT INTO `um_user_info` VALUES (4, 'ccc', 'ccc', 1, '', '', '', '2019-07-21 13:44:32', '2020-11-23 09:28:15');

-- ----------------------------
-- Table structure for um_user_password
-- ----------------------------
DROP TABLE IF EXISTS `um_user_password`;
CREATE TABLE `um_user_password`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL DEFAULT 0,
  `encrypt_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of um_user_password
-- ----------------------------
INSERT INTO `um_user_password` VALUES (1, 1, 'bf9e46e9b962c6b425f0685626cd64bb45febfac300c4b0322d0586954c20a26', '2019-06-30 11:13:30', '2019-07-21 11:52:50');
INSERT INTO `um_user_password` VALUES (2, 2, '4649d5c653594a55bf8eff9771927297c6f8d6c8e31c4a2301782257667dbabf', '2019-07-02 10:52:20', '2019-07-21 11:52:57');
INSERT INTO `um_user_password` VALUES (3, 3, '1d4148dbd0951a1ecf77c10052579a356247cf45bd0a09d3f8c700a60e4a688b', '2019-07-02 10:53:38', '2019-07-21 11:52:59');
INSERT INTO `um_user_password` VALUES (4, 4, 'c1ec864d906d5b3649c3eb9a1a2c32e9cdaa76d015a0a5d233adf9d705ce4b41', '2019-07-21 13:45:17', '2019-07-21 13:45:17');
INSERT INTO `um_user_password` VALUES (5, 10, 'd92d7c4e10e066decfe17bd3b5a933d85e55b0e041f8a47a71a63da56b70e844', '2020-11-20 14:01:17', '2020-11-20 14:01:17');
INSERT INTO `um_user_password` VALUES (6, 11, 'd92d7c4e10e066decfe17bd3b5a933d85e55b0e041f8a47a71a63da56b70e844', '2020-11-20 14:02:18', '2020-11-20 14:02:18');
INSERT INTO `um_user_password` VALUES (7, 12, '1c310521114206ab7dbdf04db99504aa3e32aa71b10acd828a8f57158e2cb84f', '2020-11-20 14:03:19', '2020-11-20 14:03:19');
INSERT INTO `um_user_password` VALUES (8, 13, '1c310521114206ab7dbdf04db99504aa3e32aa71b10acd828a8f57158e2cb84f', '2020-11-20 14:04:44', '2020-11-20 14:04:44');
INSERT INTO `um_user_password` VALUES (9, 14, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-20 14:08:37', '2020-11-20 14:08:37');
INSERT INTO `um_user_password` VALUES (10, 15, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-20 14:18:35', '2020-11-20 14:18:35');
INSERT INTO `um_user_password` VALUES (11, 16, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-20 14:18:39', '2020-11-20 14:18:39');
INSERT INTO `um_user_password` VALUES (12, 17, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-20 14:18:43', '2020-11-20 14:18:43');
INSERT INTO `um_user_password` VALUES (13, 18, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-20 14:18:46', '2020-11-20 14:18:46');
INSERT INTO `um_user_password` VALUES (14, 19, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-20 14:18:49', '2020-11-20 14:18:49');
INSERT INTO `um_user_password` VALUES (15, 20, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-20 14:18:52', '2020-11-20 14:18:52');
INSERT INTO `um_user_password` VALUES (16, 21, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-20 14:18:56', '2020-11-20 14:18:56');
INSERT INTO `um_user_password` VALUES (17, 22, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-20 14:18:59', '2020-11-20 14:18:59');
INSERT INTO `um_user_password` VALUES (18, 23, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-23 09:16:07', '2020-11-23 09:16:07');
INSERT INTO `um_user_password` VALUES (19, 24, '805fa10e51cf76c3da803de2ea7414a73f9088111879b308d4453b1dd74c43af', '2020-11-23 09:21:11', '2020-11-23 09:21:11');

-- ----------------------------
-- Table structure for um_user_role
-- ----------------------------
DROP TABLE IF EXISTS `um_user_role`;
CREATE TABLE `um_user_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL DEFAULT 0 COMMENT '用户id',
  `role_id` int NOT NULL DEFAULT 0 COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_user`(`user_id`) USING BTREE,
  INDEX `index_role`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of um_user_role
-- ----------------------------
INSERT INTO `um_user_role` VALUES (1, 1, 1);
INSERT INTO `um_user_role` VALUES (2, 2, 2);
INSERT INTO `um_user_role` VALUES (3, 2, 3);

SET FOREIGN_KEY_CHECKS = 1;



CREATE OR REPLACE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `local_demo`.`v_user_role` AS SELECT
	`u`.`id` AS `userId`,
	`u`.`user_name` AS `username`,
	`u`.`true_name` AS `truename`,
	`u`.`enabled` AS `enabled`,
	`u`.`email` AS `email`,
	`u`.`phone_num` AS `phoneNum`,
	`u`.`contact_info` AS `contactInfo`,
	`r`.`id` AS `roleId`,
	`r`.`role_code` AS `roleCode`,
	`r`.`role_name` AS `roleName` 
FROM
	((
			`um_user_info` `u`
			JOIN `um_user_role` `ur` ON ((
					`u`.`id` = `ur`.`user_id` 
				)))
		JOIN `um_role_info` `r` ON ((
			`ur`.`role_id` = `r`.`id` 
	)));
	

CREATE OR REPLACE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `local_demo`.`v_user_res` AS SELECT
	`u`.`id` AS `userId`,
	`u`.`user_name` AS `username`,
	`u`.`true_name` AS `truename`,
	`u`.`enabled` AS `enabled`,
	`u`.`email` AS `email`,
	`u`.`phone_num` AS `phoneNum`,
	`u`.`contact_info` AS `contactInfo`,
	`r`.`id` AS `resId`,
	`r`.`pid` AS `resPid`,
	`r`.`res_code` AS `resCode`,
	`r`.`res_zh_name` AS `resZhName`,
	`r`.`res_cn_name` AS `resCnName`,
	`r`.`grade` AS `grade`,
	`r`.`res_url` AS `resUrl`,
	`r`.`seq` AS `seq` 
FROM
	(((
				`um_resource_info` `r`
				JOIN `um_role_res` `rr` ON ((
						`r`.`id` = `rr`.`res_id` 
					)))
			JOIN `um_user_role` `ur` ON ((
					`rr`.`role_id` = `ur`.`role_id` 
				)))
		JOIN `um_user_info` `u` ON ((
				`ur`.`user_id` = `u`.`id` 
			))) 
GROUP BY
	`u`.`id`,
	`r`.`id`;