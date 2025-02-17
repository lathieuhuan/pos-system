DROP TABLE IF EXISTS `order_draft`;

CREATE TABLE `order_draft` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` DATETIME NOT NULL,
  `payment_method` VARCHAR(24),
  `payment_status` VARCHAR(24),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `order_draft` (id, created_at) VALUES (1, '2025-02-04 17:00:00');

SELECT * FROM possystem.order_draft;