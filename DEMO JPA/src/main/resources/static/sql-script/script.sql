CREATE SCHEMA IF NOT EXISTS `todo_db` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE IF NOT EXISTS `todo_db`.`todo` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NULL DEFAULT NULL,
    `detail` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4;

-- Thêm 1 record vào DB
INSERT INTO `todo_db`.`todo` (`title`, `detail`) VALUES ('Làm bài tập', 'Hoàn thiện bài viết Spring Boot #13');

-- Create table for storing luckynumber prize daily
CREATE TABLE lucky_number(
                             `id` INT(11) NOT NULL AUTO_INCREMENT,
                             `date` VARCHAR(255),
                             `special_prize` VARCHAR(255),
                             `first_prize` VARCHAR(255),
                             `second_prize` VARCHAR(255),
                             `third_prize` VARCHAR(255),
                             `fourth_prize` VARCHAR(255),
                             `fifth_prize` VARCHAR(255),
                             `sixth_prize` VARCHAR(255),
                             `seventh_prize` VARCHAR(255),
                             PRIMARY KEY(`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4;
