DROP TABLE IF EXISTS order_draft_item;

CREATE TABLE IF NOT EXISTS order_draft_item (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_draft_code` VARCHAR(38) NOT NULL,
  `product_code` VARCHAR(38) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

SELECT * FROM order_draft_item;

DELETE FROM order_draft_item WHERE id != -1;