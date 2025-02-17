CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(60) DEFAULT NULL,
  `price` int NOT NULL,
  `unit` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) CHARACTER SET=utf8mb4 COLLATE=utf8mb4_unicode_ci ENGINE=InnoDB AUTO_INCREMENT=1;

INSERT INTO `product` VALUES(1, 'Bàn chải đánh răng Colgate', '100000293424', 15000, 'Cái');
INSERT INTO `product` VALUES(2, 'Kem đánh răng Closeup', '100000528712', 26000, 'Tuýp');
INSERT INTO `product` VALUES(3, 'Khăn tắm', '100000293424', 15000, 'Cái');
INSERT INTO `product` VALUES(4, 'Muỗng bạc cao cấp', '200000329485', 53000, 'Cái');
INSERT INTO `product` VALUES(5, 'Nước uống sữa chua Nutriboost việt quất', '200000410842', 11000, 'Chai');