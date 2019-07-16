USE mybatis;

CREATE TABLE `country`
(
    `id`   INT          NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `code` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT `country`(`name`, `code`) values
('中国', 'CN'),
('美国', 'US'),
('俄罗斯', 'RU'),
('英国', 'GB'),
('法国', 'FR');