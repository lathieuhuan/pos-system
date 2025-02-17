CREATE TABLE IF NOT EXISTS `order_draft_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_draft_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

SELECT * FROM possystem.order_draft_item;