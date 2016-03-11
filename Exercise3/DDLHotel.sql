SSET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
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
  `date_of_using_service`  DATE NOT NULL ,
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
  `hotel_room_id1` INT NOT NULL ,
  `date_arrive`  DATE NOT NULL ,
  `date_departure` DATE NOT NULL ,
  INDEX `fk_guest_to_hotel_room_guest1_idx` (`guest_id` ASC) ,
  INDEX `fk_guest_to_hotel_room_hotel_room1_idx` (`hotel_room_id1` ASC) ,
  PRIMARY KEY (`guest_to_hotel_id`) ,
  UNIQUE INDEX `guest_to_hotel_id_UNIQUE` (`guest_to_hotel_id` ASC) ,
  CONSTRAINT `fk_guest_to_hotel_room_guest1`
    FOREIGN KEY (`guest_id` )
    REFERENCES `hotel_admin`.`guest` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_guest_to_hotel_room_hotel_room1`
    FOREIGN KEY (`hotel_room_id1` )
    REFERENCES `hotel_admin`.`hotel_room` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hotel_admin`.`price_calc`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `hotel_admin`.`price_calc` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `guest_id` INT NOT NULL ,
  `price_calc_summ_service` INT NULL ,
  `price_calc_summ_hotel_room` INT NULL ,
  `totaly_price` INT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_price_calc_guest1_idx` (`guest_id` ASC) ,
  CONSTRAINT `fk_price_calc_guest1`
    FOREIGN KEY (`guest_id` )
    REFERENCES `hotel_admin`.`guest` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
