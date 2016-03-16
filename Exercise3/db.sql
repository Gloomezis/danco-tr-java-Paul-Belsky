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
  `star_category` SMALLINT NOT NULL ,
  `busy` TINYINT(1) NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_admin`.`service`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`service` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(25) NOT NULL ,
  `price` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_admin`.`guest_to_service`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`guest_to_service` (
  `guest_to_service_id` INT NOT NULL AUTO_INCREMENT ,
  `guest_id` INT NOT NULL ,
  `service_id` INT NOT NULL ,
  INDEX `fk_guest_to_service_guest1_idx` (`guest_id` ASC) ,
  INDEX `fk_guest_to_service_service1_idx` (`service_id` ASC) ,
  PRIMARY KEY (`guest_to_service_id`) ,
  UNIQUE INDEX `guest_to_service_id_UNIQUE` (`guest_to_service_id` ASC) ,
  CONSTRAINT `fk_guest_to_service_guest1`
    FOREIGN KEY (`guest_id` )
    REFERENCES `hotel_admin`.`guest` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_guest_to_service_service1`
    FOREIGN KEY (`service_id` )
    REFERENCES `hotel_admin`.`service` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_admin`.`guest_to_hotel_room`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`guest_to_hotel_room` (
  `guest_to_hotel_id` INT NOT NULL AUTO_INCREMENT ,
  `guest_id` INT NOT NULL ,
  `hotel_room_id` INT NOT NULL ,
  `date_arrive`  Date NOT NULL ,
  `date_departure`  Date NOT NULL ,
  INDEX `fk_guest_to_hotel_room_guest1_idx` (`guest_id` ASC) ,
  INDEX `fk_guest_to_hotel_room_hotel_room1_idx` (`hotel_room_id` ASC) ,
  PRIMARY KEY (`guest_to_hotel_id`) ,
  UNIQUE INDEX `guest_to_hotel_id_UNIQUE` (`guest_to_hotel_id` ASC) ,
  CONSTRAINT `fk_guest_to_hotel_room_guest1`
    FOREIGN KEY (`guest_id` )
    REFERENCES `hotel_admin`.`guest` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_guest_to_hotel_room_hotel_room1`
    FOREIGN KEY (`hotel_room_id` )
    REFERENCES `hotel_admin`.`hotel_room` (`id` )
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


INSERT INTO service (name,price) VALUES ('Diner',10);
INSERT INTO service (name,price) VALUES ('Cleaning',5);
INSERT INTO service (name,price) VALUES ('Parking',8);
INSERT INTO service (name,price) VALUES ('Bar',5);


INSERT INTO guest_to_hotel_room (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (1,5,'2015-12-15','2015-12-18');
INSERT INTO guest_to_hotel_room (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (3,2,'2015-12-16','2015-12-25');
INSERT INTO guest_to_hotel_room (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (4,3,'2015-12-15','2015-12-24');
INSERT INTO guest_to_hotel_room (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (5,3,'2015-12-15','2015-12-24');
INSERT INTO guest_to_hotel_room (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (6,3,'2015-12-15','2015-12-24');
INSERT INTO guest_to_hotel_room (guest_id,hotel_room_id,date_arrive,date_departure) VALUES (7,4,'2015-01-17','2015-12-19');


INSERT INTO guest_to_service (guest_id,service_id) VALUES (1,3);
INSERT INTO guest_to_service (guest_id,service_id) VALUES (2,3);
INSERT INTO guest_to_service (guest_id,service_id) VALUES (3,3);
INSERT INTO guest_to_service (guest_id,service_id) VALUES (4,1);
INSERT INTO guest_to_service (guest_id,service_id) VALUES (5,2);





