DROP TABLE IF EXISTS `Sale`;


CREATE TABLE `Sale`(

    `id` INT NOT NULL AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    `number` INT NOT NULL,

    PRIMARY KEY ( `id` )

  )ENGINE=INNODB DEFAULT CHARSET=utf8;
