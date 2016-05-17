SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `hotel_admin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `hotel_admin` ;

-- -----------------------------------------------------
-- Table `hotel_admin`.`guest`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`guest` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_admin`.`hotel_room`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`hotel_room` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `number` VARCHAR(10) NOT NULL ,
  `room_price` INT NOT NULL ,
  `sleeping_number` INT NOT NULL ,
  `star_category` INT NOT NULL ,
  `busy` TINYINT(1) NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_admin`.`orders`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`orders` (
  `id` INT ZEROFILL NOT NULL AUTO_INCREMENT ,
  `guest_id` INT NOT NULL ,
  `hotel_room_id` INT NOT NULL ,
  `date_arrive` DATE NOT NULL ,
  `date_departure` DATE NOT NULL ,
  `paid` TINYINT(1) NOT NULL DEFAULT 0 ,
  INDEX `fk_guest_to_hotel_room_guest1_idx` (`guest_id` ASC) ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_orders_hotel_room1_idx` (`hotel_room_id` ASC) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  CONSTRAINT `fk_guest_to_hotel_room_guest1`
    FOREIGN KEY (`guest_id` )
    REFERENCES `hotel_admin`.`guest` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_hotel_room1`
    FOREIGN KEY (`hotel_room_id` )
    REFERENCES `hotel_admin`.`hotel_room` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_admin`.`service`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`service` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `orders_id` INT ZEROFILL  ,
  `name` VARCHAR(25) NOT NULL ,
  `price` INT NOT NULL ,
  `paid` TINYINT(1) NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_service_orders1_idx` (`orders_id` ASC) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  CONSTRAINT `fk_service_orders1`
    FOREIGN KEY (`orders_id` )
    REFERENCES `hotel_admin`.`orders` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `hotel_admin`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `login`  VARCHAR(45) NOT NULL UNIQUE,
  `password`  VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `iduser_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_admin`.`handling`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`handling` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `user_id` INT NOT NULL ,
  `time` DATE NOT NULL ,
  `resources` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `idhandling_UNIQUE` (`id` ASC) ,
  INDEX `fk_handling_user1_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_handling_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `hotel_admin`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



INSERT INTO guest (name) VALUES ('Paul');
INSERT INTO guest (name) VALUES ('Linda');
INSERT INTO guest (name) VALUES ('Archie');
INSERT INTO guest (name) VALUES ('Serinity');
INSERT INTO guest (name) VALUES ('Nobel');
INSERT INTO guest (name) VALUES ('Andrea');
INSERT INTO guest (name) VALUES ('Stephany');
INSERT INTO guest (name) VALUES ('Don');
INSERT INTO guest (name) VALUES ('Tina');


INSERT INTO hotel_room (number,room_price,sleeping_number,star_category, busy, status) VALUES ('101',80,1,5,false,true);
INSERT INTO hotel_room (number,room_price,sleeping_number,star_category, busy, status) VALUES ('102',50,2,5,false,true);
INSERT INTO hotel_room (number,room_price,sleeping_number,star_category, busy, status) VALUES ('201',75,3,5,true,true);
INSERT INTO hotel_room (number,room_price,sleeping_number,star_category, busy, status) VALUES ('301',200,1,5,true,true);
INSERT INTO hotel_room (number,room_price,sleeping_number,star_category, busy, status) VALUES ('103',65,1,2,false,true);


INSERT INTO orders (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (1,5,'2015-12-15','2015-12-18');
INSERT INTO orders (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (3,2,'2015-12-16','2015-12-25');
INSERT INTO orders (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (4,3,'2015-12-15','2015-12-24');
INSERT INTO orders (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (5,3,'2015-12-15','2015-12-24');
INSERT INTO orders (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (6,3,'2015-12-15','2015-12-24');
INSERT INTO orders (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (7,4,'2015-01-17','2015-12-19');


INSERT INTO service (orders_id,name,price) VALUES (1,'Diner',10);
INSERT INTO service (orders_id,name,price) VALUES (1,'Cleaning',5);
INSERT INTO service (orders_id,name,price) VALUES (2,'Parking',8);
INSERT INTO service (orders_id,name,price) VALUES (3,'Bar',5);
INSERT INTO service (orders_id,name,price) VALUES (1,'Swimming',40);
INSERT INTO service (orders_id,name,price) VALUES (2,'Free walk',90);
INSERT INTO service (orders_id,name,price) VALUES (2,'Diner',10);



  

















