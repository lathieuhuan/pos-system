DROP TABLE IF EXISTS possystem.order_draft_item;

CREATE TABLE IF NOT EXISTS possystem.order_draft_item (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_draft_code` VARCHAR(38) NOT NULL,
  `product_code` VARCHAR(38) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

SELECT * FROM possystem.order_draft_item;

DELETE FROM possystem.order_draft_item WHERE id != -1;