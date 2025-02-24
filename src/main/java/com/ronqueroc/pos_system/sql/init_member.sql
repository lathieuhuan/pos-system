DROP TABLE IF EXISTS possystem.member;

CREATE TABLE IF NOT EXISTS possystem.member (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `phone_number` CHAR(12) NOT NULL,
  PRIMARY KEY (`id`)
) CHARACTER SET=utf8mb4 COLLATE=utf8mb4_unicode_ci ENGINE=InnoDB AUTO_INCREMENT=1;

SELECT * FROM possystem.member;

INSERT INTO possystem.member VALUES
    (1, 'Trần Văn Bánh', "0914825821"),
    (2, 'Nguyễn Văn An', "0982958212"),
    (3, 'Lê Hoàng Cẩm Dung', "0932842954"),
    (4, 'Trương Thanh Hiền', "0959284572"),
    (5, 'Đặng Hồng Gấm', "0995727596");
    
DELETE FROM possystem.member WHERE id != -1;